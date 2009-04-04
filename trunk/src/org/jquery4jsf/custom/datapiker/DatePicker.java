package org.jquery4jsf.custom.datapiker;

import java.io.IOException;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;

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
	
	
	public DatePicker() {
		super();
		resources = new String[]{
				"theme/base/ui.all.css",
				"jquery/jquery.js",
				"ui/ui.core.js",
				"ui/ui.datepicker.js",
		};
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
	}

	public MethodBinding getOncomplete() {
		return null;
	}

	public void setOncomplete(MethodBinding methodBinding) {
	}

	public String[] getResources() {
		return resources;
	}

}
