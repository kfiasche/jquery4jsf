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
package org.jquery4jsf.renderkit;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.utilities.TextUtilities;

public class RendererUtilities {
	
	public static String getFormId(FacesContext context, UIComponent component)
	{
		while (component != null && !(component instanceof UIForm))
		{
			component = component.getParent();
		}
		
		if (component instanceof UIForm)
		{
			return ((UIForm) component).getId();
		}
		
		return null;
	}
	
	public static UIForm getForm(FacesContext context, UIComponent component)
	{
		while (component != null && !(component instanceof UIForm))
		{
			component = component.getParent();
		}
		if (component instanceof UIForm)
		{
			return ((UIForm) component);
		}
		return null;
	}

	public static void addJsForJQuery(UIComponent component, ResponseWriter responseWriter, FacesContext context) throws IOException {
		responseWriter.startElement(HTML.TAG_SCRIPT, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/javascript", null);
		responseWriter.writeAttribute(HTML.LANGUAGE, "javascript", null);
		String contextPath = context.getExternalContext().getRequestContextPath();
		responseWriter.writeAttribute(HTML.SRC,contextPath.concat("/jquery4jsf_resource/jquery/jquery.js"), null);	
		responseWriter.endElement(HTML.TAG_SCRIPT);
		responseWriter.write("\n");
	}

	public static void addJsForJQueryPlugin(UIComponent component, ResponseWriter responseWriter, FacesContext context, String string) throws IOException {
		responseWriter.startElement(HTML.TAG_SCRIPT, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/javascript", null);
		responseWriter.writeAttribute(HTML.LANGUAGE, "javascript", null);
		String contextPath = context.getExternalContext().getRequestContextPath();
		responseWriter.writeAttribute(HTML.SRC,contextPath.concat("/jquery4jsf_resource/".concat(string)), null);	
		responseWriter.endElement(HTML.TAG_SCRIPT);
		responseWriter.write("\n");
	}

	public static void addCssForJQueryPlugin(UIComponent component, ResponseWriter responseWriter, FacesContext context, String string) throws IOException {
		responseWriter.startElement(HTML.TAG_LINK, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/css", null);
		responseWriter.writeAttribute(HTML.REL, "stylesheet", null);
		String contextPath = context.getExternalContext().getRequestContextPath();
		responseWriter.writeAttribute(HTML.HREF,contextPath.concat("/jquery4jsf_resource/".concat(string)), null);
		responseWriter.writeAttribute(HTML.MEDIA, "screen", null);
		responseWriter.endElement(HTML.TAG_LINK);
		responseWriter.write("\n");
	}

	public static void encodeResourceForComponent(UIComponent component,FacesContext context, ResponseWriter responseWriter) throws IOException{
		JQueryHtmlObject jQueryObject = (JQueryHtmlObject)component;
		String[] resources = jQueryObject.getResources();
		for (int i = 0; i < resources.length; i++) {
			String resource = resources[i];
			if (resource.endsWith(".css")){
				String theme   = context.getExternalContext().getInitParameter("ThemeCSS");
				if (theme == null){
					theme = "base";
				}
				String resourceChange = resource.replaceFirst("base", theme);
				addCssForJQueryPlugin(component, responseWriter, context, resourceChange);
			}
			else if (resource.endsWith(".js")){
				addJsForJQueryPlugin(component, responseWriter, context, resource);
			}
		}
	}
	
	public static void createTagScriptForJs(UIComponent component, ResponseWriter responseWriter, StringBuffer sb) throws IOException {
		responseWriter.startElement(HTML.TAG_SCRIPT, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/javascript", null);
		responseWriter.writeAttribute(HTML.LANGUAGE, "javascript", null);
		responseWriter.write(sb.toString());
		responseWriter.endElement(HTML.TAG_SCRIPT);
		responseWriter.write("\n");
	}

	public static void renderChildren(FacesContext facesContext, UIComponent component) throws IOException {
		if ( component.getChildren() == null ||  component.getChildren().isEmpty())
			return;
		for (Iterator iterator = component.getChildren().iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			renderChild(facesContext, child);
		}
	}

	public static void renderChild(FacesContext facesContext, UIComponent child) throws IOException {
		if (!child.isRendered()) {
			return;
		}
		child.encodeBegin(facesContext);
		if (child.getRendersChildren()) {
			child.encodeChildren(facesContext);
		} else {
			renderChildren(facesContext, child);
		}
		child.encodeEnd(facesContext);
	}
	
	public static String getActionURL(FacesContext facesContext) {
		String actionURL = facesContext.getApplication().getViewHandler().getActionURL(facesContext, facesContext.getViewRoot().getViewId());
		String url = facesContext.getExternalContext().encodeResourceURL(actionURL);
		return url;
	}
	
	public static void createOptionComponentByType(StringBuffer sb, boolean value, String nameParameter, Object defaultValue){
		createOptionComponentByType(sb, new Boolean(value), nameParameter, defaultValue);
	}
	
	public static void createOptionComponentByType(StringBuffer sb, int value, String nameParameter, Object defaultValue){
		createOptionComponentByType(sb, new Integer(value), nameParameter, defaultValue);
	}
	
	public static void createOptionComponentByType(StringBuffer sb, Object value, String nameParameter, Object defaultValue){
		if (value != null){
			if (value instanceof String){
				String s = (String)value;
				if (nameParameter.substring(0,2).equalsIgnoreCase("on")){
					createOptionComponentFunction(sb, s, nameParameter);
				}
				else if (s.startsWith("{") && s.endsWith("}")){
					createOptionComponentOptionsByType(sb, s, nameParameter);
				}
				else{
					createOptionComponentStringByType(sb, s, nameParameter);
				}
			}
			else if (value instanceof Integer){
				Integer iValue = ((Integer)value);
				Integer iDefaultValue = null;
				if (defaultValue != null){
					iDefaultValue = Integer.valueOf((String) defaultValue);
				}
				else{
					iDefaultValue = new Integer(0);
				}
				if (!iValue.equals(iDefaultValue)){
					String s = iValue.toString();
					sb.append(nameParameter.concat(": ").concat(s).concat(", \n"));
				}
			}
			else if (value instanceof Boolean){
				Boolean bDefaultValue = null;
				Boolean bValue = ((Boolean)value);
				if (defaultValue != null)
				{
					bDefaultValue = Boolean.valueOf((String)defaultValue);
				}
				else{
					bDefaultValue = Boolean.FALSE;
				}
				if (bValue.booleanValue() && bDefaultValue.booleanValue()){
					
				}else if (bValue.booleanValue() || bDefaultValue.booleanValue()){
					String s = bValue.toString();
					sb.append(nameParameter.concat(": ").concat(s).concat(", \n"));
				}
				
			}
		}
	}
	
	public static void createOptionComponentOptionsByType(StringBuffer options, String value, String nameParameter) {
		if (value != null){
			options.append(nameParameter.concat(": "));
			options.append(value);
			options.append(", \n");
		}
	}
	
	public static void createOptionComponentFunction(StringBuffer options, String value, String nameParameter) {
		if (value != null){
			options.append(cleanPrefixFunction(nameParameter).concat(": function() {\n"));
			options.append(value);
			options.append("\n}");
			options.append(", \n");
		}
	}
	
	private static String cleanPrefixFunction(String nomeParameter){
		return nomeParameter.substring(2);
	}
	
	public static void createOptionComponentArrayByType(StringBuffer options, String value, String nameParameter) {
		if (value != null){
			options.append(nameParameter.concat(": ["));
			String values[] = value.split(",");
			for (int i = 0; i < values.length; i++) {
				String arrayElement = values[i];
				if (TextUtilities.isNumber(arrayElement)){
					options.append("".concat(value).concat(""));
				}
				else
				{
					options.append("'".concat(value).concat("'"));
				}
				if (i != values.length-1){
					options.append(", ");
				}
			}
			options.append("], \n");
		}
	}
	
	private static void createOptionComponentStringByType(StringBuffer options, String value, String nameParameter){
		if (value != null){
			if (TextUtilities.isNumber(value)){
				options.append(nameParameter.concat(": "));
				options.append(value);
				options.append(", \n");
			}
			else
			{
				options.append(nameParameter.concat(": '"));
				options.append(value);
				options.append("', \n");
			}
		}
	}
	
	public static String getClientIdForComponent(String forAttr,FacesContext facesContext, UIComponent uiComponent) {
		if (forAttr == null)
			return null;
		UIComponent forComponent = uiComponent.findComponent(forAttr);
		if (forComponent == null) {
			if (forAttr.length() > 0
					&& forAttr.charAt(0) == NamingContainer.SEPARATOR_CHAR) {
				// absolute id path
				return forAttr.substring(1);
			} else {
				// relative id path, we assume a component on the same level
				// as the label component
				String labelClientId = uiComponent.getClientId(facesContext);
				int colon = labelClientId.lastIndexOf(NamingContainer.SEPARATOR_CHAR);
				if (colon == -1) {
					return forAttr;
				} else {
					return labelClientId.substring(0, colon + 1) + forAttr;
				}
			}
		} else {
			return forComponent.getClientId(facesContext);
		}
	}
	
	public static String getJQueryIdComponent(String id, FacesContext facesContext, UIComponent component){
		String idClient = getClientIdForComponent(id, facesContext, component);
		if (idClient == null)
			return null;
		return "#" + idClient.replaceAll(":", "\\\\\\\\:");
	}
	
	
	public static String getJQueryIdComponent(FacesContext facesContext, UIComponent component){
		return "#" + component.getClientId(facesContext).replaceAll(":", "\\\\\\\\:");
	}
	
	public static String getJQueryId(String id){
		return "#" + id.replaceAll(":", "\\\\\\\\:");
	}
}
