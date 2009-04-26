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
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Object;
import javax.faces.event.ActionListener;
import javax.faces.el.MethodBinding;

public class Button extends HtmlBaseCommandComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlButton";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Button";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.ButtonRenderer";

	private String[] resources;
	private Boolean partialSubmit;
	private String target;
	private String url;
	private String typeSubmit;
	private String onbeforeSubmit;
	private String onsuccess;
	private String dataType;
	private Boolean semantic;
	private Boolean resetForm;
	private Boolean clearForm;
	private Boolean iframe;

	public Button() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"form/jquery.form.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isPartialSubmit() {
		if(partialSubmit != null )
			return partialSubmit.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(partialSubmit, "partialSubmit");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setPartialSubmit(boolean partialSubmit) {
		this.partialSubmit = new Boolean(partialSubmit);
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

	public String getTypeSubmit() {
		if(typeSubmit != null )
			return typeSubmit;

		String oValue = (String) getLocalOrValueBindingValue(typeSubmit, "typeSubmit");
		return oValue != null ? oValue : null;
	}
	public void setTypeSubmit(String typeSubmit) {
		this.typeSubmit = typeSubmit;
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

	public String getDataType() {
		if(dataType != null )
			return dataType;

		String oValue = (String) getLocalOrValueBindingValue(dataType, "dataType");
		return oValue != null ? oValue : null;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
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

	public Object saveState(FacesContext context) {
		Object values[] = new Object[12];
		values[0] = super.saveState(context);
		values[1] = partialSubmit;
		values[2] = target;
		values[3] = url;
		values[4] = typeSubmit;
		values[5] = onbeforeSubmit;
		values[6] = onsuccess;
		values[7] = dataType;
		values[8] = semantic;
		values[9] = resetForm;
		values[10] = clearForm;
		values[11] = iframe;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.partialSubmit = (Boolean) values[1];
		this.target = (String) values[2];
		this.url = (String) values[3];
		this.typeSubmit = (String) values[4];
		this.onbeforeSubmit = (String) values[5];
		this.onsuccess = (String) values[6];
		this.dataType = (String) values[7];
		this.semantic = (Boolean) values[8];
		this.resetForm = (Boolean) values[9];
		this.clearForm = (Boolean) values[10];
		this.iframe = (Boolean) values[11];
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