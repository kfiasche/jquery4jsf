/*
 
*  Copyright (c) 2009 Giuseppe Trisciuoglio 
* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jquery4jsf.custom.slider;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class SliderTag extends UIComponentTagBase {

	private String animate;
	private String max;
	private String min;
	private String orientation;
	private String range;
	private String step;
	private String sliderValue;
	private String values;
	private String onstart;
	private String onslide;
	private String onchange;
	private String onstop;

	public void release(){
		super.release();
		this.animate = null;
		this.max = null;
		this.min = null;
		this.orientation = null;
		this.range = null;
		this.step = null;
		this.sliderValue = null;
		this.values = null;
		this.onstart = null;
		this.onslide = null;
		this.onchange = null;
		this.onstop = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.slider.Slider component = null;
		try {
			component = (org.jquery4jsf.custom.slider.Slider) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setBooleanProperty(getFacesContext(), component, "animate", animate);
		setIntegerProperty(getFacesContext(), component, "max", max);
		setIntegerProperty(getFacesContext(), component, "min", min);
		setStringProperty(getFacesContext(), component, "orientation", orientation);
		setStringProperty(getFacesContext(), component, "range", range);
		setIntegerProperty(getFacesContext(), component, "step", step);
		setIntegerProperty(getFacesContext(), component, "sliderValue", sliderValue);
		setStringProperty(getFacesContext(), component, "values", values);
		setStringProperty(getFacesContext(), component, "onstart", onstart);
		setStringProperty(getFacesContext(), component, "onslide", onslide);
		setStringProperty(getFacesContext(), component, "onchange", onchange);
		setStringProperty(getFacesContext(), component, "onstop", onstop);
	}

	public String getComponentType() {
		return Slider.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.SliderRenderer";
	}

	public void setAnimate(String value){
		this.animate = value;
	}

	public void setMax(String value){
		this.max = value;
	}

	public void setMin(String value){
		this.min = value;
	}

	public void setOrientation(String value){
		this.orientation = value;
	}

	public void setRange(String value){
		this.range = value;
	}

	public void setStep(String value){
		this.step = value;
	}

	public void setSliderValue(String value){
		this.sliderValue = value;
	}

	public void setValues(String value){
		this.values = value;
	}

	public void setOnstart(String value){
		this.onstart = value;
	}

	public void setOnslide(String value){
		this.onslide = value;
	}

	public void setOnchange(String value){
		this.onchange = value;
	}

	public void setOnstop(String value){
		this.onstop = value;
	}

}