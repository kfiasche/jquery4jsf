package org.jquery4jsf.utilities;

public final class TextUtilities {

    public static boolean isNumber(String str)
    {
        boolean isNum = false;
        if (str != null && str.length() > 0)
        {
            try
            {
                int intVal = Integer.parseInt(str);
                if (intVal >= 0)
                {
                    isNum = true;
                }
            }
            catch (Exception e)
            {
            }
        }
        return isNum;
    }
}
