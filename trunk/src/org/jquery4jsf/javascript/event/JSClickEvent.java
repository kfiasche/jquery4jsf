package org.jquery4jsf.javascript.event;

import org.jquery4jsf.javascript.function.JSFunction;

public class JSClickEvent extends JSEvent {

    private StringBuffer javascriptCode;
	public String getType() {
		return JSEventConstants.CLICK;
	}
	
	public JSClickEvent(){
		javascriptCode = new StringBuffer();
	}

	public void addFunction(JSFunction function) {		
	}

	public String toJavaScriptCode() {
	    return javascriptCode != null ? javascriptCode.toString() : null;
	}
}
