package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Login;
import model.Customer;

import java.util.stream.IntStream;

import jdbc.DBUtil;

public class CustomerDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	/**
	 * @param String searchKeyword
	 * @return ArrayList<Customer> object
	 */
	public List<Customer> getCustomers(String searchKeyword) {
		/*
		 * This method fetches one or more customers based on the searchKeyword and returns it as an ArrayList
		 */
		
		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database based on searchKeyword will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */
		/*Sample data begins*/
		/*Sample data ends*/
		String target = searchKeyword;
		 Connection con = null;
		try {
			con = DBUtil.getConnection();	
			if(target == null) {
				String query = "SELECT * FROM Customer C,Person P WHERE C.CustomerID=P.SSN";
				PreparedStatement ps = con.prepareStatement (query);
				ResultSet res = ps.executeQuery ();
				while( res.next ()) {
				Customer temp = new Customer();
				temp.setRating(res.getInt(1));
				temp.setCreditCard(res.getString(2));
				temp.setCustomerID(res.getString(3));
				temp.setLastName(res.getString(5));
				temp.setFirstName(res.getString(6));
				temp.setAddress(res.getString(7));
				temp.setCity(res.getString(8));
				temp.setState(res.getString(9));
				temp.setZipCode(res.getInt(10));
				temp.setTelephone(res.getString(11));
				temp.setEmail(res.getString(12));
				customers.add(temp);
				}
				
			}else if(target.equals("")) {
				return customers;
			}
			else
			{
			String query = "SELECT * FROM Customer C,Person P WHERE C.CustomerID=P.SSN AND ("
					+ "P.SSN LIKE '%"+target+"%'"
					+ " OR P.LastName LIKE '%"+target+"%'"
					+ " OR P.FirstName LIKE '%"+target+"%'"
					+ " OR P.Address LIKE '%"+target+"%'"
					+ " OR P.City LIKE '%"+target+"%'"
					+ " OR P.State LIKE '%"+target+"%'"
					+ " OR P.ZipCode LIKE '%"+target+"%'"
					+ " OR P.Telephone LIKE '%"+target+"%'"
					+ " OR P.Email LIKE '%"+target+"%'"
					+ " OR C.CreditCardNum LIKE '%"+target+"%'"
					+ " OR C.Rating LIKE '%"+target+"%')";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
			Customer temp = new Customer();
			temp.setRating(res.getInt(1));
			temp.setCreditCard(res.getString(2));
			temp.setCustomerID(res.getString(3));
			temp.setLastName(res.getString(5));
			temp.setFirstName(res.getString(6));
			temp.setAddress(res.getString(7));
			temp.setCity(res.getString(8));
			temp.setState(res.getString(9));
			temp.setZipCode(res.getInt(10));
			temp.setTelephone(res.getString(11));
			temp.setEmail(res.getString(12));
			customers.add(temp);
			//System.out.println("id of the customers: "+temp.getCustomerID());
			}
		}
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		return customers;
	}


	public Customer getHighestRevenueCustomer() {
		/*
		 * This method fetches the customer who generated the highest total revenue and returns it
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */

		/*Sample data begins*/
		Customer customer = new Customer();
		customer.setCustomerID("111-11-1111");
		customer.setLastName("Lu");
		customer.setFirstName("Shiyong");
		customer.setEmail("shiyong@cs.sunysb.edu");
		/*Sample data ends*/
	
		return customer;
		
	}

	public List<Customer> getCustomerMailingList() {

		/*
		 * This method fetches the all customer mailing details and returns it
		 * The students code to fetch data from the database will be written here
		 * Each customer record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		List<Customer> customers = new ArrayList<Customer>();
	
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT * FROM Person P WHERE P.SSN IN ( SELECT CustomerID From Customer)";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Customer temp = new Customer();
				temp.setCustomerID(res.getString(1));
				temp.setLastName(res.getString(2));
				temp.setFirstName(res.getString(3));
				temp.setAddress(res.getString(4));
				temp.setCity(res.getString(5));
				temp.setState(res.getString(6));
				temp.setZipCode(res.getInt(7));
				temp.setTelephone(res.getString(8));
				temp.setEmail(res.getString(9));
				customers.add(temp);
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		/*Sample data begins*/
		/*Sample data ends*/
		
		return customers;
	}

	public Customer getCustomer(String customerID) {
		/*
		 * This method fetches the customer details and returns it
		 * customerID, which is the Customer's ID who's details have to be fetched, is given as method parameter
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */
		System.out.println("IDxxx"+ customerID);
		/*Sample data begins*/
		/*Sample data ends*/
		String target = customerID;
		Connection con = null;
		Customer temp = new Customer();
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT * FROM Person P, Customer C WHERE P.SSN = C.CustomerID AND C.CustomerID=?";
			PreparedStatement ps = con.prepareStatement (query);
			ps.setString(1, target);
			ResultSet res = ps.executeQuery ();
			if( res.next ()) {
				temp.setRating(res.getInt(10));
				temp.setCreditCard(res.getString(11));
				temp.setCustomerID(res.getString(1));
				temp.setLastName(res.getString(2));
				temp.setFirstName(res.getString(3));
				temp.setAddress(res.getString(4));
				temp.setCity(res.getString(5));
				temp.setState(res.getString(6));
				temp.setZipCode(res.getInt(7));
				temp.setTelephone(res.getString(8));
				temp.setEmail(res.getString(9));
				return temp;
			}else {
				System.out.println("unknown Customer");
			}
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		return temp;
	}
	
	public String deleteCustomer(String customerID) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * customerID, which is the Customer's ID who's details have to be deleted, is given as method parameter
		 */

		/*Sample data begins*/
		String CustomerID = customerID;
		String email;
		Connection con = null;
	
		try {
			con = DBUtil.getConnection();	
			String query = "Select P.Email FROM Person P WHERE P.SSN="+CustomerID;
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(query);
			if(res.next()) {
			email= res.getString(1);
			}
			else return "failure";// no such customer exist
			System.out.println("email"+email);
			query = "DELETE FROM Account WHERE Email=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.execute();
		
			
			query = "DELETE FROM Customer WHERE CustomerID=?";
			ps = con.prepareStatement(query);
			ps.setString(1,CustomerID);
			ps.execute();
			
			query = "DELETE FROM Person WHERE SSN=?";
			ps = con.prepareStatement(query);
			ps.setString(1,CustomerID);
			ps.execute();
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return "success";
		/*Sample data ends*/
		
	}


	public String getCustomerID(String username) {
		/*
		 * This method returns the Customer's ID based on the provided email address
		 * The students code to fetch data from the database will be written here
		 * username, which is the email address of the customer, who's ID has to be returned, is given as method parameter
		 * The Customer's ID is required to be returned as a String
		 */
		 String target = username;
		 Connection con = null;
	
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT C.CustomerID FROM Customer C,Person P WHERE C.CustomerID=P.SSN AND P.Email=?";
			PreparedStatement ps = con.prepareStatement (query);
			ps.setString(1, target);
			ResultSet res = ps.executeQuery ();
			if( res.next ()) {
				return res.getString(1);//Customer's ID
			}else {
				System.out.println("Didn't find the corresponding customer with that username");
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		return "-1";
	}


	public List<Customer> getSellers() {
		
		/*
		 * This method fetches the all seller details and returns it
		 * The students code to fetch data from the database will be written here
		 * The seller (which is a customer) record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		List<Customer> customers = new ArrayList<Customer>();
		
		Connection con = null;
	
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT SSN,Address,LastName,FirstName,City,State,Email,ZipCode"
					+ " FROM AuctionHistory,Person WHERE SSN = SellerID";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			if( res.next ()) {
				Customer customer = new Customer();
				customer.setCustomerID(res.getString(1));
				customer.setAddress(res.getString(2));
				customer.setLastName(res.getString(3));
				customer.setFirstName(res.getString(4));
				customer.setCity(res.getString(5));
				customer.setState(res.getString(6));
				customer.setEmail(res.getString(7));
				customer.setZipCode(res.getInt(8));
				customers.add(customer);		

			}else {
				System.out.println("unknown Seller");
			}
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
	
		/*Sample data begins*/
//		for (int i = 0; i < 10; i++) {
//			Customer customer = new Customer();
//			customer.setCustomerID("111-11-1111");
//			customer.setAddress("123 Success Street");
//			customer.setLastName("Lu");
//			customer.setFirstName("Shiyong");
//			customer.setCity("Stony Brook");
//			customer.setState("NY");
//			customer.setEmail("shiyong@cs.sunysb.edu");
//			customer.setZipCode(11790);
//			customers.add(customer);			
//		}
		/*Sample data ends*/
		
		return customers;

	}


	public String addCustomer(Customer customer) {

		/*
		 * All the values of the add customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the customer details and return "success" or "failure" based on result of the database insertion.
		 */
		Connection con = DBUtil.getConnection();
		String query = "INSERT INTO Person(SSN, LastName, FirstName, Address,City,State,ZipCode,Telephone,Email)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		 PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, customer.getCustomerID());
		      preparedStmt.setString (2, customer.getLastName());
		      preparedStmt.setString (3, customer.getFirstName());
		      preparedStmt.setString (4,customer.getAddress() );
		      preparedStmt.setString (5,customer.getCity() );
		      preparedStmt.setString (6,customer.getState() );
		      preparedStmt.setInt (7,customer.getZipCode() );
		      preparedStmt.setString (8,customer.getTelephone() );
		      preparedStmt.setString (9,customer.getEmail() );
		      preparedStmt.execute();
		      query = "INSERT INTO Customer(Rating,CreditCardNum,CustomerID)"
						+ " values (?,?,?)";
		      preparedStmt = con.prepareStatement(query);
		      if(customer.getRating()>0) 
		      preparedStmt.setInt (1, customer.getRating());
		      else preparedStmt.setInt (1,0);
		    	  
		      preparedStmt.setString (2, customer.getCreditCard());
		      preparedStmt.setString (3, customer.getCustomerID());
		      preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("invalid account information");
			return "failure";
		}
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	public String editCustomer(Customer customer) {
		/*
		 * All the values of the edit customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		Customer temp =customer;
		if(deleteCustomer(customer.getCustomerID()).equals("failure"))
			return  "failure";
		if(addCustomer(temp).equals("failure"))
			return  "failure";
		
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

}
