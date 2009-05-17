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
package org.jquery4jsf.custom.autocomplete;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class AutoCompleteTag extends UIComponentTagBase {

	private String jsonValue;
	private String minChars;
	private String delay;
	private String cacheLength;
	private String matchSubset;
	private String matchCase;
	private String matchContains;
	private String mustMatch;
	private String selectFirst;
	private String extraParams;
	private String multiple;
	private String multipleSeparator;
	private String width;
	private String autoFill;
	private String max;
	private String highlight;
	private String scroll;
	private String scrollHeight;
	private String onformatItem;
	private String onformatMatch;
	private String onformatResult;
	private String oncomplete;

	public void release(){
		super.release();
		this.jsonValue = null;
		this.minChars = null;
		this.delay = null;
		this.cacheLength = null;
		this.matchSubset = null;
		this.matchCase = null;
		this.matchContains = null;
		this.mustMatch = null;
		this.selectFirst = null;
		this.extraParams = null;
		this.multiple = null;
		this.multipleSeparator = null;
		this.width = null;
		this.autoFill = null;
		this.max = null;
		this.highlight = null;
		this.scroll = null;
		this.scrollHeight = null;
		this.onformatItem = null;
		this.onformatMatch = null;
		this.onformatResult = null;
		this.oncomplete = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.autocomplete.AutoComplete component = null;
		try {
			component = (org.jquery4jsf.custom.autocomplete.AutoComplete) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "jsonValue", jsonValue);
		setIntegerProperty(getFacesContext(), component, "minChars", minChars);
		setIntegerProperty(getFacesContext(), component, "delay", delay);
		setIntegerProperty(getFacesContext(), component, "cacheLength", cacheLength);
		setBooleanProperty(getFacesContext(), component, "matchSubset", matchSubset);
		setBooleanProperty(getFacesContext(), component, "matchCase", matchCase);
		setBooleanProperty(getFacesContext(), component, "matchContains", matchContains);
		setBooleanProperty(getFacesContext(), component, "mustMatch", mustMatch);
		setBooleanProperty(getFacesContext(), component, "selectFirst", selectFirst);
		setStringProperty(getFacesContext(), component, "extraParams", extraParams);
		setBooleanProperty(getFacesContext(), component, "multiple", multiple);
		setStringProperty(getFacesContext(), component, "multipleSeparator", multipleSeparator);
		setIntegerProperty(getFacesContext(), component, "width", width);
		setBooleanProperty(getFacesContext(), component, "autoFill", autoFill);
		setIntegerProperty(getFacesContext(), component, "max", max);
		setStringProperty(getFacesContext(), component, "highlight", highlight);
		setBooleanProperty(getFacesContext(), component, "scroll", scroll);
		setIntegerProperty(getFacesContext(), component, "scrollHeight", scrollHeight);
		setStringProperty(getFacesContext(), component, "onformatItem", onformatItem);
		setStringProperty(getFacesContext(), component, "onformatMatch", onformatMatch);
		setStringProperty(getFacesContext(), component, "onformatResult", onformatResult);
		setMethodBindingProperty(getFacesContext(), component, "oncomplete", oncomplete);
	}

	public String getComponentType() {
		return AutoComplete.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.AutoCompleteRenderer";
	}

	public void setJsonValue(String value){
		this.jsonValue = value;
	}

	public void setMinChars(String value){
		this.minChars = value;
	}

	public void setDelay(String value){
		this.delay = value;
	}

	public void setCacheLength(String value){
		this.cacheLength = value;
	}

	public void setMatchSubset(String value){
		this.matchSubset = value;
	}

	public void setMatchCase(String value){
		this.matchCase = value;
	}

	public void setMatchContains(String value){
		this.matchContains = value;
	}

	public void setMustMatch(String value){
		this.mustMatch = value;
	}

	public void setSelectFirst(String value){
		this.selectFirst = value;
	}

	public void setExtraParams(String value){
		this.extraParams = value;
	}

	public void setMultiple(String value){
		this.multiple = value;
	}

	public void setMultipleSeparator(String value){
		this.multipleSeparator = value;
	}

	public void setWidth(String value){
		this.width = value;
	}

	public void setAutoFill(String value){
		this.autoFill = value;
	}

	public void setMax(String value){
		this.max = value;
	}

	public void setHighlight(String value){
		this.highlight = value;
	}

	public void setScroll(String value){
		this.scroll = value;
	}

	public void setScrollHeight(String value){
		this.scrollHeight = value;
	}

	public void setOnformatItem(String value){
		this.onformatItem = value;
	}

	public void setOnformatMatch(String value){
		this.onformatMatch = value;
	}

	public void setOnformatResult(String value){
		this.onformatResult = value;
	}

	public void setOncomplete(String value){
		this.oncomplete = value;
	}

}