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
package org.jquery4jsf.custom.commandlink;

import javax.faces.component.html.HtmlCommandLink;
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

public class CommandLink extends HtmlCommandLink implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.CommandLink";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.CommandLink";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.CommandLinkRenderer";

	private String[] resources;
	private String target;
	private String charset;
	private String coords;
	private String hreflang;
	private String name;
	private String rel;
	private String rev;
	private String shape;

	public CommandLink() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"form/jquery.form.js",
			"themes/base/all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
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

	public String getCharset() {
		if(charset != null )
			return charset;

		String oValue = (String) getLocalOrValueBindingValue(charset, "charset");
		return oValue != null ? oValue : null;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getCoords() {
		if(coords != null )
			return coords;

		String oValue = (String) getLocalOrValueBindingValue(coords, "coords");
		return oValue != null ? oValue : null;
	}
	public void setCoords(String coords) {
		this.coords = coords;
	}

	public String getHreflang() {
		if(hreflang != null )
			return hreflang;

		String oValue = (String) getLocalOrValueBindingValue(hreflang, "hreflang");
		return oValue != null ? oValue : null;
	}
	public void setHreflang(String hreflang) {
		this.hreflang = hreflang;
	}

	public String getName() {
		if(name != null )
			return name;

		String oValue = (String) getLocalOrValueBindingValue(name, "name");
		return oValue != null ? oValue : null;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRel() {
		if(rel != null )
			return rel;

		String oValue = (String) getLocalOrValueBindingValue(rel, "rel");
		return oValue != null ? oValue : null;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getRev() {
		if(rev != null )
			return rev;

		String oValue = (String) getLocalOrValueBindingValue(rev, "rev");
		return oValue != null ? oValue : null;
	}
	public void setRev(String rev) {
		this.rev = rev;
	}

	public String getShape() {
		if(shape != null )
			return shape;

		String oValue = (String) getLocalOrValueBindingValue(shape, "shape");
		return oValue != null ? oValue : null;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[9];
		values[0] = super.saveState(context);
		values[1] = target;
		values[2] = charset;
		values[3] = coords;
		values[4] = hreflang;
		values[5] = name;
		values[6] = rel;
		values[7] = rev;
		values[8] = shape;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.target = (String) values[1];
		this.charset = (String) values[2];
		this.coords = (String) values[3];
		this.hreflang = (String) values[4];
		this.name = (String) values[5];
		this.rel = (String) values[6];
		this.rev = (String) values[7];
		this.shape = (String) values[8];
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