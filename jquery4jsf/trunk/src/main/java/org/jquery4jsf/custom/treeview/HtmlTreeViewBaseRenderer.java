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
package org.jquery4jsf.custom.treeview;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class HtmlTreeViewBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, HtmlTreeView htmlTreeView , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, htmlTreeView.isDataAsync(), "async", null);
		encodeOptionComponentFunction(options, htmlTreeView.getOnAsyncData(), "async_data", "node");
		encodeOptionComponentByType(options, htmlTreeView.getSelected(), "selected", null);
		encodeOptionComponentByType(options, htmlTreeView.getOpened(), "opened", null);
		encodeOptionComponentByType(options, htmlTreeView.getCookies(), "cookies", null);
		encodeOptionComponentByType(options, htmlTreeView.getLanguages(), "languages", null);
		encodeOptionComponentByType(options, htmlTreeView.getPath(), "path", null);
		encodeOptionComponentByType(options, htmlTreeView.getUidots(), "dots", null);
		encodeOptionComponentByType(options, htmlTreeView.getUirtl(), "rtl", null);
		encodeOptionComponentByType(options, htmlTreeView.getUianimation(), "animation", null);
		encodeOptionComponentByType(options, htmlTreeView.getUihovermode(), "hover_mode", null);
		encodeOptionComponentByType(options, htmlTreeView.getUiscrollspd(), "scroll_spd", null);
		encodeOptionComponentByType(options, htmlTreeView.getUithemepath(), "theme_path", null);
		encodeOptionComponentByType(options, htmlTreeView.getUithemename(), "theme_name", null);
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