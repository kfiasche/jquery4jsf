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
package org.jquery4jsf.event.paginator;

import javax.faces.component.UIComponent;
import javax.faces.event.FacesEvent;
import javax.faces.event.FacesListener;

import org.jquery4jsf.component.model.tree.TreeNode;

public class PageChangeEvent extends FacesEvent {

	private static final long serialVersionUID = 5758869696245912691L;
	
	private Integer pageChange;
	public PageChangeEvent(UIComponent source) {
		super(source);
	}
	public PageChangeEvent(UIComponent source, Integer pageChange) {
		super(source);
		this.pageChange = pageChange;
	}
	
	public boolean isAppropriateListener(FacesListener listener) {
		return (listener instanceof PageChangeListener);
	}

	public void processListener(FacesListener listener) {
		((PageChangeListener) listener).processPageChange(this);
	}

	public Integer getPageChange() {
		return pageChange;
	}

	public void setPageChange(Integer pageChange) {
		this.pageChange = pageChange;
	}


}
