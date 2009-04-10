package org.jquery4jsf.custom.panel;

import java.io.IOException;

import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.render.RenderKit;
import javax.faces.render.Renderer;

public class HtmlDiv extends UIPanel {
	public static final String COMPONENT_TYPE = "org.jquery4jsf.Panel";
	public static final String RENDERER_TYPE = "org.jquery4jsf.Div";

	public HtmlDiv() {
		setRendererType(RENDERER_TYPE);
		setTransient(true);
	}
	
	protected Renderer getRenderer(FacesContext context)
	{
		String rendererType = getRendererType();
		if (rendererType == null)
			return null;

		RenderKit renderKit = context.getRenderKit();
		if (renderKit != null){
			Renderer renderer = renderKit.getRenderer(getFamily(), getRendererType());
			return renderer;
		}
		else
			return null;
	}


}
