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
package org.jquery4jsf.custom.syntaxhighlighting;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;

public class SyntaxHighlighting extends UIComponentBase implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlSyntaxHighlighting";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.SyntaxHighlighting";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.SyntaxHighlightingRenderer";

	private String[] resources;
	private String type;

	public SyntaxHighlighting() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"syntaxhighlighter/shCore.js",
			"syntaxhighlighter/shBrushBash.js",
			"syntaxhighlighter/shBrushCpp.js",
			"syntaxhighlighter/shBrushCSharp.js",
			"syntaxhighlighter/shBrushCss.js",
			"syntaxhighlighter/shBrushDelphi.js",
			"syntaxhighlighter/shBrushDiff.js",
			"syntaxhighlighter/shBrushGroovy.js",
			"syntaxhighlighter/shBrushJava.js",
			"syntaxhighlighter/shBrushJScript.js",
			"syntaxhighlighter/shBrushPhp.js",
			"syntaxhighlighter/shBrushPlain.js",
			"syntaxhighlighter/shBrushPython.js",
			"syntaxhighlighter/shBrushRuby.js",
			"syntaxhighlighter/shBrushScala.js",
			"syntaxhighlighter/shBrushSql.js",
			"syntaxhighlighter/shBrushVb.js",
			"syntaxhighlighter/shBrushXml.js",
			"syntaxhighlighter/shCore.css",
			"syntaxhighlighter/shThemeDefault.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
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

	public Object saveState(FacesContext context) {
		Object values[] = new Object[2];
		values[0] = super.saveState(context);
		values[1] = type;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.type = (String) values[1];
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