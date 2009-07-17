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
package org.jquery4jsf.custom.selectmenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;

import org.jquery4jsf.custom.selectmanylistbox.SelectManyListbox;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;

public class SelectMenuRenderer extends SelectMenuBaseRenderer {

	public JSElement getJSElement(FacesContext context, UIComponent component) {
		SelectMenu selectMenu = null;
        if(component instanceof SelectMenu)
        	selectMenu = (SelectMenu)component;
		String clientId = RendererUtilities.encodeClientIdInteractions(selectMenu, context);
        JSElement element = new JSElement(clientId);
        JSAttribute jsSelectMenu = new JSAttribute("selectmenu", false);
        StringBuffer sbOption = new StringBuffer();
        jsSelectMenu.addValue(encodeOptionComponent(sbOption, selectMenu, context));
        element.addAttribute(jsSelectMenu);
		return element;
	}

	public void encodeChildren(FacesContext arg0, UIComponent arg1)throws IOException {
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        SelectMenu selectMenu = null;
        if(component instanceof SelectMenu)
        	selectMenu = (SelectMenu)component;
        
        encodeResources(selectMenu);
        encodeAjaxEventChild(context, selectMenu);
        encodeSelectMenuScript(context, selectMenu);
        encodeSelectMenuMarkup(context, selectMenu);
        
	}

	private void encodeSelectMenuMarkup(FacesContext context, SelectMenu selectMenu) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		if (selectMenu.getFor() != null)
			return;
		ArrayList selectItems = getSelectItems(selectMenu);
		if (selectItems != null && !selectItems.isEmpty()){
			responseWriter.startElement(HTML.TAG_SELECT, selectMenu);
			responseWriter.writeAttribute("id", selectMenu.getClientId(context), "clientId");
			responseWriter.writeAttribute("name", selectMenu.getClientId(context), "clientId");
			if (selectMenu.getSize() != null)
				responseWriter.writeAttribute("size", selectMenu.getSize().toString(), null);
			else
				responseWriter.writeAttribute("size", String.valueOf(selectMenu.getChildCount()), "size");
			HtmlRendererUtilities.writeHtmlAttributes(responseWriter, selectMenu, HTML.HTML_STD_ATTR);
			HtmlRendererUtilities.writeHtmlAttributes(responseWriter, selectMenu, HTML.HTML_JS_STD_ATTR);
			HtmlRendererUtilities.writeHtmlAttributes(responseWriter, selectMenu, HTML.HTML_JS_ELEMENT_ATTR);
			responseWriter.writeText("\n", null);
			for (Iterator iterator = selectItems.iterator(); iterator.hasNext();) {
				SelectItem selectItem = (SelectItem) iterator.next();
				encodeOptionSelectOneListBox(context, selectMenu, selectItem);
			}
			responseWriter.endElement(HTML.TAG_SELECT);
		}
	}

	public void encodeOptionSelectOneListBox(FacesContext context, SelectMenu selectMenu, SelectItem selectItem) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
		List selected = null;
		Object v = selectMenu.getValue();
		if(v != null && v instanceof String[]) {
			selected = Arrays.asList((String[])v);
		} else {
			selected = new ArrayList();
		}
		responseWriter.writeText("\t", null);
		responseWriter.startElement("option", selectMenu);
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
	
	private void encodeSelectMenuScript(FacesContext context, SelectMenu selectMenu) {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, selectMenu));
        documentElement.addFunctionToReady(function);
	}

	public boolean getRendersChildren() {
		return true;
	}
	
	

}