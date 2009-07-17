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
package org.jquery4jsf.javascript.function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.JSInterface;


public class JSFunction implements JSInterface{
	
	private List elements;
	private String name;
	private List params; 
	private StringBuffer javascriptCode;
	
	public JSFunction() {
		super();
		elements = new ArrayList();
		params = new ArrayList();
		javascriptCode = new StringBuffer();
	}
	
	public JSFunction(List elements){
		super();
		this.elements = elements;
		params = new ArrayList();
		javascriptCode = new StringBuffer();
	}
	
	public JSFunction(List elements, String name){
		super();
		this.elements = elements;
		this.name = name;
		javascriptCode = new StringBuffer();
	}
	
	public JSFunction(List elements, String name, List params){
		super();
		this.elements = elements;
		this.name = name;
		this.params = params;
		javascriptCode = new StringBuffer();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String[] getParams() {
		return (String[]) params.toArray(new String[params.size()]);
	}
	
	public JSElement[] getElements() {
		return (JSElement[]) elements.toArray(new JSElement[elements.size()]);
	}
	
	public boolean addParam(String param) {
		if (param != null && !params.contains(param)){
			return params.add(param);
		}
		return false;
	}

	public boolean addJSElement(JSElement element){
		if (element != null && !elements.contains(element)){
			return elements.add(element);
		}
		return false;
	}
	
	public String toJavaScriptCode() {
	    if (name == null && (params == null || params.isEmpty()) && (elements == null || elements.isEmpty())){
	        throw new IllegalArgumentException();
	    }
	    else if (name == null && (params == null || params.isEmpty())){
	        javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_OPEN);
	        for (Iterator iterator = elements.iterator(); iterator.hasNext();) {
				JSElement element = (JSElement) iterator.next();
                javascriptCode.append(element.toJavaScriptCode());
                javascriptCode.append("\n");
			}
	        javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_CLOSE);
	    }
	    else if (name == null){
	    	javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_WHIT_PARAM_OPEN);
	    	for (Iterator iterator = params.iterator(); iterator.hasNext();) {
	    		String param = (String) iterator.next();
	    		javascriptCode.append(param);
	    		if (iterator.hasNext()){
	    			javascriptCode.append(", ");
	    		}
	    		else{
	    			javascriptCode.append("){ \n");
	    		}
	    	}
	        for (Iterator iterator = elements.iterator(); iterator.hasNext();) {
				JSElement element = (JSElement) iterator.next();
                javascriptCode.append(element.toJavaScriptCode());
                javascriptCode.append("\n");
			}
	    	javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_WHIT_PARAM_CLOSE);
	    }
	    else{
	    	String intest = JSFunctionConstants.JS_JQUERY_FN_WHIT_NAME_OPEN;
	    	intest = intest.replaceAll("#",name);
	    	javascriptCode.append(intest);
	    	for (Iterator iterator = params.iterator(); iterator.hasNext();) {
	    		String param = (String) iterator.next();
	    		javascriptCode.append(param);
	    		if (iterator.hasNext()){
	    			javascriptCode.append(", ");
	    		}
	    		else{
	    			javascriptCode.append("){ \n");
	    		}
	    	}
	        for (Iterator iterator = elements.iterator(); iterator.hasNext();) {
				JSElement element = (JSElement) iterator.next();
                javascriptCode.append(element.toJavaScriptCode());
                javascriptCode.append("\n");
			}
	    	javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_WHIT_PARAM_CLOSE);
	    }
	    return javascriptCode != null ? javascriptCode.toString() : null;
	}



}
