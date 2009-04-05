package org.jquery4jsf.create.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.component.html.HtmlInputText;

import org.jquery4jsf.custom.accordion.AccordionSubPanel;
import org.jquery4jsf.custom.datapiker.DatePicker;

public class CreateTagLib {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		//Field[] fieldsa = AccordianSubPanel.class.getSuperclass().getSuperclass().getSuperclass().getDeclaredFields();
		//Field[] fieldsb = DatePicker.class.getSuperclass().getSuperclass().getDeclaredFields();
		//Field[] fieldsc = HtmlInputText.class.getSuperclass().getDeclaredFields();
		Field[] fieldsd = DatePicker.class.getDeclaredFields();
		ArrayList lista = new ArrayList();
		//lista.addAll(Arrays.asList(fieldsa));
		//lista.addAll(Arrays.asList(fieldsb));
		//lista.addAll(Arrays.asList(fieldsc));
		lista.addAll(Arrays.asList(fieldsd));
		sb.append("<tag>\n");
		sb.append("<name>"+ "datePicker" +"</name>\n");
		sb.append("<tag-class></tag-class>\n");
		sb.append("<body-content>JSP</body-content>\n");
		sb.append("<description></description>\n");
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
			sb.append("<rtexprvalue>");
			sb.append("false");
			sb.append("</rtexprvalue>\n");
			sb.append("<type>");
			sb.append("java.lang.String");
			sb.append("</type>\n");
			sb.append("<description></description>\n");
			sb.append("</attribute>\n");
		}
		sb.append("</tag>\n");
		System.out.println(sb.toString());
	}
}
