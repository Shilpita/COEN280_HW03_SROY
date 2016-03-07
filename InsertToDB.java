

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertToDB {
	   public String smtInsert ;
	   public Connection con ;
	
	  // public InsertToDB(String smtInsert){
	   public InsertToDB() throws ClassNotFoundException, SQLException{
		   this.con    		 = null;
		   this.smtInsert    = null;      //      smtInsert;
		 //  this.smtInsert    = null;
	   } 
	   
       /** 
        * 
        * @return a database connection 
        * @throws java.sql.SQLException when there is an error when trying to connect database 
        * @throws ClassNotFoundException when the database driver is not found. 
        */ 
	   
       public Connection openConnection() throws SQLException, ClassNotFoundException { 
           // Load the Oracle database driver 
           DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
    
           /* 
           Here is the information needed when connecting to a database 
           server. These values are now hard-coded in the program. In 
           general, they should be stored in some configuration file and 
           read at run time. 
           */ 
           String host     = "192.168.56.102"; 
           String port     = "1521"; 
           String dbName   = "XE"; 
           String userName = "SYSTEM"; 
           String password = "oracle"; 
    
          // Construct the JDBC URL 
          String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName; 
          System.out.println("\n Open connection");
          return DriverManager.getConnection(dbURL, userName, password); 
      } 
     
       
       /** 
        * Delete Data from tables before population 
        * @param con 
        */   
       public void deleteData(Connection con) throws SQLException { 
           Statement stmt = con.createStatement(); 
    
           System.out.println("Deleting previous tuples ..."); 
           
       //   stmt.executeUpdate("DELETE FROM ELITE"); 
       //   stmt.executeUpdate("DELETE FROM BUSINESS_NEIGHBORHOOD"); 
       //   stmt.executeUpdate("DELETE FROM OPERATION");
          stmt.executeUpdate("DELETE FROM SUB_CATEGORY");
          stmt.executeUpdate("DELETE FROM REVIEWS");
          stmt.executeUpdate("DELETE FROM CHECKINS");
          stmt.executeUpdate("DELETE FROM YELP_USER");
          stmt.executeUpdate("DELETE FROM BUSINESS");
           
           System.out.println("Tuples deleted...now populate new tuples!!");
           
           stmt.close(); 
       }
       
      /** 
       * Close the database connection 
       * @param con 
       */ 
       
      public void closeConnection(Connection con) { 
     //  public void closeConnection(){
          try { 
              con.close(); 
              System.out.println("\n Closed Connection");
          } catch (SQLException e) { 
              System.err.println("Cannot close connection: " + e.getMessage()); 
          } 
      } 
      
  }