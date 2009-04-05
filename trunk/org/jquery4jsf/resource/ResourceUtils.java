package org.jquery4jsf.resource;

import javax.faces.context.FacesContext;

public class ResourceUtils {

	public final static String RESOURCE_FOLDER = "/META-INF/resource";
	public final static String RESOURCE_PATTERN = "/jquery4jsf_resource";
	public final static String CSS_RESOURCE_PATTERN = "jquery4jsf_resource:url:";
	
	public static String getResourceURL(FacesContext facesContext, String resource) {
		String contextPath = facesContext.getExternalContext().getRequestContextPath();
		return contextPath + RESOURCE_PATTERN + resource;
	}
}
