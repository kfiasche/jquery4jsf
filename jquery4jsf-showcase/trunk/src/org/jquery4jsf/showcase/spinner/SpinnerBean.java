package org.jquery4jsf.showcase.spinner;

import javax.faces.event.ActionEvent;

public class SpinnerBean {

	private Integer spinnerValue;
	private String textSpinner;
	
	public Integer getSpinnerValue() {
		return spinnerValue;
	}

	public void setSpinnerValue(Integer spinnerValue) {
		this.spinnerValue = spinnerValue;
	}
	
	
	
	public void doSpinnerListener(ActionEvent event){
		textSpinner = "Spinner value: "+ getSpinnerValue().toString();
	}

	public String getTextSpinner() {
		return textSpinner;
	}

	public void setTextSpinner(String textSpinner) {
		this.textSpinner = textSpinner;
	}
	
}
