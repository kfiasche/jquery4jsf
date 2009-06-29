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
			tacconiteResponse.addAction(tacconiteAction);
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
