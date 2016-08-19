package com.restaurant.service;

import java.sql.SQLException;

import com.restaurant.service.transaction.Operation;
import com.restaurant.service.transaction.TransactionWrapper;

/**
 * Fake wrapper for test mode.
 * @author Tribel
 *
 */
public class TransactionWrapperTest extends TransactionWrapper{

	public TransactionWrapperTest() {
	}
	
	@Override
	public <T> T beginTransaction(Operation<T> command) {
		T result = null;
		try {
			result = command.execute(null);
			
		} catch (SQLException e) {
			
		} finally {
		}
		
		
		return result;
	}
}
