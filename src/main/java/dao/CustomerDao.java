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
		System.out.println("key word"+searchKeyword);
		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setCustomerID("111-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Shiyong");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setZipCode(11790);
			customer.setTelephone("5166328959");
			customer.setCreditCard("1234567812345678");
			customer.setRating(1);
			customers.add(customer);			
		}
		/*Sample data ends*/
		
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
		
		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setCustomerID("111-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Shiyong");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setZipCode(11790);
			customers.add(customer);			
		}
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
		System.out.println("ID"+ customerID);
		/*Sample data begins*/
		Customer customer = new Customer();
//		customer.setCustomerID("111-11-1111");
//		customer.setAddress("123 Success Street");
//		customer.setLastName("Lu");
//		customer.setFirstName("Shiyong");
//		customer.setCity("Stony Brook");
//		customer.setState("NY");
//		customer.setEmail("shiyong@cs.sunysb.edu");
//		customer.setZipCode(11790);
//		customer.setTelephone("5166328959");
//		customer.setCreditCard("1234567812345678");
//		customer.setRating(1);
		/*Sample data ends*/
		 String target = customerID;
		 Connection con = null;
		 String role;
		
		try {
			con = DBUtil.getConnection();	
			String query = "Deleted P.SSN FROM Person P WHERE P.SSN=?";
			PreparedStatement ps = con.prepareStatement (query);
			ps.setString(1, target);
			ResultSet res = ps.executeQuery ();
			if( res.next ()) {
				role = res.getString(1);
				System.out.println(role);
				
			}else {
				System.out.println("unknown");
			}
	
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return customer;
	}
	
	public String deleteCustomer(String customerID) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * customerID, which is the Customer's ID who's details have to be deleted, is given as method parameter
		 */

		/*Sample data begins*/
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
			System.out.println("name"+username);
		return "111-11-1111";
	}


	public List<Customer> getSellers() {
		
		/*
		 * This method fetches the all seller details and returns it
		 * The students code to fetch data from the database will be written here
		 * The seller (which is a customer) record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		List<Customer> customers = new ArrayList<Customer>();
		
		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setCustomerID("111-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Shiyong");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setZipCode(11790);
			customers.add(customer);			
		}
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
		//	e.printStackTrace();
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
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

}
