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
package org.jquery4jsf.custom.autocomplete;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryInputBaseRenderer;
import javax.faces.context.FacesContext;

public class AutoCompleteBaseRenderer extends JQueryInputBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, AutoComplete autoComplete , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, autoComplete.getJsonValue(), "jsonValue", null);
		encodeOptionComponentByType(options, autoComplete.getMinChars(), "minChars", "1");
		encodeOptionComponentByType(options, autoComplete.getDelay(), "delay", "400");
		encodeOptionComponentByType(options, autoComplete.getCacheLength(), "cacheLength", "10");
		encodeOptionComponentByType(options, autoComplete.isMatchSubset(), "matchSubset", "true");
		encodeOptionComponentByType(options, autoComplete.isMatchCase(), "matchCase", null);
		encodeOptionComponentByType(options, autoComplete.isMatchContains(), "matchContains", null);
		encodeOptionComponentByType(options, autoComplete.isMustMatch(), "mustMatch", null);
		encodeOptionComponentByType(options, autoComplete.isSelectFirst(), "selectFirst", "true");
		encodeOptionComponentByType(options, autoComplete.getExtraParams(), "extraParams", null);
		encodeOptionComponentByType(options, autoComplete.isMultiple(), "multiple", null);
		encodeOptionComponentByType(options, autoComplete.getMultipleSeparator(), "multipleSeparator", null);
		encodeOptionComponentByType(options, autoComplete.getWidth(), "width", null);
		encodeOptionComponentByType(options, autoComplete.isAutoFill(), "autoFill", null);
		encodeOptionComponentByType(options, autoComplete.getMax(), "max", "10");
		encodeOptionComponentByType(options, autoComplete.getHighlight(), "highlight", null);
		encodeOptionComponentByType(options, autoComplete.isScroll(), "scroll", "true");
		encodeOptionComponentByType(options, autoComplete.getScrollHeight(), "scrollHeight", "180");
		encodeOptionComponentByType(options, autoComplete.getOnformatItem(), "formatItem", null);
		encodeOptionComponentByType(options, autoComplete.getOnformatMatch(), "formatMatch", null);
		encodeOptionComponentByType(options, autoComplete.getOnformatResult(), "formatResult", null);
		encodeOptionComponentByType(options, autoComplete.getOncomplete(), "oncomplete", null);
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