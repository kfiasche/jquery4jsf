/**
 * 
 */
package org.jquery4jsf.showcase.button;

import javax.faces.event.ActionEvent;

/**
 * @author Administrator
 *
 */
public class ButtonBean {
	public ButtonBean() {
	}
	private String text;
	public String doButtonAction(){
		this.text = "Submit Ok!";
		return "";
	}
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void doButtonActionListener(ActionEvent event){
		this.text = "Submit Ok!";
	}
}
