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
package org.jquery4jsf.custom.simplyscroll;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIGraphic;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.panel.Panel;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;

public class SimplyScrollRenderer extends SimplyScrollBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        SimplyScroll simplyScroll = null;
        if(component instanceof SimplyScroll)
        	simplyScroll = (SimplyScroll)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = simplyScroll.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(simplyScroll.getClientId(context));
        JSAttribute jsSimplyScroll = new JSAttribute("simplyScroll", false);
        StringBuffer sbOption = new StringBuffer();
        jsSimplyScroll.addValue(encodeOptionComponent(sbOption, simplyScroll, context));
        element.addAttribute(jsSimplyScroll);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        responseWriter.startElement(HTML.TAG_DIV, component);
        responseWriter.writeAttribute("id", component.getClientId(context) +"Wrapper", null);
        responseWriter.writeAttribute("class", "ui-simplyscroll-w", null);
		responseWriter.write("\n");
		if (simplyScroll.isCustomContent()){
			encodeCustomContent(context, simplyScroll);
		}
		else{
			encodeContentClassic(context, simplyScroll);
		}
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeCustomContent(FacesContext context, SimplyScroll simplyScroll) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, simplyScroll);
        responseWriter.writeAttribute("id", simplyScroll.getClientId(context), "id");
		for (Iterator iterator = simplyScroll.getChildren().iterator(); iterator.hasNext();) {
			UIComponent component = (UIComponent) iterator.next();
			if (component instanceof HtmlGraphicImage) {
				HtmlGraphicImage img = (HtmlGraphicImage) component;
				responseWriter.startElement(HTML.TAG_DIV, component);
				responseWriter.writeAttribute("class", "section", null);
				responseWriter.startElement(HTML.TAG_DIV, component);
				responseWriter.writeAttribute("class", "hp-highlight", null);
				String path = context.getExternalContext().getRequestContextPath() + img.getValue();
				responseWriter.writeAttribute("style", "background:url("+ path +") no-repeat 0 0", null);
				responseWriter.startElement(HTML.TAG_DIV, component);
				responseWriter.writeAttribute("class", "feature-headline", null);
				UIComponent header = img.getFacet("header");
				responseWriter.startElement(HTML.TAG_H1, component);
				RendererUtilities.renderChild(context, header);
				responseWriter.endElement(HTML.TAG_H1);
				UIComponent content = img.getFacet("content");
				RendererUtilities.renderChild(context, content);
				responseWriter.endElement(HTML.TAG_DIV);
				responseWriter.endElement(HTML.TAG_DIV);
				responseWriter.endElement(HTML.TAG_DIV);
			}
			responseWriter.write("\n");
		}
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeContentClassic(FacesContext context, SimplyScroll simplyScroll) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_UL, null);
		responseWriter.writeAttribute("id", simplyScroll.getClientId(context), null);
		if(simplyScroll.getStyleClass() == null)
			responseWriter.writeAttribute("class", "ui-simplyscroll", null);
		else
			responseWriter.writeAttribute("class", "ui-simplyscroll " + simplyScroll.getStyleClass(), null);
		
		if(simplyScroll.getStyle() != null)
			responseWriter.writeAttribute("style", simplyScroll.getStyle(), null);
		responseWriter.write("\n");
        for (Iterator iterator = simplyScroll.getChildren().iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			if(child.isRendered()) {
				responseWriter.startElement(HTML.TAG_LI, null);
				RendererUtilities.renderChild(context, child);
				responseWriter.endElement(HTML.TAG_LI);
			}
		}
        responseWriter.endElement(HTML.TAG_UL);
	}
	
	public boolean getRendersChildren() {
		return true;
	}

	public void encodeChildren(FacesContext arg0, UIComponent arg1)throws IOException {
	}

	
	
}