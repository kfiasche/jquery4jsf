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
package org.jquery4jsf.component.ext;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

public class HtmlBaseDataComponent extends UIData {
	
	//Core Attributes
	/**
	 * Specifies a classname for an element
	 */
	private String styleClass;
	/**
	 * Specifies an inline style for an element
	 */
	private String style;
	/**
	 * 	Specifies extra information about an element
	 */
	private String title;
	//Language Attributes
	/**
	 * Specifies the text direction for the content in an element
	 */
	private String dir;
	/**
	 * 	Specifies a language code for the content in an element. Language code reference
	 */
	private String lang;
	/**
	 * 	Specifies a language code for the content in an element, in XHTML documents. Language code reference
	 */
	private String xmlLang;

	
	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}
	
    public void restoreState(FacesContext context, Object state)
    {
        Object[] values = (Object[]) state;
        super.restoreState(context, values[0]);
        styleClass  = (String)values[1];
        style       = (String)values[2];
        title       = (String)values[3];
        dir         = (String)values[4];
        lang        = (String)values[5];
        xmlLang     = (String)values[6];
    }
    
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[7];
        values[0] = super.saveState(context);
        values[1] = styleClass;
        values[2] = style;
        values[3] = title;
        values[4] = dir;
        values[5] = lang;
        values[6] = xmlLang;
        return values;
    }
	
	public String getStyleClass() {
		return (String) getLocalOrValueBindingValue(styleClass, "styleClass");
	}
	
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
	public String getStyle() {
		return (String) getLocalOrValueBindingValue(style, "style");
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getTitle() {
		return (String) getLocalOrValueBindingValue(title, "title");
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDir() {
		return (String) getLocalOrValueBindingValue(dir, "dir");	
	}
	
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	public String getLang() {
		return (String) getLocalOrValueBindingValue(lang, "lang");
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public String getXmlLang() {
		return (String) getLocalOrValueBindingValue(xmlLang, "xmlLang");
	}
	
	public void setXmlLang(String xmlLang) {
		this.xmlLang = xmlLang;
	}
	
	
}
