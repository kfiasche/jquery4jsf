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
package org.jquery4jsf.custom.paragraph;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class ParagraphRenderer extends ParagraphBaseRenderer{

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		Paragraph paragraph = null;
		if(component instanceof Paragraph)
			paragraph = (Paragraph)component;
		
		// TODO devo trovare il modo per scrivere i script nell'head
		String[] list = paragraph.getResources();
		for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
		
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_P, paragraph);
		writeIdAttributeIfNecessary(context, responseWriter, component);
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, paragraph, HTML.HTML_STD_ATTR);
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, paragraph, HTML.HTML_JS_STD_ATTR);
		
		Object value = getValue(paragraph);
		if (value != null){
			responseWriter.writeText(value, "value");
		}
		
	}
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.endElement(HTML.TAG_P);
	}

	protected Object getValue(UIComponent component){
		Object value = null;
		try {
			value = ((ValueHolder) component).getValue();
		} catch (Exception e) {
			throw new FacesException(e);
		}
		return value;
	}
}
