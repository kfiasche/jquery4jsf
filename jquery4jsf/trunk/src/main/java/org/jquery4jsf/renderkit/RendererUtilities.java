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
import java.util.List;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.el.ValueBinding;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.custom.UIInteractions;
import org.jquery4jsf.custom.ajax.AjaxEvent;
import org.jquery4jsf.renderkit.html.HTML;
import org.jquery4jsf.resource.ResourceContext;
import org.jquery4jsf.resource.ResourceCostants;
import org.jquery4jsf.utilities.TextUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RendererUtilities {
	
	private static Logger logger = LoggerFactory.getLogger(RendererUtilities.class);
	
	public static void encodeAjaxEventChild(FacesContext context, UIComponent component) throws IOException{
		List children = component.getChildren();
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			if (child instanceof AjaxEvent) {
				AjaxEvent ajaxEvent = (AjaxEvent) child;
				ajaxEvent.encodeBegin(context);
				ajaxEvent.encodeChildren(context);
				ajaxEvent.encodeEnd(context);
			}
		}
	}
	
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
		responseWriter.writeAttribute(HTML.SRC,getResourceURL(context, "jquery/jquery.js"), null);	
		responseWriter.endElement(HTML.TAG_SCRIPT);
		responseWriter.write("\n");
	}

	public static void addJsForJQueryPlugin(UIComponent component, ResponseWriter responseWriter, FacesContext context, String string) throws IOException {
		responseWriter.startElement(HTML.TAG_SCRIPT, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/javascript", null);
		responseWriter.writeAttribute(HTML.LANGUAGE, "javascript", null);
		responseWriter.writeAttribute(HTML.SRC,getResourceURL(context, string), null);	
		responseWriter.endElement(HTML.TAG_SCRIPT);
		responseWriter.write("\n");
	}

	public static void addCssForJQueryPlugin(UIComponent component, ResponseWriter responseWriter, FacesContext context, String string) throws IOException {
		responseWriter.startElement(HTML.TAG_LINK, component);
		responseWriter.writeAttribute(HTML.TYPE, "text/css", null);
		responseWriter.writeAttribute(HTML.REL, "stylesheet", null);
		responseWriter.writeAttribute(HTML.HREF, getResourceURL(context, string), null);
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
	
	public static void encodeImportJavascripScript(UIComponent component, ResponseWriter responseWriter, StringBuffer sb) throws IOException {
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
					createOptionComponentFunction(sb, s, nameParameter, null);
				}
				else if (s.startsWith("{") && s.endsWith("}")){
					createOptionComponentOptionsByType(sb, s, nameParameter);
				}
				else if (s.startsWith("$") && (s.endsWith(")") || s.endsWith(");"))){
					createOptionComponentJQueryByType(sb, s, nameParameter);
				}
				else if (s.startsWith("[") && s.endsWith("]")){
					createOptionComponentArrayByType(sb, s, nameParameter);
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
	
	private static void createOptionComponentJQueryByType(StringBuffer sb, String s, String nameParameter) {
		if (s != null){
			sb.append(nameParameter.concat(": "));
			sb.append(s);
			sb.append(", \n");
		}
	}

	public static void createOptionComponentOptionsByType(StringBuffer options, String value, String nameParameter) {
		if (value != null && !TextUtilities.isStringVuota(value)){
			options.append(nameParameter.concat(": {\n"));
			options.append("\t");
			if (value.endsWith(", \n")){
				String stringa = value.substring(0, value.length()-3);
				options.append(stringa);
			}
			else{
				String cln = TextUtilities.cleanString(value);
				if (cln.startsWith("{") && cln.endsWith("}")){
					String stringa = value.substring(1).substring(0, value.length()-2);
					options.append(stringa);
				}
				else
				{
					options.append(value);
				}
			}
			options.append("}, \n");
		}
	}
	
	public static void createOptionComponentFunction(StringBuffer options, String value, String nameParameter, String params) {
		if (value != null){
			if (TextUtilities.isStringVuota(params)){
				options.append(cleanPrefixFunction(nameParameter).concat(": function() {\n"));
			}else{
				options.append(cleanPrefixFunction(nameParameter).concat(": function("));
				options.append(params);
				options.append(") {\n");
			}
			options.append(value);
			options.append("\n}");
			options.append(", \n");
		}
	}
	
	private static String cleanPrefixFunction(String nomeParameter){
		if (nomeParameter.startsWith("on"))
			return nomeParameter.substring(2);
		else
			return nomeParameter;
	}
	
	public static void createOptionComponentArrayByType(StringBuffer options, String value, String nameParameter) {
		if (!TextUtilities.isStringVuota(value)
				&& TextUtilities.isArray(value)){
			value = TextUtilities.cleanStringArrayChar(value);
			options.append(nameParameter.concat(": ["));
			String values[] = value.split(",");
			for (int i = 0; i < values.length; i++) {
				String arrayElement = values[i];
				if (TextUtilities.isNumber(arrayElement) || TextUtilities.isBoolean(arrayElement)){
					options.append("".concat(arrayElement).concat(""));
				}
				else
				{
					options.append("'".concat(arrayElement).concat("'"));
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
			else if (TextUtilities.isBoolean(value))
			{
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
//		if (forAttr == null)
//			return null;
//		UIComponent forComponent = uiComponent.findComponent(forAttr);
//		if (forComponent == null) {
//			if (forAttr.length() > 0
//					&& forAttr.charAt(0) == NamingContainer.SEPARATOR_CHAR) {
//				// absolute id path
//				return forAttr.substring(1);
//			} else {
//				// relative id path, we assume a component on the same level
//				// as the label component
//				String labelClientId = uiComponent.getClientId(facesContext);
//				int colon = labelClientId.lastIndexOf(NamingContainer.SEPARATOR_CHAR);
//				if (colon == -1) {
//					return forAttr;
//				} else {
//					return labelClientId.substring(0, colon + 1) + forAttr;
//				}
//			}
//		} else {
//			return forComponent.getClientId(facesContext);
//		}
		if (forAttr == null)
			return null;
		UIComponent component = ComponentUtilities.findComponentInRoot(forAttr);
		if (component == null)
			return null;
		else
			return component.getClientId(facesContext);
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
	
	public static String writeIdAttributeIfNecessary(FacesContext context,ResponseWriter writer, UIComponent component) {
		String id = null;
		if (shouldWriteIdAttribute(component)) {
			try {
				id = component.getClientId(context);
				writer.writeAttribute("id", id, "id");
			} catch (IOException e) {
				System.out.println("Can't write ID attribute" + e.getMessage());
			}
		}
		return id;
	}
	
	public static boolean shouldWriteIdAttribute(UIComponent component) {
		String id;
		return (null != (id = component.getId()) && !id.startsWith(UIViewRoot.UNIQUE_ID_PREFIX));
	}
	
	public static String getResourceURL(FacesContext facesContext, String resource) {
		String contextPath = facesContext.getExternalContext().getRequestContextPath();
		return contextPath + ResourceCostants.RESOURCE_PATTERN + resource;
	}
	
	public static String encodeIdInteractions(UIComponent component, FacesContext context){
		if (!(component instanceof UIInteractions)){
			throw new IllegalArgumentException();	
		}
		UIInteractions interactions = (UIInteractions)component;
		String clientId = "";
		UIComponent parent = component.getParent();
        if (!TextUtilities.isStringVuota(interactions.getFor())){
        	clientId = getJQueryIdComponent(interactions.getFor(), context, component);
        	if (clientId == null){
        		// selector ????
        		clientId = interactions.getFor();
        	}
        }
        else if (!isUniqueId(component)
        			&& !(parent instanceof UIForm || parent instanceof UIViewRoot)){
        		clientId = parent.getClientId(context);
        }
        else{
        	clientId = component.getClientId(context);
        }
        return clientId;
	}
	
	public static boolean isUniqueId(UIComponent component){
		return (component.getId() != null && !component.getId().startsWith(
				UIViewRoot.UNIQUE_ID_PREFIX));
	}
	
	public static String encodeOptionsWithUIParam(UIComponent component){
		List children = component.getChildren();
		StringBuffer options = new StringBuffer();
		options.append("{");
		for (Iterator iterator = children.iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			if(child instanceof UIParameter) {
				UIParameter param = (UIParameter) child;
				List childrenParam = param.getChildren();
				if (childrenParam == null || childrenParam.isEmpty())
				{	
					createOptionComponentByType(options, param.getValue(), param.getName(), null);
				}
				else
				{
					 String value = encodeOptionsWithUIParam(param);
					 createOptionComponentOptionsByType(options, value, param.getName());
				}
			}
		}
		if (options.toString().endsWith(", \n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (options.toString().endsWith(" {\n")){
			String stringa = options.substring(0, options.length()-4);
			options = new StringBuffer(stringa);
			noParams = true;
		}
		if (!noParams)
		{
			options.append(" }");
		}
		return options.toString();
	}

	public static void encodeResources(JQueryHtmlObject jqcomponent) {
        String[] list = jqcomponent.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
	}
	
	public static Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue)throws ConverterException {
		if (submittedValue instanceof String) {
			Converter converter = getConverter(context, component);
			if (converter != null) {
				return converter.getAsObject(context, component, (String) submittedValue);
			}
		}
		return submittedValue;
	}

	public static Converter getConverter(FacesContext context, UIComponent component) {
		Converter converter = null;
		if (component instanceof ValueHolder) {
			converter = ((ValueHolder) component).getConverter();
		}
		if (converter == null) {
			ValueBinding valueBinding = component.getValueBinding("value");
			if (valueBinding != null) {
				Class converterType = valueBinding.getType(context);
				if (converterType == null 
						|| converterType == String.class 
						|| converterType == Object.class) {
					return null;
				}
				try {
					converter = context.getApplication().createConverter(converterType);
				} catch (FacesException e) {
					logger.error("Non è stato trovato il converter per questa tipo di classe: "+converterType);
				}
			}
		}
		return converter;
	}

}
