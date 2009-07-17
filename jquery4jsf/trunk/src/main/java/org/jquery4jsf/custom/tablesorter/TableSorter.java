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
package org.jquery4jsf.custom.tablesorter;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;

public class TableSorter extends HtmlBaseOutputComponent implements JQueryHtmlObject {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTableSorter";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.TableSorter";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.TableSorterRenderer";

	private String[] resources;
	private Boolean themeroller;
	private String target;
	private String ascStyleClass;
	private String descStyleClass;
	private String headerStyleClass;
	private String sortedColumns;
	private String sortMultiSortKey;

	public TableSorter() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"tablesorter/jquery.tablesorter.js",
			"tablesorter/jquery.tablesorter-theme.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isThemeroller() {
		if(themeroller != null )
			return themeroller.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(themeroller, "themeroller");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setThemeroller(boolean themeroller) {
		this.themeroller = new Boolean(themeroller);
	}

	public String getTarget() {
		if(target != null )
			return target;

		String oValue = (String) getLocalOrValueBindingValue(target, "target");
		return oValue != null ? oValue : null;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public String getAscStyleClass() {
		if(ascStyleClass != null )
			return ascStyleClass;

		String oValue = (String) getLocalOrValueBindingValue(ascStyleClass, "ascStyleClass");
		return oValue != null ? oValue : null;
	}
	public void setAscStyleClass(String ascStyleClass) {
		this.ascStyleClass = ascStyleClass;
	}

	public String getDescStyleClass() {
		if(descStyleClass != null )
			return descStyleClass;

		String oValue = (String) getLocalOrValueBindingValue(descStyleClass, "descStyleClass");
		return oValue != null ? oValue : null;
	}
	public void setDescStyleClass(String descStyleClass) {
		this.descStyleClass = descStyleClass;
	}

	public String getHeaderStyleClass() {
		if(headerStyleClass != null )
			return headerStyleClass;

		String oValue = (String) getLocalOrValueBindingValue(headerStyleClass, "headerStyleClass");
		return oValue != null ? oValue : null;
	}
	public void setHeaderStyleClass(String headerStyleClass) {
		this.headerStyleClass = headerStyleClass;
	}

	public String getSortedColumns() {
		if(sortedColumns != null )
			return sortedColumns;

		String oValue = (String) getLocalOrValueBindingValue(sortedColumns, "sortedColumns");
		return oValue != null ? oValue : null;
	}
	public void setSortedColumns(String sortedColumns) {
		this.sortedColumns = sortedColumns;
	}

	public String getSortMultiSortKey() {
		if(sortMultiSortKey != null )
			return sortMultiSortKey;

		String oValue = (String) getLocalOrValueBindingValue(sortMultiSortKey, "sortMultiSortKey");
		return oValue != null ? oValue : null;
	}
	public void setSortMultiSortKey(String sortMultiSortKey) {
		this.sortMultiSortKey = sortMultiSortKey;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[8];
		values[0] = super.saveState(context);
		values[1] = this.themeroller;
		values[2] = this.target;
		values[3] = this.ascStyleClass;
		values[4] = this.descStyleClass;
		values[5] = this.headerStyleClass;
		values[6] = this.sortedColumns;
		values[7] = this.sortMultiSortKey;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.themeroller = (Boolean) values[1];
		this.target = (String) values[2];
		this.ascStyleClass = (String) values[3];
		this.descStyleClass = (String) values[4];
		this.headerStyleClass = (String) values[5];
		this.sortedColumns = (String) values[6];
		this.sortMultiSortKey = (String) values[7];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodeScript(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof org.jquery4jsf.renderkit.JQueryRenderer) {
			((org.jquery4jsf.renderkit.JQueryRenderer)renderer).encodeScript(facesContext, this);
		}
	}
}