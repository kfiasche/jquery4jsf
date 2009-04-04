package org.jquery4jsf.custom.accordion;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;

import com.sun.faces.util.Util;

public class AccordionSubPanelRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.AccordionSubPanelRenderer";

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        AccordionSubPanel accordionSubPanel = null;
        if (component instanceof AccordionSubPanel) {
			accordionSubPanel = (AccordionSubPanel) component;
		}
        if (accordionSubPanel.getPanelName() == null){
        	throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        }
        ResponseWriter responseWriter = context.getResponseWriter();
        //responseWriter.startElement(HTML.TAG_DIV, component);
        responseWriter.startElement(HTML.TAG_H3, component);
        responseWriter.startElement(HTML.TAG_A, component);
        responseWriter.writeAttribute(HTML.HREF, "#", null);
        responseWriter.writeText(accordionSubPanel.getPanelName(), "panelName");
        responseWriter.endElement(HTML.TAG_A);
        responseWriter.endElement(HTML.TAG_H3);
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        
		if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement(HTML.TAG_DIV, component);
        RendererUtilities.renderChildren(context,component);
        responseWriter.endElement(HTML.TAG_DIV);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        //ResponseWriter responseWriter = context.getResponseWriter();
        //responseWriter.endElement(HTML.TAG_DIV);
	}

	public boolean getRendersChildren() {
		return true;
	}	
}
