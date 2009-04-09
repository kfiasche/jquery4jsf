package org.jquery4jsf.custom.tabbedpanel;

import javax.faces.component.UIComponent;

import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class TabbedPanelTag extends UIComponentTagBase {

	private String 	ajaxOptions;
	private String 	cache;
	private String 	collapsible;
	private String 	cookie;
	private String 	deselectable;
	private String 	event;
	private String 	fx;
	private String 	idPrefix;
	private String 	selected;
	private String 	spinner;
	
	public String getComponentType() {
		return TabbedPanel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return TabbedPanel.DEFAULT_RENDERER_TYPE;
	}

	public void release(){
		super.release();
		ajaxOptions= null;
		cache= null;
		collapsible= null;
		cookie= null;
		deselectable= null;
		event= null;
		fx= null;
		idPrefix= null;
		selected= null;
		spinner= null;
	}
	
	
	
	public void setAjaxOptions(String ajaxOptions) {
		this.ajaxOptions = ajaxOptions;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}

	public void setCollapsible(String collapsible) {
		this.collapsible = collapsible;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public void setDeselectable(String deselectable) {
		this.deselectable = deselectable;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public void setIdPrefix(String idPrefix) {
		this.idPrefix = idPrefix;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public void setSpinner(String spinner) {
		this.spinner = spinner;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		setStringProperty(getFacesContext(), component, "ajaxOptions", ajaxOptions);
		setBooleanProperty(getFacesContext(), component, "cache", cache);
		setBooleanProperty(getFacesContext(), component, "collapsible", collapsible);
		setStringProperty(getFacesContext(), component, "cookie", cookie);
		setBooleanProperty(getFacesContext(), component, "deselectable", deselectable);
		setStringProperty(getFacesContext(), component, "event", event);
		setStringProperty(getFacesContext(), component, "fx", fx);
		setStringProperty(getFacesContext(), component, "idPrefix", idPrefix);
		setIntegerProperty(getFacesContext(), component, "selected", selected);
		setStringProperty(getFacesContext(), component, "spinner", spinner);
	}

}
