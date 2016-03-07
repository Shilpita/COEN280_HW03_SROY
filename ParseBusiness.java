

import java.util.*;
import java.sql.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseBusiness{

		public String line;
		PreparedStatement preparedStatement ;
		Connection con ;
		String insertStmt;
		HashMap<String,Object> Category;
		String[] days = {
	    			"Monday",
	    			"Tuesday",
	    			"Wednesday",
	    			"Thursday",
	    			"Friday",
	    			"Saturday",
	    			"Sunday"
				  };
		private static final Set<String> mainCategory = new HashSet<String>(Arrays.asList(
			     new String[] {
							"Active Life",
							"Arts & Entertainment",
							"Automotive",
							"Car Rental",
							"Cafes",
							"Beauty & Spas",
							"Convenience Stores",
							"Dentists",
							"Doctors",
							"Drugstores",
							"Department Stores",
							"Education",
							"Event Planning & Services",
							"Flowers & Gifts",
							"Food",
							"Health & Medical",
							"Home Services",
							"Home & Garden",
							"Hospitals",
							"Hotels & Travel",
							"Hardware Stores",
							"Grocery",
							"Medical Centers",
							"Nurseries & Gardening",
							"Nightlife",
							"Restaurants",
							"Shopping",
							"Transportation"
					       }
			));
		
		
		public ParseBusiness(String line ,Connection con_){ 
			this.line 		= line;
			this.con        = con_;	
			}
		
		
		
		public void parseJson(){
			try{
				JSONParser jsonParser   = new JSONParser();
				JSONObject jsonObject   = (JSONObject) jsonParser.parse(line);
				
				insertStmt              = "INSERT INTO BUSINESS VALUES(?,?,?,?,?,?,?,?,?,?,?)" ;
				preparedStatement       = con.prepareStatement(insertStmt); 
				// get a String from the JSON object
				String business_id 	    = (String) jsonObject.get("business_id");
			    String full_address 	= (String) jsonObject.get("full_address");
			    String is_open          = ""+jsonObject.get("open")+"";
			    String city             = (String) jsonObject.get("city");
			    long review_count 		= (long) jsonObject.get("review_count");
	            String business_name 	= (String) jsonObject.get("name");
	            String state            = (String) jsonObject.get("state");
				double stars 			= (double) jsonObject.get("stars");
				double latitude         = (double) jsonObject.get("latitude");
				String attributes		= ""+ jsonObject.get("attributes")+"";
				String type 			= (String) jsonObject.get("type");
				
				
				preparedStatement.setString(1, business_id);
				preparedStatement.setString(2, full_address);
				preparedStatement.setString(3, is_open);
				preparedStatement.setString(4, city);
				preparedStatement.setLong(5, review_count);
				preparedStatement.setString(6, business_name);
				preparedStatement.setString(7, state);
				preparedStatement.setDouble(8, stars);
				preparedStatement.setDouble(9, latitude);
				preparedStatement.setString(10, attributes);
				preparedStatement.setString(11, type);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
				/*
				JSONObject hours      = (JSONObject) jsonObject.get("hours");
				parseOperation(business_id, hours);
				
				JSONArray neighborhoodsArray = (JSONArray) jsonObject.get("neighborhoods");
				if (neighborhoodsArray.size() > 0){
				     parseNeighborhoods(business_id , neighborhoodsArray , neighborhoodsArray.size());
				}
				*/
				
				JSONArray categoryArray = (JSONArray) jsonObject.get("categories");
				if (categoryArray.size() > 0){
				     parseCategory(business_id , categoryArray , categoryArray.size());
				}
			
			}catch (ParseException ex) {
				ex.printStackTrace();
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		//	return insertTableYUser; 
		}
		
		private void parseCategory(String business_id, JSONArray categoryArray, int size) throws SQLException {
			
			Vector<String> category = new Vector<String>();
			Vector<String> subcategory = new Vector<String>();
			for (int i = 0; i < size ; i++){
				if(mainCategory.contains((String) categoryArray.get(i)))
					category.add((String) categoryArray.get(i));
				else
					subcategory.add((String) categoryArray.get(i));	
			}
			
			insertStmt                          = "INSERT INTO SUB_CATEGORY VALUES(?,?,?)" ;
    		preparedStatement                   = con.prepareStatement(insertStmt);
			
			/*
			for(int i = 0 ; i < category.size() ; i++){
				for(int j =0 ; j < subcategory.size() ; j++){
		    		insertStmt                          = "INSERT INTO SUB_CATEGORY VALUES(?,?,?)" ;
		    		preparedStatement                   = con.prepareStatement(insertStmt);
		    		preparedStatement.setString(1, business_id);
		    		preparedStatement.setString(2, category.get(i));
		    		preparedStatement.setString(3, subcategory.get(j));
		    		preparedStatement.executeUpdate();
				    preparedStatement.close();
		    	}
			} */
			
    		for(String c: category){
    			
    			if(subcategory.isEmpty()){
    				String trash = "No_Subcategory";   //null;
    				preparedStatement.setString(1, business_id);
    				preparedStatement.setString(2, c);
    				preparedStatement.setString(3, trash);
    				preparedStatement.executeUpdate();
    				
    			}else{
    				for(String s: subcategory){
    					preparedStatement.setString(1, business_id);
    					preparedStatement.setString(2, c);
    					preparedStatement.setString(3, s);
    					preparedStatement.executeUpdate();
    				}
    			}
    		}	
    		preparedStatement.close();
		}

		public void parseOperation(String business_id, JSONObject hours) throws SQLException{
			for (int i = 0; i < days.length ; i++){
				 JSONObject day      = (JSONObject) hours.get(days[i]);
				 if(day != null){
				    insertStmt                = "INSERT INTO OPERATION VALUES(?,?,?,?)" ;
				    preparedStatement         = con.prepareStatement(insertStmt);  
					String close        = (String) day.get("close");
					String open         = (String) day.get("open");
			
				    preparedStatement.setString(1, business_id);
				    preparedStatement.setString(2, days[i]);
				    preparedStatement.setString(3, close);
				    preparedStatement.setString(4, open);
				    preparedStatement.executeUpdate();
				    preparedStatement.close();
				}
				
			}
		}
		
		public void parseNeighborhoods(String business_id , JSONArray neighborhoodsArray , int size) throws SQLException{
		 	for (int i = 0; i < size ; i++){
		 			insertStmt                          = "INSERT INTO BUSINESS_NEIGHBORHOOD VALUES(?,?)" ;
		 			preparedStatement                   = con.prepareStatement(insertStmt); 
		 			String neighborhoods 				= (String) neighborhoodsArray.get(i);
		 			preparedStatement.setString(1, business_id);
					preparedStatement.setString(2, neighborhoods);
					preparedStatement.executeUpdate();
					preparedStatement.close();
		 }
}
		
			
}
