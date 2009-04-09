package org.jquery4jsf.javascript.event;

import org.jquery4jsf.javascript.JSInterface;
import org.jquery4jsf.javascript.function.JSFunction;


public abstract class JSEvent implements JSInterface{

	public abstract String getType();
	public abstract void addFunction(JSFunction function);
}
