package com.rest.dao;

import java.sql.*;

public class DBOperation {

	private static final String DBNAME = "euphony";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";
	
	
	public static Connection getConnection() throws Exception {
		   Connection conn = null;
		   try {
			// String url = "jdbc:mysql://euphony.cucnzttohznf.us-west-1.rds.amazonaws.com:3306/"+DBNAME+"?user="+DB_USERNAME+"&password="+DB_PASSWORD;  
		     String url = "jdbc:mysql://localhost:3306/"+DBNAME+"?user="+DB_USERNAME+"&password="+DB_PASSWORD;
		     Class.forName("com.mysql.jdbc.Driver");
		     conn = DriverManager.getConnection(url);
		   } catch (SQLException sqle) {
		      System.out.println("SQLException: Unable to open connection to db: "+sqle.getMessage());
		      throw sqle;
		   } catch(Exception e) {
		      System.out.println("Exception: Unable to open connection to db: "+e.getMessage());
		      throw e;
		   }
		   return conn;
		}
	
	public static void executeQuery(String strQuery) throws Exception {
		Connection conn = null;
		
		try {
			conn = getConnection();
			Statement stmt  = conn.createStatement();
			stmt.executeUpdate(strQuery);
			
		} catch (SQLException sqle) {
			System.out.println("SQLException: Unable to execute query : "+strQuery);
			throw sqle;
		} catch (Exception e) {
			System.out.println("Exception: Unable to execute query: "+strQuery);
			throw e;
		} finally {
			closeConnection(conn);
		}
	}

	public static Long executeUpdateQuery(String query) throws Exception{
		Connection conn = null;
		Long returnedIndx;
		try {
			conn = getConnection();
			Statement stmt  = conn.createStatement();
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);			
			ResultSet rs = null;
             try {
                 rs = stmt.getGeneratedKeys();
                 if (rs.next()) {
                	 returnedIndx = rs.getLong(1);                    
                 } else {
                     throw new RuntimeException("Can't find most recent insert we just entered");
                 }
                 rs.close();
                 rs = null;
             }  finally {
                 if (rs != null) {
                     try {
                         rs.close();
                     } catch (SQLException ex) {} // ignore
                 }
                 try {
                	 stmt.close();
                 } catch (SQLException ex) {}  // ignore
             }
			
		} catch (SQLException sqle) {
			System.out.println("SQLException: Unable to execute query : "+query);
			throw sqle;
		} catch (Exception e) {
			System.out.println("Exception: Unable to execute query: "+query);
			throw e;
		} finally {
			closeConnection(conn);
		}
		System.out.println("Returned Index is: "+returnedIndx);
		return returnedIndx;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		} catch(SQLException sqle) {
			System.out.println("Error while closing connection.");
		}
	}
	

}
