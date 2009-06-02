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
package org.jquery4jsf.custom.outputbarcode;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class OutputBarcodeTag extends UIComponentTagBase {

	private String barWidth;
	private String barHeight;
	private String showHRI;
	private String bgColor;
	private String color;
	private String fontSize;
	private String type;
	private String value;

	public void release(){
		super.release();
		this.barWidth = null;
		this.barHeight = null;
		this.showHRI = null;
		this.bgColor = null;
		this.color = null;
		this.fontSize = null;
		this.type = null;
		this.value = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.outputbarcode.OutputBarcode component = null;
		try {
			component = (org.jquery4jsf.custom.outputbarcode.OutputBarcode) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setIntegerProperty(getFacesContext(), component, "barWidth", barWidth);
		setIntegerProperty(getFacesContext(), component, "barHeight", barHeight);
		setBooleanProperty(getFacesContext(), component, "showHRI", showHRI);
		setStringProperty(getFacesContext(), component, "bgColor", bgColor);
		setStringProperty(getFacesContext(), component, "color", color);
		setStringProperty(getFacesContext(), component, "fontSize", fontSize);
		setStringProperty(getFacesContext(), component, "type", type);
		setValueProperty(getFacesContext(), component, "value", value);
	}

	public String getComponentType() {
		return OutputBarcode.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.OutputBarcodeRenderer";
	}

	public void setBarWidth(String value){
		this.barWidth = value;
	}

	public void setBarHeight(String value){
		this.barHeight = value;
	}

	public void setShowHRI(String value){
		this.showHRI = value;
	}

	public void setBgColor(String value){
		this.bgColor = value;
	}

	public void setColor(String value){
		this.color = value;
	}

	public void setFontSize(String value){
		this.fontSize = value;
	}

	public void setType(String value){
		this.type = value;
	}

	public void setValue(String value){
		this.value = value;
	}

}