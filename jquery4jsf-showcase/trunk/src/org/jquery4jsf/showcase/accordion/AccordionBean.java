package org.jquery4jsf.showcase.accordion;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;

import org.jquery4jsf.showcase.parser.model.TagDefinition;
import org.jquery4jsf.showcase.parser.model.TagLib;

public class AccordionBean {
	
	private TagDefinition accordionPanelDefinition;
	private TagDefinition accordionSubPanelDefinition;
	private String content;
	public AccordionBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		ValueBinding valueBinding = context.getApplication().createValueBinding("#{startupBean.tagLib}");
		TagLib tagLib = (TagLib) valueBinding.getValue(context);
		accordionPanelDefinition = tagLib.getTags().get("accordionPanel");
		accordionSubPanelDefinition = tagLib.getTags().get("accordionSubPanel");
		
		content = "It's a default content";
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
	
	public void actionListener(ActionEvent actionEvent){
		Date dt = new Date();
		content = "It's a content load with a ajaxEvent: "+ dt.getTime() ;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
