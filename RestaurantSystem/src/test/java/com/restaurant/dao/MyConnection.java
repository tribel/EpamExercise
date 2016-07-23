package com.restaurant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyConnection {
	
	private static final Logger logger = LogManager.getLogger(MyConnection.class);
	
	private static final String DB_CONNECTION = "jdbc:derby:E:\\Bionic\\workpalce\\RS;create=true";

	
	public static Connection getConnection() throws SQLException{			
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		Connection conn = DriverManager.getConnection(DB_CONNECTION);
	     logger.info("Connection established successfully!");
	    return conn;
	}

}
