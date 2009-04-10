package org.jquery4jsf.custom.accordion;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class AccordionPanelRenderer extends JQueryBaseRenderer implements AjaxBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.AccordionPanelRenderer";

	public void encodePartially(FacesContext context, UIComponent component)throws IOException {
	}

	public String getActionURL(FacesContext context) throws IOException {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        AccordionPanel accordionPanel = null;
        if(component instanceof AccordionPanel)
        	accordionPanel = (AccordionPanel)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = accordionPanel.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(accordionPanel.getClientId(context));
        JSAttribute jsAutocomplete = new JSAttribute("accordion", false);
        StringBuffer sbOption = new StringBuffer();
        jsAutocomplete.addValue(createOptionComponent(sbOption, accordionPanel, context));
        element.addAttribute(jsAutocomplete);

        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb); 
        responseWriter.startElement(HTML.TAG_DIV, accordionPanel);
        writeIdAttributeIfNecessary(context, responseWriter, component);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_STD_ATTR);
        HtmlRendererUtilities.writeHtmlAttributes(responseWriter, component, HTML.HTML_JS_STD_ATTR);
	
	}

	private String createOptionComponent(StringBuffer options, AccordionPanel accordionPanel, FacesContext context) {
		options.append(" {\n");
		createOptionComponentByType(options,accordionPanel.getActive(), "active");
		createOptionComponentByType(options,accordionPanel.getAnimated(), "animated");
		createOptionComponentByType(options,accordionPanel.isAutoHeight(), "autoHeight");
		createOptionComponentByType(options,accordionPanel.isClearStyle(), "clearStyle");
		createOptionComponentByType(options,accordionPanel.isCollapsible(), "collapsible");
		createOptionComponentByType(options,accordionPanel.getEvent(), "event");
		createOptionComponentByType(options,accordionPanel.isFillSpace(), "fillSpace");
		createOptionComponentByType(options,accordionPanel.getHeader(), "header");
		createOptionComponentByType(options,accordionPanel.getHeader(), "header");
		createOptionComponentByType(options,accordionPanel.getIcons(), "icons");
		createOptionComponentByType(options,accordionPanel.isNavigation(), "navigation");
		createOptionComponentByType(options,accordionPanel.getNavigationFilter(), "navigationFilter");
		//TODO implementare il bind delle funzioni
		/*createOptionComponentByType(options,accordionPanel.getOnaccordionchange(), "accordionchange");*/
		if (options.toString().endsWith(", \n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (options.toString().endsWith(" {\n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
			noParams = true;
		}
		if (!noParams)
		{
			options.append(" }");
		}
		return options.toString();
	}

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		super.encodeChildren(context, component);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || context == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.endElement(HTML.TAG_DIV);
	}

	public boolean getRendersChildren() {
		return false;
	}

	
	
}
