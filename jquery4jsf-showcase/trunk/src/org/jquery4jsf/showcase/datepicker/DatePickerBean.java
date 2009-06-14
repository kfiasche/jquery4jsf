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
public class DatePickerBean {
	public DatePickerBean() {
	}
	
	private Date dateOfBorn;
	private String textLabel;
	
	public void doActionDatePicker(ActionEvent actionEvent){
		if (dateOfBorn != null){
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			String date = sdf.format(dateOfBorn);
			textLabel = "This is my birthday ".concat(date);
		}
	}

	public Date getDateOfBorn() {
		return dateOfBorn;
	}

	public void setDateOfBorn(Date dateOfBorn) {
		this.dateOfBorn = dateOfBorn;
	}

	public String getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(String textLabel) {
		this.textLabel = textLabel;
	}
	
}
