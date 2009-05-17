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
package org.jquery4jsf.custom.dialog;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class DialogTag extends UIComponentTagBase {

	private String autoOpen;
	private String bgiframe;
	private String buttons;
	private String closeOnEscape;
	private String dialogClass;
	private String draggable;
	private String height;
	private String hide;
	private String maxHeight;
	private String maxWidth;
	private String minHeight;
	private String minWidth;
	private String modal;
	private String position;
	private String resizable;
	private String show;
	private String stack;
	private String title;
	private String width;
	private String zindex;
	private String onbeforeclose;
	private String onopen;
	private String onfocus;
	private String ondragStart;
	private String ondrag;
	private String ondragStop;
	private String onresizeStart;
	private String onresize;
	private String onresizeStop;
	private String onclose;

	public void release(){
		super.release();
		this.autoOpen = null;
		this.bgiframe = null;
		this.buttons = null;
		this.closeOnEscape = null;
		this.dialogClass = null;
		this.draggable = null;
		this.height = null;
		this.hide = null;
		this.maxHeight = null;
		this.maxWidth = null;
		this.minHeight = null;
		this.minWidth = null;
		this.modal = null;
		this.position = null;
		this.resizable = null;
		this.show = null;
		this.stack = null;
		this.title = null;
		this.width = null;
		this.zindex = null;
		this.onbeforeclose = null;
		this.onopen = null;
		this.onfocus = null;
		this.ondragStart = null;
		this.ondrag = null;
		this.ondragStop = null;
		this.onresizeStart = null;
		this.onresize = null;
		this.onresizeStop = null;
		this.onclose = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.dialog.Dialog component = null;
		try {
			component = (org.jquery4jsf.custom.dialog.Dialog) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setBooleanProperty(getFacesContext(), component, "autoOpen", autoOpen);
		setBooleanProperty(getFacesContext(), component, "bgiframe", bgiframe);
		setStringProperty(getFacesContext(), component, "buttons", buttons);
		setBooleanProperty(getFacesContext(), component, "closeOnEscape", closeOnEscape);
		setStringProperty(getFacesContext(), component, "dialogClass", dialogClass);
		setBooleanProperty(getFacesContext(), component, "draggable", draggable);
		setIntegerProperty(getFacesContext(), component, "height", height);
		setStringProperty(getFacesContext(), component, "hide", hide);
		setIntegerProperty(getFacesContext(), component, "maxHeight", maxHeight);
		setIntegerProperty(getFacesContext(), component, "maxWidth", maxWidth);
		setIntegerProperty(getFacesContext(), component, "minHeight", minHeight);
		setIntegerProperty(getFacesContext(), component, "minWidth", minWidth);
		setBooleanProperty(getFacesContext(), component, "modal", modal);
		setStringProperty(getFacesContext(), component, "position", position);
		setBooleanProperty(getFacesContext(), component, "resizable", resizable);
		setStringProperty(getFacesContext(), component, "show", show);
		setBooleanProperty(getFacesContext(), component, "stack", stack);
		setStringProperty(getFacesContext(), component, "title", title);
		setIntegerProperty(getFacesContext(), component, "width", width);
		setIntegerProperty(getFacesContext(), component, "zindex", zindex);
		setStringProperty(getFacesContext(), component, "onbeforeclose", onbeforeclose);
		setStringProperty(getFacesContext(), component, "onopen", onopen);
		setStringProperty(getFacesContext(), component, "onfocus", onfocus);
		setStringProperty(getFacesContext(), component, "ondragStart", ondragStart);
		setStringProperty(getFacesContext(), component, "ondrag", ondrag);
		setStringProperty(getFacesContext(), component, "ondragStop", ondragStop);
		setStringProperty(getFacesContext(), component, "onresizeStart", onresizeStart);
		setStringProperty(getFacesContext(), component, "onresize", onresize);
		setStringProperty(getFacesContext(), component, "onresizeStop", onresizeStop);
		setStringProperty(getFacesContext(), component, "onclose", onclose);
	}

	public String getComponentType() {
		return Dialog.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.DialogRenderer";
	}

	public void setAutoOpen(String value){
		this.autoOpen = value;
	}

	public void setBgiframe(String value){
		this.bgiframe = value;
	}

	public void setButtons(String value){
		this.buttons = value;
	}

	public void setCloseOnEscape(String value){
		this.closeOnEscape = value;
	}

	public void setDialogClass(String value){
		this.dialogClass = value;
	}

	public void setDraggable(String value){
		this.draggable = value;
	}

	public void setHeight(String value){
		this.height = value;
	}

	public void setHide(String value){
		this.hide = value;
	}

	public void setMaxHeight(String value){
		this.maxHeight = value;
	}

	public void setMaxWidth(String value){
		this.maxWidth = value;
	}

	public void setMinHeight(String value){
		this.minHeight = value;
	}

	public void setMinWidth(String value){
		this.minWidth = value;
	}

	public void setModal(String value){
		this.modal = value;
	}

	public void setPosition(String value){
		this.position = value;
	}

	public void setResizable(String value){
		this.resizable = value;
	}

	public void setShow(String value){
		this.show = value;
	}

	public void setStack(String value){
		this.stack = value;
	}

	public void setTitle(String value){
		this.title = value;
	}

	public void setWidth(String value){
		this.width = value;
	}

	public void setZindex(String value){
		this.zindex = value;
	}

	public void setOnbeforeclose(String value){
		this.onbeforeclose = value;
	}

	public void setOnopen(String value){
		this.onopen = value;
	}

	public void setOnfocus(String value){
		this.onfocus = value;
	}

	public void setOndragStart(String value){
		this.ondragStart = value;
	}

	public void setOndrag(String value){
		this.ondrag = value;
	}

	public void setOndragStop(String value){
		this.ondragStop = value;
	}

	public void setOnresizeStart(String value){
		this.onresizeStart = value;
	}

	public void setOnresize(String value){
		this.onresize = value;
	}

	public void setOnresizeStop(String value){
		this.onresizeStop = value;
	}

	public void setOnclose(String value){
		this.onclose = value;
	}

}