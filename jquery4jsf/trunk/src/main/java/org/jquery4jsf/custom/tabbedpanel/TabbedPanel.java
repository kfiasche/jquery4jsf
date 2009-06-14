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
package org.jquery4jsf.custom.tabbedpanel;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Integer;

public class TabbedPanel extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTabbedPanel";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.TabbedPanel";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.TabbedPanelRenderer";

	private String[] resources;
	private Boolean cache;
	private Boolean collapsible;
	private String cookie;
	private Boolean deselectable;
	private String event;
	private String fx;
	private String idPrefix;
	private Integer selected;
	private String spinner;

	public TabbedPanel() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"tab/ui.tabs.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isCache() {
		if(cache != null )
			return cache.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(cache, "cache");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setCache(boolean cache) {
		this.cache = new Boolean(cache);
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

	public String getCookie() {
		if(cookie != null )
			return cookie;

		String oValue = (String) getLocalOrValueBindingValue(cookie, "cookie");
		return oValue != null ? oValue : null;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public boolean isDeselectable() {
		if(deselectable != null )
			return deselectable.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(deselectable, "deselectable");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setDeselectable(boolean deselectable) {
		this.deselectable = new Boolean(deselectable);
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

	public String getFx() {
		if(fx != null )
			return fx;

		String oValue = (String) getLocalOrValueBindingValue(fx, "fx");
		return oValue != null ? oValue : null;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}

	public String getIdPrefix() {
		if(idPrefix != null )
			return idPrefix;

		String oValue = (String) getLocalOrValueBindingValue(idPrefix, "idPrefix");
		return oValue != null ? oValue : null;
	}
	public void setIdPrefix(String idPrefix) {
		this.idPrefix = idPrefix;
	}

	public int getSelected() {
		if(selected != null )
			return selected.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(selected, "selected");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setSelected(int selected) {
		this.selected = new Integer(selected);
	}

	public String getSpinner() {
		if(spinner != null )
			return spinner;

		String oValue = (String) getLocalOrValueBindingValue(spinner, "spinner");
		return oValue != null ? oValue : null;
	}
	public void setSpinner(String spinner) {
		this.spinner = spinner;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[10];
		values[0] = super.saveState(context);
		values[1] = cache;
		values[2] = collapsible;
		values[3] = cookie;
		values[4] = deselectable;
		values[5] = event;
		values[6] = fx;
		values[7] = idPrefix;
		values[8] = selected;
		values[9] = spinner;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.cache = (Boolean) values[1];
		this.collapsible = (Boolean) values[2];
		this.cookie = (String) values[3];
		this.deselectable = (Boolean) values[4];
		this.event = (String) values[5];
		this.fx = (String) values[6];
		this.idPrefix = (String) values[7];
		this.selected = (Integer) values[8];
		this.spinner = (String) values[9];
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