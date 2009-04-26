/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
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
package org.jquery4jsf.custom.button;

import javax.faces.context.FacesContext;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;

public class ButtonBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Button button , FacesContext context) {
		options.append(" {\n");
		//encodeOptionComponentByType(options, button.isPartialSubmit(), "partialSubmit", null);
		encodeOptionComponentByType(options, button.getTarget(), "target", null);
		if (button.getUrl() != null)
			encodeOptionComponentByType(options, button.getUrl(), "url", null);
		else{
			String actionURL = RendererUtilities.getActionURL(context);

			String clientId = button.getClientId(context);;
			
			String target = button.getTarget();
			if (target == null || target.trim().length() == 0){
				target = RendererUtilities.getFormId(context, button);
			}
			String reRenderedId = RendererUtilities.getClientIdForComponent(target, context, button);
			if(actionURL.indexOf("?") == -1)
			{
				actionURL = actionURL + "?ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + reRenderedId;
			}
			else
			{
				actionURL = actionURL + "&ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + reRenderedId ;
			}
		}
		encodeOptionComponentByType(options, button.getTypeSubmit(), "type", "post");
		encodeOptionComponentByType(options, button.getOnbeforeSubmit(), "beforeSubmit", null);
		encodeOptionComponentByType(options, button.getOnsuccess(), "success", null);
		encodeOptionComponentByType(options, button.getDataType(), "success", null);
		encodeOptionComponentByType(options, button.isSemantic(), "semantic", null);
		encodeOptionComponentByType(options, button.isResetForm(), "resetForm", null);
		encodeOptionComponentByType(options, button.isClearForm(), "clearForm", null);
		encodeOptionComponentByType(options, button.isIframe(), "iframe", null);
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