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
package org.jquery4jsf.custom.bookmark;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public abstract class BookMarkBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, BookMark bookMark , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, bookMark.getUrl(), "url", null);
		encodeOptionComponentByType(options, bookMark.getTitle(), "title", null);
		encodeOptionComponentByType(options, bookMark.getSites(), "sites", null);
		encodeOptionComponentByType(options, bookMark.getIcons(), "icons", null);
		encodeOptionComponentByType(options, bookMark.getIconSize(), "iconSize", null);
		encodeOptionComponentByType(options, bookMark.getIconCols(), "iconCols", null);
		encodeOptionComponentByType(options, bookMark.getTarget(), "target", null);
		encodeOptionComponentByType(options, bookMark.isCompact(), "compact", null);
		encodeOptionComponentByType(options, bookMark.getHint(), "hint", null);
		encodeOptionComponentByType(options, bookMark.isPopup(), "popup", null);
		encodeOptionComponentByType(options, bookMark.getPopupText(), "popupText", null);
		encodeOptionComponentByType(options, bookMark.isAddFavorite(), "addFavorite", null);
		encodeOptionComponentByType(options, bookMark.getFavoriteText(), "favoriteText", null);
		encodeOptionComponentByType(options, bookMark.getFavoriteIcon(), "favoriteIcon", null);
		encodeOptionComponentByType(options, bookMark.isAddEmail(), "addEmail", null);
		encodeOptionComponentByType(options, bookMark.getEmailText(), "emailText", null);
		encodeOptionComponentByType(options, bookMark.getEmailIcon(), "emailIcon", null);
		encodeOptionComponentByType(options, bookMark.getEmailSubject(), "emailSubject", null);
		encodeOptionComponentByType(options, bookMark.getEmailBody(), "emailBody", null);
		encodeOptionComponentByType(options, bookMark.getManualBookmark(), "manualBookmark", null);
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