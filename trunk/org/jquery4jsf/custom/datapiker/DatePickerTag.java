package org.jquery4jsf.custom.datapiker;

import javax.faces.component.UIComponent;

import org.jquery4jsf.component.ComponentUtilities;

import com.sun.faces.taglib.html_basic.InputTextTag;

public class DatePickerTag extends InputTextTag{

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
	private String RTL;//isRTL
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
		altField		= null;	
		altFormat               = null;
		appendText              = null;
		buttonImage             = null;
		buttonImageOnly         = null;
		buttonText              = null;
		changeMonth             = null;
		changeYear              = null;
		closeText               = null;
		constrainInput          = null;
		currentText             = null;
		dateFormat              = null;
		dayNames                = null;
		dayNamesMin             = null;
		dayNamesShort           = null;
		defaultDate             = null;
		duration                = null;
		firstDay                = null;
		gotoCurrent             = null;
		hideIfNoPrevNext        = null;
		RTL                     = null;
		maxDate                 = null;
		minDate                 = null;
		monthNames              = null;
		monthNamesShort         = null;
		navigationAsDateFormat  = null;
		nextText                = null;
		numberOfMonths          = null;
		prevText                = null;
		shortYearCutoff         = null;
		showAnim                = null;
		showButtonPanel         = null;
		showCurrentAtPos        = null;
		showMonthAfterYear      = null;
		showOn                  = null;
		showOptions             = null;
		showOtherMonths         = null;
		stepMonths              = null;
		yearRange               = null;
		onbeforeShow            = null;
		onbeforeShowDay         = null;
		onchangeMonthYear       = null;
		onclose                 = null;
		onselect		= null;	
	}
	
	public String getComponentType() {
		return DatePicker.COMPONENT_TYPE;
	}
	
	public String getRendererType() {
		return DatePicker.DEFAULT_RENDERER_TYPE;
	}
	
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "altField", altField);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "altFormat",altFormat );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "appendText",appendText );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "buttonImage",buttonImage );
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "buttonImageOnly",buttonImageOnly );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "buttonText", buttonText);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "changeMonth",changeMonth );
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "changeYear",changeYear );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "closeText",closeText );
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "constrainInput",constrainInput );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "currentText",currentText );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "dateFormat",dateFormat );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "dayNames",dayNames );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "dayNamesMin",dayNamesMin );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "dayNamesShort",dayNamesShort );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "defaultDate",defaultDate );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "duration",duration );
		ComponentUtilities.setIntegerProperty(getFacesContext(),component, "firstDay",firstDay );
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "gotoCurrent",gotoCurrent );
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "hideIfNoPrevNext",hideIfNoPrevNext );
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "RTL",RTL );//isRTL
		ComponentUtilities.setStringProperty(getFacesContext(),component, "maxDate", maxDate);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "minDate",minDate );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "monthNames", monthNames);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "monthNamesShort", monthNamesShort);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "navigationAsDateFormat", navigationAsDateFormat);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "nextText",nextText );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "numberOfMonths",numberOfMonths);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "prevText", prevText);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "shortYearCutoff", shortYearCutoff);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "showAnim", showAnim);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "showButtonPanel",showButtonPanel);
		ComponentUtilities.setIntegerProperty(getFacesContext(),component, "showCurrentAtPos",showCurrentAtPos);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "showMonthAfterYear",showMonthAfterYear );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "showOn",showOn );
		ComponentUtilities.setStringProperty(getFacesContext(),component, "showOptions",showOptions );
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "showOtherMonths",showOtherMonths);
		ComponentUtilities.setIntegerProperty(getFacesContext(),component, "stepMonths", stepMonths);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "yearRange",yearRange);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "onbeforeShow",onbeforeShow);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "onbeforeShowDay",onbeforeShowDay);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "onchangeMonthYear",onchangeMonthYear);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "onclose",onclose);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "onselect",onselect);
	}



	public void setAltField(String altField) {
		this.altField = altField;
	}
	public void setAltFormat(String altFormat) {
		this.altFormat = altFormat;
	}
	public void setAppendText(String appendText) {
		this.appendText = appendText;
	}
	public void setButtonImage(String buttonImage) {
		this.buttonImage = buttonImage;
	}
	public void setButtonImageOnly(String buttonImageOnly) {
		this.buttonImageOnly = buttonImageOnly;
	}
	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}
	public void setChangeMonth(String changeMonth) {
		this.changeMonth = changeMonth;
	}
	public void setChangeYear(String changeYear) {
		this.changeYear = changeYear;
	}
	public void setCloseText(String closeText) {
		this.closeText = closeText;
	}
	public void setConstrainInput(String constrainInput) {
		this.constrainInput = constrainInput;
	}
	public void setCurrentText(String currentText) {
		this.currentText = currentText;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public void setDayNames(String dayNames) {
		this.dayNames = dayNames;
	}
	public void setDayNamesMin(String dayNamesMin) {
		this.dayNamesMin = dayNamesMin;
	}
	public void setDayNamesShort(String dayNamesShort) {
		this.dayNamesShort = dayNamesShort;
	}
	public void setDefaultDate(String defaultDate) {
		this.defaultDate = defaultDate;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void setFirstDay(String firstDay) {
		this.firstDay = firstDay;
	}
	public void setGotoCurrent(String gotoCurrent) {
		this.gotoCurrent = gotoCurrent;
	}
	public void setHideIfNoPrevNext(String hideIfNoPrevNext) {
		this.hideIfNoPrevNext = hideIfNoPrevNext;
	}
	public void setRTL(String rtl) {
		RTL = rtl;
	}
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}
	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}
	public void setMonthNames(String monthNames) {
		this.monthNames = monthNames;
	}
	public void setMonthNamesShort(String monthNamesShort) {
		this.monthNamesShort = monthNamesShort;
	}
	public void setNavigationAsDateFormat(String navigationAsDateFormat) {
		this.navigationAsDateFormat = navigationAsDateFormat;
	}
	public void setNextText(String nextText) {
		this.nextText = nextText;
	}
	public void setNumberOfMonths(String numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}
	public void setPrevText(String prevText) {
		this.prevText = prevText;
	}
	public void setShortYearCutoff(String shortYearCutoff) {
		this.shortYearCutoff = shortYearCutoff;
	}
	public void setShowAnim(String showAnim) {
		this.showAnim = showAnim;
	}
	public void setShowButtonPanel(String showButtonPanel) {
		this.showButtonPanel = showButtonPanel;
	}
	public void setShowCurrentAtPos(String showCurrentAtPos) {
		this.showCurrentAtPos = showCurrentAtPos;
	}
	public void setShowMonthAfterYear(String showMonthAfterYear) {
		this.showMonthAfterYear = showMonthAfterYear;
	}
	public void setShowOn(String showOn) {
		this.showOn = showOn;
	}
	public void setShowOptions(String showOptions) {
		this.showOptions = showOptions;
	}
	public void setShowOtherMonths(String showOtherMonths) {
		this.showOtherMonths = showOtherMonths;
	}
	public void setStepMonths(String stepMonths) {
		this.stepMonths = stepMonths;
	}
	public void setYearRange(String yearRange) {
		this.yearRange = yearRange;
	}
	public void setOnbeforeShow(String onbeforeShow) {
		this.onbeforeShow = onbeforeShow;
	}
	public void setOnbeforeShowDay(String onbeforeShowDay) {
		this.onbeforeShowDay = onbeforeShowDay;
	}
	public void setOnchangeMonthYear(String onchangeMonthYear) {
		this.onchangeMonthYear = onchangeMonthYear;
	}
	public void setOnclose(String onclose) {
		this.onclose = onclose;
	}
	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}
}
