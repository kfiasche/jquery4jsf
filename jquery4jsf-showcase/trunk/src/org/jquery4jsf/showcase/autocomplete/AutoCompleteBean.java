package org.jquery4jsf.showcase.autocomplete;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.jquery4jsf.showcase.parser.model.TagDefinition;
import org.jquery4jsf.showcase.parser.model.TagLib;

public class AutoCompleteBean {

	private TagDefinition autoCompleteDefinition;
	
	public AutoCompleteBean() {
		super();
		FacesContext context = FacesContext.getCurrentInstance();
		ValueBinding valueBinding = context.getApplication().createValueBinding("#{startupBean.tagLib}");
		TagLib tagLib = (TagLib) valueBinding.getValue(context);
		autoCompleteDefinition = tagLib.getTags().get("autoComplete");
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public List<String> completeAlgo(String query){
		List<String> listaQuery = new ArrayList<String>();
		for (int i=0; i<11; i++){
			query = query.concat(Integer.toString(i));
			listaQuery.add(query);
		}
		return listaQuery;
	}

	public TagDefinition getAutoCompleteDefinition() {
		return autoCompleteDefinition;
	}

	public void setAutoCompleteDefinition(TagDefinition autoCompleteDefinition) {
		this.autoCompleteDefinition = autoCompleteDefinition;
	}
	
}
