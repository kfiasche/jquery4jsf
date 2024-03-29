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
package org.jquery4jsf.custom.autocomplete;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.el.MethodBinding;
import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;

public class AutoCompleteRenderer extends AutoCompleteBaseRenderer implements AjaxBaseRenderer {

    public static final String RENDERER_TYPE = "org.jquery4jsf.HtmlInputTextAutocompleteRenderer";
    
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        AutoComplete autoComplete = null;
        if(component instanceof AutoComplete)
            autoComplete = (AutoComplete)component;
        
        encodeResources(autoComplete);
        encodeAutoCompleteScript(context, autoComplete);
        encodeInputText(autoComplete, context);
	}
	
	protected void encodeAutoCompleteScript(FacesContext context, AutoComplete autoComplete) throws IOException{
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, autoComplete));
        documentElement.addFunctionToReady(function);
	}
	
	public JSElement getJSElement(FacesContext context, UIComponent component){
        AutoComplete autoComplete = null;
        if(component instanceof AutoComplete)
            autoComplete = (AutoComplete)component;
        JSElement element = new JSElement(autoComplete.getClientId(context));
        JSAttribute jsAutocomplete = new JSAttribute("autocomplete", false);
        StringBuffer options = new StringBuffer();
        jsAutocomplete.addValue(encodeOptionComponent(options, autoComplete, context));
        element.addAttribute(jsAutocomplete);
        return element;
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
			System.out.println("Error invoke method: "+e.getMessage());
		}
		int i=0;
		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
			String result = (String)iterator.next();
			String row = result.concat("|").concat(Integer.toString(i)).concat("\n");
			writer.write(row);
			i++;
		}
	}
    
	protected String encodeOptionComponent(StringBuffer options, AutoComplete autoComplete , FacesContext context) {
		UIForm form = RendererUtilities.getForm(context, autoComplete);
		String clientId = autoComplete.getClientId(context);
		if (form == null){
			throw new FacesException("Il tag autoComplete "+ clientId + " deve essere all'interno di un tag form.");
		}
		options.append(" {\n");
		if (autoComplete.getJsonValue() != null)
    	{
			encodeOptionComponentByType(options, autoComplete.getJsonValue(), "data", null);
    	}
    	else
    	{
    		String actionURL = getActionURL(context);
    		if(actionURL.indexOf("?") == -1)
    		{
    			actionURL = actionURL + "?ajaxSourceJQuery=" + clientId;
    		}
    		else
    		{
    			actionURL = actionURL + "&ajaxSourceJQuery=" + clientId;
    		}
    		encodeOptionComponentByType(options, actionURL, "url", null);
    	}
		encodeOptionComponentByType(options, autoComplete.getMinChars(), "minChars", "1");
		encodeOptionComponentByType(options, autoComplete.getDelay(), "delay", "400");
		encodeOptionComponentByType(options, autoComplete.getCacheLength(), "cacheLength", null);
		encodeOptionComponentByType(options, autoComplete.isMatchSubset(), "matchSubset", "true");
		encodeOptionComponentByType(options, autoComplete.isMatchCase(), "matchCase", "false");
		encodeOptionComponentByType(options, autoComplete.isMatchContains(), "matchContains", "false");
		encodeOptionComponentByType(options, autoComplete.isMustMatch(), "mustMatch", "false");
		encodeOptionComponentByType(options, autoComplete.isSelectFirst(), "selectFirst", "true");
		encodeOptionComponentByType(options, encodeOptionsWithUIParam(autoComplete), "extraParams", null);
		encodeOptionComponentByType(options, autoComplete.getOnformatItem(), "formatItem", null);
		encodeOptionComponentByType(options, autoComplete.getOnformatMatch(), "formatMatch", null);
		encodeOptionComponentByType(options, autoComplete.getOnformatResult(), "formatResult", null);
		encodeOptionComponentByType(options, autoComplete.isMultiple(), "multiple", "false");
		encodeOptionComponentByType(options, autoComplete.getMultipleSeparator(), "multipleSeparator", null);
		encodeOptionComponentByType(options, autoComplete.getWidth(), "width", "0");
		encodeOptionComponentByType(options, autoComplete.isAutoFill(), "autoFill", "false");
		encodeOptionComponentByType(options, autoComplete.getMax(), "max", "10");
		encodeOptionComponentByType(options, autoComplete.getHighlight(), "highlight", null);
		encodeOptionComponentByType(options, autoComplete.isScroll(), "scroll", "true");
		encodeOptionComponentByType(options, autoComplete.getScrollHeight(), "scrollHeight", "180");
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
	
	public void decode(FacesContext context, UIComponent component) {
		AutoComplete autoComplete = (AutoComplete) component;
		String paramKey = autoComplete.getClientId(context);
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(paramKey);
		autoComplete.setSubmittedValue(submittedValue);
	}

	public String getActionURL(FacesContext context){
		return RendererUtilities.getActionURL(context);
	}
}
