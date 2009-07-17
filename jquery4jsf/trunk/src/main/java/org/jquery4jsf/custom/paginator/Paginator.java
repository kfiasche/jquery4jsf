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

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;
import javax.faces.el.MethodBinding;

public class Paginator extends HtmlBaseOutputComponent implements JQueryHtmlObject {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.Paginator";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Paginator";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.PaginatorRenderer";

	private String[] resources;
	private String target;
	private Integer totalItems;
	private Integer itemsForPage;
	private Integer currentPage;
	private Integer numDispalyEntries;
	private String textNext;
	private String textPrevious;
	private MethodBinding pageChangeListener;

	public Paginator() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"form/jquery.form.js",
			"taconite/jquery.taconite.js",
			"pagination/jquery.pagination.js",
			"button/ui.button.js",
			"pagination/jquery.pagination.css",
			"themes/base/ui.all.css",
			"button/ui.button.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
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

	public int getTotalItems() {
		if(totalItems != null )
			return totalItems.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(totalItems, "totalItems");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = new Integer(totalItems);
	}

	public int getItemsForPage() {
		if(itemsForPage != null )
			return itemsForPage.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(itemsForPage, "itemsForPage");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setItemsForPage(int itemsForPage) {
		this.itemsForPage = new Integer(itemsForPage);
	}

	public int getCurrentPage() {
		if(currentPage != null )
			return currentPage.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(currentPage, "currentPage");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = new Integer(currentPage);
	}

	public int getNumDispalyEntries() {
		if(numDispalyEntries != null )
			return numDispalyEntries.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(numDispalyEntries, "numDispalyEntries");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setNumDispalyEntries(int numDispalyEntries) {
		this.numDispalyEntries = new Integer(numDispalyEntries);
	}

	public String getTextNext() {
		if(textNext != null )
			return textNext;

		String oValue = (String) getLocalOrValueBindingValue(textNext, "textNext");
		return oValue != null ? oValue : null;
	}
	public void setTextNext(String textNext) {
		this.textNext = textNext;
	}

	public String getTextPrevious() {
		if(textPrevious != null )
			return textPrevious;

		String oValue = (String) getLocalOrValueBindingValue(textPrevious, "textPrevious");
		return oValue != null ? oValue : null;
	}
	public void setTextPrevious(String textPrevious) {
		this.textPrevious = textPrevious;
	}

	public MethodBinding getPageChangeListener() {
		if(pageChangeListener != null )
			return pageChangeListener;

		MethodBinding oValue = (MethodBinding) getLocalOrValueBindingValue(pageChangeListener, "pageChangeListener");
		return oValue != null ? oValue : null;
	}
	public void setPageChangeListener(MethodBinding pageChangeListener) {
		this.pageChangeListener = pageChangeListener;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[9];
		values[0] = super.saveState(context);
		values[1] = this.target;
		values[2] = this.totalItems;
		values[3] = this.itemsForPage;
		values[4] = this.currentPage;
		values[5] = this.numDispalyEntries;
		values[6] = this.textNext;
		values[7] = this.textPrevious;
		values[8] = saveAttachedState(context, pageChangeListener);
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.target = (String) values[1];
		this.totalItems = (Integer) values[2];
		this.itemsForPage = (Integer) values[3];
		this.currentPage = (Integer) values[4];
		this.numDispalyEntries = (Integer) values[5];
		this.textNext = (String) values[6];
		this.textPrevious = (String) values[7];
		this.pageChangeListener = (MethodBinding) restoreAttachedState(context, values[8]);
	}

	public String[] getResources() {
		return resources;
	}

	public void broadcast(javax.faces.event.FacesEvent event) throws javax.faces.event.AbortProcessingException {
		super.broadcast(event);
		FacesContext context = FacesContext.getCurrentInstance();
		MethodBinding me = getPageChangeListener();
		if (me != null) {
			me.invoke(context, new Object[] {event});
		}
	}

	public void encodeScript(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof org.jquery4jsf.renderkit.JQueryRenderer) {
			((org.jquery4jsf.renderkit.JQueryRenderer)renderer).encodeScript(facesContext, this);
		}
	}
}