/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
/*
 *
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
package org.jquery4jsf.custom.button;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class ButtonTag extends UIComponentTagBase {

	private String value;
	private String actionListener;
	private String action;
	private String immediate;
	private String accesskey;
	private String alt;
	private String dir;
	private String disabled;
	private String image;
	private String lang;
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
	private String onselect;
	private String readonly;
	private String style;
	private String styleClass;
	private String tabindex;
	private String title;
	private String type;
	private String partialSubmit;
	private String target;
	private String url;
	private String typeSubmit;
	private String onbeforeSubmit;
	private String onsuccess;
	private String dataType;
	private String semantic;
	private String resetForm;
	private String clearForm;
	private String iframe;

	public void release(){
		super.release();
		this.value = null;
		this.actionListener = null;
		this.action = null;
		this.immediate = null;
		this.accesskey = null;
		this.alt = null;
		this.dir = null;
		this.disabled = null;
		this.image = null;
		this.lang = null;
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
		this.onselect = null;
		this.readonly = null;
		this.style = null;
		this.styleClass = null;
		this.tabindex = null;
		this.title = null;
		this.type = null;
		this.partialSubmit = null;
		this.target = null;
		this.url = null;
		this.typeSubmit = null;
		this.onbeforeSubmit = null;
		this.onsuccess = null;
		this.dataType = null;
		this.semantic = null;
		this.resetForm = null;
		this.clearForm = null;
		this.iframe = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.button.Button component = null;
		try {
			component = (org.jquery4jsf.custom.button.Button) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setValueProperty(getFacesContext(), component, "value", value);
		setActionListenerProperty(getFacesContext(), component, "actionListener", actionListener);
		setActionProperty(getFacesContext(), component, "action", action);
		setBooleanProperty(getFacesContext(), component, "immediate", immediate);
		setStringProperty(getFacesContext(), component, "accesskey", accesskey);
		setStringProperty(getFacesContext(), component, "alt", alt);
		setStringProperty(getFacesContext(), component, "dir", dir);
		setBooleanProperty(getFacesContext(), component, "disabled", disabled);
		setStringProperty(getFacesContext(), component, "image", image);
		setStringProperty(getFacesContext(), component, "lang", lang);
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
		setStringProperty(getFacesContext(), component, "onselect", onselect);
		setBooleanProperty(getFacesContext(), component, "readonly", readonly);
		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setStringProperty(getFacesContext(), component, "tabindex", tabindex);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "type", type);
		setBooleanProperty(getFacesContext(), component, "partialSubmit", partialSubmit);
		setStringProperty(getFacesContext(), component, "target", target);
		setStringProperty(getFacesContext(), component, "url", url);
		setStringProperty(getFacesContext(), component, "typeSubmit", typeSubmit);
		setStringProperty(getFacesContext(), component, "onbeforeSubmit", onbeforeSubmit);
		setStringProperty(getFacesContext(), component, "onsuccess", onsuccess);
		setStringProperty(getFacesContext(), component, "dataType", dataType);
		setBooleanProperty(getFacesContext(), component, "semantic", semantic);
		setBooleanProperty(getFacesContext(), component, "resetForm", resetForm);
		setBooleanProperty(getFacesContext(), component, "clearForm", clearForm);
		setBooleanProperty(getFacesContext(), component, "iframe", iframe);
	}

	public String getComponentType() {
		return Button.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.ButtonRenderer";
	}

	public void setValue(String value){
		this.value = value;
	}

	public void setActionListener(String value){
		this.actionListener = value;
	}

	public void setAction(String value){
		this.action = value;
	}

	public void setImmediate(String value){
		this.immediate = value;
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

	public void setImage(String value){
		this.image = value;
	}

	public void setLang(String value){
		this.lang = value;
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

	public void setOnselect(String value){
		this.onselect = value;
	}

	public void setReadonly(String value){
		this.readonly = value;
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

	public void setType(String value){
		this.type = value;
	}

	public void setPartialSubmit(String value){
		this.partialSubmit = value;
	}

	public void setTarget(String value){
		this.target = value;
	}

	public void setUrl(String value){
		this.url = value;
	}

	public void setTypeSubmit(String value){
		this.typeSubmit = value;
	}

	public void setOnbeforeSubmit(String value){
		this.onbeforeSubmit = value;
	}

	public void setOnsuccess(String value){
		this.onsuccess = value;
	}

	public void setDataType(String value){
		this.dataType = value;
	}

	public void setSemantic(String value){
		this.semantic = value;
	}

	public void setResetForm(String value){
		this.resetForm = value;
	}

	public void setClearForm(String value){
		this.clearForm = value;
	}

	public void setIframe(String value){
		this.iframe = value;
	}

}