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
package org.jquery4jsf.custom.colorpicker;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;

public class ColorPickerRenderer extends ColorPickerBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component)throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        ColorPicker colorPicker = null;
        if(component instanceof ColorPicker)
        	colorPicker = (ColorPicker)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        encodeResources(colorPicker);
        
        UIComponent parent = colorPicker.getParent();
        String clientId = null;
        if (parent instanceof UIInput && !colorPicker.isFlat()){
        	clientId = parent.getClientId(context);
        	colorPicker.getAttributes().put("target", RendererUtilities.getJQueryId(clientId));
        }
        else if (!colorPicker.isFlat()){
        	clientId = colorPicker.getClientId(context);
        	encodeInputText(colorPicker, context);	
        	colorPicker.getAttributes().put("target", RendererUtilities.getJQueryId(clientId));
        }
        else{
        	clientId = colorPicker.getClientId(context);
        	responseWriter.startElement(HTML.TAG_P, colorPicker);
        	writeIdAttributeIfNecessary(context, responseWriter, component);
        	responseWriter.endElement(HTML.TAG_P);
        	HtmlInputHidden secret = new HtmlInputHidden();
        	String colorPickerId = colorPicker.getId() + "hidden";
        	secret.setId(colorPickerId);
        	String colorPickerhdd = clientId + "hidden";
        	secret.setValue(colorPicker.getColor());
        	secret.setParent(RendererUtilities.getForm(context, component));
        	secret.encodeBegin(context);
        	secret.encodeChildren(context);
        	secret.encodeEnd(context);
        	colorPicker.getAttributes().put("target", RendererUtilities.getJQueryId(colorPickerhdd));
        }
        
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(clientId);
        JSAttribute jsColorPicker = new JSAttribute("ColorPicker", false);
        StringBuffer sbOption = new StringBuffer();
        jsColorPicker.addValue(encodeOptionComponent(sbOption, colorPicker, context));
        element.addAttribute(jsColorPicker);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.encodeImportJavascripScript(component, responseWriter, sb);
        
	}

	public void decode(FacesContext context, UIComponent component) {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        super.decode(context, component);
        
        ColorPicker colorPicker = null;
        if(component instanceof ColorPicker)
        	colorPicker = (ColorPicker)component;
        if (colorPicker.isFlat()){
        	String colorPickerHidden = colorPicker.getClientId(context) + "hidden";
        	String object = (String) context.getExternalContext().getRequestParameterMap().get(colorPickerHidden);
        	colorPicker.setColor(object);
        }
	}
	
	
	
}
