/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
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
package org.jquery4jsf.custom.carousel;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class CarouselTag extends UIComponentTagBase {

	private String vertical;
	private String skin;
	private String skinCss;
	private String skinStyleClass;
	private String start;
	private String offset;
	private String size;
	private String scroll;
	private String visible;
	private String animation;
	private String easing;
	private String auto;
	private String wrap;
	private String initCallback;
	private String itemLoadCallbackBefore;
	private String itemLoadCallbackAfter;
	private String itemFirstInCallbackBefore;
	private String itemFirstInCallbackAfter;
	private String itemFirstOutCallbackBefore;
	private String itemFirstOutCallbackAfter;
	private String itemLastInCallbackBefore;
	private String itemLastInCallbackAfter;
	private String itemLastOutCallbackBefore;
	private String itemLastOutCallbackAfter;
	private String itemVisibleInCallbackBefore;
	private String itemVisibleInCallbackAfter;
	private String itemVisibleOutCallbackBefore;
	private String itemVisibleOutCallbackAfter;
	private String buttonNextCallback;
	private String buttonPrevCallback;
	private String buttonNextEvent;
	private String buttonPrevEvent;

	public void release(){
		super.release();
		this.vertical = null;
		this.skin = null;
		this.skinCss = null;
		this.skinStyleClass = null;
		this.start = null;
		this.offset = null;
		this.size = null;
		this.scroll = null;
		this.visible = null;
		this.animation = null;
		this.easing = null;
		this.auto = null;
		this.wrap = null;
		this.initCallback = null;
		this.itemLoadCallbackBefore = null;
		this.itemLoadCallbackAfter = null;
		this.itemFirstInCallbackBefore = null;
		this.itemFirstInCallbackAfter = null;
		this.itemFirstOutCallbackBefore = null;
		this.itemFirstOutCallbackAfter = null;
		this.itemLastInCallbackBefore = null;
		this.itemLastInCallbackAfter = null;
		this.itemLastOutCallbackBefore = null;
		this.itemLastOutCallbackAfter = null;
		this.itemVisibleInCallbackBefore = null;
		this.itemVisibleInCallbackAfter = null;
		this.itemVisibleOutCallbackBefore = null;
		this.itemVisibleOutCallbackAfter = null;
		this.buttonNextCallback = null;
		this.buttonPrevCallback = null;
		this.buttonNextEvent = null;
		this.buttonPrevEvent = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.carousel.Carousel component = null;
		try {
			component = (org.jquery4jsf.custom.carousel.Carousel) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setBooleanProperty(getFacesContext(), component, "vertical", vertical);
		setStringProperty(getFacesContext(), component, "skin", skin);
		setStringProperty(getFacesContext(), component, "skinCss", skinCss);
		setStringProperty(getFacesContext(), component, "skinStyleClass", skinStyleClass);
		setIntegerProperty(getFacesContext(), component, "start", start);
		setIntegerProperty(getFacesContext(), component, "offset", offset);
		setIntegerProperty(getFacesContext(), component, "size", size);
		setIntegerProperty(getFacesContext(), component, "scroll", scroll);
		setIntegerProperty(getFacesContext(), component, "visible", visible);
		setStringProperty(getFacesContext(), component, "animation", animation);
		setStringProperty(getFacesContext(), component, "easing", easing);
		setIntegerProperty(getFacesContext(), component, "auto", auto);
		setStringProperty(getFacesContext(), component, "wrap", wrap);
		setStringProperty(getFacesContext(), component, "initCallback", initCallback);
		setStringProperty(getFacesContext(), component, "itemLoadCallbackBefore", itemLoadCallbackBefore);
		setStringProperty(getFacesContext(), component, "itemLoadCallbackAfter", itemLoadCallbackAfter);
		setStringProperty(getFacesContext(), component, "itemFirstInCallbackBefore", itemFirstInCallbackBefore);
		setStringProperty(getFacesContext(), component, "itemFirstInCallbackAfter", itemFirstInCallbackAfter);
		setStringProperty(getFacesContext(), component, "itemFirstOutCallbackBefore", itemFirstOutCallbackBefore);
		setStringProperty(getFacesContext(), component, "itemFirstOutCallbackAfter", itemFirstOutCallbackAfter);
		setStringProperty(getFacesContext(), component, "itemLastInCallbackBefore", itemLastInCallbackBefore);
		setStringProperty(getFacesContext(), component, "itemLastInCallbackAfter", itemLastInCallbackAfter);
		setStringProperty(getFacesContext(), component, "itemLastOutCallbackBefore", itemLastOutCallbackBefore);
		setStringProperty(getFacesContext(), component, "itemLastOutCallbackAfter", itemLastOutCallbackAfter);
		setStringProperty(getFacesContext(), component, "itemVisibleInCallbackBefore", itemVisibleInCallbackBefore);
		setStringProperty(getFacesContext(), component, "itemVisibleInCallbackAfter", itemVisibleInCallbackAfter);
		setStringProperty(getFacesContext(), component, "itemVisibleOutCallbackBefore", itemVisibleOutCallbackBefore);
		setStringProperty(getFacesContext(), component, "itemVisibleOutCallbackAfter", itemVisibleOutCallbackAfter);
		setStringProperty(getFacesContext(), component, "buttonNextCallback", buttonNextCallback);
		setStringProperty(getFacesContext(), component, "buttonPrevCallback", buttonPrevCallback);
		setStringProperty(getFacesContext(), component, "buttonNextEvent", buttonNextEvent);
		setStringProperty(getFacesContext(), component, "buttonPrevEvent", buttonPrevEvent);
	}

	public String getComponentType() {
		return Carousel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.CarouselRenderer";
	}

	public void setVertical(String value){
		this.vertical = value;
	}

	public void setSkin(String value){
		this.skin = value;
	}

	public void setSkinCss(String value){
		this.skinCss = value;
	}

	public void setSkinStyleClass(String value){
		this.skinStyleClass = value;
	}

	public void setStart(String value){
		this.start = value;
	}

	public void setOffset(String value){
		this.offset = value;
	}

	public void setSize(String value){
		this.size = value;
	}

	public void setScroll(String value){
		this.scroll = value;
	}

	public void setVisible(String value){
		this.visible = value;
	}

	public void setAnimation(String value){
		this.animation = value;
	}

	public void setEasing(String value){
		this.easing = value;
	}

	public void setAuto(String value){
		this.auto = value;
	}

	public void setWrap(String value){
		this.wrap = value;
	}

	public void setInitCallback(String value){
		this.initCallback = value;
	}

	public void setItemLoadCallbackBefore(String value){
		this.itemLoadCallbackBefore = value;
	}

	public void setItemLoadCallbackAfter(String value){
		this.itemLoadCallbackAfter = value;
	}

	public void setItemFirstInCallbackBefore(String value){
		this.itemFirstInCallbackBefore = value;
	}

	public void setItemFirstInCallbackAfter(String value){
		this.itemFirstInCallbackAfter = value;
	}

	public void setItemFirstOutCallbackBefore(String value){
		this.itemFirstOutCallbackBefore = value;
	}

	public void setItemFirstOutCallbackAfter(String value){
		this.itemFirstOutCallbackAfter = value;
	}

	public void setItemLastInCallbackBefore(String value){
		this.itemLastInCallbackBefore = value;
	}

	public void setItemLastInCallbackAfter(String value){
		this.itemLastInCallbackAfter = value;
	}

	public void setItemLastOutCallbackBefore(String value){
		this.itemLastOutCallbackBefore = value;
	}

	public void setItemLastOutCallbackAfter(String value){
		this.itemLastOutCallbackAfter = value;
	}

	public void setItemVisibleInCallbackBefore(String value){
		this.itemVisibleInCallbackBefore = value;
	}

	public void setItemVisibleInCallbackAfter(String value){
		this.itemVisibleInCallbackAfter = value;
	}

	public void setItemVisibleOutCallbackBefore(String value){
		this.itemVisibleOutCallbackBefore = value;
	}

	public void setItemVisibleOutCallbackAfter(String value){
		this.itemVisibleOutCallbackAfter = value;
	}

	public void setButtonNextCallback(String value){
		this.buttonNextCallback = value;
	}

	public void setButtonPrevCallback(String value){
		this.buttonPrevCallback = value;
	}

	public void setButtonNextEvent(String value){
		this.buttonNextEvent = value;
	}

	public void setButtonPrevEvent(String value){
		this.buttonPrevEvent = value;
	}

}