package org.jquery4jsf.utilities;

import javax.faces.context.FacesContext;

public final class JQueryUtilities {

	public static final String PARAM_THEME_CSS 			= "org.jquery4jsf.THEME_CSS";
	public static final String PARAM_THEME_CSS_ENABLE 	= "org.jquery4jsf.THEME_CSS_ENABLE";
	public static final String PARAM_TACONITE 			= "org.jquery4jsf.TACONITE";
	public static final String PARAM_JQUERY_NO_CONFLICT = "org.jquery4jsf.JQUERY_NO_CONFLICT";
	
	public static final String JQUERY_SHORT = "$";
	public static final String JQUERY_FULL = "jQuery";
	
	public static boolean isTacconiteEnabled(){
		FacesContext context = getFacesContext();
		String tacconite = context.getExternalContext().getInitParameter(PARAM_TACONITE);
		return TextUtilities.isBoolean(tacconite) ? Boolean.valueOf(tacconite).booleanValue() : true;
	}
	
	public static boolean isJQueryNoConflictEnabled(){
		FacesContext context = getFacesContext();
		String tacconite = context.getExternalContext().getInitParameter(PARAM_JQUERY_NO_CONFLICT);
		return TextUtilities.isBoolean(tacconite) ? Boolean.valueOf(tacconite).booleanValue() : false;
	}
	
	public static boolean isThemeEnabled(){
		FacesContext context = getFacesContext();
		String themeEnable   =  context.getExternalContext().getInitParameter(PARAM_THEME_CSS_ENABLE);
		if (!TextUtilities.isStringVuota(themeEnable)){
			return (Boolean.valueOf(themeEnable)).booleanValue();
		}
		else{
			return true;
		}
	}
	
	public static boolean isCssThemeResource(String resource){
		return resource.endsWith(".css") && resource.indexOf("theme") > -1;
	}
	
	public static String getThemeName(){
		FacesContext context = getFacesContext();
		String themeName = context.getExternalContext().getInitParameter(PARAM_THEME_CSS);
		return themeName;
	}
	
	private static FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
}
