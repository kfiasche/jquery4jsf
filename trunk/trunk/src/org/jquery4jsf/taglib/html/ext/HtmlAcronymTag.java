package org.jquery4jsf.taglib.html.ext;

import org.jquery4jsf.custom.HtmlAcronym;

public class HtmlAcronymTag extends HtmlJSBaseTag {

	public String getComponentType() {
		return HtmlAcronym.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return HtmlAcronym.DEFAULT_RENDERER_TYPE;
	}

}
