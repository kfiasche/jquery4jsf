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
package org.jquery4jsf.custom.overlay;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public abstract class OverlayBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Overlay overlay , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, overlay.getMessage(), "message", null);
		encodeOptionComponentByType(options, overlay.getCssPadding(), "padding", null);
		encodeOptionComponentByType(options, overlay.getCssMargin(), "margin", null);
		encodeOptionComponentByType(options, overlay.getCssWidth(), "width", null);
		encodeOptionComponentByType(options, overlay.getCssTop(), "top", null);
		encodeOptionComponentByType(options, overlay.getCssLeft(), "left", null);
		encodeOptionComponentByType(options, overlay.getCssTextAlign(), "textAlign", null);
		encodeOptionComponentByType(options, overlay.getCssColor(), "color", null);
		encodeOptionComponentByType(options, overlay.getCssBorder(), "border", null);
		encodeOptionComponentByType(options, overlay.getCssBackgroundColor(), "backgroundColor", null);
		encodeOptionComponentByType(options, overlay.getCssCursor(), "cursor", null);
		encodeOptionComponentByType(options, overlay.getOverlayCSSBackgroundColor(), "backgroundColor", null);
		encodeOptionComponentByType(options, overlay.getOverlayCSSOpacity(), "opacity", null);
		encodeOptionComponentByType(options, overlay.getIframeSrc(), "iframeSrc", null);
		encodeOptionComponentByType(options, overlay.isForceIframe(), "forceIframe", null);
		encodeOptionComponentByType(options, overlay.getBaseZ(), "baseZ", null);
		encodeOptionComponentByType(options, overlay.isCenterX(), "centerX", "true");
		encodeOptionComponentByType(options, overlay.isCenterY(), "centerY", "true");
		encodeOptionComponentByType(options, overlay.isAllowBodyStretch(), "allowBodyStretch", "true");
		encodeOptionComponentByType(options, overlay.isBindEvents(), "bindEvents", "true");
		encodeOptionComponentByType(options, overlay.isConstrainTabKey(), "constrainTabKey", "true");
		encodeOptionComponentByType(options, overlay.getFadeIn(), "fadeIn", null);
		encodeOptionComponentByType(options, overlay.getFadeOut(), "fadeOut", null);
		encodeOptionComponentByType(options, overlay.getTimeout(), "timeout", null);
		encodeOptionComponentByType(options, overlay.isShowOverlay(), "showOverlay", "true");
		encodeOptionComponentByType(options, overlay.isFocusInput(), "focusInput", "true");
		encodeOptionComponentByType(options, overlay.isApplyPlatformOpacityRules(), "applyPlatformOpacityRules", "true");
		encodeOptionComponentFunction(options, overlay.getOnUnblock(), "ononUnblock", "element, options");
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