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

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer;

public abstract class JQueryBaseRenderer extends HtmlBasicRenderer {
	
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
	
	protected void encodeOptionComponentFunction(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentFunction(options, value, nameParameter);
	}

	protected String writeIdAttributeIfNecessary(FacesContext context ,ResponseWriter responseWriter, UIComponent component) {
		return RendererUtilities.writeIdAttributeIfNecessary(context, responseWriter, component);
	}
	

}
