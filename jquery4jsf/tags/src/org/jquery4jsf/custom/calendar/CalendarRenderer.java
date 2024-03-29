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
package org.jquery4jsf.custom.calendar;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.custom.datepicker.DatePicker;
import org.jquery4jsf.custom.datepicker.DatePickerRenderer;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class CalendarRenderer extends DatePickerRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.CalendarRenderer";

	public void encodePartially(FacesContext context, UIComponent component) throws IOException {
	}

	public String getActionURL(FacesContext context) throws IOException {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        DatePicker datePicker = null;
        if(component instanceof DatePicker)
        	datePicker = (DatePicker)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = datePicker.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        if (req.getLocale() != null){
        	String locale = req.getLocale().toString();
        	
        	String src = "datepicker/i18n/ui.datepicker-"+locale.substring(0,2)+".js";
        	RendererUtilities.addJsForJQueryPlugin(component, responseWriter, context, src);
        }
        
        responseWriter.startElement(HTML.TAG_DIV, component);
        responseWriter.writeAttribute("id", component.getClientId(context), "id");
        responseWriter.endElement(HTML.TAG_DIV);
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(datePicker.getClientId(context));
        JSAttribute jsDatePicker = new JSAttribute("datepicker", false);
        StringBuffer sbOption = new StringBuffer();
        jsDatePicker.addValue(encodeOptionComponent(sbOption, datePicker, context));
        element.addAttribute(jsDatePicker);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
	}
}
