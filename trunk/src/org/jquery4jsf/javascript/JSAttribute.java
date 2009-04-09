package org.jquery4jsf.javascript;

public class JSAttribute implements JSInterface{


    private String name;
    private StringBuffer javascriptCode;
    private boolean isSetGet = true;
    /**
     * @param name
     */
    public JSAttribute(String name, boolean setGet) {
        super();
        this.name = name;
        isSetGet  = setGet;
        javascriptCode = new StringBuffer();
    }
    
    public String toJavaScriptCode() {
        return javascriptCode != null ? javascriptCode.toString() : null;
    }

    /**
     * @return Restituisce il valore name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name Il valore name da impostare.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void addValue(String code){
        if (code != null && !code.equalsIgnoreCase("")){
            if (isSetGet){
    	        javascriptCode.append(".set");
    	        javascriptCode.append(name.substring(0,1).toUpperCase());
    	        javascriptCode.append(name.substring(1).toLowerCase());
    	        javascriptCode.append("(");
    	        javascriptCode.append(code);
    	        javascriptCode.append(");");
            }
            else{
    	        javascriptCode.append(".");
    	        javascriptCode.append(name);
    	        javascriptCode.append("(");
    	        javascriptCode.append(code);
    	        javascriptCode.append(");");
            }
        }else{
    	        javascriptCode.append(".");
    	        javascriptCode.append(name);
    	        javascriptCode.append("(");
    	        javascriptCode.append(");");
        }
    }
}
