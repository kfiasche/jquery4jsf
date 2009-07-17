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
        
        encodeResources(colorPicker);
        encodeColorPickerMarkup(context, colorPicker);
        encodeColorPickerScript(context, colorPicker);
	}
	
	private void encodeColorPickerMarkup(FacesContext context, ColorPicker colorPicker) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
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
        	writeIdAttributeIfNecessary(context, responseWriter, colorPicker);
        	responseWriter.endElement(HTML.TAG_P);
        	HtmlInputHidden secret = new HtmlInputHidden();
        	String colorPickerId = colorPicker.getId() + "hidden";
        	secret.setId(colorPickerId);
        	String colorPickerhdd = clientId + "hidden";
        	secret.setValue(colorPicker.getColor());
        	secret.setParent(RendererUtilities.getForm(context, colorPicker));
        	secret.encodeBegin(context);
        	secret.encodeChildren(context);
        	secret.encodeEnd(context);
        	colorPicker.getAttributes().put("target", RendererUtilities.getJQueryId(colorPickerhdd));
        }
	}
	
	private void encodeColorPickerScript(FacesContext context, ColorPicker colorPicker){
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, colorPicker));
        documentElement.addFunctionToReady(function);
	}
	
	public JSElement getJSElement(FacesContext context, UIComponent component){
        ColorPicker colorPicker = null;
        if(component instanceof ColorPicker)
        	colorPicker = (ColorPicker)component;
        
		String clientId = null;
		if (colorPicker.getParent() instanceof UIInput && !colorPicker.isFlat()){
			clientId = colorPicker.getParent().getClientId(context);
		}
		else{
			clientId = colorPicker.getClientId(context);
		}
        JSElement element = new JSElement(clientId);
        JSAttribute jsColorPicker = new JSAttribute("ColorPicker", false);
        StringBuffer sbOption = new StringBuffer();
        jsColorPicker.addValue(encodeOptionComponent(sbOption, colorPicker, context));
        element.addAttribute(jsColorPicker);
        return element;
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
