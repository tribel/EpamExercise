package com.tribel.project2.entity;

import java.util.List;

/**
 * This class represents a entire text, that will be analyze 
 * and separate by paragraphs.
 * @author Tribel
 *
 */
public class Text {
	
	private List<Paragraph> paragraphs;
	private String text;
	private String filteredText;
	
	/**
	 * Constructor 
	 * @param text {@link String} value that will be parsed. 
	 */
	public Text(String text) {
		this.text = text;
		
	}

	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public String getText() {
		return text;
	}

	public String getFilteredText() {
		return filteredText;
	}
	
	
	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setFilteredText(String filteredText) {
		this.filteredText = filteredText;
	}

}
