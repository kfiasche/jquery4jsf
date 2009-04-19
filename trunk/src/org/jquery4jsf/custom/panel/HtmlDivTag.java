package org.jquery4jsf.custom.panel;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.webapp.UIComponentBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;

import org.jquery4jsf.component.ComponentUtilities;

public class HtmlDivTag extends UIComponentBodyTag
 {
    private String styleClass;
    private String style;

    public void setStyle(String style) {
		this.style = style;
	}

	public HtmlDivTag() {
    }

    public String getComponentType() {
        return HtmlDiv.COMPONENT_TYPE;
    }

    public String getRendererType() {
        return HtmlDiv.RENDERER_TYPE;
    }

    public void setProperties(UIComponent component) {
        super.setProperties(component);
        ComponentUtilities.setStringProperty(getFacesContext(), component, "styleClass", styleClass);
        ComponentUtilities.setStringProperty(getFacesContext(), component, "style", style);
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
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
        		HtmlDiv htmlDiv = (HtmlDiv) getComponentInstance();
        		if (htmlDiv != null){
        			htmlDiv.getChildren().add(output);
        		}
        	}
        }
        return super.doAfterBody();
    }
}
