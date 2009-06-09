/**
 * 
 */
package org.jquery4jsf.showcase.quicksearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.jquery4jsf.showcase.model.Player;

/**
 * @author Administrator
 *
 */
public class QuickSearchBean {
	private List<Player> listPlayers;
	public QuickSearchBean() {
		try {
			initLoadDati();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initLoadDati() throws Exception{
		ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realpath = sc.getRealPath("quicksearch/dati/rosa2009roma.csv");
		FileReader fileReader = new FileReader(realpath);
		BufferedReader bufferedReader = new  BufferedReader(fileReader);
		String readLine = "";
		listPlayers = new ArrayList<Player>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);

		while (readLine != null) {
			readLine = bufferedReader.readLine();
			if (readLine != null){
				//Numero Maglia;Nome;Ruolo;Data Nascita;Nazionalità;Partite Giocate;
				String[] split = readLine.split(";");
				Integer number = Integer.parseInt(split[0]);
				String nome = split[1];
				String ruolo = split[2];
				Date born = dateFormat.parse(split[3]);
				String nazionalita = split[4];
				Integer numberMath = Integer.getInteger(split[0]);
				listPlayers.add(new Player(nome, number, born, numberMath, ruolo, nazionalita));
			}
		}
	}

	public List<Player> getListPlayers() {
		return listPlayers;
	}

	public void setListPlayers(List<Player> listPlayers) {
		this.listPlayers = listPlayers;
	}
}
