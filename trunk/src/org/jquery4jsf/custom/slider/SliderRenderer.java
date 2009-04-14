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
        jsAutocomplete.addValue(createOptionComponent(sbOption, slider, context));
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

	private String createOptionComponent(StringBuffer options, Slider slider, FacesContext context) {
		options.append(" {\n");
		
		createOptionComponentByType(options, slider.isAnimate(), "animate");
		createOptionComponentByType(options, slider.getMax(), "max");
		createOptionComponentByType(options, slider.getMin(), "min");
		createOptionComponentByType(options, slider.getOrientation(), "orientation");
		createOptionComponentByType(options, slider.getRange(), "range");
		createOptionComponentByType(options, slider.getStep(), "step");
		createOptionComponentByType(options, slider.getValue(), "value");
		createOptionComponentArrayByType(options, slider.getValues(), "values");
		
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
