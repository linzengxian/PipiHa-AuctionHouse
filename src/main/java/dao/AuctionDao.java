package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBUtil;
import model.Auction;
import model.Bid;
import model.Customer;
import model.Item;

public class AuctionDao {
	
	public List<Auction> getAllAuctions() {
		
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the auctions should be implemented
		 */
		
		/*Sample data begins*/
		try {
		Connection con = DBUtil.getConnection();
	    String query = "SELECT * FROM Auction a, Bid b WHERE a.AuctionID = b.AuctionID ORDER BY b.BidTime DESC LIMIT 1 " ;
	    // create the java statement
	    Statement st = con.createStatement();
	      // execute the query, and get a java resultset
	    ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			Auction auction = new Auction();
			auction.setAuctionID(rs.getInt("AuctionID"));
			auction.setBidIncrement((float)rs.getDouble("BidIncrement"));
			auction.setMinimumBid((float)rs.getDouble("MinimuBid"));
			auction.setCopiesSold(rs.getInt("Copies_Sold"));
			auction.setItemID(rs.getInt("ItemID"));
			auction.setClosingBid((int)rs.getDouble("CurrentBid"));
			auction.setCurrentBid((int)rs.getDouble("CurrentBid"));
			auction.setCurrentHighBid((int)rs.getDouble("CurrentHighBid"));
			auction.setReserve((int)rs.getDouble("Reserve"));
			auctions.add(auction);
		}
		}catch(Exception e) {
			return null;
		}
		/*Sample data ends*/
		
