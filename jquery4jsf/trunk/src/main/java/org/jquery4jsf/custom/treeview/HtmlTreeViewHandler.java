/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.jquery4jsf.custom.treeview;

import java.util.List;

import org.jquery4jsf.component.tree.NodeCollapseEvent;
import org.jquery4jsf.component.tree.NodeExpandEvent;
import org.jquery4jsf.component.tree.NodeSelectEvent;

import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.MethodRule;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.ComponentHandler;


public class HtmlTreeViewHandler extends ComponentHandler{

	public HtmlTreeViewHandler(ComponentConfig config) {
		super(config);
	}
	
	protected MetaRuleset createMetaRuleset(Class type) { 
		MetaRuleset metaRuleset = super.createMetaRuleset(type); 
		Class[] selectEventClasses = new Class[]{NodeSelectEvent.class};
		Class[] expandEventClasses = new Class[]{NodeExpandEvent.class};
		Class[] collapseEventClasses = new Class[]{NodeCollapseEvent.class};
		
		metaRuleset.addRule(new MethodRule("treeNodeSelectListener", List.class, selectEventClasses));
		metaRuleset.addRule(new MethodRule("treeNodeExpandListener", List.class, expandEventClasses));
		metaRuleset.addRule(new MethodRule("treeNodeCollapseListener", List.class, collapseEventClasses));
		
		return metaRuleset; 
	} 
}
