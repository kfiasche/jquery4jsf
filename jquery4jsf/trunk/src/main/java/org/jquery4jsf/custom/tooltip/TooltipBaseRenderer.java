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
package org.jquery4jsf.custom.tooltip;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class TooltipBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Tooltip tooltip , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, tooltip.getOncomplete(), "oncomplete", null);
		encodeOptionComponentByType(options, tooltip.isPrerender(), "prerender", "false");
		encodeOptionComponentByType(options, tooltip.getUrl(), "url", null);
		encodeOptionComponentByType(options, tooltip.getText(), "text", null);
		encodeOptionComponentByType(options, tooltip.getTitleText(), "text", null);
		encodeOptionComponentByType(options, tooltip.getTitleButton(), "button", null);
		encodeOptionComponentByType(options, tooltip.getPositionTarget(), "target", null);
		encodeOptionComponentByType(options, tooltip.getPositionType(), "type", null);
		encodeOptionComponentByType(options, tooltip.getPositionContainer(), "container", null);
		encodeOptionComponentByType(options, tooltip.getCornerTarget(), "target", null);
		encodeOptionComponentByType(options, tooltip.getCornerTooltip(), "tooltip", null);
		encodeOptionComponentByType(options, tooltip.getAdjustX(), "x", null);
		encodeOptionComponentByType(options, tooltip.getAdjustY(), "y", null);
		encodeOptionComponentByType(options, tooltip.isAdjustMouse(), "mouse", null);
		encodeOptionComponentByType(options, tooltip.isAdjustScreen(), "screen", null);
		encodeOptionComponentByType(options, tooltip.isAdjustScroll(), "scroll", null);
		encodeOptionComponentByType(options, tooltip.getAdjustResize(), "resize", null);
		encodeOptionComponentByType(options, tooltip.getShowDelay(), "delay", null);
		encodeOptionComponentByType(options, tooltip.getShowSolo(), "solo", null);
		encodeOptionComponentByType(options, tooltip.getShowReady(), "ready", null);
		encodeOptionComponentByType(options, tooltip.getShowWhenTarget(), "target", null);
		encodeOptionComponentByType(options, tooltip.getShowWhenEvent(), "event", null);
		encodeOptionComponentByType(options, tooltip.getShowEffectLength(), "length", null);
		encodeOptionComponentByType(options, tooltip.getShowEffectType(), "type", null);
		encodeOptionComponentByType(options, tooltip.getHideDelay(), "delay", null);
		encodeOptionComponentByType(options, tooltip.isHideFixed(), "fixed", null);
		encodeOptionComponentByType(options, tooltip.getHideWhenTarget(), "target", null);
		encodeOptionComponentByType(options, tooltip.getHideWhenEvent(), "event", null);
		encodeOptionComponentByType(options, tooltip.getHideEffectLength(), "length", null);
		encodeOptionComponentByType(options, tooltip.getHideEffectType(), "type", null);
		encodeOptionComponentByType(options, tooltip.getStyleName(), "name", null);
		encodeOptionComponentByType(options, tooltip.getStyleWidthMin(), "min", null);
		encodeOptionComponentByType(options, tooltip.getStyleWidthMax(), "max", null);
		encodeOptionComponentByType(options, tooltip.getStyleBorderWidth(), "width", null);
		encodeOptionComponentByType(options, tooltip.getStyleBorderRadius(), "radius", null);
		encodeOptionComponentByType(options, tooltip.getStyleBorderColor(), "color", null);
		encodeOptionComponentByType(options, tooltip.getStyleTipColor(), "color", null);
		encodeOptionComponentByType(options, tooltip.getStyleTipCorner(), "corner", null);
		encodeOptionComponentByType(options, tooltip.getStyleTipSizeX(), "x", null);
		encodeOptionComponentByType(options, tooltip.getStyleTipSizeY(), "y", null);
		encodeOptionComponentByType(options, tooltip.getStyleTargetClass(), "target", null);
		encodeOptionComponentByType(options, tooltip.getStyleTooltipClass(), "tooltip", null);
		encodeOptionComponentByType(options, tooltip.getStyleTipClass(), "tip", null);
		encodeOptionComponentByType(options, tooltip.getStyleTitleClass(), "title", null);
		encodeOptionComponentByType(options, tooltip.getStyleContentClass(), "content", null);
		encodeOptionComponentByType(options, tooltip.getStyleActiveClass(), "active", null);
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