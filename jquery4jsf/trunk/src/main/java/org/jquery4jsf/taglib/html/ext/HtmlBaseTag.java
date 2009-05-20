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
package org.jquery4jsf.taglib.html.ext;

import javax.faces.component.UIComponent;

import org.jquery4jsf.renderkit.html.HTML;

public abstract class HtmlBaseTag extends UIComponentTagBase {

	private String styleClass;
	private String style;
	private String title;
	private String dir;
	private String lang;
	private String xmlLang;
	private String accesskey;
	private String tabindex;
		
	public void release() {
		super.release();
		styleClass	= null;
		style		= null;
		title		= null;
		dir			= null;
		lang		= null;
		xmlLang		= null;
		accesskey	= null;
		tabindex	= null;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);
        setStringProperty(getFacesContext(), component, HTML.DIR, dir);
        setStringProperty(getFacesContext(), component, HTML.LANG, lang);
        setStringProperty(getFacesContext(), component, HTML.STYLE, style);
        setStringProperty(getFacesContext(), component, HTML.TITLE, title);
        setStringProperty(getFacesContext(), component, HTML.STYLE_CLASS, styleClass);
        setStringProperty(getFacesContext(), component, HTML.ACCESS_KEY, accesskey);
        setIntegerProperty(getFacesContext(), component, HTML.TAB_INDEX, tabindex);
        setStringProperty(getFacesContext(), component, HTML.XML_LANG, xmlLang);
	}
	
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public void setXmlLang(String xmlLang) {
		this.xmlLang = xmlLang;
	}
	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}
	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}
	
}
