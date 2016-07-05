package com.main;

import java.io.FileInputStream;

import com.parsers.DomParser;
import com.parsers.SaxParser;
import com.parsers.StaxParser;

public class XmlParseShow {
	
	public static void main(String[] args) throws Exception {
		String filePath = "./src/gem.xml";
		
		DomParser domParser = new DomParser();
		domParser.parse(new FileInputStream(filePath));
		System.out.println(domParser.getJewels());
	
		
		SaxParser saxParser = new SaxParser();
		saxParser.parse(new FileInputStream(filePath));
		System.out.println(saxParser.getJewel());
	
		StaxParser staxParser = new StaxParser();
		staxParser.parse(new FileInputStream(filePath));
		System.out.println(staxParser.getJewel());
	}
	
	
}
