package org.jquery4jsf.showcase.parser.model;

import java.util.LinkedHashMap;

public class TagLib {
	String tlibVersion;

	String jspVersion;

	String shortVame;

	String uri;

	String description;

	LinkedHashMap<String, TagDefinition> tags;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJspVersion() {
		return jspVersion;
	}

	public void setJspVersion(String jspVersion) {
		this.jspVersion = jspVersion;
	}

	public String getShortVame() {
		return shortVame;
	}

	public void setShortVame(String shortVame) {
		this.shortVame = shortVame;
	}

	public LinkedHashMap<String, TagDefinition> getTags() {
		if (tags == null) {
			tags = new LinkedHashMap<String, TagDefinition>();
		}
		return tags;
	}

	public void setTags(LinkedHashMap<String, TagDefinition> tags) {
		this.tags = tags;
	}

	public String getTlibVersion() {
		return tlibVersion;
	}

	public void setTlibVersion(String tlibVersion) {
		this.tlibVersion = tlibVersion;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
