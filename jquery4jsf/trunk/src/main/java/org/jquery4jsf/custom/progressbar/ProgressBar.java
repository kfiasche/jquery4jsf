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
package org.jquery4jsf.custom.progressbar;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;

public class ProgressBar extends HtmlBaseOutputComponent implements JQueryHtmlObject {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlProgressBar";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.ProgressBar";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.ProgressBarRenderer";

	private String[] resources;
	private Integer progressBarValue;
	private Boolean resizable;
	private String onchange;

	public ProgressBar() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"ui/ui.core.js",
			"progressbar/ui.progressbar.js",
			"ui/ui.resizable.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public int getProgressBarValue() {
		if(progressBarValue != null )
			return progressBarValue.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(progressBarValue, "progressBarValue");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setProgressBarValue(int progressBarValue) {
		this.progressBarValue = new Integer(progressBarValue);
	}

	public boolean isResizable() {
		if(resizable != null )
			return resizable.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(resizable, "resizable");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setResizable(boolean resizable) {
		this.resizable = new Boolean(resizable);
	}

	public String getOnchange() {
		if(onchange != null )
			return onchange;

		String oValue = (String) getLocalOrValueBindingValue(onchange, "onchange");
		return oValue != null ? oValue : "false";
	}
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[4];
		values[0] = super.saveState(context);
		values[1] = this.progressBarValue;
		values[2] = this.resizable;
		values[3] = this.onchange;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.progressBarValue = (Integer) values[1];
		this.resizable = (Boolean) values[2];
		this.onchange = (String) values[3];
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