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
package org.jquery4jsf.application;

import java.io.IOException;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.render.RenderKit;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jquery4jsf.application.ajax.AjaxRequestHandler;
import org.jquery4jsf.application.ajax.DefaultAjaxRequestHandler;
import org.jquery4jsf.application.ajax.TaconiteAjaxRequestHandler;
import org.jquery4jsf.javascript.JSDocumentElement;
import org.jquery4jsf.utilities.JQueryUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AjaxPhaseListener implements javax.faces.event.PhaseListener {

	private static final long serialVersionUID = 1L;
	public static final String AJAX_VIEW_ID = "ajaxSourceJQuery";
	public static final String AJAX_PS_ID = "ajaxUpdate";
	
	
	private static Logger logger = LoggerFactory.getLogger(AjaxPhaseListener.class);

	public void afterPhase(PhaseEvent event) {
	}

	private void handleAjaxRequest(PhaseEvent event) throws IOException {
		AjaxRequestHandler ajaxRequestHandler = null;
		if (JQueryUtilities.getInstance().isTacconiteEnabled()){
			ajaxRequestHandler = new TaconiteAjaxRequestHandler();
		}
		else{
			ajaxRequestHandler = new DefaultAjaxRequestHandler();
		}
		ajaxRequestHandler.handleAjaxRequest(event);
	}



	public void beforePhase(PhaseEvent phaseEvent) {
		FacesContext facesContext = phaseEvent.getFacesContext();
		Map params = facesContext.getExternalContext().getRequestParameterMap();
		boolean isAjaxRequest = params.containsKey(AJAX_VIEW_ID);
		if(isAjaxRequest) {
			initPartialResponseWriter(facesContext);
			try {
				handleAjaxRequest(phaseEvent);
			} catch (IOException e) {
			}
			// reset jselement fusion
			JSDocumentElement.reset();
			facesContext.responseComplete();
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	/**
	 *
	 * Code taken, modified from org.primefaces.ui.application.PrimeFacesPhaseListener
	 *
	 */
	public void initPartialResponseWriter(FacesContext context) {
		if(context.getResponseWriter() != null)
			return;
		try {
			ServletResponse response = (ServletResponse) context.getExternalContext().getResponse();
			ServletRequest request = (ServletRequest) context.getExternalContext().getRequest();
			RenderKit renderKit = context.getRenderKit();
			ResponseWriter responseWriter = renderKit.createResponseWriter(response.getWriter(), null, request.getCharacterEncoding());
			context.setResponseWriter(responseWriter);
		}catch(IOException e) {
			logger.error("ajaxRequest error: "+e.getMessage());
		}
	}
	
}
