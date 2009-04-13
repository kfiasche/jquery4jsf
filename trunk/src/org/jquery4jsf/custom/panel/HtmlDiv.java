package org.jquery4jsf.custom.panel;

import javax.faces.component.UIPanel;

public class HtmlDiv extends UIPanel {
	
	public static final String COMPONENT_TYPE = "org.jquery4jsf.Panel";
	public static final String RENDERER_TYPE = "org.jquery4jsf.Div";

	public HtmlDiv() {
		setRendererType(RENDERER_TYPE);
	}
}
