package org.jquery4jsf.custom.carousel;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIGraphic;
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
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class CarouselRenderer extends JQueryBaseRenderer implements AjaxBaseRenderer {

	public void encodePartially(FacesContext context, UIComponent component) throws IOException {
	}

	public String getActionURL(FacesContext context) throws IOException {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeEnd(FacesContext context, UIComponent component)throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.endElement(HTML.TAG_UL);
	}

	public void encodeBegin(FacesContext context, UIComponent component)throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        Carousel carousel = null;
        if(component instanceof Carousel)
        	carousel = (Carousel)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = carousel.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(carousel.getClientId(context));
        JSAttribute jsCarousel = new JSAttribute("jcarousel", false);
        StringBuffer sbOption = new StringBuffer();
        jsCarousel.addValue(encodeOptionComponent(sbOption, carousel, context));
        element.addAttribute(jsCarousel);

        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb); 
        
        responseWriter.startElement(HTML.TAG_UL, carousel);
        responseWriter.writeAttribute(HTML.ID, carousel.getClientId(context), "id");
        if (carousel.getSkinStyleClass() != null){
        	responseWriter.writeAttribute("class", carousel.getSkinStyleClass(), "skinStyleClass");
        }
        else {
        	String styleClass = "jcarousel-skin-".concat(carousel.getSkin());
        	responseWriter.writeAttribute("class",styleClass, null);
        }
        encodeCarouselContent(context,responseWriter, carousel);
	}

	private void encodeCarouselContent(FacesContext context,ResponseWriter responseWriter, Carousel carousel) throws IOException {
		List children = carousel.getChildren();
		if (children == null || children.isEmpty() || !isChildHasImg(children)){
			throw new IllegalArgumentException("Il carousel deve avere almeno un immagine come figlio.");
		}
		responseWriter.write("\n");
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			UIGraphic graphic = (UIGraphic) iterator.next();
	        responseWriter.startElement(HTML.TAG_LI, null);
	        graphic.encodeBegin(context);
	        graphic.encodeChildren(context);
	        graphic.encodeEnd(context);
	        responseWriter.endElement(HTML.TAG_LI);
	        responseWriter.write("\n");
		}
	}

	private boolean isChildHasImg(List children) {
		boolean isChildGrafic = true;
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			if (child instanceof UIGraphic) {
				isChildGrafic = true && isChildGrafic;
			}
			else{
				isChildGrafic = false;
			}
		}
		return isChildGrafic;
	}

	private String encodeOptionComponent(StringBuffer options,Carousel carousel, FacesContext context) {
		return null;
	}

	public void encodeChildren(FacesContext context, UIComponent component)throws IOException {
	}

	public boolean getRendersChildren() {
		return true;
	}
	
}
