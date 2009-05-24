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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	private static final String AJAX_PS_ID = "ajaxUpdate";

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
		boolean isAjaxRequest = request.getParameterMap().containsKey(AJAX_VIEW_ID);
		if (isAjaxRequest){
			boolean isPartialSubmit = request.getParameterMap().containsKey(AJAX_PS_ID);
			if (isPartialSubmit){
				String[] updateIds = (String[]) request.getParameterMap().get(AJAX_PS_ID);
				ServletResponse response = (ServletResponse) context.getExternalContext().getResponse();
				response.setContentType("text/html");
				printRequestValue(request);
				try {
					for (int i = 0; i < updateIds.length; i++) {
						String id = updateIds[i];
						if (id != null && id.trim().length() > 0){
							String values[] = id.split(":");
							int y = values.length -1;
							id = values[y];
							UIComponent component = ComponentUtilities.findComponentInRoot(id);
							if (component != null)
								ComponentUtilities.encodeAll(context, component);
						}
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			else{
				String id = request.getParameter(AJAX_VIEW_ID);
				if (id != null && !id.equalsIgnoreCase("")){
					String values[] = id.split(":");
					int i = values.length -1;
					id = values[i];
					printRequestValue(request);
					UIComponent component = ComponentUtilities.findComponentInRoot(id);
					if (component instanceof AjaxComponent){
						((AjaxComponent) component).encodePartially(context);
					}
				}
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
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void printRequestValue(HttpServletRequest request){
		Map params = request.getParameterMap();
		Set keySet = params.keySet();
		for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = params.get(key);
			if (value instanceof String[]){
				String[] args = (String[])value;
				for (int i = 0; i < args.length; i++) {
					String valore = args[i];
					System.out.println("Nome parametro: "+key+" valore: "+valore);
				}
			}
			else if (value instanceof String){
				String valore = (String)value;
				System.out.println("Nome parametro: "+key+" valore: "+valore);
			}
			else{
				System.out.println("Nome parametro: "+key+" valore: "+value.toString());
			}
		}
	}
	
}
