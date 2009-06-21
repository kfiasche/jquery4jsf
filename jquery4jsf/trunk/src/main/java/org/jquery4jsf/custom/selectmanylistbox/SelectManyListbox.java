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
package org.jquery4jsf.custom.selectmanylistbox;

import org.jquery4jsf.component.ext.HtmlBaseSelectManyComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.custom.UIInteractions;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Object;
import javax.faces.convert.Converter;
import javax.faces.validator.Validator;
import javax.faces.event.ValueChangeListener;
import java.lang.Integer;

public class SelectManyListbox extends HtmlBaseSelectManyComponent implements JQueryHtmlObject,AjaxComponent,UIInteractions {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlSelectManyListbox";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.SelectManyListbox";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.SelectManyListboxRenderer";

	private String[] resources;
	private String _for;
	private Boolean sortable;
	private Boolean searchable;

	public SelectManyListbox() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"ui/ui.sortable.js",
			"ui/ui.draggable.js",
			"external/jquery.scrollTo.js",
			"multiselect/ui.multiselect.js",
			"multiselect/ui.multiselect.css",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getFor() {
		if( _for != null )
			return _for;

		String oValue = (String) getLocalOrValueBindingValue( _for, "for");
		return oValue != null ? oValue : null;
	}
	public void setFor(String _for) {
		this._for = _for;
	}

	public boolean isSortable() {
		if(sortable != null )
			return sortable.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(sortable, "sortable");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setSortable(boolean sortable) {
		this.sortable = new Boolean(sortable);
	}

	public boolean isSearchable() {
		if(searchable != null )
			return searchable.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(searchable, "searchable");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setSearchable(boolean searchable) {
		this.searchable = new Boolean(searchable);
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[4];
		values[0] = super.saveState(context);
		values[1] = _for;
		values[2] = sortable;
		values[3] = searchable;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.sortable = (Boolean) values[2];
		this.searchable = (Boolean) values[3];
	}

	public String[] getResources() {
		return resources;
	}

	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}