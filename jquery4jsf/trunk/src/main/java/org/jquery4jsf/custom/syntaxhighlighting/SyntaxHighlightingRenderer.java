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
package org.jquery4jsf.custom.syntaxhighlighting;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class SyntaxHighlightingRenderer extends SyntaxHighlightingBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || component == null)
	            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        responseWriter.endElement(HTML.TAG_PRE);      
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || component == null)
	            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        SyntaxHighlighting syntax = null;
	        if(component instanceof SyntaxHighlighting)
	        	syntax = (SyntaxHighlighting)component;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        
	        // TODO devo trovare il modo per scrivere i script nell'head
	        String[] list = syntax.getResources();
	        for (int i = 0; i < list.length; i++) {
				String resource = list[i];
				ResourceContext.getInstance().addResource(resource);
			}
	        StringBuffer sb = new StringBuffer();
	        sb.append("\n");
	        sb.append("\t\tSyntaxHighlighter.config.clipboardSwf = 'scripts/clipboard.swf';\n");
	        sb.append("\t\tSyntaxHighlighter.all();\n");
	        sb.append("\n");
	        RendererUtilities.createTagScriptForJs(component, responseWriter,  sb);
	        responseWriter.startElement(HTML.TAG_PRE, syntax);
	        String styleClass = "brush: " + syntax.getType() +";";
	        responseWriter.writeAttribute("class", styleClass, null);
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		super.encodeChildren(context, component);
	}

	
}
