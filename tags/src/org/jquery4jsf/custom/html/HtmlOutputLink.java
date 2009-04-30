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
package org.jquery4jsf.custom.html;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.Object;
import javax.faces.convert.Converter;
import java.lang.String;

public class HtmlOutputLink extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlOutputLink";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.HtmlOutputLink";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.HtmlOutputLinkRenderer";

	private String[] resources;
	private String style;
	private String styleClass;
	private String charset;
	private String coords;
	private String hreflang;
	private String name;
	private String rel;
	private String rev;
	private String shape;
	private String target;

	public HtmlOutputLink() {
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
		Object values[] = new Object[11];
		values[0] = super.saveState(context);
		values[1] = style;
		values[2] = styleClass;
		values[3] = charset;
		values[4] = coords;
		values[5] = hreflang;
		values[6] = name;
		values[7] = rel;
		values[8] = rev;
		values[9] = shape;
		values[10] = target;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.style = (String) values[1];
		this.styleClass = (String) values[2];
		this.charset = (String) values[3];
		this.coords = (String) values[4];
		this.hreflang = (String) values[5];
		this.name = (String) values[6];
		this.rel = (String) values[7];
		this.rev = (String) values[8];
		this.shape = (String) values[9];
		this.target = (String) values[10];
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