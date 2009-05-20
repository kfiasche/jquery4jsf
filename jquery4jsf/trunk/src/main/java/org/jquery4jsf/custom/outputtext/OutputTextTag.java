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
package org.jquery4jsf.custom.outputtext;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class OutputTextTag extends UIComponentTagBase {

	private String value;
	private String converter;
	private String dir;
	private String lang;
	private String title;
	private String xmlLang;
	private String style;
	private String styleClass;
	private String nospan;
	private String escape;
	private String effect;
	private String eventEffect;

	public void release(){
		super.release();
		this.value = null;
		this.converter = null;
		this.dir = null;
		this.lang = null;
		this.title = null;
		this.xmlLang = null;
		this.style = null;
		this.styleClass = null;
		this.nospan = null;
		this.escape = null;
		this.effect = null;
		this.eventEffect = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.outputtext.OutputText component = null;
		try {
			component = (org.jquery4jsf.custom.outputtext.OutputText) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setValueProperty(getFacesContext(), component, "value", value);
		setConverterProperty(getFacesContext(), component, "converter", converter);
		setStringProperty(getFacesContext(), component, "dir", dir);
		setStringProperty(getFacesContext(), component, "lang", lang);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "xmlLang", xmlLang);
		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setBooleanProperty(getFacesContext(), component, "nospan", nospan);
		setBooleanProperty(getFacesContext(), component, "escape", escape);
		setStringProperty(getFacesContext(), component, "effect", effect);
		setStringProperty(getFacesContext(), component, "eventEffect", eventEffect);
	}

	public String getComponentType() {
		return OutputText.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.OutputTextRenderer";
	}

	public void setValue(String value){
		this.value = value;
	}

	public void setConverter(String value){
		this.converter = value;
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

	public void setNospan(String value){
		this.nospan = value;
	}

	public void setEscape(String value){
		this.escape = value;
	}

	public void setEffect(String value){
		this.effect = value;
	}

	public void setEventEffect(String value){
		this.eventEffect = value;
	}

}