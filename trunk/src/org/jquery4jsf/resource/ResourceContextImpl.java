package org.jquery4jsf.resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceContextImpl implements ResourceContext{

	private static List listResource;
	
	public ResourceContextImpl(){
		listResource = new ArrayList();
	}
	
	public boolean addResource(String resource){
		if (resource == null || resource.equals(""))
			return false;
		if (!listResource.contains(resource)){
			System.out.println("add Resource: "+ resource);
			return listResource.add(resource);
		}
		return false;
	}
	
	public List getResources(){
		return listResource;
	}
}
