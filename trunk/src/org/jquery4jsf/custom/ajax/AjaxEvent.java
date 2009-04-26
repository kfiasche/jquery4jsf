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
package org.jquery4jsf.custom.ajax;

import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Object;
import javax.faces.event.ActionListener;
import javax.faces.el.MethodBinding;

public class AjaxEvent extends UICommand implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlAjaxEvent";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.AjaxEvent";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.AjaxEventRenderer";

	private String[] resources;
	private String reRender;
	private String event;
	private Boolean partialSubmit;

	public AjaxEvent() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ajaxcontent/jquery.ajaxContent.js",
			"form/jquery.form.js"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getReRender() {
		if(reRender != null )
			return reRender;

		String oValue = (String) getLocalOrValueBindingValue(reRender, "reRender");
		return oValue != null ? oValue : null;
	}
	public void setReRender(String reRender) {
		this.reRender = reRender;
	}

	public String getEvent() {
		if(event != null )
			return event;

		String oValue = (String) getLocalOrValueBindingValue(event, "event");
		return oValue != null ? oValue : "click";
	}
	public void setEvent(String event) {
		this.event = event;
	}

	public boolean isPartialSubmit() {
		if(partialSubmit != null )
			return partialSubmit.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(partialSubmit, "partialSubmit");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setPartialSubmit(boolean partialSubmit) {
		this.partialSubmit = new Boolean(partialSubmit);
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[4];
		values[0] = super.saveState(context);
		values[1] = reRender;
		values[2] = event;
		values[3] = partialSubmit;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.reRender = (String) values[1];
		this.event = (String) values[2];
		this.partialSubmit = (Boolean) values[3];
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

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}