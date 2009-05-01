package org.jquery4jsf.custom.syntaxhighlighting;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class SyntaxHighlightingRenderer extends SyntaxHighlightingBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || component == null)
	            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        responseWriter.endElement(HTML.TAG_PRE);      
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || component == null)
	            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        SyntaxHighlighting syntax = null;
	        if(component instanceof SyntaxHighlighting)
	        	syntax = (SyntaxHighlighting)component;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        
	        // TODO devo trovare il modo per scrivere i script nell'head
	        String[] list = syntax.getResources();
	        for (int i = 0; i < list.length; i++) {
				String resource = list[i];
				ResourceContext.getInstance().addResource(resource);
			}
	        StringBuffer sb = new StringBuffer();
	        sb.append("\n");
	        sb.append("\t\tSyntaxHighlighter.config.clipboardSwf = 'scripts/clipboard.swf';\n");
	        sb.append("\t\tSyntaxHighlighter.all();\n");
	        sb.append("\n");
	        RendererUtilities.createTagScriptForJs(component, responseWriter,  sb);
	        responseWriter.startElement(HTML.TAG_PRE, syntax);
	        String styleClass = "brush: " + syntax.getType() +";";
	        responseWriter.writeAttribute("class", styleClass, null);
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		super.encodeChildren(context, component);
	}

	
}
