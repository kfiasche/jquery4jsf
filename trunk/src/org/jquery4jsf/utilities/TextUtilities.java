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
}
