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

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class ResizableRenderer extends ResizableBaseRenderer {

	private void encodeResizableMarkup(FacesContext context, Resizable resizable) throws IOException {
		String clientId = RendererUtilities.encodeClientIdInteractions(resizable, context);
		if (RendererUtilities.isUniqueId(resizable)){
			encodeResizableWrapper(context, resizable, clientId);
		}
		else{
			RendererUtilities.renderChildren(context, resizable);
		}
	}

	private void encodeResizableScript(FacesContext context, Resizable resizable) {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, resizable));
        documentElement.addFunctionToReady(function);
	}

	private void encodeResizableWrapper(FacesContext context, Resizable resizable, String clientId) throws IOException {
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
    	RendererUtilities.renderChildren(context, resizable);
    	responseWriter.endElement(HTML.TAG_DIV);
	}
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Resizable resizable = null;
        if(component instanceof Resizable)
            resizable = (Resizable)component;
        
        encodeResources(resizable);
        encodeResizableScript(context, resizable);
        encodeResizableMarkup(context, resizable);
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        Resizable resizable = null;
        if(component instanceof Resizable)
            resizable = (Resizable)component;
        String clientId = RendererUtilities.encodeClientIdInteractions(resizable, context);
        JSElement element = new JSElement(clientId);
        JSAttribute jsResizable = new JSAttribute("resizable", false);
        StringBuffer sbOption = new StringBuffer();
        jsResizable.addValue(encodeOptionComponent(sbOption, resizable, context));
        element.addAttribute(jsResizable);
		return element;
	}
}
