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
