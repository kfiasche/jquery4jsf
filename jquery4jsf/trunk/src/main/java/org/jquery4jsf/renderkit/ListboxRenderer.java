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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectMany;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


public abstract class ListboxRenderer extends JQueryInputBaseRenderer
{

	/**
	 * True if the renderer is responsible for rendering the children.
	 */
	public boolean getRendersChildren()
	{
		return true;
	}

	/**
	 * Decodes the data from the form.
	 */
	public void decode(FacesContext context, UIComponent component)
	{
		String clientId = component.getClientId(context);
		ExternalContext ext = context.getExternalContext();
		Map paramMap = ext.getRequestParameterValuesMap();
		String[] value = (String[]) paramMap.get(clientId);
		if (value != null) {
			((EditableValueHolder) component).setSubmittedValue(value);
		}
	}
	
    public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
        if (component instanceof UISelectMany) {
            return convertSelectManyValue(context, ((UISelectMany) component), (String[]) submittedValue);
        } else {
            return super.getConvertedValue(context, component, submittedValue);
        }
    }

    protected Object convertSelectManyValue(FacesContext context, UISelectMany component, String[] newValue) throws ConverterException {
    	if (newValue == null) return null;
    	Class veType = null;
    	Class arrayType = null;
    	Object ve = component.getValue();
        if (ve != null) {
            veType = ve.getClass();
            if (veType != null && veType.isArray()) {
                arrayType = veType.getComponentType();
            }
        }

    	Converter converter = component.getConverter();
    	if (converter == null) {
    		if (veType == null) {
    			return newValue;
    		}
    		if (List.class.isAssignableFrom(veType)) {
    			List lst = new ArrayList(newValue.length);
    			for (int i=0; i<newValue.length; i++) {
    				lst.add(newValue[i]);
    			}
    			return lst;
    		}
    		if (arrayType == null) {
    			throw new IllegalArgumentException("ValueBinding for UISelectMany must be of type List or Array");
    		}
    		if (String.class.equals(arrayType) || Object.class.equals(arrayType)) return newValue;
    		try {
    			converter = context.getApplication().createConverter(arrayType);
    		} catch (Exception e) {
    			return newValue;
    		}
    	}
    	if (veType == null) {
    		int len = newValue.length;
    		Object [] convertedValues = (Object []) Array.newInstance(arrayType, len);
    		for (int i = 0; i < len; i++) {
    			convertedValues[i] = converter.getAsObject(context, component, newValue[i]);
    		}
    		return convertedValues;
    	}
    	if (List.class.isAssignableFrom(veType)) {
    		int len = newValue.length;
    		List lst = new ArrayList(len);
    		for (int i=0; i<len; i++) {
    			lst.add(converter.getAsObject(context, component, newValue[i]));
    		}
    		return lst;
    	}
    	if (arrayType == null) {
    		throw new IllegalArgumentException("ValueBinding for UISelectMany must be of type List or Array");
    	}
    	if (arrayType.isPrimitive()) {
    		int len = newValue.length;
    		Object convertedValues = Array.newInstance(arrayType, len);
    		for (int i=0; i<len; i++) {
    			Array.set(convertedValues, i,converter.getAsObject(context, component, newValue[i]));
    		}
    		return convertedValues;
    	} else {
    		int len = newValue.length;
    		Object[] convertedValues = new Object[len];
    		for (int i=0; i<len; i++) {
    			convertedValues[i] = converter.getAsObject(context, component, newValue[i]);
    		}
    		return convertedValues;
    	}
    }

	
}

