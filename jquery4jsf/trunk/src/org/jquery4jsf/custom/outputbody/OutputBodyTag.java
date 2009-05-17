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
package org.jquery4jsf.custom.outputbody;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class OutputBodyTag extends UIComponentTagBase {

	private String dir;
	private String lang;
	private String title;
	private String xmlLang;
	private String style;
	private String styleClass;
	private String onclick;
	private String ondblclick;
	private String onload;
	private String onmousedown;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onunload;

	public void release(){
		super.release();
		this.dir = null;
		this.lang = null;
		this.title = null;
		this.xmlLang = null;
		this.style = null;
		this.styleClass = null;
		this.onclick = null;
		this.ondblclick = null;
		this.onload = null;
		this.onmousedown = null;
		this.onmousemove = null;
		this.onmouseout = null;
		this.onmouseover = null;
		this.onmouseup = null;
		this.onkeydown = null;
		this.onkeypress = null;
		this.onkeyup = null;
		this.onunload = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.outputbody.OutputBody component = null;
		try {
			component = (org.jquery4jsf.custom.outputbody.OutputBody) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "dir", dir);
		setStringProperty(getFacesContext(), component, "lang", lang);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "xmlLang", xmlLang);
		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setStringProperty(getFacesContext(), component, "onclick", onclick);
		setStringProperty(getFacesContext(), component, "ondblclick", ondblclick);
		setStringProperty(getFacesContext(), component, "onload", onload);
		setStringProperty(getFacesContext(), component, "onmousedown", onmousedown);
		setStringProperty(getFacesContext(), component, "onmousemove", onmousemove);
		setStringProperty(getFacesContext(), component, "onmouseout", onmouseout);
		setStringProperty(getFacesContext(), component, "onmouseover", onmouseover);
		setStringProperty(getFacesContext(), component, "onmouseup", onmouseup);
		setStringProperty(getFacesContext(), component, "onkeydown", onkeydown);
		setStringProperty(getFacesContext(), component, "onkeypress", onkeypress);
		setStringProperty(getFacesContext(), component, "onkeyup", onkeyup);
		setStringProperty(getFacesContext(), component, "onunload", onunload);
	}

	public String getComponentType() {
		return OutputBody.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.OutputBodyRenderer";
	}

	public void setDir(String value){
		this.dir = value;
	}

	public void setLang(String value){
		this.lang = value;
	}

	public void setTitle(String value){
		this.title = value;
	}

	public void setXmlLang(String value){
		this.xmlLang = value;
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setOnclick(String value){
		this.onclick = value;
	}

	public void setOndblclick(String value){
		this.ondblclick = value;
	}

	public void setOnload(String value){
		this.onload = value;
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

	public void setOnkeydown(String value){
		this.onkeydown = value;
	}

	public void setOnkeypress(String value){
		this.onkeypress = value;
	}

	public void setOnkeyup(String value){
		this.onkeyup = value;
	}

	public void setOnunload(String value){
		this.onunload = value;
	}

}