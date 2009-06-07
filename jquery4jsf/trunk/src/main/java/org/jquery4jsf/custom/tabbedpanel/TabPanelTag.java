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

public class TabPanelTag extends UIComponentTagBodyBase {

	private String disabled;
	private String tabName;

	public void release(){
		super.release();
		this.disabled = null;
		this.tabName = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.tabbedpanel.TabPanel component = null;
		try {
			component = (org.jquery4jsf.custom.tabbedpanel.TabPanel) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "disabled", disabled);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "tabName", tabName);
	}

	public String getComponentType() {
		return TabPanel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return null;
	}

	public void setDisabled(String value){
		this.disabled = value;
	}

	public void setTabName(String value){
		this.tabName = value;
	}

}