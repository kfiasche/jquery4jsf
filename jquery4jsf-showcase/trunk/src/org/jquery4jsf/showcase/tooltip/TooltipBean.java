/**
 * 
 */
package org.jquery4jsf.showcase.tooltip;

import javax.faces.context.FacesContext;

/**
 * @author Administrator
 *
 */
public class TooltipBean {
	public TooltipBean() {
	}
	public String onComplete(){
		String ruolo = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ruolo");
		return "This player is a fantastic ".concat(ruolo).concat("!!!");
	}
}
