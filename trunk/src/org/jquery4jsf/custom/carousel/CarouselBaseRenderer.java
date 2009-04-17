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
package org.jquery4jsf.custom.carousel;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class CarouselBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Carousel carousel , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, carousel.isVertical(), "vertical");
		encodeOptionComponentByType(options, carousel.getSkin(), "skin");
		encodeOptionComponentByType(options, carousel.getSkinCss(), "skinCss");
		encodeOptionComponentByType(options, carousel.getSkinStyleClass(), "skinStyleClass");
		encodeOptionComponentByType(options, carousel.getStart(), "start");
		encodeOptionComponentByType(options, carousel.getOffset(), "offset");
		encodeOptionComponentByType(options, carousel.getSize(), "size");
		encodeOptionComponentByType(options, carousel.getScroll(), "scroll");
		encodeOptionComponentByType(options, carousel.getVisible(), "visible");
		encodeOptionComponentByType(options, carousel.getAnimation(), "animation");
		encodeOptionComponentByType(options, carousel.getEasing(), "easing");
		encodeOptionComponentByType(options, carousel.getAuto(), "auto");
		encodeOptionComponentByType(options, carousel.getWrap(), "wrap");
		encodeOptionComponentByType(options, carousel.getInitCallback(), "initCallback");
		encodeOptionComponentByType(options, carousel.getItemLoadCallbackBefore(), "itemLoadCallbackBefore");
		encodeOptionComponentByType(options, carousel.getItemLoadCallbackAfter(), "itemLoadCallbackAfter");
		encodeOptionComponentByType(options, carousel.getItemFirstInCallbackBefore(), "itemFirstInCallbackBefore");
		encodeOptionComponentByType(options, carousel.getItemFirstInCallbackAfter(), "itemFirstInCallbackAfter");
		encodeOptionComponentByType(options, carousel.getItemFirstOutCallbackBefore(), "itemFirstOutCallbackBefore");
		encodeOptionComponentByType(options, carousel.getItemFirstOutCallbackAfter(), "itemFirstOutCallbackAfter");
		encodeOptionComponentByType(options, carousel.getItemLastInCallbackBefore(), "itemLastInCallbackBefore");
		encodeOptionComponentByType(options, carousel.getItemLastInCallbackAfter(), "itemLastInCallbackAfter");
		encodeOptionComponentByType(options, carousel.getItemLastOutCallbackBefore(), "itemLastOutCallbackBefore");
		encodeOptionComponentByType(options, carousel.getItemLastOutCallbackAfter(), "itemLastOutCallbackAfter");
		encodeOptionComponentByType(options, carousel.getItemVisibleInCallbackBefore(), "itemVisibleInCallbackBefore");
		encodeOptionComponentByType(options, carousel.getItemVisibleInCallbackAfter(), "itemVisibleInCallbackAfter");
		encodeOptionComponentByType(options, carousel.getItemVisibleOutCallbackBefore(), "itemVisibleOutCallbackBefore");
		encodeOptionComponentByType(options, carousel.getItemVisibleOutCallbackAfter(), "itemVisibleOutCallbackAfter");
		encodeOptionComponentByType(options, carousel.getButtonNextCallback(), "buttonNextCallback");
		encodeOptionComponentByType(options, carousel.getButtonPrevCallback(), "buttonPrevCallback");
		encodeOptionComponentByType(options, carousel.getButtonNextEvent(), "buttonNextEvent");
		encodeOptionComponentByType(options, carousel.getButtonPrevEvent(), "buttonPrevEvent");
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