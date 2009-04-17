package org.jquery4jsf.component;

import java.util.Iterator;

import javax.faces.component.ActionSource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;

import org.jquery4jsf.el.JQueryMethodBinding;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class ComponentUtilities {

	private static final Class[] ACTION_LISTENER_ARGS = {ActionEvent.class};
	
	public static void setIntegerProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		if (value != null)
		{
			if (isValueReference(value))
			{
				ValueBinding vb = context.getApplication().createValueBinding(value);
				component.setValueBinding(propertyName, vb);
			}
			else
			{
				component.getAttributes().put(propertyName, Integer.valueOf(value));
			}
		}
	}
	
	public static void setDoubleProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		if (value != null)
		{
			if (isValueReference(value))
			{
				ValueBinding vb = context.getApplication().createValueBinding(value);
				component.setValueBinding(propertyName, vb);
			}
			else
			{
				component.getAttributes().put(propertyName, Double.valueOf(value));
			}
		}
	}

	public static void setLongProperty(FacesContext context, UIComponent component, String propertyName, String value)
    {
        if (value != null)
        {
            if (isValueReference(value))
            {
                ValueBinding vb = context.getApplication().createValueBinding(value);
                component.setValueBinding(propertyName, vb);
            }
            else
            {
                component.getAttributes().put(propertyName, Long.valueOf(value));
            }
        }
    }

	public static void setFloatProperty(FacesContext context, UIComponent component, String propertyName, String value)
    {
        if (value != null)
        {
            if (isValueReference(value))
            {
                ValueBinding vb = context.getApplication().createValueBinding(value);
                component.setValueBinding(propertyName, vb);
            }
            else
            {
                component.getAttributes().put(propertyName, Float.valueOf(value));
            }
        }
    }

	
	public static void setStringProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		if (value != null)
		{
			if (isValueReference(value))
			{
				ValueBinding vb = context.getApplication().createValueBinding(value);
				component.setValueBinding(propertyName, vb);
			}
			else
			{
				component.getAttributes().put(propertyName, value);
			}
		}
	}

	public static void setBooleanProperty(FacesContext context, UIComponent component, String propertyName, String value)
	{
		if (value != null)
		{
			if (isValueReference(value))
			{
				ValueBinding vb = context.getApplication().createValueBinding(value);
				component.setValueBinding(propertyName, vb);
			}
			else
			{
				component.getAttributes().put(propertyName, Boolean.valueOf(value));
			}
		}
	}
	
	public static void setActionProperty(FacesContext context, UIComponent component, String action)
	{
		if (action != null)
		{
			if (!(component instanceof ActionSource))
			{
				throw new IllegalArgumentException("Component " + component.getClientId(context) + " is no ActionSource");
			}
			MethodBinding mb;
			if (isValueReference(action))
			{
				mb = context.getApplication().createMethodBinding(action, null);
			}
			else
			{
				mb = new JQueryMethodBinding(action);
			}
			((ActionSource)component).setAction(mb);
		}
	}
	
	
    public static void setMethodBindingProperty(FacesContext context, UIComponent component, String attributeName, String mbValue) {
        if(mbValue != null) {
                if (isValueReference(mbValue)) {
                        Class params [] = { String.class };
                        MethodBinding mb = context.getApplication().createMethodBinding(mbValue, params);
                        component.getAttributes().put(attributeName, mb);
                } else {
                        throw new IllegalArgumentException("Component with id:" + component.getId() + " has an invalid method binding");
                }
        }
    }
	
	
	public static void setActionListenerProperty(FacesContext context, UIComponent component, String actionListener)
	{
		if (actionListener != null)
		{
			if (!(component instanceof ActionSource))
			{
				throw new IllegalArgumentException();
			}
			if (isValueReference(actionListener))
			{
				MethodBinding mb = context.getApplication().createMethodBinding(actionListener, ACTION_LISTENER_ARGS);
				((ActionSource)component).setActionListener(mb);
			}
		}
	}
	
	private static boolean isValueReference(String value) {
		return UIComponentTagBase.isValueReference(value);
	}
	
	public static boolean isValidMethodBinding(String mb) {
		if (mb == null || mb.equalsIgnoreCase("")){
			return false;
		}
		else{
			int start = mb.indexOf("#{");
			if (start < 0){
				return false;
			}
			int end = mb.lastIndexOf("}");
			return (end >= 0 && start < end);
		}
	}
	
	public static UIComponent findComponent(UIComponent base, String id) {
		if (id.equals(base.getId())) {
			return base;
		}
		UIComponent kid = null;
		UIComponent result = null;
		Iterator kids = base.getFacetsAndChildren();
		while (kids.hasNext() && (result == null)) {
			kid = (UIComponent) kids.next();
			if (id.equals(kid.getId())) {
				result = kid;
				break;
			}
			result = findComponent(kid, id);
			if (result != null) {
				break;
			}
		}
		return result;
	}

	public static UIComponent findComponentInRoot(String id) {
		UIComponent ret = null;
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			UIComponent root = context.getViewRoot();
			ret = findComponent(root, id);
		}
		return ret;
	}
	/**
	 * @deprecated
	 * @param localValue
	 * @param valueBindingName
	 * @return
	 */
	public static Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}
	
	public static ValueBinding getValueBinding(String valueBindingName) 
	{
		return getFacesContext().getApplication().createValueBinding(valueBindingName);
	}

	public static FacesContext getFacesContext()
	{
		return FacesContext.getCurrentInstance();
	}
	
}
