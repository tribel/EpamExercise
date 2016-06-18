package com.tribel.project2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tribel.project2.entity.Paragraph;
import com.tribel.project2.entity.Sentence;
import com.tribel.project2.entity.WordFactory;
import com.tribel.project2.entity.Text;
import com.tribel.project2.entity.Word;

/**
 * Model class that define major parse methods of paragraphs, 
 * sentences characters and words.
 * @author Tribel
 *
 */
public class Parse {

	private Pattern paragrapPattern;
	private Pattern sentencePattern;
	private Pattern wordPattern;

	/**
	 * Default constructor , define all regular expression patterns,
	 * that will be used in class. 
	 */
	public Parse() {
		this.paragrapPattern = Pattern.compile(RegExInteface.PARAGRAPH);
		this.sentencePattern = Pattern.compile(RegExInteface.SENTENCE);
		this.wordPattern = Pattern.compile(RegExInteface.WORD);
	}

	/**
	 * Parse text and replace all tabulations to single space.
	 * @param text {@link String} text the will be parsed
	 * @return text without tabulations.
	 */
	public String parseText(String text) {
		return text.replaceAll(RegExInteface.REAPLECE_SYMBOLS,
				RegExInteface.CHANGE_TO_CHARACTER);
	}

	
	/**
	 * Parse input text, separate it to paragraphs 
	 * @param text input {@link String} text
	 * @return parsed {@link Text} entity
	 */
	public Text putAnalizeText(Text text) {
		text.setFilteredText(parseText(text.getText()));
		text.setParagraphs(parseParagraph(text));
		return text;
	}
	
	/**
	 * Parse text and returned paragraphs list.
	 * @param txt text that will be parsed.
	 * @return  {@link List} {@link Paragraph}. 
	 */
	public List<Paragraph> parseParagraph(Text txt) {
		Matcher matcher = paragrapPattern.matcher(txt.getFilteredText());
		List<Paragraph> paragraphs = new ArrayList<>();
		String tmpParagraph = null;

		while (matcher.find()) {
			tmpParagraph = matcher.group();
			if (!tmpParagraph.isEmpty()) {
				 paragraphs.add(new Paragraph(getSentences(tmpParagraph)));
			}
		}
		return paragraphs;
	}

	/**
	 * Parse text and returned sentences list.
	 * @param text {@link String} that will be parsed.
	 * @return list of resulting sentences.
	 */
	public List<Sentence> getSentences(String text) { 
		return new ParserWrapper().parse((str, matcher) -> {
			return new Sentence(getTextWords(str));
		}, text, sentencePattern);
	}
	
	/**
	 * Parse text and returned words list.
	 * @param text {@link String} that will be parsed.
	 * @return {@link Word} {@link List}`
	 */
	public List<Word> getTextWords(String text) {
		return new ParserWrapper().parse((str, matcher) -> {
				 return WordFactory.getPart(str);
			} , text, wordPattern);
	}
	
	
	/**
	 * Sorting sentences by word count
	 * @param text  full {@link Text}
	 * @return {@link Sentence} {@link List}
	 */
	public List<Sentence> sortByWordCount(Text text) {
		List<Sentence> sentences = new ArrayList<>();
		text.getList().stream().forEach(x -> sentences.addAll(x.getList()));
		sentences.sort((s1, s2) -> Integer.compare(s1.getList().size(), 
												   s2.getList().size()));
		return sentences;
	}
	
	//size1 > size2 ? true : false
			
}
