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
package org.jquery4jsf.custom.accordion;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class AccordionSubPanelTag extends UIComponentTagBase {

	private String headerClass;
	private String headerStyle;
	private String contentClass;
	private String contentStyle;
	private String panelName;

	public void release(){
		super.release();
		this.headerClass = null;
		this.headerStyle = null;
		this.contentClass = null;
		this.contentStyle = null;
		this.panelName = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.accordion.AccordionSubPanel component = null;
		try {
			component = (org.jquery4jsf.custom.accordion.AccordionSubPanel) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "headerClass", headerClass);
		setStringProperty(getFacesContext(), component, "headerStyle", headerStyle);
		setStringProperty(getFacesContext(), component, "contentClass", contentClass);
		setStringProperty(getFacesContext(), component, "contentStyle", contentStyle);
		setStringProperty(getFacesContext(), component, "panelName", panelName);
	}

	public String getComponentType() {
		return AccordionSubPanel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.AccordionSubPanelRenderer";
	}

	public void setHeaderClass(String value){
		this.headerClass = value;
	}

	public void setHeaderStyle(String value){
		this.headerStyle = value;
	}

	public void setContentClass(String value){
		this.contentClass = value;
	}

	public void setContentStyle(String value){
		this.contentStyle = value;
	}

	public void setPanelName(String value){
		this.panelName = value;
	}

}