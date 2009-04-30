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

public class JSDocumentElement implements JSInterface {

    private String id;
    private StringBuffer javascriptCode;
    public JSDocumentElement(){
        this.id = "document";
        javascriptCode = new StringBuffer();
    }
    
    public void addFunctionToReady(JSInterface function){
	    if (function != null 
	            && javascriptCode.toString() != null 
	            && !javascriptCode.toString().equalsIgnoreCase("")){
	        javascriptCode.append(JSElementConstants.JS_JQUERY_READY_OPEN);
			javascriptCode.append(function.toJavaScriptCode());
			javascriptCode.append(JSElementConstants.JS_JQUERY_READY_CLOSE);
	    }else if (function != null){
	        generaCodice();
	        javascriptCode.append(JSElementConstants.JS_JQUERY_READY_OPEN);
	        javascriptCode.append(function.toJavaScriptCode());
	        javascriptCode.append(JSElementConstants.JS_JQUERY_READY_CLOSE);
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
			javascriptCode.append(JSElementConstants.JS_JQUERY_OPEN);
			javascriptCode.append(id);
			javascriptCode.append(JSElementConstants.JS_JQUERY_CLOSE);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
    
}
