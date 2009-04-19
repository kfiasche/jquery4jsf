/*
 *
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

public class DatePickerBaseRenderer extends JQueryInputBaseRenderer {

	protected String encodeOptionComponent(StringBuffer options, DatePicker datePicker , FacesContext context) {
		options.append(" {\n");
		encodeOptionComponentByType(options, datePicker.getAltField(), "altField");
		encodeOptionComponentByType(options, datePicker.getAltFormat(), "altFormat");
		encodeOptionComponentByType(options, datePicker.getAppendText(), "appendText");
		encodeOptionComponentByType(options, datePicker.getButtonImage(), "buttonImage");
		encodeOptionComponentByType(options, datePicker.isButtonImageOnly(), "buttonImageOnly");
		encodeOptionComponentByType(options, datePicker.getButtonText(), "buttonText");
		encodeOptionComponentByType(options, datePicker.isChangeMonth(), "changeMonth");
		encodeOptionComponentByType(options, datePicker.isChangeYear(), "changeYear");
		encodeOptionComponentByType(options, datePicker.getCloseText(), "closeText");
		encodeOptionComponentByType(options, datePicker.isConstrainInput(), "constrainInput");
		encodeOptionComponentByType(options, datePicker.getCurrentText(), "currentText");
		encodeOptionComponentByType(options, datePicker.getDateFormat(), "dateFormat");
		encodeOptionComponentByType(options, datePicker.getDayNames(), "dayNames");
		encodeOptionComponentByType(options, datePicker.getDayNamesMin(), "dayNamesMin");
		encodeOptionComponentByType(options, datePicker.getDayNamesShort(), "dayNamesShort");
		encodeOptionComponentByType(options, datePicker.getDefaultDate(), "defaultDate");
		encodeOptionComponentByType(options, datePicker.getDuration(), "duration");
		encodeOptionComponentByType(options, datePicker.getFirstDay(), "firstDay");
		encodeOptionComponentByType(options, datePicker.isGotoCurrent(), "gotoCurrent");
		encodeOptionComponentByType(options, datePicker.isHideIfNoPrevNext(), "hideIfNoPrevNext");
		encodeOptionComponentByType(options, datePicker.getMaxDate(), "maxDate");
		encodeOptionComponentByType(options, datePicker.getMinDate(), "minDate");
		encodeOptionComponentByType(options, datePicker.getMonthNames(), "monthNames");
		encodeOptionComponentByType(options, datePicker.getMonthNamesShort(), "monthNamesShort");
		encodeOptionComponentByType(options, datePicker.isNavigationAsDateFormat(), "navigationAsDateFormat");
		encodeOptionComponentByType(options, datePicker.getNextText(), "nextText");
		encodeOptionComponentByType(options, datePicker.getNumberOfMonths(), "numberOfMonths");
		encodeOptionComponentByType(options, datePicker.getPrevText(), "prevText");
		encodeOptionComponentByType(options, datePicker.getShortYearCutoff(), "shortYearCutoff");
		encodeOptionComponentByType(options, datePicker.getShowAnim(), "showAnim");
		encodeOptionComponentByType(options, datePicker.isShowButtonPanel(), "showButtonPanel");
		encodeOptionComponentByType(options, datePicker.getShowCurrentAtPos(), "showCurrentAtPos");
		encodeOptionComponentByType(options, datePicker.isShowMonthAfterYear(), "showMonthAfterYear");
		encodeOptionComponentByType(options, datePicker.getShowOn(), "showOn");
		encodeOptionComponentByType(options, datePicker.getShowOptions(), "showOptions");
		encodeOptionComponentByType(options, datePicker.isShowOtherMonths(), "showOtherMonths");
		encodeOptionComponentByType(options, datePicker.getStepMonths(), "stepMonths");
		encodeOptionComponentByType(options, datePicker.getYearRange(), "yearRange");
		encodeOptionComponentByType(options, datePicker.getOnbeforeShow(), "onbeforeShow");
		encodeOptionComponentByType(options, datePicker.getOnbeforeShowDay(), "onbeforeShowDay");
		encodeOptionComponentByType(options, datePicker.getOnchangeMonthYear(), "onchangeMonthYear");
		encodeOptionComponentByType(options, datePicker.getOnclose(), "onclose");
		encodeOptionComponentByType(options, datePicker.getOnselect(), "onselect");
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