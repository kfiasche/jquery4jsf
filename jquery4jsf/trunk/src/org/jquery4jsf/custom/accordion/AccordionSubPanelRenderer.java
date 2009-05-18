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
package org.jquery4jsf.custom.accordion;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;

public class AccordionSubPanelRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.AccordionSubPanelRenderer";

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        AccordionSubPanel accordionSubPanel = null;
        if (component instanceof AccordionSubPanel) {
			accordionSubPanel = (AccordionSubPanel) component;
		}
        if (accordionSubPanel.getPanelName() == null){
        	throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        }
        ResponseWriter responseWriter = context.getResponseWriter();
        //responseWriter.startElement(HTML.TAG_DIV, component);
        responseWriter.startElement(HTML.TAG_H3, component);
        responseWriter.startElement(HTML.TAG_A, component);
        responseWriter.writeAttribute(HTML.HREF, "#", null);
        responseWriter.writeText(accordionSubPanel.getPanelName(), "panelName");
        responseWriter.endElement(HTML.TAG_A);
        responseWriter.endElement(HTML.TAG_H3);
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        
		if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement(HTML.TAG_DIV, component);
        RendererUtilities.renderChildren(context,component);
        responseWriter.endElement(HTML.TAG_DIV);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        //ResponseWriter responseWriter = context.getResponseWriter();
        //responseWriter.endElement(HTML.TAG_DIV);
	}

	public boolean getRendersChildren() {
		return true;
	}	
}
