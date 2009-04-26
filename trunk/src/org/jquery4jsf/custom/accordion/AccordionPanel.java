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
import java.lang.Integer;

public class AccordionPanel extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlAccordionPanel";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.AccordionPanel";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.AccordionPanelRenderer";

	private String[] resources;
	private Integer active;
	private String animated;
	private Boolean autoHeight;
	private Boolean clearStyle;
	private Boolean collapsible;
	private String event;
	private Boolean fillSpace;
	private String icons;
	private Boolean navigation;
	private String header;
	private String navigationFilter;
	private String onaccordionchange;

	public AccordionPanel() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"accordion/ui.accordion.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public int getActive() {
		if(active != null )
			return active.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(active, "active");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setActive(int active) {
		this.active = new Integer(active);
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

	public String getIcons() {
		if(icons != null )
			return icons;

		String oValue = (String) getLocalOrValueBindingValue(icons, "icons");
		return oValue != null ? oValue : null;
	}
	public void setIcons(String icons) {
		this.icons = icons;
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

	public String getHeader() {
		if(header != null )
			return header;

		String oValue = (String) getLocalOrValueBindingValue(header, "header");
		return oValue != null ? oValue : null;
	}
	public void setHeader(String header) {
		this.header = header;
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

	public String getOnaccordionchange() {
		if(onaccordionchange != null )
			return onaccordionchange;

		String oValue = (String) getLocalOrValueBindingValue(onaccordionchange, "onaccordionchange");
		return oValue != null ? oValue : null;
	}
	public void setOnaccordionchange(String onaccordionchange) {
		this.onaccordionchange = onaccordionchange;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[13];
		values[0] = super.saveState(context);
		values[1] = active;
		values[2] = animated;
		values[3] = autoHeight;
		values[4] = clearStyle;
		values[5] = collapsible;
		values[6] = event;
		values[7] = fillSpace;
		values[8] = icons;
		values[9] = navigation;
		values[10] = header;
		values[11] = navigationFilter;
		values[12] = onaccordionchange;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.active = (Integer) values[1];
		this.animated = (String) values[2];
		this.autoHeight = (Boolean) values[3];
		this.clearStyle = (Boolean) values[4];
		this.collapsible = (Boolean) values[5];
		this.event = (String) values[6];
		this.fillSpace = (Boolean) values[7];
		this.icons = (String) values[8];
		this.navigation = (Boolean) values[9];
		this.header = (String) values[10];
		this.navigationFilter = (String) values[11];
		this.onaccordionchange = (String) values[12];
	}

	public String[] getResources() {
		return resources;
	}

	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}