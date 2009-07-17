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

import org.jquery4jsf.custom.datepicker.DatePicker;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Object;
import javax.faces.convert.Converter;
import javax.faces.validator.Validator;
import javax.faces.event.ValueChangeListener;
import java.lang.Integer;

public class Calendar extends DatePicker implements JQueryHtmlObject {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlCalendar";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Calendar";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.CalendarRenderer";

	private String[] resources;
	private String locale;
	private String altField;
	private String altFormat;
	private String appendText;
	private String buttonImage;
	private Boolean buttonImageOnly;
	private String buttonText;
	private Boolean changeMonth;
	private Boolean changeYear;
	private String closeText;
	private Boolean constrainInput;
	private String currentText;
	private String dateFormat;
	private String dayNames;
	private String dayNamesMin;
	private String dayNamesShort;
	private String defaultDate;
	private String duration;
	private Integer firstDay;
	private Boolean gotoCurrent;
	private Boolean hideIfNoPrevNext;
	private String maxDate;
	private String minDate;
	private String monthNames;
	private String monthNamesShort;
	private Boolean navigationAsDateFormat;
	private String nextText;
	private String numberOfMonths;
	private String prevText;
	private String shortYearCutoff;
	private String showAnim;
	private Boolean showButtonPanel;
	private Integer showCurrentAtPos;
	private Boolean showMonthAfterYear;
	private String showOn;
	private String showOptions;
	private Boolean showOtherMonths;
	private Integer stepMonths;
	private String yearRange;
	private String onbeforeShow;
	private String onbeforeShowDay;
	private String onchangeMonthYear;
	private String onclose;
	private String onselect;

	public Calendar() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"ui/ui.core.js",
			"datepicker/ui.datepicker.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getLocale() {
		if(locale != null )
			return locale;

		String oValue = (String) getLocalOrValueBindingValue(locale, "locale");
		return oValue != null ? oValue : null;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getAltField() {
		if(altField != null )
			return altField;

		String oValue = (String) getLocalOrValueBindingValue(altField, "altField");
		return oValue != null ? oValue : null;
	}
	public void setAltField(String altField) {
		this.altField = altField;
	}

	public String getAltFormat() {
		if(altFormat != null )
			return altFormat;

		String oValue = (String) getLocalOrValueBindingValue(altFormat, "altFormat");
		return oValue != null ? oValue : null;
	}
	public void setAltFormat(String altFormat) {
		this.altFormat = altFormat;
	}

	public String getAppendText() {
		if(appendText != null )
			return appendText;

		String oValue = (String) getLocalOrValueBindingValue(appendText, "appendText");
		return oValue != null ? oValue : null;
	}
	public void setAppendText(String appendText) {
		this.appendText = appendText;
	}

	public String getButtonImage() {
		if(buttonImage != null )
			return buttonImage;

		String oValue = (String) getLocalOrValueBindingValue(buttonImage, "buttonImage");
		return oValue != null ? oValue : null;
	}
	public void setButtonImage(String buttonImage) {
		this.buttonImage = buttonImage;
	}

