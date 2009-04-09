package org.jquery4jsf.custom.tabbedpanel;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;

public class TabPanel extends HtmlBaseComponent implements JQueryHtmlObject{

	public static final String COMPONENT_FAMILY = "org.jquery4jsf.TabPanel";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTabPanel";
	public static final String DEFAULT_RENDERER_TYPE = TabPanelRenderer.RENDERER_TYPE;
	
	public Boolean disabled;
	public Boolean ajaxSupport;
	public String ajaxSource;
	public String tabName;
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String[] getResources() {
		throw new IllegalAccessError("Questo componente non ha nessun tipo di risorsa.");
	}

}
