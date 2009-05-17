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
package org.jquery4jsf.custom.html;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class HtmlOutputLinkBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, HtmlOutputLink htmlOutputLink , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, htmlOutputLink.getStyle(), "style", null);
		encodeOptionComponentByType(options, htmlOutputLink.getStyleClass(), "styleClass", null);
		encodeOptionComponentByType(options, htmlOutputLink.getCharset(), "charset", null);
		encodeOptionComponentByType(options, htmlOutputLink.getCoords(), "coords", null);
		encodeOptionComponentByType(options, htmlOutputLink.getHreflang(), "hreflang", null);
		encodeOptionComponentByType(options, htmlOutputLink.getName(), "name", null);
		encodeOptionComponentByType(options, htmlOutputLink.getRel(), "rel", null);
		encodeOptionComponentByType(options, htmlOutputLink.getRev(), "rev", null);
		encodeOptionComponentByType(options, htmlOutputLink.getShape(), "shape", null);
		encodeOptionComponentByType(options, htmlOutputLink.getTarget(), "target", null);
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