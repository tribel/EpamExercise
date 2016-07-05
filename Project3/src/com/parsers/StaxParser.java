package com.parsers;

import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

/**
 * Class implements Stax java parser. Generate java class from
 * xml file.
 * @author Tribel
 *
 */
public class StaxParser  extends SaxParser{

	@Override
	public void parse(InputStream in) throws Exception {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(in);
		SaxHandler handler = new SaxHandler();
		try {
		
			int event = reader.getEventType();
			while(true) {
				
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					//AttributesImpl attributesImpl = new AttributesImpl();
					//attributesImpl.setValue(0, "id");
					//Byte.parseByte(reader.getAttributeValue(0));
					handler.startElement(null, reader.getName().toString(), null, null);
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
