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
package org.jquery4jsf.custom.treeview;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import org.jquery4jsf.component.ComponentUtilities;
import javax.faces.component.UIComponent;

public class HtmlTreeViewTag extends UIComponentTagBase {

	private String style;
	private String styleClass;
	private String animated;
	private String collapsed;
	private String control;
	private String unique;
	private String ontoggle;
	private String persist;
	private String cookieId;
	private String prerendered;
	private String add;

	public void release(){
		super.release();
		this.style = null;
		this.styleClass = null;
		this.animated = null;
		this.collapsed = null;
		this.control = null;
		this.unique = null;
		this.ontoggle = null;
		this.persist = null;
		this.cookieId = null;
		this.prerendered = null;
		this.add = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.treeview.HtmlTreeView component = null;
		try {
			component = (org.jquery4jsf.custom.treeview.HtmlTreeView) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		ComponentUtilities.setStringProperty(getFacesContext(), component, "style", style);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "animated", animated);
		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "collapsed", collapsed);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "control", control);
		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "unique", unique);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "ontoggle", ontoggle);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "persist", persist);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "cookieId", cookieId);
		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "prerendered", prerendered);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "add", add);
	}

	public String getComponentType() {
		return HtmlTreeView.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.HtmlTreeViewRenderer";
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setAnimated(String value){
		this.animated = value;
	}

	public void setCollapsed(String value){
		this.collapsed = value;
	}

	public void setControl(String value){
		this.control = value;
	}

	public void setUnique(String value){
		this.unique = value;
	}

	public void setOntoggle(String value){
		this.ontoggle = value;
	}

	public void setPersist(String value){
		this.persist = value;
	}

	public void setCookieId(String value){
		this.cookieId = value;
	}

	public void setPrerendered(String value){
		this.prerendered = value;
	}

	public void setAdd(String value){
		this.add = value;
	}

}