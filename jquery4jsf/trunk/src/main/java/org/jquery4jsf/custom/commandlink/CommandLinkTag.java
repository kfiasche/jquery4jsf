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
package org.jquery4jsf.custom.commandlink;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class CommandLinkTag extends UIComponentTagBase {

	private String value;
	private String actionListener;
	private String action;
	private String immediate;
	private String dir;
	private String lang;
	private String title;
	private String xmlLang;
	private String target;
	private String charset;
	private String coords;
	private String hreflang;
	private String name;
	private String rel;
	private String rev;
	private String shape;

	public void release(){
		super.release();
		this.value = null;
		this.actionListener = null;
		this.action = null;
		this.immediate = null;
		this.dir = null;
		this.lang = null;
		this.title = null;
		this.xmlLang = null;
		this.target = null;
		this.charset = null;
		this.coords = null;
		this.hreflang = null;
		this.name = null;
		this.rel = null;
		this.rev = null;
		this.shape = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.commandlink.CommandLink component = null;
		try {
			component = (org.jquery4jsf.custom.commandlink.CommandLink) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setValueProperty(getFacesContext(), component, "value", value);
		setActionListenerProperty(getFacesContext(), component, "actionListener", actionListener);
		setActionProperty(getFacesContext(), component, "action", action);
		setBooleanProperty(getFacesContext(), component, "immediate", immediate);
		setStringProperty(getFacesContext(), component, "dir", dir);
		setStringProperty(getFacesContext(), component, "lang", lang);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "xmlLang", xmlLang);
		setStringProperty(getFacesContext(), component, "target", target);
		setStringProperty(getFacesContext(), component, "charset", charset);
		setStringProperty(getFacesContext(), component, "coords", coords);
		setStringProperty(getFacesContext(), component, "hreflang", hreflang);
		setStringProperty(getFacesContext(), component, "name", name);
		setStringProperty(getFacesContext(), component, "rel", rel);
		setStringProperty(getFacesContext(), component, "rev", rev);
		setStringProperty(getFacesContext(), component, "shape", shape);
	}

	public String getComponentType() {
		return CommandLink.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.CommandLinkRenderer";
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

	public void setTarget(String value){
		this.target = value;
	}

	public void setCharset(String value){
		this.charset = value;
	}

	public void setCoords(String value){
		this.coords = value;
	}

	public void setHreflang(String value){
		this.hreflang = value;
	}

	public void setName(String value){
		this.name = value;
	}

	public void setRel(String value){
		this.rel = value;
	}

	public void setRev(String value){
		this.rev = value;
	}

	public void setShape(String value){
		this.shape = value;
	}

}