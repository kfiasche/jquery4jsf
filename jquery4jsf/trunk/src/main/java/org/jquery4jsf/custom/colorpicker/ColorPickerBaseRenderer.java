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
package org.jquery4jsf.custom.colorpicker;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryInputBaseRenderer;
import javax.faces.context.FacesContext;

public abstract class ColorPickerBaseRenderer extends JQueryInputBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, ColorPicker colorPicker , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, colorPicker.getEventName(), "eventName", null);
		encodeOptionComponentByType(options, colorPicker.getTarget(), "target", null);
		encodeOptionComponentByType(options, colorPicker.getColor(), "color", null);
		encodeOptionComponentByType(options, colorPicker.isFlat(), "flat", null);
		encodeOptionComponentByType(options, colorPicker.isLivePreview(), "livePreview", null);
		encodeOptionComponentByType(options, colorPicker.getOnShow(), "onShow", null);
		encodeOptionComponentByType(options, colorPicker.getOnBeforeShow(), "onBeforeShow", null);
		encodeOptionComponentByType(options, colorPicker.getOnHide(), "onHide", null);
		encodeOptionComponentByType(options, colorPicker.getOnChange(), "onChange", null);
		encodeOptionComponentByType(options, colorPicker.getOnSubmit(), "onSubmit", null);
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