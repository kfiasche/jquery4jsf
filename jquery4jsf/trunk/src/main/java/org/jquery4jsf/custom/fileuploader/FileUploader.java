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
package org.jquery4jsf.custom.fileuploader;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
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

public class FileUploader extends HtmlInputText implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlFileUploader";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.FileUploader";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.FileUploaderRenderer";

	private String[] resources;
	private String scrollHeight;

	public FileUploader() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"fileuploader/jquery.MultiFile.js",
			"uiblock/jquery.blockUI.js"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getScrollHeight() {
		if(scrollHeight != null )
			return scrollHeight;

		String oValue = (String) getLocalOrValueBindingValue(scrollHeight, "scrollHeight");
		return oValue != null ? oValue : null;
	}
	public void setScrollHeight(String scrollHeight) {
		this.scrollHeight = scrollHeight;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[2];
		values[0] = super.saveState(context);
		values[1] = scrollHeight;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.scrollHeight = (String) values[1];
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