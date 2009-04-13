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

import com.sun.faces.util.Util;

public class TabbedPanelRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.TabbedPanelRenderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		  if(context == null || component == null)
	            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
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
	        JSAttribute jsAutocomplete = new JSAttribute("tabs", false);
	        StringBuffer sbOption = new StringBuffer();
	        jsAutocomplete.addValue(createOptionComponent(sbOption, tabbedPanel, context));
	        element.addAttribute(jsAutocomplete);

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
			if (tabPanel.isAjaxSupport()){
				responseWriter.writeAttribute(HTML.HREF, tabPanel.getAjaxSource(), null);
			}
			else{
				responseWriter.writeAttribute(HTML.HREF, "#"+tabPanel.getClientId(context), null);
			}
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
	
	private String createOptionComponent(StringBuffer options,TabbedPanel tabbedPanel, FacesContext context) {
		options.append(" {\n");
		
		//TODO implementare option
		createOptionComponentByType(options,tabbedPanel.getAjaxOptions(), "ajaxOptions");
		
		createOptionComponentByType(options,tabbedPanel.isCache(), "cache");
		createOptionComponentByType(options,tabbedPanel.isCollapsible(), "collapsible");
		createOptionComponentByType(options,tabbedPanel.getCookie(), "cookie");
		createOptionComponentByType(options,tabbedPanel.isDeselectable(), "deselectable");
		//TODO implementare la disabilitazione dei tabs
		createOptionComponentByType(options,"", "disabled");
		createOptionComponentByType(options,tabbedPanel.getEvent(), "event");
		//TODO implementare option
		createOptionComponentByType(options,tabbedPanel.getFx(), "fx");
		createOptionComponentByType(options,tabbedPanel.getIdPrefix(), "idPrefix");
		createOptionComponentByType(options,tabbedPanel.getSelected(), "selected");
		createOptionComponentByType(options,tabbedPanel.getSpinner(), "spinner");
		
		//TODO implementare il bind delle funzioni
		/*createOptionComponentByType(options,accordionPanel.getOnaccordionchange(), "accordionchange");*/
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
