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
package org.jquery4jsf.custom.inputmask;

import org.jquery4jsf.component.ext.HtmlInputText;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.custom.UIInteractions;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Object;
import javax.faces.convert.Converter;
import javax.faces.validator.Validator;
import javax.faces.event.ValueChangeListener;
import java.lang.Integer;

public class InputMask extends HtmlInputText implements JQueryHtmlObject,UIInteractions {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlInputMask";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.InputMask";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.InputMaskRenderer";

	private String[] resources;
	private String _for;
	private String mask;
	private String placeholder;
	private Boolean allowPartials;
	private String oncompleted;

	public InputMask() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"ui/ui.core.js",
			"mask/ui.mask.js",
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

	public String getMask() {
		if(mask != null )
			return mask;

		String oValue = (String) getLocalOrValueBindingValue(mask, "mask");
		return oValue != null ? oValue : null;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getPlaceholder() {
		if(placeholder != null )
			return placeholder;

		String oValue = (String) getLocalOrValueBindingValue(placeholder, "placeholder");
		return oValue != null ? oValue : null;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public boolean isAllowPartials() {
		if(allowPartials != null )
			return allowPartials.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(allowPartials, "allowPartials");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAllowPartials(boolean allowPartials) {
		this.allowPartials = new Boolean(allowPartials);
	}

	public String getOncompleted() {
		if(oncompleted != null )
			return oncompleted;

		String oValue = (String) getLocalOrValueBindingValue(oncompleted, "oncompleted");
		return oValue != null ? oValue : null;
	}
	public void setOncompleted(String oncompleted) {
		this.oncompleted = oncompleted;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[6];
		values[0] = super.saveState(context);
		values[1] = this._for;
		values[2] = this.mask;
		values[3] = this.placeholder;
		values[4] = this.allowPartials;
		values[5] = this.oncompleted;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.mask = (String) values[2];
		this.placeholder = (String) values[3];
		this.allowPartials = (Boolean) values[4];
		this.oncompleted = (String) values[5];
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

	public void encodeScript(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof org.jquery4jsf.renderkit.JQueryRenderer) {
			((org.jquery4jsf.renderkit.JQueryRenderer)renderer).encodeScript(facesContext, this);
		}
	}
}