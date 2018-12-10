package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBUtil;
import model.Employee;
import model.Item;
import model.Post;

public class PostDao {

	
	public List<Item> getSalesReport(Post post) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" List
		 * Query to get sales report for a particular month must be implemented
		 * post, which has details about the month and year for which the sales report is to be generated, is given as method parameter
		 * The month and year are in the format "month-year", e.g. "10-2018" and stored in the expireDate attribute of post object
		 * The month and year can be accessed by getter method, i.e., post.getExpireDate()
		 */

		List<Item> items = new ArrayList<Item>();
		try {
			Connection con = DBUtil.getConnection();
			String[] monthYear = post.getExpireDate().split("-");
		    String query = "SELECT * FROM AuctionHistory WHERE YEAR(Date) = " + monthYear[1] + " AND MONTH(Date) = " + monthYear[0];
		    // create the java statement
		    Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
		    System.out.println("xxxxxxx");
		    while(rs.next()) {
		    	System.out.println("xxxxxxx");
		    	Item item = new Item();
		    	item.setSoldPrice((int)rs.getDouble("BidingPrice"));
		    	query = "SELECT Name FROM Item WHERE ItemID = " + rs.getInt("ItemID");
		    	st = con.createStatement();
			      // execute the query, and get a java resultset
			    rs = st.executeQuery(query);
			    if(rs.next()) {
			    	item.setName(rs.getString("Name"));
			    }
				items.add(item);
		    }
		}catch(Exception e) {
			return null;
		}
		/*Sample data begins*/
	
		/*Sample data ends*/
		

		return items;
		
	}
}
