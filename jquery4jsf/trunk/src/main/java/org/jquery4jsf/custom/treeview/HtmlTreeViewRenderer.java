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
package org.jquery4jsf.custom.treeview;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.component.model.tree.TreeNode;
import org.jquery4jsf.component.tree.NodeCollapseEvent;
import org.jquery4jsf.component.tree.NodeExpandEvent;
import org.jquery4jsf.component.tree.NodeSelectEvent;
import org.jquery4jsf.component.tree.TreeNodeHandler;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;

public class HtmlTreeViewRenderer extends HtmlTreeViewBaseRenderer implements AjaxBaseRenderer{

	private static int SELECT = 0;
	private static int EXPAND = 1;
	private static int COLLAPSE = 2;
	
	public void encodePartially(FacesContext context, UIComponent component) throws IOException {
	}

	public String getActionURL(FacesContext context) {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		if(context == null || component == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		HtmlTreeView tree = null;
		if(component instanceof HtmlTreeView)
			tree = (HtmlTreeView)component;
		
		UIForm form = RendererUtilities.getForm(context, component);
		if (form == null){
			throw new FacesException("L'albero con l'id "+ tree.getId() +"deve essere incluso all'interno di una form.");
		}
		
        ResponseWriter responseWriter = context.getResponseWriter();
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = tree.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(tree.getClientId(context));
        JSAttribute jsTree = new JSAttribute("tree", false);
        StringBuffer sbOption = new StringBuffer();
        jsTree.addValue("{ui : { theme_name: \"default\", theme_path: \""+RendererUtilities.getResourceURL(context, "/treeview/themes/")+"\"}}");
        element.addAttribute(jsTree);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb); 
		responseWriter.startElement(HTML.TAG_UL, null);
		responseWriter.writeAttribute("id", tree.getClientId(context), "id");
		//responseWriter.writeAttribute("class", "tree tree-checkbox", null);
		

		
	}

	
	
	protected void encodeTreeNode(FacesContext facesContext, HtmlTreeView tree, TreeNode node, String rowKey) throws IOException {
		ResponseWriter responseWriter = facesContext.getResponseWriter();
		int rowIndex = 0;
		String clientTreeId = tree.getClientId(facesContext);
		if (node.isLeaf()) {
			responseWriter.write("\n");
			responseWriter.startElement(HTML.TAG_LI, null);
			responseWriter.writeAttribute("id", clientTreeId.concat("_").concat(rowKey), null);
			if (isClient(tree)){
				responseWriter.write("\n");
				if (isLocation(tree))
				{
					String type = node.getType();
					UIComponent component = tree.getFacet(type);
					RendererUtilities.renderChild(facesContext, component);
				}
				else{
					String type = node.getType();
					UIComponent component = tree.getFacet(type);
					RendererUtilities.renderChild(facesContext, component);
				}
				responseWriter.write("\n");
			}
			responseWriter.endElement(HTML.TAG_LI);
			responseWriter.write("\n");
		}
		if(isClient(tree) && !node.isLeaf()) {
			
			responseWriter.write("\n");
			responseWriter.startElement(HTML.TAG_LI, null);
			responseWriter.writeAttribute("id", clientTreeId.concat("_").concat(rowKey), null);
			responseWriter.write("\n");
			if (isLocation(tree))
			{
				String type = node.getType();
				UIComponent component = tree.getFacet(type);
				RendererUtilities.renderChild(facesContext, component);
			}
			else{
				String type = node.getType();
				UIComponent component = tree.getFacet(type);
				RendererUtilities.renderChild(facesContext, component);
			}

			responseWriter.write("\n");
			responseWriter.startElement(HTML.TAG_UL, null);
			for (Iterator iterator = node.getChildren().iterator(); iterator.hasNext();) {
				String childRowKey = rowKey + "." + rowIndex;
				TreeNode treeNode = (TreeNode) iterator.next();
				Map requestMap = facesContext.getExternalContext().getRequestMap();
	            String varAttribute = tree.getVar();
	            requestMap.put(varAttribute, treeNode);
				encodeTreeNode(facesContext, tree, treeNode, childRowKey);
				rowIndex ++;
			}
			responseWriter.endElement(HTML.TAG_UL);
			responseWriter.endElement(HTML.TAG_LI);
			responseWriter.write("\n");
			
		}	
		responseWriter.write("\n");
	}
	
	
	private boolean isLocation(HtmlTreeView tree) {
		String toggleMode = null;//tree.getPersist();
		if(toggleMode == null)
			return false;
		else
			return toggleMode.equalsIgnoreCase("location");
	}
	
	private boolean isClient(HtmlTreeView tree) {
		String toggleMode = null;//tree.getToogleType();
		if(toggleMode == null)
			return true;
		else
			return toggleMode.equalsIgnoreCase("client");
	}

	public void decode(FacesContext context, UIComponent component) {
		HtmlTreeView tree = (HtmlTreeView) component;
		String clientId = tree.getClientId(context);
		Map params = context.getExternalContext().getRequestParameterMap();
		
		if(params.containsKey(clientId)) {
			String rowKey = (String) params.get(clientId + "_rowKey");
			String event = (String) params.get(clientId + "_event");
			
			TreeNode root = (TreeNode) tree.getValue();
			TreeNode selected = new TreeNode("");
			int eventCode = TreeNodeHandler.valueOf(event);
			switch(eventCode) {
				case 0:
					selected.setSelected(true);
					tree.queueEvent(new NodeSelectEvent(tree, selected));
				break;
				
				case 1:
					selected.setExpanded(true);
					tree.queueEvent(new NodeExpandEvent(tree, selected));
				break;
					
				case 2:
					selected.setExpanded(false);
					tree.queueEvent(new NodeCollapseEvent(tree, selected));
				break;
			}
		}
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		if(context == null || component == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		HtmlTreeView tree = null;
		if(component instanceof HtmlTreeView)
			tree = (HtmlTreeView)component;
		
		UIForm form = RendererUtilities.getForm(context, component);
		if (form == null){
			throw new FacesException("L'albero con l'id "+ tree.getId() +"deve essere incluso all'interno di una form.");
		}
		
        TreeNode root = null;
		if(tree.getValue() instanceof TreeNode)
			root = (TreeNode)tree.getValue();
		else
			throw new FacesException("L'albero con l'id "+ tree.getId() +"deve avere come value un TreeNode.");
		
		int rowIndex = 0;

		for (Iterator iterator = root.getChildren().iterator(); iterator.hasNext();) {
			TreeNode treeNode = (TreeNode) iterator.next();	
			Map requestMap = context.getExternalContext().getRequestMap();
            String varAttribute = tree.getVar();
            requestMap.put(varAttribute, treeNode);
			encodeTreeNode(context, tree, treeNode, String.valueOf(rowIndex));
			rowIndex ++;
		}
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.endElement(HTML.TAG_UL);
	}

	public boolean getRendersChildren() {
		return true;
	}
}