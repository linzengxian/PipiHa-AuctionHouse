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
			System.out.println(monthYear[0] + " " + monthYear[1]);
		    String query = "SELECT * FROM AuctionHistory WHERE YEAR(Date) = " +
		    				monthYear[1] + " AND MONTH(Date) = " + monthYear[0];
		    // create the java statement
		    Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
		    while(rs.next()) {
		    	Item item = new Item();
		    	item.setSoldPrice((int)rs.getDouble("BidingPrice"));
		    	query = "SELECT Name FROM Item WHERE ItemID = " + rs.getInt("ItemID");
		    	Statement ist = con.createStatement();
			      // execute the query, and get a java resultset
		    	ResultSet irs = ist.executeQuery(query);
			    if(irs.next()) {
			    	item.setName(irs.getString("Name"));
			    }
				items.add(item);
		    }
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		/*Sample data begins*/
	
		/*Sample data ends*/
		

		return items;
		
	}
}
