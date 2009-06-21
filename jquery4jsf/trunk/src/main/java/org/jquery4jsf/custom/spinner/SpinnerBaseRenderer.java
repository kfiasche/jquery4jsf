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
package org.jquery4jsf.custom.spinner;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryInputBaseRenderer;
import javax.faces.context.FacesContext;

public class SpinnerBaseRenderer extends JQueryInputBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Spinner spinner , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, spinner.getSyncWith(), "syncWith", null);
		encodeOptionComponentByType(options, spinner.getStep(), "step", null);
		encodeOptionComponentByType(options, spinner.isCurrency(), "currency", null);
		encodeOptionComponentByType(options, spinner.getFormat(), "format", null);
		encodeOptionComponentByType(options, spinner.getGroupSeparator(), "groupSeparator", null);
		encodeOptionComponentByType(options, spinner.getHide(), "hide", null);
		encodeOptionComponentByType(options, spinner.isIncremental(), "incremental", "true");
		encodeOptionComponentByType(options, spinner.getMax(), "max", null);
		encodeOptionComponentByType(options, spinner.getMin(), "min", null);
		encodeOptionComponentByType(options, spinner.isMouseWheel(), "mouseWheel", "true");
		encodeOptionComponentByType(options, spinner.getPadLength(), "padLength", "0");
		encodeOptionComponentByType(options, spinner.getPage(), "page", null);
		encodeOptionComponentByType(options, spinner.getPrecision(), "precision", null);
		encodeOptionComponentByType(options, spinner.getRadix(), "radix", null);
		encodeOptionComponentByType(options, spinner.getRadixPoint(), "radixPoint", null);
		encodeOptionComponentByType(options, spinner.getReadOnly(), "readOnly", null);
		encodeOptionComponentByType(options, spinner.getSpinnerClass(), "spinnerClass", null);
		encodeOptionComponentByType(options, spinner.getWidth(), "width", null);
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