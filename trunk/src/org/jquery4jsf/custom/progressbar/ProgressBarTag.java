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
/*
 *
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
package org.jquery4jsf.custom.progressbar;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class ProgressBarTag extends UIComponentTagBase {

	private String progressBarValue;
	private String resizable;
	private String onchange;

	public void release(){
		super.release();
		this.progressBarValue = null;
		this.resizable = null;
		this.onchange = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.progressbar.ProgressBar component = null;
		try {
			component = (org.jquery4jsf.custom.progressbar.ProgressBar) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setIntegerProperty(getFacesContext(), component, "progressBarValue", progressBarValue);
		setBooleanProperty(getFacesContext(), component, "resizable", resizable);
		setStringProperty(getFacesContext(), component, "onchange", onchange);
	}

	public String getComponentType() {
		return ProgressBar.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.ProgressBarRenderer";
	}

	public void setProgressBarValue(String value){
		this.progressBarValue = value;
	}

	public void setResizable(String value){
		this.resizable = value;
	}

	public void setOnchange(String value){
		this.onchange = value;
	}

}