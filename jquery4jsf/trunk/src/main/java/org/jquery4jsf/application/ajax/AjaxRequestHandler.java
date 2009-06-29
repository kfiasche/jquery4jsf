package org.jquery4jsf.application.ajax;

import java.io.IOException;

import javax.faces.event.PhaseEvent;

public interface AjaxRequestHandler {
	
	public void handleAjaxRequest(PhaseEvent event) throws IOException;
}
