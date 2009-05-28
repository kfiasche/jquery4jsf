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
package org.jquery4jsf.custom.outputbody;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class OutputBodyBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, OutputBody outputBody , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, outputBody.getOnclick(), "onclick", null);
		encodeOptionComponentByType(options, outputBody.getOndblclick(), "ondblclick", null);
		encodeOptionComponentByType(options, outputBody.getOnload(), "onload", null);
		encodeOptionComponentByType(options, outputBody.getOnmousedown(), "onmousedown", null);
		encodeOptionComponentByType(options, outputBody.getOnmousemove(), "onmousemove", null);
		encodeOptionComponentByType(options, outputBody.getOnmouseout(), "onmouseout", null);
		encodeOptionComponentByType(options, outputBody.getOnmouseover(), "onmouseover", null);
		encodeOptionComponentByType(options, outputBody.getOnmouseup(), "onmouseup", null);
		encodeOptionComponentByType(options, outputBody.getOnkeydown(), "onkeydown", null);
		encodeOptionComponentByType(options, outputBody.getOnkeypress(), "onkeypress", null);
		encodeOptionComponentByType(options, outputBody.getOnkeyup(), "onkeyup", null);
		encodeOptionComponentByType(options, outputBody.getOnunload(), "onunload", null);
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