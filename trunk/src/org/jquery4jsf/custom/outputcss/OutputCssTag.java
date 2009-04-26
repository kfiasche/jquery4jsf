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
package org.jquery4jsf.custom.outputcss;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class OutputCssTag extends UIComponentTagBase {

	private String hreflang;
	private String type;
	private String href;
	private String media;
	private String rel;
	private String charset;

	public void release(){
		super.release();
		this.hreflang = null;
		this.type = null;
		this.href = null;
		this.media = null;
		this.rel = null;
		this.charset = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.outputcss.OutputCss component = null;
		try {
			component = (org.jquery4jsf.custom.outputcss.OutputCss) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "hreflang", hreflang);
		setStringProperty(getFacesContext(), component, "type", type);
		setStringProperty(getFacesContext(), component, "href", href);
		setStringProperty(getFacesContext(), component, "media", media);
		setStringProperty(getFacesContext(), component, "rel", rel);
		setStringProperty(getFacesContext(), component, "charset", charset);
	}

	public String getComponentType() {
		return OutputCss.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.OutputCssRenderer";
	}

	public void setHreflang(String value){
		this.hreflang = value;
	}

	public void setType(String value){
		this.type = value;
	}

	public void setHref(String value){
		this.href = value;
	}

	public void setMedia(String value){
		this.media = value;
	}

	public void setRel(String value){
		this.rel = value;
	}

	public void setCharset(String value){
		this.charset = value;
	}

}