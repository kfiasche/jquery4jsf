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
package org.jquery4jsf.custom.resizable;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class ResizableTag extends UIComponentTagBase {

	private String _for;
	private String alsoResize;
	private String animateDuration;
	private String animateEasing;
	private String aspectRatio;
	private String autoHide;
	private String cancel;
	private String containment;
	private String delay;
	private String distance;
	private String ghost;
	private String grid;
	private String handles;
	private String helper;
	private String maxHeight;
	private String maxWidth;
	private String minWidth;
	private String minHeight;
	private String onstart;
	private String onresize;
	private String onstop;

	public void release(){
		super.release();
		this._for = null;
		this.alsoResize = null;
		this.animateDuration = null;
		this.animateEasing = null;
		this.aspectRatio = null;
		this.autoHide = null;
		this.cancel = null;
		this.containment = null;
		this.delay = null;
		this.distance = null;
		this.ghost = null;
		this.grid = null;
		this.handles = null;
		this.helper = null;
		this.maxHeight = null;
		this.maxWidth = null;
		this.minWidth = null;
		this.minHeight = null;
		this.onstart = null;
		this.onresize = null;
		this.onstop = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.resizable.Resizable component = null;
		try {
			component = (org.jquery4jsf.custom.resizable.Resizable) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "for", _for);
		setStringProperty(getFacesContext(), component, "alsoResize", alsoResize);
		setStringProperty(getFacesContext(), component, "animateDuration", animateDuration);
		setStringProperty(getFacesContext(), component, "animateEasing", animateEasing);
		setStringProperty(getFacesContext(), component, "aspectRatio", aspectRatio);
		setBooleanProperty(getFacesContext(), component, "autoHide", autoHide);
		setStringProperty(getFacesContext(), component, "cancel", cancel);
		setStringProperty(getFacesContext(), component, "containment", containment);
		setIntegerProperty(getFacesContext(), component, "delay", delay);
		setIntegerProperty(getFacesContext(), component, "distance", distance);
		setBooleanProperty(getFacesContext(), component, "ghost", ghost);
		setStringProperty(getFacesContext(), component, "grid", grid);
		setStringProperty(getFacesContext(), component, "handles", handles);
		setStringProperty(getFacesContext(), component, "helper", helper);
		setIntegerProperty(getFacesContext(), component, "maxHeight", maxHeight);
		setIntegerProperty(getFacesContext(), component, "maxWidth", maxWidth);
		setIntegerProperty(getFacesContext(), component, "minWidth", minWidth);
		setIntegerProperty(getFacesContext(), component, "minHeight", minHeight);
		setStringProperty(getFacesContext(), component, "onstart", onstart);
		setStringProperty(getFacesContext(), component, "onresize", onresize);
		setStringProperty(getFacesContext(), component, "onstop", onstop);
	}

	public String getComponentType() {
		return Resizable.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.ResizableRenderer";
	}

	public void setFor(String value){
		this._for = value;
	}

	public void setAlsoResize(String value){
		this.alsoResize = value;
	}

	public void setAnimateDuration(String value){
		this.animateDuration = value;
	}

	public void setAnimateEasing(String value){
		this.animateEasing = value;
	}

	public void setAspectRatio(String value){
		this.aspectRatio = value;
	}

	public void setAutoHide(String value){
		this.autoHide = value;
	}

	public void setCancel(String value){
		this.cancel = value;
	}

	public void setContainment(String value){
		this.containment = value;
	}

	public void setDelay(String value){
		this.delay = value;
	}

	public void setDistance(String value){
		this.distance = value;
	}

	public void setGhost(String value){
		this.ghost = value;
	}

	public void setGrid(String value){
		this.grid = value;
	}

	public void setHandles(String value){
		this.handles = value;
	}

	public void setHelper(String value){
		this.helper = value;
	}

	public void setMaxHeight(String value){
		this.maxHeight = value;
	}

	public void setMaxWidth(String value){
		this.maxWidth = value;
	}

	public void setMinWidth(String value){
		this.minWidth = value;
	}

	public void setMinHeight(String value){
		this.minHeight = value;
	}

	public void setOnstart(String value){
		this.onstart = value;
	}

	public void setOnresize(String value){
		this.onresize = value;
	}

	public void setOnstop(String value){
		this.onstop = value;
	}

}