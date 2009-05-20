/*
 
*  Copyright (c) 2009 Giuseppe Trisciuoglio 
* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jquery4jsf.custom.quicksearch;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class HtmlQuickSearchTag extends UIComponentTagBase {

	private String target;
	private String position;
	private String attached;
	private String formId;
	private String labelText;
	private String labelClass;
	private String inputText;
	private String inputClass;
	private String loaderId;
	private String loaderClass;
	private String loaderImg;
	private String loaderText;
	private String stripeRowClass;
	private String delay;
	private String focusOnLoad;
	private String hideElement;
	private String onBefore;
	private String onAfter;
	private String filter;
	private String randomElement;
	private String isFieldset;
	private String fixWidths;

	public void release(){
		super.release();
		this.target = null;
		this.position = null;
		this.attached = null;
		this.formId = null;
		this.labelText = null;
		this.labelClass = null;
		this.inputText = null;
		this.inputClass = null;
		this.loaderId = null;
		this.loaderClass = null;
		this.loaderImg = null;
		this.loaderText = null;
		this.stripeRowClass = null;
		this.delay = null;
		this.focusOnLoad = null;
		this.hideElement = null;
		this.onBefore = null;
		this.onAfter = null;
		this.filter = null;
		this.randomElement = null;
		this.isFieldset = null;
		this.fixWidths = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.quicksearch.HtmlQuickSearch component = null;
		try {
			component = (org.jquery4jsf.custom.quicksearch.HtmlQuickSearch) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "target", target);
		setStringProperty(getFacesContext(), component, "position", position);
		setStringProperty(getFacesContext(), component, "attached", attached);
		setStringProperty(getFacesContext(), component, "formId", formId);
		setStringProperty(getFacesContext(), component, "labelText", labelText);
		setStringProperty(getFacesContext(), component, "labelClass", labelClass);
		setStringProperty(getFacesContext(), component, "inputText", inputText);
		setStringProperty(getFacesContext(), component, "inputClass", inputClass);
		setStringProperty(getFacesContext(), component, "loaderId", loaderId);
		setStringProperty(getFacesContext(), component, "loaderClass", loaderClass);
		setStringProperty(getFacesContext(), component, "loaderImg", loaderImg);
		setStringProperty(getFacesContext(), component, "loaderText", loaderText);
		setStringProperty(getFacesContext(), component, "stripeRowClass", stripeRowClass);
		setIntegerProperty(getFacesContext(), component, "delay", delay);
		setBooleanProperty(getFacesContext(), component, "focusOnLoad", focusOnLoad);
		setStringProperty(getFacesContext(), component, "hideElement", hideElement);
		setStringProperty(getFacesContext(), component, "onBefore", onBefore);
		setStringProperty(getFacesContext(), component, "onAfter", onAfter);
		setStringProperty(getFacesContext(), component, "filter", filter);
		setStringProperty(getFacesContext(), component, "randomElement", randomElement);
		setBooleanProperty(getFacesContext(), component, "isFieldset", isFieldset);
		setBooleanProperty(getFacesContext(), component, "fixWidths", fixWidths);
	}

	public String getComponentType() {
		return HtmlQuickSearch.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.HtmlQuickSearchRenderer";
	}

	public void setTarget(String value){
		this.target = value;
	}

	public void setPosition(String value){
		this.position = value;
	}

	public void setAttached(String value){
		this.attached = value;
	}

	public void setFormId(String value){
		this.formId = value;
	}

	public void setLabelText(String value){
		this.labelText = value;
	}

	public void setLabelClass(String value){
		this.labelClass = value;
	}

	public void setInputText(String value){
		this.inputText = value;
	}

	public void setInputClass(String value){
		this.inputClass = value;
	}

	public void setLoaderId(String value){
		this.loaderId = value;
	}

	public void setLoaderClass(String value){
		this.loaderClass = value;
	}

	public void setLoaderImg(String value){
		this.loaderImg = value;
	}

	public void setLoaderText(String value){
		this.loaderText = value;
	}

	public void setStripeRowClass(String value){
		this.stripeRowClass = value;
	}

	public void setDelay(String value){
		this.delay = value;
	}

	public void setFocusOnLoad(String value){
		this.focusOnLoad = value;
	}

	public void setHideElement(String value){
		this.hideElement = value;
	}

	public void setOnBefore(String value){
		this.onBefore = value;
	}

	public void setOnAfter(String value){
		this.onAfter = value;
	}

	public void setFilter(String value){
		this.filter = value;
	}

	public void setRandomElement(String value){
		this.randomElement = value;
	}

	public void setIsFieldset(String value){
		this.isFieldset = value;
	}

	public void setFixWidths(String value){
		this.fixWidths = value;
	}

}