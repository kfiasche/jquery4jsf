package org.jquery4jsf.custom.colorpicker;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class ColorPickerRenderer extends ColorPickerBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component)throws IOException {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        ColorPicker colorPicker = null;
        if(component instanceof ColorPicker)
        	colorPicker = (ColorPicker)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = colorPicker.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        UIComponent parent = colorPicker.getParent();
        String clientId = null;
        if (parent instanceof UIInput && !colorPicker.isFlat()){
        	clientId = parent.getClientId(context);
        	colorPicker.getAttributes().put("target", RendererUtilities.getJQueryId(clientId));
        }
        else if (!colorPicker.isFlat()){
        	clientId = colorPicker.getClientId(context);
        	rendererInputText(responseWriter, colorPicker, context);	
        	colorPicker.getAttributes().put("target", RendererUtilities.getJQueryId(clientId));
        }
        else{
        	clientId = colorPicker.getClientId(context);
        	responseWriter.startElement(HTML.TAG_P, colorPicker);
        	writeIdAttributeIfNecessary(context, responseWriter, component);
        	responseWriter.endElement(HTML.TAG_P);
        	HtmlInputHidden secret = new HtmlInputHidden();
        	String colorPickerId = colorPicker.getId() + "hidden";
        	secret.setId(colorPickerId);
        	String colorPickerhdd = clientId + "hidden";
        	secret.setValue(colorPicker.getColor());
        	secret.setParent(RendererUtilities.getForm(context, component));
        	secret.encodeBegin(context);
        	secret.encodeChildren(context);
        	secret.encodeEnd(context);
        	colorPicker.getAttributes().put("target", RendererUtilities.getJQueryId(colorPickerhdd));
        }
        
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(clientId);
        JSAttribute jsColorPicker = new JSAttribute("ColorPicker", false);
        StringBuffer sbOption = new StringBuffer();
        jsColorPicker.addValue(encodeOptionComponent(sbOption, colorPicker, context));
        element.addAttribute(jsColorPicker);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
	}

	public void decode(FacesContext context, UIComponent component) {
        if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        super.decode(context, component);
        
        ColorPicker colorPicker = null;
        if(component instanceof ColorPicker)
        	colorPicker = (ColorPicker)component;
        if (colorPicker.isFlat()){
        	String colorPickerHidden = colorPicker.getClientId(context) + "hidden";
        	String object = (String) context.getExternalContext().getRequestParameterMap().get(colorPickerHidden);
        	colorPicker.setColor(object);
        }
	}
	
	
	
}
