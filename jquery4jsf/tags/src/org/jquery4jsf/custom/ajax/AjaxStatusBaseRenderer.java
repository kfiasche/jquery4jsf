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
package org.jquery4jsf.custom.ajax;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class AjaxStatusBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, AjaxStatus ajaxStatus , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, ajaxStatus.getOnajaxStart(), "onajaxStart", null);
		encodeOptionComponentByType(options, ajaxStatus.getOnajaxSuccess(), "onajaxSuccess", null);
		encodeOptionComponentByType(options, ajaxStatus.getOnajaxError(), "onajaxError", null);
		encodeOptionComponentByType(options, ajaxStatus.getOnajaxComplete(), "onajaxComplete", null);
		encodeOptionComponentByType(options, ajaxStatus.getOnajaxStop(), "onajaxStop", null);
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