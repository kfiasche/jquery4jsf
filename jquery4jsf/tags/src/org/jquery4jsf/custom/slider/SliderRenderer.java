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
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class SliderRenderer extends JQueryBaseRenderer implements AjaxBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.SliderRenderer";
	
	
	public void encodePartially(FacesContext context, UIComponent component)
			throws IOException {
	}

	public String getActionURL(FacesContext context) throws IOException {
		return RendererUtilities.getActionURL(context);
	}

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        Slider slider = null;
        if(component instanceof Slider)
        	slider = (Slider)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = slider.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(slider.getClientId(context));
        JSAttribute jsAutocomplete = new JSAttribute("slider", false);
        StringBuffer sbOption = new StringBuffer();
        jsAutocomplete.addValue(encodeOptionComponent(sbOption, slider, context));
        element.addAttribute(jsAutocomplete);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
        responseWriter.startElement(HTML.TAG_DIV, component);
        responseWriter.writeAttribute("id", component.getClientId(context), "id");
        responseWriter.endElement(HTML.TAG_DIV);
	}

	private String encodeOptionComponent(StringBuffer options, Slider slider, FacesContext context) {
		options.append(" {\n");
		
		encodeOptionComponentByType(options, slider.isAnimate(), "animate", null);
		encodeOptionComponentByType(options, slider.getMax(), "max", null);
		encodeOptionComponentByType(options, slider.getMin(), "min", null);
		encodeOptionComponentByType(options, slider.getOrientation(), "orientation", null);
		encodeOptionComponentByType(options, slider.getRange(), "range", null);
		encodeOptionComponentByType(options, slider.getStep(), "step", null);
		encodeOptionComponentByType(options, slider.getValue(), "value", null);
		encodeOptionComponentArrayByType(options, slider.getValues(), "values");
		
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

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	}
	
	
	

}
