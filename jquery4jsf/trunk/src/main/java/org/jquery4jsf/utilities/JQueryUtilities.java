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
package org.jquery4jsf.utilities;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

public final class JQueryUtilities {

	public static final String PARAM_THEME_CSS 			= "org.jquery4jsf.THEME_CSS";
	public static final String PARAM_THEME_CSS_ENABLE 	= "org.jquery4jsf.THEME_CSS_ENABLE";
	public static final String PARAM_TACONITE 			= "org.jquery4jsf.TACONITE";
	public static final String PARAM_JQUERY_NO_CONFLICT = "org.jquery4jsf.JQUERY_NO_CONFLICT";
	public static final String PARAM_HTML_RESP_COMPRESSOR = "org.jquery4jsf.HTML_RESP_COMPRESSOR";
	
	public static final String JQUERY_SHORT = "$";
	public static final String JQUERY_FULL = "jQuery";
	private Map parameterMap;
	private static JQueryUtilities instance;
	
	private JQueryUtilities(ServletContext servletContext){
		parameterMap = new HashMap();
		initSingleton(servletContext);
	}
	
	private void initSingleton(ServletContext servletContext) {
		Enumeration enumeration = servletContext.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			String value = servletContext.getInitParameter(name);
			if (!parameterMap.containsKey(name)){
				parameterMap.put(name, value);
			}
		}
	}

	public boolean isTacconiteEnabled(){
		String taconiteValue = (String) parameterMap.get(PARAM_TACONITE);
		return TextUtilities.isBoolean(taconiteValue) ? Boolean.valueOf(taconiteValue).booleanValue() : true;
	}
	
	public boolean isJQueryNoConflictEnabled(){
		String noConflic =  (String) parameterMap.get(PARAM_JQUERY_NO_CONFLICT);
		return TextUtilities.isBoolean(noConflic) ? Boolean.valueOf(noConflic).booleanValue() : false;
	}
	
	public boolean isHtmlCompressorEnabled(){
		String htmlCompressor =  (String) parameterMap.get(PARAM_HTML_RESP_COMPRESSOR);
		return TextUtilities.isBoolean(htmlCompressor) ? Boolean.valueOf(htmlCompressor).booleanValue() : false;
	}
	
	public boolean isThemeEnabled(){
		String themeEnable   =   (String) parameterMap.get(PARAM_THEME_CSS_ENABLE);
		if (!TextUtilities.isStringVuota(themeEnable)){
			return (Boolean.valueOf(themeEnable)).booleanValue();
		}
		else{
			return true;
		}
	}
	
	public boolean isCssThemeResource(String resource){
		return resource.endsWith(".css") && resource.indexOf("theme") > -1;
	}
	
	public String getThemeName(){
		String themeName =  (String) parameterMap.get(PARAM_THEME_CSS);
		return themeName;
	}

	public synchronized static JQueryUtilities getInstance(ServletContext sc) {
		if (instance == null){
			instance = new JQueryUtilities(sc);
		}
		return instance;
	}
	
	public synchronized static JQueryUtilities getInstance(){
		if (instance == null){
			throw new IllegalArgumentException();
		}
		return instance;
	}
	
	public static void reset(){
		instance = null;
	}
}
