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
import java.util.Locale;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.jquery4jsf.javascript.JSDocumentElement;

public class JQueryViewHandler extends ViewHandler{
	
	protected ViewHandler defaultViewHandler;
	
	public JQueryViewHandler(ViewHandler defaultViewHandler) {
		super();
		this.defaultViewHandler = defaultViewHandler;
	}

	public Locale calculateLocale(FacesContext context) {
		return defaultViewHandler.calculateLocale(context);
	}

	public String calculateRenderKitId(FacesContext context) {
		return defaultViewHandler.calculateRenderKitId(context);
	}

	public UIViewRoot createView(FacesContext context, String arg1) {
		return defaultViewHandler.createView(context, arg1);
	}

	public String getActionURL(FacesContext context, String arg1) {
		return defaultViewHandler.getActionURL(context, arg1);
	}

	public String getResourceURL(FacesContext context, String arg1) {
		return defaultViewHandler.getResourceURL(context, arg1);
	}

	public void renderView(FacesContext context, UIViewRoot arg1)throws IOException, FacesException {
		defaultViewHandler.renderView(context, arg1);		
	}

	public UIViewRoot restoreView(FacesContext context, String arg1) {
		return defaultViewHandler.restoreView(context, arg1);		
	}

	public void writeState(FacesContext context) throws IOException {
		defaultViewHandler.writeState(context);
	}

}
