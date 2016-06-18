package com.tribel.project2.entity;

import java.util.List;

/**
 * Part of text, that includes sentences list.
 * @author Tribel
 *
 */
public class Paragraph implements TextComposite<Sentence>{
	
	private List<Sentence> sentenceList;
	
	/**
	 * Default constructor.
	 * @param sentences {@link List}
	 */
	public Paragraph(List<Sentence> sentences) {
		this.sentenceList = sentences;
	}
	
	public void setSentenceList(List<Sentence> sentences) {
		this.sentenceList = sentences;
	}


	@Override
	public List<Sentence> getList() {
		return sentenceList;
	}
	
	
}
