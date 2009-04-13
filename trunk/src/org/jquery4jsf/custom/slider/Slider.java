package org.jquery4jsf.custom.slider;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;

public class Slider extends HtmlBaseComponent implements JQueryHtmlObject, AjaxComponent {
	
	public static final String DEFAULT_RENDERER_TYPE = SliderRenderer.RENDERER_TYPE;
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Slider";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlSlider";
	
	private String[] resources;
	private Boolean animate;
	private Integer max;
	private Integer min;
	private String orientation;
	private String range;
	private Integer step;
	private Integer value;
	private String values;
	
	public Slider() {
		super();
		resources = new String[]{
				"jquery/jquery.js",
				"ui/ui.core.js",
				"ui/ui.resizable.js",
				"slider/ui.slider.js",
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
		animate=(Boolean)values[1];  
		max=(Integer)values[2];  
		min=(Integer)values[3];  
		orientation=(String)values[4];  
		range=(String)values[5];  
		step=(Integer)values[6];  
		value=(Integer)values[7];  
		this.values=(String)values[8];  
    }
	
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[9];
        values[0] = super.saveState(context);
        values[1] = animate;
        values[2] = max;
        values[3] = min;
        values[4] = orientation;
        values[5] = range;
        values[6] = step;
        values[7] = value;
        values[8] = this.values;
        return values;
    }
	
	public String[] getResources() {
		return resources;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
	}

	public MethodBinding getOncomplete() {
		return null;
	}

	public void setOncomplete(MethodBinding methodBinding) {
	}

	public boolean isAnimate() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(animate, "animate");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setAnimate(boolean animate) {
		this.animate = animate ? Boolean.TRUE : Boolean.FALSE;
	}

	public Integer getMax() {
		return (Integer) getLocalOrValueBindingValue(max, "max");
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return (Integer) getLocalOrValueBindingValue(min, "min");
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public String getOrientation() {
		return (String) getLocalOrValueBindingValue(orientation, "orientation");
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getRange() {
		return (String) getLocalOrValueBindingValue(range, "range");
	}

	public void setRange(String range) {
		this.range = range;
	}

	public Integer getStep() {
		return (Integer) getLocalOrValueBindingValue(step, "step");
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Integer getValue() {
		return (Integer) getLocalOrValueBindingValue(value, "value");
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getValues() {
		return (String) getLocalOrValueBindingValue(values, "values");
	}

	public void setValues(String values) {
		this.values = values;
	}

	public void setResources(String[] resources) {
		this.resources = resources;
	}
	
	

}
