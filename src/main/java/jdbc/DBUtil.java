package jdbc;

import java.sql.*;

public class DBUtil {
	  private static final String URL="jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zenlin";
	  private static final String NAME="zenlin";
	  private static final String PASSWORD="111784497";
	       
	  private static Connection conn=null;
	       static{
	         try {
	               //1.load sql driver
	               Class.forName("com.mysql.jdbc.Driver");
	               //2.connect with sql
	               conn = DriverManager.getConnection(URL, NAME, PASSWORD);
	           } catch (ClassNotFoundException e) {
	               e.printStackTrace();
	           } catch (SQLException e) {
	               e.printStackTrace();
	           }
	       }
	       //get the connection
	       public static Connection getConnection(){
	           return conn;
	       }
}
