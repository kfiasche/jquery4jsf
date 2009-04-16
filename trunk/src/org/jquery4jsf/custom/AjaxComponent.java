package org.jquery4jsf.custom;

import java.io.IOException;

import javax.faces.context.FacesContext;

public interface AjaxComponent {

	public void encodePartially(FacesContext facesContext) throws IOException;
	
}
