package org.jquery4jsf.custom.draggable;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class DraggableRenderer extends DraggableBaseRenderer {

	public static final String RENDERER_TYPE = null;
	
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Draggable draggable = null;
        if(component instanceof Draggable)
            draggable = (Draggable)component;
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = draggable.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        String clientId = draggable.getClientId(context);
        if (draggable.getFor() != null){
        	clientId = RendererUtilities.getJQueryIdComponent(draggable.getFor(), context, draggable);
        }
        JSElement element = new JSElement(clientId);
        JSAttribute jsDraggable = new JSAttribute("draggable", false);
        StringBuffer sbOption = new StringBuffer();
        jsDraggable.addValue(encodeOptionComponent(sbOption, draggable, context));
        element.addAttribute(jsDraggable);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        if (draggable.getFor() == null){
        	responseWriter.startElement(HTML.TAG_DIV, draggable);
        	writeIdAttributeIfNecessary(context, responseWriter, component);
        	responseWriter.writeAttribute("class", "ui-widget-content" , null);
        }
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Draggable draggable = null;
        if(component instanceof Draggable)
            draggable = (Draggable)component;
        
        if (draggable.getFor() == null){
        	ResponseWriter responseWriter = context.getResponseWriter();
        	responseWriter.endElement(HTML.TAG_DIV);
        }
	}
	
}
