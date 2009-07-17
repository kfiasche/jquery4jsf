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
package org.jquery4jsf.custom.lightbox;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public abstract class LightBoxBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, LightBox lightBox , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, lightBox.getStyle(), "style", null);
		encodeOptionComponentByType(options, lightBox.getStyleClass(), "styleClass", null);
		encodeOptionComponentByType(options, lightBox.getActiveImage(), "activeImage", "0");
		encodeOptionComponentByType(options, lightBox.isFixedNavigation(), "fixedNavigation", null);
		encodeOptionComponentByType(options, lightBox.getOverlayBgColor(), "overlayBgColor", null);
		encodeOptionComponentByType(options, lightBox.getOverlayOpacity(), "overlayOpacity", null);
		encodeOptionComponentByType(options, lightBox.getImageLoading(), "imageLoading", null);
		encodeOptionComponentByType(options, lightBox.getImageBtnClose(), "imageBtnClose", null);
		encodeOptionComponentByType(options, lightBox.getImageBtnPrev(), "imageBtnPrev", null);
		encodeOptionComponentByType(options, lightBox.getImageBtnNext(), "imageBtnNext", null);
		encodeOptionComponentByType(options, lightBox.getContainerBorderSize(), "containerBorderSize", null);
		encodeOptionComponentByType(options, lightBox.getContainerResizeSpeed(), "containerResizeSpeed", null);
		encodeOptionComponentByType(options, lightBox.getTxtImage(), "txtImage", null);
		encodeOptionComponentByType(options, lightBox.getTxtOf(), "txtOf", null);
		encodeOptionComponentByType(options, lightBox.getImageBlank(), "imageBlank", null);
		encodeOptionComponentByType(options, lightBox.getKeyToClose(), "keyToClose", null);
		encodeOptionComponentByType(options, lightBox.getKeyToPrev(), "keyToPrev", null);
		encodeOptionComponentByType(options, lightBox.getKeyToNext(), "keyToNext", null);
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