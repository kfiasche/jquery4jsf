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
package org.jquery4jsf.custom.outputcss;

import javax.faces.component.UIComponent;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class OutputCssTag extends UIComponentTagBase{

	private String hreflang;
	private String type;
	private String href;
	private String media;
	private String rel;
	private String charset;
	
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setHreflang(String hreflang) {
		this.hreflang = hreflang;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getComponentType() {
		return OutputCss.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return OutputCss.DEFAULT_RENDERER_TYPE;
	}
	
	public void release(){
		super.release();
		hreflang    = null;
		type   = null;
		href  = null;
		media= null;
		rel= null;
		charset = null;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "hreflang",hreflang);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "type",type);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "href",href);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "media",media);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "rel",rel);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "charset",charset);
	}

}
