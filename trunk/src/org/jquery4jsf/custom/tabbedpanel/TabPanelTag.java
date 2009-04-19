package org.jquery4jsf.custom.tabbedpanel;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.webapp.UIComponentBodyTag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;

import org.jquery4jsf.component.ComponentUtilities;

public class TabPanelTag extends UIComponentBodyTag {

	private String disabled;
	private String ajaxSupport;
	private String ajaxSource;
	private String tabName;
	
	public String getComponentType() {
		return TabPanel.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return null;
	}

	public void release() {
		super.release();
		disabled = null;
		ajaxSource = null;
		ajaxSupport = null;
		tabName = null;
	}
	
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "disabled", disabled) ;
		ComponentUtilities.setStringProperty(getFacesContext(), component, "ajaxSource", ajaxSource);
		ComponentUtilities.setBooleanProperty(getFacesContext(), component, "ajaxSupport",ajaxSupport);
		ComponentUtilities.setStringProperty(getFacesContext(), component, "tabName", tabName);
	}	
	
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public void setAjaxSupport(String ajaxSupport) {
		this.ajaxSupport = ajaxSupport;
	}

	public void setAjaxSource(String ajaxSource) {
		this.ajaxSource = ajaxSource;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
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
        		TabPanel tabPanel = (TabPanel) getComponentInstance();
        		if (tabPanel != null){
        			tabPanel.getChildren().add(output);
        		}
        	}
        }
        return super.doAfterBody();
    }
}
