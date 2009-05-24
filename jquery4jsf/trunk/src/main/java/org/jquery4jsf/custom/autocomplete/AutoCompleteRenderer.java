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
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;
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
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = autoComplete.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			if (resource.endsWith(".css")){
				ResourceContext.getInstance().addResource(resource);
			}
			if (resource.endsWith(".js")){
				ResourceContext.getInstance().addResource(resource);
			}
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(autoComplete.getClientId(context));
        JSAttribute jsAutocomplete = new JSAttribute("autocomplete", false);
        StringBuffer sbOption = new StringBuffer();
        jsAutocomplete.addValue(encodeOptionComponent(sbOption, autoComplete, context));
        element.addAttribute(jsAutocomplete);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
        rendererInputText(responseWriter, autoComplete, context);
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
    	if (autoComplete.getJsonValue() != null)
    	{
    		options.append(autoComplete.getJsonValue());
    	}
    	else
    	{
    		String actionURL = getActionURL(context);
    		String clientId = autoComplete.getClientId(context);;
    		if(actionURL.indexOf("?") == -1)
    		{
    			actionURL = actionURL + "?ajaxSourceJQuery=" + clientId;
    		}
    		else
    		{
    			actionURL = actionURL + "&ajaxSourceJQuery=" + clientId;
    		}
    		options.append("\"");
    		options.append(actionURL);
    		options.append("\"");
    	}
    	options.append(", {\n");
		encodeOptionComponentByType(options, autoComplete.getMinChars(), "minChars", "1");
		encodeOptionComponentByType(options, autoComplete.getDelay(), "delay", "400");
		encodeOptionComponentByType(options, autoComplete.getCacheLength(), "cacheLength", null);
		encodeOptionComponentByType(options, autoComplete.isMatchSubset(), "matchSubset", "true");
		encodeOptionComponentByType(options, autoComplete.isMatchCase(), "matchCase", "false");
		encodeOptionComponentByType(options, autoComplete.isMatchContains(), "matchContains", "false");
		encodeOptionComponentByType(options, autoComplete.isMustMatch(), "mustMatch", "false");
		encodeOptionComponentByType(options, autoComplete.isSelectFirst(), "selectFirst", "true");
		//TODO viewroot serial???

		encodeOptionComponentByType(options, autoComplete.getExtraParams(), "extraParams", null);
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
