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
package org.jquery4jsf.custom.accordion;

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

public class AccordionPanel extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlAccordionPanel";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.AccordionPanel";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.AccordionPanelRenderer";

	private String[] resources;
	private String styleClass;
	private String style;
	private Boolean cookie;
	private String active;
	private String animated;
	private Boolean autoHeight;
	private Boolean clearStyle;
	private Boolean collapsible;
	private String event;
	private Boolean fillSpace;
	private String iconsHeader;
	private String iconsHeaderSelected;
	private Boolean navigation;
	private String navigationFilter;
	private String onchange;
	private String onchangestart;

	public AccordionPanel() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"accordion/ui.accordion.js",
			"external/jquery.cookie.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getStyleClass() {
		if(styleClass != null )
			return styleClass;

		String oValue = (String) getLocalOrValueBindingValue(styleClass, "styleClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getStyle() {
		if(style != null )
			return style;

		String oValue = (String) getLocalOrValueBindingValue(style, "style");
		return oValue != null ? oValue : null;
	}
	public void setStyle(String style) {
		this.style = style;
	}

	public boolean isCookie() {
		if(cookie != null )
			return cookie.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(cookie, "cookie");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setCookie(boolean cookie) {
		this.cookie = new Boolean(cookie);
	}

	public String getActive() {
		if(active != null )
			return active;

		String oValue = (String) getLocalOrValueBindingValue(active, "active");
		return oValue != null ? oValue : null;
	}
	public void setActive(String active) {
		this.active = active;
	}

	public String getAnimated() {
		if(animated != null )
			return animated;

		String oValue = (String) getLocalOrValueBindingValue(animated, "animated");
		return oValue != null ? oValue : null;
	}
	public void setAnimated(String animated) {
		this.animated = animated;
	}

	public boolean isAutoHeight() {
		if(autoHeight != null )
			return autoHeight.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(autoHeight, "autoHeight");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setAutoHeight(boolean autoHeight) {
		this.autoHeight = new Boolean(autoHeight);
	}

	public boolean isClearStyle() {
		if(clearStyle != null )
			return clearStyle.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(clearStyle, "clearStyle");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setClearStyle(boolean clearStyle) {
		this.clearStyle = new Boolean(clearStyle);
	}

	public boolean isCollapsible() {
		if(collapsible != null )
			return collapsible.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(collapsible, "collapsible");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setCollapsible(boolean collapsible) {
		this.collapsible = new Boolean(collapsible);
	}

	public String getEvent() {
		if(event != null )
			return event;

		String oValue = (String) getLocalOrValueBindingValue(event, "event");
		return oValue != null ? oValue : null;
	}
	public void setEvent(String event) {
		this.event = event;
	}

	public boolean isFillSpace() {
		if(fillSpace != null )
			return fillSpace.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(fillSpace, "fillSpace");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setFillSpace(boolean fillSpace) {
		this.fillSpace = new Boolean(fillSpace);
	}

	public String getIconsHeader() {
		if(iconsHeader != null )
			return iconsHeader;

		String oValue = (String) getLocalOrValueBindingValue(iconsHeader, "iconsHeader");
		return oValue != null ? oValue : null;
	}
	public void setIconsHeader(String iconsHeader) {
		this.iconsHeader = iconsHeader;
	}

	public String getIconsHeaderSelected() {
		if(iconsHeaderSelected != null )
			return iconsHeaderSelected;

		String oValue = (String) getLocalOrValueBindingValue(iconsHeaderSelected, "iconsHeaderSelected");
		return oValue != null ? oValue : null;
	}
	public void setIconsHeaderSelected(String iconsHeaderSelected) {
		this.iconsHeaderSelected = iconsHeaderSelected;
	}

	public boolean isNavigation() {
		if(navigation != null )
			return navigation.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(navigation, "navigation");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setNavigation(boolean navigation) {
		this.navigation = new Boolean(navigation);
	}

	public String getNavigationFilter() {
		if(navigationFilter != null )
			return navigationFilter;

		String oValue = (String) getLocalOrValueBindingValue(navigationFilter, "navigationFilter");
		return oValue != null ? oValue : null;
	}
	public void setNavigationFilter(String navigationFilter) {
		this.navigationFilter = navigationFilter;
	}

	public String getOnchange() {
		if(onchange != null )
			return onchange;

		String oValue = (String) getLocalOrValueBindingValue(onchange, "onchange");
		return oValue != null ? oValue : null;
	}
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnchangestart() {
		if(onchangestart != null )
			return onchangestart;

		String oValue = (String) getLocalOrValueBindingValue(onchangestart, "onchangestart");
		return oValue != null ? oValue : null;
	}
	public void setOnchangestart(String onchangestart) {
		this.onchangestart = onchangestart;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[17];
		values[0] = super.saveState(context);
		values[1] = styleClass;
		values[2] = style;
		values[3] = cookie;
		values[4] = active;
		values[5] = animated;
		values[6] = autoHeight;
		values[7] = clearStyle;
		values[8] = collapsible;
		values[9] = event;
		values[10] = fillSpace;
		values[11] = iconsHeader;
		values[12] = iconsHeaderSelected;
		values[13] = navigation;
		values[14] = navigationFilter;
		values[15] = onchange;
		values[16] = onchangestart;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.styleClass = (String) values[1];
		this.style = (String) values[2];
		this.cookie = (Boolean) values[3];
		this.active = (String) values[4];
		this.animated = (String) values[5];
		this.autoHeight = (Boolean) values[6];
		this.clearStyle = (Boolean) values[7];
		this.collapsible = (Boolean) values[8];
		this.event = (String) values[9];
		this.fillSpace = (Boolean) values[10];
		this.iconsHeader = (String) values[11];
		this.iconsHeaderSelected = (String) values[12];
		this.navigation = (Boolean) values[13];
		this.navigationFilter = (String) values[14];
		this.onchange = (String) values[15];
		this.onchangestart = (String) values[16];
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