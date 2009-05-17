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
package org.jquery4jsf.custom.colorpicker;

import org.jquery4jsf.component.ext.HtmlInputText;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;

public class ColorPicker extends HtmlInputText implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlColorPicker";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.ColorPicker";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.ColorPickerRenderer";

	private String[] resources;
	private String eventName;
	private String target;
	private String color;
	private Boolean flat;
	private Boolean livePreview;
	private String onShow;
	private String onBeforeShow;
	private String onHide;
	private String onChange;
	private String onSubmit;

	public ColorPicker() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"colorpicker/ui.colorpicker.js",
			"colorpicker/ui.colorpicker.css",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getEventName() {
		if(eventName != null )
			return eventName;

		String oValue = (String) getLocalOrValueBindingValue(eventName, "eventName");
		return oValue != null ? oValue : null;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getTarget() {
		if(target != null )
			return target;

		String oValue = (String) getLocalOrValueBindingValue(target, "target");
		return oValue != null ? oValue : null;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public String getColor() {
		if(color != null )
			return color;

		String oValue = (String) getLocalOrValueBindingValue(color, "color");
		return oValue != null ? oValue : null;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFlat() {
		if(flat != null )
			return flat.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(flat, "flat");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setFlat(boolean flat) {
		this.flat = new Boolean(flat);
	}

	public boolean isLivePreview() {
		if(livePreview != null )
			return livePreview.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(livePreview, "livePreview");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setLivePreview(boolean livePreview) {
		this.livePreview = new Boolean(livePreview);
	}

	public String getOnShow() {
		if(onShow != null )
			return onShow;

		String oValue = (String) getLocalOrValueBindingValue(onShow, "onShow");
		return oValue != null ? oValue : null;
	}
	public void setOnShow(String onShow) {
		this.onShow = onShow;
	}

	public String getOnBeforeShow() {
		if(onBeforeShow != null )
			return onBeforeShow;

		String oValue = (String) getLocalOrValueBindingValue(onBeforeShow, "onBeforeShow");
		return oValue != null ? oValue : null;
	}
	public void setOnBeforeShow(String onBeforeShow) {
		this.onBeforeShow = onBeforeShow;
	}

	public String getOnHide() {
		if(onHide != null )
			return onHide;

		String oValue = (String) getLocalOrValueBindingValue(onHide, "onHide");
		return oValue != null ? oValue : null;
	}
	public void setOnHide(String onHide) {
		this.onHide = onHide;
	}

	public String getOnChange() {
		if(onChange != null )
			return onChange;

		String oValue = (String) getLocalOrValueBindingValue(onChange, "onChange");
		return oValue != null ? oValue : null;
	}
	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	public String getOnSubmit() {
		if(onSubmit != null )
			return onSubmit;

		String oValue = (String) getLocalOrValueBindingValue(onSubmit, "onSubmit");
		return oValue != null ? oValue : null;
	}
	public void setOnSubmit(String onSubmit) {
		this.onSubmit = onSubmit;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[11];
		values[0] = super.saveState(context);
		values[1] = eventName;
		values[2] = target;
		values[3] = color;
		values[4] = flat;
		values[5] = livePreview;
		values[6] = onShow;
		values[7] = onBeforeShow;
		values[8] = onHide;
		values[9] = onChange;
		values[10] = onSubmit;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.eventName = (String) values[1];
		this.target = (String) values[2];
		this.color = (String) values[3];
		this.flat = (Boolean) values[4];
		this.livePreview = (Boolean) values[5];
		this.onShow = (String) values[6];
		this.onBeforeShow = (String) values[7];
		this.onHide = (String) values[8];
		this.onChange = (String) values[9];
		this.onSubmit = (String) values[10];
	}

	public String[] getResources() {
		return resources;
	}
	public void processUpdates(FacesContext context) {
		if (!isRendered())
		{
			return;
		}
		try {
			ValueBinding vb = getValueBinding("color");
			if (vb != null) {
				vb.setValue(context, this.color);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.processUpdates(context);
	}

	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}