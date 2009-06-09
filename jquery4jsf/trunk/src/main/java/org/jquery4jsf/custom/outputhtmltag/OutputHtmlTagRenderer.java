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
package org.jquery4jsf.custom.outputhtmltag;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;
import org.jquery4jsf.utilities.TextUtilities;

public class OutputHtmlTagRenderer extends JQueryBaseRenderer {



	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || context == null)
	            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        
	        OutputHtmlTag outputHtml = null;
	        if(component instanceof OutputHtmlTag)
	        	outputHtml = (OutputHtmlTag)component;
	        if(TextUtilities.isStringVuota(outputHtml.getTagName()))
	        	throw new  NullPointerException();
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        responseWriter.endElement(outputHtml.getTagName());
	        
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || context == null)
	            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;

	        OutputHtmlTag outputHtml = null;
	        if(component instanceof OutputHtmlTag)
	        	outputHtml = (OutputHtmlTag)component;
	        
	        if(TextUtilities.isStringVuota(outputHtml.getTagName()))
	        	throw new  NullPointerException();
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        responseWriter.startElement(outputHtml.getTagName(), outputHtml);
	        writeIdAttributeIfNecessary(context, responseWriter, outputHtml);
	        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_STD_ATTR);
	        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_JS_STD_ATTR);
	        RendererUtilities.renderChildren(context, component);
	}

	public void encodeChildren(FacesContext arg0, UIComponent arg1)throws IOException {
	}

	public boolean getRendersChildren() {
		return true;
	}
	
}