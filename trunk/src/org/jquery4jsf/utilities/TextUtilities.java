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

public final class TextUtilities {

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
        	newString = newString.replace(REPLACEMENT_CHARS[i], ' ');
        }
        return newString;
    }

	public static boolean isStringVuota(String value) {
		if (value == null || value.trim().length() == 0)
			return true;
		else{
			return false;
		}
	}
	


}
