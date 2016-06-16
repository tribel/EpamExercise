package com.tribel.project2.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a sentence which consists of a list of words and
 * punctuation marks. 
 * @author Tribel
 *
 */
public class Sentence {
	
	private List<Word> words;
	private List<PunctuationMark> marks;
	
	/**
	 * Sentence constructor that define word and marks list.
	 * @param words {@link List} that represents all words
	 * @param marks {@link Character} represents all punctuation marks.
	 */
	public Sentence(List<Word> words, List<PunctuationMark> marks) {
		this.words = words;
		this.marks = marks;
	}

	public List<Word> getWords() {
		return words;
	}

	public List<PunctuationMark> getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		StringBuilder sentence = new StringBuilder();
		List<SentencePart<? extends Object>> partsList = new ArrayList<>();
		partsList.addAll(marks);
		partsList.addAll(words);

		partsList.sort(( o1, o2) -> Integer.compare(o1.getPosition(), o2.getPosition()));
		partsList.stream().forEach(x -> sentence.append(x.getSentencePart()));
		return sentence.toString();
	}

	
	
	
}
