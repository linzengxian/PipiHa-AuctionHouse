package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBUtil;
import model.Auction;
import model.Bid;
import model.Employee;
import model.Item;

public class ItemDao {

	
	public List<Item> getItems() {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch details of all the items has to be implemented
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" List
		 */

		List<Item> items = new ArrayList<Item>();
				
		/*Sample data begins*/
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT * FROM Item I";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Item temp = new Item();
				temp.setItemID(res.getInt(1));
				temp.setDescription(res.getString(2));
				temp.setName(res.getString(3));
				temp.setType(res.getString(4));
				temp.setNumCopies(res.getInt(5));
				items.add(temp);
			}
			
		}catch(Exception e) {
			System.out.println(e);	
		}
		return items;
	}
	
	public List<Item> getBestsellerItems() {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch details of the bestseller items has to be implemented
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" List
		 */

		List<Item> items = new ArrayList<Item>();
		Connection con = null;
		/*Sample data begins*/
		try {
			
			con = DBUtil.getConnection();
			/*
			String query = "CREATE OR REPLACE VIEW Sold (CustomerID, AuctionID, SoldPrice)"
					+ "AS"
					+ "SELECT B1.CustomerID, B1.AuctionID, B1.BidPrice AS SoldPrice"
					+ "FROM Bid B1"
					+ "WHERE B1.BidTime > 'Today' AND B1.BidPrice >="
					+ "ALL (SELECT B2.BidPrice FROM Bid B2 WHERE B1.AuctionID =B2.AuctionID)"
					+ "SELECT I.ItemID, Count(I.ItemID) AS CountItem"
					+ "FROM Sold S, Auction A, Item I"
					+ "WHERE S.AuctionID = A.AuctionID AND A.ItemID = I.ItemID"
					+ "GROUP BY I.ItemID"
					+ "ORDER BY CountItem";
					*/
			String query = "SELECT *,COUNT(I.ItemID) CountItem FROM AuctionHistory A, item I WHERE A.ItemID = I.ItemID GROUP BY I.ItemID ORDER BY CountItem DESC LIMIT 10";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Item temp = new Item();
				temp.setItemID(res.getInt("ItemID"));
				temp.setDescription(res.getString("Description"));
				temp.setName(res.getString("Name"));
				temp.setType(res.getString("Type"));
				temp.setNumCopies(res.getInt("NumCopies"));
				items.add(temp);
			}
			
		}catch(Exception e) {
			System.out.println(e);	
		}
		return items;

	}

	public List<Item> getSummaryListing(String searchKeyword) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch details of summary listing of revenue generated by a particular item or item type must be implemented
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" ArrayList
		 * Store the revenue generated by an item in the soldPrice attribute, using setSoldPrice method of each "item" object
		 */

		List<Item> items = new ArrayList<Item>();
		Connection con = null;
		String target = searchKeyword;
		/*Sample data begins*/
		try {
			con = DBUtil.getConnection();	
			if(target == null) {
				String query = "SELECT I.ItemID I.Description I.Name I.Type I.NumCopies AH.BidingPrice FROM Item I, AuctionHistory AH WHERE AH.ItemID = I.ItemID";
				PreparedStatement ps = con.prepareStatement (query);
				ResultSet res = ps.executeQuery ();
				while( res.next ()) {
				Item temp = new Item();
				temp.setItemID(res.getInt(1));
				temp.setDescription(res.getString(2));
				temp.setName(res.getString(3));
				temp.setType(res.getString(4));
				temp.setNumCopies(res.getInt(5));
				temp.setSoldPrice((int)res.getFloat(5));
				items.add(temp);
				}
				
			}else if(target.equals("")) {
				return items;
			}
			else
			{
			String query = "SELECT I.ItemID I.Description I.Name I.Type I.NumCopies AH.BidingPrice FROM Item I, AuctionHistory AH WHERE AH.ItemID = I.ItemID AND ("
					+  "I.ItemID LIKE '%"+target+"%'"
					+ " OR I.Type LIKE '%"+target+"%'"
					+ " OR I.Name LIKE '%"+target+"%')";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
			Item temp1 = new Item();
			temp1.setItemID(res.getInt(1));
			temp1.setDescription(res.getString(2));
			temp1.setName(res.getString(3));
			temp1.setType(res.getString(4));
			temp1.setNumCopies(res.getInt(5));
			temp1.setSoldPrice((int)res.getFloat(5));
			items.add(temp1);
			//System.out.println("id of the customers: "+temp.getCustomerID());
			}
		}
		}catch(Exception e) {
			System.out.println(e);
			
		}

		return items;

	}

	public List<Item> getItemSuggestions(String customerID) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch item suggestions for a customer, indicated by customerID, must be implemented
		 * customerID, which is the Customer's ID for whom the item suggestions are fetched, is given as method parameter
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" ArrayList
		 */
		List<Item> items = new ArrayList<Item>();
		
		/*Sample data begins*/
		/*Sample data ends*/
		
		String target = customerID;
		 Connection con = null;
	
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT S.ItemID,S.Name,S.Description FROM Item S WHERE S.Type IN "
					+ "( SELECT i.Type FROM Item i WHERE i.ItemID IN( SELECT ItemID FROM AuctionHistory  WHERE BuyerID = ? ))"
					+ " AND (S.ItemID NOT IN( SELECT A.ItemID FROM AuctionHistory A WHERE BuyerID = ?)) ORDER BY Rand() Limit 3";
			PreparedStatement ps = con.prepareStatement (query);
			ps.setString(1, target);
			ps.setString(2, target);
			ResultSet res = ps.executeQuery ();
			if( res.next ()) {
				Item item = new Item();
				
			}else {
				System.out.println("Didn't find the corresponding customer with that username");
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		
		
		
		return items;

	}

	public List getItemsBySeller(String sellerID) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch items sold by a given seller, indicated by sellerID, must be implemented
		 * sellerID, which is the Sellers's ID who's items are fetched, is given as method parameter
		 * The bid and auction details of each of the items should also be fetched
		 * The bid details must have the highest current bid for the item
		 * The auction details must have the details about the auction in which the item is sold
		 * Each item record is required to be encapsulated as a "Item" class object and added to the "items" List
		 * Each bid record is required to be encapsulated as a "Bid" class object and added to the "bids" List
		 * Each auction record is required to be encapsulated as a "Auction" class object and added to the "auctions" List
		 * The items, bids and auctions Lists have to be added to the "output" List and returned
		 */

		List output = new ArrayList();
		List<Item> items = new ArrayList<Item>();
		List<Bid> bids = new ArrayList<Bid>();
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*Sample data begins*/
		Connection con = null;

		/*Sample data begins*/
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Item temp = new Item();
				temp.setItemID(res.getInt(1));
				temp.setDescription(res.getString(2));
				temp.setName(res.getString(3));
				temp.setType(res.getString(4));
				temp.setNumCopies(res.getInt(5));
				items.add(temp);
			}
			
		}catch(Exception e) {
			System.out.println(e);	
		}
		/*Sample data ends*/
		
		output.add(items);
		output.add(bids);
		output.add(auctions);
		
		return output;
	}

	public List<Item> getItemTypes() {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" ArrayList
		 * A query to fetch the unique item types has to be implemented
		 * Each item type is to be added to the "item" object using setType method
		 */
		
		List<Item> items = new ArrayList<Item>();
		
			Connection con = null;
		
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT * FROM Item I";
			PreparedStatement ps = con.prepareStatement (query);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Item temp = new Item();
				temp.setItemID(res.getInt(1));
				temp.setDescription(res.getString(2));
				temp.setName(res.getString(3));
				temp.setType(res.getString(4));
				temp.setNumCopies(res.getInt(5));
				items.add(temp);
			}
			
		}catch(Exception e) {
			System.out.println(e);	
		}
		
		/*Sample data begins*/
