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
