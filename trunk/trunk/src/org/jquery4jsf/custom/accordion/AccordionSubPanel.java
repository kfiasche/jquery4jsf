package org.jquery4jsf.custom.accordion;

import javax.faces.context.FacesContext;

import org.jquery4jsf.component.ext.HtmlBaseComponent;

public class AccordionSubPanel extends HtmlBaseComponent {

	public AccordionSubPanel() {
		super();
		setRendererType(DEFAULT_RENDERER_TYPE);
	}
	
	private String panelName;

	public static final String COMPONENT_FAMILY = "org.jquery4jsf.AccordionSubPanel";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlAccordionSubPanel";
	public static final String DEFAULT_RENDERER_TYPE = AccordionSubPanelRenderer.RENDERER_TYPE;

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public String getPanelName() {
		return (String)getLocalOrValueBindingValue(panelName, "panelName");
	}

	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}

	public void restoreState(FacesContext context, Object state) {
		 	Object[] values = (Object[]) state;
	        super.restoreState(context, values[0]);
	        panelName		= (String)values[1];
	}

	public Object saveState(FacesContext context) {
		Object[] values = new Object[2];
        values[0] = super.saveState(context);
        values[1]= panelName;
        return values;
	}
}
