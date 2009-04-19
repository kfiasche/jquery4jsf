package org.jquery4jsf.custom.calendar;

import org.jquery4jsf.custom.datepicker.DatePicker;

public class Calendar extends DatePicker {

	public static final String DEFAULT_RENDERER_TYPE = CalendarRenderer.RENDERER_TYPE;
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Calendar";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlCalendar";
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
}
