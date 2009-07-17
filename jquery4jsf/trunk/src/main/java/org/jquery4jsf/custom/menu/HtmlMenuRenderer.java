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
package org.jquery4jsf.custom.menu;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;

import org.jquery4jsf.custom.icon.Icon;
import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.MessageFactory;
import org.jquery4jsf.utilities.TextUtilities;


public class HtmlMenuRenderer extends HtmlMenuBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        HtmlMenu htmlMenu = null;
        if(component instanceof HtmlMenu)
        	htmlMenu = (HtmlMenu)component;
        
        encodeResources(htmlMenu);
        encodeHtmlMenuScript(context, htmlMenu);
        encodeHtmlMenuMarkup(context, htmlMenu);
        
	}
	
	protected void encodeHtmlMenuMarkup(FacesContext context, HtmlMenu htmlMenu) throws IOException
	{
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.write("\n");
        responseWriter.startElement(HTML.TAG_A, null);
        responseWriter.writeAttribute("tabindex","0", null);
        writeIdAttributeIfNecessary(context, responseWriter, htmlMenu);
        responseWriter.writeAttribute("class", "fg-button fg-button-icon-right ui-widget ui-state-default ui-corner-all", null);
        responseWriter.writeAttribute("href","#menudiv-".concat(htmlMenu.getId()), null);
        encodeIcon(context, htmlMenu);
        responseWriter.writeText(htmlMenu.getLabel(), null);
        responseWriter.endElement(HTML.TAG_A);
        responseWriter.write("\n");
        responseWriter.startElement(HTML.TAG_DIV, null);
        responseWriter.writeAttribute("id","menudiv-".concat(htmlMenu.getId()), null);
        responseWriter.writeAttribute("class", "fg-menu-hidden", null);
        responseWriter.write("\n");
        encodeSubMenu(context, htmlMenu);
        responseWriter.write("\n");
        responseWriter.endElement(HTML.TAG_DIV);
        responseWriter.write("\n");
	}
	
	protected void encodeHtmlMenuScript(FacesContext context, HtmlMenu htmlMenu) throws IOException{
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();
        function.addJSElement(getJSElement(context, htmlMenu));
        documentElement.addFunctionToReady(function);
	}
	
	private void encodeSubMenu(FacesContext context, UIComponent component) throws IOException{
		ResponseWriter writer = context.getResponseWriter();
		List submenus = component.getChildren();
		writer.write("\n");
		writer.startElement(HTML.TAG_UL, null);
		writer.write("\t");
		for (int i=0; i < submenus.size(); i++) {
			MenuItem submenu = (MenuItem) submenus.get(i);
			encodeMenuItem(context, submenu);
		}
		writer.endElement(HTML.TAG_UL);
	}

	private void encodeMenuItem(FacesContext context, MenuItem submenu) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		UIComponent icon = submenu.getFacet("icon");
		writer.write("\n\t\t");
		writer.startElement(HTML.TAG_LI, null);
		if (!submenu.isDisabled()){
			if (!TextUtilities.isStringVuota((String) submenu.getValue())){
				writer.startElement(HTML.TAG_A, null);
				writer.writeAttribute("href", submenu.getValue(), null);
				if (icon != null){
					icon.encodeBegin(context);
					icon.encodeChildren(context);
					icon.encodeEnd(context);
				}
				writer.writeText(submenu.getLabel(), null);
				writer.endElement(HTML.TAG_A);
			}
			else if (submenu.isAjaxSubmit()){
				writer.startElement(HTML.TAG_A, null);
				writer.writeAttribute("href", "#", null);
				String ajaxRequest = getAjaxRequest(context, submenu);
				writer.writeAttribute("onclick", ajaxRequest, null);
				writer.writeText(submenu.getLabel(), null);
				writer.endElement(HTML.TAG_A);
			}
			else if (submenu.getAction() != null || submenu.getActionListeners().length > 0){
				//TODO da implementare
				writer.startElement(HTML.TAG_A, null);
				writer.writeAttribute("href", "#", null);
				String ajaxRequest = getAjaxRequest(context, submenu);
				writer.writeAttribute("onclick", ajaxRequest, null);
				writer.writeText(submenu.getLabel(), null);
				writer.endElement(HTML.TAG_A);
			}
			else{
				writer.startElement(HTML.TAG_A, null);
				writer.writeAttribute("href", "#", null);
				writer.writeText(submenu.getLabel(), null);
				writer.endElement(HTML.TAG_A);
			}
			if (submenu.getChildren() != null 
					&& !submenu.getChildren().isEmpty()){
				encodeSubMenu(context, submenu);
			}
		}
		else{
			writer.writeAttribute("class","fg-button ui-state-default ui-state-disabled ui-corner-all" , null);
			writer.startElement(HTML.TAG_SPAN, null);
			writer.writeText(submenu.getLabel(), null);
			writer.endElement(HTML.TAG_SPAN);
		}
		writer.endElement(HTML.TAG_LI);
	}

	private String getAjaxRequest(FacesContext context, MenuItem submenu) {
		UIForm form = RendererUtilities.getForm(context, submenu);
		String formId = RendererUtilities.getJQueryId(form.getClientId(context));
		String ajaxRequest = RendererUtilities.getJQueryVarWidget()+"('" + formId +"').ajaxSubmit("+encodeOptionComponent(new StringBuffer(), submenu, context) +"); return false;";
		return ajaxRequest;
	}

	private void encodeIcon(FacesContext context, HtmlMenu htmlMenu) throws IOException{
		 UIComponent icon = htmlMenu.getFacet("icon");
		 if (icon != null){
			 icon.encodeBegin(context);
			 icon.encodeChildren(context);
			 icon.encodeEnd(context);
		 }
		 else{
			 Icon iconComponent = new Icon();
			 iconComponent.setParent(htmlMenu);
			 iconComponent.setId(htmlMenu.getId().concat("icon"));
			 iconComponent.setType("triangle-1-s");
			 iconComponent.encodeBegin(context);
			 iconComponent.encodeChildren(context);
			 iconComponent.encodeEnd(context);
		 }
	}
	
	public boolean getRendersChildren() {
		return true;
	}

	public void encodeChildren(FacesContext arg0, UIComponent arg1) throws IOException {
	}
	
	protected String encodeOptionComponent(StringBuffer options, HtmlMenu htmlMenu , FacesContext context) {
		options.append(" {\n");
		String content = RendererUtilities.getJQueryVarWidget()+"('"+RendererUtilities.getJQueryId(htmlMenu.getClientId(context)) +"').next().html()";
		encodeOptionComponentByType(options,content, "content", null);
		encodeOptionComponentByType(options, htmlMenu.getWidth(), "width", null);
		encodeOptionComponentByType(options, htmlMenu.getMaxHeight(), "maxHeight", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsPosX(), "posX", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsPosY(), "posY", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsOffsetX(), "offsetX", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsOffsetY(), "offsetY", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsDirectionH(), "directionH", null);
		encodeOptionComponentByType(options, htmlMenu.getPositionOptsDirectionV(), "directionV", null);
		encodeOptionComponentByType(options, htmlMenu.isPositionOptsDetectH(), "detectH", null);
		encodeOptionComponentByType(options, htmlMenu.isPositionOptsDetectV(), "detectV", null);
		encodeOptionComponentByType(options, htmlMenu.isPositionOptsLinkToFront(), "linkToFront", null);
		encodeOptionComponentByType(options, htmlMenu.getShowSpeed(), "showSpeed", null);
		encodeOptionComponentByType(options, htmlMenu.getCallerOnStateClass(), "callerOnState", null);
		encodeOptionComponentByType(options, htmlMenu.getLoadingStateClass(), "loadingState", null);
		encodeOptionComponentByType(options, htmlMenu.getLinkHoverClass(), "linkHover", null);
		encodeOptionComponentByType(options, htmlMenu.getLinkHoverSecondaryClass(), "linkHoverSecondary", null);
		encodeOptionComponentByType(options, htmlMenu.getCrossSpeed(), "crossSpeed", null);
		encodeOptionComponentByType(options, htmlMenu.getCrumbDefaultText(), "crumbDefaultText", null);
		encodeOptionComponentByType(options, htmlMenu.isBackLink(), "backLink", "true");
		encodeOptionComponentByType(options, htmlMenu.getBackLinkText(), "backLinkText", null);
		encodeOptionComponentByType(options, htmlMenu.isFlyOut(), "flyOut", null);
		encodeOptionComponentByType(options, htmlMenu.getFlyOutOnStateClass(), "flyOutOnState", null);
		encodeOptionComponentByType(options, htmlMenu.getNextMenuLinkClass(), "nextMenuLink", null);
		encodeOptionComponentByType(options, htmlMenu.getTopLinkText(), "topLinkText", null);
		encodeOptionComponentByType(options, htmlMenu.getNextCrumbLinkClass(), "nextCrumbLink", null);
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
	
	protected String encodeOptionComponent(StringBuffer options, MenuItem submenu , FacesContext context) {
		options.append(" {\n");
		String target = submenu.getTarget();
		String clientId = submenu.getClientId(context);;
		if (target == null || target.trim().length() == 0){
			target = null;
		}else{
			target = RendererUtilities.getClientIdForComponent(target, context, submenu);
		}
		String actionURL = RendererUtilities.getActionURL(context);
		if(actionURL.indexOf("?") == -1)
		{
			actionURL = actionURL + "?ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + target;
		}
		else
		{
			actionURL = actionURL + "&ajaxSourceJQuery=" + clientId +"&ajaxUpdate=" + target ;
		}
		encodeOptionComponentByType(options, actionURL, "url", null);
		String targetJQ = null;
		if(target != null){
			targetJQ = RendererUtilities.getJQueryId(target);
		}
		else{
			UIForm form = RendererUtilities.getForm(context, submenu);
			targetJQ = RendererUtilities.getJQueryId(form.getClientId(context));
		}
		encodeOptionComponentByType(options,targetJQ, "target", null);
		encodeOptionComponentByType(options, clientId , "buttonSubmit", "");
		String extraParams = encodeOptionsWithUIParam(submenu);
		if (!TextUtilities.isStringVuota(extraParams)){
			encodeOptionComponentByType(options, extraParams , "data", null);
		}
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
	
	public void decode(FacesContext context, UIComponent component) {
		if(context == null || component == null)
			throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));

		HtmlMenu menu = null;
		if(component instanceof HtmlMenu)
			menu = (HtmlMenu)component;
		String clientId = component.getClientId(context);
		Map map = context.getExternalContext().getRequestParameterMap();
		String s1 = (String)map.get(clientId);
		if(s1 == null)
			return;
		menu.queueEvent(new ActionEvent(component));
		return;

	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        HtmlMenu htmlMenu = null;
        if(component instanceof HtmlMenu)
        	htmlMenu = (HtmlMenu)component;
        JSElement element = new JSElement(htmlMenu.getClientId(context));
        JSAttribute jsMenuBar = new JSAttribute("menu", false);
        StringBuffer sbOption = new StringBuffer();
        jsMenuBar.addValue(encodeOptionComponent(sbOption, htmlMenu, context));
        element.addAttribute(jsMenuBar);
		return element;
	}
}