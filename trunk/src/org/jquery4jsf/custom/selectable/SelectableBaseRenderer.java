/*
 *
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
		encodeOptionComponentByType(options, selectable.isAutoRefresh(), "autoRefresh");
		encodeOptionComponentByType(options, selectable.getCancel(), "cancel");
		encodeOptionComponentByType(options, selectable.getDelay(), "delay");
		encodeOptionComponentByType(options, selectable.getDistance(), "distance");
		encodeOptionComponentByType(options, selectable.getFilter(), "filter");
		encodeOptionComponentByType(options, selectable.getTolerance(), "tolerance");
		encodeOptionComponentByType(options, selectable.getOnselected(), "onselected");
		encodeOptionComponentByType(options, selectable.getOnselecting(), "onselecting");
		encodeOptionComponentByType(options, selectable.getOnstart(), "onstart");
		encodeOptionComponentByType(options, selectable.getStop(), "stop");
		encodeOptionComponentByType(options, selectable.getOnunselected(), "onunselected");
		encodeOptionComponentByType(options, selectable.getOnunselecting(), "onunselecting");
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