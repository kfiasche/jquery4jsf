package org.jquery4jsf.component.ext;

import javax.faces.el.ValueBinding;

public class HtmlInputText extends javax.faces.component.html.HtmlInputText {

	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}
	
}
