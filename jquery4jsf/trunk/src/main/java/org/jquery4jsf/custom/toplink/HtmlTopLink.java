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
package org.jquery4jsf.custom.toplink;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Object;
import javax.faces.convert.Converter;
import java.lang.Integer;

public class HtmlTopLink extends HtmlBaseOutputComponent implements JQueryHtmlObject {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTopLink";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.HtmlTopLink";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.HtmlTopLinkRenderer";

	private String[] resources;
	private Integer min;
	private Integer fadeSpeed;
	private Integer ieOffset;
	private String target;

	public HtmlTopLink() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"ui/ui.core.js",
			"toplink/ui.toplink.js",
			"external/jquery.scrollTo.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public int getMin() {
		if(min != null )
			return min.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(min, "min");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMin(int min) {
		this.min = new Integer(min);
	}

	public int getFadeSpeed() {
		if(fadeSpeed != null )
			return fadeSpeed.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(fadeSpeed, "fadeSpeed");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setFadeSpeed(int fadeSpeed) {
		this.fadeSpeed = new Integer(fadeSpeed);
	}

	public int getIeOffset() {
		if(ieOffset != null )
			return ieOffset.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(ieOffset, "ieOffset");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setIeOffset(int ieOffset) {
		this.ieOffset = new Integer(ieOffset);
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
		Object values[] = new Object[5];
		values[0] = super.saveState(context);
		values[1] = this.min;
		values[2] = this.fadeSpeed;
		values[3] = this.ieOffset;
		values[4] = this.target;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.min = (Integer) values[1];
		this.fadeSpeed = (Integer) values[2];
		this.ieOffset = (Integer) values[3];
		this.target = (String) values[4];
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