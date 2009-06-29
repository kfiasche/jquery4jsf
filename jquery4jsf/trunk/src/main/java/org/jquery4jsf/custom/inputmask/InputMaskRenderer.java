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
package org.jquery4jsf.custom.inputmask;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;

public class InputMaskRenderer extends InputMaskBaseRenderer {

	public void decode(FacesContext context, UIComponent component) {
		InputMask inputMask = (InputMask) component;
		String paramKey = inputMask.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(paramKey);
		inputMask.setSubmittedValue(submittedValue);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        InputMask inputMask = null;
        if(component instanceof InputMask)
            inputMask = (InputMask)component;
        
        encodeResources(inputMask);
        encodeInputMaskScript(context, inputMask);
        encodeInputMaskMarkup(context, inputMask);
	}

	private void encodeInputMaskMarkup(FacesContext context, InputMask inputMask) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        String clientId = RendererUtilities.encodeIdInteractions(inputMask, context);
        JSElement element = new JSElement(clientId);
        JSAttribute jsMask = new JSAttribute("mask", false);
        StringBuffer sbOption = new StringBuffer();
        jsMask.addValue(encodeOptionComponent(sbOption, inputMask, context));
        element.addAttribute(jsMask);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.encodeImportJavascripScript(inputMask, responseWriter, sb);
	}

	private void encodeInputMaskScript(FacesContext context, InputMask inputMask) throws IOException {
        if (RendererUtilities.isUniqueId(inputMask)){
        	encodeInputText(inputMask, context);
        }
	}

}