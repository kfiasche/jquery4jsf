package org.jquery4jsf.renderkit;

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer;

public abstract class JQueryBaseRenderer extends HtmlBasicRenderer {
	
	protected void encodeOptionComponentByType(StringBuffer sb, boolean value, String nameParameter){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter);
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, int value, String nameParameter){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter);
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, Object value, String nameParameter){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter);
	}
	
	//TODO da realizzare
	protected void encodeOptionComponentOptionsByType(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentOptionsByType(options, value, nameParameter);
	}
	
	protected void encodeOptionComponentArrayByType(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentArrayByType(options, value, nameParameter);
	}
	
}
