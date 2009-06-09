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
package org.jquery4jsf.custom.panel;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class PanelExRenderer extends PanelExBaseRenderer {

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		PanelEx panelEx = null;
		if(component instanceof PanelEx)
			panelEx = (PanelEx)component;
		
		ResponseWriter responseWriter = context.getResponseWriter();
		// TODO devo trovare il modo per scrivere i script nell'head
		String[] list = panelEx.getResources();
		for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
		
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(panelEx.getClientId(context));
        JSAttribute jsPanel = new JSAttribute("panel", false);
        StringBuffer sbOption = new StringBuffer();
        jsPanel.addValue(encodeOptionComponent(sbOption, panelEx, context));
        element.addAttribute(jsPanel);

        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.encodeImportJavascripScript(component, responseWriter, sb);
		
		
		responseWriter.startElement(HTML.TAG_DIV, panelEx);
		responseWriter.writeAttribute("id", panelEx.getClientId(context), "id");

		responseWriter.writeAttribute("class", panelEx.getStyleClass(), null);
		if(panelEx.getStyle() != null)
			responseWriter.writeAttribute("style", panelEx.getStyle(), null);
		
		responseWriter.startElement(HTML.TAG_H3, panelEx);
		responseWriter.writeText(panelEx.getHeader(), "header");
		responseWriter.endElement(HTML.TAG_H3);
		responseWriter.startElement(HTML.TAG_DIV, null);
	}

	public void encodeEnd(FacesContext context,UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.endElement(HTML.TAG_DIV);
		responseWriter.endElement(HTML.TAG_DIV);
	}
	
}
