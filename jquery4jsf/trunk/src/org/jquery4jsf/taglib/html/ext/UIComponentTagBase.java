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
	
	public static void setFloatProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		ComponentUtilities.setFloatProperty(context, component, propertyName, value);
	}
	
	public static void setDoubleProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		ComponentUtilities.setDoubleProperty(context, component, propertyName, value);
	}
	
	public static void setConverterProperty(FacesContext context,UIComponent component, String propertyName, String value){
		ComponentUtilities.setConverterProperty(context, component, propertyName, value);
	}
	
	public static void setValueProperty(FacesContext context,UIComponent component, String propertyName, String value){
		ComponentUtilities.setValueProperty(context, component, propertyName, value);
	}
	
	public static void setActionListenerProperty(FacesContext context,UIComponent component, String propertyName, String value){
		ComponentUtilities.setActionListenerProperty(context, component, value);
	}
	
	public static void setActionProperty(FacesContext context,UIComponent component, String propertyName, String value){
		ComponentUtilities.setActionProperty(context, component, value);
	}
	
	public static void setMethodBindingProperty(FacesContext context,UIComponent component, String propertyName, String value){
		ComponentUtilities.setMethodBindingProperty(context, component, propertyName, value);
	}
	
	public static void setValidatorProperty(FacesContext context,UIComponent component, String propertyName, String value){
		ComponentUtilities.setValidatorProperty(context, component,propertyName, value);
	}
	
	public static void setValueChangeListenerProperty(FacesContext context,UIComponent component, String propertyName, String value){
		ComponentUtilities.setValueChangeListenerProperty(context, component,propertyName, value);
	}
}
