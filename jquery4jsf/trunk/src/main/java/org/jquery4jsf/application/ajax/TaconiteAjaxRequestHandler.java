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
package org.jquery4jsf.application.ajax;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.NamingContainer;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.PhaseEvent;
import javax.servlet.ServletResponse;

import org.jquery4jsf.application.AjaxPhaseListener;
import org.jquery4jsf.application.taconite.TaconiteAction;
import org.jquery4jsf.application.taconite.TaconiteEvalAction;
import org.jquery4jsf.application.taconite.TaconiteEvalShowForceAction;
import org.jquery4jsf.application.taconite.TaconiteReplaceElementAction;
import org.jquery4jsf.application.taconite.TaconiteResponse;
import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.custom.AjaxComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaconiteAjaxRequestHandler implements AjaxRequestHandler {
	
	private static Logger logger = LoggerFactory.getLogger(TaconiteAjaxRequestHandler.class);
	
	public void handleAjaxRequest(PhaseEvent event) throws IOException {
		FacesContext context = event.getFacesContext();
		ServletResponse response = (ServletResponse) context.getExternalContext().getResponse();
		Map params = context.getExternalContext().getRequestParameterMap();
		boolean isAjaxRequest =params.containsKey(AjaxPhaseListener.AJAX_VIEW_ID);
		if (isAjaxRequest){
			boolean isPartialSubmit = params.containsKey(AjaxPhaseListener.AJAX_PS_ID);
			if (isPartialSubmit){
				String[] ids = null;
				String updateIds = (String) params.get(AjaxPhaseListener.AJAX_PS_ID);
				if(updateIds != null) {
					ids = updateIds.split(",");
				}
				response.setContentType("text/xml");
				writeComponents(context, ids);
			}
			else{
				String id = (String) params.get(AjaxPhaseListener.AJAX_VIEW_ID);
				if (id != null && !id.equalsIgnoreCase("")){
					id = getComponentId(id);
					UIComponent component = ComponentUtilities.findComponentInRoot(id);
					if (component != null && component instanceof AjaxComponent){
						((AjaxComponent) component).encodePartially(context);
					}
					else{
						logger.error("Component not found to be updated");
					}
				}
			}
		}
	}

	private void writeComponents(FacesContext context, String[] ids) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		TaconiteResponse tacconiteResponse = new TaconiteResponse(responseWriter);
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			String clientId = getComponentId(id).trim();
			UIComponent component = ComponentUtilities.findComponentInRoot(clientId);
			TaconiteAction tacconiteAction = new TaconiteReplaceElementAction(id, component);
			TaconiteAction tacconiteEvalAction = new TaconiteEvalAction(id, component);
			tacconiteResponse.addAction(tacconiteAction);
			tacconiteResponse.addAction(tacconiteEvalAction);
			//TODO force jquery show component
			TaconiteAction taconiteActionShowForce = new TaconiteEvalShowForceAction(id, component);
			tacconiteResponse.addAction(taconiteActionShowForce);
		}
		tacconiteResponse.writeResponse();
	}

	private String getComponentId(String clientId){
		String charSeparator = String.valueOf(NamingContainer.SEPARATOR_CHAR);
		String values[] = clientId.split(charSeparator);
		int i = values.length -1;
		return values[i];
	}
	
}
