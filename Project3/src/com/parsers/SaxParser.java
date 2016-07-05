package com.parsers;

import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.xml.Jewel;
import com.xml.Jewel.Gem;
import com.xml.Jewel.Gem.VisualParameters;

/**
 * Class implements java SAX parser.
 * @author Tribel
 *
 */
public class SaxParser {
	
	Jewel jewel = new Jewel();
	String temp;
	
	class SaxHandler implements ContentHandler {

		@Override
		public void setDocumentLocator(Locator locator) {
		}

		@Override
		public void startDocument() throws SAXException {
		}

		@Override
		public void endDocument() throws SAXException {
		}

		@Override
		public void startPrefixMapping(String prefix, String uri)
				throws SAXException {
		}

		@Override
		public void endPrefixMapping(String prefix) throws SAXException {
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes atts) throws SAXException {
		
			switch (localName) {
			case "gem":
				Gem gem = new Gem();
				if(atts != null) gem.setId(Byte.parseByte(atts.getValue("id")));
				jewel.getGem().add(gem);
				break;

			case "visual_parameters":
				VisualParameters vp = new VisualParameters();
				jewel.getGem().get(jewel.getGem().size() - 1).setVisualParameters(vp);
				break;
			default:
				break;
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			int lastIndex = jewel.getGem().size() - 1;
			
			switch (localName) {
			case "name":
				jewel.getGem().get(lastIndex).setName(temp);
				break;
			case "preciousness":
				jewel.getGem().get(lastIndex).setPreciousness(Boolean.parseBoolean(temp));
				break;
			case "origin":
				jewel.getGem().get(lastIndex).setOrigin(temp);
				break;
			case "color":
				jewel.getGem().get(lastIndex).getVisualParameters().setColor(temp);
				break;
			case "transparency":
				jewel.getGem().get(lastIndex).getVisualParameters().setTransparency(Byte.parseByte(temp));
				break;
			case "faces":
				jewel.getGem().get(lastIndex).getVisualParameters().setFaces(Byte.parseByte(temp));
				break;
			case "value":
				jewel.getGem().get(lastIndex).setValue(Float.parseFloat(temp));
				break;
			default:
				break;
			}
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			
			temp = new String(ch, start, length);
		}

		@Override
		public void ignorableWhitespace(char[] ch, int start, int length)
				throws SAXException {
		}

		@Override
		public void processingInstruction(String target, String data)
				throws SAXException {
		}

		@Override
		public void skippedEntity(String name) throws SAXException {
		}
		
	}
	
	/**
	 * Parse entire xml file and generate and java class.
	 * @param in path to xml file
	 * @throws Exception 
	 */
	public void parse(InputStream in) throws Exception {
		jewel.setGem(new ArrayList<>());
		XMLReader reader = XMLReaderFactory.createXMLReader();
		SaxHandler contentHandler = new SaxHandler();
		reader.setContentHandler(contentHandler);
		reader.parse(new InputSource(in));
	}
	
	/**
	 * Returning {@link Jewel} entity, after parse xml file.
	 * @return {@link Jewel} entity.
	 */
	public Jewel getJewel() {
		return jewel;
	}
}
