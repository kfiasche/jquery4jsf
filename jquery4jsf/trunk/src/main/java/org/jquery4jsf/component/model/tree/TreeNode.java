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

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	private String nodeId;
	private String type;
	private Object data;
	private List children;
	private TreeNode parent;
	private boolean expanded;
	private boolean selected;

	public TreeNode(Object data) {
		this.data = data;
		children = new ArrayList();
	}
	
	public TreeNode(String type, Object data) {
		this.type = type;
		this.data = data;
		children = new ArrayList();
	}
	
	public TreeNode(String id, String type, Object data) {
		this.type = type;
		this.data = data;
		this.nodeId = id;
		children = new ArrayList();
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public List getChildren() {
		return children;
	}
	
	public void setChildren(List children) {
		this.children = children;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public void addChild(TreeNode treeNode) {
		treeNode.setParent(this);
		children.add(treeNode);
	}

	public int getChildCount() {
		return children.size();
	}
	
	public boolean isLeaf() {
		if(children == null)
			return true;
		
		return children.size() == 0;
	}

	public String toString() {
		if(data != null)
			return data.toString();
		else
			return super.toString();
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}	
}
