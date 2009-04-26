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
/*
 *
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
package org.jquery4jsf.custom.panel;

import java.lang.String;
import com.sun.faces.taglib.jsf_core.VerbatimTag;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.custom.tabbedpanel.TabPanel;

public class HtmlDivTag extends VerbatimTag {

	private String style;
	private String styleClass;

	public void release(){
		super.release();
		this.style = null;
		this.styleClass = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.panel.HtmlDiv component = null;
		try {
			component = (org.jquery4jsf.custom.panel.HtmlDiv) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		ComponentUtilities.setStringProperty(getFacesContext(), component, "style", style);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "styleClass", styleClass);
	}

	public String getComponentType() {
		return HtmlDiv.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.DivRenderer";
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}
	
    public int doAfterBody() throws JspException
    {
        BodyContent bodyContent = getBodyContent();
        if (bodyContent != null)
        {
        	String bodyContentString = bodyContent.getString().trim();
        	if (bodyContentString != null && !bodyContent.equals("")){
        		HtmlOutputText output = (HtmlOutputText) getFacesContext().getApplication().createComponent(HtmlOutputText.COMPONENT_TYPE);
        		output.setId(getFacesContext().getViewRoot().createUniqueId());
        		output.setTransient(true);
        		output.setRendered(true);
        		output.setEscape(false);
        		output.setValue(bodyContentString);
        		UIComponent uiComponent = getComponentInstance();
        		if (uiComponent != null){
        			uiComponent.getChildren().add(output);
        		}
        	}
        }
        return super.doAfterBody();
    }

}