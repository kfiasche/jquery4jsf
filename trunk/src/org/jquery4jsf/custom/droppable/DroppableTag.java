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
package org.jquery4jsf.custom.droppable;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class DroppableTag extends UIComponentTagBase {

	private String _for;
	private String accept;
	private String activeClass;
	private String addClasses;
	private String greedy;
	private String hoverClass;
	private String scope;
	private String tolerance;
	private String ondropactivate;
	private String ondropdeactivate;
	private String ondropover;
	private String ondropout;
	private String ondrop;

	public void release(){
		super.release();
		this._for = null;
		this.accept = null;
		this.activeClass = null;
		this.addClasses = null;
		this.greedy = null;
		this.hoverClass = null;
		this.scope = null;
		this.tolerance = null;
		this.ondropactivate = null;
		this.ondropdeactivate = null;
		this.ondropover = null;
		this.ondropout = null;
		this.ondrop = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.droppable.Droppable component = null;
		try {
			component = (org.jquery4jsf.custom.droppable.Droppable) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "for", _for);
		setStringProperty(getFacesContext(), component, "accept", accept);
		setStringProperty(getFacesContext(), component, "activeClass", activeClass);
		setBooleanProperty(getFacesContext(), component, "addClasses", addClasses);
		setBooleanProperty(getFacesContext(), component, "greedy", greedy);
		setStringProperty(getFacesContext(), component, "hoverClass", hoverClass);
		setStringProperty(getFacesContext(), component, "scope", scope);
		setStringProperty(getFacesContext(), component, "tolerance", tolerance);
		setStringProperty(getFacesContext(), component, "ondropactivate", ondropactivate);
		setStringProperty(getFacesContext(), component, "ondropdeactivate", ondropdeactivate);
		setStringProperty(getFacesContext(), component, "ondropover", ondropover);
		setStringProperty(getFacesContext(), component, "ondropout", ondropout);
		setStringProperty(getFacesContext(), component, "ondrop", ondrop);
	}

	public String getComponentType() {
		return Droppable.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.DroppableRenderer";
	}

	public void setFor(String value){
		this._for = value;
	}

	public void setAccept(String value){
		this.accept = value;
	}

	public void setActiveClass(String value){
		this.activeClass = value;
	}

	public void setAddClasses(String value){
		this.addClasses = value;
	}

	public void setGreedy(String value){
		this.greedy = value;
	}

	public void setHoverClass(String value){
		this.hoverClass = value;
	}

	public void setScope(String value){
		this.scope = value;
	}

	public void setTolerance(String value){
		this.tolerance = value;
	}

	public void setOndropactivate(String value){
		this.ondropactivate = value;
	}

	public void setOndropdeactivate(String value){
		this.ondropdeactivate = value;
	}

	public void setOndropover(String value){
		this.ondropover = value;
	}

	public void setOndropout(String value){
		this.ondropout = value;
	}

	public void setOndrop(String value){
		this.ondrop = value;
	}

}