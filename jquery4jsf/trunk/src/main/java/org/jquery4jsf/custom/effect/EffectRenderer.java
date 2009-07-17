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
package org.jquery4jsf.custom.effect;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.jquery4jsf.javascript.JSAttribute;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.renderkit.RendererUtilities;
import org.jquery4jsf.utilities.MessageFactory;
public class EffectRenderer extends EffectBaseRenderer {

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
	    if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!component.isRendered())
            return;
        
        Effect effect = null;
        if(component instanceof Effect)
            effect = (Effect)component;
        
        encodeResources(effect);
        encodeEffectScript(context, effect);
        encodeEffectMarkup(context, effect);
	}

	private void encodeEffectScript(FacesContext context, Effect effect) {
        JSDocumentElement documentElement = JSDocumentElement.getInstance();
        JSFunction function = new JSFunction();  
        function.addJSElement(getJSElement(context, effect));
        documentElement.addFunctionToReady(function);
	}

	private void encodeEffectMarkup(FacesContext context, Effect effect) {
	}

	public JSElement getJSElement(FacesContext context, UIComponent component) {
        Effect effect = null;
        if(component instanceof Effect)
            effect = (Effect)component;
		String parentClientId = effect.getParent().getClientId(context);
		String effectedComponentClientId = null;
		if(effect.getFor() != null) {
			effectedComponentClientId = RendererUtilities.getClientIdForComponent(effect.getFor(), context, effect);
		} else {
			effectedComponentClientId = parentClientId;
		}
        JSElement thisElement = new JSElement("this");
        JSAttribute jsEvent = new JSAttribute(effect.getEvent(), false);
        JSElement element = new JSElement(effectedComponentClientId);
        JSAttribute jsEffect = new JSAttribute("effect", false);
        StringBuffer sbOption = new StringBuffer();
        sbOption.append("'");
        sbOption.append(effect.getEffect());
        sbOption.append("', ");
        sbOption.append(encodeOptionsWithUIParam(effect));
        sbOption.append(", ");
        sbOption.append(effect.getSpeed());
        sbOption.append(", ");
        sbOption.append(effect.getCallback());
        jsEffect.addValue(sbOption.toString());
        thisElement.addAttribute(jsEffect);
             
        JSFunction functionEvent = new JSFunction();
        functionEvent.addJSElement(thisElement);
        jsEvent.addValue(functionEvent.toJavaScriptCode());
        element.addAttribute(jsEvent);
		return element;
	}
}
