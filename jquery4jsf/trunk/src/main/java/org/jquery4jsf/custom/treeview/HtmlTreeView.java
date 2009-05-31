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
package org.jquery4jsf.custom.treeview;

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

public class HtmlTreeView extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTreeView";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.TreeView";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.HtmlTreeViewRenderer";

	private String[] resources;
	private String animated;
	private Boolean collapsed;
	private String control;
	private Boolean unique;
	private String ontoggle;
	private String persist;
	private String cookieId;
	private Boolean prerendered;
	private String add;

	public HtmlTreeView() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
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

	public boolean isCollapsed() {
		if(collapsed != null )
			return collapsed.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(collapsed, "collapsed");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setCollapsed(boolean collapsed) {
		this.collapsed = new Boolean(collapsed);
	}

	public String getControl() {
		if(control != null )
			return control;

		String oValue = (String) getLocalOrValueBindingValue(control, "control");
		return oValue != null ? oValue : null;
	}
	public void setControl(String control) {
		this.control = control;
	}

	public boolean isUnique() {
		if(unique != null )
			return unique.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(unique, "unique");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setUnique(boolean unique) {
		this.unique = new Boolean(unique);
	}

	public String getOntoggle() {
		if(ontoggle != null )
			return ontoggle;

		String oValue = (String) getLocalOrValueBindingValue(ontoggle, "ontoggle");
		return oValue != null ? oValue : null;
	}
	public void setOntoggle(String ontoggle) {
		this.ontoggle = ontoggle;
	}

	public String getPersist() {
		if(persist != null )
			return persist;

		String oValue = (String) getLocalOrValueBindingValue(persist, "persist");
		return oValue != null ? oValue : null;
	}
	public void setPersist(String persist) {
		this.persist = persist;
	}

	public String getCookieId() {
		if(cookieId != null )
			return cookieId;

		String oValue = (String) getLocalOrValueBindingValue(cookieId, "cookieId");
		return oValue != null ? oValue : null;
	}
	public void setCookieId(String cookieId) {
		this.cookieId = cookieId;
	}

	public boolean isPrerendered() {
		if(prerendered != null )
			return prerendered.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(prerendered, "prerendered");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setPrerendered(boolean prerendered) {
		this.prerendered = new Boolean(prerendered);
	}

	public String getAdd() {
		if(add != null )
			return add;

		String oValue = (String) getLocalOrValueBindingValue(add, "add");
		return oValue != null ? oValue : null;
	}
	public void setAdd(String add) {
		this.add = add;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[10];
		values[0] = super.saveState(context);
		values[1] = animated;
		values[2] = collapsed;
		values[3] = control;
		values[4] = unique;
		values[5] = ontoggle;
		values[6] = persist;
		values[7] = cookieId;
		values[8] = prerendered;
		values[9] = add;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.animated = (String) values[1];
		this.collapsed = (Boolean) values[2];
		this.control = (String) values[3];
		this.unique = (Boolean) values[4];
		this.ontoggle = (String) values[5];
		this.persist = (String) values[6];
		this.cookieId = (String) values[7];
		this.prerendered = (Boolean) values[8];
		this.add = (String) values[9];
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