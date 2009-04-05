package org.jquery4jsf.custom.autocomplete;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.el.MethodBinding;
import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.JQueryInputBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;

import com.sun.faces.util.Util;

public class AutoCompleteRenderer extends JQueryInputBaseRenderer implements AjaxBaseRenderer {

    public static final String RENDERER_TYPE = "org.jquery4jsf.HtmlInputTextAutocompleteRenderer";
    
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        AutoComplete autoComplete = null;
        if(component instanceof AutoComplete)
            autoComplete = (AutoComplete)component;
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("input", component);
        writeIdAttributeIfNecessary(context, responseWriter, component);
        responseWriter.writeAttribute("type", "text", null);
        responseWriter.writeAttribute("name", component.getClientId(context), "clientId");
        
        
        Object object = autoComplete.getValue();
        
        if(autoComplete.getValue() != null)
            responseWriter.writeAttribute("value", object.toString(), "value");
        if(autoComplete.getStyleClass() != null)
            responseWriter.writeAttribute("class", autoComplete.getStyleClass(), "styleClass");
        if(autoComplete.getAccesskey() != null)
            responseWriter.writeAttribute("accesskey", autoComplete.getAccesskey(), null);
        if(autoComplete.getAlt() != null)
            responseWriter.writeAttribute("alt", autoComplete.getAlt(), null);
        if(autoComplete.getDir() != null)
            responseWriter.writeAttribute("dir", autoComplete.getDir(), null);
        if(autoComplete.isDisabled())
            responseWriter.writeAttribute("disabled", "disabled", null);
        if(autoComplete.getLang() != null)
            responseWriter.writeAttribute("lang", autoComplete.getLang(), null);
        if(autoComplete.getMaxlength() > 0)
            responseWriter.writeAttribute("maxlength", new Integer(autoComplete.getMaxlength()), null);
        if(autoComplete.getOnblur() != null)
            responseWriter.writeAttribute("onblur", autoComplete.getOnblur(), null);
        if(autoComplete.getOnchange() != null)
            responseWriter.writeAttribute("onchange", autoComplete.getOnchange(), null);
        if(autoComplete.getOnclick() != null)
            responseWriter.writeAttribute("onclick", autoComplete.getOnclick(), null);
        if(autoComplete.getOndblclick() != null)
            responseWriter.writeAttribute("ondblclick", autoComplete.getOndblclick(), null);
        if(autoComplete.getOnfocus() != null)
            responseWriter.writeAttribute("onfocus", autoComplete.getOnfocus(), null);
        if(autoComplete.getOnkeydown() != null)
            responseWriter.writeAttribute("onkeydown", autoComplete.getOnkeydown(), null);
        if(autoComplete.getOnkeypress() != null)
            responseWriter.writeAttribute("onkeypress", autoComplete.getOnkeypress(), null);
        if(autoComplete.getOnkeyup() != null)
            responseWriter.writeAttribute("onkeyup", autoComplete.getOnkeyup(), null);
        if(autoComplete.getOnmousedown() != null)
            responseWriter.writeAttribute("onmousedown", autoComplete.getOnmousedown(), null);
        if(autoComplete.getOnmousemove() != null)
            responseWriter.writeAttribute("onmousemove", autoComplete.getOnmousemove(), null);
        if(autoComplete.getOnmouseout() != null)
            responseWriter.writeAttribute("onmouseout", autoComplete.getOnmouseout(), null);
        if(autoComplete.getOnmouseover() != null)
            responseWriter.writeAttribute("onmouseover", autoComplete.getOnmouseover(), null);
        if(autoComplete.getOnmouseup() != null)
            responseWriter.writeAttribute("onmouseup", autoComplete.getOnmouseup(), null);
        if(autoComplete.getOnselect() != null)
            responseWriter.writeAttribute("onselect", autoComplete.getOnselect(), null);
        if(autoComplete.isReadonly())
            responseWriter.writeAttribute("readonly", "readonly", null);
        if(autoComplete.getSize() > 0)
            responseWriter.writeAttribute("size", new Integer(autoComplete.getSize()), null);
        if(autoComplete.getStyle() != null)
            responseWriter.writeAttribute("style", autoComplete.getStyle(), null);
        if(autoComplete.getTabindex() != null)
            responseWriter.writeAttribute("tabindex", autoComplete.getTabindex(), null);
        if(autoComplete.getTitle() != null)
            responseWriter.writeAttribute("title", autoComplete.getTitle(), null);
        
