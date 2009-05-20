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
package org.jquery4jsf.custom.scriptcollector;

import javax.faces.component.UIComponentBase;
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
import javax.faces.el.MethodBinding;

public class ScriptCollector extends UIComponentBase implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.ScriptCollector";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.ScriptCollector";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.ScriptCollectorRenderer";

	private String[] resources;
	private MethodBinding onPageLoadBegin;
	private MethodBinding onPageLoadEnd;
	private MethodBinding onPagePost;
	private Boolean disableForm;
	private String ignoreIdFormDisable;

	public ScriptCollector() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public MethodBinding getOnPageLoadBegin() {
		if(onPageLoadBegin != null )
			return onPageLoadBegin;

		MethodBinding oValue = (MethodBinding) getLocalOrValueBindingValue(onPageLoadBegin, "onPageLoadBegin");
		return oValue != null ? oValue : null;
	}
	public void setOnPageLoadBegin(MethodBinding onPageLoadBegin) {
		this.onPageLoadBegin = onPageLoadBegin;
	}

	public MethodBinding getOnPageLoadEnd() {
		if(onPageLoadEnd != null )
			return onPageLoadEnd;

		MethodBinding oValue = (MethodBinding) getLocalOrValueBindingValue(onPageLoadEnd, "onPageLoadEnd");
		return oValue != null ? oValue : null;
	}
	public void setOnPageLoadEnd(MethodBinding onPageLoadEnd) {
		this.onPageLoadEnd = onPageLoadEnd;
	}

	public MethodBinding getOnPagePost() {
		if(onPagePost != null )
			return onPagePost;

		MethodBinding oValue = (MethodBinding) getLocalOrValueBindingValue(onPagePost, "onPagePost");
		return oValue != null ? oValue : null;
	}
	public void setOnPagePost(MethodBinding onPagePost) {
		this.onPagePost = onPagePost;
	}

	public boolean isDisableForm() {
		if(disableForm != null )
			return disableForm.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(disableForm, "disableForm");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setDisableForm(boolean disableForm) {
		this.disableForm = new Boolean(disableForm);
	}

	public String getIgnoreIdFormDisable() {
		if(ignoreIdFormDisable != null )
			return ignoreIdFormDisable;

		String oValue = (String) getLocalOrValueBindingValue(ignoreIdFormDisable, "ignoreIdFormDisable");
		return oValue != null ? oValue : null;
	}
	public void setIgnoreIdFormDisable(String ignoreIdFormDisable) {
		this.ignoreIdFormDisable = ignoreIdFormDisable;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[6];
		values[0] = super.saveState(context);
		values[1] = saveAttachedState(context, onPageLoadBegin);
		values[2] = saveAttachedState(context, onPageLoadEnd);
		values[3] = saveAttachedState(context, onPagePost);
		values[4] = disableForm;
		values[5] = ignoreIdFormDisable;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.onPageLoadBegin = (MethodBinding) restoreAttachedState(context, values[1]);
		this.onPageLoadEnd = (MethodBinding) restoreAttachedState(context, values[2]);
		this.onPagePost = (MethodBinding) restoreAttachedState(context, values[3]);
		this.disableForm = (Boolean) values[4];
		this.ignoreIdFormDisable = (String) values[5];
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