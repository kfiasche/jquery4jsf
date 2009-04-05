package org.jquery4jsf.application;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.render.RenderKit;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.component.ComponentUtilities;
import org.jquery4jsf.custom.AjaxComponent;

public class AjaxPhaseListener implements PhaseListener {

	private static final long serialVersionUID = -4178354510294658599L;
	private static final String AJAX_VIEW_ID = "ajaxSourceJQuery";

	public void afterPhase(PhaseEvent event) {
	}

	private void handleAjaxRequest(PhaseEvent event) throws IOException {
		FacesContext context = event.getFacesContext();
		Object object = context.getExternalContext().getRequest();
		if (!(object instanceof HttpServletRequest))
		{
			//Only handle HttpServletRequests
			return;
		}
		HttpServletRequest request = (HttpServletRequest) object;
		String id = request.getParameter(AJAX_VIEW_ID);
		if (id != null && !id.equalsIgnoreCase("")){
			String values[] = id.split(":");
			int i = values.length -1;
			id = values[i];
			UIComponent component = (UIComponent) ComponentUtilities.findComponentInRoot(id);
			if (component instanceof AjaxComponent){
				((AjaxComponent) component).encodePartially(context);
			}
		}
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
			facesContext.responseComplete();
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	public void initPartialResponseWriter(FacesContext facesContext) {
		if(facesContext.getResponseWriter() != null)
			return;
		
		try {
			ServletResponse response = (ServletResponse) facesContext.getExternalContext().getResponse();
			ServletRequest request = (ServletRequest) facesContext.getExternalContext().getRequest();
			RenderKit renderKit = facesContext.getRenderKit();
			ResponseWriter responseWriter = renderKit.createResponseWriter(response.getWriter(), null, request.getCharacterEncoding());
			facesContext.setResponseWriter(responseWriter);
		}catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
}
