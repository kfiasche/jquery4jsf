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
package org.jquery4jsf.custom.draggable;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class DraggableBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Draggable draggable , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, draggable.isAddClasses(), "addClasses", "true");
		encodeOptionComponentByType(options, draggable.getAppendTo(), "appendTo", "parent");
		encodeOptionComponentByType(options, draggable.getAxis(), "axis", null);
		encodeOptionComponentByType(options, draggable.getCancel(), "cancel", null);
		encodeOptionComponentByType(options, draggable.getConnectToSortable(), "connectToSortable", null);
		encodeOptionComponentByType(options, draggable.getContainment(), "containment", null);
		encodeOptionComponentByType(options, draggable.getCursor(), "cursor", null);
		encodeOptionComponentByType(options, draggable.getCursorAt(), "cursorAt", "parent");
		encodeOptionComponentByType(options, draggable.getDelay(), "delay", "0");
		encodeOptionComponentByType(options, draggable.getDistance(), "distance", "1");
		encodeOptionComponentByType(options, draggable.getGrid(), "grid", null);
		encodeOptionComponentByType(options, draggable.getHandle(), "handle", null);
		encodeOptionComponentByType(options, draggable.getHelper(), "helper", null);
		encodeOptionComponentByType(options, draggable.getIframeFix(), "iframeFix", null);
		encodeOptionComponentByType(options, draggable.getOpacity(), "opacity", null);
		encodeOptionComponentByType(options, draggable.isRefreshPositions(), "refreshPositions", null);
		encodeOptionComponentByType(options, draggable.getRevert(), "revert", "parent");
		encodeOptionComponentByType(options, draggable.getRevertDuration(), "revertDuration", "500");
		encodeOptionComponentByType(options, draggable.getScope(), "scope", null);
		encodeOptionComponentByType(options, draggable.isScroll(), "scroll", "true");
		encodeOptionComponentByType(options, draggable.getScrollSensitivity(), "scrollSensitivity", "20");
		encodeOptionComponentByType(options, draggable.getScrollSpeed(), "scrollSpeed", "20");
		encodeOptionComponentByType(options, draggable.getSnap(), "snap", null);
		encodeOptionComponentByType(options, draggable.getSnapMode(), "snapMode", null);
		encodeOptionComponentByType(options, draggable.getSnapTolerance(), "snapTolerance", null);
		encodeOptionComponentByType(options, draggable.getStack(), "stack", null);
		encodeOptionComponentByType(options, draggable.getZIndex(), "zIndex", null);
		encodeOptionComponentByType(options, draggable.getOndragstart(), "ondragstart", null);
		encodeOptionComponentByType(options, draggable.getOndrag(), "ondrag", null);
		encodeOptionComponentByType(options, draggable.getOndragstop(), "ondragstop", null);
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