package org.jquery4jsf.custom.accordion;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import org.jquery4jsf.component.ext.HtmlKeyEvent;
import org.jquery4jsf.component.ext.HtmlMouseEvent;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;

public class AccordionPanel extends HtmlBaseComponent implements AjaxComponent, JQueryHtmlObject, HtmlKeyEvent, HtmlMouseEvent {
	
	private String[] resources = null;

	public AccordionPanel() {
		super();
		setRendererType(DEFAULT_RENDERER_TYPE);
		resources = new String[]{
				"jquery/jquery.js",
				"ui/ui.core.js",
				"accordion/ui.accordion.js",
				"themes/base/ui.all.css"
		};
	}
	//Standard javascript event for tag <div>
	private String onclick;
	private String ondblclick;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onmousedown;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private MethodBinding oncomplete;
	
	private Integer active;
	private String 	animated;
	private Boolean autoHeight;
	private Boolean clearStyle;
	private Boolean collapsible;
	private String 	event;
	private Boolean	fillSpace;
	private String 	icons;
	private Boolean	navigation;
	private String header;
	private String navigationFilter;
	/*
	 * Eventi
	 */
	private String onaccordionchange;
	
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.AccordionPanel";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlAccordionPanel";
	public static final String DEFAULT_RENDERER_TYPE = AccordionPanelRenderer.RENDERER_TYPE;

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
    public void restoreState(FacesContext context, Object state)
    {
        Object[] values = (Object[]) state;
        super.restoreState(context, values[0]);
        onclick		= (String)values[1];
        ondblclick	= (String)values[2];
        onkeydown	= (String)values[3];
        onkeypress	= (String)values[4];
        onkeyup		= (String)values[5];
        onmousedown	= (String)values[6];
        onmousemove	= (String)values[7];
        onmouseout	= (String)values[8];
        onmouseover	= (String)values[9];
        onmouseup	= (String)values[10];
        oncomplete  = (MethodBinding)values[11];
        active		= (Integer)values[12];
        animated        = (String)values[13];
        autoHeight      = (Boolean)values[14];
        clearStyle      = (Boolean)values[15];
        collapsible     = (Boolean)values[16];
        event           = (String)values[17];
        fillSpace       = (Boolean)values[18];
        icons           = (String)values[19];
        navigation      = (Boolean)values[20];
        header			= (String)values[21];
        navigationFilter = (String)values[22];
    }
    
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[23];
        values[0] = super.saveState(context);
        values[1]= onclick;
        values[2]= ondblclick;
        values[3]= onkeydown;
        values[4]= onkeypress;
        values[5]= onkeyup;
        values[6]= onmousedown;
        values[7]= onmousemove;
        values[8]= onmouseout;
        values[9]= onmouseover;
        values[10]= onmouseup;
        values[11] = oncomplete;
        values[12] = active;
        values[13] = animated;
        values[14] = autoHeight;
        values[15] = clearStyle;
        values[16] = collapsible;
        values[17] = event;
        values[18] = fillSpace;
        values[19] = icons;
        values[20] = navigation;
        values[21] = header;
        values[22] = navigationFilter;
        return values;
    }

	public String getOnclick() {
		return (String) getLocalOrValueBindingValue(onclick, "onclick");
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		return (String) getLocalOrValueBindingValue(ondblclick, "ondblclick");
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnkeydown() {
		return (String) getLocalOrValueBindingValue(onkeydown, "onkeydown");
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeypress() {
		return (String) getLocalOrValueBindingValue(onkeypress,"onkeypress");
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeyup() {
		return (String) getLocalOrValueBindingValue(onkeyup,"onkeyup");
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnmousedown() {
		return (String) getLocalOrValueBindingValue(onmousedown, "onmousedown");
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmousemove() {
		return (String) getLocalOrValueBindingValue(onmousemove, "onmousemove");
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return (String) getLocalOrValueBindingValue(onmouseout, "onmouseout");
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnmouseover() {
		return (String) getLocalOrValueBindingValue(onmouseover, "onmouseover");
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmouseup() {
		return (String) getLocalOrValueBindingValue(onmouseup, "onmouseup");
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public MethodBinding getOncomplete() {
		return oncomplete;
	}

	public void setOncomplete(MethodBinding methodBinding) {
		this.oncomplete = methodBinding;
	}

	
	public Integer getActive() {
		return (Integer) getLocalOrValueBindingValue(active, "active");
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getAnimated() {
		return (String) getLocalOrValueBindingValue(animated, "animated");
	}

	public void setAnimated(String animated) {
		this.animated = animated;
	}

	public boolean isAutoHeight() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(autoHeight, "autoHeight");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setAutoHeight(boolean autoHeight) {
		this.autoHeight = autoHeight ? Boolean.TRUE : Boolean.FALSE;
	}

	public boolean isClearStyle() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(clearStyle, "clearStyle");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setClearStyle(boolean clearStyle) {
		this.clearStyle = clearStyle ? Boolean.TRUE : Boolean.FALSE;
	}

	public boolean isCollapsible() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(collapsible, "collapsible");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setCollapsible(boolean collapsible) {
		this.collapsible = collapsible ? Boolean.TRUE : Boolean.FALSE;
	}

	public String getEvent() {
		return (String) getLocalOrValueBindingValue(event, "event");
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public boolean isFillSpace() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(fillSpace, "fillSpace");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setFillSpace(boolean fillSpace) {
		this.fillSpace = fillSpace ? Boolean.TRUE : Boolean.FALSE;
	}

	public String getIcons() {
		return (String) getLocalOrValueBindingValue(icons, "icons");
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	public boolean isNavigation() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(navigation, "navigation");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setNavigation(boolean navigation) {
		this.navigation = navigation ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public String getHeader() {
		return (String) getLocalOrValueBindingValue(header, "header");
	}

	public void setHeader(String header) {
		this.header = header;
	}
	
	public String[] getResources() {
		return resources;
	}

	public String getNavigationFilter() {
		return (String) getLocalOrValueBindingValue(navigationFilter, "navigationFilter");
	}

	public void setNavigationFilter(String navigationFilter) {
		this.navigationFilter = navigationFilter;
	}

	public String getOnaccordionchange() {
		return (String) getLocalOrValueBindingValue(onaccordionchange, "onaccordionchange");
	}

	public void setOnaccordionchange(String onaccordionchange) {
		this.onaccordionchange = onaccordionchange;
	}
}
