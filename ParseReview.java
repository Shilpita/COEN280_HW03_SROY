//package yelp;

import java.sql.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
		
public class ParseReview {
			public String line;
			PreparedStatement preparedStatement ;
			Connection con ;
			String insertStmt;
	//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			public ParseReview(String line ,Connection con_){ 
				this.line 		= line;
				this.con        = con_;	
			}
			
			public void parseJson(){
				try{
					JSONParser jsonParser   = new JSONParser();
					JSONObject jsonObject   = (JSONObject) jsonParser.parse(line);
					
					insertStmt              = "INSERT INTO REVIEWS VALUES(?,?,?,?,?,?,?,?,?,?,?)" ;
					preparedStatement       = con.prepareStatement(insertStmt); 
					// get a String from the JSON object
					JSONObject structure  = (JSONObject) jsonObject.get("votes");
					long funnyVotes       = (long)structure.get("funny");
					long usefulVotes      = (long)structure.get("useful");
					long coolVotes        = (long)structure.get("useful");
					long total_votes      = funnyVotes + usefulVotes + coolVotes;
					String review_id 	  = (String) jsonObject.get("review_id");
					String user_id 	      = (String) jsonObject.get("user_id");
					String business_id 	  = (String) jsonObject.get("business_id");
					long stars        	  = (long) jsonObject.get("stars");
					String publish_date     = (String) jsonObject.get("date");
					String text           = (String) jsonObject.get("text");
					String type 		  = (String)jsonObject.get("type");
					
					preparedStatement.setString(1, review_id);
					preparedStatement.setString(2, user_id);
					preparedStatement.setString(3, business_id);
					preparedStatement.setLong(4, stars);
					preparedStatement.setString(5, text);
					preparedStatement.setString(6, publish_date);           
					preparedStatement.setLong(7, funnyVotes);
					preparedStatement.setLong(8, usefulVotes);
					preparedStatement.setLong(9, coolVotes);
					preparedStatement.setLong(10, total_votes);
					preparedStatement.setString(11, type);
					preparedStatement.executeUpdate();
					preparedStatement.close();
					
				}catch (ParseException ex) {
					ex.printStackTrace();
				} catch (NullPointerException ex) {
					ex.printStackTrace();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}		
			}
}
