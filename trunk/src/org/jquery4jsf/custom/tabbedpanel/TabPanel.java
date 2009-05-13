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

public class TabPanel extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTabPanel";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.TabPanel";

	private String[] resources;
	private Boolean disabled;
	private Boolean ajaxSupport;
	private String ajaxSource;
	private String tabName;

	public TabPanel() {
		setRendererType(null);
		 resources = new String[]{
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isDisabled() {
		if(disabled != null )
			return disabled.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(disabled, "disabled");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = new Boolean(disabled);
	}

	public boolean isAjaxSupport() {
		if(ajaxSupport != null )
			return ajaxSupport.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(ajaxSupport, "ajaxSupport");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAjaxSupport(boolean ajaxSupport) {
		this.ajaxSupport = new Boolean(ajaxSupport);
	}

	public String getAjaxSource() {
		if(ajaxSource != null )
			return ajaxSource;

		String oValue = (String) getLocalOrValueBindingValue(ajaxSource, "ajaxSource");
		return oValue != null ? oValue : null;
	}
	public void setAjaxSource(String ajaxSource) {
		this.ajaxSource = ajaxSource;
	}

	public String getTabName() {
		if(tabName != null )
			return tabName;

		String oValue = (String) getLocalOrValueBindingValue(tabName, "tabName");
		return oValue != null ? oValue : null;
	}
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[5];
		values[0] = super.saveState(context);
		values[1] = disabled;
		values[2] = ajaxSupport;
		values[3] = ajaxSource;
		values[4] = tabName;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.disabled = (Boolean) values[1];
		this.ajaxSupport = (Boolean) values[2];
		this.ajaxSource = (String) values[3];
		this.tabName = (String) values[4];
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