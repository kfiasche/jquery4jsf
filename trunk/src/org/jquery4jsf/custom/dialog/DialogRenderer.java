package org.jquery4jsf.custom.dialog;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class DialogRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.DialogRenderer";

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        Dialog dialog = null;
        if(component instanceof Dialog)
            dialog = (Dialog)component;
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = dialog.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			if (resource.endsWith(".css")){
				ResourceContext.getInstance().addResource(resource);
			}
			if (resource.endsWith(".js")){
				ResourceContext.getInstance().addResource(resource);
			}
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(dialog.getClientId(context));
        JSAttribute jsDialog = new JSAttribute("dialog", false);
        StringBuffer sbOption = new StringBuffer();
        jsDialog.addValue(encodeOptionComponent(sbOption, dialog, context));
        element.addAttribute(jsDialog);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.createTagScriptForJs(component, responseWriter, sb);
        
        responseWriter.startElement(HTML.TAG_DIV, dialog);
        writeIdAttributeIfNecessary(context, responseWriter, component);
	}

	private String encodeOptionComponent(StringBuffer options, Dialog dialog, FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, dialog.isAutoOpen(), "autoOpen");
		encodeOptionComponentByType(options, dialog.isBgiframe(), "bgiframe");
		encodeOptionComponentByType(options, dialog.getButtons(), "buttons");
		encodeOptionComponentByType(options, dialog.isCloseOnEscape(), "closeOnEscape");
		encodeOptionComponentByType(options, dialog.getDialogClass(), "dialogClass");
		encodeOptionComponentByType(options, dialog.isDraggable(), "draggable");
		encodeOptionComponentByType(options, dialog.getHeight(), "height");
		encodeOptionComponentByType(options, dialog.getHide(), "hide");
		encodeOptionComponentByType(options, dialog.getMaxHeight(), "maxHeight");
		encodeOptionComponentByType(options, dialog.getMaxWidth(), "maxWidth");
		encodeOptionComponentByType(options, dialog.getMinHeight(), "minHeight");
		encodeOptionComponentByType(options, dialog.getMinWidth(), "minWidth");
		encodeOptionComponentByType(options, dialog.isModal(), "modal");
		encodeOptionComponentByType(options, dialog.getPosition(), "position");
		encodeOptionComponentByType(options, dialog.isResizable(), "resizable");
		encodeOptionComponentByType(options, dialog.getShow(), "show");
		encodeOptionComponentByType(options, dialog.isStack(), "stack");
		encodeOptionComponentByType(options, dialog.getTitle(), "title");
		encodeOptionComponentByType(options, dialog.getWidth(), "width");
		encodeOptionComponentByType(options, dialog.getZindex(), "zIndex");
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
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.endElement(HTML.TAG_DIV);
	}

}
