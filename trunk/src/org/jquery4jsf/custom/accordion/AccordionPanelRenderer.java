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
			if (resource.endsWith(".css")){
				RendererUtilities.addCssForJQueryPlugin(component, responseWriter, context, resource);
			}
			if (resource.endsWith(".js")){
				RendererUtilities.addJsForJQueryPlugin(component, responseWriter, context, resource);
			}
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

	private String createOptionComponent(StringBuffer sbOption, AccordionPanel accordionPanel, FacesContext context) {
		sbOption.append(" {\n");
		if (accordionPanel.getActive() != null){
			sbOption.append("active: "+accordionPanel.getActive().toString()+", ");
		}
		if (accordionPanel.getAnimated() != null){
			sbOption.append("animated: '"+accordionPanel.getAnimated()+"', ");
		}
		if (accordionPanel.getEvent() != null){
			sbOption.append("event: '"+accordionPanel.getEvent()+"', ");
		}
		if (accordionPanel.isAutoHeight()){
			sbOption.append("autoHeight: "+accordionPanel.isAutoHeight()+", ");
		}
		if (accordionPanel.isClearStyle()){
			sbOption.append("clearStyle: "+accordionPanel.isClearStyle()+", ");
		}
		if (accordionPanel.isCollapsible()){
			sbOption.append("collapsible: "+accordionPanel.isCollapsible()+", ");
		}
		if (accordionPanel.isFillSpace()){
			sbOption.append("fillSpace: "+accordionPanel.isFillSpace()+", ");
		}
		if (accordionPanel.getIcons() != null){
			sbOption.append("icons: "+accordionPanel.getIcons()+", ");
		}
		if (accordionPanel.isNavigation()){
			sbOption.append("navigation: "+accordionPanel.isNavigation()+" ");
		}
		if (sbOption.toString().endsWith(", ")){
			String stringa = sbOption.substring(0, sbOption.length()-2);
			sbOption = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (sbOption.toString().endsWith(" {\n")){
			String stringa = sbOption.substring(0, sbOption.length()-3);
			sbOption = new StringBuffer(stringa);
			noParams = true;
		}
		if (!noParams)
		{
			sbOption.append(" }");
		}
		return sbOption.toString();
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
