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
package org.jquery4jsf.custom.html;

import java.io.IOException;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class HtmlOutputLinkRenderer extends JQueryBaseRenderer {

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlOutputLink outputLink = null;
        if (component instanceof HtmlOutputLink){
        	outputLink = (HtmlOutputLink)component;
        }
        if (!outputLink.isRendered())
        	return;
        
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement(HTML.TAG_A, outputLink);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_JS_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_JS_ELEMENT_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_A_TAG_ATTR);
	}

	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
		super.encodeChildren(context, component);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlOutputLink outputLink = null;
        if (component instanceof HtmlOutputLink){
        	outputLink = (HtmlOutputLink)component;
        }
        if (!outputLink.isRendered())
        	return;
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement(HTML.TAG_A);
	}

}