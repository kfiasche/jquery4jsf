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
package org.jquery4jsf.custom.button;

import org.jquery4jsf.component.ext.HtmlBaseCommandComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Object;

public class Button extends HtmlBaseCommandComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlButton";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Button";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.ButtonRenderer";

	private String[] resources;
	private Boolean ajaxSubmit;
	private String icon;
	private Boolean active;
	private Boolean toggle;
	private String checkButtonset;
	private String ontoggle;
	private String target;
	private String url;
	private Boolean semantic;
	private Boolean resetForm;
	private Boolean clearForm;
	private Boolean iframe;
	private String onbeforeSubmit;
	private String onsuccess;

	public Button() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"form/jquery.form.js",
			"button/ui.button.js",
			"themes/base/ui.all.css",
			"button/ui.button.css"
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

	public String getIcon() {
		if(icon != null )
			return icon;

		String oValue = (String) getLocalOrValueBindingValue(icon, "icon");
		return oValue != null ? oValue : null;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isActive() {
		if(active != null )
			return active.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(active, "active");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setActive(boolean active) {
		this.active = new Boolean(active);
	}

	public boolean isToggle() {
		if(toggle != null )
			return toggle.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(toggle, "toggle");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setToggle(boolean toggle) {
		this.toggle = new Boolean(toggle);
	}

	public String getCheckButtonset() {
		if(checkButtonset != null )
			return checkButtonset;

		String oValue = (String) getLocalOrValueBindingValue(checkButtonset, "checkButtonset");
		return oValue != null ? oValue : null;
	}
	public void setCheckButtonset(String checkButtonset) {
		this.checkButtonset = checkButtonset;
	}

	public String getOntoggle() {
		if(ontoggle != null )
			return ontoggle;

		String oValue = (String) getLocalOrValueBindingValue(ontoggle, "ontoggle");
		return oValue != null ? oValue : null;
	}
	public void setOntoggle(String ontoggle) {
		this.ontoggle = ontoggle;
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

	public String getUrl() {
		if(url != null )
			return url;

		String oValue = (String) getLocalOrValueBindingValue(url, "url");
		return oValue != null ? oValue : null;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isSemantic() {
		if(semantic != null )
			return semantic.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(semantic, "semantic");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setSemantic(boolean semantic) {
		this.semantic = new Boolean(semantic);
	}

	public boolean isResetForm() {
		if(resetForm != null )
			return resetForm.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(resetForm, "resetForm");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setResetForm(boolean resetForm) {
		this.resetForm = new Boolean(resetForm);
	}

	public boolean isClearForm() {
		if(clearForm != null )
			return clearForm.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(clearForm, "clearForm");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setClearForm(boolean clearForm) {
		this.clearForm = new Boolean(clearForm);
	}

	public boolean isIframe() {
		if(iframe != null )
			return iframe.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(iframe, "iframe");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setIframe(boolean iframe) {
		this.iframe = new Boolean(iframe);
	}

	public String getOnbeforeSubmit() {
		if(onbeforeSubmit != null )
			return onbeforeSubmit;

		String oValue = (String) getLocalOrValueBindingValue(onbeforeSubmit, "onbeforeSubmit");
		return oValue != null ? oValue : null;
	}
	public void setOnbeforeSubmit(String onbeforeSubmit) {
		this.onbeforeSubmit = onbeforeSubmit;
	}

	public String getOnsuccess() {
		if(onsuccess != null )
			return onsuccess;

		String oValue = (String) getLocalOrValueBindingValue(onsuccess, "onsuccess");
		return oValue != null ? oValue : null;
	}
	public void setOnsuccess(String onsuccess) {
		this.onsuccess = onsuccess;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[15];
		values[0] = super.saveState(context);
		values[1] = ajaxSubmit;
		values[2] = icon;
		values[3] = active;
		values[4] = toggle;
		values[5] = checkButtonset;
		values[6] = ontoggle;
		values[7] = target;
		values[8] = url;
		values[9] = semantic;
		values[10] = resetForm;
		values[11] = clearForm;
		values[12] = iframe;
		values[13] = onbeforeSubmit;
		values[14] = onsuccess;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.ajaxSubmit = (Boolean) values[1];
		this.icon = (String) values[2];
		this.active = (Boolean) values[3];
		this.toggle = (Boolean) values[4];
		this.checkButtonset = (String) values[5];
		this.ontoggle = (String) values[6];
		this.target = (String) values[7];
		this.url = (String) values[8];
		this.semantic = (Boolean) values[9];
		this.resetForm = (Boolean) values[10];
		this.clearForm = (Boolean) values[11];
		this.iframe = (Boolean) values[12];
		this.onbeforeSubmit = (String) values[13];
		this.onsuccess = (String) values[14];
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