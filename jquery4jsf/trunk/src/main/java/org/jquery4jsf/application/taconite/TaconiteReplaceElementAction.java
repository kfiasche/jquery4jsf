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

import java.util.List;

import javax.faces.component.UIComponent;

public class TaconiteReplaceElementAction extends AbstractTaconiteAction {
	
	private static final String START_ELEMENT = "<replace select=\"$1\">";
	private static final String END_ELEMENT = "</replace>";
	
	public TaconiteReplaceElementAction(String id, List components) {
		super(id, components);
	}
	
	public TaconiteReplaceElementAction(String id, UIComponent component) {
		super(id, component);
	}
	
	protected String getEndElement() {
		return END_ELEMENT;
	}

	protected String getStartElement() {
		return START_ELEMENT;
	}

}
