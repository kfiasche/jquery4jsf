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

public abstract class HtmlJSCompleteTag extends HtmlJSBaseTag {

	private String onchange;
	private String onblur;
	private String onfocus;
	
	public void release(){
		super.release();
		onblur = null;
		onfocus = null;
		onchange = null;
	}
	
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
        setStringProperty(getFacesContext(), component, HTML.ONBLUR, onblur);
        setStringProperty(getFacesContext(), component, HTML.ONCHANGE, onchange);
        setStringProperty(getFacesContext(), component, HTML.ONFOCUS, onfocus);
	}
	
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}
	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}
	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}
	
	
}
