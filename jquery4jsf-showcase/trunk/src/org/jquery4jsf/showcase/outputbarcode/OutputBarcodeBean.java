/**
 * 
 */
package org.jquery4jsf.showcase.outputbarcode;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.jquery4jsf.showcase.parser.model.TagDefinition;
import org.jquery4jsf.showcase.parser.model.TagLib;

/**
 * @author Administrator
 *
 */
public class OutputBarcodeBean {
	
	private TagDefinition outputBarcodeDefinition;
	
	public OutputBarcodeBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		ValueBinding valueBinding = context.getApplication().createValueBinding("#{startupBean.tagLib}");
		TagLib tagLib = (TagLib) valueBinding.getValue(context);
		outputBarcodeDefinition = tagLib.getTags().get("outputBarcode");
	}

	public TagDefinition getOutputBarcodeDefinition() {
		return outputBarcodeDefinition;
	}

	public void setOutputBarcodeDefinition(TagDefinition outputBarcodeDefinition) {
		this.outputBarcodeDefinition = outputBarcodeDefinition;
	}
}
