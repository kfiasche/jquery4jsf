/*
 * Creato il 20-mar-2009
 *
 * TODO Per modificare il modello associato a questo file generato, aprire
 * Finestra - Preferenze - Java - Stile codice - Modelli codice
 */
package org.jquery4jsf.javascript.event;

import org.jquery4jsf.javascript.JSInterface;
import org.jquery4jsf.javascript.function.JSFunction;

/**
 * @author Administrator
 *
 * TODO Per modificare il modello associato al commento di questo tipo generato, aprire
 * Finestra - Preferenze - Java - Stile codice - Modelli codice
 */
public abstract class JSEvent implements JSInterface{

	public abstract String getType();
	public abstract void addFunction(JSFunction function);
}
