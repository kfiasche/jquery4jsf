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
