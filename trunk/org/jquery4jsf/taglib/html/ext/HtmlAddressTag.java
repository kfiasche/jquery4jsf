package org.jquery4jsf.taglib.html.ext;

import org.jquery4jsf.custom.HtmlAddress;

public class HtmlAddressTag extends HtmlJSBaseTag {

	public String getComponentType() {
		return HtmlAddress.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return HtmlAddress.DEFAULT_RENDERER_TYPE;
	}

}
