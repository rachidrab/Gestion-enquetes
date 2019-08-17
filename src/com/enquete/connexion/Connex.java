package com.enquete.connexion;

import java.sql.*;


public class Connex {
	   private static String url = "jdbc:mysql://localhost:3306/enquete";    
	    private static String driverName = "com.mysql.jdbc.Driver";   
	    private static String username = "root";   
	    private static String password = "";
	    private static Connection con;

	    public static Connection getConnex() {
	        try {
	            Class.forName(driverName);
	                con = DriverManager.getConnection(url, username, password);
	            } 
	        catch (SQLException ex) {
	                // log an exception. fro example:
	                System.out.println("Failed to create the database connection."); 
	            }
	       
	    catch (ClassNotFoundException ex) {
	            // log an exception. for example:
	            System.out.println("Driver not found."); 
	        }
	        return con;
	    }
} 


