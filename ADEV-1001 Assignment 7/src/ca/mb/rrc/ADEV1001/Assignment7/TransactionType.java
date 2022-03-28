package ca.mb.rrc.ADEV1001.Assignment7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

class TransactionType {
	/**
	 * Parameter: USER_NAME, user name to gain access to MySQL database
	 * Parameter: PASS_WORD, password to gain access to MySQL database
	 * Parameter: CONNECTION_STR, connection link  to MySQL and chosen database Adev1001Project
	 */
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "t65yrG77";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/Adev1001Project";
	
    public static void main(String[] args) throws SQLException
    {	
    	/*
			String query represents the SQL action I want to make
			This being inserting values into the TransactionType Table
    	 */
    	String query = "INSERT INTO TransactionType VALUES (?, ?)";
    	/**
		 * Try to connect to the MySQL database through Connection represented as conn
		 * PreparedStatement stmt used to execute the actions of the String query 
		 */
		try(
			Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);
		    PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);)
		{
			/**
			 * Setting parameter 1 TranTypeId (PK) to value
			 * Setting parameter 2 TransactionDesc to value
			 * Executing inserts into table by stmt.executeUpdate 
			 */
			stmt.setString(1, "A");
			stmt.setString(2, "Authorization");
			int insert1 = stmt.executeUpdate();
			
			stmt.setString(1, "C");
			stmt.setString(2, "Credit");
			int insert2 = stmt.executeUpdate();
			
			stmt.setString(1, "P");
			stmt.setString(2, "Payment");
			int insert3 = stmt.executeUpdate();
			
			//If all inserts are completed print statement will relay message
            if (insert1 == 1 && insert2 == 1 && insert3 == 1)
                System.out.println("All rows inserted with success");
            
		}
		catch (SQLException e)
        {
            System.err.println(e);
        }    	
    }

}
