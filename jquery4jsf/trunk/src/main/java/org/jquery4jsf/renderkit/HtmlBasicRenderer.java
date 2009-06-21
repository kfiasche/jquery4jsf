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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.ConverterException;
import javax.faces.model.SelectItem;
import javax.faces.render.Renderer;

import org.jquery4jsf.utilities.TextUtilities;

public class HtmlBasicRenderer extends Renderer {

	protected String writeIdAttributeIfNecessary(FacesContext context,
			ResponseWriter responseWriter, UIComponent component) {
		return RendererUtilities.writeIdAttributeIfNecessary(context,
				responseWriter, component);
	}

	protected Object getValue(UIComponent component) {
		throw new UnsupportedOperationException();
	}

	protected void encodeRecursive(FacesContext context, UIComponent component)
			throws IOException {
		RendererUtilities.renderChildren(context, component);
	}

	protected Iterator getChildren(UIComponent component) {
		int childCount = component.getChildCount();
		if (childCount > 0) {
			return component.getChildren().iterator();
		} else
			return null;
	}

	protected UIComponent getFacet(UIComponent component, String name) {

		UIComponent facet = null;
		if (getFacetCount(component) > 0) {
			facet = component.getFacet(name);
			if (facet != null && !facet.isRendered()) {
				facet = null;
			}
		}
		return facet;
	}

	protected int getFacetCount(UIComponent component) {
		Map facets = component.getFacets();
		if (facets != null)
			return facets.size();
		return -1;
	}
	
	protected void encodeHiddenInput(FacesContext context, String id, String value) throws IOException {
		ResponseWriter writer = context.getResponseWriter();	
		writer.startElement("input", null);
		writer.writeAttribute("id", id, null);
		writer.writeAttribute("name", id, null);
		writer.writeAttribute("type", "hidden", null);
		if (!TextUtilities.isStringVuota(value))
			writer.writeAttribute("value", value, null);
		writer.endElement("input");
	}

	protected void encodeHiddenInput(FacesContext context, String id) throws IOException {
		encodeHiddenInput(context, id, null);
	}
	
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		return RendererUtilities.getConvertedValue(context, component, submittedValue);
	}
	
	protected ArrayList getSelectItems(UIComponent component)
	{
		ArrayList items = new ArrayList();

		int count = component.getChildCount();
		if (count == 0)
			return items;

		List children = component.getChildren();

		for (int i = 0; i < count; i++) {
			UIComponent child = (UIComponent) children.get(i);

			if (child instanceof UISelectItem) {
				UISelectItem uiSelectItem = (UISelectItem) child;

				SelectItem item = new SelectItem(uiSelectItem.getItemValue(),
						uiSelectItem.getItemLabel(),
						uiSelectItem.getItemDescription(),
						uiSelectItem.isItemDisabled());

				items.add(item);
			}
			else if (child instanceof UISelectItems) {
				UISelectItems selectItems = (UISelectItems) child;

				Object value = selectItems.getValue();

				if (value instanceof SelectItem)
					items.add((SelectItem) value);
				else if (value instanceof Collection) {
					Iterator iter = ((Collection) value).iterator();

					while (iter.hasNext()) {
						Object subValue = iter.next();

						if (subValue instanceof SelectItem)
							items.add((SelectItem) subValue);
					}
				}
				else if (value instanceof SelectItem[]) {
					SelectItem[] arraySelectItem = (SelectItem[])value;
					for (int j = 0; j < arraySelectItem.length; j++) {
						SelectItem selectItem = arraySelectItem[j];
						items.add(selectItem);
					}
				}
				else if (value instanceof Map) {
					Map map = (Map) value;

					Iterator iter = map.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next();

						items.add(new SelectItem(entry.getValue(),
								String.valueOf(entry.getKey())));
					}
				}
			}
		}
		return items;
	}

}
