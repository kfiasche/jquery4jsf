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
		encodeOptionComponentByType(options, draggable.isAddClasses(), "addClasses");
		encodeOptionComponentByType(options, draggable.getAppendTo(), "appendTo");
		encodeOptionComponentByType(options, draggable.getAxis(), "axis");
		encodeOptionComponentByType(options, draggable.getCancel(), "cancel");
		encodeOptionComponentByType(options, draggable.getConnectToSortable(), "connectToSortable");
		encodeOptionComponentByType(options, draggable.getContainment(), "containment");
		encodeOptionComponentByType(options, draggable.getCursor(), "cursor");
		encodeOptionComponentByType(options, draggable.getCursorAt(), "cursorAt");
		encodeOptionComponentByType(options, draggable.getDelay(), "delay");
		encodeOptionComponentByType(options, draggable.getDistance(), "distance");
		encodeOptionComponentByType(options, draggable.getGrid(), "grid");
		encodeOptionComponentByType(options, draggable.getHandle(), "handle");
		encodeOptionComponentByType(options, draggable.getHelper(), "helper");
		encodeOptionComponentByType(options, draggable.getIframeFix(), "iframeFix");
		encodeOptionComponentByType(options, draggable.getOpacity(), "opacity");
		encodeOptionComponentByType(options, draggable.isRefreshPositions(), "refreshPositions");
		encodeOptionComponentByType(options, draggable.getRevert(), "revert");
		encodeOptionComponentByType(options, draggable.getRevertDuration(), "revertDuration");
		encodeOptionComponentByType(options, draggable.getScope(), "scope");
		encodeOptionComponentByType(options, draggable.isScroll(), "scroll");
		encodeOptionComponentByType(options, draggable.getScrollSensitivity(), "scrollSensitivity");
		encodeOptionComponentByType(options, draggable.getScrollSpeed(), "scrollSpeed");
		encodeOptionComponentByType(options, draggable.getSnap(), "snap");
		encodeOptionComponentByType(options, draggable.getSnapMode(), "snapMode");
		encodeOptionComponentByType(options, draggable.getSnapTolerance(), "snapTolerance");
		encodeOptionComponentByType(options, draggable.getStack(), "stack");
		encodeOptionComponentByType(options, draggable.getZIndex(), "zIndex");
		encodeOptionComponentByType(options, draggable.getOndragstart(), "ondragstart");
		encodeOptionComponentByType(options, draggable.getOndrag(), "ondrag");
		encodeOptionComponentByType(options, draggable.getOndragstop(), "ondragstop");
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