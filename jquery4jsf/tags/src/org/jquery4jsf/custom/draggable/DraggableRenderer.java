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
package org.jquery4jsf.custom.draggable;

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

import com.sun.faces.util.Util;

public class DraggableRenderer extends DraggableBaseRenderer {

	public static final String RENDERER_TYPE = Draggable.DEFAULT_RENDERER;
	
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Draggable draggable = null;
        if(component instanceof Draggable)
            draggable = (Draggable)component;
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = draggable.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        String clientId = draggable.getClientId(context);
        if (draggable.getFor() != null){
        	clientId = RendererUtilities.getJQueryIdComponent(draggable.getFor(), context, draggable);
        }
        JSElement element = new JSElement(clientId);
        JSAttribute jsDraggable = new JSAttribute("draggable", false);
        StringBuffer sbOption = new StringBuffer();
        jsDraggable.addValue(encodeOptionComponent(sbOption, draggable, context));
        element.addAttribute(jsDraggable);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        if (draggable.getFor() == null){
        	responseWriter.startElement(HTML.TAG_DIV, draggable);
        	writeIdAttributeIfNecessary(context, responseWriter, component);
        	responseWriter.writeAttribute("class", "ui-widget-content" , null);
        }
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Draggable draggable = null;
        if(component instanceof Draggable)
            draggable = (Draggable)component;
        
        if (draggable.getFor() == null){
        	ResponseWriter responseWriter = context.getResponseWriter();
        	responseWriter.endElement(HTML.TAG_DIV);
        }
	}
	
}
