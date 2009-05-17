/**
 * 
 */
package org.jquery4jsf.test.datatable;

import java.util.ArrayList;

import org.jquery4jsf.test.model.User;

/**
 * @author Administrator
 *
 */
public class DataTableBean {
	private ArrayList lista;
	public DataTableBean() {
		lista = new ArrayList();
		lista.add(new User("Andrea", "Rossi"));
		lista.add(new User("Marco", "Rossi"));
		lista.add(new User("Francesco", "Totti"));
		lista.add(new User("Alessandro", "Del Piero"));
		lista.add(new User("Andrea", "Pirlo"));
		lista.add(new User("Daniele", "De Rossi"));
		lista.add(new User("Simone", "Perrotta"));
		lista.add(new User("Marco", "Motta"));
		lista.add(new User("Matteo", "Brighi"));
		lista.add(new User("Max", "Tonetto"));
		lista.add(new User("Marco", "Cassetti"));
	}
	public ArrayList getLista() {
		return lista;
	}
	public void setLista(ArrayList lista) {
		this.lista = lista;
	}
}
