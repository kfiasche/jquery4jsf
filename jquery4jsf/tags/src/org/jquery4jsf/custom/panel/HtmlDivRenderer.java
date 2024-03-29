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
import javax.faces.render.Renderer;

import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;

import com.sun.faces.util.Util;

public class HtmlDivRenderer extends Renderer {


	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	}

	public void encodeEnd(FacesContext context,UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		if(context == null || context == null)
			throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		HtmlDiv htmlDiv = null;
		if(component instanceof HtmlDiv)
			htmlDiv = (HtmlDiv)component;

		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, htmlDiv);
		responseWriter.writeAttribute("id", htmlDiv.getClientId(context), "id");
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_STD_ATTR);
		responseWriter.write("\n");
		
		RendererUtilities.renderChildren(context, component);
		responseWriter.endElement(HTML.TAG_DIV);
		responseWriter.write("\n");
	}

    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
	}

	public void decode(FacesContext context, UIComponent component) {
        return;
    }

	public boolean getRendersChildren() {
		return true;
	}


}

