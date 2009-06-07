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
package org.jquery4jsf.component.model.tree;

import javax.faces.model.DataModel;

public class TreeDataModel extends DataModel {

	private Object wrappedData = null;	
	private int rowIndex = -1;
	
	public TreeDataModel() {}
	
	public TreeDataModel(TreeNode node) {
		this.wrappedData = node;
	}
	
	public int getRowCount() {
		return ((TreeNode) wrappedData).getChildCount();
	}

	public Object getRowData() {
		return ((TreeNode) wrappedData).getData();
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public Object getWrappedData() {
		return wrappedData;
	}

	public boolean isRowAvailable() {
		return false;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
		if (rowIndex > -1){
			TreeNode childNode = (TreeNode) ((TreeNode) wrappedData).getChildren().get(rowIndex);
			setWrappedData(childNode);
		}
	}

	public void setWrappedData(Object wrappedData) {
		this.wrappedData = wrappedData;
	}
	
}
