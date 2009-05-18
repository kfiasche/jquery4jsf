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
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class DialogRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.DialogRenderer";

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Dialog dialog = null;
        if(component instanceof Dialog)
            dialog = (Dialog)component;
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = dialog.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(dialog.getClientId(context));
        JSAttribute jsDialog = new JSAttribute("dialog", false);
        StringBuffer sbOption = new StringBuffer();
        jsDialog.addValue(encodeOptionComponent(sbOption, dialog, context));
        element.addAttribute(jsDialog);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
        responseWriter.startElement(HTML.TAG_DIV, dialog);
        writeIdAttributeIfNecessary(context, responseWriter, component);
	}

	private String encodeOptionComponent(StringBuffer options, Dialog dialog, FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, dialog.isAutoOpen(), "autoOpen", "true");
		encodeOptionComponentByType(options, dialog.isBgiframe(), "bgiframe", null);
		encodeOptionComponentByType(options, dialog.getButtons(), "buttons", null);
		encodeOptionComponentByType(options, dialog.isCloseOnEscape(), "closeOnEscape", null);
		encodeOptionComponentByType(options, dialog.getDialogClass(), "dialogClass", null);
		encodeOptionComponentByType(options, dialog.isDraggable(), "draggable", null);
		encodeOptionComponentByType(options, dialog.getHeight(), "height", null);
		encodeOptionComponentByType(options, dialog.getHide(), "hide", null);
		encodeOptionComponentByType(options, dialog.getMaxHeight(), "maxHeight", null);
		encodeOptionComponentByType(options, dialog.getMaxWidth(), "maxWidth", null);
		encodeOptionComponentByType(options, dialog.getMinHeight(), "minHeight", null);
		encodeOptionComponentByType(options, dialog.getMinWidth(), "minWidth", null);
		encodeOptionComponentByType(options, dialog.isModal(), "modal", null);
		encodeOptionComponentByType(options, dialog.getPosition(), "position", null);
		encodeOptionComponentByType(options, dialog.isResizable(), "resizable", "true");
		encodeOptionComponentByType(options, dialog.getShow(), "show", null);
		encodeOptionComponentByType(options, dialog.isStack(), "stack", null);
		encodeOptionComponentByType(options, dialog.getTitle(), "title", null);
		encodeOptionComponentByType(options, dialog.getWidth(), "width", null);
		encodeOptionComponentByType(options, dialog.getZindex(), "zIndex", null);
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
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.endElement(HTML.TAG_DIV);
	}

	public boolean getRendersChildren() {
		return true;
	}

	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
		RendererUtilities.renderChildren(context, component);
	}

	
	
}
