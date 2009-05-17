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

public abstract class HtmlJSBaseTag extends HtmlBaseTag{

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
	
	public void release()
	{
		super.release();
		onclick=null;
		ondblclick=null;
		onkeydown=null;
		onkeypress=null;
		onkeyup=null;
		onmousedown=null;
		onmousemove=null;
		onmouseout=null;
		onmouseover=null;
		onmouseup=null;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);
        setStringProperty(getFacesContext(), component, HTML.ONCLICK, onclick);
        setStringProperty(getFacesContext(), component, HTML.ONDBLCLICK, ondblclick);
        setStringProperty(getFacesContext(), component, HTML.ONKEYDOWN, onkeydown);
        setStringProperty(getFacesContext(), component, HTML.ONKEYPRESS, onkeypress);
        setStringProperty(getFacesContext(), component, HTML.ONKEYUP, onkeyup);
        setStringProperty(getFacesContext(), component, HTML.ONMOUSEDOWN, onmousedown);
        setStringProperty(getFacesContext(), component, HTML.ONMOUSEMOVE, onmousemove);
        setStringProperty(getFacesContext(), component, HTML.ONMOUSEOUT, onmouseout);
        setStringProperty(getFacesContext(), component, HTML.ONMOUSEOVER, onmouseover);
        setStringProperty(getFacesContext(), component, HTML.ONMOUSEUP, onmouseup);
	}
	
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}
	
}
