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

public class AlertDialogBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, AlertDialog alertDialog , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, alertDialog.isAutoOpen(), "autoOpen", "true");
		encodeOptionComponentByType(options, alertDialog.isBgiframe(), "bgiframe", "false");
		encodeOptionComponentByType(options, alertDialog.getOkLabel(), "okLabel", "Ok");
		encodeOptionComponentByType(options, alertDialog.getNoLabel(), "noLabel", "No");
		encodeOptionComponentByType(options, alertDialog.getOkAction(), "okAction", null);
		encodeOptionComponentByType(options, alertDialog.getNoAction(), "noAction", null);
		encodeOptionComponentByType(options, alertDialog.isCloseOnEscape(), "closeOnEscape", "true");
		encodeOptionComponentByType(options, alertDialog.getDialogClass(), "dialogClass", null);
		encodeOptionComponentByType(options, alertDialog.isDraggable(), "draggable", "true");
		encodeOptionComponentByType(options, alertDialog.getHeight(), "height", null);
		encodeOptionComponentByType(options, alertDialog.getHide(), "hide", null);
		encodeOptionComponentByType(options, alertDialog.getMaxHeight(), "maxHeight", null);
		encodeOptionComponentByType(options, alertDialog.getMaxWidth(), "maxWidth", null);
		encodeOptionComponentByType(options, alertDialog.getMinHeight(), "minHeight", "150");
		encodeOptionComponentByType(options, alertDialog.getMinWidth(), "minWidth", "150");
		encodeOptionComponentByType(options, alertDialog.isModal(), "modal", "false");
		encodeOptionComponentByType(options, alertDialog.getPosition(), "position", "center");
		encodeOptionComponentByType(options, alertDialog.isResizable(), "resizable", "true");
		encodeOptionComponentByType(options, alertDialog.getShow(), "show", null);
		encodeOptionComponentByType(options, alertDialog.isStack(), "stack", "true");
		encodeOptionComponentByType(options, alertDialog.getTitle(), "title", null);
		encodeOptionComponentByType(options, alertDialog.getWidth(), "width", "300");
		encodeOptionComponentByType(options, alertDialog.getZindex(), "zIndex", "1000");
		encodeOptionComponentByType(options, alertDialog.getOnbeforeclose(), "onbeforeclose", null);
		encodeOptionComponentByType(options, alertDialog.getOnopen(), "onopen", null);
		encodeOptionComponentByType(options, alertDialog.getOnfocus(), "onfocus", null);
		encodeOptionComponentByType(options, alertDialog.getOndragStart(), "ondragStart", null);
		encodeOptionComponentByType(options, alertDialog.getOndrag(), "ondrag", null);
		encodeOptionComponentByType(options, alertDialog.getOndragStop(), "ondragStop", null);
		encodeOptionComponentByType(options, alertDialog.getOnresizeStart(), "onresizeStart", null);
		encodeOptionComponentByType(options, alertDialog.getOnresize(), "onresize", null);
		encodeOptionComponentByType(options, alertDialog.getOnresizeStop(), "onresizeStop", null);
		encodeOptionComponentByType(options, alertDialog.getOnclose(), "onclose", null);
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