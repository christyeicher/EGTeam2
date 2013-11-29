package cafitnessclub.model.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	   static final String DB_URL = "jdbc:mysql://localhost/";
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "passwort";
	   private static Connection conn = null;

	   public static Connection getConnection() throws SQLException
	   {
	      try{
	    	  if (conn == null)
		      {
		         Class.forName(JDBC_DRIVER); //Register JDBC Driver
		         conn = DriverManager.getConnection(DB_URL + "CAFitnessClub", USER, null);
		      }
	      }catch(ClassNotFoundException e)
	      {
	    	  System.out.println("Error with JDBC Driver!");
	      }
	      return conn;
	   }

}
