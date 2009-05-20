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
package org.jquery4jsf.custom.panel;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class PanelTag extends UIComponentTagBase {

	private String style;
	private String styleClass;
	private String header;
	private String headerClass;
	private String contentClass;

	public void release(){
		super.release();
		this.style = null;
		this.styleClass = null;
		this.header = null;
		this.headerClass = null;
		this.contentClass = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.panel.Panel component = null;
		try {
			component = (org.jquery4jsf.custom.panel.Panel) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setStringProperty(getFacesContext(), component, "header", header);
		setStringProperty(getFacesContext(), component, "headerClass", headerClass);
		setStringProperty(getFacesContext(), component, "contentClass", contentClass);
	}

	public String getComponentType() {
		return Panel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.PanelRenderer";
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setHeader(String value){
		this.header = value;
	}

	public void setHeaderClass(String value){
		this.headerClass = value;
	}

	public void setContentClass(String value){
		this.contentClass = value;
	}

}