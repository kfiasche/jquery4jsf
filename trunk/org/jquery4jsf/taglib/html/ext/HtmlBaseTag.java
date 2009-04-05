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
