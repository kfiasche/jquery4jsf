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

	private String oncomplete;
	private String prerender;
	private String text;
	private String titleText;
	private String titleButton;
	private String positionTarget;
	private String positionType;
	private String positionContainer;
	private String cornerTarget;
	private String cornerTooltip;
	private String adjustX;
	private String adjustY;
	private String adjustMouse;
	private String adjustScreen;
	private String adjustScroll;
	private String adjustResize;
	private String showDelay;
	private String showSolo;
	private String showReady;
	private String showWhenTarget;
	private String showWhenEvent;
	private String showEffectLength;
	private String showEffectType;
	private String hideDelay;
	private String hideFixed;
	private String hideWhenTarget;
	private String hideWhenEvent;
	private String hideEffectLength;
	private String hideEffectType;
	private String styleName;
	private String styleWidthMin;
	private String styleWidthMax;
	private String styleBorderWidth;
	private String styleBorderRadius;
	private String styleBorderColor;
	private String styleTipColor;
	private String styleTipCorner;
	private String styleTipSizeX;
	private String styleTipSizeY;
	private String styleTargetClass;
	private String styleTooltipClass;
	private String styleTipClass;
	private String styleTitleClass;
	private String styleContentClass;
	private String styleActiveClass;

	public void release(){
		super.release();
		this.oncomplete = null;
		this.prerender = null;
		this.text = null;
		this.titleText = null;
		this.titleButton = null;
		this.positionTarget = null;
		this.positionType = null;
		this.positionContainer = null;
		this.cornerTarget = null;
		this.cornerTooltip = null;
		this.adjustX = null;
		this.adjustY = null;
		this.adjustMouse = null;
		this.adjustScreen = null;
		this.adjustScroll = null;
		this.adjustResize = null;
		this.showDelay = null;
		this.showSolo = null;
		this.showReady = null;
		this.showWhenTarget = null;
		this.showWhenEvent = null;
		this.showEffectLength = null;
		this.showEffectType = null;
		this.hideDelay = null;
		this.hideFixed = null;
		this.hideWhenTarget = null;
		this.hideWhenEvent = null;
		this.hideEffectLength = null;
		this.hideEffectType = null;
		this.styleName = null;
		this.styleWidthMin = null;
		this.styleWidthMax = null;
		this.styleBorderWidth = null;
		this.styleBorderRadius = null;
		this.styleBorderColor = null;
		this.styleTipColor = null;
		this.styleTipCorner = null;
		this.styleTipSizeX = null;
		this.styleTipSizeY = null;
		this.styleTargetClass = null;
		this.styleTooltipClass = null;
		this.styleTipClass = null;
		this.styleTitleClass = null;
		this.styleContentClass = null;
		this.styleActiveClass = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.tooltip.Tooltip component = null;
		try {
			component = (org.jquery4jsf.custom.tooltip.Tooltip) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setMethodBindingProperty(getFacesContext(), component, "oncomplete", oncomplete);
		setBooleanProperty(getFacesContext(), component, "prerender", prerender);
		setStringProperty(getFacesContext(), component, "text", text);
		setStringProperty(getFacesContext(), component, "titleText", titleText);
		setStringProperty(getFacesContext(), component, "titleButton", titleButton);
		setStringProperty(getFacesContext(), component, "positionTarget", positionTarget);
		setStringProperty(getFacesContext(), component, "positionType", positionType);
		setStringProperty(getFacesContext(), component, "positionContainer", positionContainer);
		setStringProperty(getFacesContext(), component, "cornerTarget", cornerTarget);
		setStringProperty(getFacesContext(), component, "cornerTooltip", cornerTooltip);
		setIntegerProperty(getFacesContext(), component, "adjustX", adjustX);
		setIntegerProperty(getFacesContext(), component, "adjustY", adjustY);
		setBooleanProperty(getFacesContext(), component, "adjustMouse", adjustMouse);
		setBooleanProperty(getFacesContext(), component, "adjustScreen", adjustScreen);
		setBooleanProperty(getFacesContext(), component, "adjustScroll", adjustScroll);
		setStringProperty(getFacesContext(), component, "adjustResize", adjustResize);
		setIntegerProperty(getFacesContext(), component, "showDelay", showDelay);
		setStringProperty(getFacesContext(), component, "showSolo", showSolo);
		setStringProperty(getFacesContext(), component, "showReady", showReady);
		setStringProperty(getFacesContext(), component, "showWhenTarget", showWhenTarget);
		setStringProperty(getFacesContext(), component, "showWhenEvent", showWhenEvent);
		setIntegerProperty(getFacesContext(), component, "showEffectLength", showEffectLength);
		setStringProperty(getFacesContext(), component, "showEffectType", showEffectType);
		setIntegerProperty(getFacesContext(), component, "hideDelay", hideDelay);
		setBooleanProperty(getFacesContext(), component, "hideFixed", hideFixed);
		setStringProperty(getFacesContext(), component, "hideWhenTarget", hideWhenTarget);
		setStringProperty(getFacesContext(), component, "hideWhenEvent", hideWhenEvent);
		setIntegerProperty(getFacesContext(), component, "hideEffectLength", hideEffectLength);
		setStringProperty(getFacesContext(), component, "hideEffectType", hideEffectType);
		setStringProperty(getFacesContext(), component, "styleName", styleName);
		setIntegerProperty(getFacesContext(), component, "styleWidthMin", styleWidthMin);
		setIntegerProperty(getFacesContext(), component, "styleWidthMax", styleWidthMax);
		setIntegerProperty(getFacesContext(), component, "styleBorderWidth", styleBorderWidth);
		setIntegerProperty(getFacesContext(), component, "styleBorderRadius", styleBorderRadius);
		setStringProperty(getFacesContext(), component, "styleBorderColor", styleBorderColor);
		setStringProperty(getFacesContext(), component, "styleTipColor", styleTipColor);
		setStringProperty(getFacesContext(), component, "styleTipCorner", styleTipCorner);
		setIntegerProperty(getFacesContext(), component, "styleTipSizeX", styleTipSizeX);
		setIntegerProperty(getFacesContext(), component, "styleTipSizeY", styleTipSizeY);
		setStringProperty(getFacesContext(), component, "styleTargetClass", styleTargetClass);
		setStringProperty(getFacesContext(), component, "styleTooltipClass", styleTooltipClass);
		setStringProperty(getFacesContext(), component, "styleTipClass", styleTipClass);
		setStringProperty(getFacesContext(), component, "styleTitleClass", styleTitleClass);
		setStringProperty(getFacesContext(), component, "styleContentClass", styleContentClass);
		setStringProperty(getFacesContext(), component, "styleActiveClass", styleActiveClass);
	}

	public String getComponentType() {
		return Tooltip.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.TooltipRenderer";
	}

	public void setOncomplete(String value){
		this.oncomplete = value;
	}

	public void setPrerender(String value){
		this.prerender = value;
	}

	public void setText(String value){
		this.text = value;
	}

	public void setTitleText(String value){
		this.titleText = value;
	}

	public void setTitleButton(String value){
		this.titleButton = value;
	}

	public void setPositionTarget(String value){
		this.positionTarget = value;
	}

	public void setPositionType(String value){
		this.positionType = value;
	}

	public void setPositionContainer(String value){
		this.positionContainer = value;
	}

	public void setCornerTarget(String value){
		this.cornerTarget = value;
	}

	public void setCornerTooltip(String value){
		this.cornerTooltip = value;
	}

	public void setAdjustX(String value){
		this.adjustX = value;
	}

	public void setAdjustY(String value){
		this.adjustY = value;
	}

	public void setAdjustMouse(String value){
		this.adjustMouse = value;
	}

	public void setAdjustScreen(String value){
		this.adjustScreen = value;
	}

	public void setAdjustScroll(String value){
		this.adjustScroll = value;
	}

	public void setAdjustResize(String value){
		this.adjustResize = value;
	}

	public void setShowDelay(String value){
		this.showDelay = value;
	}

	public void setShowSolo(String value){
		this.showSolo = value;
	}

	public void setShowReady(String value){
		this.showReady = value;
	}

	public void setShowWhenTarget(String value){
		this.showWhenTarget = value;
	}

	public void setShowWhenEvent(String value){
		this.showWhenEvent = value;
	}

	public void setShowEffectLength(String value){
		this.showEffectLength = value;
	}

	public void setShowEffectType(String value){
		this.showEffectType = value;
	}

	public void setHideDelay(String value){
		this.hideDelay = value;
	}

	public void setHideFixed(String value){
		this.hideFixed = value;
	}

	public void setHideWhenTarget(String value){
		this.hideWhenTarget = value;
	}

	public void setHideWhenEvent(String value){
		this.hideWhenEvent = value;
	}

	public void setHideEffectLength(String value){
		this.hideEffectLength = value;
	}

	public void setHideEffectType(String value){
		this.hideEffectType = value;
	}

	public void setStyleName(String value){
		this.styleName = value;
	}

	public void setStyleWidthMin(String value){
		this.styleWidthMin = value;
	}

	public void setStyleWidthMax(String value){
		this.styleWidthMax = value;
	}

	public void setStyleBorderWidth(String value){
		this.styleBorderWidth = value;
	}

	public void setStyleBorderRadius(String value){
		this.styleBorderRadius = value;
	}

	public void setStyleBorderColor(String value){
		this.styleBorderColor = value;
	}

	public void setStyleTipColor(String value){
		this.styleTipColor = value;
	}

	public void setStyleTipCorner(String value){
		this.styleTipCorner = value;
	}

	public void setStyleTipSizeX(String value){
		this.styleTipSizeX = value;
	}

	public void setStyleTipSizeY(String value){
		this.styleTipSizeY = value;
	}

	public void setStyleTargetClass(String value){
		this.styleTargetClass = value;
	}

	public void setStyleTooltipClass(String value){
		this.styleTooltipClass = value;
	}

	public void setStyleTipClass(String value){
		this.styleTipClass = value;
	}

	public void setStyleTitleClass(String value){
		this.styleTitleClass = value;
	}

	public void setStyleContentClass(String value){
		this.styleContentClass = value;
	}

	public void setStyleActiveClass(String value){
		this.styleActiveClass = value;
	}

}