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
package org.jquery4jsf.custom.outputcss;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.HtmlBasicRenderer;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;
public class OutputCssRenderer extends HtmlBasicRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || context == null)
	            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        responseWriter.endElement(HTML.TAG_LINK);
	        
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || context == null)
	            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;

	        OutputCss outputCss = null;
	        if(component instanceof OutputCss)
	        	outputCss = (OutputCss)component;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        responseWriter.startElement(HTML.TAG_LINK, outputCss);
	        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_LINK_TAG_ATTR);
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
	}


}
