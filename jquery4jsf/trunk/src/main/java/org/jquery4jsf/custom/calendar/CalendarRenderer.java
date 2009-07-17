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

import org.jquery4jsf.custom.datepicker.DatePicker;
import org.jquery4jsf.custom.datepicker.DatePickerRenderer;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.JSOperationElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;

public class CalendarRenderer extends DatePickerRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.CalendarRenderer";

	public void encodePartially(FacesContext context, UIComponent component) throws IOException {
	}

	public String getActionURL(FacesContext context) {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Calendar calendar = null;
        if(component instanceof Calendar)
        	calendar = (Calendar)component;
        
        encodeResources(calendar);
        encodeLocale(context, calendar);
        encodeCalendarMarkup(context, calendar);
        encodeCalendarScript(context, calendar);
	}
	
	private void encodeCalendarScript(FacesContext context, Calendar calendar) {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, calendar));
        documentElement.addFunctionToReady(function);
	}

	private void encodeCalendarMarkup(FacesContext context, Calendar calendar) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
		String clientId = calendar.getClientId(context);
        responseWriter.startElement(HTML.TAG_DIV, calendar);
        responseWriter.writeAttribute("id", calendar.getClientId(context) , "id");
        responseWriter.endElement(HTML.TAG_DIV);
        encodeHiddenInput(context, clientId.concat("_input"));
        calendar.setAltField(clientId.concat("_input"));
	}
	
	private JSElement getJSElementLocale(FacesContext context, DatePicker datePicker){
		JSOperationElement operationElement = new JSOperationElement("");
		String jQueryId = RendererUtilities.getJQueryId(datePicker.getClientId(context));
		operationElement.addOperation("\n "+RendererUtilities.getJQueryVarWidget()+"("+jQueryId.concat(").datepicker("+RendererUtilities.getJQueryVarWidget()+".datepicker.regional['"+datePicker.getLocale()+"']);" ));
		operationElement.addOperation("\n "+RendererUtilities.getJQueryVarWidget()+"("+jQueryId.concat(").datepicker('option', "+RendererUtilities.getJQueryVarWidget()+".extend("+encodeOptionComponent(new StringBuffer(), datePicker, context)+", \n "+RendererUtilities.getJQueryVarWidget()+".datepicker.regional['"+datePicker.getLocale()+"']));" ));
		return operationElement;
	}
	
	public JSElement getJSElement(FacesContext context, UIComponent component){
		Calendar calendar = null;
        if(component instanceof Calendar)
        	calendar = (Calendar)component;
        
        if (calendar.getLocale() != null){
        	return  getJSElementLocale(context, calendar);
        }
		JSElement element = new JSElement(calendar.getClientId(context));
		JSAttribute jsDatePicker = new JSAttribute("datepicker", false);
		StringBuffer sbOption = new StringBuffer();
		String options = encodeOptionComponent(sbOption, calendar, context);
		jsDatePicker.addValue(options);
		element.addAttribute(jsDatePicker);
		return element;
	}
	public void decode(FacesContext context, UIComponent component) {
		DatePicker datePicker = (DatePicker) component;
		String clientId = datePicker.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId+"_input");
		datePicker.setSubmittedValue(submittedValue);
	}
}
