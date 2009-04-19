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
import org.jquery4jsf.resource.ResourceContext;

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
        jsAutocomplete.addValue(createOptionComponent(sbOption, autoComplete, context));
        element.addAttribute(jsAutocomplete);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
        rendererInputText(responseWriter, autoComplete, context);
	}
	
    private String createOptionComponent(StringBuffer options, AutoComplete autoComplete, FacesContext context) throws IOException {
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
    	encodeOptionComponentByType(options, autoComplete.getMinChars(), "minChars");
    	encodeOptionComponentByType(options, autoComplete.getDelay(), "delay");
    	encodeOptionComponentByType(options, autoComplete.getCacheLength(), "cacheLength");
    	encodeOptionComponentByType(options, autoComplete.isMatchSubset(), "matchSubset");
    	encodeOptionComponentByType(options, autoComplete.isMatchCase(), "matchCase");
    	encodeOptionComponentByType(options, autoComplete.isMustMatch(), "mustMatch");
    	encodeOptionComponentByType(options, autoComplete.isSelectFirst(), "selectFirst");
    	//TODO devo inserire questo parametro
    	//encodeOptionComponentByType(options, autoComplete.getExtraParams(), "extraParams");
    	//encodeOptionComponentByFunction(options, autoComplete.getFormatItem(), "formatItem");
    	//encodeOptionComponentByFunction(options, autoComplete.getFormatMatch(), "formatMatch");
    	//encodeOptionComponentByFunction(options, autoComplete.getFormatResult(), "formatResult");
    	encodeOptionComponentByType(options, autoComplete.isMultiple(), "multiple");
    	encodeOptionComponentByType(options, autoComplete.getMultipleSeparator(), "multipleSeparator");
    	//encodeOptionComponentByType(options, autoComplete.get(), "width");
    	encodeOptionComponentByType(options, autoComplete.isAutoFill(), "autoFill");
    	encodeOptionComponentByType(options, autoComplete.getMax(), "max");
    	encodeOptionComponentByType(options, autoComplete.isHighlight(), "highlight");
    	encodeOptionComponentByType(options, autoComplete.isScroll(), "scroll");
    	encodeOptionComponentByType(options, autoComplete.getScrollHeight(), "scrollHeight");
		if (options.toString().endsWith(", \n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (options.toString().endsWith(", {\n")){
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