        responseWriter.endElement("input");
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = autoComplete.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			if (resource.endsWith(".css")){
				RendererUtilities.addCssForJQueryPlugin(component, responseWriter, context, resource);
			}
			if (resource.endsWith(".js")){
				RendererUtilities.addJsForJQueryPlugin(component, responseWriter, context, resource);
			}
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(autoComplete.getClientId(context));
        JSAttribute jsAutocomplete = new JSAttribute("autocomplete", false);
        StringBuffer sbOption = new StringBuffer();
        jsAutocomplete.addValue(createOptionComponent(sbOption, autoComplete, context));
        element.addAttribute(jsAutocomplete);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
	}
	
    private String createOptionComponent(StringBuffer sbOption, AutoComplete autoComplete, FacesContext context) throws IOException {
        if (autoComplete.getJsonValue() != null){
            sbOption.append(autoComplete.getJsonValue());
            sbOption.append(", {\n");
            if (autoComplete.getMinChars() != -1){
                sbOption.append("minChars: "+ autoComplete.getMinChars() +", \n");
            }
            if (autoComplete.getMax() != -1){
                sbOption.append("max: "+ autoComplete.getMax() +", \n");
            }
            if (autoComplete.isAutoFill()){
                sbOption.append("autoFill: "+ autoComplete.isAutoFill() +", \n");
            }
            if (autoComplete.isMustMatch()){
                sbOption.append("mustMatch: "+ autoComplete.isMustMatch() +", \n");
            }
            if (autoComplete.isMatchContains()){
                sbOption.append("matchContains: "+ autoComplete.isMatchContains() +", \n");
            }
            if (autoComplete.getScrollHeight() != -1){
                sbOption.append("scrollHeight: "+ autoComplete.getScrollHeight() +", \n");
            }
            if (autoComplete.isSelectFirst()){
                sbOption.append("selectFirst: "+ autoComplete.isSelectFirst() +", \n");
            }
            if (autoComplete.isHighlight()){
                sbOption.append("highlight: "+ autoComplete.isHighlight() +", \n");
            }
            if (autoComplete.isScroll()){
                sbOption.append("scroll: "+ autoComplete.isScroll() +", \n");
            }
            if (autoComplete.isMultiple()){
                sbOption.append("multiple: "+ autoComplete.isMultiple() +", \n");
            }
            if (autoComplete.getMultipleSeparator() != null){
                sbOption.append("multipleSeparator: "+ autoComplete.getMultipleSeparator() +", \n");
            }
            if (sbOption.toString().endsWith(", \n")){
                String stringa = sbOption.substring(0, sbOption.length()-3);
                sbOption = new StringBuffer(stringa);
            }
            sbOption.append("}");
        }
        else {
    		String actionURL = getActionURL(context);
    		String clientId = autoComplete.getClientId(context);;
    		if(actionURL.indexOf("?") == -1)
    			actionURL = actionURL + "?ajaxSourceJQuery=" + clientId;
    		else
    			actionURL = actionURL + "&ajaxSourceJQuery=" + clientId;
    		
    		sbOption.append("\"");
    		sbOption.append(actionURL);
    		sbOption.append("\"");
            sbOption.append(", {\n");
            if (autoComplete.getMinChars() != -1){
                sbOption.append("minChars: "+ autoComplete.getMinChars() +", \n");
            }
            if (autoComplete.getMax() != -1){
                sbOption.append("max: "+ autoComplete.getMax() +", \n");
            }
            if (autoComplete.isAutoFill()){
                sbOption.append("autoFill: "+ autoComplete.isAutoFill() +", \n");
            }
            if (autoComplete.isMustMatch()){
                sbOption.append("mustMatch: "+ autoComplete.isMustMatch() +", \n");
            }
            if (autoComplete.isMatchContains()){
                sbOption.append("matchContains: "+ autoComplete.isMatchContains() +", \n");
            }
            if (autoComplete.getScrollHeight() != -1){
                sbOption.append("scrollHeight: "+ autoComplete.getScrollHeight() +", \n");
            }
            if (autoComplete.isSelectFirst()){
                sbOption.append("selectFirst: "+ autoComplete.isSelectFirst() +", \n");
            }
            if (autoComplete.isHighlight()){
                sbOption.append("highlight: "+ autoComplete.isHighlight() +", \n");
            }
            if (autoComplete.isScroll()){
                sbOption.append("scroll: "+ autoComplete.isScroll() +", \n");
            }
            if (autoComplete.isMultiple()){
                sbOption.append("multiple: "+ autoComplete.isMultiple() +", \n");
            }
            if (autoComplete.getMultipleSeparator() != null){
                sbOption.append("multipleSeparator: "+ autoComplete.getMultipleSeparator() +", \n");
            }
            if (sbOption.toString().endsWith(", \n")){
                String stringa = sbOption.substring(0, sbOption.length()-3);
                sbOption = new StringBuffer(stringa);
            }
            sbOption.append("}");
            if (sbOption.toString().endsWith(", {\n}")){
            	String stringa = sbOption.substring(0, sbOption.length()-5);
            	sbOption = new StringBuffer(stringa);
            }
        }
        return sbOption.toString();
    }
	
	public void encodeChildren(FacesContext context, UIComponent component) {
	}

	public void encodePartially(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		AutoComplete autoComplete = (AutoComplete) component;
		MethodBinding me = autoComplete.getOncomplete();
		HttpServletRequest req = (HttpServletRequest)context.getExternalContext().getRequest();
		String query = req.getParameter("q");
		List results = null;
		try {
			results = (List) me.invoke(context, new Object[]{query});
		} catch (Exception e) {
		}
		int i=0;
		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
			String result = (String)iterator.next();
			String row = result.concat("|").concat(Integer.toString(i)).concat("\n");
			writer.write(row);
			i++;
		}
	}
    
	
	public void decode(FacesContext context, UIComponent component) {
		AutoComplete autoComplete = (AutoComplete) component;
		String paramKey = autoComplete.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(paramKey);
		autoComplete.setSubmittedValue(submittedValue);
	}

	public String getActionURL(FacesContext context) throws IOException {
		return RendererUtilities.getActionURL(context);
	}
}
