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
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;

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
		boolean isUnique = RendererUtilities.isUniqueId(spinner);
		List selectItems = getSelectItems(spinner);
		if (isUnique && selectItems == null){
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
		ResponseWriter responseWriter = context.getResponseWriter();
        String clientId = RendererUtilities.encodeIdInteractions(spinner, context);
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(clientId);
        JSAttribute jsResizable = new JSAttribute("spinner", false);
        StringBuffer sbOption = new StringBuffer();
        jsResizable.addValue(encodeOptionComponent(sbOption, spinner, context));
        element.addAttribute(jsResizable);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.encodeImportJavascripScript(spinner, responseWriter, sb);
	}
	
	public void decode(FacesContext context, UIComponent component) {
		Spinner spinner = (Spinner) component;
		String clientId = spinner.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId);
		spinner.setSubmittedValue(submittedValue);
	}
}