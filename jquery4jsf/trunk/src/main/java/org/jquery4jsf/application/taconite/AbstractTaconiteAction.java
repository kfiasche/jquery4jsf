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
package org.jquery4jsf.application.taconite;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.component.ComponentUtilities;

public abstract class AbstractTaconiteAction implements TaconiteAction{

	private String id;
	private List components = new LinkedList();
	
	public AbstractTaconiteAction(){
		super();
	}
	
	public AbstractTaconiteAction(String id, UIComponent component){
		this.id = id;
		this.components.add(component);
	}
	
	public AbstractTaconiteAction(UIComponent component){
		this.id = component.getClientId(getFacesContext());
		this.components.add(component);
	}
	
	public AbstractTaconiteAction(String id, List components){
		this.id = id;
		this.components = components;
	}
	
	public void processTacconiteAction() throws IOException{
        ResponseWriter responseWriter = getResponseWriter();
        String startElement = this.getStartElement().replaceFirst("\\$1", id);
        responseWriter.write(startElement);
        responseWriter.write(getStartCDATA());
        for (Iterator iterator = components.iterator(); iterator.hasNext();) {
			UIComponent component = (UIComponent) iterator.next();
			ComponentUtilities.encodeAll(getFacesContext(), component);
		}
        responseWriter.write(getEndCDATA());
        responseWriter.write(this.getEndElement());
	}
	
	protected abstract String getStartElement();
	protected abstract String getEndElement();
	
	protected String getStartCDATA(){
		return "<![CDATA[\n";
	}
	
	protected String getEndCDATA(){
		return "\n]]>";
	}
	
	protected FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	protected ResponseWriter getResponseWriter(){
		return getFacesContext().getResponseWriter();
	}
}
