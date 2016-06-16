package com.tribel.project2.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Realization of flyweight pattern. Cash for {@link Word} objects.
 * 
 * @author Tribel
 *
 */
public class WordFactory {

	private static final Map<String, Word> map = new HashMap<>();

	public static Word getPart(String str) {
		Word word = map.get(str);
		
		if(word == null) {
			word = new Word(str);
			map.put(str, word);
		}
		return word;
	}

}
