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
package org.jquery4jsf.custom.tooltip;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class TooltipTag extends UIComponentTagBase {

	private String delay;
	private String track;
	private String showURL;
	private String showBody;
	private String onbodyHandler;
	private String extraClass;
	private String top;
	private String fixPNG;
	private String left;

	public void release(){
		super.release();
		this.delay = null;
		this.track = null;
		this.showURL = null;
		this.showBody = null;
		this.onbodyHandler = null;
		this.extraClass = null;
		this.top = null;
		this.fixPNG = null;
		this.left = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.tooltip.Tooltip component = null;
		try {
			component = (org.jquery4jsf.custom.tooltip.Tooltip) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setIntegerProperty(getFacesContext(), component, "delay", delay);
		setStringProperty(getFacesContext(), component, "track", track);
		setStringProperty(getFacesContext(), component, "showURL", showURL);
		setStringProperty(getFacesContext(), component, "showBody", showBody);
		setStringProperty(getFacesContext(), component, "onbodyHandler", onbodyHandler);
		setStringProperty(getFacesContext(), component, "extraClass", extraClass);
		setIntegerProperty(getFacesContext(), component, "top", top);
		setStringProperty(getFacesContext(), component, "fixPNG", fixPNG);
		setIntegerProperty(getFacesContext(), component, "left", left);
	}

	public String getComponentType() {
		return Tooltip.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.TooltipRenderer";
	}

	public void setDelay(String value){
		this.delay = value;
	}

	public void setTrack(String value){
		this.track = value;
	}

	public void setShowURL(String value){
		this.showURL = value;
	}

	public void setShowBody(String value){
		this.showBody = value;
	}

	public void setOnbodyHandler(String value){
		this.onbodyHandler = value;
	}

	public void setExtraClass(String value){
		this.extraClass = value;
	}

	public void setTop(String value){
		this.top = value;
	}

	public void setFixPNG(String value){
		this.fixPNG = value;
	}

	public void setLeft(String value){
		this.left = value;
	}

}