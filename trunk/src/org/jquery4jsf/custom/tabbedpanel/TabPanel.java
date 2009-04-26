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
package org.jquery4jsf.custom.tabbedpanel;

import javax.faces.context.FacesContext;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;

public class TabPanel extends HtmlBaseOutputComponent implements JQueryHtmlObject{

	public TabPanel() {
		super();
	}

	public static final String COMPONENT_FAMILY = "org.jquery4jsf.TabPanel";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTabPanel";
	
	private Boolean disabled;
	private Boolean ajaxSupport;
	private String ajaxSource;
	private String tabName;
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public void restoreState(FacesContext context, Object state)
    {
        Object[] values = (Object[]) state;
        super.restoreState(context, values[0]);
        ajaxSource = (String) values[1]; 
        disabled       = (Boolean) values[2]; 
        ajaxSupport = (Boolean) values[3]; 
        tabName      = (String) values[4]; 
    }
	
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[5];
        values[0] = super.saveState(context);
        values[1] = ajaxSource;
        values[2] = disabled;
        values[3] = ajaxSupport;
        values[4] = tabName;
        return values;
    }
	
	public String[] getResources() {
		throw new IllegalAccessError("Questo componente non ha nessun tipo di risorsa.");
	}

	public boolean isDisabled() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(disabled, "disabled");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled ? Boolean.TRUE : Boolean.FALSE;
	}

	public boolean isAjaxSupport() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(ajaxSupport, "ajaxSupport");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setAjaxSupport(boolean ajaxSupport) {
		this.ajaxSupport = ajaxSupport ? Boolean.TRUE : Boolean.FALSE;
	}

	public String getAjaxSource() {
		return (String) getLocalOrValueBindingValue(ajaxSource, "ajaxSource");
	}

	public void setAjaxSource(String ajaxSource) {
		this.ajaxSource = ajaxSource;
	}

	public String getTabName() {
		return (String) getLocalOrValueBindingValue(tabName, "tabName");
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public boolean getRendersChildren() {
		return true;
	}

}