	public boolean isButtonImageOnly() {
		if(buttonImageOnly != null )
			return buttonImageOnly.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(buttonImageOnly, "buttonImageOnly");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setButtonImageOnly(boolean buttonImageOnly) {
		this.buttonImageOnly = new Boolean(buttonImageOnly);
	}

	public String getButtonText() {
		if(buttonText != null )
			return buttonText;

		String oValue = (String) getLocalOrValueBindingValue(buttonText, "buttonText");
		return oValue != null ? oValue : null;
	}
	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public boolean isChangeMonth() {
		if(changeMonth != null )
			return changeMonth.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(changeMonth, "changeMonth");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setChangeMonth(boolean changeMonth) {
		this.changeMonth = new Boolean(changeMonth);
	}

	public boolean isChangeYear() {
		if(changeYear != null )
			return changeYear.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(changeYear, "changeYear");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setChangeYear(boolean changeYear) {
		this.changeYear = new Boolean(changeYear);
	}

	public String getCloseText() {
		if(closeText != null )
			return closeText;

		String oValue = (String) getLocalOrValueBindingValue(closeText, "closeText");
		return oValue != null ? oValue : null;
	}
	public void setCloseText(String closeText) {
		this.closeText = closeText;
	}

	public boolean isConstrainInput() {
		if(constrainInput != null )
			return constrainInput.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(constrainInput, "constrainInput");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setConstrainInput(boolean constrainInput) {
		this.constrainInput = new Boolean(constrainInput);
	}

	public String getCurrentText() {
		if(currentText != null )
			return currentText;

		String oValue = (String) getLocalOrValueBindingValue(currentText, "currentText");
		return oValue != null ? oValue : null;
	}
	public void setCurrentText(String currentText) {
		this.currentText = currentText;
	}

	public String getDateFormat() {
		if(dateFormat != null )
			return dateFormat;

		String oValue = (String) getLocalOrValueBindingValue(dateFormat, "dateFormat");
		return oValue != null ? oValue : null;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDayNames() {
		if(dayNames != null )
			return dayNames;

		String oValue = (String) getLocalOrValueBindingValue(dayNames, "dayNames");
		return oValue != null ? oValue : null;
	}
	public void setDayNames(String dayNames) {
		this.dayNames = dayNames;
	}

	public String getDayNamesMin() {
		if(dayNamesMin != null )
			return dayNamesMin;

		String oValue = (String) getLocalOrValueBindingValue(dayNamesMin, "dayNamesMin");
		return oValue != null ? oValue : null;
	}
	public void setDayNamesMin(String dayNamesMin) {
		this.dayNamesMin = dayNamesMin;
	}

	public String getDayNamesShort() {
		if(dayNamesShort != null )
			return dayNamesShort;

		String oValue = (String) getLocalOrValueBindingValue(dayNamesShort, "dayNamesShort");
		return oValue != null ? oValue : null;
	}
	public void setDayNamesShort(String dayNamesShort) {
		this.dayNamesShort = dayNamesShort;
	}

	public String getDefaultDate() {
		if(defaultDate != null )
			return defaultDate;

		String oValue = (String) getLocalOrValueBindingValue(defaultDate, "defaultDate");
		return oValue != null ? oValue : null;
	}
	public void setDefaultDate(String defaultDate) {
		this.defaultDate = defaultDate;
	}

	public String getDuration() {
		if(duration != null )
			return duration;

		String oValue = (String) getLocalOrValueBindingValue(duration, "duration");
		return oValue != null ? oValue : null;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getFirstDay() {
		if(firstDay != null )
			return firstDay.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(firstDay, "firstDay");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setFirstDay(int firstDay) {
		this.firstDay = new Integer(firstDay);
	}

	public boolean isGotoCurrent() {
		if(gotoCurrent != null )
			return gotoCurrent.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(gotoCurrent, "gotoCurrent");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setGotoCurrent(boolean gotoCurrent) {
		this.gotoCurrent = new Boolean(gotoCurrent);
	}

	public boolean isHideIfNoPrevNext() {
		if(hideIfNoPrevNext != null )
			return hideIfNoPrevNext.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(hideIfNoPrevNext, "hideIfNoPrevNext");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setHideIfNoPrevNext(boolean hideIfNoPrevNext) {
		this.hideIfNoPrevNext = new Boolean(hideIfNoPrevNext);
	}

	public String getMaxDate() {
		if(maxDate != null )
			return maxDate;

		String oValue = (String) getLocalOrValueBindingValue(maxDate, "maxDate");
		return oValue != null ? oValue : null;
	}
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	public String getMinDate() {
		if(minDate != null )
			return minDate;

		String oValue = (String) getLocalOrValueBindingValue(minDate, "minDate");
		return oValue != null ? oValue : null;
	}
	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}

	public String getMonthNames() {
		if(monthNames != null )
			return monthNames;

		String oValue = (String) getLocalOrValueBindingValue(monthNames, "monthNames");
		return oValue != null ? oValue : null;
	}
	public void setMonthNames(String monthNames) {
		this.monthNames = monthNames;
	}

	public String getMonthNamesShort() {
		if(monthNamesShort != null )
			return monthNamesShort;

		String oValue = (String) getLocalOrValueBindingValue(monthNamesShort, "monthNamesShort");
		return oValue != null ? oValue : null;
	}
	public void setMonthNamesShort(String monthNamesShort) {
		this.monthNamesShort = monthNamesShort;
	}

	public boolean isNavigationAsDateFormat() {
		if(navigationAsDateFormat != null )
			return navigationAsDateFormat.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(navigationAsDateFormat, "navigationAsDateFormat");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setNavigationAsDateFormat(boolean navigationAsDateFormat) {
		this.navigationAsDateFormat = new Boolean(navigationAsDateFormat);
	}

	public String getNextText() {
		if(nextText != null )
			return nextText;

		String oValue = (String) getLocalOrValueBindingValue(nextText, "nextText");
		return oValue != null ? oValue : null;
	}
	public void setNextText(String nextText) {
		this.nextText = nextText;
	}

	public String getNumberOfMonths() {
		if(numberOfMonths != null )
			return numberOfMonths;

		String oValue = (String) getLocalOrValueBindingValue(numberOfMonths, "numberOfMonths");
		return oValue != null ? oValue : "1";
	}
	public void setNumberOfMonths(String numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	public String getPrevText() {
		if(prevText != null )
			return prevText;

		String oValue = (String) getLocalOrValueBindingValue(prevText, "prevText");
		return oValue != null ? oValue : null;
	}
	public void setPrevText(String prevText) {
		this.prevText = prevText;
	}

	public String getShortYearCutoff() {
		if(shortYearCutoff != null )
			return shortYearCutoff;

		String oValue = (String) getLocalOrValueBindingValue(shortYearCutoff, "shortYearCutoff");
		return oValue != null ? oValue : null;
	}
	public void setShortYearCutoff(String shortYearCutoff) {
		this.shortYearCutoff = shortYearCutoff;
	}

	public String getShowAnim() {
		if(showAnim != null )
			return showAnim;

		String oValue = (String) getLocalOrValueBindingValue(showAnim, "showAnim");
		return oValue != null ? oValue : null;
	}
	public void setShowAnim(String showAnim) {
		this.showAnim = showAnim;
	}

	public boolean isShowButtonPanel() {
		if(showButtonPanel != null )
			return showButtonPanel.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(showButtonPanel, "showButtonPanel");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setShowButtonPanel(boolean showButtonPanel) {
		this.showButtonPanel = new Boolean(showButtonPanel);
	}

	public int getShowCurrentAtPos() {
		if(showCurrentAtPos != null )
			return showCurrentAtPos.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(showCurrentAtPos, "showCurrentAtPos");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setShowCurrentAtPos(int showCurrentAtPos) {
		this.showCurrentAtPos = new Integer(showCurrentAtPos);
	}

	public boolean isShowMonthAfterYear() {
		if(showMonthAfterYear != null )
			return showMonthAfterYear.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(showMonthAfterYear, "showMonthAfterYear");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setShowMonthAfterYear(boolean showMonthAfterYear) {
		this.showMonthAfterYear = new Boolean(showMonthAfterYear);
	}

	public String getShowOn() {
		if(showOn != null )
			return showOn;

		String oValue = (String) getLocalOrValueBindingValue(showOn, "showOn");
		return oValue != null ? oValue : null;
	}
	public void setShowOn(String showOn) {
		this.showOn = showOn;
	}

	public String getShowOptions() {
		if(showOptions != null )
			return showOptions;

		String oValue = (String) getLocalOrValueBindingValue(showOptions, "showOptions");
		return oValue != null ? oValue : null;
	}
	public void setShowOptions(String showOptions) {
		this.showOptions = showOptions;
	}

	public boolean isShowOtherMonths() {
		if(showOtherMonths != null )
			return showOtherMonths.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(showOtherMonths, "showOtherMonths");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setShowOtherMonths(boolean showOtherMonths) {
		this.showOtherMonths = new Boolean(showOtherMonths);
	}

	public int getStepMonths() {
		if(stepMonths != null )
			return stepMonths.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(stepMonths, "stepMonths");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setStepMonths(int stepMonths) {
		this.stepMonths = new Integer(stepMonths);
	}

	public String getYearRange() {
		if(yearRange != null )
			return yearRange;

		String oValue = (String) getLocalOrValueBindingValue(yearRange, "yearRange");
		return oValue != null ? oValue : null;
	}
	public void setYearRange(String yearRange) {
		this.yearRange = yearRange;
	}

	public String getOnbeforeShow() {
		if(onbeforeShow != null )
			return onbeforeShow;

		String oValue = (String) getLocalOrValueBindingValue(onbeforeShow, "onbeforeShow");
		return oValue != null ? oValue : null;
	}
	public void setOnbeforeShow(String onbeforeShow) {
		this.onbeforeShow = onbeforeShow;
	}

	public String getOnbeforeShowDay() {
		if(onbeforeShowDay != null )
			return onbeforeShowDay;

		String oValue = (String) getLocalOrValueBindingValue(onbeforeShowDay, "onbeforeShowDay");
		return oValue != null ? oValue : null;
	}
	public void setOnbeforeShowDay(String onbeforeShowDay) {
		this.onbeforeShowDay = onbeforeShowDay;
	}

	public String getOnchangeMonthYear() {
		if(onchangeMonthYear != null )
			return onchangeMonthYear;

		String oValue = (String) getLocalOrValueBindingValue(onchangeMonthYear, "onchangeMonthYear");
		return oValue != null ? oValue : null;
	}
	public void setOnchangeMonthYear(String onchangeMonthYear) {
		this.onchangeMonthYear = onchangeMonthYear;
	}

	public String getOnclose() {
		if(onclose != null )
			return onclose;

		String oValue = (String) getLocalOrValueBindingValue(onclose, "onclose");
		return oValue != null ? oValue : null;
	}
	public void setOnclose(String onclose) {
		this.onclose = onclose;
	}

	public String getOnselect() {
		if(onselect != null )
			return onselect;

		String oValue = (String) getLocalOrValueBindingValue(onselect, "onselect");
		return oValue != null ? oValue : null;
	}
	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[45];
		values[0] = super.saveState(context);
		values[1] = this.locale;
		values[2] = this.altField;
		values[3] = this.altFormat;
		values[4] = this.appendText;
		values[5] = this.buttonImage;
		values[6] = this.buttonImageOnly;
		values[7] = this.buttonText;
		values[8] = this.changeMonth;
		values[9] = this.changeYear;
		values[10] = this.closeText;
		values[11] = this.constrainInput;
		values[12] = this.currentText;
		values[13] = this.dateFormat;
		values[14] = this.dayNames;
		values[15] = this.dayNamesMin;
		values[16] = this.dayNamesShort;
		values[17] = this.defaultDate;
		values[18] = this.duration;
		values[19] = this.firstDay;
		values[20] = this.gotoCurrent;
		values[21] = this.hideIfNoPrevNext;
		values[22] = this.maxDate;
		values[23] = this.minDate;
		values[24] = this.monthNames;
		values[25] = this.monthNamesShort;
		values[26] = this.navigationAsDateFormat;
		values[27] = this.nextText;
		values[28] = this.numberOfMonths;
		values[29] = this.prevText;
		values[30] = this.shortYearCutoff;
		values[31] = this.showAnim;
		values[32] = this.showButtonPanel;
		values[33] = this.showCurrentAtPos;
		values[34] = this.showMonthAfterYear;
		values[35] = this.showOn;
		values[36] = this.showOptions;
		values[37] = this.showOtherMonths;
		values[38] = this.stepMonths;
		values[39] = this.yearRange;
		values[40] = this.onbeforeShow;
		values[41] = this.onbeforeShowDay;
		values[42] = this.onchangeMonthYear;
		values[43] = this.onclose;
		values[44] = this.onselect;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.locale = (String) values[1];
		this.altField = (String) values[2];
		this.altFormat = (String) values[3];
		this.appendText = (String) values[4];
		this.buttonImage = (String) values[5];
		this.buttonImageOnly = (Boolean) values[6];
		this.buttonText = (String) values[7];
		this.changeMonth = (Boolean) values[8];
		this.changeYear = (Boolean) values[9];
		this.closeText = (String) values[10];
		this.constrainInput = (Boolean) values[11];
		this.currentText = (String) values[12];
		this.dateFormat = (String) values[13];
		this.dayNames = (String) values[14];
		this.dayNamesMin = (String) values[15];
		this.dayNamesShort = (String) values[16];
		this.defaultDate = (String) values[17];
		this.duration = (String) values[18];
		this.firstDay = (Integer) values[19];
		this.gotoCurrent = (Boolean) values[20];
		this.hideIfNoPrevNext = (Boolean) values[21];
		this.maxDate = (String) values[22];
		this.minDate = (String) values[23];
		this.monthNames = (String) values[24];
		this.monthNamesShort = (String) values[25];
		this.navigationAsDateFormat = (Boolean) values[26];
		this.nextText = (String) values[27];
		this.numberOfMonths = (String) values[28];
		this.prevText = (String) values[29];
		this.shortYearCutoff = (String) values[30];
		this.showAnim = (String) values[31];
		this.showButtonPanel = (Boolean) values[32];
		this.showCurrentAtPos = (Integer) values[33];
		this.showMonthAfterYear = (Boolean) values[34];
		this.showOn = (String) values[35];
		this.showOptions = (String) values[36];
		this.showOtherMonths = (Boolean) values[37];
		this.stepMonths = (Integer) values[38];
		this.yearRange = (String) values[39];
		this.onbeforeShow = (String) values[40];
		this.onbeforeShowDay = (String) values[41];
		this.onchangeMonthYear = (String) values[42];
		this.onclose = (String) values[43];
		this.onselect = (String) values[44];
	}

	public String[] getResources() {
		return resources;
	}

	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}

	public void encodeScript(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof org.jquery4jsf.renderkit.JQueryRenderer) {
			((org.jquery4jsf.renderkit.JQueryRenderer)renderer).encodeScript(facesContext, this);
		}
	}
}