package org.jquery4jsf.custom.progressbar;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;

public class ProgressBar extends HtmlBaseComponent implements AjaxComponent, JQueryHtmlObject {
	
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.ProgressBar";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlProgressBar";
	public static final String DEFAULT_RENDERER_TYPE = ProgressBarRenderer.RENDERER_TYPE;
	private String[] resources = null;
	private Integer value;
	private Boolean resizable;
	
	public ProgressBar() {
		super();
		resources = new String[]{
				"jquery/jquery.js",
				"ui/ui.core.js",
				"progressbar/ui.progressbar.js",
				"ui/ui.resizable.js",
				"themes/base/ui.all.css"
		};
		setRendererType(DEFAULT_RENDERER_TYPE);
	}
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public void restoreState(FacesContext context, Object state)
    {
        Object[] values = (Object[]) state;
        super.restoreState(context, values[0]);
        value=              (Integer)values[1];  
        resizable=              (Boolean)values[2];  
    }
	
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[3];
        values[0] = super.saveState(context);
        values[1] = value;
        values[2] = resizable;
        return values;
    }
    
	public void encodePartially(FacesContext facesContext) throws IOException {
	}

	public MethodBinding getOncomplete() {
		return null;
	}

	public void setOncomplete(MethodBinding methodBinding) {
	}

	public String[] getResources() {
		return resources;
	}

	public Integer getValue() {
		return (Integer) getLocalOrValueBindingValue(value, "value");
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public boolean isResizable() {
		Boolean bValue =(Boolean) getLocalOrValueBindingValue(resizable, "resizable");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setResizable(boolean resizable) {
		this.resizable = resizable ? Boolean.TRUE : Boolean.FALSE;
	}
	
	

}
