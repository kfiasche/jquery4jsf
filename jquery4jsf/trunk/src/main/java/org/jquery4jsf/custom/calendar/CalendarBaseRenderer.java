/*
 
*  Copyright (c) 2009 Giuseppe Trisciuoglio 
* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jquery4jsf.custom.calendar;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryBaseRenderer;
import javax.faces.context.FacesContext;

public class CalendarBaseRenderer extends JQueryBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, Calendar calendar , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, calendar.getLocale(), "locale", null);
		encodeOptionComponentByType(options, calendar.getAltField(), "altField", null);
		encodeOptionComponentByType(options, calendar.getAltFormat(), "altFormat", null);
		encodeOptionComponentByType(options, calendar.getAppendText(), "appendText", null);
		encodeOptionComponentByType(options, calendar.getButtonImage(), "buttonImage", null);
		encodeOptionComponentByType(options, calendar.isButtonImageOnly(), "buttonImageOnly", null);
		encodeOptionComponentByType(options, calendar.getButtonText(), "buttonText", null);
		encodeOptionComponentByType(options, calendar.isChangeMonth(), "changeMonth", null);
		encodeOptionComponentByType(options, calendar.isChangeYear(), "changeYear", null);
		encodeOptionComponentByType(options, calendar.getCloseText(), "closeText", null);
		encodeOptionComponentByType(options, calendar.isConstrainInput(), "constrainInput", null);
		encodeOptionComponentByType(options, calendar.getCurrentText(), "currentText", null);
		encodeOptionComponentByType(options, calendar.getDateFormat(), "dateFormat", null);
		encodeOptionComponentByType(options, calendar.getDayNames(), "dayNames", null);
		encodeOptionComponentByType(options, calendar.getDayNamesMin(), "dayNamesMin", null);
		encodeOptionComponentByType(options, calendar.getDayNamesShort(), "dayNamesShort", null);
		encodeOptionComponentByType(options, calendar.getDefaultDate(), "defaultDate", null);
		encodeOptionComponentByType(options, calendar.getDuration(), "duration", null);
		encodeOptionComponentByType(options, calendar.getFirstDay(), "firstDay", null);
		encodeOptionComponentByType(options, calendar.isGotoCurrent(), "gotoCurrent", null);
		encodeOptionComponentByType(options, calendar.isHideIfNoPrevNext(), "hideIfNoPrevNext", null);
		encodeOptionComponentByType(options, calendar.getMaxDate(), "maxDate", null);
		encodeOptionComponentByType(options, calendar.getMinDate(), "minDate", null);
		encodeOptionComponentByType(options, calendar.getMonthNames(), "monthNames", null);
		encodeOptionComponentByType(options, calendar.getMonthNamesShort(), "monthNamesShort", null);
		encodeOptionComponentByType(options, calendar.isNavigationAsDateFormat(), "navigationAsDateFormat", null);
		encodeOptionComponentByType(options, calendar.getNextText(), "nextText", null);
		encodeOptionComponentByType(options, calendar.getNumberOfMonths(), "numberOfMonths", "1");
		encodeOptionComponentByType(options, calendar.getPrevText(), "prevText", null);
		encodeOptionComponentByType(options, calendar.getShortYearCutoff(), "shortYearCutoff", null);
		encodeOptionComponentByType(options, calendar.getShowAnim(), "showAnim", null);
		encodeOptionComponentByType(options, calendar.isShowButtonPanel(), "showButtonPanel", null);
		encodeOptionComponentByType(options, calendar.getShowCurrentAtPos(), "showCurrentAtPos", null);
		encodeOptionComponentByType(options, calendar.isShowMonthAfterYear(), "showMonthAfterYear", null);
		encodeOptionComponentByType(options, calendar.getShowOn(), "showOn", null);
		encodeOptionComponentByType(options, calendar.getShowOptions(), "showOptions", null);
		encodeOptionComponentByType(options, calendar.isShowOtherMonths(), "showOtherMonths", null);
		encodeOptionComponentByType(options, calendar.getStepMonths(), "stepMonths", null);
		encodeOptionComponentByType(options, calendar.getYearRange(), "yearRange", null);
		encodeOptionComponentByType(options, calendar.getOnbeforeShow(), "onbeforeShow", null);
		encodeOptionComponentByType(options, calendar.getOnbeforeShowDay(), "onbeforeShowDay", null);
		encodeOptionComponentByType(options, calendar.getOnchangeMonthYear(), "onchangeMonthYear", null);
		encodeOptionComponentByType(options, calendar.getOnclose(), "onclose", null);
		encodeOptionComponentByType(options, calendar.getOnselect(), "onselect", null);
		if (options.toString().endsWith(", \n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
		}
		boolean noParams = false;
		if (options.toString().endsWith(" {\n")){
			String stringa = options.substring(0, options.length()-3);
			options = new StringBuffer(stringa);
			noParams = true;
		}
		if (!noParams)
		{
			options.append(" }");
		}
		return options.toString();
	}
}