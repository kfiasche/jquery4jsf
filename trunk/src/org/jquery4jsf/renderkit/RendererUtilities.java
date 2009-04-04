package org.jquery4jsf.renderkit;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.html.HTML;

public class RendererUtilities {
	
	public static String getFormId(FacesContext context, UIComponent component)
	{
		while (component != null && !(component instanceof UIForm))
		{
			component = component.getParent();
		}
		
		if (component instanceof UIForm)
		{
			return ((UIForm) component).getId();
		}
		
		return null;
	}
	
	public static UIForm getForm(FacesContext context, UIComponent component)
	{
		while (component != null && !(component instanceof UIForm))
		{
			component = component.getParent();
		}
		if (component instanceof UIForm)
		{
			return ((UIForm) component);
		}
		return null;
	}

	public static void addJsForJQuery(UIComponent component, ResponseWriter responseWriter, FacesContext context) throws IOException {
		responseWriter.startElement(HTML.TAG_SCRIPT, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/javascript", null);
		responseWriter.writeAttribute(HTML.LANGUAGE, "javascript", null);
		String contextPath = context.getExternalContext().getRequestContextPath();
		responseWriter.writeAttribute(HTML.SRC,contextPath.concat("/jquery4jsf_resource/jquery/jquery.js"), null);	
		responseWriter.endElement(HTML.TAG_SCRIPT);
		responseWriter.write("\n");
	}

	public static void addJsForJQueryPlugin(UIComponent component, ResponseWriter responseWriter, FacesContext context, String string) throws IOException {
		responseWriter.startElement(HTML.TAG_SCRIPT, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/javascript", null);
		responseWriter.writeAttribute(HTML.LANGUAGE, "javascript", null);
		String contextPath = context.getExternalContext().getRequestContextPath();
		responseWriter.writeAttribute(HTML.SRC,contextPath.concat("/jquery4jsf_resource/".concat(string)), null);	
		responseWriter.endElement(HTML.TAG_SCRIPT);
		responseWriter.write("\n");
	}

	public static void addCssForJQueryPlugin(UIComponent component, ResponseWriter responseWriter, FacesContext context, String string) throws IOException {
		responseWriter.startElement(HTML.TAG_LINK, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/css", null);
		responseWriter.writeAttribute(HTML.REL, "stylesheet", null);
		String contextPath = context.getExternalContext().getRequestContextPath();
		responseWriter.writeAttribute(HTML.HREF,contextPath.concat("/jquery4jsf_resource/".concat(string)), null);
		responseWriter.writeAttribute(HTML.MEDIA, "screen", null);
		responseWriter.endElement(HTML.TAG_LINK);
		responseWriter.write("\n");
	}

	public static void createTagScriptForJs(UIComponent component, ResponseWriter responseWriter, StringBuffer sb) throws IOException {
		responseWriter.startElement(HTML.TAG_SCRIPT, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/javascript", null);
		responseWriter.writeAttribute(HTML.LANGUAGE, "javascript", null);
		responseWriter.write(sb.toString());
		responseWriter.endElement(HTML.TAG_SCRIPT);
		responseWriter.write("\n");
	}

	public static void renderChildren(FacesContext facesContext, UIComponent component) throws IOException {
		for (Iterator iterator = component.getChildren().iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			renderChild(facesContext, child);
		}
	}

	public static void renderChild(FacesContext facesContext, UIComponent child) throws IOException {
		if (!child.isRendered()) {
			return;
		}
		child.encodeBegin(facesContext);
		if (child.getRendersChildren()) {
			child.encodeChildren(facesContext);
		} else {
			renderChildren(facesContext, child);
		}
		child.encodeEnd(facesContext);
	}
	
	public static String getActionURL(FacesContext facesContext) {
		String actionURL = facesContext.getApplication().getViewHandler().getActionURL(facesContext, facesContext.getViewRoot().getViewId());
		String url = facesContext.getExternalContext().encodeResourceURL(actionURL);
		return url;
	}
	
}
