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
				RendererUtilities.addCssForJQueryPlugin(component, responseWriter, context, resource);
			}
			if (resource.endsWith(".js")){
				RendererUtilities.addJsForJQueryPlugin(component, responseWriter, context, resource);
			}
		}
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        if (req.getLocale() != null){
        	String locale = req.getLocale().toString();
        	
        	String src = "datepicker/i18n/ui.datepicker-"+locale.substring(0,2)+".js";
        	RendererUtilities.addJsForJQueryPlugin(component, responseWriter, context, src);
        }
        
        responseWriter.startElement("input", component);
        writeIdAttributeIfNecessary(context, responseWriter, component);
        responseWriter.writeAttribute("type", "text", null);
        responseWriter.writeAttribute("name", component.getClientId(context), "clientId");
        Object object = datePicker.getValue();
        if(datePicker.getValue() != null)
            responseWriter.writeAttribute("value", object.toString(), "value");
        if(datePicker.getStyleClass() != null)
            responseWriter.writeAttribute("class", datePicker.getStyleClass(), "styleClass");
        if(datePicker.getAccesskey() != null)
            responseWriter.writeAttribute("accesskey", datePicker.getAccesskey(), null);
        if(datePicker.getAlt() != null)
            responseWriter.writeAttribute("alt", datePicker.getAlt(), null);
        if(datePicker.getDir() != null)
            responseWriter.writeAttribute("dir", datePicker.getDir(), null);
        if(datePicker.isDisabled())
            responseWriter.writeAttribute("disabled", "disabled", null);
        if(datePicker.getLang() != null)
            responseWriter.writeAttribute("lang", datePicker.getLang(), null);
        if(datePicker.getMaxlength() > 0)
            responseWriter.writeAttribute("maxlength", new Integer(datePicker.getMaxlength()), null);
        if(datePicker.getOnblur() != null)
            responseWriter.writeAttribute("onblur", datePicker.getOnblur(), null);
        if(datePicker.getOnchange() != null)
            responseWriter.writeAttribute("onchange", datePicker.getOnchange(), null);
        if(datePicker.getOnclick() != null)
            responseWriter.writeAttribute("onclick", datePicker.getOnclick(), null);
        if(datePicker.getOndblclick() != null)
            responseWriter.writeAttribute("ondblclick", datePicker.getOndblclick(), null);
        if(datePicker.getOnfocus() != null)
            responseWriter.writeAttribute("onfocus", datePicker.getOnfocus(), null);
        if(datePicker.getOnkeydown() != null)
            responseWriter.writeAttribute("onkeydown", datePicker.getOnkeydown(), null);
        if(datePicker.getOnkeypress() != null)
            responseWriter.writeAttribute("onkeypress", datePicker.getOnkeypress(), null);
        if(datePicker.getOnkeyup() != null)
            responseWriter.writeAttribute("onkeyup", datePicker.getOnkeyup(), null);
        if(datePicker.getOnmousedown() != null)
            responseWriter.writeAttribute("onmousedown", datePicker.getOnmousedown(), null);
        if(datePicker.getOnmousemove() != null)
            responseWriter.writeAttribute("onmousemove", datePicker.getOnmousemove(), null);
        if(datePicker.getOnmouseout() != null)
            responseWriter.writeAttribute("onmouseout", datePicker.getOnmouseout(), null);
        if(datePicker.getOnmouseover() != null)
            responseWriter.writeAttribute("onmouseover", datePicker.getOnmouseover(), null);
        if(datePicker.getOnmouseup() != null)
            responseWriter.writeAttribute("onmouseup", datePicker.getOnmouseup(), null);
        if(datePicker.getOnselect() != null)
            responseWriter.writeAttribute("onselect", datePicker.getOnselect(), null);
        if(datePicker.isReadonly())
            responseWriter.writeAttribute("readonly", "readonly", null);
        if(datePicker.getSize() > 0)
            responseWriter.writeAttribute("size", new Integer(datePicker.getSize()), null);
        if(datePicker.getStyle() != null)
            responseWriter.writeAttribute("style", datePicker.getStyle(), null);
        if(datePicker.getTabindex() != null)
            responseWriter.writeAttribute("tabindex", datePicker.getTabindex(), null);
        if(datePicker.getTitle() != null)
            responseWriter.writeAttribute("title", datePicker.getTitle(), null);
        responseWriter.endElement("input");
        
        
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

	private String createOptionComponent(StringBuffer options, DatePicker dp, FacesContext context) {
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
