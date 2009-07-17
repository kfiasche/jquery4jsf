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
package org.jquery4jsf.custom.overlay;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.JSOperationElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;

public class OverlayRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Overlay overflow , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, overflow.getMessage(), "message", null);
		
		StringBuffer cssOptions = new StringBuffer();
		encodeOptionComponentByType(cssOptions, overflow.getCssPadding(), "padding", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssMargin(), "margin", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssWidth(), "width", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssTop(), "top", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssLeft(), "left", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssTextAlign(), "textAlign", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssColor(), "color", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssBorder(), "border", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssBackgroundColor(), "backgroundColor", null);
		encodeOptionComponentByType(cssOptions, overflow.getCssCursor(), "cursor", null);
		encodeOptionComponentOptionsByType(options, cssOptions.toString(), "css", null);
		
		StringBuffer overlayOptions = new StringBuffer();
		encodeOptionComponentByType(overlayOptions, overflow.getOverlayCSSBackgroundColor(), "backgroundColor", null);
		encodeOptionComponentByType(overlayOptions, overflow.getOverlayCSSOpacity(), "opacity", null);
		encodeOptionComponentOptionsByType(options, overlayOptions.toString(), "overlayCSS", null);
		
		encodeOptionComponentByType(options, overflow.getIframeSrc(), "iframeSrc", null);
		encodeOptionComponentByType(options, overflow.isForceIframe(), "forceIframe", null);
		encodeOptionComponentByType(options, overflow.getBaseZ(), "baseZ", null);
		encodeOptionComponentByType(options, overflow.isCenterX(), "centerX", "true");
		encodeOptionComponentByType(options, overflow.isCenterY(), "centerY", "true");
		encodeOptionComponentByType(options, overflow.isAllowBodyStretch(), "allowBodyStretch", "true");
		encodeOptionComponentByType(options, overflow.isBindEvents(), "bindEvents", "true");
		encodeOptionComponentByType(options, overflow.isConstrainTabKey(), "constrainTabKey", "true");
		encodeOptionComponentByType(options, overflow.getFadeIn(), "fadeIn", null);
		encodeOptionComponentByType(options, overflow.getFadeOut(), "fadeOut", null);
		encodeOptionComponentByType(options, overflow.getTimeout(), "timeout", null);
		encodeOptionComponentByType(options, overflow.isShowOverlay(), "showOverlay", "true");
		encodeOptionComponentByType(options, overflow.isFocusInput(), "focusInput", "true");
		encodeOptionComponentByType(options, overflow.isApplyPlatformOpacityRules(), "applyPlatformOpacityRules", "true");
		encodeOptionComponentFunction(options, overflow.getOnUnblock(), "ononUnblock", "element, options");
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
		if(context == null || context == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
		if(!component.isRendered())
			return;
		
		Overlay overflow = null;
		if(component instanceof Overlay)
			overflow = (Overlay)component;
		
		encodeResources(overflow);
		encodeScriptOverlay(context, overflow);
		encodeOverlayMarkup(context, overflow);
	}

	private void encodeOverlayMarkup(FacesContext context, Overlay overflow) {		
	}

	private void encodeScriptOverlay(FacesContext context, Overlay overflow) throws IOException {
		JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, overflow));
        documentElement.addFunctionToReady(function);
	}
	
	private String encodeStartEventOperation(FacesContext context, Overlay overflow){
		String jQuery = RendererUtilities.getJQueryVarWidget();
		String options = encodeOptionComponent(new StringBuffer(), overflow, context);
		String operation = jQuery.concat(".blockUI(").concat(options).concat(");");
		String clientId = RendererUtilities.encodeClientIdInteractions(overflow, context);
		boolean isIgnore = false;
		if (clientId.equalsIgnoreCase(overflow.getClientId(context))){
			clientId = "document";
			isIgnore = true;
		}
		StringBuffer eventStart = new StringBuffer();
		eventStart.append("'"+overflow.getEventStart()+"', ");
		JSAttribute attribute = new JSAttribute("bind", false);
		JSElement element = new JSElement(clientId, isIgnore);
		JSFunction function = new JSFunction();
		JSOperationElement operationElement = new JSOperationElement("");
		operationElement.addOperation(operation);
		function.addJSElement(operationElement);
		eventStart.append(function.toJavaScriptCode());
		attribute.addValue(eventStart.toString());
		element.addAttribute(attribute);
		return element.toJavaScriptCode();
	}
	
	private String encodeStopEventOperation(FacesContext context, Overlay overflow){
		String jQuery = RendererUtilities.getJQueryVarWidget();
		String operation = jQuery.concat(".unblockUI();");
		String clientId = RendererUtilities.encodeClientIdInteractions(overflow, context);
		boolean isIgnore = false;
		if (clientId.equalsIgnoreCase(overflow.getClientId(context))){
			clientId = "document";
			isIgnore = true;
		}
		StringBuffer eventStop = new StringBuffer();
		eventStop.append("'"+overflow.getEventStop()+"', ");
		JSAttribute attribute = new JSAttribute("bind", false);
		JSElement element = new JSElement(clientId, isIgnore);
		JSFunction function = new JSFunction();
		JSOperationElement operationElement = new JSOperationElement("");
		operationElement.addOperation(operation);
		function.addJSElement(operationElement);
		eventStop.append(function.toJavaScriptCode());
		attribute.addValue(eventStop.toString());
		element.addAttribute(attribute);
		return element.toJavaScriptCode();
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
		Overlay overflow = null;
		if(component instanceof Overlay)
			overflow = (Overlay)component;
		JSOperationElement operationElement = new JSOperationElement("");
		String startOperation = encodeStartEventOperation(context, overflow);
		String stopOperation = encodeStopEventOperation(context, overflow);
		operationElement.addOperation(startOperation);
		operationElement.addOperation(stopOperation);
		return operationElement;
	}
}