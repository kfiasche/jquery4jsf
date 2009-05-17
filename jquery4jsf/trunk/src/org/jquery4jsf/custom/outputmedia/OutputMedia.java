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
package org.jquery4jsf.custom.outputmedia;

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
import java.lang.Boolean;

public class OutputMedia extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputMedia";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.OutputMedia";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.OutputMediaRenderer";

	private String[] resources;
	private String style;
	private String styleClass;
	private Boolean nospan;
	private Boolean escape;
	private String effect;
	private String eventEffect;

	public OutputMedia() {
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

	public boolean isNospan() {
		if(nospan != null )
			return nospan.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(nospan, "nospan");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setNospan(boolean nospan) {
		this.nospan = new Boolean(nospan);
	}

	public boolean isEscape() {
		if(escape != null )
			return escape.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(escape, "escape");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setEscape(boolean escape) {
		this.escape = new Boolean(escape);
	}

	public String getEffect() {
		if(effect != null )
			return effect;

		String oValue = (String) getLocalOrValueBindingValue(effect, "effect");
		return oValue != null ? oValue : null;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getEventEffect() {
		if(eventEffect != null )
			return eventEffect;

		String oValue = (String) getLocalOrValueBindingValue(eventEffect, "eventEffect");
		return oValue != null ? oValue : null;
	}
	public void setEventEffect(String eventEffect) {
		this.eventEffect = eventEffect;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[7];
		values[0] = super.saveState(context);
		values[1] = style;
		values[2] = styleClass;
		values[3] = nospan;
		values[4] = escape;
		values[5] = effect;
		values[6] = eventEffect;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.style = (String) values[1];
		this.styleClass = (String) values[2];
		this.nospan = (Boolean) values[3];
		this.escape = (Boolean) values[4];
		this.effect = (String) values[5];
		this.eventEffect = (String) values[6];
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