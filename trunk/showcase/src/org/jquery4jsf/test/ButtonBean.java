/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
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
		this.cognome = cognome;
	}
	
	public void provaActionListener(ActionEvent event){
		if (getNome() != null){
			String nome = getNome().concat("_ProvaListener");
			setNome(nome);
		}
	}
	
	public void provaActionListener2(ActionEvent event){
		if (getNome() != null){
			String nome = getNome().concat("****Secondo listener");
			setNome(nome);
		}
	}
	
}
