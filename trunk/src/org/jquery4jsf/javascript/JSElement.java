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

import org.jquery4jsf.javascript.event.JSEvent;
import org.jquery4jsf.javascript.function.JSFunction;

public class JSElement implements JSInterface {

	private String id;
	private StringBuffer javascriptCode;
	
	public JSElement(String id){
		super();
		this.id = id;
		javascriptCode = new StringBuffer();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void addEvent(JSEvent event){
	    if (event != null 
	            && javascriptCode.toString() != null 
	            && !javascriptCode.toString().equalsIgnoreCase("")){
			javascriptCode.append(event.toJavaScriptCode());
	    }else if (event != null){
	        generaCodice();
	        javascriptCode.append(event.toJavaScriptCode());
	    }
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public void addFunction(JSFunction function){
	    if (function != null 
	            && javascriptCode.toString() != null 
	            && !javascriptCode.toString().equalsIgnoreCase("")){
			javascriptCode.append(function.toJavaScriptCode());
	    }else if (function != null){
	        generaCodice();
	        javascriptCode.append(function.toJavaScriptCode());
	    }
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public void addAttribute(JSAttribute attribute){
	    if (attribute != null 
	            && javascriptCode.toString() != null 
	            && !javascriptCode.toString().equalsIgnoreCase("")){
	    	String jsCode = javascriptCode.toString();
	    	String attCode = attribute.toJavaScriptCode();
	    	if (jsCode.endsWith(";") && attCode.startsWith(".")){
	    		javascriptCode = javascriptCode.deleteCharAt(javascriptCode.length()-1);
	    	}
	    	javascriptCode.append(attribute.toJavaScriptCode());
	    }else if (attribute != null){
	        generaCodice();
	        javascriptCode.append(attribute.toJavaScriptCode());
	    }
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public String toJavaScriptCode(){	
		return javascriptCode != null ? javascriptCode.toString() : null;
	}
	
	private void generaCodice(){
		if (id != null && !id.equalsIgnoreCase("")){
			javascriptCode.append("\t");
			javascriptCode.append(JSElementConstants.JS_JQUERY_OPEN);
			if("this".equalsIgnoreCase(id)){
				javascriptCode.append(id);
			}
			else
				javascriptCode.append(generaIdForJquery(id));
			javascriptCode.append(JSElementConstants.JS_JQUERY_CLOSE);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	private String generaIdForJquery(String id){
	    String idNew = id.replaceAll(":", "\\\\\\\\:");
	    return "'#".concat(idNew).concat("'");
	}
}
