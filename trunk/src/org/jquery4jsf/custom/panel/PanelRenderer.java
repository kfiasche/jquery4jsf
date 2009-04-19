package org.jquery4jsf.custom.panel;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class PanelRenderer extends JQueryBaseRenderer {

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		Panel panel = null;
		if(component instanceof Panel)
			panel = (Panel)component;
		
		// TODO devo trovare il modo per scrivere i script nell'head
		String[] list = panel.getResources();
		for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
		
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, panel);
		responseWriter.writeAttribute("id", panel.getClientId(context), "id");
		String styleClass = "ui-widget-content";
		if (panel.getStyleClass() != null){
			styleClass = styleClass.concat(" ").concat(panel.getStyleClass());
		}
		if (panel.getContentClass() != null){
			styleClass = styleClass.concat(" ").concat(panel.getContentClass());
		}
		responseWriter.writeAttribute("class", styleClass, null);
		if(panel.getStyle() != null)
			responseWriter.writeAttribute("style", panel.getStyle(), null);
		
		responseWriter.startElement(HTML.TAG_H3, panel);
		String styleClassHeader = "ui-widget-header";
		if (panel.getHeaderClass() != null){
			styleClassHeader = styleClassHeader.concat(" ").concat(panel.getHeaderClass());
		}
		responseWriter.writeAttribute("class", styleClassHeader, null);
		responseWriter.writeText(panel.getHeader(), "header");
		responseWriter.endElement(HTML.TAG_H3);
	}

	public void encodeEnd(FacesContext context,UIComponent component) throws IOException {
		if(context == null || context == null)
			throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.endElement(HTML.TAG_DIV);
	}
	
}
