package org.jquery4jsf.custom;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

public interface AjaxComponent {

	public void encodePartially(FacesContext facesContext) throws IOException;
	public void setOncomplete(MethodBinding methodBinding);
	public MethodBinding getOncomplete();
	
}
