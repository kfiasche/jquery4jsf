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
package org.jquery4jsf.custom.selectable;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class SelectableTag extends UIComponentTagBase {

	private String _for;
	private String autoRefresh;
	private String cancel;
	private String delay;
	private String distance;
	private String filter;
	private String tolerance;
	private String onselected;
	private String onselecting;
	private String onstart;
	private String stop;
	private String onunselected;
	private String onunselecting;

	public void release(){
		super.release();
		this._for = null;
		this.autoRefresh = null;
		this.cancel = null;
		this.delay = null;
		this.distance = null;
		this.filter = null;
		this.tolerance = null;
		this.onselected = null;
		this.onselecting = null;
		this.onstart = null;
		this.stop = null;
		this.onunselected = null;
		this.onunselecting = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.selectable.Selectable component = null;
		try {
			component = (org.jquery4jsf.custom.selectable.Selectable) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "for", _for);
		setBooleanProperty(getFacesContext(), component, "autoRefresh", autoRefresh);
		setStringProperty(getFacesContext(), component, "cancel", cancel);
		setIntegerProperty(getFacesContext(), component, "delay", delay);
		setIntegerProperty(getFacesContext(), component, "distance", distance);
		setStringProperty(getFacesContext(), component, "filter", filter);
		setStringProperty(getFacesContext(), component, "tolerance", tolerance);
		setStringProperty(getFacesContext(), component, "onselected", onselected);
		setStringProperty(getFacesContext(), component, "onselecting", onselecting);
		setStringProperty(getFacesContext(), component, "onstart", onstart);
		setStringProperty(getFacesContext(), component, "stop", stop);
		setStringProperty(getFacesContext(), component, "onunselected", onunselected);
		setStringProperty(getFacesContext(), component, "onunselecting", onunselecting);
	}

	public String getComponentType() {
		return Selectable.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.SelectableRenderer";
	}

	public void setFor(String value){
		this._for = value;
	}

	public void setAutoRefresh(String value){
		this.autoRefresh = value;
	}

	public void setCancel(String value){
		this.cancel = value;
	}

	public void setDelay(String value){
		this.delay = value;
	}

	public void setDistance(String value){
		this.distance = value;
	}

	public void setFilter(String value){
		this.filter = value;
	}

	public void setTolerance(String value){
		this.tolerance = value;
	}

	public void setOnselected(String value){
		this.onselected = value;
	}

	public void setOnselecting(String value){
		this.onselecting = value;
	}

	public void setOnstart(String value){
		this.onstart = value;
	}

	public void setStop(String value){
		this.stop = value;
	}

	public void setOnunselected(String value){
		this.onunselected = value;
	}

	public void setOnunselecting(String value){
		this.onunselecting = value;
	}

}