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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.custom.dialog.AlertDialog;
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
import org.jquery4jsf.utilities.MessageFactory;

public class ButtonRenderer extends ButtonBaseRenderer implements AjaxBaseRenderer {

	public void encodePartially(FacesContext context, UIComponent component)throws IOException {		
	}

	public String getActionURL(FacesContext context){
		return RendererUtilities.getActionURL(context);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Button button = null;
        if(component instanceof Button)
        	button = (Button)component;
        
		UIComponent form = RendererUtilities.getForm(context, component);
		if(form == null) {
			throw new FacesException(MessageFactory.getMessage("org.jquery4jsf.BUTTON_PARENT_FORM"));
		}
        ResponseWriter responseWriter = context.getResponseWriter();
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = button.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        String idClient = button.getClientId(context);
        AlertDialog alert = getAlertDialog(button);
        if (alert != null){
        	alert.encodeBegin(context);
        	alert.encodeChildren(context);
        	alert.encodeEnd(context);
        }
        responseWriter.startElement(HTML.TAG_INPUT, button);
        writeIdAttributeIfNecessary(context, responseWriter, component);
        if (!button.isResetForm() || !button.isClearForm())
        	responseWriter.writeAttribute("name", idClient, null);
        String styleClass = "ui-button ui-state-default ui-priority-primary ui-corner-all ";
        if (button.isDisabled()){
        	styleClass = "ui-state-default ui-state-disabled ui-corner-all ";
        }
        if (button.getStyleClass() != null){
        	styleClass = styleClass.concat(button.getStyleClass());
        }
        else{
        	button.setStyleClass(styleClass);
        }
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_INPUT_COMMAND_TAG_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_JS_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_JS_ELEMENT_ATTR);
        responseWriter.endElement(HTML.TAG_INPUT);
        
        if (!button.getType().equalsIgnoreCase("reset") 
        		&& (button.getTarget()!=null 
        				|| alert != null)){
        	encodeJQueryButtonScript(idClient, button, responseWriter, context);
        }
       
	}
	
	private void encodeJQueryButtonScript(String id, Button button, ResponseWriter responseWriter, FacesContext context) throws IOException{
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement buttonElement = new JSElement(id);
        UIForm uiForm = RendererUtilities.getForm(context, button);
        JSElement formElement = new JSElement(uiForm.getClientId(context));
        JSAttribute jsButton = new JSAttribute("click",false);
        JSFunction jsFnOnClick = new JSFunction();
        AlertDialog alert = getAlertDialog(button);
        if(alert == null){
	        JSAttribute jsForm = null;
	       	jsForm = new JSAttribute("ajaxSubmit", false);
	        StringBuffer sbOption = new StringBuffer();
	        jsForm.addValue(encodeOptionComponent(sbOption, button, context));
	        formElement.addAttribute(jsForm);
	        jsFnOnClick.addJSElement(formElement);
        }
        else{
        	String clientIdAlert = RendererUtilities.getJQueryId(alert.getClientId(context));
        	JSOperationElement jsOperationElement = new JSOperationElement(clientIdAlert);
        	jsOperationElement.addOperation("$('"+clientIdAlert+"').dialog('open');");
            jsFnOnClick.addJSElement(jsOperationElement);
        }
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
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));

		Button button = null;
		if(component instanceof Button)
			button = (Button)component;

		String clientId = component.getClientId(context);
		Map map = context.getExternalContext().getRequestParameterMap();
		String s1 = (String)map.get(clientId.concat(":button"));
		String s2 = (String)map.get(clientId);
		if(s1 == null && s2 == null)
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
	
	private AlertDialog getAlertDialog(Button button) {
		List children = button.getChildren();
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (object instanceof AlertDialog) {
				AlertDialog alert = (AlertDialog) object;
				return alert;
			}
		}
		return null;
	}
	
	protected String encodeOptionComponent(StringBuffer options, Button button , FacesContext context) {
		options.append(" {\n");
		String target = button.getTarget();
		String clientId = button.getClientId(context);;
		if (target == null || target.trim().length() == 0){
			target = null;
		}else{
			target = RendererUtilities.getClientIdForComponent(target, context, button);
		}
		if (button.getUrl() != null)
			encodeOptionComponentByType(options, button.getUrl(), "url", null);
		else{
			String actionURL = RendererUtilities.getActionURL(context);
			if(actionURL.indexOf("?") == -1)
			{
				actionURL = actionURL + "?ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + target;
			}
			else
			{
				actionURL = actionURL + "&ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + target ;
			}
			encodeOptionComponentByType(options, actionURL, "url", null);
		}
		String targetJQ = null;
		if(target != null){
			targetJQ = RendererUtilities.getJQueryId(target);
		}
		encodeOptionComponentByType(options,targetJQ, "target", null);
		encodeOptionComponentByType(options, button.getTypeSubmit(), "type", "post");
		encodeOptionComponentByType(options, clientId.concat(":button") , "buttonSubmit", "");
		encodeOptionComponentFunction(options, button.getOnbeforeSubmit(), "onbeforeSubmit", null);
		encodeOptionComponentFunction(options, button.getOnsuccess(), "onsuccess", null);
		encodeOptionComponentByType(options, button.getDataType(), "dataType", "");
		encodeOptionComponentByType(options, button.isSemantic(), "semantic", "false");
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

	public boolean getRendersChildren() {
		return true;
	}

	public void encodeChildren(FacesContext arg0, UIComponent arg1)throws IOException {
	}
	
	
	
}
