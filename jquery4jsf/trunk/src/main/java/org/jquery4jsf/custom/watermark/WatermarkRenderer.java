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
package org.jquery4jsf.custom.watermark;

import java.io.IOException;
import java.lang.String;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class WatermarkRenderer extends WatermarkBaseRenderer {

	public void decode(FacesContext context, UIComponent component) {
		Watermark watermark = (Watermark) component;
		String clientId = watermark.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId);
		watermark.setSubmittedValue(submittedValue);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Watermark watermark = null;
        if(component instanceof Watermark)
        	watermark = (Watermark)component;
        
        encodeResources(watermark);
        encodeWatermarkScript(context, watermark);
        encodeWatermarkMarkup(context, watermark);
	}

	private void encodeWatermarkMarkup(FacesContext context, Watermark watermark) throws IOException {
        if (RendererUtilities.isUniqueId(watermark)){
        	encodeInputText(watermark, context);
        }
	}

	private void encodeWatermarkScript(FacesContext context, Watermark watermark) throws IOException {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, watermark));
        documentElement.addFunctionToReady(function);
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        Watermark watermark = null;
        if(component instanceof Watermark)
        	watermark = (Watermark)component;
        String clientId = RendererUtilities.encodeClientIdInteractions(watermark, context);
        JSElement element = new JSElement(clientId);
        JSAttribute jsWatermark = new JSAttribute("watermark", false);
        StringBuffer sbOption = new StringBuffer();
        jsWatermark.addValue(encodeOptionComponent(sbOption, watermark, context));
        element.addAttribute(jsWatermark);
		return element;
	}
	
}