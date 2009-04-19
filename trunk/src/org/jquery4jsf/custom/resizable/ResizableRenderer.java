package org.jquery4jsf.custom.resizable;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class ResizableRenderer extends ResizableBaseRenderer {

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Resizable resizable = null;
        if(component instanceof Resizable)
            resizable = (Resizable)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = resizable.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
		String parentClientId = resizable.getParent().getClientId(context);
		String resizableComponentClientId = null;
		
		if(resizable.getFor() != null) {
			resizableComponentClientId = RendererUtilities.getClientIdForComponent(resizable.getFor(), context, resizable);
		} else {
			resizableComponentClientId = parentClientId;
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(resizableComponentClientId);
        JSAttribute jsResizable = new JSAttribute("resizable", false);
        StringBuffer sbOption = new StringBuffer();
        jsResizable.addValue(encodeOptionComponent(sbOption, resizable, context));
        element.addAttribute(jsResizable);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
	}
}
