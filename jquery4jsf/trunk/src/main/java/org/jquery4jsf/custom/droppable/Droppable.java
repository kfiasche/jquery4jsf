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
package org.jquery4jsf.custom.droppable;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.custom.UIInteractions;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;

public class Droppable extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent,UIInteractions {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlDroppable";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Droppable";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.DroppableRenderer";

	private String[] resources;
	private String _for;
	private String accept;
	private String activeClass;
	private Boolean addClasses;
	private Boolean greedy;
	private String hoverClass;
	private String scope;
	private String tolerance;
	private String ondropactivate;
	private String ondropdeactivate;
	private String ondropover;
	private String ondropout;
	private String ondrop;

	public Droppable() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"ui/ui.droppable.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getFor() {
		if( _for != null )
			return _for;

		String oValue = (String) getLocalOrValueBindingValue( _for, "for");
		return oValue != null ? oValue : null;
	}
	public void setFor(String _for) {
		this._for = _for;
	}

	public String getAccept() {
		if(accept != null )
			return accept;

		String oValue = (String) getLocalOrValueBindingValue(accept, "accept");
		return oValue != null ? oValue : null;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getActiveClass() {
		if(activeClass != null )
			return activeClass;

		String oValue = (String) getLocalOrValueBindingValue(activeClass, "activeClass");
		return oValue != null ? oValue : null;
	}
	public void setActiveClass(String activeClass) {
		this.activeClass = activeClass;
	}

	public boolean isAddClasses() {
		if(addClasses != null )
			return addClasses.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(addClasses, "addClasses");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setAddClasses(boolean addClasses) {
		this.addClasses = new Boolean(addClasses);
	}

	public boolean isGreedy() {
		if(greedy != null )
			return greedy.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(greedy, "greedy");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setGreedy(boolean greedy) {
		this.greedy = new Boolean(greedy);
	}

	public String getHoverClass() {
		if(hoverClass != null )
			return hoverClass;

		String oValue = (String) getLocalOrValueBindingValue(hoverClass, "hoverClass");
		return oValue != null ? oValue : null;
	}
	public void setHoverClass(String hoverClass) {
		this.hoverClass = hoverClass;
	}

	public String getScope() {
		if(scope != null )
			return scope;

		String oValue = (String) getLocalOrValueBindingValue(scope, "scope");
		return oValue != null ? oValue : null;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getTolerance() {
		if(tolerance != null )
			return tolerance;

		String oValue = (String) getLocalOrValueBindingValue(tolerance, "tolerance");
		return oValue != null ? oValue : null;
	}
	public void setTolerance(String tolerance) {
		this.tolerance = tolerance;
	}

	public String getOndropactivate() {
		if(ondropactivate != null )
			return ondropactivate;

		String oValue = (String) getLocalOrValueBindingValue(ondropactivate, "ondropactivate");
		return oValue != null ? oValue : null;
	}
	public void setOndropactivate(String ondropactivate) {
		this.ondropactivate = ondropactivate;
	}

	public String getOndropdeactivate() {
		if(ondropdeactivate != null )
			return ondropdeactivate;

		String oValue = (String) getLocalOrValueBindingValue(ondropdeactivate, "ondropdeactivate");
		return oValue != null ? oValue : null;
	}
	public void setOndropdeactivate(String ondropdeactivate) {
		this.ondropdeactivate = ondropdeactivate;
	}

	public String getOndropover() {
		if(ondropover != null )
			return ondropover;

		String oValue = (String) getLocalOrValueBindingValue(ondropover, "ondropover");
		return oValue != null ? oValue : null;
	}
	public void setOndropover(String ondropover) {
		this.ondropover = ondropover;
	}

	public String getOndropout() {
		if(ondropout != null )
			return ondropout;

		String oValue = (String) getLocalOrValueBindingValue(ondropout, "ondropout");
		return oValue != null ? oValue : null;
	}
	public void setOndropout(String ondropout) {
		this.ondropout = ondropout;
	}

	public String getOndrop() {
		if(ondrop != null )
			return ondrop;

		String oValue = (String) getLocalOrValueBindingValue(ondrop, "ondrop");
		return oValue != null ? oValue : null;
	}
	public void setOndrop(String ondrop) {
		this.ondrop = ondrop;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[14];
		values[0] = super.saveState(context);
		values[1] = _for;
		values[2] = accept;
		values[3] = activeClass;
		values[4] = addClasses;
		values[5] = greedy;
		values[6] = hoverClass;
		values[7] = scope;
		values[8] = tolerance;
		values[9] = ondropactivate;
		values[10] = ondropdeactivate;
		values[11] = ondropover;
		values[12] = ondropout;
		values[13] = ondrop;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.accept = (String) values[2];
		this.activeClass = (String) values[3];
		this.addClasses = (Boolean) values[4];
		this.greedy = (Boolean) values[5];
		this.hoverClass = (String) values[6];
		this.scope = (String) values[7];
		this.tolerance = (String) values[8];
		this.ondropactivate = (String) values[9];
		this.ondropdeactivate = (String) values[10];
		this.ondropover = (String) values[11];
		this.ondropout = (String) values[12];
		this.ondrop = (String) values[13];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}