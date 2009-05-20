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
package org.jquery4jsf.custom.tabbedpanel;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class TabbedPanelBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, TabbedPanel tabbedPanel , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, tabbedPanel.getAjaxOptions(), "ajaxOptions", null);
		encodeOptionComponentByType(options, tabbedPanel.isCache(), "cache", null);
		encodeOptionComponentByType(options, tabbedPanel.isCollapsible(), "collapsible", null);
		encodeOptionComponentByType(options, tabbedPanel.getCookie(), "cookie", null);
		encodeOptionComponentByType(options, tabbedPanel.isDeselectable(), "deselectable", null);
		encodeOptionComponentByType(options, tabbedPanel.getEvent(), "event", null);
		encodeOptionComponentByType(options, tabbedPanel.getFx(), "fx", null);
		encodeOptionComponentByType(options, tabbedPanel.getIdPrefix(), "idPrefix", null);
		encodeOptionComponentByType(options, tabbedPanel.getSelected(), "selected", null);
		encodeOptionComponentByType(options, tabbedPanel.getSpinner(), "spinner", null);
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