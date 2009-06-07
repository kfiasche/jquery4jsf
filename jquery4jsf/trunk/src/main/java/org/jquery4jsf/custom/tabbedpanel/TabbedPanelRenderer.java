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
package org.jquery4jsf.custom.tabbedpanel;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class TabbedPanelRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.TabbedPanelRenderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		  if(context == null || component == null)
	            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        TabbedPanel tabbedPanel = null;
	        if(component instanceof TabbedPanel)
	        	tabbedPanel = (TabbedPanel)component;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        
	        // TODO devo trovare il modo per scrivere i script nell'head
	        String[] list = tabbedPanel.getResources();
	        for (int i = 0; i < list.length; i++) {
				String resource = list[i];
				ResourceContext.getInstance().addResource(resource);
			}
	        
	        StringBuffer sb = new StringBuffer();
	        sb.append("\n");
	        JSDocumentElement documentElement = new JSDocumentElement();
	        JSElement element = new JSElement(tabbedPanel.getClientId(context));
	        JSAttribute jsTabs = new JSAttribute("tabs", false);
	        StringBuffer sbOption = new StringBuffer();
	        jsTabs.addValue(encodeOptionComponent(sbOption, tabbedPanel, context));
	        element.addAttribute(jsTabs);

	        JSFunction function = new JSFunction();
	        function.addJSElement(element);
	        documentElement.addFunctionToReady(function);
	        sb.append(documentElement.toJavaScriptCode());
	        sb.append("\n");
	        RendererUtilities.createTagScriptForJs(component, responseWriter, sb); 
	        
	        responseWriter.startElement(HTML.TAG_DIV, tabbedPanel);
	        responseWriter.writeAttribute(HTML.ID, tabbedPanel.getClientId(context) ,"id");
	        encodeTabHeaders(responseWriter,tabbedPanel, context);
	        encodeTabContents(responseWriter,tabbedPanel, context);
	        responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeTabContents(ResponseWriter responseWriter,TabbedPanel tabbedPanel, FacesContext context) throws IOException{
		responseWriter.write("\n");
		for (Iterator iterator = tabbedPanel.getChildren().iterator(); iterator.hasNext();) {
			TabPanel tabPanel = (TabPanel) iterator.next();
	        responseWriter.startElement(HTML.TAG_DIV, null);
	        responseWriter.writeAttribute(HTML.ID, tabPanel.getClientId(context),null);
	        RendererUtilities.renderChildren(context, tabPanel);
	        responseWriter.endElement(HTML.TAG_DIV);
	        responseWriter.write("\n");
		}
	}
	
	private void encodeTabHeaders(ResponseWriter responseWriter,TabbedPanel tabbedPanel, FacesContext context) throws IOException {
		List children = tabbedPanel.getChildren();
		if (children == null || children.isEmpty() || !isChildHasTabs(children)){
			throw new IllegalArgumentException("Il tabulatore deve avere almeno un figlio di tipo Tab");
		}
		responseWriter.startElement(HTML.TAG_UL, null);
		responseWriter.write("\n");
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			TabPanel tabPanel = (TabPanel) iterator.next();
			responseWriter.startElement(HTML.TAG_LI, null);
			responseWriter.startElement(HTML.TAG_A, null);
			responseWriter.writeAttribute(HTML.HREF, "#"+tabPanel.getClientId(context), null);
			responseWriter.write(tabPanel.getTabName());
			responseWriter.endElement(HTML.TAG_A);
			responseWriter.endElement(HTML.TAG_LI);
			responseWriter.write("\n");
		}
		responseWriter.endElement(HTML.TAG_UL);
		responseWriter.write("\n");
	}

	private boolean isChildHasTabs(List children){
		boolean isChildTab = true;
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			if (child instanceof TabPanel) {
				isChildTab = true && isChildTab;
			}
			else{
				isChildTab = false;
			}
		}
		return isChildTab;
	}
	
	private String encodeOptionComponent(StringBuffer options,TabbedPanel tabbedPanel, FacesContext context) {
		options.append(" {\n");
		
		//TODO implementare option
		//encodeOptionComponentByType(options,tabbedPanel.getAjaxOptions(), "ajaxOptions", null);
		
		encodeOptionComponentByType(options,tabbedPanel.isCache(), "cache", null);
		encodeOptionComponentByType(options,tabbedPanel.isCollapsible(), "collapsible", null);
		encodeOptionComponentByType(options,tabbedPanel.getCookie(), "cookie", null);
		encodeOptionComponentByType(options,tabbedPanel.isDeselectable(), "deselectable", null);
		//TODO implementare la disabilitazione dei tabs
		encodeOptionComponentByType(options,null, "disabled", null);
		encodeOptionComponentByType(options,tabbedPanel.getEvent(), "event", null);
		//TODO implementare option
		encodeOptionComponentByType(options,tabbedPanel.getFx(), "fx", null);
		encodeOptionComponentByType(options,tabbedPanel.getIdPrefix(), "idPrefix", null);
		encodeOptionComponentByType(options,tabbedPanel.getSelected(), "selected", null);
		encodeOptionComponentByType(options,tabbedPanel.getSpinner(), "spinner", null);
		
		//TODO implementare il bind delle funzioni
		/*encodeOptionComponentByType(options,accordionPanel.getOnaccordionchange(), "accordionchange");*/
		if (options.toString().endsWith(", \n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (options.toString().endsWith(" {\n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
			noParams = true;
		}
		if (!noParams)
		{
			options.append(" }");
		}
		return options.toString();
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
	}

	public boolean getRendersChildren() {
		return true;
	}
	
}
