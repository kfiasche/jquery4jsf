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
package org.jquery4jsf.custom.overflow;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.custom.UIInteractions;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;

public class Overflow extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent,UIInteractions {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlOverflow";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Overflow";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.OverflowRenderer";

	private String[] resources;
	private String _for;
	private String eventStart;
	private String eventStop;
	private String message;
	private String cssPadding;
	private String cssMargin;
	private String cssWidth;
	private String cssTop;
	private String cssLeft;
	private String cssTextAlign;
	private String cssColor;
	private String cssBorder;
	private String cssBackgroundColor;
	private String cssCursor;
	private String overlayCSSBackgroundColor;
	private String overlayCSSOpacity;
	private String iframeSrc;
	private Boolean forceIframe;
	private Integer baseZ;
	private Boolean centerX;
	private Boolean centerY;
	private Boolean allowBodyStretch;
	private Boolean bindEvents;
	private Boolean constrainTabKey;
	private Integer fadeIn;
	private Integer fadeOut;
	private Integer timeout;
	private Boolean showOverlay;
	private Boolean focusInput;
	private Boolean applyPlatformOpacityRules;
	private String onUnblock;

	public Overflow() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"uiblock/jquery.blockUI.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getFor() {
		if( _for != null )
			return _for;

		String oValue = (String) getLocalOrValueBindingValue( _for, "for");
		return oValue != null ? oValue : null;
	}
	public void setFor(String _for) {
		this._for = _for;
	}

	public String getEventStart() {
		if(eventStart != null )
			return eventStart;

		String oValue = (String) getLocalOrValueBindingValue(eventStart, "eventStart");
		return oValue != null ? oValue : null;
	}
	public void setEventStart(String eventStart) {
		this.eventStart = eventStart;
	}

	public String getEventStop() {
		if(eventStop != null )
			return eventStop;

		String oValue = (String) getLocalOrValueBindingValue(eventStop, "eventStop");
		return oValue != null ? oValue : null;
	}
	public void setEventStop(String eventStop) {
		this.eventStop = eventStop;
	}

	public String getMessage() {
		if(message != null )
			return message;

		String oValue = (String) getLocalOrValueBindingValue(message, "message");
		return oValue != null ? oValue : null;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getCssPadding() {
		if(cssPadding != null )
			return cssPadding;

		String oValue = (String) getLocalOrValueBindingValue(cssPadding, "cssPadding");
		return oValue != null ? oValue : null;
	}
	public void setCssPadding(String cssPadding) {
		this.cssPadding = cssPadding;
	}

	public String getCssMargin() {
		if(cssMargin != null )
			return cssMargin;

		String oValue = (String) getLocalOrValueBindingValue(cssMargin, "cssMargin");
		return oValue != null ? oValue : null;
	}
	public void setCssMargin(String cssMargin) {
		this.cssMargin = cssMargin;
	}

	public String getCssWidth() {
		if(cssWidth != null )
			return cssWidth;

		String oValue = (String) getLocalOrValueBindingValue(cssWidth, "cssWidth");
		return oValue != null ? oValue : null;
	}
	public void setCssWidth(String cssWidth) {
		this.cssWidth = cssWidth;
	}

	public String getCssTop() {
		if(cssTop != null )
			return cssTop;

		String oValue = (String) getLocalOrValueBindingValue(cssTop, "cssTop");
		return oValue != null ? oValue : null;
	}
	public void setCssTop(String cssTop) {
		this.cssTop = cssTop;
	}

	public String getCssLeft() {
		if(cssLeft != null )
			return cssLeft;

		String oValue = (String) getLocalOrValueBindingValue(cssLeft, "cssLeft");
		return oValue != null ? oValue : null;
	}
	public void setCssLeft(String cssLeft) {
		this.cssLeft = cssLeft;
	}

	public String getCssTextAlign() {
		if(cssTextAlign != null )
			return cssTextAlign;

		String oValue = (String) getLocalOrValueBindingValue(cssTextAlign, "cssTextAlign");
		return oValue != null ? oValue : null;
	}
	public void setCssTextAlign(String cssTextAlign) {
		this.cssTextAlign = cssTextAlign;
	}

	public String getCssColor() {
		if(cssColor != null )
			return cssColor;

		String oValue = (String) getLocalOrValueBindingValue(cssColor, "cssColor");
		return oValue != null ? oValue : null;
	}
	public void setCssColor(String cssColor) {
		this.cssColor = cssColor;
	}

	public String getCssBorder() {
		if(cssBorder != null )
			return cssBorder;

		String oValue = (String) getLocalOrValueBindingValue(cssBorder, "cssBorder");
		return oValue != null ? oValue : null;
	}
	public void setCssBorder(String cssBorder) {
		this.cssBorder = cssBorder;
	}

	public String getCssBackgroundColor() {
		if(cssBackgroundColor != null )
			return cssBackgroundColor;

		String oValue = (String) getLocalOrValueBindingValue(cssBackgroundColor, "cssBackgroundColor");
		return oValue != null ? oValue : null;
	}
	public void setCssBackgroundColor(String cssBackgroundColor) {
		this.cssBackgroundColor = cssBackgroundColor;
	}

	public String getCssCursor() {
		if(cssCursor != null )
			return cssCursor;

		String oValue = (String) getLocalOrValueBindingValue(cssCursor, "cssCursor");
		return oValue != null ? oValue : null;
	}
	public void setCssCursor(String cssCursor) {
		this.cssCursor = cssCursor;
	}

	public String getOverlayCSSBackgroundColor() {
		if(overlayCSSBackgroundColor != null )
			return overlayCSSBackgroundColor;

		String oValue = (String) getLocalOrValueBindingValue(overlayCSSBackgroundColor, "overlayCSSBackgroundColor");
		return oValue != null ? oValue : null;
	}
	public void setOverlayCSSBackgroundColor(String overlayCSSBackgroundColor) {
		this.overlayCSSBackgroundColor = overlayCSSBackgroundColor;
	}

	public String getOverlayCSSOpacity() {
		if(overlayCSSOpacity != null )
			return overlayCSSOpacity;

		String oValue = (String) getLocalOrValueBindingValue(overlayCSSOpacity, "overlayCSSOpacity");
		return oValue != null ? oValue : null;
	}
	public void setOverlayCSSOpacity(String overlayCSSOpacity) {
		this.overlayCSSOpacity = overlayCSSOpacity;
	}

	public String getIframeSrc() {
		if(iframeSrc != null )
			return iframeSrc;

		String oValue = (String) getLocalOrValueBindingValue(iframeSrc, "iframeSrc");
		return oValue != null ? oValue : null;
	}
	public void setIframeSrc(String iframeSrc) {
		this.iframeSrc = iframeSrc;
	}

	public boolean isForceIframe() {
		if(forceIframe != null )
			return forceIframe.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(forceIframe, "forceIframe");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setForceIframe(boolean forceIframe) {
		this.forceIframe = new Boolean(forceIframe);
	}

	public int getBaseZ() {
		if(baseZ != null )
			return baseZ.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(baseZ, "baseZ");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setBaseZ(int baseZ) {
		this.baseZ = new Integer(baseZ);
	}

	public boolean isCenterX() {
		if(centerX != null )
			return centerX.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(centerX, "centerX");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setCenterX(boolean centerX) {
		this.centerX = new Boolean(centerX);
	}

	public boolean isCenterY() {
		if(centerY != null )
			return centerY.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(centerY, "centerY");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setCenterY(boolean centerY) {
		this.centerY = new Boolean(centerY);
	}

	public boolean isAllowBodyStretch() {
		if(allowBodyStretch != null )
			return allowBodyStretch.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(allowBodyStretch, "allowBodyStretch");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setAllowBodyStretch(boolean allowBodyStretch) {
		this.allowBodyStretch = new Boolean(allowBodyStretch);
	}

	public boolean isBindEvents() {
		if(bindEvents != null )
			return bindEvents.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(bindEvents, "bindEvents");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setBindEvents(boolean bindEvents) {
		this.bindEvents = new Boolean(bindEvents);
	}

	public boolean isConstrainTabKey() {
		if(constrainTabKey != null )
			return constrainTabKey.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(constrainTabKey, "constrainTabKey");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setConstrainTabKey(boolean constrainTabKey) {
		this.constrainTabKey = new Boolean(constrainTabKey);
	}

	public int getFadeIn() {
		if(fadeIn != null )
			return fadeIn.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(fadeIn, "fadeIn");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setFadeIn(int fadeIn) {
		this.fadeIn = new Integer(fadeIn);
	}

	public int getFadeOut() {
		if(fadeOut != null )
			return fadeOut.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(fadeOut, "fadeOut");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setFadeOut(int fadeOut) {
		this.fadeOut = new Integer(fadeOut);
	}

	public int getTimeout() {
		if(timeout != null )
			return timeout.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(timeout, "timeout");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setTimeout(int timeout) {
		this.timeout = new Integer(timeout);
	}

	public boolean isShowOverlay() {
		if(showOverlay != null )
			return showOverlay.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(showOverlay, "showOverlay");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setShowOverlay(boolean showOverlay) {
		this.showOverlay = new Boolean(showOverlay);
	}

	public boolean isFocusInput() {
		if(focusInput != null )
			return focusInput.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(focusInput, "focusInput");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setFocusInput(boolean focusInput) {
		this.focusInput = new Boolean(focusInput);
	}

	public boolean isApplyPlatformOpacityRules() {
		if(applyPlatformOpacityRules != null )
			return applyPlatformOpacityRules.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(applyPlatformOpacityRules, "applyPlatformOpacityRules");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setApplyPlatformOpacityRules(boolean applyPlatformOpacityRules) {
		this.applyPlatformOpacityRules = new Boolean(applyPlatformOpacityRules);
	}

	public String getOnUnblock() {
		if(onUnblock != null )
			return onUnblock;

		String oValue = (String) getLocalOrValueBindingValue(onUnblock, "onUnblock");
		return oValue != null ? oValue : null;
	}
	public void setOnUnblock(String onUnblock) {
		this.onUnblock = onUnblock;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[32];
		values[0] = super.saveState(context);
		values[1] = _for;
		values[2] = eventStart;
		values[3] = eventStop;
		values[4] = message;
		values[5] = cssPadding;
		values[6] = cssMargin;
		values[7] = cssWidth;
		values[8] = cssTop;
		values[9] = cssLeft;
		values[10] = cssTextAlign;
		values[11] = cssColor;
		values[12] = cssBorder;
		values[13] = cssBackgroundColor;
		values[14] = cssCursor;
		values[15] = overlayCSSBackgroundColor;
		values[16] = overlayCSSOpacity;
		values[17] = iframeSrc;
		values[18] = forceIframe;
		values[19] = baseZ;
		values[20] = centerX;
		values[21] = centerY;
		values[22] = allowBodyStretch;
		values[23] = bindEvents;
		values[24] = constrainTabKey;
		values[25] = fadeIn;
		values[26] = fadeOut;
		values[27] = timeout;
		values[28] = showOverlay;
		values[29] = focusInput;
		values[30] = applyPlatformOpacityRules;
		values[31] = onUnblock;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.eventStart = (String) values[2];
		this.eventStop = (String) values[3];
		this.message = (String) values[4];
		this.cssPadding = (String) values[5];
		this.cssMargin = (String) values[6];
		this.cssWidth = (String) values[7];
		this.cssTop = (String) values[8];
		this.cssLeft = (String) values[9];
		this.cssTextAlign = (String) values[10];
		this.cssColor = (String) values[11];
		this.cssBorder = (String) values[12];
		this.cssBackgroundColor = (String) values[13];
		this.cssCursor = (String) values[14];
		this.overlayCSSBackgroundColor = (String) values[15];
		this.overlayCSSOpacity = (String) values[16];
		this.iframeSrc = (String) values[17];
		this.forceIframe = (Boolean) values[18];
		this.baseZ = (Integer) values[19];
		this.centerX = (Boolean) values[20];
		this.centerY = (Boolean) values[21];
		this.allowBodyStretch = (Boolean) values[22];
		this.bindEvents = (Boolean) values[23];
		this.constrainTabKey = (Boolean) values[24];
		this.fadeIn = (Integer) values[25];
		this.fadeOut = (Integer) values[26];
		this.timeout = (Integer) values[27];
		this.showOverlay = (Boolean) values[28];
		this.focusInput = (Boolean) values[29];
		this.applyPlatformOpacityRules = (Boolean) values[30];
		this.onUnblock = (String) values[31];
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