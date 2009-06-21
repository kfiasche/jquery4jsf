/**
 * 
 */
package org.jquery4jsf.showcase.selectmanylistbox;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 * @author Administrator
 *
 */
public class SelectManyListBoxBean {
	
	private String[] values;
	private String textValues = "";
	
	public SelectManyListBoxBean() {
	}
	
	public SelectItem[] getListaNazioni(){
		SelectItem[] lista = new SelectItem[]{
			new SelectItem("AF","Afghanistan"),	
			new SelectItem("AL","Albania"),	
			new SelectItem("AG","Algeria"),	
			new SelectItem("AD","Andorra"),	
			new SelectItem("ARG","Argentina"),	
			new SelectItem("ARM","Armenia"),	
			new SelectItem("ARB","Aruba"),	
			new SelectItem("AUS","Australia")
		};
		return lista;
	}

	public void actionListener(ActionEvent actionEvent){
		String[] values = (String[]) getValues();
		if (values != null){
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				textValues = textValues.concat(" ").concat(value);
			}
		}
	}
	
	public String[] getValues(){
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}
	
	public String getTextValues(){
		return textValues;
	}
	
}
