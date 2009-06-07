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
package org.jquery4jsf.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.component.ActionSource;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIColumn;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIGraphic;
import javax.faces.component.UIParameter;
import javax.faces.component.UISelectBoolean;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import javax.faces.event.FacesEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.webapp.UIComponentTag;

import org.jquery4jsf.el.JQueryMethodBinding;

public class ComponentUtilities {

	private static final Class[] FACES_LISTENER_ARGS = { FacesEvent.class };
	private static final Class[] ACTION_LISTENER_ARGS = { ActionEvent.class };
	private static final Class[] VALIDATOR_ARGS = { ActionEvent.class };

	public static void setIntegerProperty(FacesContext context,
			UIComponent component, String propertyName, String value) {
		if (value != null) {
			if (isValueReference(value)) {
				ValueBinding vb = context.getApplication().createValueBinding(
						value);
				component.setValueBinding(propertyName, vb);
			} else {
				component.getAttributes().put(propertyName,
						Integer.valueOf(value));
			}
		}
	}

	public static void setDoubleProperty(FacesContext context,
			UIComponent component, String propertyName, String value) {
		if (value != null) {
			if (isValueReference(value)) {
				ValueBinding vb = context.getApplication().createValueBinding(
						value);
				component.setValueBinding(propertyName, vb);
			} else {
				component.getAttributes().put(propertyName,
						Double.valueOf(value));
			}
		}
	}

	public static void setLongProperty(FacesContext context,
			UIComponent component, String propertyName, String value) {
		if (value != null) {
			if (isValueReference(value)) {
				ValueBinding vb = context.getApplication().createValueBinding(
						value);
				component.setValueBinding(propertyName, vb);
			} else {
				component.getAttributes()
				.put(propertyName, Long.valueOf(value));
			}
		}
	}

	public static void setFloatProperty(FacesContext context,
			UIComponent component, String propertyName, String value) {
		if (value != null) {
			if (isValueReference(value)) {
				ValueBinding vb = context.getApplication().createValueBinding(
						value);
				component.setValueBinding(propertyName, vb);
			} else {
				component.getAttributes().put(propertyName,
						Float.valueOf(value));
			}
		}
	}

	public static void setStringProperty(FacesContext context,
			UIComponent component, String propertyName, String value) {
		if (value != null) {
			if (isValueReference(value)) {
				ValueBinding vb = context.getApplication().createValueBinding(
						value);
				component.setValueBinding(propertyName, vb);
			} else {
				component.getAttributes().put(propertyName, value);
			}
		}
	}

	public static void setBooleanProperty(FacesContext context,
			UIComponent component, String propertyName, String value) {
		if (value != null) {
			if (isValueReference(value)) {
				ValueBinding vb = context.getApplication().createValueBinding(
						value);
				component.setValueBinding(propertyName, vb);
			} else {
				component.getAttributes().put(propertyName,
						Boolean.valueOf(value));
			}
		}
	}

	public static void setActionProperty(FacesContext context,
			UIComponent component, String action) {
		if (action != null) {
			if (!(component instanceof ActionSource)) {
				throw new IllegalArgumentException("Component "
						+ component.getClientId(context)
						+ " is no ActionSource");
			}
			MethodBinding mb;
			if (isValueReference(action)) {
				mb = context.getApplication().createMethodBinding(action, null);
			} else {
				mb = new JQueryMethodBinding(action);
			}
			((ActionSource) component).setAction(mb);
		}
	}

	public static void setMethodBindingProperty(FacesContext context,
			UIComponent component, String attributeName, String mbValue) {
		if (mbValue != null) {
			if (isValueReference(mbValue)) {
				Class params[] = { String.class };
				MethodBinding mb = context.getApplication()
				.createMethodBinding(mbValue, params);
				component.getAttributes().put(attributeName, mb);
			} else {
				throw new IllegalArgumentException("Component with id:"
						+ component.getId() + " has an invalid method binding");
			}
		}
	}

	public static void setActionListenerProperty(FacesContext context,
			UIComponent component, String actionListener) {
		if (actionListener != null) {
			if (!(component instanceof ActionSource)) {
				throw new IllegalArgumentException();
			}
			if (isValueReference(actionListener)) {
				MethodBinding mb = context.getApplication()
				.createMethodBinding(actionListener,
						ACTION_LISTENER_ARGS);
				((ActionSource) component).setActionListener(mb);
			}
		}
	}

	private static boolean isValueReference(String value) {
		return UIComponentTag.isValueReference(value);
	}

