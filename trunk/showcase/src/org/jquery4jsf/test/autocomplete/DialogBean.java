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
package org.jquery4jsf.test.autocomplete;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;

public class DialogBean
{

    public DialogBean()
    {
    }

    public void doButtonDialog(ActionEvent actionEvent)
    {
        System.out.println("sono qui");
        //return "";
    }
    
    private ArrayList users;

	public ArrayList getUsers() {
		return users;
	}

	public void setUsers(ArrayList users) {
		this.users = users;
	}
	
	public void addUser(ActionEvent actionEvent){
		if (users == null){
			users = new ArrayList();
		}
		users.add(getManagedBean("user"));
	}
	
    public static Object getManagedBean(String beanName) {
    	String cleanKey = ((String)beanName).replaceAll("[#\\{\\}]*","").trim();
        Object o = getValueBinding(getJsfEl(cleanKey)).getValue(FacesContext.getCurrentInstance());
        return o;
    }

	private static ValueBinding getValueBinding(String jsfEl) {
		ValueBinding valueBinding = FacesContext.getCurrentInstance().getApplication().createValueBinding(jsfEl);
		return valueBinding;
	}

	private static String getJsfEl(String cleanKey) {
		return "#{" + cleanKey + "}";
	}
}
