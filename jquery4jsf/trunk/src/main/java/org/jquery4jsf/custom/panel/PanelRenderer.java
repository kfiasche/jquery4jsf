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
package org.jquery4jsf.custom.panel;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;
public class PanelRenderer extends JQueryBaseRenderer {

	protected void encodePanelMarkup(FacesContext context, Panel panel) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, panel);
		responseWriter.writeAttribute("id", panel.getClientId(context), "id");
		String styleClass = "ui-widget-content";
		if (panel.getStyleClass() != null){
			styleClass = styleClass.concat(" ").concat(panel.getStyleClass());
		}
		if (panel.getContentClass() != null){
			styleClass = styleClass.concat(" ").concat(panel.getContentClass());
		}
		responseWriter.writeAttribute("class", styleClass, null);
		
		if(panel.getStyle() != null)
			responseWriter.writeAttribute("style", panel.getStyle(), null);
		encodePanelHeader(context, panel);
		encodePanelContent(context, panel);
		encodePanelFooter(context, panel);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	protected void encodePanelFooter(FacesContext context, Panel panel) {
		//TODO da implementare
	}

	protected void encodePanelContent(FacesContext context, Panel panel) throws IOException {
		UIComponent content = panel.getFacet("content");
		if (content != null){
			RendererUtilities.renderChildren(context, content);
		}
		else{
			RendererUtilities.renderChildren(context, panel);
		}
	}

	protected void encodePanelHeader(FacesContext context, Panel panel) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
		UIComponent header = panel.getFacet("header");
		if (header != null || panel.getHeader() != null){
			responseWriter.startElement(HTML.TAG_H3, panel);
			String styleClassHeader = "ui-widget-header";
			if (panel.getHeaderClass() != null){
				styleClassHeader = styleClassHeader.concat(" ").concat(panel.getHeaderClass());
			}
			responseWriter.writeAttribute("class", styleClassHeader, null);
			if (header != null){
				RendererUtilities.renderChild(context, header);
				responseWriter.writeText(panel.getHeader(), "header");
			}
			else{
				responseWriter.writeText(panel.getHeader(), "header");
			}
			responseWriter.endElement(HTML.TAG_H3);
		}
	}
	
	public void encodeEnd(FacesContext context,UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		Panel panel = null;
		if(component instanceof Panel)
			panel = (Panel)component;
		
		encodeResources(panel);
		encodePanelMarkup(context, panel);

	}
		
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
	}
	
	public boolean getRendersChildren() {
		return true;
	}
}
