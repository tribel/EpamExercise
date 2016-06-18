package com.tribel.project2.entity;

import java.util.List;

/**
 * Type for sentences elements. That returned current part
 * of sentence and it position.
 * @author Tribel
 *
 */
public interface TextComposite<T> {

	
	/** 
	 * Return part of text
	 * @return part of text
	 */
	 public List<T> getList();
	

	
	
}
