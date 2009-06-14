package org.jquery4jsf.showcase.parser.model;
import java.util.ArrayList;

public class TagDefinition {
	String name;

	String tagClass;

	String bodyContent;

	ArrayList<Attribute> attributes;

	public ArrayList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new ArrayList<Attribute>();
		}
		return attributes;
	}

	public void setAttributes( ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}

	public String getBodyContent() {
		return bodyContent;
	}

	public void setBodyContent(String bodyContent) {
		this.bodyContent = bodyContent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTagClass() {
		return tagClass;
	}

	public void setTagClass(String tagClass) {
		this.tagClass = tagClass;
	}

	public void addAttribute(String name, String description,String type,  String required, String rtexprvalue) {
		addAttribute(name, description,type, required.equals("true"), rtexprvalue.equals("true"));
	}

	public void addAttribute(String name, String description,String type,  boolean required, boolean rtexprvalue) {
		Attribute a = new Attribute();
		a.setName(name);
		a.setDescription(description);
		a.setType(type);
		a.setRequired(required);
		a.setRtexprvalue(rtexprvalue);
		if (!getAttributes().contains(a)){
			getAttributes().add(a);
		}
	}
}

