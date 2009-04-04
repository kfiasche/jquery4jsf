package org.jquery4jsf.renderkit.html.ext;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.link.HtmlLink;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer;

public class HtmlLinkRenderer extends HtmlBasicRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.HtmlLinkRenderer";

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlLink htmlLink = null;
        if (component instanceof HtmlLink){
        	htmlLink = (HtmlLink)component;
        }
        if (!htmlLink.isRendered())
        	return;
        
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement(HTML.TAG_A, htmlLink);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_JS_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_JS_ELEMENT_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_A_TAG_ATTR);
	}

	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
		super.encodeChildren(context, component);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlLink htmlLink = null;
        if (component instanceof HtmlLink){
        	htmlLink = (HtmlLink)component;
        }
        if (!htmlLink.isRendered())
        	return;
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement(HTML.TAG_A);
	}

	public boolean getRendersChildren() {
		return false;
	}
	
	
	
	
}
