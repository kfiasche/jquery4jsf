/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.jquery4jsf.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.javascript.JSElement;

public abstract class JQueryBaseRenderer extends HtmlBasicRenderer implements JQueryRenderer {
	
	public void encodeScript(FacesContext context, JQueryHtmlObject queryComponent) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		JSElement element = getJSElement(context, (UIComponent) queryComponent);
		if (element != null){
			responseWriter.write("\n");
			responseWriter.write(element.toJavaScriptCode());
			responseWriter.write("\n");
		}
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, boolean value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, int value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, Object value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentOptionsByType(StringBuffer options, String value, String nameParameter, Object defaultValue) {
		RendererUtilities.createOptionComponentOptionsByType(options, value, nameParameter);
	}
	
	protected void encodeOptionComponentArrayByType(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentArrayByType(options, value, nameParameter);
	}
	
	protected void encodeOptionComponentFunction(StringBuffer options, String value, String nameParameter, String params) {
		RendererUtilities.createOptionComponentFunction(options, value, nameParameter, params);
	}

	protected String encodeOptionsWithUIParam(UIComponent component){
		return RendererUtilities.encodeOptionsWithUIParam(component);
	}
	
	protected void encodeResources(JQueryHtmlObject jqcomponent) {
		RendererUtilities.encodeResources(jqcomponent);
	}
	
	protected void encodeAjaxEventChild(FacesContext context, UIComponent component) throws IOException {
		RendererUtilities.encodeAjaxEventChild(context, component);
	}
}
