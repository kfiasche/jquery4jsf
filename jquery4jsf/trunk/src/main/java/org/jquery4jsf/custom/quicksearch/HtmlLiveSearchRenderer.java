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
import java.lang.String;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;

public class HtmlLiveSearchRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, HtmlLiveSearch htmlLiveSearch , FacesContext context) {
		options.append(" {\n");
		String targetJQ = null;
		String target = htmlLiveSearch.getTarget();
		if(target != null){
			targetJQ = RendererUtilities.getClientIdForComponent(target, context, htmlLiveSearch);
		}
		else{
			UIForm form = RendererUtilities.getForm(context, htmlLiveSearch);
			targetJQ = RendererUtilities.getJQueryId(form.getClientId(context));
		}
		encodeOptionComponentByType(options,targetJQ, "target", null);
		encodeOptionComponentByType(options, htmlLiveSearch.getFor(), "for", null);
		encodeOptionComponentByType(options, htmlLiveSearch.getType(), "type", null);
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
        HtmlLiveSearch liveSearch = null;
        if(component instanceof HtmlLiveSearch)
            liveSearch = (HtmlLiveSearch)component;
        String clientId = RendererUtilities.encodeClientIdInteractions(liveSearch, context);
		JSElement element = new JSElement(clientId);
		JSAttribute jsLiveSearch = new JSAttribute("searchfilter", false);
		StringBuffer sbOption = new StringBuffer();
		jsLiveSearch.addValue(encodeOptionComponent(sbOption, liveSearch, context));
		element.addAttribute(jsLiveSearch);
		return element;
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        HtmlLiveSearch liveSearch = null;
        if(component instanceof HtmlLiveSearch)
            liveSearch = (HtmlLiveSearch)component;
        
        encodeResources(liveSearch);
        encodeLiveSearchScript(context, liveSearch);
	}

	private void encodeLiveSearchScript(FacesContext context, HtmlLiveSearch liveSearch) {
		JSDocumentElement documentElement = JSDocumentElement.getInstance();
		JSFunction function = new JSFunction();
		function.addJSElement(getJSElement(context, liveSearch));
		documentElement.addFunctionToReady(function);
	}
}