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
package org.jquery4jsf.application.taconite;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.ResponseWriter;

public class TaconiteResponse {
	

	private static final String START_RESPONSE = new String("<?xml version=\"1.0\"?>\n<taconite>\n");
    private static final String END_RESPONSE = new String("\n</taconite>");
    private List actions = new LinkedList();
    private ResponseWriter responseWriter;
    
	public TaconiteResponse(ResponseWriter responseWriter) {
		super();
		this.responseWriter = responseWriter;
	}
    
    public boolean addAction(TaconiteAction tacconiteAction){
    	return actions.add(tacconiteAction);
    }

    public void writeResponse() throws IOException{
    	responseWriter.write(START_RESPONSE);
    	for (Iterator iterator = actions.iterator(); iterator.hasNext();) {
			TaconiteAction tacconiteAction = (TaconiteAction) iterator.next();
			tacconiteAction.processTacconiteAction();
		}
    	responseWriter.write(END_RESPONSE);
    }
    
}
