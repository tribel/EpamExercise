package com.tribel.project2.entity;

/**
 * This class represents a punctuation mark, that is a part of sentence.
 * @author Tribel
 *
 */
public class PunctuationMark extends SentencePart<Character>{

	private Character mark;
	
	/**
	 * 
	 * @param ch actual {@link Character} value of punctuation mark
	 * @param position {@link Integer} mark position
	 */
	public PunctuationMark(Character ch, int position) {
		this.mark = ch;
		this.position = position;
	}
	
	@Override
	public Character getSentencePart() {
		return mark;
	}

	@Override
	public String toString() {
		return String.valueOf(mark);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
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
		PunctuationMark other = (PunctuationMark) obj;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		return true;
	}
	
	

}
