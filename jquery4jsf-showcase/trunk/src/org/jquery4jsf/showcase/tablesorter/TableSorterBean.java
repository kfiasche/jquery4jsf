package org.jquery4jsf.showcase.tablesorter;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.jquery4jsf.showcase.model.User;

public class TableSorterBean {

	private ArrayList lista;
	public TableSorterBean(){
		lista = new ArrayList();
		lista.add(new User("Francesco", "Totti", "f.totti@asroma.it", "", new GregorianCalendar(1973,9,25).getTime()));
		lista.add(new User("Daniele", "De Rossi", "d.derossi@asroma.it", "", new GregorianCalendar(1983,5,7).getTime()));
		lista.add(new User("Alberto", "Acquilani", "a.acquilani@asroma.it", "", new GregorianCalendar(1984,6,2).getTime()));
		lista.add(new User("Simone", "Perrotta", "s.perrotta@asroma.it","" , new GregorianCalendar(1975,7,15).getTime()));
		lista.add(new User("Marco", "Motta", "m.motta@asroma.it", "", new GregorianCalendar(1989,5,22).getTime()));
		lista.add(new User("Marco", "Cassetti", "m.cassetti@asroma.it", "", new GregorianCalendar(1973,9,28).getTime()));
		lista.add(new User("Max", "Tonetto", "m.tonetto@asroma.it", "", new GregorianCalendar(1972,11,30).getTime()));
		lista.add(new User("Cristian", "Panucci", "c.panucci@asroma.it", "", new GregorianCalendar(1970,10,12).getTime()));
		lista.add(new User("Simone", "Loria", "s.loria@asroma.it", "", new GregorianCalendar(1973,8,03).getTime()));
		lista.add(new User("Matteo", "Brighi", "m.brighi@asroma.it", "", new GregorianCalendar(1980,6,10).getTime()));
		lista.add(new User("Vincenzo", "Montella", "v.montella@asroma.it", "", new GregorianCalendar(1974,5,10).getTime()));
	}
	
	public ArrayList getLista() {
		
		return lista;
	}
	public void setLista(ArrayList lista) {
		this.lista = lista;
	}
	
}