//		for (int i = 0; i < 6; i++) {
//			Item item = new Item();
//			item.setType("BOOK");
//			items.add(item);
//		}
		/*Sample data ends*/
		
		return items;
	}

	public List getItemsByName(String itemName) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * The itemName, which is the item's name on which the query has to be implemented, is given as method parameter
		 * Query to fetch items containing itemName in their name has to be implemented
		 * Each item's corresponding auction data also has to be fetched
		 * Each item record is required to be encapsulated as a "Item" class object and added to the "items" List
		 * Each auction record is required to be encapsulated as a "Auction" class object and added to the "auctions" List
		 * The items and auctions Lists are to be added to the "output" List and returned
		 */

		List output = new ArrayList();
		List<Item> items = new ArrayList<Item>();
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*Sample data begins*/
		Connection con = null;
		String target = itemName;
		int item_id=0;
		
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT Item.ItemID,Description,Name,Type,NumCopies,MinimuBid,BidIncrement"
					+ " FROM Item,Auction where Item.Name LIKE'%"+target+"%' and Item.ItemID=Auction.ItemID and Auction.AuctionID NOT IN (SELECT AuctionID from AuctionHistory)";
			PreparedStatement ps = con.prepareStatement (query);
			//ps.setString(1, target);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Item temp = new Item();
				temp.setItemID(res.getInt(1));
				temp.setDescription(res.getString(2));
				temp.setName(res.getString(3));
				temp.setType(res.getString(4));
				temp.setNumCopies(res.getInt(5));
				items.add(temp);
				
				Auction auction = new Auction();
				auction.setMinimumBid(res.getFloat(6));
				auction.setBidIncrement(7);
				auctions.add(auction);
			
			}
		}catch(Exception e) {
			System.out.println(e);	
		}

		output.add(items);
		output.add(auctions);
		
		return output;
	}

	public List getItemsByType(String itemType) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * The itemType, which is the item's type on which the query has to be implemented, is given as method parameter
		 * Query to fetch items containing itemType as their type has to be implemented
		 * Each item's corresponding auction data also has to be fetched
		 * Each item record is required to be encapsulated as a "Item" class object and added to the "items" List
		 * Each auction record is required to be encapsulated as a "Auction" class object and added to the "auctions" List
		 * The items and auctions Lists are to be added to the "output" List and returned
		 */

		List output = new ArrayList();
		List<Item> items = new ArrayList<Item>();
		List<Auction> auctions = new ArrayList<Auction>();
		
		System.out.println(itemType);
		Connection con = null;
		String target = itemType;
		int item_id=0;
		
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT A.ItemID,Description,Name,Type,NumCopies,MinimuBid,BidIncrement,AuctionID"
					+ " FROM Item I,Auction A where I.Type=? AND I.ItemID=A.ItemID AND A.AuctionID NOT IN (SELECT H.AuctionID from AuctionHistory H)";
			PreparedStatement ps = con.prepareStatement (query);
			ps.setString(1, target);
			ResultSet res = ps.executeQuery ();
			while( res.next ()) {
				Item temp = new Item();
				temp.setItemID(res.getInt(1));
				temp.setDescription(res.getString(2));
				temp.setName(res.getString(3));
				temp.setType(res.getString(4));
				temp.setNumCopies(res.getInt(5));
				items.add(temp);
				
				Auction auction = new Auction();
				auction.setAuctionID(res.getInt("AuctionID"));
				auction.setMinimumBid(res.getFloat(6));
				auction.setBidIncrement(7);
				auctions.add(auction);
			
			}
		
			
		}catch(Exception e) {
			System.out.println(e);	
		}
		
				
		/*Sample data begins*/
