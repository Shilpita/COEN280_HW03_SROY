
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;


public class populate {
	public static String filePath = "";
    public static BufferedReader file1 = null;
    public static BufferedReader file2 = null;
    public static BufferedReader file3 = null;
    public static BufferedReader file4 = null;
	public static InsertToDB insertDBCon;
    public static Connection con ;
    //public static File filename = new File();
    
    public static void main(String[] args) { 
		       try {
					
		    	    if(args.length < 4)
                   		System.out.println("\n Insufficient arguments");  

		    	   // for(int i=0 ; i< 4 ; i++){
		    	    	if(!args[0].equalsIgnoreCase("yelp_business.json")){
		    	    		System.out.println("\n Incorrect file name "+ args[0]);
		    	    	}
		    	    	if(!args[1].equalsIgnoreCase("yelp_review.json")){
		    	    		System.out.println("\n Incorrect file name "+ args[1]);
		    	    	}
                        if(!args[2].equalsIgnoreCase("yelp_checkin.json")){
                        	System.out.println("\n Incorrect file name "+ args[2]);
		    	    	}
                        if(!args[3].equalsIgnoreCase("yelp_user.json")){
                        	System.out.println("\n Incorrect file name "+ args[3]);
		    	    	}
		    	   // }
		    	    
					String line1 	= null;
					String line2 	= null;
					String line3 	= null;
					String line4 	= null;
					// read the json file
		           // file 			= new BufferedReader(new FileReader(filePath));
					file1 			= new BufferedReader(new FileReader(args[0]));              //("yelp_business.json"));
					line1 			= file1.readLine();
					file2 			= new BufferedReader(new FileReader(args[1]));              //("yelp_review.json"));
					line2 			= file2.readLine();
					file3 			= new BufferedReader(new FileReader(args[2]));              // ("yelp_checkin.json"));
					line3 			= file3.readLine();
					file4 			= new BufferedReader(new FileReader(args[3]));              //("yelp_user.json"));
					line4 			= file4.readLine();
					insertDBCon     = new InsertToDB();
					con             = insertDBCon.openConnection();
					insertDBCon.deleteData(con);
				
						while(line1 != null){
									ParseBusiness parseBusiness = new ParseBusiness(line1 , con)	;
									parseBusiness.parseJson();
									
									line1 					    = file1.readLine();	    
						} 
						
						System.out.println("\n Business data is populated.");
						
						while(line2 != null){ 
									ParseReview parseReview 	= new ParseReview(line2 , con)	;
									parseReview.parseJson();
									
									line2 						= file2.readLine();	 
					     }
						
						System.out.println("\n Review data is populated.");
						
						while(line3 != null){ 
									ParseCheckin parseCheckin 	= new ParseCheckin(line3 , con)	;
									parseCheckin.parseJson();
									
									line3						= file3.readLine();
								  }
						
						System.out.println("\n Checkin data is populated.");
						
						while(line4 != null){ 
									
									ParseUser parseUser 	    = new ParseUser(line4 , con)	;
									parseUser.parseJson();
									
									line4						= file4.readLine();
								  }
						
						System.out.println("\n User data is populated.");
							
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (NullPointerException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException | SQLException ex) {
					ex.printStackTrace();
				} finally {
					try {
						file1.close();
						file2.close();
						file3.close();
						file4.close();
						if (con != null)
						   insertDBCon.closeConnection(con);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
    	}
}













