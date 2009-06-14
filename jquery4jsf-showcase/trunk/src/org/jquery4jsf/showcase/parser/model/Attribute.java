package org.jquery4jsf.showcase.parser.model;

public class Attribute {
	
	String name;
	
	String description;
	
	String type;

	boolean required;

	boolean rtexprvalue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isRtexprvalue() {
		return rtexprvalue;
	}

	public void setRtexprvalue(boolean rtexprvalue) {
		this.rtexprvalue = rtexprvalue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}