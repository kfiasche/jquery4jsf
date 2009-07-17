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
package org.jquery4jsf.custom.dialog;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public abstract class DialogBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Dialog dialog , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, dialog.isAutoOpen(), "autoOpen", "true");
		encodeOptionComponentByType(options, dialog.isBgiframe(), "bgiframe", "false");
		encodeOptionComponentByType(options, dialog.getButtons(), "buttons", null);
		encodeOptionComponentByType(options, dialog.isCloseOnEscape(), "closeOnEscape", "true");
		encodeOptionComponentByType(options, dialog.getDialogClass(), "dialogClass", null);
		encodeOptionComponentByType(options, dialog.isDraggable(), "draggable", "true");
		encodeOptionComponentByType(options, dialog.getHeight(), "height", null);
		encodeOptionComponentByType(options, dialog.getHide(), "hide", null);
		encodeOptionComponentByType(options, dialog.getMaxHeight(), "maxHeight", null);
		encodeOptionComponentByType(options, dialog.getMaxWidth(), "maxWidth", null);
		encodeOptionComponentByType(options, dialog.getMinHeight(), "minHeight", "150");
		encodeOptionComponentByType(options, dialog.getMinWidth(), "minWidth", "150");
		encodeOptionComponentByType(options, dialog.isModal(), "modal", "false");
		encodeOptionComponentByType(options, dialog.getPosition(), "position", "center");
		encodeOptionComponentByType(options, dialog.isResizable(), "resizable", "true");
		encodeOptionComponentByType(options, dialog.getShow(), "show", null);
		encodeOptionComponentByType(options, dialog.isStack(), "stack", "true");
		encodeOptionComponentByType(options, dialog.getTitle(), "title", null);
		encodeOptionComponentByType(options, dialog.getWidth(), "width", "300");
		encodeOptionComponentByType(options, dialog.getZindex(), "zIndex", "1000");
		encodeOptionComponentByType(options, dialog.getOnbeforeclose(), "onbeforeclose", null);
		encodeOptionComponentByType(options, dialog.getOnopen(), "onopen", null);
		encodeOptionComponentByType(options, dialog.getOnfocus(), "onfocus", null);
		encodeOptionComponentByType(options, dialog.getOndragStart(), "ondragStart", null);
		encodeOptionComponentByType(options, dialog.getOndrag(), "ondrag", null);
		encodeOptionComponentByType(options, dialog.getOndragStop(), "ondragStop", null);
		encodeOptionComponentByType(options, dialog.getOnresizeStart(), "onresizeStart", null);
		encodeOptionComponentByType(options, dialog.getOnresize(), "onresize", null);
		encodeOptionComponentByType(options, dialog.getOnresizeStop(), "onresizeStop", null);
		encodeOptionComponentByType(options, dialog.getOnclose(), "onclose", null);
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