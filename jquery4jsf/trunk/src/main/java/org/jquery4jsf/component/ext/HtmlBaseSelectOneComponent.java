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

import javax.faces.component.UISelectOne;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

public abstract class HtmlBaseSelectOneComponent extends UISelectOne implements HtmlElementEvent,HtmlKeyEvent, HtmlMouseEvent {

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
	
	//Keyboard Attributes
	/**
	 * Specifies a keyboard shortcut to access an element
	 */
	private String accesskey;
	/**
	 * Specifies the tab order of an element
	 */
	private Integer tabindex;
	
	private String alt;
	private Boolean disabled;	
	private String name;
	private Integer size;	
	private String type;
	
	private String onclick;
	private String ondblclick;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onmousedown;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String onblur;
	private String onchange;
	private String onfocus;
	private String onselect;


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
        accesskey   = (String)values[7];
        tabindex   = (Integer)values[8];
        onclick		= (String)values[9];
        ondblclick	= (String)values[10];
        onkeydown	= (String)values[11];
        onkeypress	= (String)values[12];
        onkeyup		= (String)values[13];
        onmousedown	= (String)values[14];
        onmousemove	= (String)values[15];
        onmouseout	= (String)values[16];
        onmouseover	= (String)values[17];
        onmouseup	= (String)values[18];
        onblur	= (String)values[19];
        onchange	= (String)values[20];
        onfocus	= (String)values[21];
        onselect	= (String)values[22];
        size = (Integer) values[23];
        disabled = (Boolean) values[24];
        alt = (String) values[25];
        name = (String)values[26];
        type = (String)values[27];
    }
    
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[28];
        values[0] = super.saveState(context);
        values[1] = styleClass;
        values[2] = style;
        values[3] = title;
        values[4] = dir;
        values[5] = lang;
        values[6] = xmlLang;
        values[7] = accesskey;
        values[8] = tabindex;
        values[9]= onclick;
        values[10] = ondblclick;
        values[11] = onkeydown;
        values[12] = onkeypress;
        values[13] = onkeyup;
        values[14] = onmousedown;
        values[15] = onmousemove;
        values[16] = onmouseout;
        values[17] = onmouseover;
        values[18] = onmouseup;
        values[19] = onblur;
        values[20] = onchange;
        values[21] = onfocus;
        values[22] = onselect;
        values[23] = size;
        values[24] = disabled;
        values[25] = alt;
        values[26] = name;
        values[27] = type;
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
	
	public String getAccesskey() {
		return (String) getLocalOrValueBindingValue(accesskey, "accesskey");
	}

	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	public Integer getTabindex() {
		return (Integer) getLocalOrValueBindingValue(tabindex, "tabindex");
	}

	public void setTabindex(Integer tabindex) {
		this.tabindex = tabindex;
	}
	
	public String getOnclick() {
		return (String) getLocalOrValueBindingValue(onclick, "onclick");
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		return (String) getLocalOrValueBindingValue(ondblclick, "ondblclick");
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnkeydown() {
		return (String) getLocalOrValueBindingValue(onkeydown, "onkeydown");
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeypress() {
		return (String) getLocalOrValueBindingValue(onkeypress,"onkeypress");
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeyup() {
		return (String) getLocalOrValueBindingValue(onkeyup,"onkeyup");
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnmousedown() {
		return (String) getLocalOrValueBindingValue(onmousedown, "onmousedown");
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmousemove() {
		return (String) getLocalOrValueBindingValue(onmousemove, "onmousemove");
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return (String) getLocalOrValueBindingValue(onmouseout, "onmouseout");
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnmouseover() {
		return (String) getLocalOrValueBindingValue(onmouseover, "onmouseover");
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmouseup() {
		return (String) getLocalOrValueBindingValue(onmouseup, "onmouseup");
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	public String getOnblur() {
		return (String) getLocalOrValueBindingValue(onblur, "onblur");
	}

	public String getOnchange() {
		return (String) getLocalOrValueBindingValue(onchange, "onchange");
	}

	public String getOnfocus() {
		return (String) getLocalOrValueBindingValue(onfocus, "onfocus");
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}
	public String getOnselect() {
		return (String) getLocalOrValueBindingValue(onselect, "onselect");
	}

	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}
	
	public String getAlt() {
		return (String) getLocalOrValueBindingValue(alt, "alt");
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public boolean isDisabled() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(disabled, "disabled");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = new Boolean(disabled);
	}

	public String getName() {
		return (String) getLocalOrValueBindingValue(name, "name");
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return (Integer) getLocalOrValueBindingValue(size, "size");
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	public String getType() {
		return (String) getLocalOrValueBindingValue(type, "type");
	}

	public void setType(String type) {
		this.type = type;
	}

}
