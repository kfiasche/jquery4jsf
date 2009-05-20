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
package org.jquery4jsf.custom.droppable;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class DroppableBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Droppable droppable , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, droppable.getAccept(), "accept", null);
		encodeOptionComponentByType(options, droppable.getActiveClass(), "activeClass", null);
		encodeOptionComponentByType(options, droppable.isAddClasses(), "addClasses", "true");
		encodeOptionComponentByType(options, droppable.isGreedy(), "greedy", "false");
		encodeOptionComponentByType(options, droppable.getHoverClass(), "hoverClass", null);
		encodeOptionComponentByType(options, droppable.getScope(), "scope", null);
		encodeOptionComponentByType(options, droppable.getTolerance(), "tolerance", null);
		encodeOptionComponentByType(options, droppable.getOndropactivate(), "ondropactivate", null);
		encodeOptionComponentByType(options, droppable.getOndropdeactivate(), "ondropdeactivate", null);
		encodeOptionComponentByType(options, droppable.getOndropover(), "ondropover", null);
		encodeOptionComponentByType(options, droppable.getOndropout(), "ondropout", null);
		encodeOptionComponentByType(options, droppable.getOndrop(), "ondrop", null);
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