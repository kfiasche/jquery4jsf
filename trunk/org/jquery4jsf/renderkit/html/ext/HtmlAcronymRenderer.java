package org.jquery4jsf.renderkit.html.ext;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.HtmlAcronym;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer;

public class HtmlAcronymRenderer extends HtmlBasicRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.HtmlAcronymRenderer";

	
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if ((context == null) || (component == null))
        {
            throw new NullPointerException();
        }
        HtmlAcronym htmlAcronym = null;
        if (component instanceof HtmlAcronym){
        	htmlAcronym = (HtmlAcronym)component;
        }
        if (!htmlAcronym.isRendered())
        	return;
        
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement(HTML.TAG_ACRONYM, htmlAcronym);
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
        HtmlAcronym htmlAcronym = null;
        if (component instanceof HtmlAcronym){
        	htmlAcronym = (HtmlAcronym)component;
        }
        if (!htmlAcronym.isRendered())
        	return;
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement(HTML.TAG_ACRONYM);
	}

	public boolean getRendersChildren() {
		return false;
	}
	
}
