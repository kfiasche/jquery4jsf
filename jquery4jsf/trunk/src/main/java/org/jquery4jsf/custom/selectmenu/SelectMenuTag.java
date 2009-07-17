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
package org.jquery4jsf.custom.selectmenu;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class SelectMenuTag extends UIComponentTagBase {

	private String _for;
	private String transferClasses;
	private String styleType;
	private String width;
	private String menuWidth;
	private String handleWidth;
	private String icons;
	private String format;
	private String onopen;
	private String onclose;
	private String onchange;
	private String onselect;

	public void release(){
		super.release();
		this._for = null;
		this.transferClasses = null;
		this.styleType = null;
		this.width = null;
		this.menuWidth = null;
		this.handleWidth = null;
		this.icons = null;
		this.format = null;
		this.onopen = null;
		this.onclose = null;
		this.onchange = null;
		this.onselect = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.selectmenu.SelectMenu component = null;
		try {
			component = (org.jquery4jsf.custom.selectmenu.SelectMenu) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "for", _for);
		setStringProperty(getFacesContext(), component, "transferClasses", transferClasses);
		setStringProperty(getFacesContext(), component, "styleType", styleType);
		setIntegerProperty(getFacesContext(), component, "width", width);
		setIntegerProperty(getFacesContext(), component, "menuWidth", menuWidth);
		setIntegerProperty(getFacesContext(), component, "handleWidth", handleWidth);
		setStringProperty(getFacesContext(), component, "icons", icons);
		setStringProperty(getFacesContext(), component, "format", format);
		setStringProperty(getFacesContext(), component, "onopen", onopen);
		setStringProperty(getFacesContext(), component, "onclose", onclose);
		setStringProperty(getFacesContext(), component, "onchange", onchange);
		setStringProperty(getFacesContext(), component, "onselect", onselect);
	}

	public String getComponentType() {
		return SelectMenu.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.SelectMenuRenderer";
	}

	public void setFor(String value){
		this._for = value;
	}

	public void setTransferClasses(String value){
		this.transferClasses = value;
	}

	public void setStyleType(String value){
		this.styleType = value;
	}

	public void setWidth(String value){
		this.width = value;
	}

	public void setMenuWidth(String value){
		this.menuWidth = value;
	}

	public void setHandleWidth(String value){
		this.handleWidth = value;
	}

	public void setIcons(String value){
		this.icons = value;
	}

	public void setFormat(String value){
		this.format = value;
	}

	public void setOnopen(String value){
		this.onopen = value;
	}

	public void setOnclose(String value){
		this.onclose = value;
	}

	public void setOnchange(String value){
		this.onchange = value;
	}

	public void setOnselect(String value){
		this.onselect = value;
	}

}