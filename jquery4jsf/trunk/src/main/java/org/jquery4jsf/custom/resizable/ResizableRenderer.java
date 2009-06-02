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
package org.jquery4jsf.custom.resizable;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.draggable.Draggable;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class ResizableRenderer extends ResizableBaseRenderer {

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Resizable resizable = null;
        if(component instanceof Resizable)
            resizable = (Resizable)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = resizable.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        String clientId = RendererUtilities.encodeIdInteractions(component, context);
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(clientId);
        JSAttribute jsResizable = new JSAttribute("resizable", false);
        StringBuffer sbOption = new StringBuffer();
        jsResizable.addValue(encodeOptionComponent(sbOption, resizable, context));
        element.addAttribute(jsResizable);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
        if (RendererUtilities.isUniqueId(component)){
        	encodeStartDivWrapper(context, resizable, clientId);
        }
	}

	private void encodeStartDivWrapper(FacesContext context, Resizable resizable, String clientId) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, resizable);
    	responseWriter.writeAttribute("id", clientId, "id");
    	String styleClass = " ui-widget-content";
    	if (resizable.getStyleClass() != null)
    	{
    		styleClass = resizable.getStyleClass().concat(styleClass);
    	}
    	responseWriter.writeAttribute("class", styleClass , "styleClass");
    	if (resizable.getStyle() != null){
    		responseWriter.writeAttribute("style", resizable.getStyle() , "style");
    	}
	}
	
	private void encodeEndDivWrapper(FacesContext context) throws IOException {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.endElement(HTML.TAG_DIV);
	}
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        if (RendererUtilities.isUniqueId(component)){
        	encodeEndDivWrapper(context);
        }
	}
}
