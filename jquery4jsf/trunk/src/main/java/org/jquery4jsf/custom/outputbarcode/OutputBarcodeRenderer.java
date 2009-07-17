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
package org.jquery4jsf.custom.outputbarcode;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;
import org.jquery4jsf.utilities.TextUtilities;


public class OutputBarcodeRenderer extends OutputBarcodeBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component)throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		OutputBarcode outputBarcode = null;
		if (component instanceof OutputBarcode){
			outputBarcode = (OutputBarcode)component;
		}
		
		if (TextUtilities.isStringVuota(outputBarcode.getType()))
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if (outputBarcode.getValue() == null)
        	throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        
        encodeResources(outputBarcode);
        encodeBarcodeScript(context, outputBarcode);
        encodeBarcodeMarkup(context, outputBarcode);
	}
	
	
	private void encodeBarcodeMarkup(FacesContext context, OutputBarcode outputBarcode) throws IOException {
		String clientId = outputBarcode.getClientId(context);
		ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement(HTML.TAG_DIV, outputBarcode);
        responseWriter.writeAttribute("id", clientId, "id");
        responseWriter.endElement(HTML.TAG_DIV);
	}


	private void encodeBarcodeScript(FacesContext context, OutputBarcode outputBarcode) {
		JSDocumentElement documentElement = JSDocumentElement.getInstance();
		JSFunction function = new JSFunction();
		function.addJSElement(getJSElement(context, outputBarcode));
		documentElement.addFunctionToReady(function);
	}


	protected String encodeOptionComponent(StringBuffer options, OutputBarcode outputBarcode , FacesContext context) {
		options.append("\"");
		String value = (String) outputBarcode.getValue();
		options.append(value);
		options.append("\",");
		options.append("\"");
		String type = outputBarcode.getType();
		options.append(type);
		options.append("\"");
		options.append(", {\n");
		encodeOptionComponentByType(options, outputBarcode.getBarWidth(), "barWidth", "1");
		encodeOptionComponentByType(options, outputBarcode.getBarHeight(), "barHeight", "50");
		encodeOptionComponentByType(options, outputBarcode.isShowHRI(), "showHRI", "true");
		encodeOptionComponentByType(options, outputBarcode.getBgColor(), "bgColor", null);
		encodeOptionComponentByType(options, outputBarcode.getColor(), "color", null);
		encodeOptionComponentByType(options, outputBarcode.getFontSize(), "fontSize", null);
		if (options.toString().endsWith(", \n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (options.toString().endsWith(" {\n")){
			String stringa = options.substring(0, options.length()-4);
			options = new StringBuffer(stringa);
			noParams = true;
		}
		if (!noParams)
		{
			options.append(" }");
		}
		return options.toString();
	}


	public JSElement getJSElement(FacesContext context, UIComponent component) {
		OutputBarcode outputBarcode = null;
		if (component instanceof OutputBarcode){
			outputBarcode = (OutputBarcode)component;
		}
		String clientId = outputBarcode.getClientId(context);
		JSElement element = new JSElement(clientId);
		JSAttribute jsBarcode = new JSAttribute("barcode", false);
		StringBuffer sbOptions = new StringBuffer();
		jsBarcode.addValue(encodeOptionComponent(sbOptions, outputBarcode, context));
		element.addAttribute(jsBarcode);
		return element;
	}
}