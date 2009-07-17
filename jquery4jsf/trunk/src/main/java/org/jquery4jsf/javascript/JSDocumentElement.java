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
package org.jquery4jsf.javascript;

import java.util.ArrayList;
import java.util.Iterator;

import org.jquery4jsf.javascript.function.JSFunction;
import org.jquery4jsf.utilities.JQueryUtilities;
import org.jquery4jsf.utilities.TextUtilities;

public class JSDocumentElement implements JSInterface {

    private String id;
    private StringBuffer javascriptCode;
    private static JSDocumentElement instance;
    private ArrayList elements;
    private ArrayList functions;
    
    private JSDocumentElement(){
        this.id = "document";
        javascriptCode = new StringBuffer();
        elements = new ArrayList();
        functions = new ArrayList();
    }
    
    public boolean addFunctionToReady(JSFunction function){
    	return this.addFunctionToReady(function, false);
    }
    public boolean addFunctionToReady(JSFunction function, boolean addFuntion){
    	if (addFuntion && function != null && !functions.contains(function) && function.getName() != null){
    		return functions.add(function);
    	}
    	else if (function != null && !elements.contains(function)){
    		return elements.add(function);
    	}
    	return false;
    }

	public String toJavaScriptCode(){
		if (functions.isEmpty() && elements.isEmpty())
			return "";
		
		if (JQueryUtilities.getInstance().isJQueryNoConflictEnabled()){ 
			javascriptCode.append("\n");
			javascriptCode.append("jQuery.noConflict();");
			javascriptCode.append("\n");
		}
		generaCodice();	
		javascriptCode.append(JSElementConstants.JS_JQUERY_READY_OPEN);
		
		for (Iterator iterator = functions.iterator(); iterator.hasNext();) {
			javascriptCode.append("\n");
			JSFunction function = (JSFunction) iterator.next();
			javascriptCode.append(function.toJavaScriptCode());
		}
		
		for (Iterator iterator = elements.iterator(); iterator.hasNext();) {
			JSFunction function = (JSFunction) iterator.next();
			JSElement[] elements = function.getElements();
			for (int i = 0; i < elements.length; i++) {
				javascriptCode.append("\n");
				JSElement element = elements[i];
				javascriptCode.append(element.toJavaScriptCode());
			}
		}
		javascriptCode.append(JSElementConstants.JS_JQUERY_READY_CLOSE);
		return javascriptCode != null ? TextUtilities.formatCode(javascriptCode.toString()) : null;
	}
	
	private void generaCodice(){
		if (id != null && !id.equalsIgnoreCase("")){
			javascriptCode.append(JSElementConstants.JS_JQUERY_OPEN);
			javascriptCode.append(id);
			javascriptCode.append(JSElementConstants.JS_JQUERY_CLOSE);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	public synchronized static JSDocumentElement getInstance() {
		if (instance == null)
			instance = new JSDocumentElement();
		return instance;
	}
	
	public static void reset() {
		instance = null;
	}

	public ArrayList getFunctions() {
		return elements;
	}
}
