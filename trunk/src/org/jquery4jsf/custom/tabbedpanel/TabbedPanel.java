package org.jquery4jsf.custom.tabbedpanel;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;

public class TabbedPanel extends HtmlBaseComponent implements AjaxComponent, JQueryHtmlObject{

	public static final String COMPONENT_FAMILY = "org.jquery4jsf.TabbedPanel";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTabbedPanel";
	public static final String DEFAULT_RENDERER_TYPE = TabbedPanelRenderer.RENDERER_TYPE;
	
	private String 	ajaxOptions;
	private Boolean cache;
	private Boolean collapsible;
	private String 	cookie;
	private Boolean deselectable;
	private String 	event;
	private String 	fx;
	private String 	idPrefix;
	private Integer selected;
	private String 	spinner;
	private String[] resources = null;
	
	public TabbedPanel() {
		super();
		resources = new String[]{
				"themes/base/ui.all.css",
				"jquery/jquery.js",
				"ui/ui.core.js",
				"tab/ui.tabs.js"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public void restoreState(FacesContext context, Object state)
    {
        Object[] values = (Object[]) state;
        super.restoreState(context, values[0]);
        ajaxOptions = (String) values[1]; 
        cache       = (Boolean) values[2]; 
        collapsible = (Boolean) values[3]; 
        cookie      = (String) values[4]; 
        deselectable= (Boolean) values[5]; 
        event       = (String) values[6]; 
        fx          = (String) values[7]; 
        idPrefix    = (String) values[8]; 
        selected    = (Integer) values[10];
        spinner     = (String) values[11];
    }
	
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[12];
        values[0] = super.saveState(context);
        values[1] = ajaxOptions;
        values[2] = cache;
        values[3] = collapsible;
        values[4] = cookie;
        values[5] = deselectable;
        values[6] = event;
        values[7] = fx;
        values[8] = idPrefix;
        values[10] = selected;
        values[11] = spinner;
        return values;
    }
	
	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}

	public String[] getResources() {
		return resources;
	}

	public String getAjaxOptions() {
		return (String)getLocalOrValueBindingValue(ajaxOptions, "ajaxOptions");
	}

	public void setAjaxOptions(String ajaxOptions) {
		this.ajaxOptions = ajaxOptions;
	}

	public boolean isCache() {
		Boolean bValue = (Boolean)getLocalOrValueBindingValue(cache, "cache");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setCache(boolean cache) {
		this.cache = cache ? Boolean.TRUE : Boolean.FALSE;
	}

	public boolean isCollapsible() {
		Boolean bValue = (Boolean)getLocalOrValueBindingValue(collapsible, "collapsible");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setCollapsible(Boolean collapsible) {
		this.collapsible = collapsible;
	}

	public String getCookie() {
		return (String)getLocalOrValueBindingValue(cookie, "cookie");
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public boolean isDeselectable() {
		Boolean bValue = (Boolean)getLocalOrValueBindingValue(deselectable, "deselectable");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setDeselectable(boolean deselectable) {
		this.deselectable = deselectable ? Boolean.TRUE : Boolean.FALSE;
	}

	public String getEvent() {
		return (String)getLocalOrValueBindingValue(event, "event");
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getFx() {
		return (String)getLocalOrValueBindingValue(fx, "fx");
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public String getIdPrefix() {
		return (String)getLocalOrValueBindingValue(idPrefix, "idPrefix");
	}

	public void setIdPrefix(String idPrefix) {
		this.idPrefix = idPrefix;
	}

	public Integer getSelected() {
		return (Integer)getLocalOrValueBindingValue(selected, "selected");
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public String getSpinner() {
		return (String)getLocalOrValueBindingValue(spinner, "spinner");
	}

	public void setSpinner(String spinner) {
		this.spinner = spinner;
	}

}
