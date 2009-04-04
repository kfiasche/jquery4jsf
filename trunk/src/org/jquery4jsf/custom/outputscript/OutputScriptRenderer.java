package org.jquery4jsf.custom.outputscript;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;

import com.sun.faces.util.Util;

public class OutputScriptRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.OutputScriptRenderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || context == null)
	            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        
	        //responseWriter.write(HTML.TAG_CDATA_CLOSE);
	        responseWriter.endElement(HTML.TAG_SCRIPT);
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		 if(context == null || context == null)
	            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;

	        OutputScript outputScript = null;
	        if(component instanceof OutputScript)
	        	outputScript = (OutputScript)component;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        responseWriter.startElement(HTML.TAG_SCRIPT, outputScript);
	        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_SCRIPT_TAG_ATTR);
	       // responseWriter.write(HTML.TAG_CDATA_OPEN);
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		super.encodeChildren(context, component);
	}


}
