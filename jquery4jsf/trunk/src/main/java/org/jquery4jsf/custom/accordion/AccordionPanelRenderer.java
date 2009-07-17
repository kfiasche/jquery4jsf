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
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccordionPanelRenderer extends AccordionPanelBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.AccordionPanelRenderer";
	private Logger logger = LoggerFactory.getLogger(AccordionPanelRenderer.class);
	
	protected String encodeOptionComponent(StringBuffer options, AccordionPanel accordionPanel , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, accordionPanel.getActive(), "active", null);
		encodeOptionComponentByType(options, accordionPanel.getAnimated(), "animated", null);
		encodeOptionComponentByType(options, accordionPanel.isAutoHeight(), "autoHeight", "true");
		encodeOptionComponentByType(options, accordionPanel.isClearStyle(), "clearStyle", null);
		encodeOptionComponentByType(options, accordionPanel.isCollapsible(), "collapsible", null);
		encodeOptionComponentByType(options, accordionPanel.getEvent(), "event", null);
		encodeOptionComponentByType(options, accordionPanel.isFillSpace(), "fillSpace", null);
		StringBuffer icons = new StringBuffer();
		encodeOptionComponentByType(icons, accordionPanel.getIconsHeader(), "header", null);
		encodeOptionComponentByType(icons, accordionPanel.getIconsHeaderSelected(), "headerSelected", null);
		encodeOptionComponentOptionsByType(options, icons.toString(), "icons", null);
		encodeOptionComponentByType(options, accordionPanel.isNavigation(), "navigation", null);
		encodeOptionComponentFunction(options, accordionPanel.getNavigationFilter(), "navigationFilter", null);
		encodeOptionComponentFunction(options, accordionPanel.getOnchange(), "onchange", "event,ui");
		encodeOptionComponentFunction(options, accordionPanel.getOnchangestart(), "onchangestart", "event,ui");
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
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || context == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        AccordionPanel accordionPanel = null;
        if (component instanceof AccordionPanel)
        	accordionPanel = (AccordionPanel)component;
        
        encodeResources(accordionPanel);
        encodeAjaxEventChild(context, accordionPanel);
        encodeAccordianScript(context, accordionPanel);
        encodeAccordianMarkp(context, accordionPanel);
	}
	
	protected void encodeAccordianMarkp(FacesContext context, AccordionPanel accordionPanel) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement(HTML.TAG_DIV, accordionPanel);
        writeIdAttributeIfNecessary(context, responseWriter, accordionPanel);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, accordionPanel, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, accordionPanel, HTML.HTML_JS_STD_ATTR);
        encodeAccordionPanelChild(context, accordionPanel);
        responseWriter.endElement(HTML.TAG_DIV);
	}

	protected void encodeAccordionPanelChild(FacesContext context, AccordionPanel accordionPanel) throws IOException{
		List children = accordionPanel.getChildren();
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			if (child instanceof AccordionSubPanel) {
				AccordionSubPanel panelChild = (AccordionSubPanel) child;
				RendererUtilities.renderChild(context, panelChild);
			}
			else{
				logger.warn("Questo componente non puo' essere renderizzato: "+child.getClientId(context));
			}
		}
	}
	
	protected void encodeAccordianScript(FacesContext context, AccordionPanel accordionPanel) throws IOException{
		JSDocumentElement documentElement = JSDocumentElement.getInstance();
		JSFunction function = new JSFunction();
		JSElement element = getJSElement(context, accordionPanel);
		function.addJSElement(element);
		documentElement.addFunctionToReady(function);
	}
	
	public JSElement getJSElement(FacesContext context, UIComponent component){
        AccordionPanel accordionPanel = null;
        if (component instanceof AccordionPanel)
        	accordionPanel = (AccordionPanel)component;
		JSElement element = new JSElement(accordionPanel.getClientId(context));
        JSAttribute jsAccordion = new JSAttribute("accordion", false);
        StringBuffer options = new StringBuffer();
        jsAccordion.addValue(encodeOptionComponent(options, accordionPanel, context));
        element.addAttribute(jsAccordion);
        return element;
	}	
	
	public boolean getRendersChildren() {
		return true;
	}


}
