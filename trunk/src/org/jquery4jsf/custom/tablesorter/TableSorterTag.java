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

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class TableSorterTag extends UIComponentTagBase {

	private String target;
	private String ascStyleClass;
	private String descStyleClass;
	private String headerStyleClass;
	private String sortedColumns;
	private String sortMultiSortKey;

	public void release(){
		super.release();
		this.target = null;
		this.ascStyleClass = null;
		this.descStyleClass = null;
		this.headerStyleClass = null;
		this.sortedColumns = null;
		this.sortMultiSortKey = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.tablesorter.TableSorter component = null;
		try {
			component = (org.jquery4jsf.custom.tablesorter.TableSorter) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "target", target);
		setStringProperty(getFacesContext(), component, "ascStyleClass", ascStyleClass);
		setStringProperty(getFacesContext(), component, "descStyleClass", descStyleClass);
		setStringProperty(getFacesContext(), component, "headerStyleClass", headerStyleClass);
		setStringProperty(getFacesContext(), component, "sortedColumns", sortedColumns);
		setStringProperty(getFacesContext(), component, "sortMultiSortKey", sortMultiSortKey);
	}

	public String getComponentType() {
		return TableSorter.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.TableSorterRenderer";
	}

	public void setTarget(String value){
		this.target = value;
	}

	public void setAscStyleClass(String value){
		this.ascStyleClass = value;
	}

	public void setDescStyleClass(String value){
		this.descStyleClass = value;
	}

	public void setHeaderStyleClass(String value){
		this.headerStyleClass = value;
	}

	public void setSortedColumns(String value){
		this.sortedColumns = value;
	}

	public void setSortMultiSortKey(String value){
		this.sortMultiSortKey = value;
	}

}