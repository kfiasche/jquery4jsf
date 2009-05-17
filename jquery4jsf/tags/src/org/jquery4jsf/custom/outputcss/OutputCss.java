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
package org.jquery4jsf.custom.outputcss;

import javax.faces.component.UIComponentBase;
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

public class OutputCss extends UIComponentBase implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputCss";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.OutputCss";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.OutputCssRenderer";

	private String[] resources;
	private String hreflang;
	private String type;
	private String href;
	private String media;
	private String rel;
	private String charset;

	public OutputCss() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
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

	public String getType() {
		if(type != null )
			return type;

		String oValue = (String) getLocalOrValueBindingValue(type, "type");
		return oValue != null ? oValue : null;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getHref() {
		if(href != null )
			return href;

		String oValue = (String) getLocalOrValueBindingValue(href, "href");
		return oValue != null ? oValue : null;
	}
	public void setHref(String href) {
		this.href = href;
	}

	public String getMedia() {
		if(media != null )
			return media;

		String oValue = (String) getLocalOrValueBindingValue(media, "media");
		return oValue != null ? oValue : null;
	}
	public void setMedia(String media) {
		this.media = media;
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

	public String getCharset() {
		if(charset != null )
			return charset;

		String oValue = (String) getLocalOrValueBindingValue(charset, "charset");
		return oValue != null ? oValue : null;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[7];
		values[0] = super.saveState(context);
		values[1] = hreflang;
		values[2] = type;
		values[3] = href;
		values[4] = media;
		values[5] = rel;
		values[6] = charset;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.hreflang = (String) values[1];
		this.type = (String) values[2];
		this.href = (String) values[3];
		this.media = (String) values[4];
		this.rel = (String) values[5];
		this.charset = (String) values[6];
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