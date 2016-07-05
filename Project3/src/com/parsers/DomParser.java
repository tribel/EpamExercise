package com.parsers;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.xml.Jewel;
import com.xml.Jewel.Gem;
import com.xml.Jewel.Gem.VisualParameters;
import com.xml.ObjectFactory;


/**
 *  Class implements DOM parser of XML file.
 * @author Tribel
 *
 */
public class DomParser {

	Jewel jewel;
	
	/**
	 * Parse entire xml file, and generate java class.
	 * @param in {@link InputStream} path to xml file
	 * @throws Exception if file not found.
	 */
	public void parse(InputStream in) throws Exception {
		jewel = new ObjectFactory().createJewel();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document document = db.parse(in);
		Element root = document.getDocumentElement();
		
		NodeList rootList = root.getChildNodes();
		for(int i = 0; i < rootList.getLength(); i++) {
			Gem gemInstance = new Gem();
			Node node = rootList.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element gemEl = (Element) node;
				gemInstance.setId(Byte.parseByte(gemEl.getAttribute("id")));
				NodeList rootGem = gemEl.getChildNodes();
				for(int j = 0; j < rootGem.getLength(); j++) {
					Node nodeGem = rootGem.item(j);
					if(nodeGem.getNodeType() == Node.ELEMENT_NODE) {
						Element tmpGemElement = (Element) nodeGem;
						
						if("name".equals(tmpGemElement.getNodeName())) {
							gemInstance.setName(tmpGemElement.getFirstChild().getNodeValue());
						
						} else if("preciousness".equals(tmpGemElement.getNodeName())) {
							gemInstance.setPreciousness(
									Boolean.parseBoolean(tmpGemElement.getFirstChild().getNodeValue()));
							
						} else if("origin".equals(tmpGemElement.getNodeName())) {
							gemInstance.setOrigin(tmpGemElement.getFirstChild().getNodeValue());
						
						} else if("visual_parameters".equals(tmpGemElement.getNodeName())) {
							gemInstance.setVisualParameters(paraseVisualParameters(tmpGemElement));
						
						} else if("value".equals(tmpGemElement.getNodeName())) {
							gemInstance.setValue(Float.parseFloat(tmpGemElement.getFirstChild().getNodeValue()));
						}
					}
				}
				
				jewel.addGem(gemInstance);
			}
		}
	}
	
	
	/**
	 * Parse the visual_parameter complex tag
	 * @param el {@link Element} that will be parse
	 * @return {@link VisualParameters} entity.
	 */
	public VisualParameters paraseVisualParameters(Element el) {
		VisualParameters vp = new VisualParameters();
		NodeList childs = el.getChildNodes();
		for(int i = 0; i < childs.getLength(); i++) {
			Node item = childs.item(i);
			if(item.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) item;
				if("color".equals(element.getNodeName())) {
					vp.setColor(element.getFirstChild().getNodeValue());
				
				} else if("transparency".equals(element.getNodeName())) {
					vp.setTransparency(Byte.parseByte(element.getFirstChild().getNodeValue()));
				
				} else if("faces".equals(element.getNodeName())) {
					vp.setFaces(Byte.parseByte(element.getFirstChild().getNodeValue()));
				}
				
			}
		}
		return vp;
	}
	
	/**
	 * Returning {@link Jewel} entity, after parse xml file.
	 * @return {@link Jewel} entity.
	 */
	public Jewel getJewels() {
		return jewel;
	}

}


