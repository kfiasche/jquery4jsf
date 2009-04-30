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
package org.jquery4jsf.javascript;

import java.util.ArrayList;
import java.util.Iterator;

public class JSOperationElement extends JSElement {

	public ArrayList listaOperation;
	public JSOperationElement(String id) {
		super(id);
		listaOperation = new ArrayList();
	}
	
	public void addOperation(String operation){
		if (isValidOperation(operation)){
			listaOperation.add(operation);
		}
	}

	public String toJavaScriptCode() {
		StringBuffer sb = new StringBuffer();
		for (Iterator iterator = listaOperation.iterator(); iterator.hasNext();) {
			String operation = (String) iterator.next();
			sb.append(operation).append("\n");
		}
		return sb.toString();
	}
	
	private boolean isValidOperation(String operation){
		if (operation == null || operation.trim().length() == 0 || operation.lastIndexOf(";") == -1){
			return false;
		}
		return true;
	}
	
}
