/*
 *
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
package org.jquery4jsf.custom.draggable;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class DraggableTag extends UIComponentTagBase {

	private String _for;
	private String addClasses;
	private String appendTo;
	private String axis;
	private String cancel;
	private String connectToSortable;
	private String containment;
	private String cursor;
	private String cursorAt;
	private String delay;
	private String distance;
	private String grid;
	private String handle;
	private String helper;
	private String iframeFix;
	private String opacity;
	private String refreshPositions;
	private String revert;
	private String revertDuration;
	private String scope;
	private String scroll;
	private String scrollSensitivity;
	private String scrollSpeed;
	private String snap;
	private String snapMode;
	private String snapTolerance;
	private String stack;
	private String zIndex;
	private String ondragstart;
	private String ondrag;
	private String ondragstop;

	public void release(){
		super.release();
		this._for = null;
		this.addClasses = null;
		this.appendTo = null;
		this.axis = null;
		this.cancel = null;
		this.connectToSortable = null;
		this.containment = null;
		this.cursor = null;
		this.cursorAt = null;
		this.delay = null;
		this.distance = null;
		this.grid = null;
		this.handle = null;
		this.helper = null;
		this.iframeFix = null;
		this.opacity = null;
		this.refreshPositions = null;
		this.revert = null;
		this.revertDuration = null;
		this.scope = null;
		this.scroll = null;
		this.scrollSensitivity = null;
		this.scrollSpeed = null;
		this.snap = null;
		this.snapMode = null;
		this.snapTolerance = null;
		this.stack = null;
		this.zIndex = null;
		this.ondragstart = null;
		this.ondrag = null;
		this.ondragstop = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.draggable.Draggable component = null;
		try {
			component = (org.jquery4jsf.custom.draggable.Draggable) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "for", _for);
		setBooleanProperty(getFacesContext(), component, "addClasses", addClasses);
		setStringProperty(getFacesContext(), component, "appendTo", appendTo);
		setStringProperty(getFacesContext(), component, "axis", axis);
		setStringProperty(getFacesContext(), component, "cancel", cancel);
		setStringProperty(getFacesContext(), component, "connectToSortable", connectToSortable);
		setStringProperty(getFacesContext(), component, "containment", containment);
		setStringProperty(getFacesContext(), component, "cursor", cursor);
		setStringProperty(getFacesContext(), component, "cursorAt", cursorAt);
		setIntegerProperty(getFacesContext(), component, "delay", delay);
		setIntegerProperty(getFacesContext(), component, "distance", distance);
		setStringProperty(getFacesContext(), component, "grid", grid);
		setStringProperty(getFacesContext(), component, "handle", handle);
		setStringProperty(getFacesContext(), component, "helper", helper);
		setStringProperty(getFacesContext(), component, "iframeFix", iframeFix);
		setFloatProperty(getFacesContext(), component, "opacity", opacity);
		setBooleanProperty(getFacesContext(), component, "refreshPositions", refreshPositions);
		setStringProperty(getFacesContext(), component, "revert", revert);
		setIntegerProperty(getFacesContext(), component, "revertDuration", revertDuration);
		setStringProperty(getFacesContext(), component, "scope", scope);
		setBooleanProperty(getFacesContext(), component, "scroll", scroll);
		setIntegerProperty(getFacesContext(), component, "scrollSensitivity", scrollSensitivity);
		setIntegerProperty(getFacesContext(), component, "scrollSpeed", scrollSpeed);
		setStringProperty(getFacesContext(), component, "snap", snap);
		setStringProperty(getFacesContext(), component, "snapMode", snapMode);
		setIntegerProperty(getFacesContext(), component, "snapTolerance", snapTolerance);
		setStringProperty(getFacesContext(), component, "stack", stack);
		setIntegerProperty(getFacesContext(), component, "zIndex", zIndex);
		setStringProperty(getFacesContext(), component, "ondragstart", ondragstart);
		setStringProperty(getFacesContext(), component, "ondrag", ondrag);
		setStringProperty(getFacesContext(), component, "ondragstop", ondragstop);
	}

	public String getComponentType() {
		return Draggable.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.DraggableRenderer";
	}

	public void setFor(String value){
		this._for = value;
	}

	public void setAddClasses(String value){
		this.addClasses = value;
	}

	public void setAppendTo(String value){
		this.appendTo = value;
	}

	public void setAxis(String value){
		this.axis = value;
	}

	public void setCancel(String value){
		this.cancel = value;
	}

	public void setConnectToSortable(String value){
		this.connectToSortable = value;
	}

	public void setContainment(String value){
		this.containment = value;
	}

	public void setCursor(String value){
		this.cursor = value;
	}

	public void setCursorAt(String value){
		this.cursorAt = value;
	}

	public void setDelay(String value){
		this.delay = value;
	}

	public void setDistance(String value){
		this.distance = value;
	}

	public void setGrid(String value){
		this.grid = value;
	}

	public void setHandle(String value){
		this.handle = value;
	}

	public void setHelper(String value){
		this.helper = value;
	}

	public void setIframeFix(String value){
		this.iframeFix = value;
	}

	public void setOpacity(String value){
		this.opacity = value;
	}

	public void setRefreshPositions(String value){
		this.refreshPositions = value;
	}

	public void setRevert(String value){
		this.revert = value;
	}

	public void setRevertDuration(String value){
		this.revertDuration = value;
	}

	public void setScope(String value){
		this.scope = value;
	}

	public void setScroll(String value){
		this.scroll = value;
	}

	public void setScrollSensitivity(String value){
		this.scrollSensitivity = value;
	}

	public void setScrollSpeed(String value){
		this.scrollSpeed = value;
	}

	public void setSnap(String value){
		this.snap = value;
	}

	public void setSnapMode(String value){
		this.snapMode = value;
	}

	public void setSnapTolerance(String value){
		this.snapTolerance = value;
	}

	public void setStack(String value){
		this.stack = value;
	}

	public void setZIndex(String value){
		this.zIndex = value;
	}

	public void setOndragstart(String value){
		this.ondragstart = value;
	}

	public void setOndrag(String value){
		this.ondrag = value;
	}

	public void setOndragstop(String value){
		this.ondragstop = value;
	}

}