/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
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
package org.jquery4jsf.custom.slider;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class SliderBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Slider slider , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, slider.isAnimate(), "animate", "false");
		encodeOptionComponentByType(options, slider.getMax(), "max", "100");
		encodeOptionComponentByType(options, slider.getMin(), "min", "0");
		encodeOptionComponentByType(options, slider.getOrientation(), "orientation", "auto");
		encodeOptionComponentByType(options, slider.getRange(), "range", null);
		encodeOptionComponentByType(options, slider.getStep(), "step", "1");
		encodeOptionComponentByType(options, slider.getSliderValue(), "value", "0");
		encodeOptionComponentByType(options, slider.getValues(), "values", null);
		encodeOptionComponentByType(options, slider.getOnstart(), "onstart", null);
		encodeOptionComponentByType(options, slider.getOnslide(), "onslide", null);
		encodeOptionComponentByType(options, slider.getOnchange(), "onchange", null);
		encodeOptionComponentByType(options, slider.getOnstop(), "onstop", null);
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