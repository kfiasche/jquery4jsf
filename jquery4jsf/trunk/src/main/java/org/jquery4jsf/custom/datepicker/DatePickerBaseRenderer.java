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
package org.jquery4jsf.custom.datepicker;

import java.lang.String;
import org.jquery4jsf.renderkit.JQueryInputBaseRenderer;
import javax.faces.context.FacesContext;

public abstract class DatePickerBaseRenderer extends JQueryInputBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, DatePicker datePicker , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, datePicker.getLocale(), "regional", null);
		encodeOptionComponentByType(options, datePicker.getAltField(), "altField", null);
		encodeOptionComponentByType(options, datePicker.getAltFormat(), "altFormat", null);
		encodeOptionComponentByType(options, datePicker.getAppendText(), "appendText", null);
		encodeOptionComponentByType(options, datePicker.getButtonImage(), "buttonImage", null);
		encodeOptionComponentByType(options, datePicker.isButtonImageOnly(), "buttonImageOnly", null);
		encodeOptionComponentByType(options, datePicker.getButtonText(), "buttonText", null);
		encodeOptionComponentByType(options, datePicker.isChangeMonth(), "changeMonth", null);
		encodeOptionComponentByType(options, datePicker.isChangeYear(), "changeYear", null);
		encodeOptionComponentByType(options, datePicker.getCloseText(), "closeText", null);
		encodeOptionComponentByType(options, datePicker.isConstrainInput(), "constrainInput", null);
		encodeOptionComponentByType(options, datePicker.getCurrentText(), "currentText", null);
		encodeOptionComponentByType(options, datePicker.getDateFormat(), "dateFormat", null);
		encodeOptionComponentByType(options, datePicker.getDayNames(), "dayNames", null);
		encodeOptionComponentByType(options, datePicker.getDayNamesMin(), "dayNamesMin", null);
		encodeOptionComponentByType(options, datePicker.getDayNamesShort(), "dayNamesShort", null);
		encodeOptionComponentByType(options, datePicker.getDefaultDate(), "defaultDate", null);
		encodeOptionComponentByType(options, datePicker.getDuration(), "duration", null);
		encodeOptionComponentByType(options, datePicker.getFirstDay(), "firstDay", null);
		encodeOptionComponentByType(options, datePicker.isGotoCurrent(), "gotoCurrent", null);
		encodeOptionComponentByType(options, datePicker.isHideIfNoPrevNext(), "hideIfNoPrevNext", null);
		encodeOptionComponentByType(options, datePicker.getMaxDate(), "maxDate", null);
		encodeOptionComponentByType(options, datePicker.getMinDate(), "minDate", null);
		encodeOptionComponentByType(options, datePicker.getMonthNames(), "monthNames", null);
		encodeOptionComponentByType(options, datePicker.getMonthNamesShort(), "monthNamesShort", null);
		encodeOptionComponentByType(options, datePicker.isNavigationAsDateFormat(), "navigationAsDateFormat", null);
		encodeOptionComponentByType(options, datePicker.getNextText(), "nextText", null);
		encodeOptionComponentByType(options, datePicker.getNumberOfMonths(), "numberOfMonths", "1");
		encodeOptionComponentByType(options, datePicker.getPrevText(), "prevText", null);
		encodeOptionComponentByType(options, datePicker.getShortYearCutoff(), "shortYearCutoff", null);
		encodeOptionComponentByType(options, datePicker.getShowAnim(), "showAnim", null);
		encodeOptionComponentByType(options, datePicker.isShowButtonPanel(), "showButtonPanel", null);
		encodeOptionComponentByType(options, datePicker.getShowCurrentAtPos(), "showCurrentAtPos", null);
		encodeOptionComponentByType(options, datePicker.isShowMonthAfterYear(), "showMonthAfterYear", null);
		encodeOptionComponentByType(options, datePicker.getShowOn(), "showOn", null);
		encodeOptionComponentByType(options, datePicker.getShowOptions(), "showOptions", null);
		encodeOptionComponentByType(options, datePicker.isShowOtherMonths(), "showOtherMonths", null);
		encodeOptionComponentByType(options, datePicker.getStepMonths(), "stepMonths", null);
		encodeOptionComponentByType(options, datePicker.getYearRange(), "yearRange", null);
		encodeOptionComponentByType(options, datePicker.getOnbeforeShow(), "onbeforeShow", null);
		encodeOptionComponentByType(options, datePicker.getOnbeforeShowDay(), "onbeforeShowDay", null);
		encodeOptionComponentByType(options, datePicker.getOnchangeMonthYear(), "onchangeMonthYear", null);
		encodeOptionComponentByType(options, datePicker.getOnclose(), "onclose", null);
		encodeOptionComponentByType(options, datePicker.getOnselect(), "onselect", null);
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