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
