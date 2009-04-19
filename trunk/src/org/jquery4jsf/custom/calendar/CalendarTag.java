package org.jquery4jsf.custom.calendar;

import org.jquery4jsf.custom.datepicker.DatePickerTag;

public class CalendarTag extends DatePickerTag {

	public String getComponentType() {
		return Calendar.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return Calendar.DEFAULT_RENDERER_TYPE;
	}

}
