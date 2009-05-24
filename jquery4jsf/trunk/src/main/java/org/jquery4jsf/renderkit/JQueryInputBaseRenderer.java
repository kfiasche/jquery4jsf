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

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.sun.faces.renderkit.html_basic.HtmlBasicInputRenderer;

public class JQueryInputBaseRenderer extends HtmlBasicInputRenderer {

	protected void encodeOptionComponentByType(StringBuffer sb, boolean value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, int value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, Object value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentOptionsByType(StringBuffer options, String value, String nameParameter, Object defaultValue) {
		RendererUtilities.createOptionComponentOptionsByType(options, value, nameParameter);
	}
	
	protected void encodeOptionComponentArrayByType(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentArrayByType(options, value, nameParameter);
	}
	
	
	protected void rendererInputText(ResponseWriter responseWriter, HtmlInputText input, FacesContext facesContext) throws IOException{
        responseWriter.startElement("input", input);
        writeIdAttributeIfNecessary(facesContext, responseWriter, input);
        responseWriter.writeAttribute("type", "text", null);
        responseWriter.writeAttribute("name", input.getClientId(facesContext), "clientId");
        if(input.getValue() != null)
            responseWriter.writeAttribute("value", getValue(input), "value");
        if(input.getStyleClass() != null)
            responseWriter.writeAttribute("class", input.getStyleClass(), "styleClass");
        if(input.getAccesskey() != null)
            responseWriter.writeAttribute("accesskey", input.getAccesskey(), null);
        if(input.getAlt() != null)
            responseWriter.writeAttribute("alt", input.getAlt(), null);
        if(input.getDir() != null)
            responseWriter.writeAttribute("dir", input.getDir(), null);
        if(input.isDisabled())
            responseWriter.writeAttribute("disabled", "disabled", null);
        if(input.getLang() != null)
            responseWriter.writeAttribute("lang", input.getLang(), null);
        if(input.getMaxlength() > 0)
            responseWriter.writeAttribute("maxlength", new Integer(input.getMaxlength()), null);
        if(input.getOnblur() != null)
            responseWriter.writeAttribute("onblur", input.getOnblur(), null);
        if(input.getOnchange() != null)
            responseWriter.writeAttribute("onchange", input.getOnchange(), null);
        if(input.getOnclick() != null)
            responseWriter.writeAttribute("onclick", input.getOnclick(), null);
        if(input.getOndblclick() != null)
            responseWriter.writeAttribute("ondblclick", input.getOndblclick(), null);
        if(input.getOnfocus() != null)
            responseWriter.writeAttribute("onfocus", input.getOnfocus(), null);
        if(input.getOnkeydown() != null)
            responseWriter.writeAttribute("onkeydown", input.getOnkeydown(), null);
        if(input.getOnkeypress() != null)
            responseWriter.writeAttribute("onkeypress", input.getOnkeypress(), null);
        if(input.getOnkeyup() != null)
            responseWriter.writeAttribute("onkeyup", input.getOnkeyup(), null);
        if(input.getOnmousedown() != null)
            responseWriter.writeAttribute("onmousedown", input.getOnmousedown(), null);
        if(input.getOnmousemove() != null)
            responseWriter.writeAttribute("onmousemove", input.getOnmousemove(), null);
        if(input.getOnmouseout() != null)
            responseWriter.writeAttribute("onmouseout", input.getOnmouseout(), null);
        if(input.getOnmouseover() != null)
            responseWriter.writeAttribute("onmouseover", input.getOnmouseover(), null);
        if(input.getOnmouseup() != null)
            responseWriter.writeAttribute("onmouseup", input.getOnmouseup(), null);
        if(input.getOnselect() != null)
            responseWriter.writeAttribute("onselect", input.getOnselect(), null);
        if(input.isReadonly())
            responseWriter.writeAttribute("readonly", "readonly", null);
        if(input.getSize() > 0)
            responseWriter.writeAttribute("size", new Integer(input.getSize()), null);
        if(input.getStyle() != null)
            responseWriter.writeAttribute("style", input.getStyle(), null);
        if(input.getTabindex() != null)
            responseWriter.writeAttribute("tabindex", input.getTabindex(), null);
        if(input.getTitle() != null)
            responseWriter.writeAttribute("title", input.getTitle(), null);
        responseWriter.endElement("input");
	}
	
	protected String writeIdAttributeIfNecessary(FacesContext context ,ResponseWriter responseWriter, UIComponent component) {
		return RendererUtilities.writeIdAttributeIfNecessary(context, responseWriter, component);
	}
	
}
