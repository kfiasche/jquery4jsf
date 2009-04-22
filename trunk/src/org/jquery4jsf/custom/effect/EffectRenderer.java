package org.jquery4jsf.custom.effect;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class EffectRenderer extends EffectBaseRenderer {

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Effect effect = null;
        if(component instanceof Effect)
            effect = (Effect)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = effect.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
		String parentClientId = effect.getParent().getClientId(context);
		String effectedComponentClientId = null;
		
		if(effect.getFor() != null) {
			effectedComponentClientId = RendererUtilities.getClientIdForComponent(effect.getFor(), context, effect);
		} else {
			effectedComponentClientId = parentClientId;
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        
        
        JSElement thisElement = new JSElement("this");
        JSAttribute jsEvent = new JSAttribute(effect.getEvent(), false);
        
        JSElement element = new JSElement(effectedComponentClientId);
        JSAttribute jsEffect = new JSAttribute("effect", false);
        
        StringBuffer sbOption = new StringBuffer();
        String optionsString = effect.getOptions() != null ? "{"+ effect.getOptions() +"}" : "{}";
        sbOption.append("'");
        sbOption.append(effect.getEffect());
        sbOption.append("', ");
        sbOption.append(optionsString);
        sbOption.append(", ");
        sbOption.append(effect.getSpeed());
        sbOption.append(", ");
        sbOption.append(effect.getCallback());
        jsEffect.addValue(sbOption.toString());
        thisElement.addAttribute(jsEffect);
        JSFunction function = new JSFunction();
        
        JSFunction functionEvent = new JSFunction();
        functionEvent.addJSElement(thisElement);
        jsEvent.addValue(functionEvent.toJavaScriptCode());
        element.addAttribute(jsEvent);
        function.addJSElement(element);
        
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
	}
	
	protected String encodeOptionComponent(StringBuffer options, Effect effect , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, effect.getOptions(), "options", null);
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
		String returns = options.toString();
		return returns.trim().equalsIgnoreCase("") ? "{}" : returns;
	}
	
}
