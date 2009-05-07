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
package org.jquery4jsf.custom.ajax;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.event.JSHideEvent;
import org.jquery4jsf.javascript.event.JSShowEvent;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.resource.ResourceContext;

import com.sun.faces.util.Util;

public class AjaxStatusRenderer extends AjaxStatusBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(Util.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;

        AjaxStatus ajaxStatus = null;
        if(component instanceof AjaxStatus)
            ajaxStatus = (AjaxStatus)component;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        
        // TODO devo trovare il modo per scrivere i script nell'head
        String[] list = ajaxStatus.getResources();
        for (int i = 0; i < list.length; i++) {
			String resource = list[i];
			ResourceContext.getInstance().addResource(resource);
		}
        
        String clientId = ajaxStatus.getClientId(context);
        encodeScriptWidget(responseWriter, clientId, ajaxStatus, context);
        responseWriter.write("\n");
        responseWriter.startElement("div", null);
        responseWriter.writeAttribute("id", clientId, null);
		encodeFacet(responseWriter, clientId, ajaxStatus, context, "start");
		encodeFacet(responseWriter, clientId, ajaxStatus, context, "error");
		encodeFacet(responseWriter, clientId, ajaxStatus, context, "success");
		encodeFacet(responseWriter, clientId, ajaxStatus, context, "complete");
		encodeFacet(responseWriter, clientId, ajaxStatus, context, "stop");
		responseWriter.endElement("div");
		responseWriter.write("\n");
	}

	
	
	private void encodeFacet(ResponseWriter responseWriter, String clientId, AjaxStatus ajaxStatus, FacesContext context, String facetName) throws IOException{
		responseWriter.write("\n");
		responseWriter.startElement("span", null);
		responseWriter.writeAttribute("id", clientId + ":" + facetName, null);
		responseWriter.writeAttribute("style", "display:none", null);
		UIComponent component = ajaxStatus.getFacet(facetName);
		if(component != null) {
			RendererUtilities.renderChild(context, component);
		}
		responseWriter.endElement("span");
		responseWriter.write("\n");
	}
	
	private void encodeScriptWidget(ResponseWriter responseWriter, String clientId, AjaxStatus ajaxStatus, FacesContext context) throws IOException {
		UIComponent start = ajaxStatus.getFacet("start");
		UIComponent complete = ajaxStatus.getFacet("complete");
		UIComponent error = ajaxStatus.getFacet("error");
		UIComponent success = ajaxStatus.getFacet("success");
		UIComponent stop = ajaxStatus.getFacet("stop");
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
		JSDocumentElement documentElement = new JSDocumentElement();
		JSFunction jsFunction = new JSFunction();
		JSElement element = new JSElement(clientId);
		if (start != null){
			StringBuffer sbAjaxStart = new StringBuffer();
			sbAjaxStart.append("'ajaxStart', ");
			JSAttribute attribute = new JSAttribute("bind", false);
			JSFunction function = new JSFunction();
			//complete
			if (complete != null){
				JSElement completeElement = new JSElement(clientId + ":" + "complete");
				completeElement.addEvent(new JSHideEvent());
				function.addJSElement(completeElement);
			}
			//error
			if (error != null){
				JSElement errorElement = new JSElement(clientId + ":" + "error");
				errorElement.addEvent(new JSHideEvent());
				function.addJSElement(errorElement);
			}
			JSElement startElement = new JSElement(clientId + ":" + "start");
			startElement.addEvent(new JSShowEvent());
			function.addJSElement(startElement);
			
			sbAjaxStart.append(function.toJavaScriptCode());
			attribute.addValue(sbAjaxStart.toString());
			element.addAttribute(attribute);
		}
		if (complete != null){
			StringBuffer sbAjaxStart = new StringBuffer();
			sbAjaxStart.append("'ajaxComplete', ");
			JSAttribute attribute = new JSAttribute("bind", false);
			JSFunction function = new JSFunction();
			//start
			if (start != null){
				JSElement startElement = new JSElement(clientId + ":" + "start");
				startElement.addEvent(new JSHideEvent());
				function.addJSElement(startElement);
			}
			//complete
			JSElement thisElement = new JSElement(clientId + ":" + "complete");
			thisElement.addEvent(new JSShowEvent());
			function.addJSElement(thisElement);
			sbAjaxStart.append(function.toJavaScriptCode());
			attribute.addValue(sbAjaxStart.toString());
			element.addAttribute(attribute);
		}
		if (error != null){
			StringBuffer sbAjaxStart = new StringBuffer();
			sbAjaxStart.append("'ajaxError', ");
			JSAttribute attribute = new JSAttribute("bind", false);
			JSFunction function = new JSFunction();
			//start
			if (start != null){
				JSElement startElement = new JSElement(clientId + ":" + "start");
				startElement.addEvent(new JSHideEvent());
				function.addJSElement(startElement);
			}
			//error
			JSElement thisElement = new JSElement(clientId + ":" + "error");
			thisElement.addEvent(new JSShowEvent());
			function.addJSElement(thisElement);
			sbAjaxStart.append(function.toJavaScriptCode());
			attribute.addValue(sbAjaxStart.toString());
			element.addAttribute(attribute);
		}
		jsFunction.addJSElement(element);
		documentElement.addFunctionToReady(jsFunction);
		sb.append(documentElement.toJavaScriptCode());
		sb.append("\n");
		RendererUtilities.createTagScriptForJs(ajaxStatus, responseWriter, sb);
	}
}
