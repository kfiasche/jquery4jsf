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
package org.jquery4jsf.renderkit.html;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.ResponseWriter;

public class HtmlRendererUtilities {

	public static boolean writeHtmlAttributes(ResponseWriter writer, UIComponent component, String[] attributes, String[] ignored) throws IOException {
		boolean isWriteAttribute = false;
		for (int i = 0, len = attributes.length; i < len; i++) {
			String attrName = attributes[i];
			for (int j = 0; j < ignored.length; j++) {
				String attrIgnored = ignored[j];
				if (!attrIgnored.equalsIgnoreCase(attrName)){
					if (writeHtmlAttribute(writer, component, attrName, attrName)) {
						isWriteAttribute = true;
					}
				}
				else{
					break;
				}
			}
		}
		return isWriteAttribute;
	}
	
	public static boolean writeHtmlAttributes(ResponseWriter writer, UIComponent component, String[] attributes) throws IOException {
		boolean isWriteAttribute = false;
		for (int i = 0, len = attributes.length; i < len; i++) {
			String attrName = attributes[i];
			if (writeHtmlAttribute(writer, component, attrName, attrName)) {
				isWriteAttribute = true;
			}
		}
		return isWriteAttribute;
	}
	
	public static boolean writeHtmlAttribute(ResponseWriter writer, UIComponent component, String propertyComponent, String attributeName) throws IOException {
		Object value = component.getAttributes().get(propertyComponent);
	    return writeHtmlAttribute(writer, propertyComponent, attributeName, value);
	}
	
	public static boolean writeHtmlAttribute(ResponseWriter writer, String propertyComponent, String attributeName, Object value) throws IOException {
        if (!isDefaultAttributeValue(value)) {
            String htmlAttrName = attributeName.equals(JSFConstants.STYLE_CLASS) ? "class" : attributeName;
            writer.writeAttribute(htmlAttrName, value, propertyComponent);
            return true;
        }
        return false;
	}
	
	/*
	 * Metodo per il valore di default delle specifiche jsf 
	 */
	public static boolean isDefaultAttributeValue(Object value) {
        if (value == null) {
            return true;
        }
        else if (value instanceof Boolean) {
            return !((Boolean) value).booleanValue();
        }
        else if (value instanceof Number) {
            if (value instanceof Integer) {
                return ((Number) value).intValue() == Integer.MIN_VALUE;
            }
            else if (value instanceof Double) {
                return ((Number) value).doubleValue() == Double.MIN_VALUE;
            }
            else if (value instanceof Long) {
                return ((Number) value).longValue() == Long.MIN_VALUE;
            }
            else if (value instanceof Byte) {
                return ((Number) value).byteValue() == Byte.MIN_VALUE;
            }
            else if (value instanceof Float) {
                return ((Number) value).floatValue() == Float.MIN_VALUE;
            }
            else if (value instanceof Short) {
                return ((Number) value).shortValue() == Short.MIN_VALUE;
            }
        }
        return false;
    }
	
}
