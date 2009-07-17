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
package org.jquery4jsf.el;

import javax.faces.context.FacesContext;
import javax.faces.el.EvaluationException;
import javax.faces.el.VariableResolver;

public class JQueryVariableResolver extends VariableResolver {
    
	private VariableResolver original;
    
    public JQueryVariableResolver(VariableResolver variableResolver) {
        this.original = variableResolver;
    }
    
	public Object resolveVariable(FacesContext context, String name) throws EvaluationException {
		Object originalResult = original.resolveVariable(context, name);
		if (originalResult != null){
			return originalResult;
		}
		Object obj = JQueryContext.getInstance().getAttribute(name);
		if (obj != null){
			return obj;
		}
		return null;
	}

}
