package org.jquery4jsf.showcase.ajax;

import javax.faces.event.ActionEvent;

public class AjaxBean {

	private String nome;
	private String cognome;
	private String fans;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	public void creaRomaFans(ActionEvent actionEvent){
		if (fans == null)
			fans = "";
		fans = fans.concat("Francesco Totti");
	}
	
	public String getFans() {
		return fans;
	}
	public void setFans(String fans) {
		this.fans = fans;
	}
	
}
