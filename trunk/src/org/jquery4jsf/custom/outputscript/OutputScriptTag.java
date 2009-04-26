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

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class OutputScriptTag extends UIComponentTagBase {

	private String src;
	private String type;
	private String defer;
	private String charset;

	public void release(){
		super.release();
		this.src = null;
		this.type = null;
		this.defer = null;
		this.charset = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.outputscript.OutputScript component = null;
		try {
			component = (org.jquery4jsf.custom.outputscript.OutputScript) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "src", src);
		setStringProperty(getFacesContext(), component, "type", type);
		setStringProperty(getFacesContext(), component, "defer", defer);
		setStringProperty(getFacesContext(), component, "charset", charset);
	}

	public String getComponentType() {
		return OutputScript.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.OutputScriptRenderer";
	}

	public void setSrc(String value){
		this.src = value;
	}

	public void setType(String value){
		this.type = value;
	}

	public void setDefer(String value){
		this.defer = value;
	}

	public void setCharset(String value){
		this.charset = value;
	}

}