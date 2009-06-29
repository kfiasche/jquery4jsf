package org.jquery4jsf.showcase.model;

import java.util.Date;

public class Player {

	private String name;
	private Integer number;
	private Date bornDate;
	private Integer numberOfMacth;
	private String ruolo;
	private String nazionalita;

	
	
	public Player(String name, Integer number, Date bornDate,
			Integer numberOfMacth, String ruolo, String nazionalita) {
		super();
		this.name = name;
		this.number = number;
		this.bornDate = bornDate;
		this.numberOfMacth = numberOfMacth;
		this.ruolo = ruolo;
		this.nazionalita = nazionalita;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public Integer getNumberOfMacth() {
		return numberOfMacth;
	}
	public void setNumberOfMacth(Integer numberOfMacth) {
		this.numberOfMacth = numberOfMacth;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	public String toString(){
		return this.getName() + " " + this.getNazionalita();
	}
}
