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

public class AjaxStatusTag extends UIComponentTagBase {

	private String onajaxStart;
	private String onajaxSuccess;
	private String onajaxError;
	private String onajaxComplete;
	private String onajaxStop;

	public void release(){
		super.release();
		this.onajaxStart = null;
		this.onajaxSuccess = null;
		this.onajaxError = null;
		this.onajaxComplete = null;
		this.onajaxStop = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.ajax.AjaxStatus component = null;
		try {
			component = (org.jquery4jsf.custom.ajax.AjaxStatus) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "onajaxStart", onajaxStart);
		setStringProperty(getFacesContext(), component, "onajaxSuccess", onajaxSuccess);
		setStringProperty(getFacesContext(), component, "onajaxError", onajaxError);
		setStringProperty(getFacesContext(), component, "onajaxComplete", onajaxComplete);
		setStringProperty(getFacesContext(), component, "onajaxStop", onajaxStop);
	}

	public String getComponentType() {
		return AjaxStatus.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.AjaxStatusRenderer";
	}

	public void setOnajaxStart(String value){
		this.onajaxStart = value;
	}

	public void setOnajaxSuccess(String value){
		this.onajaxSuccess = value;
	}

	public void setOnajaxError(String value){
		this.onajaxError = value;
	}

	public void setOnajaxComplete(String value){
		this.onajaxComplete = value;
	}

	public void setOnajaxStop(String value){
		this.onajaxStop = value;
	}

}