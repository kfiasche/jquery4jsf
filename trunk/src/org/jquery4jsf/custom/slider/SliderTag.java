package org.jquery4jsf.custom.slider;

import javax.faces.component.UIComponent;

import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class SliderTag extends UIComponentTagBase {

	private String animate;
	private String max;
	private String min;
	private String orientation;
	private String range;
	private String step;
	private String value;
	private String values;
	
	public String getComponentType() {
		return Slider.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return Slider.DEFAULT_RENDERER_TYPE;
	}
	
	public void release(){
		super.release();
		animate    = null;
		max        = null;
		min        = null;
		orientation= null;
		range      = null;
		step       = null;
		value      = null;
		values     = null;
	}

	public void setAnimate(String animate) {
		this.animate = animate;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setValues(String values) {
		this.values = values;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		setBooleanProperty(getFacesContext(), component, "animate", animate);
		setIntegerProperty(getFacesContext(), component, "max", max);
		setIntegerProperty(getFacesContext(), component, "min", min);
		setStringProperty(getFacesContext(), component, "orientation",orientation);
		setStringProperty(getFacesContext(), component, "range",range);
		setIntegerProperty(getFacesContext(), component, "step",step);
		setIntegerProperty(getFacesContext(), component, "value",value);
		setStringProperty(getFacesContext(), component, "values",values);
	}

}
