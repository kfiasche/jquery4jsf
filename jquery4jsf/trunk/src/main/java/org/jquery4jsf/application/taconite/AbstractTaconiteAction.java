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
	
	private String getStartCDATA(){
		return "<![CDATA[\n";
	}
	
	private String getEndCDATA(){
		return "\n]]>";
	}
	
	protected FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	protected ResponseWriter getResponseWriter(){
		return getFacesContext().getResponseWriter();
	}
}
