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
package org.jquery4jsf.custom.spinner;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;

public class SpinnerRenderer extends SpinnerBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Spinner spinner = null;
        if(component instanceof Spinner)
            spinner = (Spinner)component;
        
        encodeResources(spinner);
        encodeSpinnerScript(context, spinner);
        encodeSpinnerMarkup(context, spinner);
	}

	private void encodeSpinnerMarkup(FacesContext context, Spinner spinner) throws IOException {
		String id = RendererUtilities.encodeIdInteractions(spinner, context);
		UIComponent component = ComponentUtilities.findComponentInRoot(id);
		List selectItems = getSelectItems(spinner);
		if (!(component instanceof UIInput)){
			encodeInputText(spinner, context);
		}	
		else if (spinner.getFor() == null && selectItems != null){
			SelectItem[] arrays = (SelectItem[]) selectItems.toArray(new SelectItem[selectItems.size()]);
			encodeSpinnerItems(context, arrays);
		}
	}

	private void encodeSpinnerItems(FacesContext context, SelectItem[] items) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_UL, null);
		for (int i = 0; i < items.length; i++) {
			SelectItem item = items[i];
			encodeItem(context, item);
		}
		responseWriter.endElement(HTML.TAG_UL);
	}
	
	private void encodeItem(FacesContext context, SelectItem item) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_LI, null);
		responseWriter.write(item.getLabel());
		responseWriter.endElement(HTML.TAG_LI);
	}
	
	private void encodeSpinnerScript(FacesContext context, Spinner spinner) throws IOException {
		JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, spinner));
        documentElement.addFunctionToReady(function);
	}
	
	public void decode(FacesContext context, UIComponent component) {
		Spinner spinner = (Spinner) component;
		String clientId = spinner.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId);
		spinner.setSubmittedValue(submittedValue);
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        Spinner spinner = null;
        if(component instanceof Spinner)
            spinner = (Spinner)component;
		String clientId = RendererUtilities.encodeClientIdInteractions(spinner, context);
        JSElement element = new JSElement(clientId);
        JSAttribute jsSpinner = new JSAttribute("spinner", false);
        StringBuffer sbOption = new StringBuffer();
        jsSpinner.addValue(encodeOptionComponent(sbOption, spinner, context));
        element.addAttribute(jsSpinner);
		return element;
	}
	
	protected String encodeOptionComponent(StringBuffer options, Spinner spinner , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, spinner.getDir(), "dir", null);
		encodeOptionComponentByType(options, spinner.getSyncWith(), "syncWith", null);
		encodeOptionComponentByType(options, spinner.getStep(), "step", null);
		encodeOptionComponentByType(options, spinner.isCurrency(), "currency", null);
		encodeOptionComponentByType(options, spinner.getFormat(), "format", null);
		encodeOptionComponentByType(options, spinner.getGroupSeparator(), "groupSeparator", null);
		encodeOptionComponentByType(options, spinner.getHide(), "hide", null);
		encodeOptionComponentByType(options, spinner.isIncremental(), "incremental", "true");
		encodeOptionComponentByType(options, spinner.getMax(), "max", null);
		encodeOptionComponentByType(options, spinner.getMin(), "min", null);
		encodeOptionComponentByType(options, spinner.isMouseWheel(), "mouseWheel", "true");
		encodeOptionComponentByType(options, spinner.getPadLength(), "padLength", "0");
		encodeOptionComponentByType(options, spinner.getPage(), "page", null);
		encodeOptionComponentByType(options, spinner.getPrecision(), "precision", null);
		encodeOptionComponentByType(options, spinner.getRadix(), "radix", null);
		encodeOptionComponentByType(options, spinner.getRadixPoint(), "radixPoint", null);
		encodeOptionComponentByType(options, spinner.getReadOnly(), "readOnly", null);
		encodeOptionComponentByType(options, spinner.getSpinnerClass(), "spinnerClass", null);
		encodeOptionComponentByType(options, spinner.getWidth(), "width", null);
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
}