	public static boolean isValidMethodBinding(String mb) {
		if (mb == null || mb.equalsIgnoreCase("")) {
			return false;
		} else {
			int start = mb.indexOf("#{");
			if (start < 0) {
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
	public static Object getLocalOrValueBindingValue(Object localValue,
			String valueBindingName) {
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}

	public static ValueBinding getValueBinding(String valueBindingName) {
		return getFacesContext().getApplication().createValueBinding(
				valueBindingName);
	}

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public static void setValueProperty(FacesContext context,
			UIComponent component, String property, String value) {
		if (value != null) {
			if (UIComponentTag.isValueReference(value)) {
				ValueBinding binding = context.getApplication()
				.createValueBinding(value);
				component.setValueBinding("value", binding);
			} else if (component instanceof UICommand) {
				((UICommand) component).setValue(value);
			} else if (component instanceof UIParameter) {
				((UIParameter) component).setValue(value);
			} else if (component instanceof UISelectBoolean) {
				((UISelectBoolean) component).setValue(Boolean.valueOf(value));
			} else if (component instanceof UIGraphic) {
				((UIGraphic) component).setValue(value);
			} else if (component instanceof ValueHolder) {
				((ValueHolder) component).setValue(value);
			}
		}
	}

	public static void setValueChangeListenerProperty(FacesContext context,
			UIComponent component, String property, String valueChangeListener) {
		if (valueChangeListener != null) {
			if (isValueReference(valueChangeListener)) {
				Class params[] = { ValueChangeEvent.class };
				MethodBinding mb = context.getApplication()
				.createMethodBinding(valueChangeListener, params);
				((EditableValueHolder) component).setValueChangeListener(mb);
			} else {
				throw new IllegalArgumentException("Component with id:"
						+ component.getId() + " has an invalid validator");
			}
		}
	}

	public static void setRequiredProperty(FacesContext context,
			UIComponent component, String property, String required) {
		if (required != null) {
			if (isValueReference(required)) {
				ValueBinding vb = context.getApplication().createValueBinding(
						required);
				component.setValueBinding("required", vb);
			} else {
				((EditableValueHolder) component).setRequired(Boolean.valueOf(
						required).booleanValue());
			}
		}
	}

	public static void setImmediateProperty(FacesContext context,
			UIComponent component, String property, String immediate) {
		if (immediate != null) {
			if (isValueReference(immediate)) {
				ValueBinding vb = context.getApplication().createValueBinding(
						immediate);
				component.setValueBinding("immediate", vb);
			} else {
				((EditableValueHolder) component).setImmediate(Boolean.valueOf(
						immediate).booleanValue());
			}
		}
	}

	public static void setConverterProperty(FacesContext context,
			UIComponent component, String property, String value) {
		if (value != null) {
			if (component instanceof ValueHolder) {
				if (isValueReference(value)) {
					ValueBinding vb = context.getApplication()
					.createValueBinding(value);
					component.setValueBinding("converter", vb);
				} else {
					Converter converter = context.getApplication()
					.createConverter(value);
					((ValueHolder) component).setConverter(converter);
				}
			}
		}
	}

	public static void setValidatorProperty(FacesContext context,
			UIComponent component, String property, String validator) {
		if (validator != null) {
			if (!(component instanceof EditableValueHolder)) {
				throw new IllegalArgumentException("Component "
						+ component.getClientId(context)
						+ " is no EditableValueHolder");
			}
			if (isValueReference(validator)) {
				MethodBinding mb = context.getApplication()
				.createMethodBinding(validator, VALIDATOR_ARGS);
				((EditableValueHolder) component).setValidator(mb);
			}
		}
	}

	public static void encodeAll(FacesContext context, UIComponent component)
	throws IOException {
		if (!component.isRendered()) {
			return;
		}

		component.encodeBegin(context);
		if (component.getRendersChildren()) {
			component.encodeChildren(context);
		} else if (component.getChildCount() > 0) {
			Iterator children = component.getChildren().iterator();
			while (children.hasNext()) {
				UIComponent child = (UIComponent) children.next();
				encodeAll(context, child);
			}
		}
		component.encodeEnd(context);
	}

	public static ArrayList getColumns(UIData data) {
		ArrayList list = new ArrayList();
		Iterator iterator = data.getChildren().iterator();
		do {
			if (!iterator.hasNext())
				break;
			UIComponent uicomponent = (UIComponent) iterator.next();
			if ((uicomponent instanceof UIColumn) && uicomponent.isRendered())
				list.add(uicomponent);
		} while (true);
		return list;
	}

}
