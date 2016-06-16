package com.tribel.project2.entity;

/**
 * Type for sentences elements. That returned current part
 * of sentence and it position.
 * @author Tribel
 *
 */
public abstract class SentencePart<T> {

	protected int position;
	
	/**
	 * Return part of text
	 * @return part of text
	 */
	public abstract T getSentencePart();
	
	/**
	 * @return position of specific text part. 
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * Define the position field
	 * @param pos sentenve part position 
	 */
	public void setPosition(int pos) {
		this.position = pos;
	}
	
	
}
