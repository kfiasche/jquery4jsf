package org.jquery4jsf.taglib.html.ext;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.webapp.UIComponentBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;

import org.jquery4jsf.utilities.TextUtilities;

public abstract class UIComponentTagBodyBase extends UIComponentBodyTag{

    public int doAfterBody() throws JspException
    {
        BodyContent bodyContent = getBodyContent();
        if (bodyContent != null)
        {
        	String bodyContentString = bodyContent.getString().trim();
        	String cleanBodyContent = TextUtilities.cleanString(bodyContentString).trim();
        	if (cleanBodyContent != null && !cleanBodyContent.equals("")){
        		HtmlOutputText output = (HtmlOutputText) getFacesContext().getApplication().createComponent(HtmlOutputText.COMPONENT_TYPE);
        		output.setId(getFacesContext().getViewRoot().createUniqueId());
        		output.setTransient(true);
        		output.setRendered(true);
        		output.setEscape(false);
        		output.setValue(cleanBodyContent);
        		UIComponent uiComponent = getComponentInstance();
        		if (uiComponent != null){
        			uiComponent.getChildren().add(output);
        		}
        	}
        }
        return super.doAfterBody();
    }
	
}
