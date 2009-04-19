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
package org.jquery4jsf.custom.accordion;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class AccordionPanelTag extends UIComponentTagBase {

	private String active;
	private String animated;
	private String autoHeight;
	private String clearStyle;
	private String collapsible;
	private String event;
	private String fillSpace;
	private String icons;
	private String navigation;
	private String header;
	private String navigationFilter;
	private String onaccordionchange;

	public void release(){
		super.release();
		this.active = null;
		this.animated = null;
		this.autoHeight = null;
		this.clearStyle = null;
		this.collapsible = null;
		this.event = null;
		this.fillSpace = null;
		this.icons = null;
		this.navigation = null;
		this.header = null;
		this.navigationFilter = null;
		this.onaccordionchange = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.accordion.AccordionPanel component = null;
		try {
			component = (org.jquery4jsf.custom.accordion.AccordionPanel) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setIntegerProperty(getFacesContext(), component, "active", active);
		setStringProperty(getFacesContext(), component, "animated", animated);
		setBooleanProperty(getFacesContext(), component, "autoHeight", autoHeight);
		setBooleanProperty(getFacesContext(), component, "clearStyle", clearStyle);
		setBooleanProperty(getFacesContext(), component, "collapsible", collapsible);
		setStringProperty(getFacesContext(), component, "event", event);
		setBooleanProperty(getFacesContext(), component, "fillSpace", fillSpace);
		setStringProperty(getFacesContext(), component, "icons", icons);
		setBooleanProperty(getFacesContext(), component, "navigation", navigation);
		setStringProperty(getFacesContext(), component, "header", header);
		setStringProperty(getFacesContext(), component, "navigationFilter", navigationFilter);
		setStringProperty(getFacesContext(), component, "onaccordionchange", onaccordionchange);
	}

	public String getComponentType() {
		return AccordionPanel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.AccordionPanelRenderer";
	}

	public void setActive(String value){
		this.active = value;
	}

	public void setAnimated(String value){
		this.animated = value;
	}

	public void setAutoHeight(String value){
		this.autoHeight = value;
	}

	public void setClearStyle(String value){
		this.clearStyle = value;
	}

	public void setCollapsible(String value){
		this.collapsible = value;
	}

	public void setEvent(String value){
		this.event = value;
	}

	public void setFillSpace(String value){
		this.fillSpace = value;
	}

	public void setIcons(String value){
		this.icons = value;
	}

	public void setNavigation(String value){
		this.navigation = value;
	}

	public void setHeader(String value){
		this.header = value;
	}

	public void setNavigationFilter(String value){
		this.navigationFilter = value;
	}

	public void setOnaccordionchange(String value){
		this.onaccordionchange = value;
	}

}