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
package org.jquery4jsf.custom.quicksearch;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class HtmlQuickSearchRenderer extends HtmlQuickSearchBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        HtmlQuickSearch quickSearch = null;
        if(component instanceof HtmlQuickSearch)
            quickSearch = (HtmlQuickSearch)component;
        
        encodeResources(quickSearch);
        encodeQuickSearchScript(context, quickSearch);
        encodeQuickSearchMarkup(context, quickSearch);
	}

	private void encodeQuickSearchMarkup(FacesContext context, HtmlQuickSearch quickSearch) {
	}

	private void encodeQuickSearchScript(FacesContext context, HtmlQuickSearch quickSearch) {
		JSDocumentElement documentElement = JSDocumentElement.getInstance();
		JSFunction function = new JSFunction();
		function.addJSElement(getJSElement(context, quickSearch));
		documentElement.addFunctionToReady(function);
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        HtmlQuickSearch quickSearch = null;
        if(component instanceof HtmlQuickSearch)
            quickSearch = (HtmlQuickSearch)component;
		String parentClientId = quickSearch.getParent().getClientId(context);
		String quickSearchClientId = null;
		if(quickSearch.getTarget() != null) {
			quickSearchClientId = RendererUtilities.getClientIdForComponent(quickSearch.getTarget(), context, quickSearch);
			if (quickSearchClientId == null){
				quickSearchClientId = quickSearch.getTarget();
			}
		} else {
			quickSearchClientId = parentClientId;
		}
		JSElement element = new JSElement(quickSearchClientId);
		JSAttribute jsResizable = new JSAttribute("quicksearch", false);
		StringBuffer sbOption = new StringBuffer();
		jsResizable.addValue(encodeOptionComponent(sbOption, quickSearch, context));
		element.addAttribute(jsResizable);
		return element;
	}

	
	
}