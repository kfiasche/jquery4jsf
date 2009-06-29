package org.jquery4jsf.application.taconite;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.ResponseWriter;

public class TaconiteResponse {
	

	private static final String START_RESPONSE = new String("<?xml version=\"1.0\"?>\n<taconite>\n");
    private static final String END_RESPONSE = new String("\n</taconite>");
    private List actions = new LinkedList();
    private ResponseWriter responseWriter;
    
	public TaconiteResponse(ResponseWriter responseWriter) {
		super();
		this.responseWriter = responseWriter;
	}
    
    public boolean addAction(TaconiteAction tacconiteAction){
    	return actions.add(tacconiteAction);
    }

    public void writeResponse() throws IOException{
    	responseWriter.write(START_RESPONSE);
    	for (Iterator iterator = actions.iterator(); iterator.hasNext();) {
			TaconiteAction tacconiteAction = (TaconiteAction) iterator.next();
			tacconiteAction.processTacconiteAction();
		}
    	responseWriter.write(END_RESPONSE);
    }
    
}
