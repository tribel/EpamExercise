package com.tribel.project2.model;

/**
 * Regular expression constant interface.
 * @author Tribel
 *
 */
public interface RegExInteface {

	String REAPLECE_SYMBOLS = "(\\s{2,})|(\t)";
    String CHANGE_TO_CHARACTER = " ";
    String PARAGRAPH = ".+((\u2029$)|(\\z))";
    String SENTENCE = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    String WORD = "(\\w*[a-zA-Z]+\\w*)|([a-zA-Z_]+\\w*)";
    
    
}
   