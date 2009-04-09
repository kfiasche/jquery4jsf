package org.jquery4jsf.custom.datapiker;

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
import org.jquery4jsf.renderkit.JQueryInputBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class DatePickerRenderer extends JQueryInputBaseRenderer implements AjaxBaseRenderer {
	
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
			if (resource.endsWith(".css")){
				ResourceContext.getInstance().addResource(resource);
			}
			if (resource.endsWith(".js")){
				ResourceContext.getInstance().addResource(resource);
			}
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
        jsAutocomplete.addValue(createOptionComponent(sbOption, datePicker, context));
        element.addAttribute(jsAutocomplete);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
	}

	protected String createOptionComponent(StringBuffer options, DatePicker dp, FacesContext context) {
		options.append(" {\n");
		createOptionComponentByType(options, RendererUtilities.getJQueryIdComponent(dp.getAltField(), context, dp), "altField");
		createOptionComponentByType(options, dp.getAltFormat(), "altFormat");
		createOptionComponentByType(options, dp.getAppendText(), "appendText");
		createOptionComponentByType(options, dp.getButtonImage(), "buttonImage");
		createOptionComponentByType(options, dp.isButtonImageOnly(), "buttonImageOnly");
		createOptionComponentByType(options, dp.getButtonText(), "buttonText");
		createOptionComponentByType(options, dp.isChangeMonth(), "changeMonth");
		createOptionComponentByType(options, dp.isChangeYear(), "changeYear");
		createOptionComponentByType(options, dp.getCloseText(), "closeText");
		createOptionComponentByType(options, dp.isConstrainInput(), "constrainInput");
		createOptionComponentByType(options, dp.getCurrentText(), "currentText");
		createOptionComponentByType(options, dp.getDateFormat(), "dateFormat");
		createOptionComponentArrayByType(options, dp.getDayNames(), "dayNames");
		createOptionComponentArrayByType(options, dp.getDayNamesMin(), "dayNamesMin");
		createOptionComponentArrayByType(options, dp.getDayNamesShort(), "dayNamesShort");
		createOptionComponentByType(options, dp.getDefaultDate(),"defaultDate");
		createOptionComponentByType(options, dp.getDuration(),"duration");
		createOptionComponentByType(options, dp.getFirstDay(), "firstDay");
		createOptionComponentByType(options, dp.isGotoCurrent(), "gotoCurrent");
		createOptionComponentByType(options, dp.isHideIfNoPrevNext(), "hideIfNoPrevNext");
		createOptionComponentByType(options, dp.isRTL(), "isRTL");
		createOptionComponentByType(options, dp.getMaxDate(), "maxDate");
		createOptionComponentByType(options, dp.getMinDate(), "minDate");
		createOptionComponentArrayByType(options, dp.getMonthNames(), "monthNames");
		createOptionComponentArrayByType(options, dp.getMonthNamesShort(), "monthNamesShort");
		createOptionComponentByType(options, dp.isNavigationAsDateFormat(), "navigationAsDateFormat");
		createOptionComponentByType(options, dp.getNextText(), "nextText");
		createOptionComponentArrayByType(options, dp.getNumberOfMonths(), "numberOfMonths");
		createOptionComponentByType(options, dp.getPrevText(), "prevText");
		createOptionComponentByType(options, dp.getShowAnim(), "showAnim");
		createOptionComponentByType(options, dp.isShowButtonPanel(), "showButtonPanel");
		createOptionComponentByType(options, dp.getShowCurrentAtPos(), "showCurrentAtPos");
		createOptionComponentByType(options, dp.isShowMonthAfterYear(), "showMonthAfterYear");
		createOptionComponentByType(options, dp.getShowOn(), "showOn");
		createOptionComponentOptionsByType(options, dp.getShowOptions(), "showOptions");
		createOptionComponentByType(options, dp.isShowOtherMonths(), "showOtherMonths");
		createOptionComponentByType(options, dp.getStepMonths(), "stepMonths");
		createOptionComponentByType(options, dp.getYearRange(), "yearRange");
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
