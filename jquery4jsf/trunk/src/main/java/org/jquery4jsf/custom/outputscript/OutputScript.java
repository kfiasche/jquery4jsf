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
package org.jquery4jsf.custom.outputscript;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;

public class OutputScript extends UIComponentBase {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputScript";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.OutputScript";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.OutputScriptRenderer";

	private String[] resources;
	private String src;
	private String type;
	private String defer;
	private String charset;

	public OutputScript() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getSrc() {
		if(src != null )
			return src;

		String oValue = (String) getLocalOrValueBindingValue(src, "src");
		return oValue != null ? oValue : null;
	}
	public void setSrc(String src) {
		this.src = src;
	}

	public String getType() {
		if(type != null )
			return type;

		String oValue = (String) getLocalOrValueBindingValue(type, "type");
		return oValue != null ? oValue : null;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getDefer() {
		if(defer != null )
			return defer;

		String oValue = (String) getLocalOrValueBindingValue(defer, "defer");
		return oValue != null ? oValue : null;
	}
	public void setDefer(String defer) {
		this.defer = defer;
	}

	public String getCharset() {
		if(charset != null )
			return charset;

		String oValue = (String) getLocalOrValueBindingValue(charset, "charset");
		return oValue != null ? oValue : null;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[5];
		values[0] = super.saveState(context);
		values[1] = this.src;
		values[2] = this.type;
		values[3] = this.defer;
		values[4] = this.charset;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.src = (String) values[1];
		this.type = (String) values[2];
		this.defer = (String) values[3];
		this.charset = (String) values[4];
	}

	public String[] getResources() {
		return resources;
	}

	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}
}