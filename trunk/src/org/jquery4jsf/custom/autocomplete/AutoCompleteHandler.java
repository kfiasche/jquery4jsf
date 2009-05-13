package org.jquery4jsf.custom.autocomplete;

import java.util.List;

import com.sun.facelets.tag.MetaRule;
import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.MethodRule;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.ComponentHandler;

public class AutoCompleteHandler extends ComponentHandler{

	public AutoCompleteHandler(ComponentConfig config) {
		super(config);
	}
	
	protected MetaRuleset createMetaRuleset(Class type) { 
		MetaRuleset metaRuleset = super.createMetaRuleset(type); 
		Class[] paramList = new Class[]{String.class}; 
		
		MetaRule metaRule = new MethodRule("oncomplete", List.class, paramList); 
		metaRuleset.addRule(metaRule);
		
		return metaRuleset; 
	} 
}
