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
package org.jquery4jsf.custom.overflow;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class OverflowBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Overflow overflow , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, overflow.getMessage(), "message", null);
		encodeOptionComponentByType(options, overflow.getCssPadding(), "padding", null);
		encodeOptionComponentByType(options, overflow.getCssMargin(), "margin", null);
		encodeOptionComponentByType(options, overflow.getCssWidth(), "width", null);
		encodeOptionComponentByType(options, overflow.getCssTop(), "top", null);
		encodeOptionComponentByType(options, overflow.getCssLeft(), "left", null);
		encodeOptionComponentByType(options, overflow.getCssTextAlign(), "textAlign", null);
		encodeOptionComponentByType(options, overflow.getCssColor(), "color", null);
		encodeOptionComponentByType(options, overflow.getCssBorder(), "border", null);
		encodeOptionComponentByType(options, overflow.getCssBackgroundColor(), "backgroundColor", null);
		encodeOptionComponentByType(options, overflow.getCssCursor(), "cursor", null);
		encodeOptionComponentByType(options, overflow.getOverlayCSSBackgroundColor(), "backgroundColor", null);
		encodeOptionComponentByType(options, overflow.getOverlayCSSOpacity(), "opacity", null);
		encodeOptionComponentByType(options, overflow.getIframeSrc(), "iframeSrc", null);
		encodeOptionComponentByType(options, overflow.isForceIframe(), "forceIframe", null);
		encodeOptionComponentByType(options, overflow.getBaseZ(), "baseZ", null);
		encodeOptionComponentByType(options, overflow.isCenterX(), "centerX", "true");
		encodeOptionComponentByType(options, overflow.isCenterY(), "centerY", "true");
		encodeOptionComponentByType(options, overflow.isAllowBodyStretch(), "allowBodyStretch", "true");
		encodeOptionComponentByType(options, overflow.isBindEvents(), "bindEvents", "true");
		encodeOptionComponentByType(options, overflow.isConstrainTabKey(), "constrainTabKey", "true");
		encodeOptionComponentByType(options, overflow.getFadeIn(), "fadeIn", null);
		encodeOptionComponentByType(options, overflow.getFadeOut(), "fadeOut", null);
		encodeOptionComponentByType(options, overflow.getTimeout(), "timeout", null);
		encodeOptionComponentByType(options, overflow.isShowOverlay(), "showOverlay", "true");
		encodeOptionComponentByType(options, overflow.isFocusInput(), "focusInput", "true");
		encodeOptionComponentByType(options, overflow.isApplyPlatformOpacityRules(), "applyPlatformOpacityRules", "true");
		encodeOptionComponentFunction(options, overflow.getOnUnblock(), "ononUnblock", "element, options");
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