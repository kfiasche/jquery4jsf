package org.jquery4jsf.custom.progressbar;

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

public class ProgressBarRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.ProgressBarRenderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(context == null || component == null)
			throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;

		ProgressBar progressBar = null;
		if(component instanceof ProgressBar)
			progressBar = (ProgressBar)component;

		ResponseWriter responseWriter = context.getResponseWriter();
		// TODO devo trovare il modo per scrivere i script nell'head
		String[] list = progressBar.getResources();
		for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n");
		JSDocumentElement documentElement = new JSDocumentElement();
		JSElement element = new JSElement(progressBar.getClientId(context));
		JSAttribute jsProgressbar = new JSAttribute("progressbar", false);
		StringBuffer sbOption = new StringBuffer();
		jsProgressbar.addValue(encodeOptionComponent(sbOption, progressBar, context));
		element.addAttribute(jsProgressbar);

		JSFunction function = new JSFunction();
		function.addJSElement(element);
		if (progressBar.isResizable()){
			JSElement elementWrapper = new JSElement(progressBar.getClientId(context).concat("Wrapper"));
			JSAttribute jsWrapperRes = new JSAttribute("resizable", false);
			jsWrapperRes.addValue("");
			elementWrapper.addAttribute(jsWrapperRes);
			function.addJSElement(elementWrapper);
		}
		
		documentElement.addFunctionToReady(function);
		sb.append(documentElement.toJavaScriptCode());
		sb.append("\n");
		
		RendererUtilities.createTagScriptForJs(component, responseWriter, sb); 
		//if (progressBar.isResizable()){
			responseWriter.startElement(HTML.TAG_DIV, progressBar);
			responseWriter.writeAttribute(HTML.ID, progressBar.getClientId(context).concat("Wrapper"), null);
			responseWriter.writeAttribute(HTML.STYLE, "height:25px; ", null);
			responseWriter.writeAttribute("class", "ui-widget-default", null);
		//}
		responseWriter.startElement(HTML.TAG_DIV, progressBar);
		responseWriter.writeAttribute(HTML.ID, progressBar.getClientId(context), null);
		responseWriter.writeAttribute(HTML.STYLE, "height:100%;", null);
		responseWriter.endElement(HTML.TAG_DIV);
		//if (progressBar.isResizable()){
			responseWriter.endElement(HTML.TAG_DIV);
		//}

	}

	private String encodeOptionComponent(StringBuffer options, ProgressBar progressBar, FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, progressBar.getValue(), "value", null);
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



}
