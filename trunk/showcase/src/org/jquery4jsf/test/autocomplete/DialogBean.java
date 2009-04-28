package org.jquery4jsf.test.autocomplete;

import java.util.ArrayList;

import javax.faces.event.ActionEvent;

public class DialogBean
{

    public DialogBean()
    {
    }

    public String doButtonDialog(ActionEvent actionEvent)
    {
        System.out.println("sono qui");
        return "";
    }
    
    private ArrayList users;

	public ArrayList getUsers() {
		return users;
	}

	public void setUsers(ArrayList users) {
		this.users = users;
	}
}
