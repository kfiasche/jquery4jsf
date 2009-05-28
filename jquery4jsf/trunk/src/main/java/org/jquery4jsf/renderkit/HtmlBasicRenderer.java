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
package org.jquery4jsf.renderkit;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class HtmlBasicRenderer extends Renderer {
	
	protected String writeIdAttributeIfNecessary(FacesContext context ,ResponseWriter responseWriter, UIComponent component) {
		return RendererUtilities.writeIdAttributeIfNecessary(context, responseWriter, component);
	}
	
	protected Object getValue(UIComponent component) {
		throw new UnsupportedOperationException();
	}
	
	protected void encodeRecursive(FacesContext context, UIComponent component) throws IOException {
		RendererUtilities.renderChildren(context, component);
	}
	
	protected Iterator getChildren(UIComponent component){
		 int childCount = component.getChildCount();
         if (childCount > 0) {
                 return component.getChildren().iterator();
         }
         else
        	 return null;
	}

	protected UIComponent getFacet(UIComponent component, String name) {

		UIComponent facet = null;
		if (component.getFacetCount() > 0) {
			facet = component.getFacet(name);
			if (facet != null && !facet.isRendered()) {
				facet = null;
			}
		}
		return facet;
	}

}
