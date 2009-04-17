package org.jquery4jsf.custom.datapiker;

import java.io.IOException;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.render.Renderer;

import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;

public class DatePicker extends HtmlInputText implements AjaxComponent, JQueryHtmlObject{

	private String[] resources = null;
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
	private Boolean RTL;//isRTL
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
	//Eventi:
	private String onbeforeShow;
	private String onbeforeShowDay;
	private String onchangeMonthYear;
	private String onclose;
	private String onselect;
	
	public static final String DEFAULT_RENDERER_TYPE = DatePickerRenderer.RENDERER_TYPE;
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.DatePicker";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlDatePicker";
	private static final boolean DEFAULT_CONSTRAIN_INPUT = false;	
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public DatePicker() {
		super();
		setRendererType(DEFAULT_RENDERER_TYPE);
		resources = new String[]{
				"jquery/jquery.js",
				"ui/ui.core.js",
				"datepicker/ui.datepicker.js",
				"themes/base/ui.all.css"
		};
	}

	public void restoreState(FacesContext context, Object state)
    {
        Object[] values = (Object[]) state;
        super.restoreState(context, values[0]);
        altField=              (String)values[1];  
        altFormat=             (String)values[2];  
        appendText=            (String)values[3];  
        buttonImage=           (String)values[4];  
        buttonImageOnly=       (Boolean)values[5];  
        buttonText=            (String)values[6];  
        changeMonth=   	       (Boolean)values[7];  
        changeYear=    	       (Boolean)values[8];  
        closeText=             (String)values[9];  
        constrainInput=        (Boolean)values[10]; 
        currentText=           (String)values[11]; 
        dateFormat=            (String)values[12]; 
        dayNames=              (String)values[13]; 
        dayNamesMin=           (String)values[14]; 
        dayNamesShort=         (String)values[15]; 
        defaultDate=           (String)values[16]; 
        duration=              (String)values[17]; 
        firstDay=              (Integer)values[18]; 
        gotoCurrent=           (Boolean)values[19]; 
        hideIfNoPrevNext=      (Boolean)values[20]; 
        RTL=          	       (Boolean)values[21]; 
        maxDate=               (String)values[22]; 
        minDate=               (String)values[23]; 
        monthNames=            (String)values[24]; 
        monthNamesShort=       (String)values[25]; 
        navigationAsDateFormat=(Boolean)values[26]; 
        nextText=              (String)values[27]; 
        numberOfMonths=        (String)values[28]; 
        prevText=              (String)values[29]; 
        shortYearCutoff=       (String)values[30]; 
        showAnim=              (String)values[31]; 
        showButtonPanel=       (Boolean)values[32]; 
        showCurrentAtPos=      (Integer)values[33]; 
        showMonthAfterYear=    (Boolean)values[34]; 
        showOn=                (String)values[35]; 
        showOptions=           (String)values[36]; 
        showOtherMonths=       (Boolean)values[37]; 
        stepMonths=            (Integer)values[38]; 
        yearRange=             (String)values[39]; 
        onbeforeShow=          (String)values[40]; 
        onbeforeShowDay=       (String)values[41]; 
        onchangeMonthYear=     (String)values[42]; 
        onclose=               (String)values[43]; 
        onselect=              (String)values[44]; 

    }
    public Object saveState(FacesContext context)
    {
        Object[] values = new Object[45];
        values[0] = super.saveState(context);
        values[1] = altField;
        values[2] = altFormat;
        values[3] = appendText;
        values[4] = buttonImage;
        values[5] = buttonImageOnly;
        values[6] = buttonText;
        values[7] = changeMonth;
        values[8] = changeYear;
        values[9] = closeText;
        values[10] = constrainInput;
        values[11] = currentText;
        values[12] = dateFormat;
        values[13] = dayNames;
        values[14] = dayNamesMin;
        values[15] = dayNamesShort;
        values[16] = defaultDate;
        values[17] = duration;
        values[18] = firstDay;
        values[19] = gotoCurrent;
        values[20] = hideIfNoPrevNext;
        values[21] = RTL;//isRTL
        values[22] = maxDate;
        values[23] = minDate;
        values[24] = monthNames;
        values[25] = monthNamesShort;
        values[26] = navigationAsDateFormat;
        values[27] = nextText;
        values[28] = numberOfMonths;
        values[29] = prevText;
        values[30] = shortYearCutoff;
        values[31] = showAnim;
        values[32] = showButtonPanel;
        values[33] = showCurrentAtPos;
        values[34] = showMonthAfterYear;
        values[35] = showOn;
        values[36] = showOptions;
        values[37] = showOtherMonths;
        values[38] = stepMonths;
        values[39] = yearRange;
        values[40] = onbeforeShow;
        values[41] = onbeforeShowDay;
        values[42] = onchangeMonthYear;
        values[43] = onclose;
        values[44] = onselect;
        return values;
    }
	
	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}

	
	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}
	
	public String getAltField() {
		return (String) getLocalOrValueBindingValue(altField, "altField");
	}

	public void setAltField(String altField) {
		this.altField = altField;
	}

	public String getAltFormat() {
		return (String) getLocalOrValueBindingValue(altFormat, "altFormat");
	}

	public void setAltFormat(String altFormat) {
		this.altFormat = altFormat;
	}

	public String getAppendText() {
		return (String) getLocalOrValueBindingValue(appendText, "appendText");
	}

	public void setAppendText(String appendText) {
		this.appendText = appendText;
	}

	public String getButtonImage() {
		return (String) getLocalOrValueBindingValue(buttonImage, "buttonImage");
	}

	public void setButtonImage(String buttonImage) {
		this.buttonImage = buttonImage;
	}

	public boolean isButtonImageOnly() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(buttonImageOnly, "buttonImageOnly");
		return value != null ? value.booleanValue() : false;
	}

	public void setButtonImageOnly(boolean buttonImageOnly) {
		this.buttonImageOnly = buttonImageOnly ? Boolean.TRUE : Boolean.FALSE;
	}

	public String getButtonText() {
		return (String) getLocalOrValueBindingValue(buttonText, "buttonText");
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public boolean isChangeMonth() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(changeMonth, "changeMonth");
		return value != null ? value.booleanValue() : false;
	}

	public void setChangeMonth(boolean changeMonth) {
		this.changeMonth = changeMonth? Boolean.TRUE : Boolean.FALSE;
	}

	public boolean isChangeYear() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(changeYear, "changeYear");
		return value != null ? value.booleanValue() : false;
	}

	public void setChangeYear(boolean changeYear) {
		this.changeYear = changeYear? Boolean.TRUE : Boolean.FALSE;
	}

	public String getCloseText() {
		return (String) getLocalOrValueBindingValue(closeText, "closeText");
	}

	public void setCloseText(String closeText) {
		this.closeText = closeText;
	}

	public boolean isConstrainInput() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(constrainInput, "constrainInput");
		return value != null ? value.booleanValue() : DEFAULT_CONSTRAIN_INPUT;
	}

	public void setConstrainInput(boolean constrainInput) {
		this.constrainInput = constrainInput? Boolean.TRUE : Boolean.FALSE;
	}

	public String getCurrentText() {
		return (String) getLocalOrValueBindingValue(currentText, "currentText");
	}

	public void setCurrentText(String currentText) {
		this.currentText = currentText;
	}

	public String getDateFormat() {
		return (String) getLocalOrValueBindingValue(dateFormat, "dateFormat");
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDayNames() {
		return (String) getLocalOrValueBindingValue(dayNames, "dayNames");
	}

	public void setDayNames(String dayNames) {
		this.dayNames = dayNames;
	}

	public String getDayNamesMin() {
		return (String) getLocalOrValueBindingValue(dayNamesMin, "dayNamesMin");
	}

	public void setDayNamesMin(String dayNamesMin) {
		this.dayNamesMin = dayNamesMin;
	}

	public String getDayNamesShort() {
		return (String) getLocalOrValueBindingValue(dayNamesShort, "dayNamesShort");
	}

	public void setDayNamesShort(String dayNamesShort) {
		this.dayNamesShort = dayNamesShort;
	}

	public String getDefaultDate() {
		return (String) getLocalOrValueBindingValue(defaultDate, "defaultDate");
	}

	public void setDefaultDate(String defaultDate) {
		this.defaultDate = defaultDate;
	}

	public String getDuration() {
		return (String)getLocalOrValueBindingValue(duration, "duration");
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(Integer firstDay) {
		this.firstDay = firstDay;
	}

	public boolean isGotoCurrent() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(gotoCurrent, "gotoCurrent");
		return value != null ? value.booleanValue() : false;
	}

	public void setGotoCurrent(boolean gotoCurrent) {
		this.gotoCurrent = gotoCurrent? Boolean.TRUE : Boolean.FALSE;
	}

	public boolean isHideIfNoPrevNext() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(hideIfNoPrevNext, "hideIfNoPrevNext");
		return value != null ? value.booleanValue() : false;
	}

	public void setHideIfNoPrevNext(boolean hideIfNoPrevNext) {
		this.hideIfNoPrevNext = hideIfNoPrevNext? Boolean.TRUE : Boolean.FALSE;
	}

	public boolean isRTL() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(RTL, "RTL");
		return value != null ? value.booleanValue() : false;
	}

	public void setRTL(boolean rtl) {
		RTL = rtl? Boolean.TRUE : Boolean.FALSE;
	}

	public String getMaxDate() {
		return (String)getLocalOrValueBindingValue(maxDate, "maxDate");
	}

	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	public String getMinDate() {
		return (String)getLocalOrValueBindingValue(minDate, "minDate");
	}

	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}

	public String getMonthNames() {
		return (String)getLocalOrValueBindingValue(monthNames, "monthNames");
	}

	public void setMonthNames(String monthNames) {
		this.monthNames = monthNames;
	}

	public String getMonthNamesShort() {
		return (String)getLocalOrValueBindingValue(monthNamesShort, "monthNamesShort");
	}

	public void setMonthNamesShort(String monthNamesShort) {
		this.monthNamesShort = monthNamesShort;
	}

	public boolean isNavigationAsDateFormat() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(navigationAsDateFormat, "navigationAsDateFormat");
		return value != null ? value.booleanValue() : false;
	}

	public void setNavigationAsDateFormat(boolean navigationAsDateFormat) {
		this.navigationAsDateFormat = navigationAsDateFormat? Boolean.TRUE : Boolean.FALSE;
	}

	public String getNextText() {
		return (String)getLocalOrValueBindingValue(nextText, "nextText");
	}

	public void setNextText(String nextText) {
		this.nextText = nextText;
	}

	public String getNumberOfMonths() {
		return (String)getLocalOrValueBindingValue(numberOfMonths, "numberOfMonths");
	}

	public void setNumberOfMonths(String numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	public String getPrevText() {
		return (String)getLocalOrValueBindingValue(prevText, "prevText");
	}

	public void setPrevText(String prevText) {
		this.prevText = prevText;
	}

	public String getShortYearCutoff() {
		return (String)getLocalOrValueBindingValue(shortYearCutoff, "shortYearCutoff");
	}

	public void setShortYearCutoff(String shortYearCutoff) {
		this.shortYearCutoff = shortYearCutoff;
	}

	public String getShowAnim() {
		return (String)getLocalOrValueBindingValue(showAnim, "showAnim");
	}

	public void setShowAnim(String showAnim) {
		this.showAnim = showAnim;
	}

	public boolean isShowButtonPanel() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(showButtonPanel, "showButtonPanel");
		return value != null ? value.booleanValue() : false;
	}

	public void setShowButtonPanel(boolean showButtonPanel) {
		this.showButtonPanel = showButtonPanel? Boolean.TRUE : Boolean.FALSE;
	}

	public Integer getShowCurrentAtPos() {
		return showCurrentAtPos;
	}

	public void setShowCurrentAtPos(Integer showCurrentAtPos) {
		this.showCurrentAtPos = showCurrentAtPos;
	}

	public boolean isShowMonthAfterYear() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(showMonthAfterYear, "showMonthAfterYear");
		return value != null ? value.booleanValue() : false;
	}

	public void setShowMonthAfterYear(boolean showMonthAfterYear) {
		this.showMonthAfterYear = showMonthAfterYear? Boolean.TRUE : Boolean.FALSE;
	}

	public String getShowOn() {
		return (String)getLocalOrValueBindingValue(showOn, "showOn");
	}

	public void setShowOn(String showOn) {
		this.showOn = showOn;
	}

	public String getShowOptions() {
		return (String)getLocalOrValueBindingValue(showOptions, "showOptions");
	}

	public void setShowOptions(String showOptions) {
		this.showOptions = showOptions;
	}

	public boolean isShowOtherMonths() {
		Boolean value = (Boolean)getLocalOrValueBindingValue(showOtherMonths, "showOtherMonths");
		return value != null ? value.booleanValue() : false;
	}

	public void setShowOtherMonths(boolean showOtherMonths) {
		this.showOtherMonths = showOtherMonths? Boolean.TRUE : Boolean.FALSE;
	}

	public Integer getStepMonths() {
		return stepMonths;
	}

	public void setStepMonths(Integer stepMonths) {
		this.stepMonths = stepMonths;
	}

	public String getYearRange() {
		return (String)getLocalOrValueBindingValue(yearRange, "yearRange");
	}

	public void setYearRange(String yearRange) {
		this.yearRange = yearRange;
	}

	public String getOnbeforeShow() {
		return (String)getLocalOrValueBindingValue(onbeforeShow, "onbeforeShow");
	}

	public void setOnbeforeShow(String onbeforeShow) {
		this.onbeforeShow = onbeforeShow;
	}

	public String getOnbeforeShowDay() {
		return (String)getLocalOrValueBindingValue(onbeforeShowDay, "onbeforeShowDay");
	}

	public void setOnbeforeShowDay(String onbeforeShowDay) {
		this.onbeforeShowDay = onbeforeShowDay;
	}

	public String getOnchangeMonthYear() {
		return (String)getLocalOrValueBindingValue(onchangeMonthYear, "onchangeMonthYear");
	}

	public void setOnchangeMonthYear(String onchangeMonthYear) {
		this.onchangeMonthYear = onchangeMonthYear;
	}

	public String getOnclose() {
		return (String)getLocalOrValueBindingValue(onclose, "onclose");
	}

	public void setOnclose(String onclose) {
		this.onclose = onclose;
	}

	public String getOnselect() {
		return (String)getLocalOrValueBindingValue(onselect, "onselect");
	}

	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}

	public void setResources(String[] resources) {
		this.resources = resources;
	}

	public String[] getResources() {
		return resources;
	}

}
