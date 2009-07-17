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
package org.jquery4jsf.custom.progressbar;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class ProgressBarRenderer extends JQueryBaseRenderer {

	public static final String RENDERER_TYPE = "org.jquery4jsf.ProgressBarRenderer";

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(context == null || component == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;

		ProgressBar progressBar = null;
		if(component instanceof ProgressBar)
			progressBar = (ProgressBar)component;

		encodeResources(progressBar);
		encodeProgressBarScript(context, progressBar);
		encodeProgressBarMarkup(context, progressBar);
	}

	private void encodeProgressBarMarkup(FacesContext context, ProgressBar progressBar) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(HTML.TAG_DIV, progressBar);
		responseWriter.writeAttribute(HTML.ID, progressBar.getClientId(context).concat("Wrapper"), null);
		responseWriter.writeAttribute(HTML.STYLE, "height:25px; ", null);
		responseWriter.writeAttribute("class", "ui-widget-default", null);
		responseWriter.startElement(HTML.TAG_DIV, progressBar);
		responseWriter.writeAttribute(HTML.ID, progressBar.getClientId(context), null);
		responseWriter.writeAttribute(HTML.STYLE, "height:100%;", null);
		responseWriter.endElement(HTML.TAG_DIV);
		responseWriter.endElement(HTML.TAG_DIV);
	}

	private void encodeProgressBarScript(FacesContext context, ProgressBar progressBar) {
		JSDocumentElement documentElement = JSDocumentElement.getInstance();
		JSFunction function = new JSFunction();
		function.addJSElement(getJSElement(context, progressBar));
		if (progressBar.isResizable()){
			function.addJSElement(getJSElementResize(context, progressBar));
		}
		documentElement.addFunctionToReady(function);
	}

	private String encodeOptionComponent(StringBuffer options, ProgressBar progressBar, FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, progressBar.getProgressBarValue(), "value", null);
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

	public JSElement getJSElement(FacesContext context, UIComponent component){
		//progressbar
		ProgressBar progressBar = null;
		if(component instanceof ProgressBar)
			progressBar = (ProgressBar)component;
		JSElement element = new JSElement(progressBar.getClientId(context));
		JSAttribute jsProgressbar = new JSAttribute("progressbar", false);
		StringBuffer sbOption = new StringBuffer();
		jsProgressbar.addValue(encodeOptionComponent(sbOption, progressBar, context));
		element.addAttribute(jsProgressbar);
		return element;
	}
	private JSElement getJSElementResize(FacesContext context, UIComponent component) {
		//resize
		ProgressBar progressBar = null;
		if(component instanceof ProgressBar)
			progressBar = (ProgressBar)component;
		JSElement elementWrapper = new JSElement(progressBar.getClientId(context).concat("Wrapper"));
		JSAttribute jsWrapperRes = new JSAttribute("resizable", false);
		jsWrapperRes.addValue("");
		elementWrapper.addAttribute(jsWrapperRes);
		return elementWrapper;
	}

	public void encodeScript(FacesContext context, JQueryHtmlObject queryComponent) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.write("\n");
		responseWriter.write(getJSElement(context, (UIComponent) queryComponent).toJavaScriptCode());
		responseWriter.write("\n");
		responseWriter.write(getJSElementResize(context, (UIComponent) queryComponent).toJavaScriptCode());
		responseWriter.write("\n");
	}


}
