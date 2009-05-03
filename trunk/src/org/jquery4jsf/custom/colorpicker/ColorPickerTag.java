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

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class ColorPickerTag extends UIComponentTagBase {

	private String accesskey;
	private String alt;
	private String dir;
	private String disabled;
	private String lang;
	private String maxlength;
	private String onblur;
	private String onchange;
	private String onclick;
	private String ondblclick;
	private String onfocus;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onmousedown;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String readonly;
	private String size;
	private String style;
	private String styleClass;
	private String tabindex;
	private String title;
	private String eventName;
	private String target;
	private String color;
	private String flat;
	private String livePreview;
	private String onShow;
	private String onBeforeShow;
	private String onHide;
	private String onChange;
	private String onSubmit;

	public void release(){
		super.release();
		this.accesskey = null;
		this.alt = null;
		this.dir = null;
		this.disabled = null;
		this.lang = null;
		this.maxlength = null;
		this.onblur = null;
		this.onchange = null;
		this.onclick = null;
		this.ondblclick = null;
		this.onfocus = null;
		this.onkeydown = null;
		this.onkeypress = null;
		this.onkeyup = null;
		this.onmousedown = null;
		this.onmousemove = null;
		this.onmouseout = null;
		this.onmouseover = null;
		this.onmouseup = null;
		this.readonly = null;
		this.size = null;
		this.style = null;
		this.styleClass = null;
		this.tabindex = null;
		this.title = null;
		this.eventName = null;
		this.target = null;
		this.color = null;
		this.flat = null;
		this.livePreview = null;
		this.onShow = null;
		this.onBeforeShow = null;
		this.onHide = null;
		this.onChange = null;
		this.onSubmit = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.colorpicker.ColorPicker component = null;
		try {
			component = (org.jquery4jsf.custom.colorpicker.ColorPicker) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "accesskey", accesskey);
		setStringProperty(getFacesContext(), component, "alt", alt);
		setStringProperty(getFacesContext(), component, "dir", dir);
		setBooleanProperty(getFacesContext(), component, "disabled", disabled);
		setStringProperty(getFacesContext(), component, "lang", lang);
		setIntegerProperty(getFacesContext(), component, "maxlength", maxlength);
		setStringProperty(getFacesContext(), component, "onblur", onblur);
		setStringProperty(getFacesContext(), component, "onchange", onchange);
		setStringProperty(getFacesContext(), component, "onclick", onclick);
		setStringProperty(getFacesContext(), component, "ondblclick", ondblclick);
		setStringProperty(getFacesContext(), component, "onfocus", onfocus);
		setStringProperty(getFacesContext(), component, "onkeydown", onkeydown);
		setStringProperty(getFacesContext(), component, "onkeypress", onkeypress);
		setStringProperty(getFacesContext(), component, "onkeyup", onkeyup);
		setStringProperty(getFacesContext(), component, "onmousedown", onmousedown);
		setStringProperty(getFacesContext(), component, "onmousemove", onmousemove);
		setStringProperty(getFacesContext(), component, "onmouseout", onmouseout);
		setStringProperty(getFacesContext(), component, "onmouseover", onmouseover);
		setStringProperty(getFacesContext(), component, "onmouseup", onmouseup);
		setBooleanProperty(getFacesContext(), component, "readonly", readonly);
		setIntegerProperty(getFacesContext(), component, "size", size);
		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setStringProperty(getFacesContext(), component, "tabindex", tabindex);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "eventName", eventName);
		setStringProperty(getFacesContext(), component, "target", target);
		setStringProperty(getFacesContext(), component, "color", color);
		setBooleanProperty(getFacesContext(), component, "flat", flat);
		setBooleanProperty(getFacesContext(), component, "livePreview", livePreview);
		setStringProperty(getFacesContext(), component, "onShow", onShow);
		setStringProperty(getFacesContext(), component, "onBeforeShow", onBeforeShow);
		setStringProperty(getFacesContext(), component, "onHide", onHide);
		setStringProperty(getFacesContext(), component, "onChange", onChange);
		setStringProperty(getFacesContext(), component, "onSubmit", onSubmit);
	}

	public String getComponentType() {
		return ColorPicker.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.ColorPickerRenderer";
	}

	public void setAccesskey(String value){
		this.accesskey = value;
	}

	public void setAlt(String value){
		this.alt = value;
	}

	public void setDir(String value){
		this.dir = value;
	}

	public void setDisabled(String value){
		this.disabled = value;
	}

	public void setLang(String value){
		this.lang = value;
	}

	public void setMaxlength(String value){
		this.maxlength = value;
	}

	public void setOnblur(String value){
		this.onblur = value;
	}

	public void setOnchange(String value){
		this.onchange = value;
	}

	public void setOnclick(String value){
		this.onclick = value;
	}

	public void setOndblclick(String value){
		this.ondblclick = value;
	}

	public void setOnfocus(String value){
		this.onfocus = value;
	}

	public void setOnkeydown(String value){
		this.onkeydown = value;
	}

	public void setOnkeypress(String value){
		this.onkeypress = value;
	}

	public void setOnkeyup(String value){
		this.onkeyup = value;
	}

	public void setOnmousedown(String value){
		this.onmousedown = value;
	}

	public void setOnmousemove(String value){
		this.onmousemove = value;
	}

	public void setOnmouseout(String value){
		this.onmouseout = value;
	}

	public void setOnmouseover(String value){
		this.onmouseover = value;
	}

	public void setOnmouseup(String value){
		this.onmouseup = value;
	}

	public void setReadonly(String value){
		this.readonly = value;
	}

	public void setSize(String value){
		this.size = value;
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setTabindex(String value){
		this.tabindex = value;
	}

	public void setTitle(String value){
		this.title = value;
	}

	public void setEventName(String value){
		this.eventName = value;
	}

	public void setTarget(String value){
		this.target = value;
	}

	public void setColor(String value){
		this.color = value;
	}

	public void setFlat(String value){
		this.flat = value;
	}

	public void setLivePreview(String value){
		this.livePreview = value;
	}

	public void setOnShow(String value){
		this.onShow = value;
	}

	public void setOnBeforeShow(String value){
		this.onBeforeShow = value;
	}

	public void setOnHide(String value){
		this.onHide = value;
	}

	public void setOnChange(String value){
		this.onChange = value;
	}

	public void setOnSubmit(String value){
		this.onSubmit = value;
	}

}