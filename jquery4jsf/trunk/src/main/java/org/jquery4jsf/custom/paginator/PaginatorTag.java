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
package org.jquery4jsf.custom.paginator;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class PaginatorTag extends UIComponentTagBase {

	private String target;
	private String totalItems;
	private String itemsForPage;
	private String currentPage;
	private String numDispalyEntries;
	private String textNext;
	private String textPrevious;
	private String pageChangeListener;

	public void release(){
		super.release();
		this.target = null;
		this.totalItems = null;
		this.itemsForPage = null;
		this.currentPage = null;
		this.numDispalyEntries = null;
		this.textNext = null;
		this.textPrevious = null;
		this.pageChangeListener = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.paginator.Paginator component = null;
		try {
			component = (org.jquery4jsf.custom.paginator.Paginator) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "target", target);
		setIntegerProperty(getFacesContext(), component, "totalItems", totalItems);
		setIntegerProperty(getFacesContext(), component, "itemsForPage", itemsForPage);
		setIntegerProperty(getFacesContext(), component, "currentPage", currentPage);
		setIntegerProperty(getFacesContext(), component, "numDispalyEntries", numDispalyEntries);
		setStringProperty(getFacesContext(), component, "textNext", textNext);
		setStringProperty(getFacesContext(), component, "textPrevious", textPrevious);
		setMethodBindingProperty(getFacesContext(), component, "pageChangeListener", pageChangeListener,new Class[]{org.jquery4jsf.event.paginator.PageChangeEvent.class} );
	}

	public String getComponentType() {
		return Paginator.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.PaginatorRenderer";
	}

	public void setTarget(String value){
		this.target = value;
	}

	public void setTotalItems(String value){
		this.totalItems = value;
	}

	public void setItemsForPage(String value){
		this.itemsForPage = value;
	}

	public void setCurrentPage(String value){
		this.currentPage = value;
	}

	public void setNumDispalyEntries(String value){
		this.numDispalyEntries = value;
	}

	public void setTextNext(String value){
		this.textNext = value;
	}

	public void setTextPrevious(String value){
		this.textPrevious = value;
	}

	public void setPageChangeListener(String value){
		this.pageChangeListener = value;
	}

}