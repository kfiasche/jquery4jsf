package org.jquery4jsf.resource;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

public class ResourceContextImpl extends ResourceContext {

	private static List listResource;
	private static String PARAM_THEME_CSS = "org.jquery4jsf.THEME_CSS";
	
	public ResourceContextImpl(){
		listResource = new ArrayList();
	}
	
	public boolean addResource(String resource){
		if (resource == null || resource.equals(""))
			return false;
		if (resource.endsWith(".css")){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String theme   = facesContext.getExternalContext().getInitParameter(PARAM_THEME_CSS);
			if (theme != null){
				resource = resource.replaceAll("base", theme);
			}
		}
		if (!listResource.contains(resource)){
			return listResource.add(resource);
		}
		return false;
	}
	
	public List getResources(){
		return listResource;
	}

	public void release() {
		listResource = new ArrayList();	
	}
}
