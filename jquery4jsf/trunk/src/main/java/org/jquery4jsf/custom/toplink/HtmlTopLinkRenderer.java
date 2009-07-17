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
package org.jquery4jsf.custom.toplink;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;

public class HtmlTopLinkRenderer extends HtmlTopLinkBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(context == null || component == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		HtmlTopLink topLink = null;
		if(component instanceof HtmlTopLink)
			topLink = (HtmlTopLink)component;
		
		encodeResources(topLink);
		encodeScriptTopLink(context, topLink);
		encodeMarkupTopLink(context, topLink);
	}

	protected void encodeMarkupTopLink(FacesContext context, HtmlTopLink topLink) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_A, topLink);
		responseWriter.writeAttribute("id", topLink.getClientId(context), "id");
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, topLink, HTML.HTML_STD_ATTR);
		responseWriter.writeAttribute("href", "#" + topLink.getTarget(), "target");
		responseWriter.writeText(topLink.getValue(), "value");
		responseWriter.endElement(HTML.TAG_A);
	}

	protected void encodeScriptTopLink(FacesContext context, HtmlTopLink topLink) throws IOException {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, topLink));
        documentElement.addFunctionToReady(function);
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
		HtmlTopLink topLink = null;
		if(component instanceof HtmlTopLink)
			topLink = (HtmlTopLink)component;
		String clientId = topLink.getClientId(context);
		JSElement element = new JSElement(clientId);
		JSAttribute jsTooltip = new JSAttribute("toplink", false);
		StringBuffer sbOption = new StringBuffer();
		jsTooltip.addValue(encodeOptionComponent(sbOption, topLink, context));
		element.addAttribute(jsTooltip);
		return element;
	}

	
}