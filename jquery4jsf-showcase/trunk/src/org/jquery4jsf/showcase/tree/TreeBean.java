package org.jquery4jsf.showcase.tree;

import org.jquery4jsf.component.model.tree.TreeNode;


public class TreeBean {
	
	private TreeNode root;
	
	public TreeBean() {
		root = new TreeNode("Root");
		TreeNode node0 = new TreeNode("firstbranch","Node 0");
		TreeNode node1 = new TreeNode("firstbranch","Node 1");
		TreeNode node2 = new TreeNode("firstbranch","Node 2");
		
		TreeNode node00 = new TreeNode("others","Node 0.0");
		node00.setType("others");
		TreeNode node01 = new TreeNode("others","Node 0.1");
		node01.setType("others");
		
		TreeNode node10 = new TreeNode("others","Node 1.0");
		TreeNode node11 = new TreeNode("others","Node 1.1");
		
		node00.addChild(new TreeNode("others","Node 0.0.0"));
		node00.addChild(new TreeNode("others","Node 0.0.1"));
		node01.addChild(new TreeNode("others","Node 0.1.0"));
		
		node10.addChild(new TreeNode("others","Node 1.0.0"));
		
		node0.addChild(node00);
		node0.addChild(node01);
		
		node1.addChild(node10);
		node1.addChild(node11);
		
		root.addChild(node0);
		root.addChild(node1);
		root.addChild(node2);
	}

	public TreeNode getModel() {
		return root;
	}
}
