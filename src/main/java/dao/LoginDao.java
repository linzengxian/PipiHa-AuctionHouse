package dao;
import java.sql.*;

import jdbc.DBUtil;
import model.Login;

public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
	
	
	public Login login(String username, String password) {
		/*
		 * Return a Login object with role as "manager", "customerRepresentative" or "customer" if successful login
		 * Else, return null
		 * The role depends on the type of the user, which has to be handled in the database
		 * username, which is the email address of the user, is given as method parameter
		 * password, which is the password of the user, is given as method parameter
		 * Query to verify the username and password and fetch the role of the user, must be implemented
		 */
		 Connection con = null;
		try {
			

			 con = DBUtil.getConnection();
			System.out.print("xxxx");
			Statement stat = con.createStatement ();
			ResultSet res = stat.executeQuery ("select * from AuctionHistory");
			int i=1;
			int j;
			while ( res.next ( ) ) { 
				j = res.getInt (i);
				i++;
				System.out.println(i+": "+j);
			
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Database Connection Terminated");
                } catch (Exception e) {}
            }
        }
		
		/*Sample data begins*/
		Login login = new Login();
		login.setRole("customerRepresentative");
		//login.setRole("manager");
		//login.setRole("fish");
		return login;
		/*Sample data ends*/
		
	}
	
	public String addUser(Login login) {
		/*
		 * Query to insert a new record for user login must be implemented
		 * login, which is the "Login" Class object containing username and password for the new user, is given as method parameter
		 * The username and password from login can get accessed using getter methods in the "Login" model
		 * e.g. getUsername() method will return the username encapsulated in login object
		 * Return "success" on successful insertion of a new user
		 * Return "failure" for an unsuccessful database operation
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/
	}

}
