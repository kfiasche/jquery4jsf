package org.jquery4jsf.javascript.event;

import org.jquery4jsf.javascript.function.JSFunction;

public class JSHideEvent extends JSEvent {

	public void addFunction(JSFunction function) {
	}

	public String getType() {
		return null;
	}

	public String toJavaScriptCode() {
		return ".hide();";
	}

}
