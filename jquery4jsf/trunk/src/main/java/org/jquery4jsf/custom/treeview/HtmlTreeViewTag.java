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

	private String value;
	private String var;
	private String rows;
	private String first;
	private String style;
	private String styleClass;
	private String dataAsync;
	private String onAsyncData;
	private String selected;
	private String opened;
	private String cookies;
	private String languages;
	private String path;
	private String uidots;
	private String uirtl;
	private String uianimation;
	private String uihovermode;
	private String uiscrollspd;
	private String uithemepath;
	private String uithemename;

	public void release(){
		super.release();
		this.value = null;
		this.var = null;
		this.rows = null;
		this.first = null;
		this.style = null;
		this.styleClass = null;
		this.dataAsync = null;
		this.onAsyncData = null;
		this.selected = null;
		this.opened = null;
		this.cookies = null;
		this.languages = null;
		this.path = null;
		this.uidots = null;
		this.uirtl = null;
		this.uianimation = null;
		this.uihovermode = null;
		this.uiscrollspd = null;
		this.uithemepath = null;
		this.uithemename = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.treeview.HtmlTreeView component = null;
		try {
			component = (org.jquery4jsf.custom.treeview.HtmlTreeView) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		ComponentUtilities.setValueProperty(getFacesContext(), component, "value", value);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "var", var);
		ComponentUtilities.setIntegerProperty(getFacesContext(), component, "rows", rows);
		ComponentUtilities.setIntegerProperty(getFacesContext(), component, "first", first);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "style", style);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "dataAsync", dataAsync);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "onAsyncData", onAsyncData);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "selected", selected);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "opened", opened);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "cookies", cookies);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "languages", languages);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "path", path);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "uidots", uidots);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "uirtl", uirtl);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "uianimation", uianimation);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "uihovermode", uihovermode);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "uiscrollspd", uiscrollspd);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "uithemepath", uithemepath);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "uithemename", uithemename);
	}

	public String getComponentType() {
		return HtmlTreeView.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.HtmlTreeViewRenderer";
	}

	public void setValue(String value){
		this.value = value;
	}

	public void setVar(String value){
		this.var = value;
	}

	public void setRows(String value){
		this.rows = value;
	}

	public void setFirst(String value){
		this.first = value;
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setDataAsync(String value){
		this.dataAsync = value;
	}

	public void setOnAsyncData(String value){
		this.onAsyncData = value;
	}

	public void setSelected(String value){
		this.selected = value;
	}

	public void setOpened(String value){
		this.opened = value;
	}

	public void setCookies(String value){
		this.cookies = value;
	}

	public void setLanguages(String value){
		this.languages = value;
	}

	public void setPath(String value){
		this.path = value;
	}

	public void setUidots(String value){
		this.uidots = value;
	}

	public void setUirtl(String value){
		this.uirtl = value;
	}

	public void setUianimation(String value){
		this.uianimation = value;
	}

	public void setUihovermode(String value){
		this.uihovermode = value;
	}

	public void setUiscrollspd(String value){
		this.uiscrollspd = value;
	}

	public void setUithemepath(String value){
		this.uithemepath = value;
	}

	public void setUithemename(String value){
		this.uithemename = value;
	}

}