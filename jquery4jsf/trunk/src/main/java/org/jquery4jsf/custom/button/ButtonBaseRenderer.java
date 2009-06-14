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
package org.jquery4jsf.custom.button;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class ButtonBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Button button , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, button.isAjaxSubmit(), "ajaxSubmit", null);
		encodeOptionComponentByType(options, button.getIcon(), "icon", null);
		encodeOptionComponentByType(options, button.isActive(), "active", null);
		encodeOptionComponentByType(options, button.isToggle(), "isToggle", null);
		encodeOptionComponentByType(options, button.getCheckButtonset(), "checkButtonset", null);
		encodeOptionComponentFunction(options, button.getOntoggle(), "ontoggle", "ui, event");
		encodeOptionComponentByType(options, button.getTarget(), "target", null);
		encodeOptionComponentByType(options, button.getUrl(), "url", null);
		encodeOptionComponentByType(options, button.isSemantic(), "semantic", null);
		encodeOptionComponentByType(options, button.isResetForm(), "resetForm", null);
		encodeOptionComponentByType(options, button.isClearForm(), "clearForm", null);
		encodeOptionComponentByType(options, button.isIframe(), "iframe", null);
		encodeOptionComponentByType(options, button.getOnbeforeSubmit(), "beforeSubmit", null);
		encodeOptionComponentByType(options, button.getOnsuccess(), "success", null);
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