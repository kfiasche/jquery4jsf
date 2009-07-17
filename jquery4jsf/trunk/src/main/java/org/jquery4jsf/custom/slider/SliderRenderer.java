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
package org.jquery4jsf.custom.slider;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.renderkit.html.HtmlRendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;
public class SliderRenderer extends SliderBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.SliderRenderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        Slider slider = null;
        if(component instanceof Slider)
        	slider = (Slider)component;
        
        encodeResources(slider);
        encodeSliderScript(context, slider);
        encodeSliderMarkup(context, slider);
	}

	
	private void encodeSliderScript(FacesContext context, Slider slider) {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, slider));
        documentElement.addFunctionToReady(function);
	}


	private void encodeSliderMarkup(FacesContext context, Slider slider) throws IOException{
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, slider);
		responseWriter.writeAttribute("id", slider.getClientId(context), "id");
		HtmlRendererUtilities.writeHtmlAttributes(responseWriter, slider, HTML.HTML_STD_ATTR);
		responseWriter.endElement(HTML.TAG_DIV);
	}
	public JSElement getJSElement(FacesContext context, UIComponent component) {
        Slider slider = null;
        if(component instanceof Slider)
        	slider = (Slider)component;
        
        JSElement element = new JSElement(slider.getClientId(context));
        JSAttribute jsSlider = new JSAttribute("slider", false);
        StringBuffer sbOption = new StringBuffer();
        jsSlider.addValue(encodeOptionComponent(sbOption, slider, context));
        element.addAttribute(jsSlider);
		return element;
	}
		

}
