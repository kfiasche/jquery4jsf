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
package org.jquery4jsf.custom.simplyscroll;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class SimplyScrollTag extends UIComponentTagBase {

	private String style;
	private String styleClass;
	private String className;
	private String frameRate;
	private String speed;
	private String horizontal;
	private String autoMode;
	private String pauseOnHover;
	private String jsonSource;
	private String customContent;

	public void release(){
		super.release();
		this.style = null;
		this.styleClass = null;
		this.className = null;
		this.frameRate = null;
		this.speed = null;
		this.horizontal = null;
		this.autoMode = null;
		this.pauseOnHover = null;
		this.jsonSource = null;
		this.customContent = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.simplyscroll.SimplyScroll component = null;
		try {
			component = (org.jquery4jsf.custom.simplyscroll.SimplyScroll) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setStringProperty(getFacesContext(), component, "className", className);
		setIntegerProperty(getFacesContext(), component, "frameRate", frameRate);
		setIntegerProperty(getFacesContext(), component, "speed", speed);
		setBooleanProperty(getFacesContext(), component, "horizontal", horizontal);
		setStringProperty(getFacesContext(), component, "autoMode", autoMode);
		setBooleanProperty(getFacesContext(), component, "pauseOnHover", pauseOnHover);
		setStringProperty(getFacesContext(), component, "jsonSource", jsonSource);
		setBooleanProperty(getFacesContext(), component, "customContent", customContent);
	}

	public String getComponentType() {
		return SimplyScroll.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.SimplyScrollRenderer";
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setClassName(String value){
		this.className = value;
	}

	public void setFrameRate(String value){
		this.frameRate = value;
	}

	public void setSpeed(String value){
		this.speed = value;
	}

	public void setHorizontal(String value){
		this.horizontal = value;
	}

	public void setAutoMode(String value){
		this.autoMode = value;
	}

	public void setPauseOnHover(String value){
		this.pauseOnHover = value;
	}

	public void setJsonSource(String value){
		this.jsonSource = value;
	}

	public void setCustomContent(String value){
		this.customContent = value;
	}

}