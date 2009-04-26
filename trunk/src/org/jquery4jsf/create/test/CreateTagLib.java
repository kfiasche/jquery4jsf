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
package org.jquery4jsf.create.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import org.jquery4jsf.custom.accordion.AccordionPanel;

public class CreateTagLib {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		//Field[] fieldsa = AccordianSubPanel.class.getSuperclass().getSuperclass().getSuperclass().getDeclaredFields();
		//Field[] fieldsb = DatePicker.class.getSuperclass().getSuperclass().getDeclaredFields();
		//Field[] fieldsc = HtmlInputText.class.getSuperclass().getDeclaredFields();
		Field[] fieldsd = AccordionPanel.class.getDeclaredFields();
		ArrayList lista = new ArrayList();
		//lista.addAll(Arrays.asList(fieldsa));
		//lista.addAll(Arrays.asList(fieldsb));
		//lista.addAll(Arrays.asList(fieldsc));
		lista.addAll(Arrays.asList(fieldsd));
		//sb.append("<tag>\n");
		//sb.append("<name>"+ "sliderTag" +"</name>\n");
		//sb.append("<tag-class>"+ SliderTag.class + "</tag-class>\n");
		//sb.append("<body-content>JSP</body-content>\n");
		//sb.append("<description></description>\n");
		for (int i = 0; i < lista.size(); i++) {
			Field field = (Field) lista.get(i);
			String upperName = field.getName().toUpperCase();
			if (upperName.equals(field.getName())){
				continue;
			}
			if (upperName.indexOf("_SET") != -1){
				continue;
			}
			sb.append("<attribute>\n");
			sb.append("<name>");
			sb.append(field.getName());
			sb.append("</name>\n");
			sb.append("<required>");
			sb.append("false");
			sb.append("</required>\n");
			sb.append("<type>");
			sb.append(field.getType().getName());
			sb.append("</type>\n");
			sb.append("<description></description>\n");
			sb.append("</attribute>\n");
		}
		sb.append("</tag>\n");
		System.out.println(sb.toString());
	}
}
