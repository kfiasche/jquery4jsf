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
package org.jquery4jsf.custom.accordion;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class AccordionPanelBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, AccordionPanel accordionPanel , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, accordionPanel.getActive(), "active");
		encodeOptionComponentByType(options, accordionPanel.getAnimated(), "animated");
		encodeOptionComponentByType(options, accordionPanel.isAutoHeight(), "autoHeight");
		encodeOptionComponentByType(options, accordionPanel.isClearStyle(), "clearStyle");
		encodeOptionComponentByType(options, accordionPanel.isCollapsible(), "collapsible");
		encodeOptionComponentByType(options, accordionPanel.getEvent(), "event");
		encodeOptionComponentByType(options, accordionPanel.isFillSpace(), "fillSpace");
		encodeOptionComponentByType(options, accordionPanel.getIcons(), "icons");
		encodeOptionComponentByType(options, accordionPanel.isNavigation(), "navigation");
		encodeOptionComponentByType(options, accordionPanel.getHeader(), "header");
		encodeOptionComponentByType(options, accordionPanel.getNavigationFilter(), "navigationFilter");
		encodeOptionComponentByType(options, accordionPanel.getOnaccordionchange(), "onaccordionchange");
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