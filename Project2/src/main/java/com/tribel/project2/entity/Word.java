package com.tribel.project2.entity;

/**
 * This class represents a word, that is a part of sentence.
 * @author Tribel
 *
 */
public class Word  {

	private String word;
	
	/**
	 * 
	 * @param str word {@link String} value 
	 * @param position {@link Integer} word position
	 */
	public Word(String str) {
		this.word = str;
	}
	
	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	@Override
	public String toString() {
		return word;
	}
	
	
	
}
