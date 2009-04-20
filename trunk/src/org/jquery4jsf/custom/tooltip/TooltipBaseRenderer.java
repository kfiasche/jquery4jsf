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
package org.jquery4jsf.custom.tooltip;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class TooltipBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Tooltip tooltip , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, tooltip.getDelay(), "delay");
		encodeOptionComponentByType(options, tooltip.getTrack(), "track");
		encodeOptionComponentByType(options, tooltip.getShowURL(), "showURL");
		encodeOptionComponentByType(options, tooltip.getShowBody(), "showBody");
		encodeOptionComponentByType(options, tooltip.getOnbodyHandler(), "onbodyHandler");
		encodeOptionComponentByType(options, tooltip.getExtraClass(), "extraClass");
		encodeOptionComponentByType(options, tooltip.getTop(), "top");
		encodeOptionComponentByType(options, tooltip.getFixPNG(), "fixPNG");
		encodeOptionComponentByType(options, tooltip.getLeft(), "left");
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