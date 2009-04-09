package org.jquery4jsf.custom.progressbar;

import javax.faces.component.UIComponent;

import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class ProgressBarTag extends UIComponentTagBase {

	private String value;
	private String resizable;
	
	public String getComponentType() {
		return ProgressBar.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return ProgressBar.DEFAULT_RENDERER_TYPE;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setResizable(String resizable) {
		this.resizable = resizable;
	}

	public void release() {
		super.release();
		value = null;
		resizable = null;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		setIntegerProperty(getFacesContext(), component, "value", value);
		setBooleanProperty(getFacesContext(), component, "resizable", resizable);
	}

}
