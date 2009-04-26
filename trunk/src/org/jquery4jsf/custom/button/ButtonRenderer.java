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
package org.jquery4jsf.custom.button;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.JSOperationElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class ButtonRenderer extends ButtonBaseRenderer implements AjaxBaseRenderer {

	public void encodePartially(FacesContext context, UIComponent component)throws IOException {		
	}

	public String getActionURL(FacesContext context) throws IOException {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Button button = null;
        if(component instanceof Button)
        	button = (Button)component;
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = button.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        String idClient = button.getClientId(context);
        if (!button.isResetForm()){
        	encodeJQueryScript(idClient, button, responseWriter, context);
        }

        responseWriter.startElement(HTML.TAG_INPUT, button);
        writeIdAttributeIfNecessary(context, responseWriter, component);
        if (!button.isResetForm() || !button.isClearForm())
        	responseWriter.writeAttribute("name", idClient, null);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_INPUT_COMMAND_TAG_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_JS_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_JS_ELEMENT_ATTR);
        responseWriter.endElement(HTML.TAG_INPUT);
       
	}
	
	private void encodeJQueryScript(String id, Button button, ResponseWriter responseWriter, FacesContext context) throws IOException{
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement buttonElement = new JSElement(id);
        UIForm uiForm = RendererUtilities.getForm(context, button);
        JSElement formElement = new JSElement(uiForm.getClientId(context));
        JSAttribute jsButton = new JSAttribute("click",false);
        JSFunction jsFnOnClick = new JSFunction();
        
        JSAttribute jsForm = null;
        if (button.isPartialSubmit()){
        	jsForm = new JSAttribute("ajaxForm", false);
        }
        else{
        	jsForm = new JSAttribute("ajaxSubmit", false);
        }
        StringBuffer sbOption = new StringBuffer();
        jsForm.addValue(encodeOptionComponent(sbOption, button, context));
        formElement.addAttribute(jsForm);
        jsFnOnClick.addJSElement(formElement);
        JSOperationElement jsOperationElement = new JSOperationElement(uiForm.getClientId(context));
        jsOperationElement.addOperation("return false;");
        jsFnOnClick.addJSElement(jsOperationElement);
        jsButton.addValue(jsFnOnClick.toJavaScriptCode());
        buttonElement.addAttribute(jsButton);
        JSFunction function = new JSFunction();
        function.addJSElement(buttonElement);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(button, responseWriter, sb); 
	}
	
	public void decode(FacesContext context, UIComponent component) {
		if(context == null || component == null)
			throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));

		Button button = null;
		if(component instanceof Button)
			button = (Button)component;

		if(Util.componentIsDisabledOnReadonly(component))
			return;
		String clientId = component.getClientId(context);
		Map map = context.getExternalContext().getRequestParameterMap();
		String s1 = (String)map.get(clientId);
		if(s1 == null)
			return;
		
		String type = button.getType();
		if(type != null && type.toLowerCase().equals("reset"))
		{
			return;
		} 
		else
		{
			button.queueEvent(new ActionEvent(component));
			return;
		}
	}
	
	protected String encodeOptionComponent(StringBuffer options, Button button , FacesContext context) {
		options.append(" {\n");
		//encodeOptionComponentByType(options, button.isPartialSubmit(), "partialSubmit", null);
		
		String target = button.getTarget();
		if (target == null || target.trim().length() == 0){
			target = RendererUtilities.getFormId(context, button);
		}else{
			target = RendererUtilities.getClientIdForComponent(target, context, button);
		}
		
		if (button.getUrl() != null)
			encodeOptionComponentByType(options, button.getUrl(), "url", null);
		else{
			String actionURL = RendererUtilities.getActionURL(context);
			String clientId = button.getClientId(context);;
			String reRenderedId = RendererUtilities.getClientIdForComponent(target, context, button);
			if(actionURL.indexOf("?") == -1)
			{
				actionURL = actionURL + "?ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + reRenderedId;
			}
			else
			{
				actionURL = actionURL + "&ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + reRenderedId ;
			}
			encodeOptionComponentByType(options, actionURL, "url", null);
		}
		String targetJQ = RendererUtilities.getJQueryId(target);
		encodeOptionComponentByType(options,targetJQ, "target", null);
		encodeOptionComponentByType(options, button.getTypeSubmit(), "type", "post");
		encodeOptionComponentFunction(options, button.getOnbeforeSubmit(), "onbeforeSubmit");
		encodeOptionComponentFunction(options, button.getOnsuccess(), "onsuccess");
		encodeOptionComponentByType(options, button.getDataType(), "dataType", "");
		encodeOptionComponentByType(options, button.isSemantic(), "semantic", null);
		encodeOptionComponentByType(options, button.isResetForm(), "resetForm", null);
		encodeOptionComponentByType(options, button.isClearForm(), "clearForm", null);
		encodeOptionComponentByType(options, button.isIframe(), "iframe", null);
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
