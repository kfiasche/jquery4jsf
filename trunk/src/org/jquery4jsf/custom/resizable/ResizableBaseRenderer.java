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
package org.jquery4jsf.custom.resizable;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class ResizableBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Resizable resizable , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, resizable.getOnstart(), "onstart");
		encodeOptionComponentByType(options, resizable.getOnresize(), "onresize");
		encodeOptionComponentByType(options, resizable.getOnstop(), "onstop");
		encodeOptionComponentByType(options, resizable.getAlsoResize(), "alsoResize");
		encodeOptionComponentByType(options, resizable.getAnimateDuration(), "animateDuration");
		encodeOptionComponentByType(options, resizable.getAnimateEasing(), "animateEasing");
		encodeOptionComponentByType(options, resizable.getAspectRatio(), "aspectRatio");
		encodeOptionComponentByType(options, resizable.isAutoHide(), "autoHide");
		encodeOptionComponentByType(options, resizable.getCancel(), "cancel");
		encodeOptionComponentByType(options, resizable.getContainment(), "containment");
		encodeOptionComponentByType(options, resizable.getDelay(), "delay");
		encodeOptionComponentByType(options, resizable.getDistance(), "distance");
		encodeOptionComponentByType(options, resizable.isGhost(), "ghost");
		encodeOptionComponentByType(options, resizable.getGrid(), "grid");
		encodeOptionComponentByType(options, resizable.getHandles(), "handles");
		encodeOptionComponentByType(options, resizable.getHelper(), "helper");
		encodeOptionComponentByType(options, resizable.getMaxHeight(), "maxHeight");
		encodeOptionComponentByType(options, resizable.getMaxWidth(), "maxWidth");
		encodeOptionComponentByType(options, resizable.getMinWidth(), "minWidth");
		encodeOptionComponentByType(options, resizable.getMinHeight(), "minHeight");
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