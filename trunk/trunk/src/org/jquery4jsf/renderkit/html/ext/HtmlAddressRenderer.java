package org.jquery4jsf.renderkit.html.ext;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.HtmlAddress;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer;

public class HtmlAddressRenderer extends HtmlBasicRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.HtmlAddressRenderer";

	
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlAddress htmlAddress = null;
        if (component instanceof HtmlAddress){
        	htmlAddress = (HtmlAddress)component;
        }
        if (!htmlAddress.isRendered())
        	return;
        
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement(HTML.TAG_ADDRESS, htmlAddress);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(writer, component, HTML.HTML_JS_STD_ATTR);

	}

	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
		super.encodeChildren(context, component);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlAddress htmlAddress = null;
        if (component instanceof HtmlAddress){
        	htmlAddress = (HtmlAddress)component;
        }
        if (!htmlAddress.isRendered())
        	return;
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement(HTML.TAG_ADDRESS);
	}
	

	public boolean getRendersChildren() {
		return false;
	}
	
}
