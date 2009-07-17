/*
 
*  Copyright (c) 2009 Giuseppe Trisciuoglio 
* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jquery4jsf.custom.lightbox;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;

public class LightBoxRenderer extends LightBoxBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        LightBox lightBox = null;
        if(component instanceof LightBox)
            lightBox = (LightBox)component;
        
        encodeResources(lightBox);
        encodeLightBoxScript(context, lightBox);
        encodeLightBoxMarkup(context, lightBox);
	}

	private void encodeLightBoxMarkup(FacesContext context, LightBox lightBox) throws IOException {
		String clientId = lightBox.getClientId(context);
		ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement(HTML.TAG_DIV, lightBox);
        responseWriter.writeAttribute("id", clientId, "id");
		if(lightBox.getStyleClass() == null)
			responseWriter.writeAttribute("class", "ui-lightbox", null);
		else
			responseWriter.writeAttribute("class", "ui-lightbox " + lightBox.getStyleClass(), null);
		
		if(lightBox.getStyle() != null)
			responseWriter.writeAttribute("style", lightBox.getStyle(), null);
		
		responseWriter.write("\n");
		responseWriter.startElement(HTML.TAG_UL, null);
		responseWriter.write("\n");
		for (Iterator iterator = lightBox.getChildren().iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			if(child.isRendered()) {
				responseWriter.write("\n");
				responseWriter.startElement(HTML.TAG_LI, null);
				responseWriter.write("\n");
				RendererUtilities.renderChild(context, child);
				responseWriter.write("\n");
				responseWriter.endElement(HTML.TAG_LI);
				responseWriter.write("\n");
			}
		}
		responseWriter.write("\n");
		responseWriter.endElement(HTML.TAG_UL);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeLightBoxScript(FacesContext context, LightBox lightBox) {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, lightBox));
        documentElement.addFunctionToReady(function);
	}

	public void encodeChildren(FacesContext facesContext, UIComponent component) throws IOException {
	}

	public boolean getRendersChildren() {
		return true;
	}	
	
	protected String encodeOptionComponent(StringBuffer options, LightBox lightBox , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, lightBox.getStyle(), "style", null);
		encodeOptionComponentByType(options, lightBox.getStyleClass(), "styleClass", null);
		encodeOptionComponentByType(options, lightBox.getActiveImage(), "activeImage", null);
		encodeOptionComponentByType(options, lightBox.isFixedNavigation(), "fixedNavigation", null);
		encodeOptionComponentByType(options, lightBox.getOverlayBgColor(), "overlayBgColor", null);
		encodeOptionComponentByType(options, lightBox.getOverlayOpacity(), "overlayOpacity", null);
		encodeOptionComponentByType(options, lightBox.getImageLoading() != null ? lightBox.getImageLoading() : RendererUtilities.getResourceURL(context, "/lightbox/images/lightbox-ico-loading.gif"), "imageLoading", null);
		encodeOptionComponentByType(options, lightBox.getImageBtnClose() != null ? lightBox.getImageBtnClose() : RendererUtilities.getResourceURL(context, "/lightbox/images/lightbox-btn-close.gif"), "imageBtnClose", null);
		encodeOptionComponentByType(options, lightBox.getImageBtnPrev() != null ? lightBox.getImageBtnPrev() : RendererUtilities.getResourceURL(context, "/lightbox/images/lightbox-btn-prev.gif"), "imageBtnPrev", null);
		encodeOptionComponentByType(options, lightBox.getImageBtnNext()!= null ? lightBox.getImageBtnNext() : RendererUtilities.getResourceURL(context, "/lightbox/images/lightbox-btn-next.gif"), "imageBtnNext", null);
		encodeOptionComponentByType(options, lightBox.getContainerBorderSize(), "containerBorderSize", null);
		encodeOptionComponentByType(options, lightBox.getContainerResizeSpeed(), "containerResizeSpeed", null);
		encodeOptionComponentByType(options, lightBox.getTxtImage(), "txtImage", null);
		encodeOptionComponentByType(options, lightBox.getTxtOf(), "txtOf", null);
		encodeOptionComponentByType(options, lightBox.getImageBlank() != null ? lightBox.getImageBlank() : RendererUtilities.getResourceURL(context, "/lightbox/images/lightbox-blank.gif") , "imageBlank", null);
		encodeOptionComponentByType(options, lightBox.getKeyToClose(), "keyToClose", null);
		encodeOptionComponentByType(options, lightBox.getKeyToPrev(), "keyToPrev", null);
		encodeOptionComponentByType(options, lightBox.getKeyToNext(), "keyToNext", null);
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

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        LightBox lightBox = null;
        if(component instanceof LightBox)
            lightBox = (LightBox)component;
        JSElement element = new JSElement(lightBox.getClientId(context)+" a");
        JSAttribute jslightBox = new JSAttribute("lightBox", false);
        StringBuffer sbOption = new StringBuffer();
        jslightBox.addValue(encodeOptionComponent(sbOption, lightBox, context));
        element.addAttribute(jslightBox);
        return element;
	}
}