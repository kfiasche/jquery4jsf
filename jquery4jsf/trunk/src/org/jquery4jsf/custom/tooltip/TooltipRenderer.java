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
package org.jquery4jsf.custom.tooltip;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.el.MethodBinding;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class TooltipRenderer extends TooltipBaseRenderer implements AjaxBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		  if(context == null || component == null)
	            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
	        if(!component.isRendered())
	            return;
	        Tooltip tooltip = null;
	        if(component instanceof Tooltip)
	        	tooltip = (Tooltip)component;
	        
	        ResponseWriter responseWriter = context.getResponseWriter();
	        // TODO devo trovare il modo per scrivere i script nell'head
	        String[] list = tooltip.getResources();
	        for (int i = 0; i < list.length; i++) {
				String resource = list[i];
				ResourceContext.getInstance().addResource(resource);
			}
	        
	        StringBuffer sb = new StringBuffer();
	        sb.append("\n");
	        JSDocumentElement documentElement = new JSDocumentElement();
	        String idParent = tooltip.getParent().getClientId(context);
	        JSElement element = new JSElement(idParent);
	        JSAttribute jsTooltip = new JSAttribute("qtip", false);
	        StringBuffer sbOption = new StringBuffer();
	        jsTooltip.addValue(encodeOptionComponent(sbOption, tooltip, context));
	        element.addAttribute(jsTooltip);
	        JSFunction function = new JSFunction();
	        function.addJSElement(element);
	        documentElement.addFunctionToReady(function);
	        sb.append(documentElement.toJavaScriptCode());
	        sb.append("\n");
	        RendererUtilities.createTagScriptForJs(component, responseWriter, sb); 
	}

	
	protected String encodeOptionComponent(StringBuffer options, Tooltip tooltip , FacesContext context) {
		options.append(" {\n");
		StringBuffer optionsContent = new StringBuffer();
		encodeOptionComponentByType(optionsContent, tooltip.isPrerender(), "prerender", "false");
		encodeOptionComponentByType(optionsContent, tooltip.getText(), "text", null);
		
		StringBuffer optionsTitle = new StringBuffer();
		encodeOptionComponentByType(optionsTitle, tooltip.getTitleText(), "text", null);
		encodeOptionComponentByType(optionsTitle, tooltip.getTitleButton(), "button", null);
		encodeOptionComponentOptionsByType(optionsContent, optionsTitle.toString(), "title", null);
		if (tooltip.getOncomplete() != null){
    		String actionURL = getActionURL(context);
    		String clientId = tooltip.getClientId(context);;
    		if(actionURL.indexOf("?") == -1)
    		{
    			actionURL = actionURL + "?ajaxSourceJQuery=" + clientId;
    		}
    		else
    		{
    			actionURL = actionURL + "&ajaxSourceJQuery=" + clientId;
    		}
			encodeOptionComponentByType(optionsContent, actionURL, "url", null);
			encodeOptionComponentByType(optionsContent, "post", "method", null);
		}
		encodeOptionComponentOptionsByType(options, optionsContent.toString(), "content", null);
		
		StringBuffer optionsPosition = new StringBuffer();
		encodeOptionComponentByType(optionsPosition, tooltip.getPositionTarget(), "target", null);
		encodeOptionComponentByType(optionsPosition, tooltip.getPositionType(), "type", null);
		encodeOptionComponentByType(optionsPosition, tooltip.getPositionContainer(), "container", null);
		
		StringBuffer optionsCorner = new StringBuffer();
		encodeOptionComponentByType(optionsCorner, tooltip.getCornerTarget(), "target", null);
		encodeOptionComponentByType(optionsCorner, tooltip.getCornerTooltip(), "tooltip", null);
		
		encodeOptionComponentOptionsByType(optionsPosition, optionsCorner.toString(), "corner", null);
		
		StringBuffer optionsAdjust = new StringBuffer();
		encodeOptionComponentByType(optionsAdjust, tooltip.getAdjustX(), "x", null);
		encodeOptionComponentByType(optionsAdjust, tooltip.getAdjustY(), "y", null);
		encodeOptionComponentByType(optionsAdjust, tooltip.isAdjustMouse(), "mouse", null);
		encodeOptionComponentByType(optionsAdjust, tooltip.isAdjustScreen(), "screen", null);
		encodeOptionComponentByType(optionsAdjust, tooltip.isAdjustScroll(), "scroll", null);
		encodeOptionComponentByType(optionsAdjust, tooltip.getAdjustResize(), "resize", null);
		encodeOptionComponentOptionsByType(optionsPosition, optionsAdjust.toString(), "adjust", null);
		encodeOptionComponentOptionsByType(options, optionsPosition.toString(), "position", null);
		
		StringBuffer optionsShow = new StringBuffer();
		encodeOptionComponentByType(optionsShow, tooltip.getShowDelay(), "delay", null);
		encodeOptionComponentByType(optionsShow, tooltip.getShowSolo(), "solo", null);
		encodeOptionComponentByType(optionsShow, tooltip.getShowReady(), "ready", null);
		
		StringBuffer optionsShowWhen = new StringBuffer();
		encodeOptionComponentByType(optionsShowWhen, tooltip.getShowWhenTarget(), "target", null);
		encodeOptionComponentByType(optionsShowWhen, tooltip.getShowWhenEvent(), "event", null);
		encodeOptionComponentOptionsByType(optionsShow, optionsShowWhen.toString(), "when", null);
		StringBuffer optionsShowEffect = new StringBuffer();
		encodeOptionComponentByType(optionsShowEffect, tooltip.getShowEffectLength(), "length", null);
		encodeOptionComponentByType(optionsShowEffect, tooltip.getShowEffectType(), "type", null);
		encodeOptionComponentOptionsByType(optionsShow, optionsShowEffect.toString(), "effect", null);
		encodeOptionComponentOptionsByType(options, optionsShow.toString(), "show", null);
		
		StringBuffer optionsHide = new StringBuffer();
		encodeOptionComponentByType(optionsHide, tooltip.getHideDelay(), "delay", null);
		encodeOptionComponentByType(optionsHide, tooltip.isHideFixed(), "fixed", null);
		
		StringBuffer optionsHideWhen = new StringBuffer();
		encodeOptionComponentByType(optionsHideWhen, tooltip.getHideWhenTarget(), "target", null);
		encodeOptionComponentByType(optionsHideWhen, tooltip.getHideWhenEvent(), "event", null);
		encodeOptionComponentOptionsByType(optionsHide, optionsHideWhen.toString(), "when", null);
		StringBuffer optionsHideEffect = new StringBuffer();
		encodeOptionComponentByType(optionsHideEffect, tooltip.getHideEffectLength(), "length", null);
		encodeOptionComponentByType(optionsHideEffect, tooltip.getHideEffectType(), "type", null);
		encodeOptionComponentOptionsByType(optionsHide, optionsHideEffect.toString(), "effect", null);
		encodeOptionComponentOptionsByType(options, optionsHide.toString(), "hide", null);
		
		StringBuffer optionsStyle = new StringBuffer();
		encodeOptionComponentByType(optionsStyle, tooltip.getStyleName(), "name", null);
		StringBuffer optionsStyleWidth = new StringBuffer();
		encodeOptionComponentByType(optionsStyleWidth, tooltip.getStyleWidthMin(), "min", null);
		encodeOptionComponentByType(optionsStyleWidth, tooltip.getStyleWidthMax(), "max", null);
		encodeOptionComponentOptionsByType(optionsStyle, optionsStyleWidth.toString(), "width", null);
		StringBuffer optionsStyleBorder = new StringBuffer();
		encodeOptionComponentByType(optionsStyleBorder, tooltip.getStyleBorderWidth(), "width", null);
		encodeOptionComponentByType(optionsStyleBorder, tooltip.getStyleBorderRadius(), "radius", null);
		encodeOptionComponentByType(optionsStyleBorder, tooltip.getStyleBorderColor(), "color", null);
		encodeOptionComponentOptionsByType(optionsStyle, optionsStyleBorder.toString(), "border", null);
		StringBuffer optionsTip = new StringBuffer();
		encodeOptionComponentByType(optionsTip, tooltip.getStyleTipColor(), "color", null);
		encodeOptionComponentByType(optionsTip, tooltip.getStyleTipCorner(), "corner", null);
		StringBuffer optionsTipSize = new StringBuffer();
		encodeOptionComponentByType(optionsTipSize, tooltip.getStyleTipSizeX(), "x", null);
		encodeOptionComponentByType(optionsTipSize, tooltip.getStyleTipSizeY(), "y", null);
		
		encodeOptionComponentOptionsByType(optionsTip, optionsTipSize.toString(), "size", null);
		encodeOptionComponentOptionsByType(optionsStyle, optionsTip.toString(), "tip", null);
		
		StringBuffer optionsStyleClass = new StringBuffer();
		encodeOptionComponentByType(optionsStyleClass, tooltip.getStyleTargetClass(), "target", null);
		encodeOptionComponentByType(optionsStyleClass, tooltip.getStyleTooltipClass(), "tooltip", null);
		encodeOptionComponentByType(optionsStyleClass, tooltip.getStyleTipClass(), "tip", null);
		encodeOptionComponentByType(optionsStyleClass, tooltip.getStyleTitleClass(), "title", null);
		encodeOptionComponentByType(optionsStyleClass, tooltip.getStyleContentClass(), "content", null);
		encodeOptionComponentByType(optionsStyleClass, tooltip.getStyleActiveClass(), "active", null);
		encodeOptionComponentOptionsByType(optionsStyle, optionsStyleClass.toString(), "classes", null);
		encodeOptionComponentOptionsByType(options, optionsStyle.toString(), "style", null);
		
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


	public void encodePartially(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		Tooltip tooltip = (Tooltip) component;
		MethodBinding me = tooltip.getOncomplete();
		String results = null;
		try {
			results = (String) me.invoke(context, new Object[]{""});
		} catch (Exception e) {
		}
		writer.write(results);
	}

	public String getActionURL(FacesContext context) {
		return RendererUtilities.getActionURL(context);
	}
}
