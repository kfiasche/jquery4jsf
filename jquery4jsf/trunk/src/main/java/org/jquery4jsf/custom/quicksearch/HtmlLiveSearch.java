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
package org.jquery4jsf.custom.quicksearch;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.custom.UIInteractions;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;

public class HtmlLiveSearch extends HtmlBaseOutputComponent implements JQueryHtmlObject,UIInteractions {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlLiveSearch";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.LiveSearch";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.HtmlLiveSearchRenderer";

	private String[] resources;
	private String target;
	private String _for;
	private String type;
	private Integer minChars;
	private Integer delay;

	public HtmlLiveSearch() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"ui/ui.core.js",
			"search/ui.searchfilter.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getTarget() {
		if(target != null )
			return target;

		String oValue = (String) getLocalOrValueBindingValue(target, "target");
		return oValue != null ? oValue : null;
	}
	public void setTarget(String target) {
		this.target = target;
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

	public String getType() {
		if(type != null )
			return type;

		String oValue = (String) getLocalOrValueBindingValue(type, "type");
		return oValue != null ? oValue : null;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getMinChars() {
		if(minChars != null )
			return minChars.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(minChars, "minChars");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMinChars(int minChars) {
		this.minChars = new Integer(minChars);
	}

	public int getDelay() {
		if(delay != null )
			return delay.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(delay, "delay");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setDelay(int delay) {
		this.delay = new Integer(delay);
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[6];
		values[0] = super.saveState(context);
		values[1] = this.target;
		values[2] = this._for;
		values[3] = this.type;
		values[4] = this.minChars;
		values[5] = this.delay;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.target = (String) values[1];
		this._for = (String) values[2];
		this.type = (String) values[3];
		this.minChars = (Integer) values[4];
		this.delay = (Integer) values[5];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodeScript(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof org.jquery4jsf.renderkit.JQueryRenderer) {
			((org.jquery4jsf.renderkit.JQueryRenderer)renderer).encodeScript(facesContext, this);
		}
	}
}