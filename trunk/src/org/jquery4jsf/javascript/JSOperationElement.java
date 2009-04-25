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
