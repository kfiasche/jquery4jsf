package org.jquery4jsf.showcase.accordion;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.jquery4jsf.showcase.parser.model.TagDefinition;
import org.jquery4jsf.showcase.parser.model.TagLib;

public class AccordionBean {
	
	private TagDefinition accordionPanelDefinition;
	private TagDefinition accordionSubPanelDefinition;
	
	public AccordionBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		ValueBinding valueBinding = context.getApplication().createValueBinding("#{startupBean.tagLib}");
		TagLib tagLib = (TagLib) valueBinding.getValue(context);
		accordionPanelDefinition = tagLib.getTags().get("accordionPanel");
		accordionSubPanelDefinition = tagLib.getTags().get("accordionSubPanel");
	}

	public TagDefinition getAccordionPanelDefinition() {
		return accordionPanelDefinition;
	}

	public void setAccordionPanelDefinition(TagDefinition accordionPanelDefinition) {
		this.accordionPanelDefinition = accordionPanelDefinition;
	}

	public TagDefinition getAccordionSubPanelDefinition() {
		return accordionSubPanelDefinition;
	}

	public void setAccordionSubPanelDefinition(
			TagDefinition accordionSubPanelDefinition) {
		this.accordionSubPanelDefinition = accordionSubPanelDefinition;
	}
}
