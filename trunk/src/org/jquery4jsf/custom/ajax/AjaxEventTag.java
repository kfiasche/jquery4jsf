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
package org.jquery4jsf.custom.ajax;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class AjaxEventTag extends UIComponentTagBase {

	private String value;
	private String actionListener;
	private String action;
	private String immediate;
	private String reRender;
	private String event;
	private String partialSubmit;

	public void release(){
		super.release();
		this.value = null;
		this.actionListener = null;
		this.action = null;
		this.immediate = null;
		this.reRender = null;
		this.event = null;
		this.partialSubmit = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.ajax.AjaxEvent component = null;
		try {
			component = (org.jquery4jsf.custom.ajax.AjaxEvent) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setValueProperty(getFacesContext(), component, "value", value);
		setActionListenerProperty(getFacesContext(), component, "actionListener", actionListener);
		setActionProperty(getFacesContext(), component, "action", action);
		setBooleanProperty(getFacesContext(), component, "immediate", immediate);
		setStringProperty(getFacesContext(), component, "reRender", reRender);
		setStringProperty(getFacesContext(), component, "event", event);
		setBooleanProperty(getFacesContext(), component, "partialSubmit", partialSubmit);
	}

	public String getComponentType() {
		return AjaxEvent.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.AjaxEventRenderer";
	}

	public void setValue(String value){
		this.value = value;
	}

	public void setActionListener(String value){
		this.actionListener = value;
	}

	public void setAction(String value){
		this.action = value;
	}

	public void setImmediate(String value){
		this.immediate = value;
	}

	public void setReRender(String value){
		this.reRender = value;
	}

	public void setEvent(String value){
		this.event = value;
	}

	public void setPartialSubmit(String value){
		this.partialSubmit = value;
	}

}