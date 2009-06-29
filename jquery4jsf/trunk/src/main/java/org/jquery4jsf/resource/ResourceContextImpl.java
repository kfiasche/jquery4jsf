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
package org.jquery4jsf.resource;

import java.util.ArrayList;
import java.util.List;

import org.jquery4jsf.utilities.JQueryUtilities;

public class ResourceContextImpl extends ResourceContext {

	private static List listResource;

	
	public ResourceContextImpl(){
		listResource = new ArrayList();
	}
	
	public boolean addResource(String resource){
		if (resource == null || resource.equals(""))
			return false;
		if (resource.endsWith(".css")){
			String theme = JQueryUtilities.getThemeName();
			if (theme != null){
				resource = resource.replaceAll("base", theme);
			}
		}
		if (!listResource.contains(resource)){
			if (JQueryUtilities.isCssThemeResource(resource)){
				if (JQueryUtilities.isThemeEnabled()){
					return listResource.add(resource);
				}
			}
			else
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
