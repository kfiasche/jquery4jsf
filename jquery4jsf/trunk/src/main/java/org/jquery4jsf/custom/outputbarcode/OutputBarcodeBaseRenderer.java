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
package org.jquery4jsf.custom.outputbarcode;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class OutputBarcodeBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, OutputBarcode outputBarcode , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, outputBarcode.getBarWidth(), "barWidth", "1");
		encodeOptionComponentByType(options, outputBarcode.getBarHeight(), "barHeight", "50");
		encodeOptionComponentByType(options, outputBarcode.isShowHRI(), "showHRI", "true");
		encodeOptionComponentByType(options, outputBarcode.getBgColor(), "bgColor", null);
		encodeOptionComponentByType(options, outputBarcode.getColor(), "color", null);
		encodeOptionComponentByType(options, outputBarcode.getFontSize(), "fontSize", null);
		encodeOptionComponentByType(options, outputBarcode.getType(), "type", null);
		encodeOptionComponentByType(options, outputBarcode.getValue(), "value", null);
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