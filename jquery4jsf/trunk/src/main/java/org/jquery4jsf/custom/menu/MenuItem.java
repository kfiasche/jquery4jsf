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
package org.jquery4jsf.custom.menu;

import org.jquery4jsf.component.ext.HtmlBaseCommandComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.utilities.MessageFactory;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Object;

import javax.faces.event.ActionEvent;
import java.util.Map;

public class MenuItem extends HtmlBaseCommandComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlMenuItem";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Menu";

	private String[] resources;
	private Boolean ajaxSubmit;
	private String label;
	private Boolean disabled;
	private String disabledClass;
	private String target;

	public MenuItem() {
		setRendererType(null);
		 resources = new String[]{
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isAjaxSubmit() {
		if(ajaxSubmit != null )
			return ajaxSubmit.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(ajaxSubmit, "ajaxSubmit");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAjaxSubmit(boolean ajaxSubmit) {
		this.ajaxSubmit = new Boolean(ajaxSubmit);
	}

	public String getLabel() {
		if(label != null )
			return label;

		String oValue = (String) getLocalOrValueBindingValue(label, "label");
		return oValue != null ? oValue : null;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isDisabled() {
		if(disabled != null )
			return disabled.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(disabled, "disabled");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = new Boolean(disabled);
	}

	public String getDisabledClass() {
		if(disabledClass != null )
			return disabledClass;

		String oValue = (String) getLocalOrValueBindingValue(disabledClass, "disabledClass");
		return oValue != null ? oValue : null;
	}
	public void setDisabledClass(String disabledClass) {
		this.disabledClass = disabledClass;
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

	public Object saveState(FacesContext context) {
		Object values[] = new Object[6];
		values[0] = super.saveState(context);
		values[1] = ajaxSubmit;
		values[2] = label;
		values[3] = disabled;
		values[4] = disabledClass;
		values[5] = target;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.ajaxSubmit = (Boolean) values[1];
		this.label = (String) values[2];
		this.disabled = (Boolean) values[3];
		this.disabledClass = (String) values[4];
		this.target = (String) values[5];
	}

	public String[] getResources() {
		return resources;
	}



	public void decode(FacesContext context) {
		if(context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	
		String clientId = this.getClientId(context);
		Map map = context.getExternalContext().getRequestParameterMap();
		String s1 = (String)map.get(clientId);
		if(s1 == null)
			return;
		this.queueEvent(new ActionEvent(this));
		return;
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