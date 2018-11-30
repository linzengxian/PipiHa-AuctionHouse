package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBUtil;
import model.Customer;
import model.Employee;

public class EmployeeDao {
	/*
	 * This class handles all the database operations related to the employee table
	 */
	
	public String addEmployee(Employee employee) {

		/*
		 * All the values of the add employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the employee details and return "success" or "failure" based on result of the database insertion.
		 */
		Connection con = DBUtil.getConnection();
		String query = "INSERT INTO Person(SSN, LastName, FirstName, Address,City,State,ZipCode,Telephone,Email)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		 PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, employee.getEmployeeID());
		      preparedStmt.setString (2, employee.getLastName());
		      preparedStmt.setString (3, employee.getFirstName());
		      preparedStmt.setString (4,employee.getAddress() );
		      preparedStmt.setString (5,employee.getCity() );
		      preparedStmt.setString (6,employee.getState() );
		      preparedStmt.setInt (7,employee.getZipCode() );
		      preparedStmt.setString (8,employee.getTelephone() );
		      preparedStmt.setString (9,employee.getEmail() );
		      preparedStmt.execute();
		      query = "INSERT INTO Employee(StartDate,HourlyRate,Level,EmployeeID)"
						+ " values (?,?,?,?)";
		      preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString(1, employee.getStartDate());
		      preparedStmt.setFloat(2, employee.getHourlyRate());
		      preparedStmt.setString (3, employee.getLevel());
		      preparedStmt.setString (4, employee.getEmployeeID());
		      preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	public String deleteEmployee(String employeeID) {
		/*
		 * employeeID, which is the Employee's ID which has to be deleted, is given as method parameter
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		String email;
			try {
				Connection con = DBUtil.getConnection();
				String query = "Select P.Email FROM Person P WHERE P.SSN="+employeeID;
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery(query);
				if(res.next()) {
				email= res.getString(1);
				}else {
					return "failure";// no such customer exist
				}
				query = "DELETE FROM Account WHERE Email=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, email);
				ps.execute();
			
				
				query = "DELETE FROM Employee WHERE EmployeeID=?";
				ps = con.prepareStatement(query);
				ps.setString(1,employeeID);
				ps.execute();
				
				query = "DELETE FROM Person WHERE SSN=?";
				ps = con.prepareStatement(query);
				ps.setString(1,employeeID);
				ps.execute();
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failure";
			}
			/*Sample data begins*/
			return "success";
			/*Sample data ends*/

	}

	
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to return details about all the employees must be implemented
		 * Each record is required to be encapsulated as a "Employee" class object and added to the "employees" List
		 */

		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Connection con = DBUtil.getConnection();
		    String query = "SELECT * FROM Person p, Employee e WHERE p.SSN = e.EmployeeID";
		    // create the java statement
		    Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(rs.getString("SSN"));
				employee.setLastName(rs.getString("LastName"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setAddress(rs.getString("Address"));
				employee.setCity(rs.getString("City"));
				employee.setState(rs.getString("State"));
				employee.setZipCode(rs.getInt("ZipCode"));
				employee.setTelephone(rs.getString("Telephone"));
				employee.setEmail(rs.getString("Email"));
				employee.setStartDate(rs.getString("StartDate"));
				employee.setHourlyRate(rs.getFloat("HourlyRate"));
				employee.setLevel(rs.getString("Level"));
				employees.add(employee);	 
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Sample data ends*/
		
		return employees;
	}

	public Employee getEmployee(String employeeID) {

		/*
		 * The students code to fetch data from the database based on "employeeID" will be written here
		 * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */

		Employee employee = new Employee();
		
		/*Sample data begins*/
		try {
			Connection con = DBUtil.getConnection();
		    String query = "SELECT * FROM Person WHERE SSN = " + employeeID;
		    // create the java statement
		    Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				employee.setEmployeeID(rs.getString("SSN"));
				employee.setLastName(rs.getString("LastName"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setAddress(rs.getString("Address"));
				employee.setCity(rs.getString("City"));
				employee.setState(rs.getString("State"));
				employee.setZipCode(rs.getInt("ZipCode"));
				employee.setTelephone(rs.getString("Telephone"));
				employee.setEmail(rs.getString("Email"));

				query = "SELECT * FROM Employee WHERE EmployeeID = " + employeeID;
				st = con.createStatement();
				st.executeQuery(query);
				if(rs.next()) {
					employee.setStartDate(rs.getString("StartDate"));
					employee.setHourlyRate(rs.getFloat("HourlyRate"));
					employee.setLevel(rs.getString("Level"));
				}
				 
			}else {
				return null;
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		/*Sample data ends*/
		
		return employee;
	}
	
	public Employee getHighestRevenueEmployee() {
		
		/*
		 * The students code to fetch employee data who generated the highest revenue will be written here
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		
		Employee employee = new Employee();
		
		/*Sample data begins*/
		employee.setEmail("shiyong@cs.sunysb.edu");
		employee.setFirstName("Shiyong");
		employee.setLastName("Lu");
		employee.setEmployeeID("631-413-5555");
		/*Sample data ends*/
		
		return employee;
	}

	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username" will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID is required to be returned as a String
		 */
		try {
			Connection con = DBUtil.getConnection();
			System.out.println(username);
		    String query = "SELECT SSN FROM Person WHERE Email = " + "'" + username + "'";
		    // create the java statement
		      Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				String SSN = rs.getString("SSN");
				return SSN;
			}
		    
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
