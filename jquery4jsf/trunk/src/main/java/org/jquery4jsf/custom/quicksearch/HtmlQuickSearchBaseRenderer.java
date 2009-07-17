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

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryInputBaseRenderer;
import javax.faces.context.FacesContext;

public abstract class HtmlQuickSearchBaseRenderer extends JQueryInputBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, HtmlQuickSearch htmlQuickSearch , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, htmlQuickSearch.getTarget(), "target", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getPosition(), "position", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getAttached(), "attached", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getFormId(), "formId", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getLabelText(), "labelText", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getLabelClass(), "labelClass", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getInputText(), "inputText", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getInputClass(), "inputClass", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getLoaderId(), "loaderId", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getLoaderClass(), "loaderClass", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getLoaderImg(), "loaderImg", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getLoaderText(), "loaderText", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getStripeRowClass(), "stripeRowClass", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getDelay(), "delay", null);
		encodeOptionComponentByType(options, htmlQuickSearch.isFocusOnLoad(), "focusOnLoad", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getHideElement(), "hideElement", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getOnBefore(), "onBefore", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getOnAfter(), "onAfter", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getFilter(), "filter", null);
		encodeOptionComponentByType(options, htmlQuickSearch.getRandomElement(), "randomElement", null);
		encodeOptionComponentByType(options, htmlQuickSearch.isIsFieldset(), "isFieldset", null);
		encodeOptionComponentByType(options, htmlQuickSearch.isFixWidths(), "fixWidths", null);
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