		return auctions;

	}

	public List<Auction> getAuctions(String customerID) {
		
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the auctions in which a customer participated should be implemented
		 * customerID is the customer's primary key, given as method parameter
		 */
		
		/*Sample data begins*/
		try {
			Connection con = DBUtil.getConnection();
		    String query = "SELECT * FROM Auction a, Bid b WHERE a.AuctionID = b.AuctionID AND b.CustomerID = " + customerID + " ORDER BY b.BidTime DESC LIMIT 1"  ;
		    // create the java statement
		    Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Auction auction = new Auction();
				auction.setAuctionID(rs.getInt("AuctionID"));
				auction.setBidIncrement((float)rs.getDouble("BidIncrement"));
				auction.setMinimumBid((float)rs.getDouble("MinimuBid"));
				auction.setCopiesSold(rs.getInt("Copies_Sold"));
				auction.setItemID(rs.getInt("ItemID"));
				auction.setClosingBid((int)rs.getDouble("CurrentBid"));
				auction.setCurrentBid((int)rs.getDouble("CurrentBid"));
				auction.setCurrentHighBid((int)rs.getDouble("CurrentHighBid"));
				auction.setReserve((int)rs.getDouble("Reserve"));
				auctions.add(auction);
			}
			}catch(Exception e) {
				return null;
			}
		/*Sample data ends*/
		
		return auctions;

	}

	public List<Auction> getOpenAuctions(String employeeEmail) {
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the open auctions monitored by a customer representative should be implemented
		 * employeeEmail is the email ID of the customer representative, which is given as method parameter
		 */
		/*Sample data begins*/
		try {
			Connection con = DBUtil.getConnection();
		    String query = "SELECT * FROM Auction a, Bid b WHERE a.AuctionID = b.AuctionID "
		    		+ "AND a.AuctionID NOT IN "
		    		+ "(SELECT AuctionID FROM AuctionHistory)"
		    		+ "GROUP BY a.AuctionID HAVING MAX(b.BidTime)" ;
		    // create the java statement
		    Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Auction auction = new Auction();
				auction.setAuctionID(rs.getInt("AuctionID"));
				auction.setBidIncrement((float)rs.getDouble("BidIncrement"));
				auction.setMinimumBid((float)rs.getDouble("MinimuBid"));
				auction.setCopiesSold(rs.getInt("Copies_Sold"));
				auction.setItemID(rs.getInt("ItemID"));
				auction.setClosingBid((int)rs.getDouble("CurrentBid"));
				auction.setCurrentBid((int)rs.getDouble("CurrentBid"));
				auction.setCurrentHighBid((int)rs.getDouble("CurrentHighBid"));
				auction.setReserve((int)rs.getDouble("Reserve"));
				auctions.add(auction);
			}
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		/*Sample data ends*/
		
		return auctions;

		
		
	}

	public String recordSale(String auctionID) {
		/*
		 * The students code to update data in the database will be written here
		 * Query to record a sale, indicated by the auction ID, should be implemented
		 * auctionID is the Auction's ID, given as method parameter
		 * The method should return a "success" string if the update is successful, else return "failure"
		 */
		try {
			Connection con = DBUtil.getConnection();
		    String query = "SELECT * FROM Auction a, Bid b, Post p WHERE a.AuctionID = b.AuctionID AND p.AuctionID = a.AuctionID "
		    		+ " AND a.AuctionID = " + auctionID 
		    		+ " ORDER BY b.BidTime DESC LIMIT 1" ;
		    // create the java statement
		 // create the java statement
		    Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
		    PreparedStatement preparedStmt;
			if(rs.next()) {
				System.out.println(rs.getDate("BidTime"));
				query = "INSERT INTO AuctionHistory(AuctionID, ItemID, SellerID, BuyerID,EmployeeID,Date,BidingPrice)"
						+ " values (?,?,?,?,?,?,?)";
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1,rs.getInt("AuctionID"));
				preparedStmt.setInt(2,rs.getInt("ItemID"));
				preparedStmt.setInt(3,rs.getInt("p.CustomerID"));
				preparedStmt.setInt(4,rs.getInt("b.CustomerID"));
				preparedStmt.setInt(5,rs.getInt("Monitor"));
				preparedStmt.setTimestamp(6, rs.getTimestamp("BidTime"));
				preparedStmt.setDouble(7,rs.getDouble("BidPrice"));
				if(!preparedStmt.execute()) {
					return "failure";
				}
				
			}
			}catch(Exception e) {
				System.out.println(e.getMessage());;
				return "failure";
			}
		/* Sample data begins */
		return "success";
		/* Sample data ends */
	}

	public List getAuctionData(String auctionID, String itemID) {
		
		List output = new ArrayList();
		Item item = new Item();
		Bid bid = new Bid();
		Auction auction = new Auction();
		Customer customer = new Customer();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * The item details are required to be encapsulated as a "Item" class object
		 * The bid details are required to be encapsulated as a "Bid" class object
		 * The auction details are required to be encapsulated as a "Auction" class object
		 * The customer details are required to be encapsulated as a "Customer" class object
		 * Query to get data about auction indicated by auctionID and itemID should be implemented
		 * auctionID is the Auction's ID, given as method parameter
		 * itemID is the Item's ID, given as method parameter
		 * The customer details must include details about the current winner of the auction
		 * The bid det;ails must include details about the current highest bid
		 * The item details must include details about the item, indicated by itemID
		 * The auction details must include details about the item, indicated by auctionID
		 * All the objects must be added in the "output" list and returned
		 */
		System.out.println(auctionID + "  " + itemID);
		try {
			Connection con = DBUtil.getConnection();
		    String query = "SELECT * FROM Item WHERE ItemID = " + itemID;
		    Statement st = con.createStatement();
		      // execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(query);
		    System.out.println("xxxxxxxxx");
		    if(rs.next()) {
		    	System.out.println("xxxxxxxxx");
		    	item.setItemID(rs.getInt("ItemID"));
		    	item.setDescription(rs.getString("Description"));
				item.setType(rs.getString("Type"));
				item.setName(rs.getString("Name"));
		    }
		    System.out.println("xxxxxxxxx");
		    query = "SELECT * FROM Auction WHERE AuctionID = " + auctionID;
		    st = con.createStatement();
		      // execute the query, and get a java resultset
		    rs = st.executeQuery(query);
		    int customerID;
		    System.out.println("xxxxxxxxx");
		    if(rs.next()) {
		    	auction.setMinimumBid((float)rs.getDouble("MinimuBid"));
		    	auction.setBidIncrement((float)rs.getDouble("BidIncrement"));
		    	auction.setAuctionID(Integer.parseInt(auctionID));
		    	query = "SELECT * FROM Auction a, Bid b WHERE a.AuctionID = b.AuctionID "
			    		+ "AND a.AuctionID = " + auctionID
			    		+ " ORDER BY b.BidTime DESC LIMIT 1" ;
		    	System.out.println("xxxxxxxxx");
			    st = con.createStatement();
			      // execute the query, and get a java resultset
			    rs = st.executeQuery(query);
			    if(rs.next()) {
		    	bid.setCustomerID(String.valueOf(rs.getInt("CustomerID")));
		    	bid.setBidPrice((float)rs.getDouble("BidPrice"));
		    	auction.setCurrentBid((int)rs.getDouble("BidPrice"));
				auction.setCurrentHighBid((int)rs.getDouble("CurrentHighBid"));
				customerID = rs.getInt("CustomerID");
			    
				query = "SELECT * FROM Person WHERE SSN = " + customerID;
			    st = con.createStatement();
			      // execute the query, and get a java resultset
			    rs = st.executeQuery(query);
			    if(rs.next()) {
			    	customer.setCustomerID(String.valueOf(rs.getInt("SSN")));
			    	customer.setFirstName(rs.getString("FirstName"));
			    	customer.setLastName(rs.getString("FirstName"));
		    }
			    }
		    }
		    }catch(Exception e) {
				System.out.println(e.getMessage());;
				
			}
	
		
		output.add(item);
		output.add(bid);
		output.add(auction);
		output.add(customer);
		
		return output;

	}

	
}
