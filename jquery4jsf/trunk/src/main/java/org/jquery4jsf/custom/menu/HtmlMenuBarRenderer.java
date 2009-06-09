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
package org.jquery4jsf.custom.menu;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.icon.Icon;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.utilities.MessageFactory;
public class HtmlMenuBarRenderer extends HtmlMenuBarBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        HtmlMenuBar menuBar = null;
        if(component instanceof HtmlMenuBar)
        	menuBar = (HtmlMenuBar)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = menuBar.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        JSDocumentElement documentElement = new JSDocumentElement();
        JSElement element = new JSElement(menuBar.getClientId(context));
        JSAttribute jsMenuBar = new JSAttribute("menu", false);
        StringBuffer sbOption = new StringBuffer();
        jsMenuBar.addValue(encodeOptionComponent(sbOption, menuBar, context));
        element.addAttribute(jsMenuBar);
        JSFunction function = new JSFunction();
        function.addJSElement(element);
        documentElement.addFunctionToReady(function);
        sb.append(documentElement.toJavaScriptCode());
        sb.append("\n");
        RendererUtilities.encodeImportJavascripScript(component, responseWriter, sb);
        
        //<a tabindex="0" href="#search-engines" class="fg-button fg-button-icon-right ui-widget ui-state-default ui-corner-all" id="flat">
        //<span class="ui-icon ui-icon-triangle-1-s"></span>
        //flat menu</a>

       
        responseWriter.startElement(HTML.TAG_A, null);
        responseWriter.writeAttribute("tabindex","0", null);
        writeIdAttributeIfNecessary(context, responseWriter, component);
        responseWriter.writeAttribute("class", "ui-button ui-button-icon-right ui-widget ui-state-default ui-corner-all", null);
        responseWriter.writeAttribute("href","#menudiv-".concat(menuBar.getId()), null);
        encodeIcon(context, menuBar);
        //responseWriter.writeText(menuBar.getLabel(), null);
        responseWriter.endElement(HTML.TAG_A);
        responseWriter.startElement(HTML.TAG_DIV, null);
        responseWriter.writeAttribute("id","menudiv-".concat(menuBar.getId()), null);
        responseWriter.writeAttribute("class", "fg-menu-hidden", null);
        encodeSubMenu(context, component);
        responseWriter.endElement(HTML.TAG_DIV);
	}
	
	private void encodeSubMenu(FacesContext context, UIComponent component) throws IOException{
		ResponseWriter writer = context.getResponseWriter();
		List submenus = component.getChildren();
		writer.startElement(HTML.TAG_UL, null);
		for (int i=0; i < submenus.size(); i++) {
			MenuItem submenu = (MenuItem) submenus.get(i);
			encodeMenuItem(context, submenu);
		}
		writer.endElement(HTML.TAG_UL);
	}

	private void encodeMenuItem(FacesContext context, MenuItem submenu) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		UIComponent icon = submenu.getFacet("icon");
		writer.startElement(HTML.TAG_LI, null);
		if (!submenu.isDisabled()){
			writer.startElement(HTML.TAG_A, null);
			writer.writeAttribute("href", "#", null);
			if (icon != null){
				icon.encodeBegin(context);
				icon.encodeChildren(context);
				icon.encodeEnd(context);
			}
			writer.writeText(submenu.getLabel(), null);
			writer.endElement(HTML.TAG_A);
			if (submenu.getChildren() != null 
					&& !submenu.getChildren().isEmpty()){
				encodeSubMenu(context, submenu);
			}
		}
		else{
			writer.writeAttribute("class","ui-button ui-state-default ui-state-disabled ui-corner-all" , null);
			writer.startElement(HTML.TAG_SPAN, null);
			writer.writeText(submenu.getLabel(), null);
			writer.endElement(HTML.TAG_SPAN);
		}
		writer.endElement(HTML.TAG_LI);
	}

	private void encodeIcon(FacesContext context, HtmlMenuBar menuBar) throws IOException{
		 UIComponent icon = menuBar.getFacet("icon");
		 if (icon != null){
			 icon.encodeBegin(context);
			 icon.encodeChildren(context);
			 icon.encodeEnd(context);
		 }
		 else{
			 Icon iconComponent = new Icon();
			 iconComponent.setParent(menuBar);
			 iconComponent.setId(menuBar.getId().concat("icon"));
			 iconComponent.setType("triangle-1-s");
			 iconComponent.encodeBegin(context);
			 iconComponent.encodeChildren(context);
			 iconComponent.encodeEnd(context);
		 }
	}
	
	public boolean getRendersChildren() {
		return true;
	}

//	protected String encodeOptionComponent(StringBuffer options, HtmlMenuBar htmlMenuBar , FacesContext context) {
//		options.append(" {\n");
//		String content = "$('"+RendererUtilities.getJQueryId(htmlMenuBar.getClientId(context)) +"').next().html()";
//		encodeOptionComponentByType(options, content, "content", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getWidth(), "width", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getMaxHeight(), "maxHeight", null);
//		StringBuffer positionOpts = new StringBuffer();
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.getPositionOptsPosX(), "posX", null);
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.getPositionOptsPosY(), "posY", null);
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.getPositionOptsOffsetX(), "offsetX", null);
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.getPositionOptsOffsetY(), "offsetY", null);
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.getPositionOptsDirectionH(), "directionH", null);
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.getPositionOptsDirectionV(), "directionV", null);
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.isPositionOptsDetectH(), "detectH", null);
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.isPositionOptsDetectV(), "detectV", null);
//		encodeOptionComponentByType(positionOpts, htmlMenuBar.isPositionOptsLinkToFront(), "linkToFront", null);
//		encodeOptionComponentOptionsByType(options, positionOpts.toString(), "position", null);
//		
//		encodeOptionComponentByType(options, htmlMenuBar.getShowSpeed(), "showSpeed", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getCallerOnStateClass(), "callerOnState", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getLoadingStateClass(), "loadingState", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getLinkHoverClass(), "linkHover", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getLinkHoverSecondaryClass(), "linkHoverSecondary", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getCrossSpeed(), "crossSpeed", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getCrumbDefaultText(), "crumbDefaultText", null);
//		encodeOptionComponentByType(options, htmlMenuBar.isBackLink(), "backLink", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getBackLinkText(), "backLinkText", null);
//		encodeOptionComponentByType(options, htmlMenuBar.isFlyOut(), "flyOut", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getFlyOutOnStateClass(), "flyOutOnState", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getNextMenuLinkClass(), "nextMenuLink", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getTopLinkText(), "topLinkText", null);
//		encodeOptionComponentByType(options, htmlMenuBar.getNextCrumbLinkClass(), "nextCrumbLink", null);
//		if (options.toString().endsWith(", \n")){
//			String stringa = options.substring(0, options.length()-3);
//			options = new StringBuffer(stringa);
//		}
//		boolean noParams = false;
//		if (options.toString().endsWith(" {\n")){
//			String stringa = options.substring(0, options.length()-3);
//			options = new StringBuffer(stringa);
//			noParams = true;
//		}
//		if (!noParams)
//		{
//			options.append(" }");
//		}
//		return options.toString();
//	}
	
	
}
