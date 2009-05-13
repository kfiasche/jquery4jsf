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
package org.jquery4jsf.custom.scriptcollector;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;

public class ScriptCollectorRenderer extends JQueryBaseRenderer {
	
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ScriptCollector scriptCollector = (ScriptCollector) component;
		MethodBinding mb = scriptCollector.getOnPageLoadBegin();
		if (mb != null)
			mb.invoke(context, new Object[] { context });
	}

	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ScriptCollector scriptCollector = (ScriptCollector) component;
		MethodBinding mb = scriptCollector.getOnPageLoadEnd();
		if (mb != null)
			mb.invoke(context, new Object[] { context });
	}
	
	public void decode(FacesContext context, UIComponent component)
    {
		ScriptCollector scriptCollector = (ScriptCollector) component;
		MethodBinding mb = scriptCollector.getOnPagePost();
        if(mb != null)
        	mb.invoke(context, new Object[] {
        			context
            });
    }

	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		ScriptCollector scriptCollector = (ScriptCollector) component;
		if(scriptCollector.isDisableForm()){
			setFormStatus(component, true, new String[]{});
		}
	}
	
	private void setFormStatus(UIComponent comp, boolean disabled, String[] esenti) {
		Iterator i = comp.getFacetsAndChildren();
		while (i.hasNext()) {
			UIComponent c = (UIComponent)i.next();
			
			if (esenti != null && contiene(esenti, c.getId()))
				continue;
			
			if (c instanceof HtmlInputTextarea)
			{
				try {
					Method m = c.getClass().getMethod("setReadonly", new Class[] {boolean.class});
					m.invoke(c, new Object[] {Boolean.valueOf(disabled)});
				} catch (Exception e) {
					
				}
			}else if (c instanceof UIInput || c instanceof UICommand) {
				try {
					Method m = c.getClass().getMethod("setDisabled", new Class[] {boolean.class});
					m.invoke(c, new Object[] {Boolean.valueOf(disabled)});
				} catch (Exception e) {
					
				}
			}
			
			if (c.getFacetsAndChildren().hasNext()) {
				setFormStatus(c, disabled, esenti);
			}
		}
	}
	
	private static boolean contiene(String[] array, String s) {
		if (s == null)
			return false;
		for (int i = 0; i < array.length; i++)
			if (s.equals(array[i]))
				return true;
		return false;
	}
	
}