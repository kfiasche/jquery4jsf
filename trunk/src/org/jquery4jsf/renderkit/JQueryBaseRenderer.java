package org.jquery4jsf.renderkit;

import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer;

public abstract class JQueryBaseRenderer extends HtmlBasicRenderer {
	
	protected void encodeOptionComponentByType(StringBuffer sb, boolean value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, int value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentByType(StringBuffer sb, Object value, String nameParameter, Object defaultValue){
		RendererUtilities.createOptionComponentByType(sb, value, nameParameter, defaultValue);
	}
	
	protected void encodeOptionComponentOptionsByType(StringBuffer options, String value, String nameParameter, Object defaultValue) {
		RendererUtilities.createOptionComponentOptionsByType(options, value, nameParameter);
	}
	
	protected void encodeOptionComponentArrayByType(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentArrayByType(options, value, nameParameter);
	}
	
	protected void encodeOptionComponentFunction(StringBuffer options, String value, String nameParameter) {
		RendererUtilities.createOptionComponentFunction(options, value, nameParameter);
	}
	
}
