package org.jquery4jsf.renderkit;

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer;

public abstract class JQueryBaseRenderer extends HtmlBasicRenderer {
	
	protected void createOptionComponentByType(StringBuffer sb, boolean value, String nameParameter){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter);
	}
	
	protected void createOptionComponentByType(StringBuffer sb, int value, String nameParameter){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter);
	}
	
	protected void createOptionComponentByType(StringBuffer sb, Object value, String nameParameter){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter);
	}
	
	//TODO da realizzare
	protected void createOptionComponentOptionsByType(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentOptionsByType(options, value, nameParameter);
	}
	
	protected void createOptionComponentArrayByType(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentArrayByType(options, value, nameParameter);
	}
	
}
