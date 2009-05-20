package org.jquery4jsf.custom.tooltip;

import com.sun.facelets.tag.MetaRule;
import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.MethodRule;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.ComponentHandler;


public class TooltipHandler extends ComponentHandler{

	public TooltipHandler(ComponentConfig config) {
		super(config);
	}
	
	protected MetaRuleset createMetaRuleset(Class type) { 
		MetaRuleset metaRuleset = super.createMetaRuleset(type); 
		Class[] paramList = new Class[]{String.class}; 
		
		MetaRule metaRule = new MethodRule("oncomplete", String.class, paramList); 
		metaRuleset.addRule(metaRule);
		
		return metaRuleset; 
	} 
}
