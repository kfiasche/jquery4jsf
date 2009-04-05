package org.jquery4jsf.taglib.html.ext;

import org.jquery4jsf.custom.HtmlAbbr;

public class HtmlAbbrTag extends HtmlJSBaseTag {

	public String getComponentType() {
		return HtmlAbbr.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return HtmlAbbr.DEFAULT_RENDERER_TYPE;
	}

}
