package org.jquery4jsf.custom.outputscript;

import javax.faces.component.UIComponent;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class OutputScriptTag extends UIComponentTagBase{

	private String src;
	private String type;
	private String defer;
	private String charset;
	
	public String getComponentType() {
		return OutputScript.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return OutputScript.DEFAULT_RENDERER_TYPE;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDefer(String defer) {
		this.defer = defer;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void release(){
		super.release();
		src    = null;
		type   = null;
		defer  = null;
		charset= null;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "src",src);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "type",type);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "defer",defer);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "charset",charset);
	}

}
