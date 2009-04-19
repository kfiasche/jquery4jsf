package org.jquery4jsf.custom.datepicker;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class DatePickerRenderer extends DatePickerBaseRenderer implements AjaxBaseRenderer {
	
	public static final String RENDERER_TYPE = "org.jquery4jsf.DatePickerRenderer";

	public void encodePartially(FacesContext context, UIComponent component) throws IOException {
	}

	public String getActionURL(FacesContext context) throws IOException {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeBegin(FacesContext context, UIComponent component)throws IOException {
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
        

        rendererInputText(responseWriter, datePicker, context);
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(datePicker.getClientId(context));
        JSAttribute jsAutocomplete = new JSAttribute("datepicker", false);
        StringBuffer sbOption = new StringBuffer();
        jsAutocomplete.addValue(encodeOptionComponent(sbOption, datePicker, context));
        element.addAttribute(jsAutocomplete);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
	}
	
	protected String encodeOptionComponent(StringBuffer options, DatePicker datePicker , FacesContext context) {
		options.append(" {\n");
		String id = RendererUtilities.getJQueryIdComponent(datePicker.getAltField(), context, datePicker);
		encodeOptionComponentByType(options, id, "altField");
		encodeOptionComponentByType(options, datePicker.getAltFormat(), "altFormat");
		encodeOptionComponentByType(options, datePicker.getAppendText(), "appendText");
		encodeOptionComponentByType(options, datePicker.getButtonImage(), "buttonImage");
		encodeOptionComponentByType(options, datePicker.isButtonImageOnly(), "buttonImageOnly");
		encodeOptionComponentByType(options, datePicker.getButtonText(), "buttonText");
		encodeOptionComponentByType(options, datePicker.isChangeMonth(), "changeMonth");
		encodeOptionComponentByType(options, datePicker.isChangeYear(), "changeYear");
		encodeOptionComponentByType(options, datePicker.getCloseText(), "closeText");
		encodeOptionComponentByType(options, datePicker.isConstrainInput(), "constrainInput");
		encodeOptionComponentByType(options, datePicker.getCurrentText(), "currentText");
		encodeOptionComponentByType(options, datePicker.getDateFormat(), "dateFormat");
		encodeOptionComponentByType(options, datePicker.getDayNames(), "dayNames");
		encodeOptionComponentByType(options, datePicker.getDayNamesMin(), "dayNamesMin");
		encodeOptionComponentByType(options, datePicker.getDayNamesShort(), "dayNamesShort");
		encodeOptionComponentByType(options, datePicker.getDefaultDate(), "defaultDate");
		encodeOptionComponentByType(options, datePicker.getDuration(), "duration");
		encodeOptionComponentByType(options, datePicker.getFirstDay(), "firstDay");
		encodeOptionComponentByType(options, datePicker.isGotoCurrent(), "gotoCurrent");
		encodeOptionComponentByType(options, datePicker.isHideIfNoPrevNext(), "hideIfNoPrevNext");
		encodeOptionComponentByType(options, datePicker.getMaxDate(), "maxDate");
		encodeOptionComponentByType(options, datePicker.getMinDate(), "minDate");
		encodeOptionComponentByType(options, datePicker.getMonthNames(), "monthNames");
		encodeOptionComponentByType(options, datePicker.getMonthNamesShort(), "monthNamesShort");
		encodeOptionComponentByType(options, datePicker.isNavigationAsDateFormat(), "navigationAsDateFormat");
		encodeOptionComponentByType(options, datePicker.getNextText(), "nextText");
		encodeOptionComponentByType(options, datePicker.getNumberOfMonths(), "numberOfMonths");
		encodeOptionComponentByType(options, datePicker.getPrevText(), "prevText");
		encodeOptionComponentByType(options, datePicker.getShortYearCutoff(), "shortYearCutoff");
		encodeOptionComponentByType(options, datePicker.getShowAnim(), "showAnim");
		encodeOptionComponentByType(options, datePicker.isShowButtonPanel(), "showButtonPanel");
		encodeOptionComponentByType(options, datePicker.getShowCurrentAtPos(), "showCurrentAtPos");
		encodeOptionComponentByType(options, datePicker.isShowMonthAfterYear(), "showMonthAfterYear");
		encodeOptionComponentByType(options, datePicker.getShowOn(), "showOn");
		encodeOptionComponentByType(options, datePicker.getShowOptions(), "showOptions");
		encodeOptionComponentByType(options, datePicker.isShowOtherMonths(), "showOtherMonths");
		encodeOptionComponentByType(options, datePicker.getStepMonths(), "stepMonths");
		encodeOptionComponentByType(options, datePicker.getYearRange(), "yearRange");
		encodeOptionComponentByType(options, datePicker.getOnbeforeShow(), "onbeforeShow");
		encodeOptionComponentByType(options, datePicker.getOnbeforeShowDay(), "onbeforeShowDay");
		encodeOptionComponentByType(options, datePicker.getOnchangeMonthYear(), "onchangeMonthYear");
		encodeOptionComponentByType(options, datePicker.getOnclose(), "onclose");
		encodeOptionComponentByType(options, datePicker.getOnselect(), "onselect");
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
