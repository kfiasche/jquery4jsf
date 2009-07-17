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
package org.jquery4jsf.custom.paginator;

import java.io.IOException;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.event.paginator.PageChangeEvent;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.JQueryUtilities;
import org.jquery4jsf.utilities.MessageFactory;

public class PaginatorRenderer extends PaginatorBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Paginator paginator , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, paginator.getTotalItems(), "maxentries", null);
		encodeOptionComponentByType(options, paginator.getItemsForPage(), "items_per_page", null);
		encodeOptionComponentByType(options, paginator.getCurrentPage(), "current_page", null);
		encodeOptionComponentByType(options, paginator.getNumDispalyEntries(), "num_display_entries", null);
		encodeOptionComponentByType(options, paginator.getTextNext(), "next_text", null);
		encodeOptionComponentByType(options, paginator.getTextPrevious(), "prev_text", null);
		encodeOptionComponentFunction(options, "ajaxClickPage(page_index, jq);", "callback", "page_index, jq");
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

	public JSElement getJSElement(FacesContext context, UIComponent component) {
		Paginator paginator = null;
		if(component instanceof Paginator)
			paginator = (Paginator)component;
        JSElement element = new JSElement(paginator.getClientId(context));
        JSAttribute jsPaginator = new JSAttribute("pagination", false);
        String options = encodeOptionComponent(new StringBuffer(), paginator, context);
        jsPaginator.addValue(options);
        element.addAttribute(jsPaginator);
		return element;
	}
	
	private JSFunction getAjaxJSFunctionHandler(FacesContext context, Paginator paginator){
		UIForm form = RendererUtilities.getForm(context, paginator);
		if(form == null)
			throw new FacesException("Paginator:" + paginator.getClientId(context) + " needs to be enclosed in a form when using an pageChangeListener");
		
		JSElement formElement = new JSElement(form.getClientId(context));
        JSFunction callback = new JSFunction();
        callback.addParam("page_index");
        callback.addParam("jq");
        callback.setName("ajaxClickPage");
		JSAttribute jsForm = null;
		jsForm = new JSAttribute("ajaxSubmit", false);
        StringBuffer sbOption = new StringBuffer();
		jsForm.addValue(encodeOptionAjax(sbOption, paginator, context));
		formElement.addAttribute(jsForm);
		callback.addJSElement(formElement);
		return callback;
	}

	protected String encodeOptionAjax(StringBuffer options, Paginator paginator , FacesContext context) {
		options.append(" {\n");
		String target = paginator.getTarget();
		String clientId = paginator.getClientId(context);
		if (target == null || target.trim().length() == 0){
			target = null;
		}else{
			String[] updateIds = target.split(",");
			String targetNew = "";
			for (int i = 0; i < updateIds.length; i++) {
				String id = updateIds[i];
				if (i==0)
					targetNew = RendererUtilities.getClientIdForComponent(id, context, paginator);
				else
					targetNew = targetNew + "," + RendererUtilities.getClientIdForComponent(id, context, paginator);
			}
			target = targetNew;
		}

		String actionURL = RendererUtilities.getActionURL(context);
		if(actionURL.indexOf("?") == -1)
		{
			actionURL = actionURL + "?ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + target+"&hasChagePageListener=true";
		}
		else
		{
			actionURL = actionURL + "&ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + target+"&hasChagePageListener=true";
		}
		encodeOptionComponentByType(options, actionURL, "url", null);
		String targetJQ = null;
		if(target != null){
			targetJQ = RendererUtilities.getJQueryId(target);
		}
		else{
			UIForm form = RendererUtilities.getForm(context, paginator);
			targetJQ = RendererUtilities.getJQueryId(form.getClientId(context));
		}
		encodeOptionComponentByType(options,targetJQ, "target", null);
		if (JQueryUtilities.getInstance().isTacconiteEnabled()) encodeOptionComponentByType(options, "xml", "dataType", null);
		encodeOptionComponentByType(options, clientId , "buttonSubmit", "");
		encodeOptionComponentByType(options, "{page: page_index}" , "data", null);
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

	public void decode(FacesContext facesContext, UIComponent component) {
		Paginator paginator = (Paginator) component;
		String clientId = paginator.getClientId(facesContext);
		Map params = facesContext.getExternalContext().getRequestParameterMap(); 
		boolean isPageChange = params.containsKey(clientId);
		if(isPageChange) {
			String pageNumber = (String) params.get("page");
			if(pageNumber.equals(""))
			{
				paginator.queueEvent(new PageChangeEvent(component, null));
			}
			else
			{
				paginator.queueEvent(new PageChangeEvent(component, new Integer(pageNumber)));
			}
		}
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		Paginator paginator = null;
		if(component instanceof Paginator)
			paginator = (Paginator)component;
		
		encodeResources(paginator);
		encodePaginatorScript(context, paginator);
		encodePaginatorMarkup(context, paginator);
	}

	private void encodePaginatorMarkup(FacesContext context, Paginator paginator) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, paginator);
		responseWriter.writeAttribute("id", paginator.getClientId(context), "id");
		responseWriter.writeAttribute("class", "ui-pagination", null);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodePaginatorScript(FacesContext context, Paginator paginator) {
		JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, paginator));
        documentElement.addFunctionToReady(getAjaxJSFunctionHandler(context, paginator), true);
        documentElement.addFunctionToReady(function);
	}
}