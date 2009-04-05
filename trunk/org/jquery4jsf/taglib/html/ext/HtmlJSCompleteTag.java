package org.jquery4jsf.taglib.html.ext;

import javax.faces.component.UIComponent;

import org.jquery4jsf.renderkit.html.HTML;

public abstract class HtmlJSCompleteTag extends HtmlJSBaseTag {

	private String onchange;
	private String onblur;
	private String onfocus;
	
	public void release(){
		super.release();
		onblur = null;
		onfocus = null;
		onchange = null;
	}
	
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
        setStringProperty(getFacesContext(), component, HTML.ONBLUR, onblur);
        setStringProperty(getFacesContext(), component, HTML.ONCHANGE, onchange);
        setStringProperty(getFacesContext(), component, HTML.ONFOCUS, onfocus);
	}
	
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}
	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}
	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}
	
	
}
