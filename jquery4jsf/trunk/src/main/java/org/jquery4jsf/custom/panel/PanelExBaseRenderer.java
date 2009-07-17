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
package org.jquery4jsf.custom.panel;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public abstract class PanelExBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, PanelEx panelEx , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, panelEx.isTrueVerticalText(), "trueVerticalText", null);
		encodeOptionComponentByType(options, panelEx.getCookie(), "cookie", null);
		encodeOptionComponentByType(options, panelEx.getAccordion(), "accordion", null);
		encodeOptionComponentByType(options, panelEx.getHeader(), "header", null);
		encodeOptionComponentByType(options, panelEx.getEvent(), "event", null);
		encodeOptionComponentByType(options, panelEx.isCollapsible(), "collapsible", "true");
		encodeOptionComponentByType(options, panelEx.getCollapseType(), "collapseType", null);
		encodeOptionComponentByType(options, panelEx.isCollapsed(), "collapsed", "false");
		encodeOptionComponentByType(options, panelEx.getCollapseSpeed(), "collapseSpeed", null);
		encodeOptionComponentByType(options, panelEx.isControls(), "controls", "false");
		encodeOptionComponentByType(options, panelEx.getWidgetClass(), "widgetClass", null);
		encodeOptionComponentByType(options, panelEx.getHeaderClass(), "headerClass", null);
		encodeOptionComponentByType(options, panelEx.getContentClass(), "contentClass", null);
		encodeOptionComponentByType(options, panelEx.getRightboxClass(), "rightboxClass", null);
		encodeOptionComponentByType(options, panelEx.getControlsClass(), "controlsClass", null);
		encodeOptionComponentByType(options, panelEx.getTitleClass(), "titleClass", null);
		encodeOptionComponentByType(options, panelEx.getTitleTextClass(), "titleTextClass", null);
		encodeOptionComponentByType(options, panelEx.getIconClass(), "iconClass", null);
		encodeOptionComponentByType(options, panelEx.getHoverClass(), "hoverClass", null);
		encodeOptionComponentByType(options, panelEx.getCollapsePnlClass(), "collapsePnlClass", null);
		encodeOptionComponentByType(options, panelEx.getHeaderIconClpsd(), "headerIconClpsd", null);
		encodeOptionComponentByType(options, panelEx.getHeaderIcon(), "headerIcon", null);
		encodeOptionComponentByType(options, panelEx.getSlideRIconClpsd(), "slideRIconClpsd", null);
		encodeOptionComponentByType(options, panelEx.getSlideRIcon(), "slideRIcon", null);
		encodeOptionComponentByType(options, panelEx.getSlideLIconClpsd(), "slideLIconClpsd", null);
		encodeOptionComponentByType(options, panelEx.getSlideLIcon(), "slideLIcon", null);
		encodeOptionComponentFunction(options, panelEx.getOnunfold(), "onunfold", "null");
		encodeOptionComponentFunction(options, panelEx.getOnfold(), "onfold", "null");
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