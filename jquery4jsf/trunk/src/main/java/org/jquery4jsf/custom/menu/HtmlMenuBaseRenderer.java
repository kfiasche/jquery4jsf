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
package org.jquery4jsf.custom.menu;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class HtmlMenuBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, HtmlMenu htmlMenu , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, htmlMenu.getLabel(), "label", null);
		encodeOptionComponentByType(options, htmlMenu.getWidth(), "width", null);
		encodeOptionComponentByType(options, htmlMenu.getMaxHeight(), "maxHeight", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsPosX(), "posX", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsPosY(), "posY", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsOffsetX(), "offsetX", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsOffsetY(), "offsetY", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsDirectionH(), "directionH", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsDirectionV(), "directionV", null);
		encodeOptionComponentByType(options, htmlMenu.isPositionOptsDetectH(), "detectH", null);
		encodeOptionComponentByType(options, htmlMenu.isPositionOptsDetectV(), "detectV", null);
		encodeOptionComponentByType(options, htmlMenu.isPositionOptsLinkToFront(), "linkToFront", null);
		encodeOptionComponentByType(options, htmlMenu.getShowSpeed(), "showSpeed", null);
		encodeOptionComponentByType(options, htmlMenu.getCallerOnStateClass(), "callerOnState", null);
		encodeOptionComponentByType(options, htmlMenu.getLoadingStateClass(), "loadingState", null);
		encodeOptionComponentByType(options, htmlMenu.getLinkHoverClass(), "linkHover", null);
		encodeOptionComponentByType(options, htmlMenu.getLinkHoverSecondaryClass(), "linkHoverSecondary", null);
		encodeOptionComponentByType(options, htmlMenu.getCrossSpeed(), "crossSpeed", null);
		encodeOptionComponentByType(options, htmlMenu.getCrumbDefaultText(), "crumbDefaultText", null);
		encodeOptionComponentByType(options, htmlMenu.isBackLink(), "backLink", null);
		encodeOptionComponentByType(options, htmlMenu.getBackLinkText(), "backLinkText", null);
		encodeOptionComponentByType(options, htmlMenu.isFlyOut(), "flyOut", null);
		encodeOptionComponentByType(options, htmlMenu.getFlyOutOnStateClass(), "flyOutOnState", null);
		encodeOptionComponentByType(options, htmlMenu.getNextMenuLinkClass(), "nextMenuLink", null);
		encodeOptionComponentByType(options, htmlMenu.getTopLinkText(), "topLinkText", null);
		encodeOptionComponentByType(options, htmlMenu.getNextCrumbLinkClass(), "nextCrumbLink", null);
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