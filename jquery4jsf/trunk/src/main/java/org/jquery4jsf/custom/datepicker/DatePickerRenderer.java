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
package org.jquery4jsf.custom.datepicker;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.JSOperationElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class DatePickerRenderer extends DatePickerBaseRenderer {
	
	
	public static final String RENDERER_TYPE = "org.jquery4jsf.DatePickerRenderer";

	protected void encodeLocale(FacesContext context, DatePicker datePicker) throws IOException{
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        if (req.getLocale() != null && datePicker.getLocale() == null){
        	String locale = req.getLocale().toString();
        	String src = "datepicker/i18n/ui.datepicker-"+locale.substring(0,2)+".js";
        	ResourceContext.getInstance().addResource(src);
        }
        if (datePicker.getLocale() != null){
        	String locale = datePicker.getLocale();
        	String src = "datepicker/i18n/ui.datepicker-"+locale+".js";
        	ResourceContext.getInstance().addResource(src);
        }
        if (req.getLocale() == null && datePicker.getLocale() == null){
        	String locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale().toString();
        	String src = "datepicker/i18n/ui.datepicker-"+locale.substring(0,2)+".js";
        	ResourceContext.getInstance().addResource(src);
        }

	}
	
	public void encodeBegin(FacesContext context, UIComponent component)throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        DatePicker datePicker = null;
        if(component instanceof DatePicker)
        	datePicker = (DatePicker)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        encodeResources(datePicker);
        encodeLocale(context, datePicker);
        encodeInputText(datePicker, context);
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(datePicker.getClientId(context));
        JSAttribute jsDatePicker = new JSAttribute("datepicker", false);
        StringBuffer sbOption = new StringBuffer();
        String options = encodeOptionComponent(sbOption, datePicker, context);
        jsDatePicker.addValue(options);
        element.addAttribute(jsDatePicker);
        JSFunction function = new JSFunction();
        if (datePicker.getLocale() != null){
            JSOperationElement operationElement = new JSOperationElement("");
            String idjq = RendererUtilities.getJQueryId(datePicker.getClientId(context));
            operationElement.addOperation("\n $('"+idjq.concat("').datepicker($.datepicker.regional['"+datePicker.getLocale()+"']);" ));
            operationElement.addOperation("\n $('"+idjq.concat("').datepicker('option', $.extend("+options+", \n $.datepicker.regional['"+datePicker.getLocale()+"']));" ));
            function.addJSElement(operationElement);
        }
        else
        	function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.encodeImportJavascripScript(component, responseWriter, sb);
        
	}
	
	protected String encodeOptionComponent(StringBuffer options, DatePicker datePicker , FacesContext context) {
		options.append(" {\n");
		String id = null;
		if (datePicker.getAltField() != null){
			//TODO search a id into viewtree
			id = RendererUtilities.getJQueryIdComponent(datePicker.getAltField(), context, datePicker);
			//is null write a jqueryid
			if (id == null){
				id = RendererUtilities.getJQueryId(datePicker.getAltField());
			}
		}
		encodeOptionComponentByType(options, id, "altField", null);
		encodeOptionComponentByType(options, datePicker.getAltFormat(), "altFormat", null);
		encodeOptionComponentByType(options, datePicker.getAppendText(), "appendText", null);
		encodeOptionComponentByType(options, datePicker.getButtonImage(), "buttonImage", null);
		encodeOptionComponentByType(options, datePicker.isButtonImageOnly(), "buttonImageOnly", null);
		encodeOptionComponentByType(options, datePicker.getButtonText(), "buttonText", null);
		encodeOptionComponentByType(options, datePicker.isChangeMonth(), "changeMonth", null);
		encodeOptionComponentByType(options, datePicker.isChangeYear(), "changeYear", null);
		encodeOptionComponentByType(options, datePicker.getCloseText(), "closeText", null);
		encodeOptionComponentByType(options, datePicker.isConstrainInput(), "constrainInput", null);
		encodeOptionComponentByType(options, datePicker.getCurrentText(), "currentText", null);
		encodeOptionComponentByType(options, datePicker.getDateFormat(), "dateFormat", null);
		encodeOptionComponentByType(options, datePicker.getDayNames(), "dayNames", null);
		encodeOptionComponentByType(options, datePicker.getDayNamesMin(), "dayNamesMin", null);
		encodeOptionComponentByType(options, datePicker.getDayNamesShort(), "dayNamesShort", null);
		encodeOptionComponentByType(options, datePicker.getDefaultDate(), "defaultDate", null);
		encodeOptionComponentByType(options, datePicker.getDuration(), "duration", null);
		encodeOptionComponentByType(options, datePicker.getFirstDay(), "firstDay", null);
		encodeOptionComponentByType(options, datePicker.isGotoCurrent(), "gotoCurrent", null);
		encodeOptionComponentByType(options, datePicker.isHideIfNoPrevNext(), "hideIfNoPrevNext", null);
		encodeOptionComponentByType(options, datePicker.getMaxDate(), "maxDate", null);
		encodeOptionComponentByType(options, datePicker.getMinDate(), "minDate", null);
		encodeOptionComponentByType(options, datePicker.getMonthNames(), "monthNames", null);
		encodeOptionComponentByType(options, datePicker.getMonthNamesShort(), "monthNamesShort", null);
		encodeOptionComponentByType(options, datePicker.isNavigationAsDateFormat(), "navigationAsDateFormat", null);
		encodeOptionComponentByType(options, datePicker.getNextText(), "nextText", null);
		encodeOptionComponentByType(options, datePicker.getNumberOfMonths(), "numberOfMonths", "1");
		encodeOptionComponentByType(options, datePicker.getPrevText(), "prevText", null);
		encodeOptionComponentByType(options, datePicker.getShortYearCutoff(), "shortYearCutoff", null);
		encodeOptionComponentByType(options, datePicker.getShowAnim(), "showAnim", null);
		encodeOptionComponentByType(options, datePicker.isShowButtonPanel(), "showButtonPanel", null);
		encodeOptionComponentByType(options, datePicker.getShowCurrentAtPos(), "showCurrentAtPos", null);
		encodeOptionComponentByType(options, datePicker.isShowMonthAfterYear(), "showMonthAfterYear", null);
		encodeOptionComponentByType(options, datePicker.getShowOn(), "showOn", null);
		encodeOptionComponentByType(options, datePicker.getShowOptions(), "showOptions", null);
		encodeOptionComponentByType(options, datePicker.isShowOtherMonths(), "showOtherMonths", null);
		encodeOptionComponentByType(options, datePicker.getStepMonths(), "stepMonths", null);
		encodeOptionComponentByType(options, datePicker.getYearRange(), "yearRange", null);
		encodeOptionComponentByType(options, datePicker.getOnbeforeShow(), "onbeforeShow", null);
		encodeOptionComponentByType(options, datePicker.getOnbeforeShowDay(), "onbeforeShowDay", null);
		encodeOptionComponentByType(options, datePicker.getOnchangeMonthYear(), "onchangeMonthYear", null);
		encodeOptionComponentByType(options, datePicker.getOnclose(), "onclose", null);
		encodeOptionComponentByType(options, datePicker.getOnselect(), "onselect", null);
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
	
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		return super.getConvertedValue(context, component, submittedValue);
	}
	
	public void decode(FacesContext context, UIComponent component) {
		DatePicker datePicker = (DatePicker) component;
		String clientId = datePicker.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(clientId);
		datePicker.setSubmittedValue(submittedValue);
	}
	
}
