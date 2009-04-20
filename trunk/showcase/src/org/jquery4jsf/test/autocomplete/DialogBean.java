package org.jquery4jsf.test.autocomplete;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;

import org.jquery4jsf.test.model.User;

public class DialogBean {

	public DialogBean() {
		super();
		users = new ArrayList();
		users.add(new User("John Doe", "john.doe@example.com", "johndoe1"));
	}

	private ArrayList users;
	
	public ArrayList getUsers() {
		return users;
	}

	public void setUsers(ArrayList users) {
		this.users = users;
	}

	public String doButtonSalva() {
		return "";
	}
	
	
	public void doButtonDialog(ActionEvent event){
		User user = (User) getManagedBean("user");
		System.out.println("user");
		users.add(user);
	}
	
	private Object getManagedBean(String name){
		ValueBinding valueBinding = FacesContext.getCurrentInstance().getApplication().createValueBinding("#{"+name+"}");
		return valueBinding.getValue(FacesContext.getCurrentInstance());
	}
}
