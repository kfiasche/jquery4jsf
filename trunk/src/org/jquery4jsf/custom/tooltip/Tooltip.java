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

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;

public class Tooltip extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTooltip";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Tooltip";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.TooltipRenderer";

	private String[] resources;
	private Boolean prerender;
	private String text;
	private String titleText;
	private String titleButton;
	private String positionTarget;
	private String positionType;
	private String positionContainer;
	private String cornerTarget;
	private String cornerTooltip;
	private Integer adjustX;
	private Integer adjustY;
	private Boolean adjustMouse;
	private Boolean adjustScreen;
	private Boolean adjustScroll;
	private String adjustResize;
	private Integer showDelay;
	private String showSolo;
	private String showReady;
	private String showWhenTarget;
	private String showWhenEvent;
	private Integer showEffectLength;
	private String showEffectType;
	private Integer hideDelay;
	private Boolean hideFixed;
	private String hideWhenTarget;
	private String hideWhenEvent;
	private Integer hideEffectLength;
	private String hideEffectType;
	private String styleName;
	private Integer styleWidthMin;
	private Integer styleWidthMax;
	private Integer styleBorderWidth;
	private Integer styleBorderRadius;
	private String styleBorderColor;
	private String styleTipColor;
	private String styleTipCorner;
	private Integer styleTipSizeX;
	private Integer styleTipSizeY;
	private String styleTargetClass;
	private String styleTooltipClass;
	private String styleTipClass;
	private String styleTitleClass;
	private String styleContentClass;
	private String styleActiveClass;

	public Tooltip() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"tooltip/jquery.qtip.min.js",
			"tooltip/jquery.qtip.themeroller.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isPrerender() {
		if(prerender != null )
			return prerender.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(prerender, "prerender");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setPrerender(boolean prerender) {
		this.prerender = new Boolean(prerender);
	}

	public String getText() {
		if(text != null )
			return text;

		String oValue = (String) getLocalOrValueBindingValue(text, "text");
		return oValue != null ? oValue : null;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getTitleText() {
		if(titleText != null )
			return titleText;

		String oValue = (String) getLocalOrValueBindingValue(titleText, "titleText");
		return oValue != null ? oValue : null;
	}
	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public String getTitleButton() {
		if(titleButton != null )
			return titleButton;

		String oValue = (String) getLocalOrValueBindingValue(titleButton, "titleButton");
		return oValue != null ? oValue : null;
	}
	public void setTitleButton(String titleButton) {
		this.titleButton = titleButton;
	}

	public String getPositionTarget() {
		if(positionTarget != null )
			return positionTarget;

		String oValue = (String) getLocalOrValueBindingValue(positionTarget, "positionTarget");
		return oValue != null ? oValue : null;
	}
	public void setPositionTarget(String positionTarget) {
		this.positionTarget = positionTarget;
	}

	public String getPositionType() {
		if(positionType != null )
			return positionType;

		String oValue = (String) getLocalOrValueBindingValue(positionType, "positionType");
		return oValue != null ? oValue : null;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getPositionContainer() {
		if(positionContainer != null )
			return positionContainer;

		String oValue = (String) getLocalOrValueBindingValue(positionContainer, "positionContainer");
		return oValue != null ? oValue : null;
	}
	public void setPositionContainer(String positionContainer) {
		this.positionContainer = positionContainer;
	}

	public String getCornerTarget() {
		if(cornerTarget != null )
			return cornerTarget;

		String oValue = (String) getLocalOrValueBindingValue(cornerTarget, "cornerTarget");
		return oValue != null ? oValue : null;
	}
	public void setCornerTarget(String cornerTarget) {
		this.cornerTarget = cornerTarget;
	}

	public String getCornerTooltip() {
		if(cornerTooltip != null )
			return cornerTooltip;

		String oValue = (String) getLocalOrValueBindingValue(cornerTooltip, "cornerTooltip");
		return oValue != null ? oValue : null;
	}
	public void setCornerTooltip(String cornerTooltip) {
		this.cornerTooltip = cornerTooltip;
	}

	public int getAdjustX() {
		if(adjustX != null )
			return adjustX.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(adjustX, "adjustX");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setAdjustX(int adjustX) {
		this.adjustX = new Integer(adjustX);
	}

	public int getAdjustY() {
		if(adjustY != null )
			return adjustY.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(adjustY, "adjustY");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setAdjustY(int adjustY) {
		this.adjustY = new Integer(adjustY);
	}

	public boolean isAdjustMouse() {
		if(adjustMouse != null )
			return adjustMouse.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(adjustMouse, "adjustMouse");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAdjustMouse(boolean adjustMouse) {
		this.adjustMouse = new Boolean(adjustMouse);
	}

	public boolean isAdjustScreen() {
		if(adjustScreen != null )
			return adjustScreen.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(adjustScreen, "adjustScreen");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAdjustScreen(boolean adjustScreen) {
		this.adjustScreen = new Boolean(adjustScreen);
	}

	public boolean isAdjustScroll() {
		if(adjustScroll != null )
			return adjustScroll.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(adjustScroll, "adjustScroll");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAdjustScroll(boolean adjustScroll) {
		this.adjustScroll = new Boolean(adjustScroll);
	}

	public String getAdjustResize() {
		if(adjustResize != null )
			return adjustResize;

		String oValue = (String) getLocalOrValueBindingValue(adjustResize, "adjustResize");
		return oValue != null ? oValue : null;
	}
	public void setAdjustResize(String adjustResize) {
		this.adjustResize = adjustResize;
	}

	public int getShowDelay() {
		if(showDelay != null )
			return showDelay.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(showDelay, "showDelay");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setShowDelay(int showDelay) {
		this.showDelay = new Integer(showDelay);
	}

	public String getShowSolo() {
		if(showSolo != null )
			return showSolo;

		String oValue = (String) getLocalOrValueBindingValue(showSolo, "showSolo");
		return oValue != null ? oValue : null;
	}
	public void setShowSolo(String showSolo) {
		this.showSolo = showSolo;
	}

	public String getShowReady() {
		if(showReady != null )
			return showReady;

		String oValue = (String) getLocalOrValueBindingValue(showReady, "showReady");
		return oValue != null ? oValue : null;
	}
	public void setShowReady(String showReady) {
		this.showReady = showReady;
	}

	public String getShowWhenTarget() {
		if(showWhenTarget != null )
			return showWhenTarget;

		String oValue = (String) getLocalOrValueBindingValue(showWhenTarget, "showWhenTarget");
		return oValue != null ? oValue : null;
	}
	public void setShowWhenTarget(String showWhenTarget) {
		this.showWhenTarget = showWhenTarget;
	}

	public String getShowWhenEvent() {
		if(showWhenEvent != null )
			return showWhenEvent;

		String oValue = (String) getLocalOrValueBindingValue(showWhenEvent, "showWhenEvent");
		return oValue != null ? oValue : null;
	}
	public void setShowWhenEvent(String showWhenEvent) {
		this.showWhenEvent = showWhenEvent;
	}

	public int getShowEffectLength() {
		if(showEffectLength != null )
			return showEffectLength.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(showEffectLength, "showEffectLength");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setShowEffectLength(int showEffectLength) {
		this.showEffectLength = new Integer(showEffectLength);
	}

	public String getShowEffectType() {
		if(showEffectType != null )
			return showEffectType;

		String oValue = (String) getLocalOrValueBindingValue(showEffectType, "showEffectType");
		return oValue != null ? oValue : null;
	}
	public void setShowEffectType(String showEffectType) {
		this.showEffectType = showEffectType;
	}

	public int getHideDelay() {
		if(hideDelay != null )
			return hideDelay.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(hideDelay, "hideDelay");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setHideDelay(int hideDelay) {
		this.hideDelay = new Integer(hideDelay);
	}

	public boolean isHideFixed() {
		if(hideFixed != null )
			return hideFixed.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(hideFixed, "hideFixed");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setHideFixed(boolean hideFixed) {
		this.hideFixed = new Boolean(hideFixed);
	}

	public String getHideWhenTarget() {
		if(hideWhenTarget != null )
			return hideWhenTarget;

		String oValue = (String) getLocalOrValueBindingValue(hideWhenTarget, "hideWhenTarget");
		return oValue != null ? oValue : null;
	}
	public void setHideWhenTarget(String hideWhenTarget) {
		this.hideWhenTarget = hideWhenTarget;
	}

	public String getHideWhenEvent() {
		if(hideWhenEvent != null )
			return hideWhenEvent;

		String oValue = (String) getLocalOrValueBindingValue(hideWhenEvent, "hideWhenEvent");
		return oValue != null ? oValue : null;
	}
	public void setHideWhenEvent(String hideWhenEvent) {
		this.hideWhenEvent = hideWhenEvent;
	}

	public int getHideEffectLength() {
		if(hideEffectLength != null )
			return hideEffectLength.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(hideEffectLength, "hideEffectLength");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setHideEffectLength(int hideEffectLength) {
		this.hideEffectLength = new Integer(hideEffectLength);
	}

	public String getHideEffectType() {
		if(hideEffectType != null )
			return hideEffectType;

		String oValue = (String) getLocalOrValueBindingValue(hideEffectType, "hideEffectType");
		return oValue != null ? oValue : null;
	}
	public void setHideEffectType(String hideEffectType) {
		this.hideEffectType = hideEffectType;
	}

	public String getStyleName() {
		if(styleName != null )
			return styleName;

		String oValue = (String) getLocalOrValueBindingValue(styleName, "styleName");
		return oValue != null ? oValue : null;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public int getStyleWidthMin() {
		if(styleWidthMin != null )
			return styleWidthMin.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(styleWidthMin, "styleWidthMin");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setStyleWidthMin(int styleWidthMin) {
		this.styleWidthMin = new Integer(styleWidthMin);
	}

	public int getStyleWidthMax() {
		if(styleWidthMax != null )
			return styleWidthMax.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(styleWidthMax, "styleWidthMax");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setStyleWidthMax(int styleWidthMax) {
		this.styleWidthMax = new Integer(styleWidthMax);
	}

	public int getStyleBorderWidth() {
		if(styleBorderWidth != null )
			return styleBorderWidth.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(styleBorderWidth, "styleBorderWidth");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setStyleBorderWidth(int styleBorderWidth) {
		this.styleBorderWidth = new Integer(styleBorderWidth);
	}

	public int getStyleBorderRadius() {
		if(styleBorderRadius != null )
			return styleBorderRadius.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(styleBorderRadius, "styleBorderRadius");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setStyleBorderRadius(int styleBorderRadius) {
		this.styleBorderRadius = new Integer(styleBorderRadius);
	}

	public String getStyleBorderColor() {
		if(styleBorderColor != null )
			return styleBorderColor;

		String oValue = (String) getLocalOrValueBindingValue(styleBorderColor, "styleBorderColor");
		return oValue != null ? oValue : null;
	}
	public void setStyleBorderColor(String styleBorderColor) {
		this.styleBorderColor = styleBorderColor;
	}

	public String getStyleTipColor() {
		if(styleTipColor != null )
			return styleTipColor;

		String oValue = (String) getLocalOrValueBindingValue(styleTipColor, "styleTipColor");
		return oValue != null ? oValue : null;
	}
	public void setStyleTipColor(String styleTipColor) {
		this.styleTipColor = styleTipColor;
	}

	public String getStyleTipCorner() {
		if(styleTipCorner != null )
			return styleTipCorner;

		String oValue = (String) getLocalOrValueBindingValue(styleTipCorner, "styleTipCorner");
		return oValue != null ? oValue : null;
	}
	public void setStyleTipCorner(String styleTipCorner) {
		this.styleTipCorner = styleTipCorner;
	}

	public int getStyleTipSizeX() {
		if(styleTipSizeX != null )
			return styleTipSizeX.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(styleTipSizeX, "styleTipSizeX");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setStyleTipSizeX(int styleTipSizeX) {
		this.styleTipSizeX = new Integer(styleTipSizeX);
	}

	public int getStyleTipSizeY() {
		if(styleTipSizeY != null )
			return styleTipSizeY.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(styleTipSizeY, "styleTipSizeY");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setStyleTipSizeY(int styleTipSizeY) {
		this.styleTipSizeY = new Integer(styleTipSizeY);
	}

	public String getStyleTargetClass() {
		if(styleTargetClass != null )
			return styleTargetClass;

		String oValue = (String) getLocalOrValueBindingValue(styleTargetClass, "styleTargetClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleTargetClass(String styleTargetClass) {
		this.styleTargetClass = styleTargetClass;
	}

	public String getStyleTooltipClass() {
		if(styleTooltipClass != null )
			return styleTooltipClass;

		String oValue = (String) getLocalOrValueBindingValue(styleTooltipClass, "styleTooltipClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleTooltipClass(String styleTooltipClass) {
		this.styleTooltipClass = styleTooltipClass;
	}

	public String getStyleTipClass() {
		if(styleTipClass != null )
			return styleTipClass;

		String oValue = (String) getLocalOrValueBindingValue(styleTipClass, "styleTipClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleTipClass(String styleTipClass) {
		this.styleTipClass = styleTipClass;
	}

	public String getStyleTitleClass() {
		if(styleTitleClass != null )
			return styleTitleClass;

		String oValue = (String) getLocalOrValueBindingValue(styleTitleClass, "styleTitleClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleTitleClass(String styleTitleClass) {
		this.styleTitleClass = styleTitleClass;
	}

	public String getStyleContentClass() {
		if(styleContentClass != null )
			return styleContentClass;

		String oValue = (String) getLocalOrValueBindingValue(styleContentClass, "styleContentClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleContentClass(String styleContentClass) {
		this.styleContentClass = styleContentClass;
	}

	public String getStyleActiveClass() {
		if(styleActiveClass != null )
			return styleActiveClass;

		String oValue = (String) getLocalOrValueBindingValue(styleActiveClass, "styleActiveClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleActiveClass(String styleActiveClass) {
		this.styleActiveClass = styleActiveClass;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[45];
		values[0] = super.saveState(context);
		values[1] = prerender;
		values[2] = text;
		values[3] = titleText;
		values[4] = titleButton;
		values[5] = positionTarget;
		values[6] = positionType;
		values[7] = positionContainer;
		values[8] = cornerTarget;
		values[9] = cornerTooltip;
		values[10] = adjustX;
		values[11] = adjustY;
		values[12] = adjustMouse;
		values[13] = adjustScreen;
		values[14] = adjustScroll;
		values[15] = adjustResize;
		values[16] = showDelay;
		values[17] = showSolo;
		values[18] = showReady;
		values[19] = showWhenTarget;
		values[20] = showWhenEvent;
		values[21] = showEffectLength;
		values[22] = showEffectType;
		values[23] = hideDelay;
		values[24] = hideFixed;
		values[25] = hideWhenTarget;
		values[26] = hideWhenEvent;
		values[27] = hideEffectLength;
		values[28] = hideEffectType;
		values[29] = styleName;
		values[30] = styleWidthMin;
		values[31] = styleWidthMax;
		values[32] = styleBorderWidth;
		values[33] = styleBorderRadius;
		values[34] = styleBorderColor;
		values[35] = styleTipColor;
		values[36] = styleTipCorner;
		values[37] = styleTipSizeX;
		values[38] = styleTipSizeY;
		values[39] = styleTargetClass;
		values[40] = styleTooltipClass;
		values[41] = styleTipClass;
		values[42] = styleTitleClass;
		values[43] = styleContentClass;
		values[44] = styleActiveClass;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.prerender = (Boolean) values[1];
		this.text = (String) values[2];
		this.titleText = (String) values[3];
		this.titleButton = (String) values[4];
		this.positionTarget = (String) values[5];
		this.positionType = (String) values[6];
		this.positionContainer = (String) values[7];
		this.cornerTarget = (String) values[8];
		this.cornerTooltip = (String) values[9];
		this.adjustX = (Integer) values[10];
		this.adjustY = (Integer) values[11];
		this.adjustMouse = (Boolean) values[12];
		this.adjustScreen = (Boolean) values[13];
		this.adjustScroll = (Boolean) values[14];
		this.adjustResize = (String) values[15];
		this.showDelay = (Integer) values[16];
		this.showSolo = (String) values[17];
		this.showReady = (String) values[18];
		this.showWhenTarget = (String) values[19];
		this.showWhenEvent = (String) values[20];
		this.showEffectLength = (Integer) values[21];
		this.showEffectType = (String) values[22];
		this.hideDelay = (Integer) values[23];
		this.hideFixed = (Boolean) values[24];
		this.hideWhenTarget = (String) values[25];
		this.hideWhenEvent = (String) values[26];
		this.hideEffectLength = (Integer) values[27];
		this.hideEffectType = (String) values[28];
		this.styleName = (String) values[29];
		this.styleWidthMin = (Integer) values[30];
		this.styleWidthMax = (Integer) values[31];
		this.styleBorderWidth = (Integer) values[32];
		this.styleBorderRadius = (Integer) values[33];
		this.styleBorderColor = (String) values[34];
		this.styleTipColor = (String) values[35];
		this.styleTipCorner = (String) values[36];
		this.styleTipSizeX = (Integer) values[37];
		this.styleTipSizeY = (Integer) values[38];
		this.styleTargetClass = (String) values[39];
		this.styleTooltipClass = (String) values[40];
		this.styleTipClass = (String) values[41];
		this.styleTitleClass = (String) values[42];
		this.styleContentClass = (String) values[43];
		this.styleActiveClass = (String) values[44];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}