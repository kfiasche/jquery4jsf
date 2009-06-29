/*
 
*  Copyright (c) 2009 Giuseppe Trisciuoglio 
* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jquery4jsf.custom.commandlink;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.JSOperationElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.JQueryUtilities;
import org.jquery4jsf.utilities.MessageFactory;


public class CommandLinkRenderer extends CommandLinkBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component)throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
		CommandLink commandLink = null;
        if (component instanceof CommandLink)
        	commandLink = (CommandLink)component;
        
        encodeResources(commandLink);
        encodeCommandLinkScript(context, commandLink);
        encodeCommandLinkMarkup(context, commandLink);
	}

	protected void encodeCommandLinkMarkup(FacesContext context, CommandLink commandLink) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement(HTML.TAG_A, commandLink);
        writer.writeAttribute("id",commandLink.getClientId(context) , "id");
        writer.writeAttribute("href","#", null);
        HtmlRendererUtilities.writeHtmlAttributes(writer, commandLink, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, commandLink, HTML.HTML_JS_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, commandLink, HTML.HTML_JS_ELEMENT_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, commandLink, HTML.HTML_A_TAG_ATTR);
        writer.write((String)commandLink.getValue());
        writer.endElement(HTML.TAG_A);
	}

	protected void encodeCommandLinkScript(FacesContext context, CommandLink commandLink) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement buttonElement = new JSElement(commandLink.getClientId(context));
        UIForm uiForm = RendererUtilities.getForm(context, commandLink);
        if (uiForm == null){
        	throw new FacesException("Il componente non puo' essere racchiuso in una form.");
        }
        JSElement formElement = new JSElement(uiForm.getClientId(context));
        JSAttribute jsButton = new JSAttribute("click",false);
        JSFunction jsFnOnClick = new JSFunction();
        JSAttribute jsForm = null;
       	jsForm = new JSAttribute("ajaxSubmit", false);
        StringBuffer sbOption = new StringBuffer();
        jsForm.addValue(encodeOptionComponent(sbOption, commandLink, context));
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
        RendererUtilities.encodeImportJavascripScript(commandLink, responseWriter, sb); 
	}
	
	
	protected String encodeOptionComponent(StringBuffer options, CommandLink commandLink , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, commandLink.getTarget(), "target", null);
		if (JQueryUtilities.isTacconiteEnabled()) encodeOptionComponentByType(options, "xml", "dataType", null);
		encodeOptionComponentByType(options, commandLink.getCharset(), "charset", null);
		encodeOptionComponentByType(options, commandLink.getCoords(), "coords", null);
		encodeOptionComponentByType(options, commandLink.getHreflang(), "hreflang", null);
		encodeOptionComponentByType(options, commandLink.getName(), "name", null);
		encodeOptionComponentByType(options, commandLink.getRel(), "rel", null);
		encodeOptionComponentByType(options, commandLink.getRev(), "rev", null);
		encodeOptionComponentByType(options, commandLink.getShape(), "shape", null);
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