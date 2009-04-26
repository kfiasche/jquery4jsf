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
package org.jquery4jsf.custom.carousel;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class CarouselBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Carousel carousel , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, carousel.isVertical(), "vertical", "false");
		encodeOptionComponentByType(options, carousel.getSkin(), "skin", "tango");
		encodeOptionComponentByType(options, carousel.getSkinCss(), "skinCss", null);
		encodeOptionComponentByType(options, carousel.getSkinStyleClass(), "skinStyleClass", null);
		encodeOptionComponentByType(options, carousel.getStart(), "start", "1");
		encodeOptionComponentByType(options, carousel.getOffset(), "offset", "1");
		encodeOptionComponentByType(options, carousel.getSize(), "size", null);
		encodeOptionComponentByType(options, carousel.getScroll(), "scroll", "3");
		encodeOptionComponentByType(options, carousel.getVisible(), "visible", null);
		encodeOptionComponentByType(options, carousel.getAnimation(), "animation", "fast");
		encodeOptionComponentByType(options, carousel.getEasing(), "easing", null);
		encodeOptionComponentByType(options, carousel.getAuto(), "auto", "0");
		encodeOptionComponentByType(options, carousel.getWrap(), "wrap", null);
		encodeOptionComponentByType(options, carousel.getInitCallback(), "initCallback", null);
		encodeOptionComponentByType(options, carousel.getItemLoadCallbackBefore(), "itemLoadCallbackBefore", null);
		encodeOptionComponentByType(options, carousel.getItemLoadCallbackAfter(), "itemLoadCallbackAfter", null);
		encodeOptionComponentByType(options, carousel.getItemFirstInCallbackBefore(), "itemFirstInCallbackBefore", null);
		encodeOptionComponentByType(options, carousel.getItemFirstInCallbackAfter(), "itemFirstInCallbackAfter", null);
		encodeOptionComponentByType(options, carousel.getItemFirstOutCallbackBefore(), "itemFirstOutCallbackBefore", null);
		encodeOptionComponentByType(options, carousel.getItemFirstOutCallbackAfter(), "itemFirstOutCallbackAfter", null);
		encodeOptionComponentByType(options, carousel.getItemLastInCallbackBefore(), "itemLastInCallbackBefore", null);
		encodeOptionComponentByType(options, carousel.getItemLastInCallbackAfter(), "itemLastInCallbackAfter", null);
		encodeOptionComponentByType(options, carousel.getItemLastOutCallbackBefore(), "itemLastOutCallbackBefore", null);
		encodeOptionComponentByType(options, carousel.getItemLastOutCallbackAfter(), "itemLastOutCallbackAfter", null);
		encodeOptionComponentByType(options, carousel.getItemVisibleInCallbackBefore(), "itemVisibleInCallbackBefore", null);
		encodeOptionComponentByType(options, carousel.getItemVisibleInCallbackAfter(), "itemVisibleInCallbackAfter", null);
		encodeOptionComponentByType(options, carousel.getItemVisibleOutCallbackBefore(), "itemVisibleOutCallbackBefore", null);
		encodeOptionComponentByType(options, carousel.getItemVisibleOutCallbackAfter(), "itemVisibleOutCallbackAfter", null);
		encodeOptionComponentByType(options, carousel.getButtonNextCallback(), "buttonNextCallback", null);
		encodeOptionComponentByType(options, carousel.getButtonPrevCallback(), "buttonPrevCallback", null);
		encodeOptionComponentByType(options, carousel.getButtonNextEvent(), "buttonNextEvent", "click");
		encodeOptionComponentByType(options, carousel.getButtonPrevEvent(), "buttonPrevEvent", "click");
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