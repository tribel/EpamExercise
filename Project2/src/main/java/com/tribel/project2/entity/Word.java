package com.tribel.project2.entity;

/**
 * his class represents a word, that is a part of sentence.
 * @author Tribel
 *
 */
public class Word extends SentencePart<String> implements Cloneable{

	private String word;
	
	/**
	 * 
	 * @param str word {@link String} value 
	 * @param position {@link Integer} word position
	 */
	public Word(String str, int position) {
		this.word = str;
		this.position = position;
	}
	
	public Word(String str) {
		this.word = str;
	}
	
	@Override
	public String getSentencePart() {
		return word;
	}

	
	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public Word clone() {
		try {
			return (Word) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
}
