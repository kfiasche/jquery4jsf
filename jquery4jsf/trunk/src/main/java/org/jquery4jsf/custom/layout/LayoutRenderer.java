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
package org.jquery4jsf.custom.layout;

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
import org.jquery4jsf.utilities.MessageFactory;


public class LayoutRenderer extends LayoutBaseRenderer {

	public void encodeChildren(FacesContext arg0, UIComponent arg1) throws IOException {
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Layout layout = null;
        if(component instanceof Layout)
            layout = (Layout)component;
        
        encodeResources(layout);
        encodeScriptLayout(context, layout);
        encodeMarkupLayout(context, layout);
	}

	protected void encodeMarkupLayout(FacesContext context, Layout layout) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, layout);
		responseWriter.writeAttribute("id", layout.getClientId(context), "id");
		responseWriter.writeAttribute("style", "height: 400px;", null);
		encodeMarkupCenterLayout(context, layout);
		encodeMarkupNorthLayout(context, layout);
		encodeMarkupSouthLayout(context, layout);
		encodeMarkupEastLayout(context, layout);
		encodeMarkupWestLayout(context, layout);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeMarkupWestLayout(FacesContext context, Layout layout) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		UIComponent component = layout.getFacet("west");
		if (component == null)
			return;
		responseWriter.startElement(HTML.TAG_DIV, null);
		responseWriter.writeAttribute("id", layout.getClientId(context).concat("_west"), null);
		responseWriter.writeAttribute("class", "ui-layout-west", null);
		RendererUtilities.renderChild(context, component);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeMarkupEastLayout(FacesContext context, Layout layout) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		UIComponent component = layout.getFacet("east");
		if (component == null)
			return;
		responseWriter.startElement(HTML.TAG_DIV, null);
		responseWriter.writeAttribute("id", layout.getClientId(context).concat("_east"), null);
		responseWriter.writeAttribute("class", "ui-layout-east", null);
		RendererUtilities.renderChild(context, component);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeMarkupSouthLayout(FacesContext context, Layout layout) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		UIComponent component = layout.getFacet("south");
		if (component == null)
			return;
		responseWriter.startElement(HTML.TAG_DIV, null);
		responseWriter.writeAttribute("id", layout.getClientId(context).concat("_south"), null);
		responseWriter.writeAttribute("class", "ui-layout-south", null);
		RendererUtilities.renderChild(context, component);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeMarkupNorthLayout(FacesContext context, Layout layout) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		UIComponent component = layout.getFacet("north");
		if (component == null)
			return;
		responseWriter.startElement(HTML.TAG_DIV, null);
		responseWriter.writeAttribute("id", layout.getClientId(context).concat("_north"), null);
		responseWriter.writeAttribute("class", "ui-layout-north", null);
		RendererUtilities.renderChild(context, component);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeMarkupCenterLayout(FacesContext context, Layout layout) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		UIComponent component = layout.getFacet("center");
		if (component == null)
			return;
		responseWriter.startElement(HTML.TAG_DIV, null);
		responseWriter.writeAttribute("id", layout.getClientId(context).concat("_center"), "id");
		responseWriter.writeAttribute("class", "ui-layout-center", null);
		RendererUtilities.renderChild(context, component);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	protected void encodeScriptLayout(FacesContext context, Layout layout) throws IOException {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, layout));
        documentElement.addFunctionToReady(function);
	}

	public boolean getRendersChildren() {
		return true;
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        Layout layout = null;
        if(component instanceof Layout)
            layout = (Layout)component;
        JSElement element = new JSElement(layout.getClientId(context));
        JSAttribute jsLayout = new JSAttribute("layout", false);
        StringBuffer sbOption = new StringBuffer();
        jsLayout.addValue(encodeOptionComponent(sbOption, layout, context));
        element.addAttribute(jsLayout);
		return element;
	}

	
	
}