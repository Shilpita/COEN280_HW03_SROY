//package yelp;

import java.sql.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseUser {
	public String line;
	PreparedStatement preparedStatement ;
	Connection con ;
	String insertStmt ;
	
	public ParseUser(String line ,Connection con_){ 
		this.line 		= line;
		this.con        = con_;
		}
	
	public void parseJson(){
		try{
			JSONParser jsonParser   = new JSONParser();
			JSONObject jsonObject   = (JSONObject) jsonParser.parse(line);
			
			insertStmt              = "INSERT INTO YELP_USER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
			preparedStatement       = con.prepareStatement(insertStmt); 
			
			// get a String from the JSON object
			String yelpingSince 	= (String)jsonObject.get("yelping_since");
            long review_count 		= (long)jsonObject.get("review_count");
            String name 			= (String)jsonObject.get("name");
		    String user_id 			= (String)jsonObject.get("user_id");
		    long totalFriend        = (long)((JSONArray) jsonObject.get("friends")).size();
		    String friendList       = "" + jsonObject.get("friends") + "";
			long fans 				= (long)jsonObject.get("fans");
			double average_stars 	= (double)jsonObject.get("average_stars");
			String type 			= (String)jsonObject.get("type");
			String compliments      = "" + jsonObject.get("compliments")+ "" ;
			JSONObject structure 	= (JSONObject) jsonObject.get("votes");
			long funnyVotes       	= (long)structure.get("funny");
			long usefulVotes     	= (long)structure.get("useful");
			long coolVotes        	= (long)structure.get("useful");
			long totalVotes         =  funnyVotes + usefulVotes + coolVotes ;
			
			preparedStatement.setString(1, yelpingSince);
			preparedStatement.setLong(2, review_count);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, user_id);
			preparedStatement.setLong(5, totalFriend);
			preparedStatement.setString(6, friendList);
			preparedStatement.setLong(7, fans);
			preparedStatement.setDouble(8, average_stars);
			preparedStatement.setString(9, type);
			preparedStatement.setString(10, compliments);
			preparedStatement.setLong(11, funnyVotes);
			preparedStatement.setLong(12, usefulVotes);
			preparedStatement.setLong(13, coolVotes);
			preparedStatement.setLong(14, totalVotes);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		/*	
			insertStmt                          = "INSERT INTO VOTES VALUES(?,?,?,?)" ;
			preparedStatement                   = con.prepareStatement(insertStmt); 
			
			JSONObject structure = (JSONObject) jsonObject.get("votes");
			long funnyVotes       = (long)structure.get("funny");
			long usefulVotes      = (long)structure.get("useful");
			long coolVotes        = (long)structure.get("useful");
			
			preparedStatement.setString(1, user_id);
			preparedStatement.setLong(2, funnyVotes);
			preparedStatement.setLong(3, usefulVotes);
			preparedStatement.setLong(4, coolVotes);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			JSONArray eliteArray = (JSONArray) jsonObject.get("elite");
			if (eliteArray.size() > 0){
			     parseElite(user_id , eliteArray , eliteArray.size());
			}
			
			
			JSONArray friendArray= (JSONArray) jsonObject.get("friends");
			if (friendArray.size() > 0){
				parseFriend(user_id , friendArray , friendArray.size());
			}
		*/	
			
		}catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
	}
	
	public void parseFriend(String user_id , JSONArray friendArray , int size) throws SQLException{
			for (int i = 0; i < size; i++){
				    insertStmt                          = "INSERT INTO FRIENDS VALUES(?,?)" ;
				    preparedStatement                   = con.prepareStatement(insertStmt); 
					String friend 				        = (String)friendArray.get(i);
					preparedStatement.setString(1, user_id);
					preparedStatement.setString(2, friend);
					preparedStatement.executeUpdate();
					preparedStatement.close();	
			}
	}
	
	public void parseElite(String user_id , JSONArray eliteArray , int size) throws SQLException{
		 	for (int i = 0; i < size ; i++){
		 			insertStmt                          = "INSERT INTO ELITE VALUES(?,?)" ;
		 			preparedStatement                   = con.prepareStatement(insertStmt); 
		 			long eliteYear 					= (long)eliteArray.get(i);
		 			preparedStatement.setString(1, user_id);
					preparedStatement.setLong(2, eliteYear);
					preparedStatement.executeUpdate();
					preparedStatement.close();
		 }
}

}
