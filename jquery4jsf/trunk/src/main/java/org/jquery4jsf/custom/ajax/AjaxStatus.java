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
package org.jquery4jsf.custom.ajax;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;

public class AjaxStatus extends UIComponentBase implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlAjaxStatus";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.AjaxStatus";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.AjaxStatusRenderer";

	private String[] resources;
	private String onajaxStart;
	private String onajaxSuccess;
	private String onajaxError;
	private String onajaxComplete;
	private String onajaxStop;

	public AjaxStatus() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getOnajaxStart() {
		if(onajaxStart != null )
			return onajaxStart;

		String oValue = (String) getLocalOrValueBindingValue(onajaxStart, "onajaxStart");
		return oValue != null ? oValue : null;
	}
	public void setOnajaxStart(String onajaxStart) {
		this.onajaxStart = onajaxStart;
	}

	public String getOnajaxSuccess() {
		if(onajaxSuccess != null )
			return onajaxSuccess;

		String oValue = (String) getLocalOrValueBindingValue(onajaxSuccess, "onajaxSuccess");
		return oValue != null ? oValue : null;
	}
	public void setOnajaxSuccess(String onajaxSuccess) {
		this.onajaxSuccess = onajaxSuccess;
	}

	public String getOnajaxError() {
		if(onajaxError != null )
			return onajaxError;

		String oValue = (String) getLocalOrValueBindingValue(onajaxError, "onajaxError");
		return oValue != null ? oValue : null;
	}
	public void setOnajaxError(String onajaxError) {
		this.onajaxError = onajaxError;
	}

	public String getOnajaxComplete() {
		if(onajaxComplete != null )
			return onajaxComplete;

		String oValue = (String) getLocalOrValueBindingValue(onajaxComplete, "onajaxComplete");
		return oValue != null ? oValue : null;
	}
	public void setOnajaxComplete(String onajaxComplete) {
		this.onajaxComplete = onajaxComplete;
	}

	public String getOnajaxStop() {
		if(onajaxStop != null )
			return onajaxStop;

		String oValue = (String) getLocalOrValueBindingValue(onajaxStop, "onajaxStop");
		return oValue != null ? oValue : null;
	}
	public void setOnajaxStop(String onajaxStop) {
		this.onajaxStop = onajaxStop;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[6];
		values[0] = super.saveState(context);
		values[1] = onajaxStart;
		values[2] = onajaxSuccess;
		values[3] = onajaxError;
		values[4] = onajaxComplete;
		values[5] = onajaxStop;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.onajaxStart = (String) values[1];
		this.onajaxSuccess = (String) values[2];
		this.onajaxError = (String) values[3];
		this.onajaxComplete = (String) values[4];
		this.onajaxStop = (String) values[5];
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