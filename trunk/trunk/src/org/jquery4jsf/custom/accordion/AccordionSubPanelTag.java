package org.jquery4jsf.custom.accordion;

import javax.faces.component.UIComponent;

import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class AccordionSubPanelTag extends UIComponentTagBase {
	
	private String panelName;

	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}

	public String getComponentType() {
		return AccordionSubPanel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return AccordionSubPanel.DEFAULT_RENDERER_TYPE;
	}
	
	public void release(){
		super.release();
		panelName = null;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		setStringProperty(getFacesContext(), component, "panelName", panelName);
	}
	
	
}
