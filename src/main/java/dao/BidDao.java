package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBUtil;
import model.Bid;
import model.Customer;

public class BidDao {

	public List<Bid> getBidHistory(String auctionID) {
		
		List<Bid> bids = new ArrayList<Bid>();

		/*
		 * The students code to fetch data from the database
		 * Each record is required to be encapsulated as a "Bid" class object and added to the "bids" ArrayList
		 * auctionID, which is the Auction's ID, is given as method parameter
		 * Query to get the bid history of an auction, indicated by auctionID, must be implemented
		 */

		String target = auctionID;
		 Connection con = null;
		try {
			con = DBUtil.getConnection();	
			if(target == null) {
				String query = "SELECT * FROM Bid B,Person P WHERE C.CustomerID=P.SSN";
				PreparedStatement ps = con.prepareStatement (query);
				ResultSet res = ps.executeQuery ();
				while( res.next ()) {
				Bid temp = new Bid();
				temp.setAuctionID(res.getInt(1));
				temp.setBidPrice(res.getInt(2));
				temp.setBidTime(res.getString(3));
				temp.setCustomerID(res.getString(4));
				temp.setMaxBid(res.getInt(5));
				bids.add(temp);
				}
				
			}else if(target.equals("")) {
				return bids;
			}
			else
			{
			String query = "SELECT * FROM Bid B WHERE B.AuctionID LIKE '%"+target+"%')";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Bid temp = new Bid();
				temp.setAuctionID(res.getInt(1));
				temp.setBidPrice(res.getInt(2));
				temp.setBidTime(res.getString(3));
				temp.setCustomerID(res.getString(4));
				temp.setMaxBid(res.getInt(5));
				bids.add(temp);
			//System.out.println("id of the customers: "+temp.getCustomerID());
			}
		}
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		return bids;
	}

	public List<Bid> getAuctionHistory(String customerID) {
		
		List<Bid> bids = new ArrayList<Bid>();

		/*
		 * The students code to fetch data from the database
		 * Each record is required to be encapsulated as a "Bid" class object and added to the "bids" ArrayList
		 * customerID, which is the Customer's ID, is given as method parameter
		 * Query to get the bid history of all the auctions in which a customer participated, indicated by customerID, must be implemented
		 */

		String target = customerID;
		 Connection con = null;
		try {
			con = DBUtil.getConnection();	
			if(target == null) {
				return bids;
				}else if(target.equals("")) {
				return bids;
			}
			else
			{
			String query = "SELECT * FROM Bid B WHERE B.CustomerID LIKE '%"+target+"%'";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Bid temp = new Bid();
				temp.setAuctionID(res.getInt(1));
				temp.setBidPrice(res.getInt(2));
				temp.setBidTime(res.getString(3));
				temp.setCustomerID(res.getString(4));
				temp.setMaxBid(res.getInt(5));
				bids.add(temp);
			//System.out.println("id of the customers: "+temp.getCustomerID());
			}
		}
		}catch(Exception e) {
			System.out.println(e);
			
		}
		/*Sample data ends*/
		
		return bids;
	}

	public String submitBid(String auctionID, String itemID, Float currentBid, Float maxBid, String customerID) {
		

		/*
		 * The students code to insert data in the database
		 * auctionID, which is the Auction's ID for which the bid is submitted, is given as method parameter
		 * itemID, which is the Item's ID for which the bid is submitted, is given as method parameter
		 * currentBid, which is the Customer's current bid, is given as method parameter
		 * maxBid, which is the Customer's maximum bid for the item, is given as method parameter
		 * customerID, which is the Customer's ID, is given as method parameter
		 * Query to submit a bid by a customer, indicated by customerID, must be implemented
		 * After inserting the bid data, return the bid details encapsulated in "bid" object
		 */

		Connection con = DBUtil.getConnection();
		String query = "INSERT INTO Bid(AuctionID, BidPrice, ItemID, Address,City,CustomerID)"
				+ " values (?,?,?,?,?)";
		 PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, auctionID);
		      preparedStmt.setString (2, itemID);
		      preparedStmt.setFloat (3, currentBid);
		      preparedStmt.setFloat (4,maxBid);
		      preparedStmt.setString (5,customerID);
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

	public List<Bid> getSalesListing(String searchKeyword) {
		
		List<Bid> bids = new ArrayList<Bid>();

		/*
		 * The students code to fetch data from the database
		 * Each record is required to be encapsulated as a "Bid" class object and added to the "bids" ArrayList
		 * searchKeyword, which is the search parameter, is given as method parameter
		 * Query to  produce a list of sales by item name or by customer name must be implemented
		 * The item name or the customer name can be searched with the provided searchKeyword
		 */

		String target = searchKeyword;
		 Connection con = null;
		try {
			con = DBUtil.getConnection();	
			if(target == null) {
				return bids;
				}else if(target.equals("")) {
				return bids;
			}
			else
			{
			String query = "SELECT * FROM AuctionHistory A Item I WHERE I.Name LIKE '%"+target+"%' AND("
							+ "I.ItemID = A.ItemID ";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Bid temp = new Bid();
				temp.setAuctionID(res.getInt(1));
				temp.setBidPrice(res.getInt(2));
				temp.setBidTime(res.getString(3));
				temp.setCustomerID(res.getString(4));
				temp.setMaxBid(res.getInt(5));
				bids.add(temp);
			//System.out.println("id of the customers: "+temp.getCustomerID());
			}
		}
		}catch(Exception e) {
			System.out.println(e);
			
		}
		/*Sample data ends*/
		
		return bids;
	}

}
