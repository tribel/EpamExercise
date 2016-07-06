package com.parsers;

import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.SAXException;

import com.xml.Jewel.Gem;
import com.xml.Jewel.Gem.VisualParameters;

/**
 * Class implements Stax java parser. Generate java class from
 * xml file.
 * @author Tribel
 *
 */
public class StaxParser  extends SaxParser{

	
	class StaxHandler extends SaxHandler {
		
		public void startElement(String uri, String localName, String qName,
				String atts) throws SAXException {

			switch (localName) {
			case "gem":
				Gem gem = new Gem();
				gem.setId(Byte.parseByte(atts));
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
	}
	
	
	@Override
	public void parse(InputStream in) throws Exception {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(in);
		StaxHandler handler = new StaxHandler();
		try {
		
			int event = reader.getEventType();
			while(true) {
				
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					handler.startElement(null, reader.getName().toString(), null, 
							reader.getAttributeValue(null, "id"));
					break;
				case XMLStreamConstants.START_DOCUMENT:
					handler.startDocument();
					break;
				case XMLStreamConstants.CHARACTERS:
					if(!reader.isWhiteSpace())
						handler.characters(reader.getText().toCharArray(), 0, 
								reader.getText().toCharArray().length);
					break;
				case XMLStreamConstants.END_ELEMENT:
					handler.endElement(null, reader.getName().toString(), null);
					break;
				case XMLStreamConstants.END_DOCUMENT:
					break;
				default:
					break;
				}
				
				if(!reader.hasNext()) break;
				
				event = reader.next();
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
