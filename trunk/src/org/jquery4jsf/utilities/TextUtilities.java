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
}
