package org.jquery4jsf.custom.accordion;

import javax.faces.component.UIComponent;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.taglib.html.ext.HtmlJSBaseTag;

public class AccordionPanelTag extends HtmlJSBaseTag {

	private String oncomplete;
	private String active;
	private String animated;
	private String autoHeight;
	private String clearStyle;
	private String collapsible;
	private String event;
	private String fillSpace;
	private String icons;
	private String navigation;
	
	public String getComponentType() {
		return AccordionPanel.COMPONENT_TYPE;
	}
	public String getRendererType() {
		return AccordionPanel.DEFAULT_RENDERER_TYPE;
	}
	
	public void release(){
		super.release();
		oncomplete 		= null;
		active			= null;
		animated        = null;
		autoHeight      = null;
		clearStyle      = null;
		collapsible     = null;
		event           = null;
		fillSpace       = null;
		icons           = null;
		navigation      = null;
	}
	
	
	
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		ComponentUtilities.setOncompleteProperty(getFacesContext(), component, oncomplete);
		setIntegerProperty(getFacesContext(), component, "active", active);
		setStringProperty(getFacesContext(), component, "animated", animated);
		setBooleanProperty(getFacesContext(), component, "autoHeight", autoHeight);
		setBooleanProperty(getFacesContext(), component, "clearStyle", clearStyle);
		setBooleanProperty(getFacesContext(), component, "collapsible", collapsible);
		setStringProperty(getFacesContext(), component, "event", event);
		setBooleanProperty(getFacesContext(), component, "fillSpace", fillSpace);
		setStringProperty(getFacesContext(), component, "icons", icons);
		setBooleanProperty(getFacesContext(), component, "navigation", navigation);
	}
	
	public void setOncomplete(String oncomplete) {
		this.oncomplete = oncomplete;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public void setAnimated(String animated) {
		this.animated = animated;
	}
	public void setAutoHeight(String autoHeight) {
		this.autoHeight = autoHeight;
	}
	public void setClearStyle(String clearStyle) {
		this.clearStyle = clearStyle;
	}
	public void setCollapsible(String collapsible) {
		this.collapsible = collapsible;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public void setFillSpace(String fillSpace) {
		this.fillSpace = fillSpace;
	}
	public void setIcons(String icons) {
		this.icons = icons;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	
}
