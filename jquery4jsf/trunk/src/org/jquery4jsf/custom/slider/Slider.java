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

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;

public class Slider extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlSlider";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Slider";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.SliderRenderer";

	private String[] resources;
	private Boolean animate;
	private Integer max;
	private Integer min;
	private String orientation;
	private String range;
	private Integer step;
	private Integer sliderValue;
	private String values;
	private String onstart;
	private String onslide;
	private String onchange;
	private String onstop;

	public Slider() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"slider/ui.slider.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isAnimate() {
		if(animate != null )
			return animate.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(animate, "animate");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAnimate(boolean animate) {
		this.animate = new Boolean(animate);
	}

	public int getMax() {
		if(max != null )
			return max.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(max, "max");
		return oValue != null ? oValue.intValue()  : 100;
	}
	public void setMax(int max) {
		this.max = new Integer(max);
	}

	public int getMin() {
		if(min != null )
			return min.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(min, "min");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMin(int min) {
		this.min = new Integer(min);
	}

	public String getOrientation() {
		if(orientation != null )
			return orientation;

		String oValue = (String) getLocalOrValueBindingValue(orientation, "orientation");
		return oValue != null ? oValue : "auto";
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getRange() {
		if(range != null )
			return range;

		String oValue = (String) getLocalOrValueBindingValue(range, "range");
		return oValue != null ? oValue : null;
	}
	public void setRange(String range) {
		this.range = range;
	}

	public int getStep() {
		if(step != null )
			return step.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(step, "step");
		return oValue != null ? oValue.intValue()  : 1;
	}
	public void setStep(int step) {
		this.step = new Integer(step);
	}

	public int getSliderValue() {
		if(sliderValue != null )
			return sliderValue.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(sliderValue, "sliderValue");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setSliderValue(int sliderValue) {
		this.sliderValue = new Integer(sliderValue);
	}

	public String getValues() {
		if(values != null )
			return values;

		String oValue = (String) getLocalOrValueBindingValue(values, "values");
		return oValue != null ? oValue : null;
	}
	public void setValues(String values) {
		this.values = values;
	}

	public String getOnstart() {
		if(onstart != null )
			return onstart;

		String oValue = (String) getLocalOrValueBindingValue(onstart, "onstart");
		return oValue != null ? oValue : null;
	}
	public void setOnstart(String onstart) {
		this.onstart = onstart;
	}

	public String getOnslide() {
		if(onslide != null )
			return onslide;

		String oValue = (String) getLocalOrValueBindingValue(onslide, "onslide");
		return oValue != null ? oValue : null;
	}
	public void setOnslide(String onslide) {
		this.onslide = onslide;
	}

	public String getOnchange() {
		if(onchange != null )
			return onchange;

		String oValue = (String) getLocalOrValueBindingValue(onchange, "onchange");
		return oValue != null ? oValue : null;
	}
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnstop() {
		if(onstop != null )
			return onstop;

		String oValue = (String) getLocalOrValueBindingValue(onstop, "onstop");
		return oValue != null ? oValue : null;
	}
	public void setOnstop(String onstop) {
		this.onstop = onstop;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[13];
		values[0] = super.saveState(context);
		values[1] = animate;
		values[2] = max;
		values[3] = min;
		values[4] = orientation;
		values[5] = range;
		values[6] = step;
		values[7] = sliderValue;
		values[8] = values;
		values[9] = onstart;
		values[10] = onslide;
		values[11] = onchange;
		values[12] = onstop;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.animate = (Boolean) values[1];
		this.max = (Integer) values[2];
		this.min = (Integer) values[3];
		this.orientation = (String) values[4];
		this.range = (String) values[5];
		this.step = (Integer) values[6];
		this.sliderValue = (Integer) values[7];
		this.values = (String) values[8];
		this.onstart = (String) values[9];
		this.onslide = (String) values[10];
		this.onchange = (String) values[11];
		this.onstop = (String) values[12];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}