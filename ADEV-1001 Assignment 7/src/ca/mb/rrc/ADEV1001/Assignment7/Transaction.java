package ca.mb.rrc.ADEV1001.Assignment7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
	/**
	 * Parameter: USER_NAME, user name to gain access to MySQL database
	 * Parameter: PASS_WORD, password to gain access to MySQL database
	 * Parameter: CONNECTION_STR, connection link  to MySQL and chosen database Adev1001Project
	 */
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "t65yrG77";
	private static final String CONNECTION_STR = "jdbc:mysql://localhost/employees";		

	public static void main(String[] args) throws SQLException 
	{
		/*
			String query represents the SQL action I want to make
		 	This being inserting values into the Transaction Table
		 */
		String query = "INSERT INTO Transaction VALUES (?, ?, ?, ?, ?)";
		/**
		 * Try to connect to the MySQL database through Connection represented as conn
		 * PreparedStatement stmt used to execute the actions of the String query 
		 */
		try(
			Connection conn = DriverManager.getConnection(CONNECTION_STR, USER_NAME, PASS_WORD);
		    PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);)
		{
			/**
			 * Setting parameter 1 TransId(PK) to value
			 * Setting parameter 2 TranTypeId to value
			 * Setting parameter 3 AcctIdFrom to value
			 * Setting parameter 4 AcctIdTo to value
			 * Setting parameter 5 Amount to value
			 * Executing inserts into table by stmt.executeUpdate 
			 */
			
			stmt.setInt(1, 1);
			stmt.setString(2, "A");
			stmt.setInt(3, 100);
			stmt.setInt(4, 200);
			stmt.setInt(5, 100);
			int insert1 = stmt.executeUpdate();
			
			stmt.setInt(1, 1);
			stmt.setString(2, "C");
			stmt.setInt(3, 300);
			stmt.setInt(4, 200);
			stmt.setInt(5, 1000);
			int insert2 = stmt.executeUpdate();
			
			stmt.setInt(1, 1);
			stmt.setString(2, "A");
			stmt.setInt(3, 400);
			stmt.setInt(4, 200);
			stmt.setInt(5, 100);
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
