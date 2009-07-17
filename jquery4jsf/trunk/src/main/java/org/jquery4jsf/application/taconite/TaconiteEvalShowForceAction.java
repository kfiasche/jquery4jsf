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
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.renderkit.RendererUtilities;

public class TaconiteEvalShowForceAction extends AbstractTaconiteAction {
	
	private static final String START_ELEMENT = "<eval>";
	private static final String END_ELEMENT = "</eval>";
	private String id;
	
	public TaconiteEvalShowForceAction(String id, List components) {
		super(id, components);
		this.id = id;
	}
	
	public TaconiteEvalShowForceAction(String id, UIComponent component) {
		super(id, component);
		this.id = id;
	}
	
	public void processTacconiteAction() throws IOException{
        ResponseWriter responseWriter = getResponseWriter();
        String startElement = this.getStartElement();
        responseWriter.write(startElement);
        responseWriter.write(super.getStartCDATA());
        responseWriter.writeComment(id);
        String varWidget = RendererUtilities.getJQueryVarWidget();
        responseWriter.write(varWidget+"("+varWidget+".escapeJSFClientId('"+id+"')).show();");
        responseWriter.write(getEndCDATA());
        responseWriter.write(this.getEndElement());
	}
	
	private void processChildren(FacesContext facesContext, UIComponent component) throws IOException {
		if (component.getChildren() == null ||  component.getChildren().isEmpty())
			return;
		for (Iterator iterator = component.getChildren().iterator(); iterator.hasNext();) {
			UIComponent child = (UIComponent) iterator.next();
			processChild(facesContext, child);
		}
	}

	private void processChild(FacesContext facesContext, UIComponent child) throws IOException {
		if (!child.isRendered()) {
			return;
		}
		if (child instanceof JQueryHtmlObject){
			JQueryHtmlObject jQueryComponent = (JQueryHtmlObject)child;
			jQueryComponent.encodeScript(facesContext);
			processChildren(facesContext, child);
		}
		else{
			processChildren(facesContext, child);
		}
	}
	protected String getEndElement() {
		return END_ELEMENT;
	}

	protected String getStartElement() {
		return START_ELEMENT;
	}

}
