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
package org.jquery4jsf.custom.dialog;

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
public class DialogRenderer extends DialogBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.DialogRenderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Dialog dialog = null;
        if(component instanceof Dialog)
            dialog = (Dialog)component;
        
        encodeResources(dialog);
        encodeScriptDialog(context, dialog);
        encodeMarkupDialog(context, dialog);

	}

	private void encodeMarkupDialog(FacesContext context, Dialog dialog) throws IOException {
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement(HTML.TAG_DIV, dialog);
        writeIdAttributeIfNecessary(context, responseWriter, dialog);
        RendererUtilities.renderChildren(context, dialog);
        responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeScriptDialog(FacesContext context, Dialog dialog) throws IOException {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, dialog));
        documentElement.addFunctionToReady(function);
	}

	public boolean getRendersChildren() {
		return true;
	}

	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        Dialog dialog = null;
        if(component instanceof Dialog)
            dialog = (Dialog)component;
        JSElement element = new JSElement(dialog.getClientId(context));
        JSAttribute jsDialog = new JSAttribute("dialog", false);
        StringBuffer sbOption = new StringBuffer();
        jsDialog.addValue(encodeOptionComponent(sbOption, dialog, context));
        element.addAttribute(jsDialog);
		return element;
	}

	
	
}
