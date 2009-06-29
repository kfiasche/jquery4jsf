package org.jquery4jsf.showcase.autocomplete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.jquery4jsf.showcase.model.Player;

public class AutoCompleteBean {

	private List<Player> listPlayers;
	private String text;
	
	public AutoCompleteBean() throws Exception {
		super();
		initLoadDati();
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

	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public List<String> completeAlgo(String query){
		List<String> listaQuery = new ArrayList<String>();
		for (int i=0; i<11; i++){
			query = query.concat(Integer.toString(i));
			listaQuery.add(query);
		}
		return listaQuery;
	}
	public List<String> completePlayersRuolo(String query){
		List<String> listQuery = new ArrayList<String>();
		String ruolo = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ruolo");
		for (Iterator<Player> iterator = listPlayers.iterator(); iterator.hasNext();) {
			Player player = iterator.next();
			if (player.getRuolo().equalsIgnoreCase(ruolo))
				listQuery.add(player.getName());
		}
		return listQuery;
	}
	public List<String> completePlayers(String query){
		List<String> listQuery = new ArrayList<String>();
		for (Iterator<Player> iterator = listPlayers.iterator(); iterator.hasNext();) {
			Player player = iterator.next();
			String name = player.toString();
			if (name.indexOf(query) > -1)
				listQuery.add(name);
		}
		return listQuery;
	}
	
}
