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

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;

public class AccordionPanelRenderer extends AccordionPanelBaseRenderer implements AjaxBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.AccordionPanelRenderer";

	public void encodePartially(FacesContext context, UIComponent component)throws IOException {
	}

	public String getActionURL(FacesContext context) {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        AccordionPanel accordionPanel = null;
        if(component instanceof AccordionPanel)
        	accordionPanel = (AccordionPanel)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = accordionPanel.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(accordionPanel.getClientId(context));
        JSAttribute jsAccordion = new JSAttribute("accordion", false);
        StringBuffer sbOption = new StringBuffer();
        jsAccordion.addValue(encodeOptionComponent(sbOption, accordionPanel, context));
        element.addAttribute(jsAccordion);

        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb); 
        responseWriter.startElement(HTML.TAG_DIV, accordionPanel);
        writeIdAttributeIfNecessary(context, responseWriter, component);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_JS_STD_ATTR);
	
	}

	/*private String encodeOptionComponent(StringBuffer options, AccordionPanel accordionPanel, FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options,accordionPanel.getActive(), "active");
		encodeOptionComponentByType(options,accordionPanel.getAnimated(), "animated");
		encodeOptionComponentByType(options,accordionPanel.isAutoHeight(), "autoHeight");
		encodeOptionComponentByType(options,accordionPanel.isClearStyle(), "clearStyle");
		encodeOptionComponentByType(options,accordionPanel.isCollapsible(), "collapsible");
		encodeOptionComponentByType(options,accordionPanel.getEvent(), "event");
		encodeOptionComponentByType(options,accordionPanel.isFillSpace(), "fillSpace");
		encodeOptionComponentByType(options,accordionPanel.getHeader(), "header");
		encodeOptionComponentByType(options,accordionPanel.getHeader(), "header");
		encodeOptionComponentByType(options,accordionPanel.getIcons(), "icons");
		encodeOptionComponentByType(options,accordionPanel.isNavigation(), "navigation");
		encodeOptionComponentByType(options,accordionPanel.getNavigationFilter(), "navigationFilter");
		//TODO implementare il bind delle funzioni
		//encodeOptionComponentByType(options,accordionPanel.getOnaccordionchange(), "accordionchange");
		if (options.toString().endsWith(", \n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (options.toString().endsWith(" {\n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
			noParams = true;
		}
		if (!noParams)
		{
			options.append(" }");
		}
		return options.toString();
	}*/

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || context == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.endElement(HTML.TAG_DIV);
	}

	public boolean getRendersChildren() {
		return false;
	}

	
	
}
