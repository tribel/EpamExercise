package com.restaurant.service.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Realized transaction class 
 * @author Tribel
 * 
 */
public class TransactionWrapper {
	
	private static final Logger logger = LogManager.getLogger(TransactionWrapper.class);
	private DataSource dataSource;
	
	
	public TransactionWrapper() {
		
		try {
			InitialContext initialContext = new InitialContext();
			dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/dbconnect");
			logger.info("Connection established successfully!");
		} catch (NamingException e) {
			
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * Transaction wrapper , that create {@link Connection} and catch Exceptions
	 * @param command {@link Operation} entity in anonymous class 
	 * @return result 
	 */
	public <T> T beginTransaction(Operation<T> command) {
		T result = null;
		Connection connection = null;
		
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			result = command.execute(connection);
			connection.commit();
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			try {
				logger.info("Rollback is execute");
				connection.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage());
			}
		} finally {
			
				try {
					if(connection != null) {
						connection.close();
						logger.info("Connection is close");
					}
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
		}
		
		
		return result;
	}
} 
