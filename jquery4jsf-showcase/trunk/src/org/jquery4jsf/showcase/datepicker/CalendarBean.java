/**
 * 
 */
package org.jquery4jsf.showcase.datepicker;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.event.ActionEvent;

/**
 * @author Administrator
 *
 */
public class CalendarBean {
	public CalendarBean() {
	}
	private Date date;
	private String textLabel;
	
	public void doActionCalendar(ActionEvent actionEvent){
		if (date != null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String valueString = sdf.format(date);
			textLabel = "This a date selected ".concat(valueString);
		}
	}


	public String getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(String textLabel) {
		this.textLabel = textLabel;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
}
