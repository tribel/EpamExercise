package com.tribel.project2.model;

import java.util.regex.Matcher;

/**
 * Class for creating anonymous class for parser wrapper.
 * @author Tribel
 *
 * @param <T> returned type of anonymous class. 
 */
public interface Operation<T> {

	
	public  T execute(String str, Matcher matcher);
}