//		for (int i = 0; i < 4; i++) {
//			Item item = new Item();
//			item.setItemID(123);
//			item.setDescription("sample description");
//			item.setType("BOOK");
//			item.setName("Sample Book");
//			items.add(item);
//			
//			Auction auction = new Auction();
//			auction.setMinimumBid(100);
//			auction.setBidIncrement(10);
//			auctions.add(auction);
//		}
		/*Sample data ends*/
		
		output.add(items);
		output.add(auctions);
		
		return output;
	}

	public List<Item> getBestsellersForCustomer(String customerID) {

		/*
		 * The students code to fetch data from the database will be written here.
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" ArrayList.
		 * Query to get the Best-seller list of items for a particular customer, indicated by the customerID, has to be implemented
		 * The customerID, which is the customer's ID for whom the Best-seller items have to be fetched, is given as method parameter
		 */

		List<Item> items = new ArrayList<Item>();
		String target = customerID;
		
		Connection con = null;
		/*Sample data begins*/
		try {
			con = DBUtil.getConnection();	
			String query = "SELECT I.ItemID,Description,Name,Type,NumCopies,Count(I.ItemID) AS CountItem"
					+ " FROM Item I,AuctionHistory H,Auction A WHERE I.ItemID=H.ItemID AND A.ItemID=I.ItemID AND H.SellerID=?"
					+ " GROUP BY I.ItemID,Description,Name,Type,NumCopies"
					+ " ORDER BY CountItem DESC";
			PreparedStatement ps = con.prepareStatement (query);
			ps.setString(1, target);
			ResultSet res = ps.executeQuery();
			while( res.next ()) {
				Item temp = new Item();
				temp.setItemID(res.getInt(1));
				temp.setDescription(res.getString(2));
				temp.setName(res.getString(3));
				temp.setType(res.getString(4));
				temp.setNumCopies(res.getInt(5));
				items.add(temp);
			}
			
		}catch(Exception e) {
			System.out.println(e);	
		}
		
		return items;

	}
}
