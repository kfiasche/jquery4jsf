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
package org.jquery4jsf.custom.outputhead;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class OutputHeadTag extends UIComponentTagBase {

	private String profile;
	private String dir;
	private String lang;
	private String langXml;

	public void release(){
		super.release();
		this.profile = null;
		this.dir = null;
		this.lang = null;
		this.langXml = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.outputhead.OutputHead component = null;
		try {
			component = (org.jquery4jsf.custom.outputhead.OutputHead) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "profile", profile);
		setStringProperty(getFacesContext(), component, "dir", dir);
		setStringProperty(getFacesContext(), component, "lang", lang);
		setStringProperty(getFacesContext(), component, "langXml", langXml);
	}

	public String getComponentType() {
		return OutputHead.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.OutputHeadRenderer";
	}

	public void setProfile(String value){
		this.profile = value;
	}

	public void setDir(String value){
		this.dir = value;
	}

	public void setLang(String value){
		this.lang = value;
	}

	public void setLangXml(String value){
		this.langXml = value;
	}

}