package org.jquery4jsf.resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceContextImpl extends ResourceContext {

	private static List listResource;
	
	public ResourceContextImpl(){
		listResource = new ArrayList();
	}
	
	public boolean addResource(String resource){
		if (resource == null || resource.equals(""))
			return false;
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
