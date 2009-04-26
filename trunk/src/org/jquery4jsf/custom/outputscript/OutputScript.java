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
package org.jquery4jsf.custom.outputscript;

import javax.faces.component.UIComponentBase;
import javax.faces.el.ValueBinding;

public class OutputScript extends UIComponentBase {


	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Output";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputScript";
	public static final String DEFAULT_RENDERER_TYPE = OutputScriptRenderer.RENDERER_TYPE;

	private String src;
	private String type;
	private String defer;
	private String charset;
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public OutputScript() {
		super();
		setRendererType(DEFAULT_RENDERER_TYPE);
	}
	
	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}
	
	public String getSrc() {
		return (String) getLocalOrValueBindingValue(src, "src");
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getType() {
		return (String) getLocalOrValueBindingValue(type, "type");
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDefer() {
		return (String) getLocalOrValueBindingValue(defer, "defer");
	}

	public void setDefer(String defer) {
		this.defer = defer;
	}

	public String getCharset() {
		return (String) getLocalOrValueBindingValue(charset, "charset");
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
	
}
