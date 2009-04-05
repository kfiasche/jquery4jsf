package org.jquery4jsf.taglib.html.ext;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.webapp.UIComponentTag;

import org.jquery4jsf.component.ComponentUtilities;

public abstract class UIComponentTagBase extends UIComponentTag {

	public static void setIntegerProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		ComponentUtilities.setIntegerProperty(context, component, propertyName, value);
	}
	
	public static void setStringProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		ComponentUtilities.setStringProperty(context, component, propertyName, value);
	}
	
	public static void setBooleanProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		ComponentUtilities.setBooleanProperty(context, component, propertyName, value);
	}
	
}
