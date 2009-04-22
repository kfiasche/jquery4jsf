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
package org.jquery4jsf.custom.effect;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class EffectTag extends UIComponentTagBase {

	private String _for;
	private String effect;
	private String event;
	private String options;
	private String speed;
	private String callback;

	public void release(){
		super.release();
		this._for = null;
		this.effect = null;
		this.event = null;
		this.options = null;
		this.speed = null;
		this.callback = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.effect.Effect component = null;
		try {
			component = (org.jquery4jsf.custom.effect.Effect) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "for", _for);
		setStringProperty(getFacesContext(), component, "effect", effect);
		setStringProperty(getFacesContext(), component, "event", event);
		setStringProperty(getFacesContext(), component, "options", options);
		setStringProperty(getFacesContext(), component, "speed", speed);
		setStringProperty(getFacesContext(), component, "callback", callback);
	}

	public String getComponentType() {
		return Effect.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.EffectRenderer";
	}

	public void setFor(String value){
		this._for = value;
	}

	public void setEffect(String value){
		this.effect = value;
	}

	public void setEvent(String value){
		this.event = value;
	}

	public void setOptions(String value){
		this.options = value;
	}

	public void setSpeed(String value){
		this.speed = value;
	}

	public void setCallback(String value){
		this.callback = value;
	}

}