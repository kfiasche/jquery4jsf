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
package org.jquery4jsf.custom.selectable;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class SelectableBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Selectable selectable , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, selectable.isAutoRefresh(), "autoRefresh", "true");
		encodeOptionComponentByType(options, selectable.getCancel(), "cancel", null);
		encodeOptionComponentByType(options, selectable.getDelay(), "delay", null);
		encodeOptionComponentByType(options, selectable.getDistance(), "distance", null);
		encodeOptionComponentByType(options, selectable.getFilter(), "filter", null);
		encodeOptionComponentByType(options, selectable.getTolerance(), "tolerance", null);
		encodeOptionComponentByType(options, selectable.getOnselected(), "onselected", null);
		encodeOptionComponentByType(options, selectable.getOnselecting(), "onselecting", null);
		encodeOptionComponentByType(options, selectable.getOnstart(), "onstart", null);
		encodeOptionComponentByType(options, selectable.getStop(), "stop", null);
		encodeOptionComponentByType(options, selectable.getOnunselected(), "onunselected", null);
		encodeOptionComponentByType(options, selectable.getOnunselecting(), "onunselecting", null);
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