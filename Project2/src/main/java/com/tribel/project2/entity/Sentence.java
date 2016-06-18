package com.tribel.project2.entity;

import java.util.List;

/**
 * This class represents a sentence which consists of a list of words and
 * punctuation marks. 
 * @author Tribel
 *
 */
public class Sentence implements TextComposite<Word>{
	  
	private List<Word> words;
	
	/**
	 * Sentence constructor that define word and marks list.
	 * @param words {@link List} that represents all words
	 */
	public Sentence(List<Word> words) {
		this.words = words;

	}

	@Override
	public List<Word> getList() {
		return words;
	}

	
}
