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

import java.io.BufferedReader;
import java.io.StringReader;
import java.text.StringCharacterIterator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextUtilities {
	
	private static final String NEWLINE = "\n";
	
    public static boolean isNumber(String str)
    {
        boolean isNum = false;
        if (str != null && str.length() > 0)
        {
            try
            {
                Integer.parseInt(str);
                isNum = true;
            }
            catch (Exception e)
            {
            }
        }
        return isNum;
    }
    
    public static boolean isBoolean(String str){
    	boolean isBoolean = false;
    	if (str != null && str.length() > 0)
        {
            if (str.equalsIgnoreCase("true")
            		|| str.equalsIgnoreCase("false")){
            	isBoolean = true;
            }
        }
    	return isBoolean;
    }
    
    public static Object getObjectToString(String str){
    	if (isBoolean(str)){
    		return Boolean.valueOf(str);
    	}else if (isNumber(str)){
    		return Integer.valueOf(str);
    	}else{
    		return str;
    	}
    }
    
    private static final char[] REPLACEMENT_CHARS = new char[] {'\t', '\f', '\r', '\n'};
    
    public static String cleanString(String statement) {
        String newString = statement.trim();
        for (int i = 0; i < REPLACEMENT_CHARS.length; i++) {
        	newString = newString.replace(REPLACEMENT_CHARS[i], ' ').trim();
        }
        return newString;
    }

    public static String addEscapeChar(String value){
    	final StringBuffer result = new StringBuffer();
    	final StringCharacterIterator iterator = new StringCharacterIterator(value);
    	char character =  iterator.current();
    	while (character != StringCharacterIterator.DONE ){
    		switch (character) {
			case '\\':
				result.append("\\\\");
				break;
			case '\'':
				result.append("\\'");
				break;
			case '"':
				result.append("\\\"");
				break;
			case '%':
				result.append("\\%");
				break;
			default:
				result.append(character);
				break;
			}
    		character = iterator.next();
    	}
    	return result.toString();
    }
    
    public static String formatCode(String pCode) {
    	String code = cleanString(pCode);
    	StringBuffer out = new StringBuffer( code.length() );
    	BufferedReader codeReader = new BufferedReader( new StringReader( code ) );
    	String line;
    	int    indent = 0;
    	try {
    		while( null != ( line = codeReader.readLine() ) ) {
    			line = line.trim();
    			if( line.startsWith( "}" ) ) {
    				indent -= 2;
    			}
    			for(int spaceI = 0; spaceI < indent; spaceI++) {
    				out.append( " " );
    			}
    			out.append( line );
    			out.append( NEWLINE );
    			if( line.endsWith( "{" ) ) {
    				indent += 2;
    			}
    		}
    		codeReader.close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return out.toString();
    }

    public static String cleanHtml(String s) {
    	s = cleanString(s);
    	return s.replaceAll("^\\s+", "");
    }

    
    public static boolean isStringVuota(String value) {
		if (value == null 
				|| value.trim().length() == 0 
				|| value.trim().equalsIgnoreCase("null"))
			return true;
		else{
			return false;
		}
	}
	
	public static boolean getBooleanValue(String value){
		if (isBoolean(value))
			return Boolean.valueOf(value).booleanValue();
		else{
			return false;
		}
	}

	public static boolean isArray(String value) {
		return isArray(value,",");
	}

	public static boolean isArray(String value, String pattern) {
		Pattern ARRAY_DETECTOR = Pattern.compile(pattern);
		Matcher m = ARRAY_DETECTOR.matcher(value);
		while (m.find()){
			int pos=m.start();
			int count=0;
			for (int i=pos-1;i>0;i--){
				if (value.charAt(i)=='\\')
					count++;
				else
					break;
			}
			if (count % 2 == 0){
				return true;
			}
		}
		return false;
	}

	public static String cleanStringArrayChar(String value) {
		if (value.endsWith("]") && value.startsWith("["))
		{
			int inizio = value.indexOf("[");
			int fine = value.indexOf("]");
			value = value.substring(inizio+1, fine);
		}
		return value;
	}
	
	public static String toArray(List lista){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			sb.append(object.toString());
			if (iterator.hasNext())
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
}
