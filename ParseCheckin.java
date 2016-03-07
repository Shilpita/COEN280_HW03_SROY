

import java.sql.*;
import java.util.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseCheckin {
	public String line;
	PreparedStatement preparedStatement ;
	Connection con ;
	String insertStmt;
	
	//Create a Hash-map to Map the Days supported in the business
	private static HashMap<String,String> dayMapping = new HashMap<String, String>(){
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

				{   put("0","Sunday");
					put("1","Monday");
					put("2","Tuesday");
					put("3","Wednesday");
					put("4","Thursday");
					put("5","Friday");
					put("6","Saturday");
				}
	};
	
	public ParseCheckin(String line ,Connection con_){ 
		this.line 		= line;
		this.con        = con_;	
	}
	
	@SuppressWarnings("unchecked")
	public void parseJson(){
		try{
			JSONParser jsonParser   = new JSONParser();
			JSONObject jsonObject   = (JSONObject) jsonParser.parse(line);
			
			// get a String from the JSON object
			JSONObject structure 	= (JSONObject) jsonObject.get("checkin_info");
			Set<String> set 		= structure.keySet();
			ArrayList<String> list  = new ArrayList<String>(set);
			for(int i = 0 ; i < list.size() ; i++){
						insertStmt              = "INSERT INTO CHECKINS VALUES(?,?,?,?,?,?,?)" ;
						preparedStatement       = con.prepareStatement(insertStmt); 
						String business_id 	  	= (String) jsonObject.get("business_id");
						String type 		  	= (String)jsonObject.get("type");
						String listItem       	= list.get(i);
						String[] tokens  		= listItem.split("-"); 
						long from_hour          = Long.valueOf(tokens[0]);
						long to_hour            = from_hour +1 ;
						long day_index          = Long.valueOf(tokens[1]);
						String day              = dayMapping.get(tokens[1]);
						long checkin_count      = (long)structure.get(listItem);
						
						preparedStatement.setString(1, business_id);
						preparedStatement.setLong(2, day_index);
						preparedStatement.setString(3, day);
						preparedStatement.setLong(4, from_hour);
						preparedStatement.setLong(5, to_hour);
						preparedStatement.setLong(6, checkin_count);
						preparedStatement.setString(7, type);
						preparedStatement.executeUpdate();
						preparedStatement.close();
			}
			//structure.
			
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
