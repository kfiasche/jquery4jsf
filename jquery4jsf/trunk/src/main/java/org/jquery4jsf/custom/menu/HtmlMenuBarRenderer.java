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
package org.jquery4jsf.custom.menu;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;
public class HtmlMenuBarRenderer extends HtmlMenuBarBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        HtmlMenuBar menuBar = null;
        if(component instanceof HtmlMenuBar)
        	menuBar = (HtmlMenuBar)component;
        
        encodeResources(menuBar);
        encodeMenuBarMarkup(context, menuBar);
	}
	
	private void encodeMenuBarMarkup(FacesContext context, HtmlMenuBar menuBar) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, menuBar);
		responseWriter.writeAttribute("id", menuBar.getClientId(context), "id");
		String styleClass = "ui-toolbar ui-widget-header ui-corner-all ui-helper-clearfix";
		if (menuBar.getStyleClass() != null ){
			styleClass = menuBar.getStyleClass().concat(" ").concat(styleClass);
		}
		responseWriter.writeAttribute("class", styleClass, "styleClass");
		if (menuBar.getStyle() != null )
			responseWriter.writeAttribute("style", menuBar.getStyle(), "style");
		RendererUtilities.renderChildren(context, menuBar);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	public boolean getRendersChildren() {
		return true;
	}

	public void encodeChildren(FacesContext arg0, UIComponent arg1) throws IOException {
	}
	
}
