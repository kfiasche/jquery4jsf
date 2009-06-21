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
package org.jquery4jsf.custom.selectmanylistbox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.ListboxRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;

public class SelectManyListboxRenderer extends ListboxRenderer {
	
	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
	}

	public void encodeEnd(FacesContext context, UIComponent component)throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        SelectManyListbox selectManyListbox = null;
        if(component instanceof SelectManyListbox)
        	selectManyListbox = (SelectManyListbox)component;
        
        encodeResources(selectManyListbox);
        encodeAjaxEventChild(context, selectManyListbox);
        encodeScriptSelectManyListbox(context, selectManyListbox);
        encodeMarkupSelectManyListbox(context, selectManyListbox);
	}

	private void encodeScriptSelectManyListbox(FacesContext context, SelectManyListbox selectManyListbox) throws IOException {
        String clientId = RendererUtilities.encodeIdInteractions(selectManyListbox, context);
        ResponseWriter responseWriter = context.getResponseWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(clientId);
        JSAttribute jsMultiselect = new JSAttribute("multiselect", false);
        StringBuffer sbOption = new StringBuffer();
        jsMultiselect.addValue(encodeOptionComponent(sbOption, selectManyListbox, context));
        element.addAttribute(jsMultiselect);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.encodeImportJavascripScript(selectManyListbox, responseWriter, sb);
	}

	private void encodeMarkupSelectManyListbox(FacesContext context, SelectManyListbox selectManyListbox) throws IOException {	
		ResponseWriter responseWriter = context.getResponseWriter();
		if (selectManyListbox.getFor() != null)
			return;
		ArrayList selectItems = getSelectItems(selectManyListbox);
		if (selectItems != null && !selectItems.isEmpty()){
			responseWriter.startElement(HTML.TAG_SELECT, selectManyListbox);
			responseWriter.writeAttribute("id", selectManyListbox.getClientId(context), "clientId");
			responseWriter.writeAttribute("name", selectManyListbox.getClientId(context), "clientId");
			responseWriter.writeAttribute("multiple", "multiple", null);
			if (selectManyListbox.getSize() != null)
				responseWriter.writeAttribute("size", selectManyListbox.getSize().toString(), null);
			else
				responseWriter.writeAttribute("size", String.valueOf(selectManyListbox.getChildCount()), "size");
			HtmlRendererUtilities.writeHtmlAttributes(responseWriter, selectManyListbox, HTML.HTML_STD_ATTR);
			HtmlRendererUtilities.writeHtmlAttributes(responseWriter, selectManyListbox, HTML.HTML_JS_STD_ATTR);
			HtmlRendererUtilities.writeHtmlAttributes(responseWriter, selectManyListbox, HTML.HTML_JS_ELEMENT_ATTR);
			responseWriter.writeText("\n", null);
			for (Iterator iterator = selectItems.iterator(); iterator.hasNext();) {
				SelectItem selectItem = (SelectItem) iterator.next();
				encodeOptionSelectManyListBox(context, selectManyListbox, selectItem);
			}
			responseWriter.endElement(HTML.TAG_SELECT);
		}
	}

	public boolean getRendersChildren() {
		return true;
	}
	
	public void encodeOptionSelectManyListBox(FacesContext context, SelectManyListbox selectManyListbox, SelectItem selectItem) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
		List selected = null;
		Object v = selectManyListbox.getValue();
		if(v != null && v instanceof String[]) {
			selected = Arrays.asList((String[])v);
		} else {
			selected = new ArrayList();
		}
		responseWriter.writeText("\t", null);
		responseWriter.startElement("option", selectManyListbox);
		responseWriter.writeAttribute("value", selectItem.getValue(), "value");
		if(selected.contains(selectItem.getValue())) {
			responseWriter.writeAttribute("selected", "selected", "selected");
		}
		if(selectItem.isDisabled()){
			responseWriter.writeAttribute("disabled", "disabled", "disabled");
		}
		responseWriter.writeText(selectItem.getLabel(), "label");
		responseWriter.endElement("option");
		responseWriter.writeText("\n", null);
	}
	
	protected String encodeOptionComponent(StringBuffer options, SelectManyListbox selectManyListbox , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, selectManyListbox.isSortable(), "sortable", null);
		encodeOptionComponentByType(options, selectManyListbox.isSearchable(), "searchable", null);
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