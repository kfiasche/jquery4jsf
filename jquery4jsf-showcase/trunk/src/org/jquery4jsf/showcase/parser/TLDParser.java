package org.jquery4jsf.showcase.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jquery4jsf.showcase.parser.model.TagDefinition;
import org.jquery4jsf.showcase.parser.model.TagLib;
import org.xml.sax.SAXException;


public class TLDParser {

	@SuppressWarnings("unchecked")
	public static TagLib parse(InputStream stream) throws ParserConfigurationException, SAXException, IOException, DocumentException {
		TagLib res = new TagLib();

		//XPP3Reader reader = new XPP3Reader();
		SAXReader reader = new SAXReader(false);
		reader.setIncludeExternalDTDDeclarations(false);
		reader.setIncludeInternalDTDDeclarations(true);
		Document document = reader.read(stream);
		
		Element root = document.getRootElement();
		for (int i = 0; i < root.elements().size(); i++) {
			Element cur = (Element) root.elements().get(i);
			String name = cur.getName();
			String data = cur.getTextTrim();
			if (name.equals("tlib-version")) {
				res.setTlibVersion(data);
			}
			if (name.equals("jsp-version")) {
				res.setJspVersion(data);
			}
			if (name.equals("short-name")) {
				res.setShortVame(data);
			}
			if (name.equals("uri")) {
				res.setUri(data);
			}
			if (name.equals("description")) {
				res.setDescription(data);
			}

			if (name.equals("tag")) {
				TagDefinition tagDefinition = new TagDefinition();
				List<Element> attributes = cur.elements();
				for (Element element : attributes) {
					if (element.getName().equalsIgnoreCase("name"))
					{
						String tagName = element.getTextTrim();
						tagDefinition.setName(tagName);
					}
					if (element.getName().equalsIgnoreCase("tag-class")){
						String tagClass = element.getTextTrim();
						tagDefinition.setTagClass(tagClass);
					}
					if (element.getName().equalsIgnoreCase("body-content")){
						String bodyContent = element.getTextTrim();
						tagDefinition.setBodyContent(bodyContent);
					}
					if (element.getName().equalsIgnoreCase("attribute")){
						List<Element> attributesChilds = element.elements();
						String nameAtt = null;
						String type= "&nbsp;";
						String description= "&nbsp;";
						String required= "";
						String requiredRuntime= "";
						for (Element attribute : attributesChilds) {
							if (attribute.getName().equalsIgnoreCase("name")){
								nameAtt = attribute.getTextTrim();
							}
							if (attribute.getName().equalsIgnoreCase("type")){
								type = attribute.getTextTrim().concat("&nbsp;");;
							}
							if (attribute.getName().equalsIgnoreCase("description")){
								description = attribute.getTextTrim().concat("&nbsp;");
							}
							if (attribute.getName().equalsIgnoreCase("required")){
								required = attribute.getTextTrim();
							}
							if (attribute.getName().equalsIgnoreCase("rtexprvalue")){
								requiredRuntime = attribute.getTextTrim();
							}
						}
						tagDefinition.addAttribute(nameAtt, description, type, required, requiredRuntime);
					}
				}
				res.getTags().put(tagDefinition.getName(), tagDefinition);
			}
		}
		return res;
	}
}
