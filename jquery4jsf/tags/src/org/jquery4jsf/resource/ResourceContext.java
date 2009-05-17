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

import java.util.List;

public abstract class ResourceContext {
	
	public abstract boolean addResource(String resource);
	public abstract List getResources();
	
	private static ThreadLocal _currentResourceInstance = new ThreadLocal()
    {
        protected Object initialValue()
        {
            return null;
        }
    };
    
	public synchronized static ResourceContext getInstance() {
		ResourceContext instance = null;
		if(_currentResourceInstance.get() == null){
			instance = new ResourceContextImpl();
			_currentResourceInstance.set(instance);
		}else{
			instance = (ResourceContext) _currentResourceInstance.get();
		}
		return instance;
	}
	public abstract void release();
	
}
