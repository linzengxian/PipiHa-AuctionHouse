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
		 String target = username;
		 Connection con = null;
		 String role;
		 String pass;
			Login login = new Login();
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT A.Role,A.Password FROM Account A WHERE A.Email=?";
			PreparedStatement ps = con.prepareStatement (query);
			ps.setString(1, target);
			ResultSet res = ps.executeQuery ();
			if( res.next ()) {
				role = res.getString(1);
				System.out.println(role);
				pass =res.getString(2);
				System.out.println("password"+res.getString(2));
				if(res.getString(2).equals(password)) {
					login.setRole(role);
					return login;
				}
				else
				{
					System.out.println("password is not valid");
					login=null;
					return login;
				}
			}else {
				System.out.println("unknown");
				login=null;
				return login;
			}
			
			
			
	
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		return login;
		/*Sample data begins*/
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
		Connection con = DBUtil.getConnection();
		String query = "INSERT INTO Account(Email, Password, Role)"
				+ " values (?,?,?)";
		PreparedStatement preparedStmt;
		//add user
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, login.getUsername());
		    preparedStmt.setString (2, login.getPassword());
		    preparedStmt.setString (3, login.getRole());
		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/
	}

}
