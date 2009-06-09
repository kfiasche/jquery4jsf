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
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class DatePickerTag extends UIComponentTagBase {

	private String value;
	private String converter;
	private String immediate;
	private String required;
	private String validator;
	private String valueChangeListener;
	private String requiredMessage;
	private String converterMessage;
	private String validatorMessage;
	private String accesskey;
	private String alt;
	private String dir;
	private String disabled;
	private String lang;
	private String maxlength;
	private String onblur;
	private String onchange;
	private String onclick;
	private String ondblclick;
	private String onfocus;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onmousedown;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String readonly;
	private String size;
	private String style;
	private String styleClass;
	private String tabindex;
	private String title;
	private String locale;
	private String altField;
	private String altFormat;
	private String appendText;
	private String buttonImage;
	private String buttonImageOnly;
	private String buttonText;
	private String changeMonth;
	private String changeYear;
	private String closeText;
	private String constrainInput;
	private String currentText;
	private String dateFormat;
	private String dayNames;
	private String dayNamesMin;
	private String dayNamesShort;
	private String defaultDate;
	private String duration;
	private String firstDay;
	private String gotoCurrent;
	private String hideIfNoPrevNext;
	private String maxDate;
	private String minDate;
	private String monthNames;
	private String monthNamesShort;
	private String navigationAsDateFormat;
	private String nextText;
	private String numberOfMonths;
	private String prevText;
	private String shortYearCutoff;
	private String showAnim;
	private String showButtonPanel;
	private String showCurrentAtPos;
	private String showMonthAfterYear;
	private String showOn;
	private String showOptions;
	private String showOtherMonths;
	private String stepMonths;
	private String yearRange;
	private String onbeforeShow;
	private String onbeforeShowDay;
	private String onchangeMonthYear;
	private String onclose;
	private String onselect;

	public void release(){
		super.release();
		this.value = null;
		this.converter = null;
		this.immediate = null;
		this.required = null;
		this.validator = null;
		this.valueChangeListener = null;
		this.requiredMessage = null;
		this.converterMessage = null;
		this.validatorMessage = null;
		this.accesskey = null;
		this.alt = null;
		this.dir = null;
		this.disabled = null;
		this.lang = null;
		this.maxlength = null;
		this.onblur = null;
		this.onchange = null;
		this.onclick = null;
		this.ondblclick = null;
		this.onfocus = null;
		this.onkeydown = null;
		this.onkeypress = null;
		this.onkeyup = null;
		this.onmousedown = null;
		this.onmousemove = null;
		this.onmouseout = null;
		this.onmouseover = null;
		this.onmouseup = null;
		this.readonly = null;
		this.size = null;
		this.style = null;
		this.styleClass = null;
		this.tabindex = null;
		this.title = null;
		this.locale = null;
		this.altField = null;
		this.altFormat = null;
		this.appendText = null;
		this.buttonImage = null;
		this.buttonImageOnly = null;
		this.buttonText = null;
		this.changeMonth = null;
		this.changeYear = null;
		this.closeText = null;
		this.constrainInput = null;
		this.currentText = null;
		this.dateFormat = null;
		this.dayNames = null;
		this.dayNamesMin = null;
		this.dayNamesShort = null;
		this.defaultDate = null;
		this.duration = null;
		this.firstDay = null;
		this.gotoCurrent = null;
		this.hideIfNoPrevNext = null;
		this.maxDate = null;
		this.minDate = null;
		this.monthNames = null;
		this.monthNamesShort = null;
		this.navigationAsDateFormat = null;
		this.nextText = null;
		this.numberOfMonths = null;
		this.prevText = null;
		this.shortYearCutoff = null;
		this.showAnim = null;
		this.showButtonPanel = null;
		this.showCurrentAtPos = null;
		this.showMonthAfterYear = null;
		this.showOn = null;
		this.showOptions = null;
		this.showOtherMonths = null;
		this.stepMonths = null;
		this.yearRange = null;
		this.onbeforeShow = null;
		this.onbeforeShowDay = null;
		this.onchangeMonthYear = null;
		this.onclose = null;
		this.onselect = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.datepicker.DatePicker component = null;
		try {
			component = (org.jquery4jsf.custom.datepicker.DatePicker) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setValueProperty(getFacesContext(), component, "value", value);
		setConverterProperty(getFacesContext(), component, "converter", converter);
		setBooleanProperty(getFacesContext(), component, "immediate", immediate);
		setBooleanProperty(getFacesContext(), component, "required", required);
		setValidatorProperty(getFacesContext(), component, "validator", validator);
		setValueChangeListenerProperty(getFacesContext(), component, "valueChangeListener", valueChangeListener);
		setStringProperty(getFacesContext(), component, "requiredMessage", requiredMessage);
		setStringProperty(getFacesContext(), component, "converterMessage", converterMessage);
		setStringProperty(getFacesContext(), component, "validatorMessage", validatorMessage);
		setStringProperty(getFacesContext(), component, "accesskey", accesskey);
		setStringProperty(getFacesContext(), component, "alt", alt);
		setStringProperty(getFacesContext(), component, "dir", dir);
		setBooleanProperty(getFacesContext(), component, "disabled", disabled);
		setStringProperty(getFacesContext(), component, "lang", lang);
		setIntegerProperty(getFacesContext(), component, "maxlength", maxlength);
		setStringProperty(getFacesContext(), component, "onblur", onblur);
		setStringProperty(getFacesContext(), component, "onchange", onchange);
		setStringProperty(getFacesContext(), component, "onclick", onclick);
		setStringProperty(getFacesContext(), component, "ondblclick", ondblclick);
		setStringProperty(getFacesContext(), component, "onfocus", onfocus);
		setStringProperty(getFacesContext(), component, "onkeydown", onkeydown);
		setStringProperty(getFacesContext(), component, "onkeypress", onkeypress);
		setStringProperty(getFacesContext(), component, "onkeyup", onkeyup);
		setStringProperty(getFacesContext(), component, "onmousedown", onmousedown);
		setStringProperty(getFacesContext(), component, "onmousemove", onmousemove);
		setStringProperty(getFacesContext(), component, "onmouseout", onmouseout);
		setStringProperty(getFacesContext(), component, "onmouseover", onmouseover);
		setStringProperty(getFacesContext(), component, "onmouseup", onmouseup);
		setBooleanProperty(getFacesContext(), component, "readonly", readonly);
		setIntegerProperty(getFacesContext(), component, "size", size);
		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setStringProperty(getFacesContext(), component, "tabindex", tabindex);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "locale", locale);
		setStringProperty(getFacesContext(), component, "altField", altField);
		setStringProperty(getFacesContext(), component, "altFormat", altFormat);
		setStringProperty(getFacesContext(), component, "appendText", appendText);
		setStringProperty(getFacesContext(), component, "buttonImage", buttonImage);
		setBooleanProperty(getFacesContext(), component, "buttonImageOnly", buttonImageOnly);
		setStringProperty(getFacesContext(), component, "buttonText", buttonText);
		setBooleanProperty(getFacesContext(), component, "changeMonth", changeMonth);
		setBooleanProperty(getFacesContext(), component, "changeYear", changeYear);
		setStringProperty(getFacesContext(), component, "closeText", closeText);
		setBooleanProperty(getFacesContext(), component, "constrainInput", constrainInput);
		setStringProperty(getFacesContext(), component, "currentText", currentText);
		setStringProperty(getFacesContext(), component, "dateFormat", dateFormat);
		setStringProperty(getFacesContext(), component, "dayNames", dayNames);
		setStringProperty(getFacesContext(), component, "dayNamesMin", dayNamesMin);
		setStringProperty(getFacesContext(), component, "dayNamesShort", dayNamesShort);
		setStringProperty(getFacesContext(), component, "defaultDate", defaultDate);
		setStringProperty(getFacesContext(), component, "duration", duration);
		setIntegerProperty(getFacesContext(), component, "firstDay", firstDay);
		setBooleanProperty(getFacesContext(), component, "gotoCurrent", gotoCurrent);
		setBooleanProperty(getFacesContext(), component, "hideIfNoPrevNext", hideIfNoPrevNext);
		setStringProperty(getFacesContext(), component, "maxDate", maxDate);
		setStringProperty(getFacesContext(), component, "minDate", minDate);
		setStringProperty(getFacesContext(), component, "monthNames", monthNames);
		setStringProperty(getFacesContext(), component, "monthNamesShort", monthNamesShort);
		setBooleanProperty(getFacesContext(), component, "navigationAsDateFormat", navigationAsDateFormat);
		setStringProperty(getFacesContext(), component, "nextText", nextText);
		setStringProperty(getFacesContext(), component, "numberOfMonths", numberOfMonths);
		setStringProperty(getFacesContext(), component, "prevText", prevText);
		setStringProperty(getFacesContext(), component, "shortYearCutoff", shortYearCutoff);
		setStringProperty(getFacesContext(), component, "showAnim", showAnim);
		setBooleanProperty(getFacesContext(), component, "showButtonPanel", showButtonPanel);
		setIntegerProperty(getFacesContext(), component, "showCurrentAtPos", showCurrentAtPos);
		setBooleanProperty(getFacesContext(), component, "showMonthAfterYear", showMonthAfterYear);
		setStringProperty(getFacesContext(), component, "showOn", showOn);
		setStringProperty(getFacesContext(), component, "showOptions", showOptions);
		setBooleanProperty(getFacesContext(), component, "showOtherMonths", showOtherMonths);
		setIntegerProperty(getFacesContext(), component, "stepMonths", stepMonths);
		setStringProperty(getFacesContext(), component, "yearRange", yearRange);
		setStringProperty(getFacesContext(), component, "onbeforeShow", onbeforeShow);
		setStringProperty(getFacesContext(), component, "onbeforeShowDay", onbeforeShowDay);
		setStringProperty(getFacesContext(), component, "onchangeMonthYear", onchangeMonthYear);
		setStringProperty(getFacesContext(), component, "onclose", onclose);
		setStringProperty(getFacesContext(), component, "onselect", onselect);
	}

	public String getComponentType() {
		return DatePicker.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.DatePickerRenderer";
	}

	public void setValue(String value){
		this.value = value;
	}

	public void setConverter(String value){
		this.converter = value;
	}

	public void setImmediate(String value){
		this.immediate = value;
	}

	public void setRequired(String value){
		this.required = value;
	}

	public void setValidator(String value){
		this.validator = value;
	}

	public void setValueChangeListener(String value){
		this.valueChangeListener = value;
	}

	public void setRequiredMessage(String value){
		this.requiredMessage = value;
	}

	public void setConverterMessage(String value){
		this.converterMessage = value;
	}

	public void setValidatorMessage(String value){
		this.validatorMessage = value;
	}

	public void setAccesskey(String value){
		this.accesskey = value;
	}

	public void setAlt(String value){
		this.alt = value;
	}

	public void setDir(String value){
		this.dir = value;
	}

	public void setDisabled(String value){
		this.disabled = value;
	}

	public void setLang(String value){
		this.lang = value;
	}

	public void setMaxlength(String value){
		this.maxlength = value;
	}

	public void setOnblur(String value){
		this.onblur = value;
	}

	public void setOnchange(String value){
		this.onchange = value;
	}

	public void setOnclick(String value){
		this.onclick = value;
	}

	public void setOndblclick(String value){
		this.ondblclick = value;
	}

	public void setOnfocus(String value){
		this.onfocus = value;
	}

	public void setOnkeydown(String value){
		this.onkeydown = value;
	}

	public void setOnkeypress(String value){
		this.onkeypress = value;
	}

	public void setOnkeyup(String value){
		this.onkeyup = value;
	}

	public void setOnmousedown(String value){
		this.onmousedown = value;
	}

	public void setOnmousemove(String value){
		this.onmousemove = value;
	}

	public void setOnmouseout(String value){
		this.onmouseout = value;
	}

	public void setOnmouseover(String value){
		this.onmouseover = value;
	}

	public void setOnmouseup(String value){
		this.onmouseup = value;
	}

	public void setReadonly(String value){
		this.readonly = value;
	}

	public void setSize(String value){
		this.size = value;
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setTabindex(String value){
		this.tabindex = value;
	}

	public void setTitle(String value){
		this.title = value;
	}

	public void setLocale(String value){
		this.locale = value;
	}

	public void setAltField(String value){
		this.altField = value;
	}

	public void setAltFormat(String value){
		this.altFormat = value;
	}

	public void setAppendText(String value){
		this.appendText = value;
	}

	public void setButtonImage(String value){
		this.buttonImage = value;
	}

	public void setButtonImageOnly(String value){
		this.buttonImageOnly = value;
	}

	public void setButtonText(String value){
		this.buttonText = value;
	}

	public void setChangeMonth(String value){
		this.changeMonth = value;
	}

	public void setChangeYear(String value){
		this.changeYear = value;
	}

	public void setCloseText(String value){
		this.closeText = value;
	}

	public void setConstrainInput(String value){
		this.constrainInput = value;
	}

	public void setCurrentText(String value){
		this.currentText = value;
	}

	public void setDateFormat(String value){
		this.dateFormat = value;
	}

	public void setDayNames(String value){
		this.dayNames = value;
	}

	public void setDayNamesMin(String value){
		this.dayNamesMin = value;
	}

	public void setDayNamesShort(String value){
		this.dayNamesShort = value;
	}

	public void setDefaultDate(String value){
		this.defaultDate = value;
	}

	public void setDuration(String value){
		this.duration = value;
	}

	public void setFirstDay(String value){
		this.firstDay = value;
	}

	public void setGotoCurrent(String value){
		this.gotoCurrent = value;
	}

	public void setHideIfNoPrevNext(String value){
		this.hideIfNoPrevNext = value;
	}

	public void setMaxDate(String value){
		this.maxDate = value;
	}

	public void setMinDate(String value){
		this.minDate = value;
	}

	public void setMonthNames(String value){
		this.monthNames = value;
	}

	public void setMonthNamesShort(String value){
		this.monthNamesShort = value;
	}

	public void setNavigationAsDateFormat(String value){
		this.navigationAsDateFormat = value;
	}

	public void setNextText(String value){
		this.nextText = value;
	}

	public void setNumberOfMonths(String value){
		this.numberOfMonths = value;
	}

	public void setPrevText(String value){
		this.prevText = value;
	}

	public void setShortYearCutoff(String value){
		this.shortYearCutoff = value;
	}

	public void setShowAnim(String value){
		this.showAnim = value;
	}

	public void setShowButtonPanel(String value){
		this.showButtonPanel = value;
	}

	public void setShowCurrentAtPos(String value){
		this.showCurrentAtPos = value;
	}

	public void setShowMonthAfterYear(String value){
		this.showMonthAfterYear = value;
	}

	public void setShowOn(String value){
		this.showOn = value;
	}

	public void setShowOptions(String value){
		this.showOptions = value;
	}

	public void setShowOtherMonths(String value){
		this.showOtherMonths = value;
	}

	public void setStepMonths(String value){
		this.stepMonths = value;
	}

	public void setYearRange(String value){
		this.yearRange = value;
	}

	public void setOnbeforeShow(String value){
		this.onbeforeShow = value;
	}

	public void setOnbeforeShowDay(String value){
		this.onbeforeShowDay = value;
	}

	public void setOnchangeMonthYear(String value){
		this.onchangeMonthYear = value;
	}

	public void setOnclose(String value){
		this.onclose = value;
	}

	public void setOnselect(String value){
		this.onselect = value;
	}

}