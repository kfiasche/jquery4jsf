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
package org.jquery4jsf.custom.tabbedpanel;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBodyBase;
import org.jquery4jsf.component.ComponentUtilities;
import javax.faces.component.UIComponent;

public class TabbedPanelTag extends UIComponentTagBodyBase {

	private String cache;
	private String collapsible;
	private String cookie;
	private String deselectable;
	private String event;
	private String fx;
	private String idPrefix;
	private String selected;
	private String spinner;

	public void release(){
		super.release();
		this.cache = null;
		this.collapsible = null;
		this.cookie = null;
		this.deselectable = null;
		this.event = null;
		this.fx = null;
		this.idPrefix = null;
		this.selected = null;
		this.spinner = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.tabbedpanel.TabbedPanel component = null;
		try {
			component = (org.jquery4jsf.custom.tabbedpanel.TabbedPanel) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "cache", cache);
		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "collapsible", collapsible);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "cookie", cookie);
		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "deselectable", deselectable);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "event", event);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "fx", fx);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "idPrefix", idPrefix);
		ComponentUtilities.setIntegerProperty(getFacesContext(), component, "selected", selected);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "spinner", spinner);
	}

	public String getComponentType() {
		return TabbedPanel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.TabbedPanelRenderer";
	}

	public void setCache(String value){
		this.cache = value;
	}

	public void setCollapsible(String value){
		this.collapsible = value;
	}

	public void setCookie(String value){
		this.cookie = value;
	}

	public void setDeselectable(String value){
		this.deselectable = value;
	}

	public void setEvent(String value){
		this.event = value;
	}

	public void setFx(String value){
		this.fx = value;
	}

	public void setIdPrefix(String value){
		this.idPrefix = value;
	}

	public void setSelected(String value){
		this.selected = value;
	}

	public void setSpinner(String value){
		this.spinner = value;
	}

}