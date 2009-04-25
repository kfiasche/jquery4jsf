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
