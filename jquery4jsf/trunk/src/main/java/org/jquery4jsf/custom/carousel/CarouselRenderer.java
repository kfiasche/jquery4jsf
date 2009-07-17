/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
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
import org.jquery4jsf.utilities.MessageFactory;

public class CarouselRenderer extends JQueryBaseRenderer implements AjaxBaseRenderer {

	public void encodePartially(FacesContext context, UIComponent component) throws IOException {
	}

	public String getActionURL(FacesContext context) {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeEnd(FacesContext context, UIComponent component)throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Carousel carousel = null;
        if(component instanceof Carousel)
        	carousel = (Carousel)component;
        
        encodeResources(carousel);
        encodeScriptCarousel(context, carousel);
        encodeMarkupCarousel(context, carousel);
        

	}

	private void encodeMarkupCarousel(FacesContext context, Carousel carousel) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
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
        responseWriter.endElement(HTML.TAG_UL);
	}

	private void encodeScriptCarousel(FacesContext context, Carousel carousel) {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, carousel));
        documentElement.addFunctionToReady(function);
	}

	public JSElement getJSElement(FacesContext context, UIComponent component){
        Carousel carousel = null;
        if(component instanceof Carousel)
        	carousel = (Carousel)component;
        JSElement element = new JSElement(carousel.getClientId(context));
        JSAttribute jsCarousel = new JSAttribute("jcarousel", false);
        StringBuffer sbOption = new StringBuffer();
        jsCarousel.addValue(encodeOptionComponent(sbOption, carousel, context));
        element.addAttribute(jsCarousel);
        return element;
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
