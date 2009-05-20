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
package org.jquery4jsf.custom.outputbody;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
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

public class OutputBody extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputBody";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.OutputBody";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.OutputBodyRenderer";

	private String[] resources;
	private String style;
	private String styleClass;
	private String onclick;
	private String ondblclick;
	private String onload;
	private String onmousedown;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onunload;

	public OutputBody() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getStyle() {
		if(style != null )
			return style;

		String oValue = (String) getLocalOrValueBindingValue(style, "style");
		return oValue != null ? oValue : null;
	}
	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleClass() {
		if(styleClass != null )
			return styleClass;

		String oValue = (String) getLocalOrValueBindingValue(styleClass, "styleClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getOnclick() {
		if(onclick != null )
			return onclick;

		String oValue = (String) getLocalOrValueBindingValue(onclick, "onclick");
		return oValue != null ? oValue : null;
	}
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOndblclick() {
		if(ondblclick != null )
			return ondblclick;

		String oValue = (String) getLocalOrValueBindingValue(ondblclick, "ondblclick");
		return oValue != null ? oValue : null;
	}
	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnload() {
		if(onload != null )
			return onload;

		String oValue = (String) getLocalOrValueBindingValue(onload, "onload");
		return oValue != null ? oValue : null;
	}
	public void setOnload(String onload) {
		this.onload = onload;
	}

	public String getOnmousedown() {
		if(onmousedown != null )
			return onmousedown;

		String oValue = (String) getLocalOrValueBindingValue(onmousedown, "onmousedown");
		return oValue != null ? oValue : null;
	}
	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmousemove() {
		if(onmousemove != null )
			return onmousemove;

		String oValue = (String) getLocalOrValueBindingValue(onmousemove, "onmousemove");
		return oValue != null ? oValue : null;
	}
	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		if(onmouseout != null )
			return onmouseout;

		String oValue = (String) getLocalOrValueBindingValue(onmouseout, "onmouseout");
		return oValue != null ? oValue : null;
	}
	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnmouseover() {
		if(onmouseover != null )
			return onmouseover;

		String oValue = (String) getLocalOrValueBindingValue(onmouseover, "onmouseover");
		return oValue != null ? oValue : null;
	}
	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmouseup() {
		if(onmouseup != null )
			return onmouseup;

		String oValue = (String) getLocalOrValueBindingValue(onmouseup, "onmouseup");
		return oValue != null ? oValue : null;
	}
	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	public String getOnkeydown() {
		if(onkeydown != null )
			return onkeydown;

		String oValue = (String) getLocalOrValueBindingValue(onkeydown, "onkeydown");
		return oValue != null ? oValue : null;
	}
	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeypress() {
		if(onkeypress != null )
			return onkeypress;

		String oValue = (String) getLocalOrValueBindingValue(onkeypress, "onkeypress");
		return oValue != null ? oValue : null;
	}
	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeyup() {
		if(onkeyup != null )
			return onkeyup;

		String oValue = (String) getLocalOrValueBindingValue(onkeyup, "onkeyup");
		return oValue != null ? oValue : null;
	}
	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnunload() {
		if(onunload != null )
			return onunload;

		String oValue = (String) getLocalOrValueBindingValue(onunload, "onunload");
		return oValue != null ? oValue : null;
	}
	public void setOnunload(String onunload) {
		this.onunload = onunload;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[15];
		values[0] = super.saveState(context);
		values[1] = style;
		values[2] = styleClass;
		values[3] = onclick;
		values[4] = ondblclick;
		values[5] = onload;
		values[6] = onmousedown;
		values[7] = onmousemove;
		values[8] = onmouseout;
		values[9] = onmouseover;
		values[10] = onmouseup;
		values[11] = onkeydown;
		values[12] = onkeypress;
		values[13] = onkeyup;
		values[14] = onunload;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.style = (String) values[1];
		this.styleClass = (String) values[2];
		this.onclick = (String) values[3];
		this.ondblclick = (String) values[4];
		this.onload = (String) values[5];
		this.onmousedown = (String) values[6];
		this.onmousemove = (String) values[7];
		this.onmouseout = (String) values[8];
		this.onmouseover = (String) values[9];
		this.onmouseup = (String) values[10];
		this.onkeydown = (String) values[11];
		this.onkeypress = (String) values[12];
		this.onkeyup = (String) values[13];
		this.onunload = (String) values[14];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}