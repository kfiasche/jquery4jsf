package org.jquery4jsf.custom;

import javax.faces.context.FacesContext;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import org.jquery4jsf.component.ext.HtmlKeyEvent;
import org.jquery4jsf.component.ext.HtmlMouseEvent;
import org.jquery4jsf.renderkit.html.ext.HtmlAcronymRenderer;

public class HtmlAcronym extends HtmlBaseComponent implements HtmlMouseEvent, HtmlKeyEvent{

	//Standard javascript event for tag <abbr>
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
	
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Acronym";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlAcronym";
	public static final String DEFAULT_RENDERER_TYPE = HtmlAcronymRenderer.RENDERER_TYPE;

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
    }
    
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[23];
        values[0] = super.saveState(context);
        values[1]=onclick;
        values[2]=ondblclick;
        values[3]=onkeydown;
        values[4]=onkeypress;
        values[5]=onkeyup;
        values[6]=onmousedown;
        values[7]=onmousemove;
        values[8]=onmouseout;
        values[9]=onmouseover;
        values[10]=onmouseup;
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
	
}
