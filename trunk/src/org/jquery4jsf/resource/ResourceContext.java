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
