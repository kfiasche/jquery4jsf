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
package org.jquery4jsf.showcase.dialog;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class DialogBean
{
	private String textDialogClose;
	private String textDialogOpen;
	private String textDialogFocus;
	private String textDialogDragStart;
	private String textDialogDrag;
	private String textDialogDragStop;
	
    public DialogBean()
    {
    	textDialogClose = "Text for dialog before close";
    	textDialogOpen = "Text for dialog open";
    	textDialogFocus = "Text for dialog focus";
    	textDialogDragStart = "Text for dialog drag start";
    	textDialogDrag = "Text for dialog drag";
    	textDialogDragStop = "Text for dialog drag stop";
    }

    public void doButtonDialog(ActionEvent actionEvent)
    {
        System.out.println("sono qui");
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
	
	public void onDialogBeforeClose(ActionEvent actionEvent){
		textDialogClose = "Wait please...";
	}
	public void onDialogOpen(ActionEvent actionEvent){
		textDialogOpen = "Dialog open.";
	}
	public void onDialogFocus(ActionEvent actionEvent){
		textDialogFocus = "Dialog Focus.";
	}
	
	public void onDialogDragStart(ActionEvent actionEvent){
		textDialogDragStart = "Drag start.";
	}
	public void onDialogDrag(ActionEvent actionEvent){
		textDialogDrag = "Drag.";
	}
	public void onDialogDragStop(ActionEvent actionEvent){
		textDialogDragStop = "Drag stop.";
	}
	
	public String getTextDialogClose() {
		return textDialogClose;
	}

	public void setTextDialogClose(String textDialogClose) {
		this.textDialogClose = textDialogClose;
	}

	public String getTextDialogOpen() {
		return textDialogOpen;
	}

	public void setTextDialogOpen(String textDialogOpen) {
		this.textDialogOpen = textDialogOpen;
	}

	public String getTextDialogFocus() {
		return textDialogFocus;
	}

	public void setTextDialogFocus(String textDialogFocus) {
		this.textDialogFocus = textDialogFocus;
	}

	public String getTextDialogDragStop() {
		return textDialogDragStop;
	}

	public void setTextDialogDragStop(String textDialogDragStop) {
		this.textDialogDragStop = textDialogDragStop;
	}

	public String getTextDialogDragStart() {
		return textDialogDragStart;
	}

	public void setTextDialogDragStart(String textDialogDragStart) {
		this.textDialogDragStart = textDialogDragStart;
	}

	public String getTextDialogDrag() {
		return textDialogDrag;
	}

	public void setTextDialogDrag(String textDialogDrag) {
		this.textDialogDrag = textDialogDrag;
	}
	
}
