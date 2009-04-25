/**
 * 
 */
package org.jquery4jsf.test;

import javax.faces.event.ActionEvent;

/**
 * @author Administrator
 *
 */
public class ButtonBean {
	public ButtonBean() {
	}
	
	private String nome;
	private String cognome;
	
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
		System.out.println(cognome);
		this.cognome = cognome;
	}
	
	public void provaActionListener(ActionEvent event){
		if (getNome() != null){
			String nome = getNome().concat("_ProvaListener");
			setNome(nome);
		}
	}
	
}
