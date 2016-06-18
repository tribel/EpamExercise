package com.tribel.project2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for wrap methods in Parse class, for reduce equals code.
 * @author Tribel
 *
 */
public class ParserWrapper {

	/**
	 * Default constructor.  
	 */
	public ParserWrapper() {
	}

	
	public <T> List<T> parse(Operation<T> operation, String strMatcher, Pattern pattern) {
		List<T> resultList = new ArrayList<>();
		Matcher matcher = pattern.matcher(strMatcher);
		String tmpString = null;
		
		while(matcher.find()) {
			tmpString = matcher.group();
			if(!tmpString.isEmpty()) {
				resultList.add((T) operation.execute(tmpString, matcher));
			}
		}
		return resultList;
	}



}
