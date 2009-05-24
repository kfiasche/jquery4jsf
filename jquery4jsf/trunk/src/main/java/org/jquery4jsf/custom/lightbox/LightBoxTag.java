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
package org.jquery4jsf.custom.lightbox;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class LightBoxTag extends UIComponentTagBase {

	private String style;
	private String styleClass;
	private String activeImage;
	private String fixedNavigation;
	private String overlayBgColor;
	private String overlayOpacity;
	private String imageLoading;
	private String imageBtnClose;
	private String imageBtnPrev;
	private String imageBtnNext;
	private String containerBorderSize;
	private String containerResizeSpeed;
	private String txtImage;
	private String txtOf;
	private String imageBlank;
	private String keyToClose;
	private String keyToPrev;
	private String keyToNext;

	public void release(){
		super.release();
		this.style = null;
		this.styleClass = null;
		this.activeImage = null;
		this.fixedNavigation = null;
		this.overlayBgColor = null;
		this.overlayOpacity = null;
		this.imageLoading = null;
		this.imageBtnClose = null;
		this.imageBtnPrev = null;
		this.imageBtnNext = null;
		this.containerBorderSize = null;
		this.containerResizeSpeed = null;
		this.txtImage = null;
		this.txtOf = null;
		this.imageBlank = null;
		this.keyToClose = null;
		this.keyToPrev = null;
		this.keyToNext = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.lightbox.LightBox component = null;
		try {
			component = (org.jquery4jsf.custom.lightbox.LightBox) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setIntegerProperty(getFacesContext(), component, "activeImage", activeImage);
		setBooleanProperty(getFacesContext(), component, "fixedNavigation", fixedNavigation);
		setStringProperty(getFacesContext(), component, "overlayBgColor", overlayBgColor);
		setStringProperty(getFacesContext(), component, "overlayOpacity", overlayOpacity);
		setStringProperty(getFacesContext(), component, "imageLoading", imageLoading);
		setStringProperty(getFacesContext(), component, "imageBtnClose", imageBtnClose);
		setStringProperty(getFacesContext(), component, "imageBtnPrev", imageBtnPrev);
		setStringProperty(getFacesContext(), component, "imageBtnNext", imageBtnNext);
		setStringProperty(getFacesContext(), component, "containerBorderSize", containerBorderSize);
		setStringProperty(getFacesContext(), component, "containerResizeSpeed", containerResizeSpeed);
		setStringProperty(getFacesContext(), component, "txtImage", txtImage);
		setStringProperty(getFacesContext(), component, "txtOf", txtOf);
		setStringProperty(getFacesContext(), component, "imageBlank", imageBlank);
		setStringProperty(getFacesContext(), component, "keyToClose", keyToClose);
		setStringProperty(getFacesContext(), component, "keyToPrev", keyToPrev);
		setStringProperty(getFacesContext(), component, "keyToNext", keyToNext);
	}

	public String getComponentType() {
		return LightBox.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.LightBoxRenderer";
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setActiveImage(String value){
		this.activeImage = value;
	}

	public void setFixedNavigation(String value){
		this.fixedNavigation = value;
	}

	public void setOverlayBgColor(String value){
		this.overlayBgColor = value;
	}

	public void setOverlayOpacity(String value){
		this.overlayOpacity = value;
	}

	public void setImageLoading(String value){
		this.imageLoading = value;
	}

	public void setImageBtnClose(String value){
		this.imageBtnClose = value;
	}

	public void setImageBtnPrev(String value){
		this.imageBtnPrev = value;
	}

	public void setImageBtnNext(String value){
		this.imageBtnNext = value;
	}

	public void setContainerBorderSize(String value){
		this.containerBorderSize = value;
	}

	public void setContainerResizeSpeed(String value){
		this.containerResizeSpeed = value;
	}

	public void setTxtImage(String value){
		this.txtImage = value;
	}

	public void setTxtOf(String value){
		this.txtOf = value;
	}

	public void setImageBlank(String value){
		this.imageBlank = value;
	}

	public void setKeyToClose(String value){
		this.keyToClose = value;
	}

	public void setKeyToPrev(String value){
		this.keyToPrev = value;
	}

	public void setKeyToNext(String value){
		this.keyToNext = value;
	}

}