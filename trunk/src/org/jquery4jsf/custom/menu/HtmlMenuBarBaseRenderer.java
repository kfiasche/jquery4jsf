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

public class HtmlMenuBarBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, HtmlMenuBar htmlMenuBar , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, htmlMenuBar.getLabel(), "label", null);
		encodeOptionComponentByType(options, htmlMenuBar.getWidth(), "width", null);
		encodeOptionComponentByType(options, htmlMenuBar.getMaxHeight(), "maxHeight", null);
		encodeOptionComponentByType(options, htmlMenuBar.getPositionOptsPosX(), "posX", null);
		encodeOptionComponentByType(options, htmlMenuBar.getPositionOptsPosY(), "posY", null);
		encodeOptionComponentByType(options, htmlMenuBar.getPositionOptsOffsetX(), "offsetX", null);
		encodeOptionComponentByType(options, htmlMenuBar.getPositionOptsOffsetY(), "offsetY", null);
		encodeOptionComponentByType(options, htmlMenuBar.getPositionOptsDirectionH(), "directionH", null);
		encodeOptionComponentByType(options, htmlMenuBar.getPositionOptsDirectionV(), "directionV", null);
		encodeOptionComponentByType(options, htmlMenuBar.isPositionOptsDetectH(), "detectH", null);
		encodeOptionComponentByType(options, htmlMenuBar.isPositionOptsDetectV(), "detectV", null);
		encodeOptionComponentByType(options, htmlMenuBar.isPositionOptsLinkToFront(), "linkToFront", null);
		encodeOptionComponentByType(options, htmlMenuBar.getShowSpeed(), "showSpeed", null);
		encodeOptionComponentByType(options, htmlMenuBar.getCallerOnStateClass(), "callerOnState", null);
		encodeOptionComponentByType(options, htmlMenuBar.getLoadingStateClass(), "loadingState", null);
		encodeOptionComponentByType(options, htmlMenuBar.getLinkHoverClass(), "linkHover", null);
		encodeOptionComponentByType(options, htmlMenuBar.getLinkHoverSecondaryClass(), "linkHoverSecondary", null);
		encodeOptionComponentByType(options, htmlMenuBar.getCrossSpeed(), "crossSpeed", null);
		encodeOptionComponentByType(options, htmlMenuBar.getCrumbDefaultText(), "crumbDefaultText", null);
		encodeOptionComponentByType(options, htmlMenuBar.isBackLink(), "backLink", null);
		encodeOptionComponentByType(options, htmlMenuBar.getBackLinkText(), "backLinkText", null);
		encodeOptionComponentByType(options, htmlMenuBar.isFlyOut(), "flyOut", null);
		encodeOptionComponentByType(options, htmlMenuBar.getFlyOutOnStateClass(), "flyOutOnState", null);
		encodeOptionComponentByType(options, htmlMenuBar.getNextMenuLinkClass(), "nextMenuLink", null);
		encodeOptionComponentByType(options, htmlMenuBar.getTopLinkText(), "topLinkText", null);
		encodeOptionComponentByType(options, htmlMenuBar.getNextCrumbLinkClass(), "nextCrumbLink", null);
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