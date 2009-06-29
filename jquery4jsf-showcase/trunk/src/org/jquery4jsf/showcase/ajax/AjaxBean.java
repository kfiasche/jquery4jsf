package org.jquery4jsf.showcase.ajax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.jquery4jsf.showcase.model.Player;

public class AjaxBean {
	
	private List<Player> listPlayers;
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
	
	public AjaxBean() throws Exception {
		super();
		players = new SelectItem[]{};
		initLoadDati();
	}
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String fans;
	private String position;
	private String player;
	private SelectItem[] players;
	
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
	
	public void findPlayersByPosition(ActionEvent actionEvent){
		String position = getPosition();
		if(position !=null && !position.equals("")){
			ArrayList<SelectItem> listaPlayes = new ArrayList<SelectItem>();
			for (Iterator<Player> iterator = listPlayers.iterator(); iterator.hasNext();) {
				Player player = iterator.next();
				if (player.getRuolo().startsWith(position)){
					listaPlayes.add(new SelectItem(player.getName(), player.getName()));
				}
			}
			players = (SelectItem[]) listaPlayes.toArray(new SelectItem[listaPlayes.size()]);
		}
		else{
			players = new SelectItem[]{};
		}
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public SelectItem[] getPlayers() {
		return players;
	}
	public void setPlayers(SelectItem[] players) {
		this.players = players;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
}
