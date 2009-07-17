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
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;

public class OutputBody extends HtmlBaseOutputComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputBody";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.OutputBody";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.OutputBodyRenderer";

	private String[] resources;
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
		Object values[] = new Object[13];
		values[0] = super.saveState(context);
		values[1] = this.onclick;
		values[2] = this.ondblclick;
		values[3] = this.onload;
		values[4] = this.onmousedown;
		values[5] = this.onmousemove;
		values[6] = this.onmouseout;
		values[7] = this.onmouseover;
		values[8] = this.onmouseup;
		values[9] = this.onkeydown;
		values[10] = this.onkeypress;
		values[11] = this.onkeyup;
		values[12] = this.onunload;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.onclick = (String) values[1];
		this.ondblclick = (String) values[2];
		this.onload = (String) values[3];
		this.onmousedown = (String) values[4];
		this.onmousemove = (String) values[5];
		this.onmouseout = (String) values[6];
		this.onmouseover = (String) values[7];
		this.onmouseup = (String) values[8];
		this.onkeydown = (String) values[9];
		this.onkeypress = (String) values[10];
		this.onkeyup = (String) values[11];
		this.onunload = (String) values[12];
	}

	public String[] getResources() {
		return resources;
	}
}