package org.jquery4jsf.custom.tabbedpanel;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.accordion.AccordionPanel;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class TabbedPanelRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.TabbedPanelRenderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	}

	public void encodeBegin(FacesContext context, UIComponent component)throws IOException {
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
	        createMenuTabs(responseWriter,tabbedPanel);
	}

	private void createMenuTabs(ResponseWriter responseWriter,TabbedPanel tabbedPanel) {
		
	}

	private String createOptionComponent(StringBuffer sbOption,TabbedPanel tabbedPanel, FacesContext context) {
		return null;
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
	}

	public boolean getRendersChildren() {
		return true;
	}
	
}
