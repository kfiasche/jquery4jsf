package org.jquery4jsf.javascript.function;

import java.util.ArrayList;

import org.jquery4jsf.javascript.JSElement;
import org.jquery4jsf.javascript.JSInterface;


public class JSFunction implements JSInterface{
	
	private JSElement[] elements;
	private String name;
	private String[] params; 
	private StringBuffer javascriptCode;
	
	public JSFunction() {
		super();
		javascriptCode = new StringBuffer();
	}
	
	public JSFunction(JSElement[] elements){
		super();
		this.elements = elements;
		javascriptCode = new StringBuffer();
	}
	
	public JSFunction(JSElement elements[], String name){
		super();
		this.elements = elements;
		this.name = name;
		javascriptCode = new StringBuffer();
	}
	
	public JSFunction(JSElement[] elements, String name, String[] params){
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
		return params;
	}
	
	public void setParams(String[] params) {
		this.params = params;
	}

	public void addJSElement(JSElement element){
	    ArrayList listaElementi = new ArrayList();
	    if (elements != null){
		    for (int i = 0; i < elements.length; i++) {
	            listaElementi.add(elements[i]);
	        }
	    }
	    listaElementi.add(element);
	    elements = (JSElement[]) listaElementi.toArray(new JSElement[listaElementi.size()]);
	}
	
	public String toJavaScriptCode() {
	    if (name == null && params == null && elements == null){
	        throw new IllegalArgumentException();
	    }
	    else if (name == null && params == null){
	        javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_OPEN);
	        for (int i = 0; i < elements.length; i++) {
                JSElement element = elements[i];
                javascriptCode.append(element.toJavaScriptCode());
                javascriptCode.append("\n");
            }
	        javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_CLOSE);
	    }
	    else if (name == null){
	        javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_WHIT_PARAM_OPEN);
	        for (int i = 0; i < params.length; i++) {
                String param = params[i];
                javascriptCode.append(param);
                if (i != params.length -1){
                    javascriptCode.append(", ");
                }
            }
	        for (int i = 0; i < elements.length; i++) {
                JSElement element = elements[i];
                javascriptCode.append(element.toJavaScriptCode());
            }
	        javascriptCode.append(JSFunctionConstants.JS_JQUERY_FN_WHIT_PARAM_CLOSE);
	    }
	    return javascriptCode != null ? javascriptCode.toString() : null;
	}

}
