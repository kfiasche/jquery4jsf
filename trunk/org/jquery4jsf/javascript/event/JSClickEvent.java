/*
 * Creato il 20-mar-2009
 *
 * TODO Per modificare il modello associato a questo file generato, aprire
 * Finestra - Preferenze - Java - Stile codice - Modelli codice
 */
package org.jquery4jsf.javascript.event;

import org.jquery4jsf.javascript.function.JSFunction;

/**
 * @author Administrator
 *
 * TODO Per modificare il modello associato al commento di questo tipo generato, aprire
 * Finestra - Preferenze - Java - Stile codice - Modelli codice
 */
public class JSClickEvent extends JSEvent {

    private StringBuffer javascriptCode;
	public String getType() {
		return JSEventConstants.CLICK;
	}
	
	public JSClickEvent(){
		javascriptCode = new StringBuffer();
	}

	public void addFunction(JSFunction function) {		
	}

	public String toJavaScriptCode() {
	    return javascriptCode != null ? javascriptCode.toString() : null;
	}
}
