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
package org.jquery4jsf.custom.ajax;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class AjaxEventRenderer extends AjaxEventBaseRenderer implements AjaxBaseRenderer{

	public void encodePartially(FacesContext context, UIComponent component)throws IOException {
		
	}

	public String getActionURL(FacesContext context) throws IOException {
		return RendererUtilities.getActionURL(context);
	}
	

	public void decode(FacesContext context, UIComponent component) {
		AjaxEvent ajaxEvent = (AjaxEvent) component;
		String clientId = ajaxEvent.getClientId(context);
		if(context.getExternalContext().getRequestParameterMap().containsKey(clientId)) {
			ajaxEvent.queueEvent(new ActionEvent(ajaxEvent));
		}
	}
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        AjaxEvent ajaxEvent = null;
        if(component instanceof AjaxEvent)
            ajaxEvent = (AjaxEvent)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = ajaxEvent.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
		
       String parentId = ajaxEvent.getParent().getClientId(context);
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(parentId);
        JSAttribute jsAjaxContent = new JSAttribute("ajaxContent", false);
        StringBuffer sbOption = new StringBuffer();
        jsAjaxContent.addValue(encodeOptionComponent(sbOption, ajaxEvent, context));
        element.addAttribute(jsAjaxContent);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
	}
	
	protected String encodeOptionComponent(StringBuffer options, AjaxEvent ajaxEvent , FacesContext context) {
		options.append(" {\n");
		String target = RendererUtilities.getJQueryIdComponent(ajaxEvent.getReRender(), context, ajaxEvent);
		encodeOptionComponentByType(options, target, "target", null);
		UIForm form = RendererUtilities.getForm(context, ajaxEvent);
		String formId = RendererUtilities.getJQueryIdComponent(context, form);
		encodeOptionComponentByType(options,formId, "form", null);
		encodeOptionComponentByType(options, ajaxEvent.getEvent(), "event", "click");
		String actionURL = null;
		try {
			actionURL = getActionURL(context);
		} catch (IOException e) {
		}
		String clientId = ajaxEvent.getClientId(context);;
		
		String reRenderedId = RendererUtilities.getClientIdForComponent(ajaxEvent.getReRender(), context, ajaxEvent);
		if(actionURL.indexOf("?") == -1)
		{
			actionURL = actionURL + "?ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + reRenderedId;
		}
		else
		{
			actionURL = actionURL + "&ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + reRenderedId ;
		}
		encodeOptionComponentByType(options, actionURL, "url", null);
		//encodeOptionComponentByType(options, ajaxEvent.isPartialSubmit(), "partialSubmit", "true");
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
