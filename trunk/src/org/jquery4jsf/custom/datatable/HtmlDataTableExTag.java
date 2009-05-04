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
package org.jquery4jsf.custom.datatable;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class HtmlDataTableExTag extends UIComponentTagBase {

	private String value;
	private String var;
	private String rows;
	private String first;
	private String style;
	private String styleClass;

	public void release(){
		super.release();
		this.value = null;
		this.var = null;
		this.rows = null;
		this.first = null;
		this.style = null;
		this.styleClass = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.datatable.HtmlDataTableEx component = null;
		try {
			component = (org.jquery4jsf.custom.datatable.HtmlDataTableEx) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setValueProperty(getFacesContext(), component, "value", value);
		setStringProperty(getFacesContext(), component, "var", var);
		setIntegerProperty(getFacesContext(), component, "rows", rows);
		setIntegerProperty(getFacesContext(), component, "first", first);
		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
	}

	public String getComponentType() {
		return HtmlDataTableEx.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.HtmlDataTableExRenderer";
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

}