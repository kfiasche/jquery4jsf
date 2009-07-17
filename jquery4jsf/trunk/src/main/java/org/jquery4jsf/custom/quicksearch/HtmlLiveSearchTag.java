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
package org.jquery4jsf.custom.quicksearch;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class HtmlLiveSearchTag extends UIComponentTagBase {

	private String target;
	private String _for;
	private String type;
	private String minChars;
	private String delay;

	public void release(){
		super.release();
		this.target = null;
		this._for = null;
		this.type = null;
		this.minChars = null;
		this.delay = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.quicksearch.HtmlLiveSearch component = null;
		try {
			component = (org.jquery4jsf.custom.quicksearch.HtmlLiveSearch) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "target", target);
		setStringProperty(getFacesContext(), component, "for", _for);
		setStringProperty(getFacesContext(), component, "type", type);
		setIntegerProperty(getFacesContext(), component, "minChars", minChars);
		setIntegerProperty(getFacesContext(), component, "delay", delay);
	}

	public String getComponentType() {
		return HtmlLiveSearch.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.HtmlLiveSearchRenderer";
	}

	public void setTarget(String value){
		this.target = value;
	}

	public void setFor(String value){
		this._for = value;
	}

	public void setType(String value){
		this.type = value;
	}

	public void setMinChars(String value){
		this.minChars = value;
	}

	public void setDelay(String value){
		this.delay = value;
	}

}