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
import java.util.Set;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.custom.dialog.AlertDialog;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.JSOperationElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ButtonRenderer extends ButtonBaseRenderer {
	
	private Logger logger = LoggerFactory.getLogger(ButtonRenderer.class);
	private void printRequestValue(HttpServletRequest request){
		Map params = request.getParameterMap();
		Set keySet = params.keySet();
		for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = params.get(key);
			if (value instanceof String[]){
				String[] args = (String[])value;
				for (int i = 0; i < args.length; i++) {
					String valore = args[i];
					System.out.println("Nome parametro: "+key+" valore: "+valore);
				}
			}
			else if (value instanceof String){
				String valore = (String)value;
				System.out.println("Nome parametro: "+key+" valore: "+valore);
			}
			else{
				System.out.println("Nome parametro: "+key+" valore: "+value.toString());
			}
		}
	}
	public void decode(FacesContext context, UIComponent component) {		
		String param = component.getClientId(context);
		printRequestValue((HttpServletRequest) context.getExternalContext().getRequest());
		if(context.getExternalContext().getRequestParameterMap().containsKey(param))
			component.queueEvent(new ActionEvent(component));
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Button button = null;
        if(component instanceof Button)
        	 button = (Button) component;
        
		encodeResources(button);
		encodeButtonScript(context, button);
		encodeButtonMarkup(context, button);
	}

	private void encodeButtonScript(FacesContext context, Button button) throws IOException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		JSDocumentElement documentElement = new JSDocumentElement();
		JSElement element = new JSElement(button.getClientId(context));
		JSAttribute jsCarousel = new JSAttribute("button", false);
		StringBuffer optionsButton = new StringBuffer();
		jsCarousel.addValue(encodeOptionButtonComponent(optionsButton, button, context));
		element.addAttribute(jsCarousel);

		sb.append("\n");

		JSElement buttonElement = new JSElement(button.getClientId(context));
		UIForm uiForm = RendererUtilities.getForm(context, button);
		JSElement formElement = new JSElement(uiForm.getClientId(context));
		JSAttribute jsButton = new JSAttribute("bind",false);
		JSFunction jsFnOnClick = new JSFunction();
		AlertDialog alert = getAlertDialog(button);
		if(alert == null && button.getType().equalsIgnoreCase("submit") && button.isAjaxSubmit()){
			JSAttribute jsForm = null;
			jsForm = new JSAttribute("ajaxSubmit", false);
			StringBuffer sbOption = new StringBuffer();
			jsForm.addValue(encodeOptionComponent(sbOption, button, context));
			formElement.addAttribute(jsForm);
			jsFnOnClick.addJSElement(formElement);
			JSOperationElement jsOperationElement = new JSOperationElement(uiForm.getClientId(context));
			jsOperationElement.addOperation("return false;");
			jsFnOnClick.addJSElement(jsOperationElement);
			jsButton.addValue("'click', "+jsFnOnClick.toJavaScriptCode());
			buttonElement.addAttribute(jsButton);
		}
		
		if (alert != null){
			JSOperationElement jsOperationElement = new JSOperationElement(uiForm.getClientId(context));
			String alertId = RendererUtilities.getJQueryId(alert.getClientId(context));
			jsOperationElement.addOperation("$('"+alertId+"').dialog('open');");
			jsOperationElement.addOperation("return false;");
			jsFnOnClick.addJSElement(jsOperationElement);
			jsButton.addValue("'click', "+jsFnOnClick.toJavaScriptCode());
			buttonElement.addAttribute(jsButton);
		}
		JSFunction function = new JSFunction();
		function.addJSElement(element);
		function.addJSElement(buttonElement);
		documentElement.addFunctionToReady(function);
		sb.append(documentElement.toJavaScriptCode());
		sb.append("\n");


		ResponseWriter responseWriter = context.getResponseWriter();
		RendererUtilities.encodeImportJavascripScript(button, responseWriter, sb); 
	}
	
	private void encodeButtonMarkup(FacesContext context, Button button) throws IOException {
		UIForm form = RendererUtilities.getForm(context, button);
		String buttonId = button.getClientId(context);
		if (form == null){
			throw new FacesException("Il tag Button "+ buttonId + " deve all'interno di un tag form.");
		}
		AlertDialog alertDialog = getAlertDialog(button);
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement("button", button);
		responseWriter.writeAttribute(HTML.ID, buttonId, "id");
		String type = button.getType() == null ? "submit" : button.getType();
		responseWriter.writeAttribute(HTML.TYPE, type, "type");
		responseWriter.writeAttribute(HTML.NAME, buttonId, "name");
		if(button.getStyleClass() != null) {
			responseWriter.writeAttribute("class", button.getStyleClass(), null);
		}
		
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_STD_ATTR, new String[]{HTML.STYLE_CLASS, HTML.STYLE});
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_INPUT_COMMAND_TAG_ATTR, new String[]{HTML.TYPE,HTML.NAME});
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_JS_STD_ATTR);
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, button, HTML.HTML_JS_ELEMENT_ATTR);
		
		if(button.getValue() != null)
		{	
			responseWriter.write((String) button.getValue());
		}
		responseWriter.endElement("button");
		
		if(alertDialog != null) {
			encodeAlertDialogMarkup(context, button, alertDialog);
		}
	}

	private void encodeAlertDialogMarkup(FacesContext context, Button button, AlertDialog alertDialog) throws IOException {
		alertDialog.encodeBegin(context);
		alertDialog.encodeChildren(context);
		alertDialog.encodeEnd(context);
	}

	private AlertDialog getAlertDialog(Button button) {
		List childs = button.getChildren();
		for (Iterator iterator = childs.iterator(); iterator.hasNext();) {
			Object object = iterator.next();
			if (object instanceof AlertDialog) {
				return (AlertDialog) object;
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
		else{
			UIForm form = RendererUtilities.getForm(context, button);
			targetJQ = RendererUtilities.getJQueryId(form.getClientId(context));
		}
		encodeOptionComponentByType(options,targetJQ, "target", null);
		encodeOptionComponentByType(options, clientId , "buttonSubmit", "");
		encodeOptionComponentFunction(options, button.getOnbeforeSubmit(), "onbeforeSubmit", null);
		encodeOptionComponentFunction(options, button.getOnsuccess(), "onsuccess", null);
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
	
	protected String encodeOptionButtonComponent(StringBuffer options, Button button , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, button.getIcon(), "icon", null);
		encodeOptionComponentByType(options, button.isActive(), "active", "true");
		encodeOptionComponentByType(options, button.isToggle(), "isToggle", "true");
		encodeOptionComponentByType(options, button.getCheckButtonset(), "checkButtonset", null);
		encodeOptionComponentFunction(options, button.getOntoggle(), "ontoggle", "ui, event");
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
