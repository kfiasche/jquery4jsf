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

	private String value;
	private String converter;
	private String immediate;
	private String required;
	private String validator;
	private String valueChangeListener;
	private String requiredMessage;
	private String converterMessage;
	private String validatorMessage;
	private String accesskey;
	private String alt;
	private String dir;
	private String disabled;
	private String lang;
	private String maxlength;
	private String onblur;
	private String onchange;
	private String onclick;
	private String ondblclick;
	private String onfocus;
	private String onkeydown;
	private String onkeypress;
	private String onkeyup;
	private String onmousedown;
	private String onmousemove;
	private String onmouseout;
	private String onmouseover;
	private String onmouseup;
	private String readonly;
	private String size;
	private String style;
	private String styleClass;
	private String tabindex;
	private String title;
	private String jsonValue;
	private String minChars;
	private String delay;
	private String cacheLength;
	private String matchSubset;
	private String matchCase;
	private String matchContains;
	private String mustMatch;
	private String selectFirst;
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
		this.value = null;
		this.converter = null;
		this.immediate = null;
		this.required = null;
		this.validator = null;
		this.valueChangeListener = null;
		this.requiredMessage = null;
		this.converterMessage = null;
		this.validatorMessage = null;
		this.accesskey = null;
		this.alt = null;
		this.dir = null;
		this.disabled = null;
		this.lang = null;
		this.maxlength = null;
		this.onblur = null;
		this.onchange = null;
		this.onclick = null;
		this.ondblclick = null;
		this.onfocus = null;
		this.onkeydown = null;
		this.onkeypress = null;
		this.onkeyup = null;
		this.onmousedown = null;
		this.onmousemove = null;
		this.onmouseout = null;
		this.onmouseover = null;
		this.onmouseup = null;
		this.readonly = null;
		this.size = null;
		this.style = null;
		this.styleClass = null;
		this.tabindex = null;
		this.title = null;
		this.jsonValue = null;
		this.minChars = null;
		this.delay = null;
		this.cacheLength = null;
		this.matchSubset = null;
		this.matchCase = null;
		this.matchContains = null;
		this.mustMatch = null;
		this.selectFirst = null;
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

		setValueProperty(getFacesContext(), component, "value", value);
		setConverterProperty(getFacesContext(), component, "converter", converter);
		setBooleanProperty(getFacesContext(), component, "immediate", immediate);
		setBooleanProperty(getFacesContext(), component, "required", required);
		setValidatorProperty(getFacesContext(), component, "validator", validator);
		setValueChangeListenerProperty(getFacesContext(), component, "valueChangeListener", valueChangeListener);
		setStringProperty(getFacesContext(), component, "requiredMessage", requiredMessage);
		setStringProperty(getFacesContext(), component, "converterMessage", converterMessage);
		setStringProperty(getFacesContext(), component, "validatorMessage", validatorMessage);
		setStringProperty(getFacesContext(), component, "accesskey", accesskey);
		setStringProperty(getFacesContext(), component, "alt", alt);
		setStringProperty(getFacesContext(), component, "dir", dir);
		setBooleanProperty(getFacesContext(), component, "disabled", disabled);
		setStringProperty(getFacesContext(), component, "lang", lang);
		setIntegerProperty(getFacesContext(), component, "maxlength", maxlength);
		setStringProperty(getFacesContext(), component, "onblur", onblur);
		setStringProperty(getFacesContext(), component, "onchange", onchange);
		setStringProperty(getFacesContext(), component, "onclick", onclick);
		setStringProperty(getFacesContext(), component, "ondblclick", ondblclick);
		setStringProperty(getFacesContext(), component, "onfocus", onfocus);
		setStringProperty(getFacesContext(), component, "onkeydown", onkeydown);
		setStringProperty(getFacesContext(), component, "onkeypress", onkeypress);
		setStringProperty(getFacesContext(), component, "onkeyup", onkeyup);
		setStringProperty(getFacesContext(), component, "onmousedown", onmousedown);
		setStringProperty(getFacesContext(), component, "onmousemove", onmousemove);
		setStringProperty(getFacesContext(), component, "onmouseout", onmouseout);
		setStringProperty(getFacesContext(), component, "onmouseover", onmouseover);
		setStringProperty(getFacesContext(), component, "onmouseup", onmouseup);
		setBooleanProperty(getFacesContext(), component, "readonly", readonly);
		setIntegerProperty(getFacesContext(), component, "size", size);
		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setStringProperty(getFacesContext(), component, "tabindex", tabindex);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "jsonValue", jsonValue);
		setIntegerProperty(getFacesContext(), component, "minChars", minChars);
		setIntegerProperty(getFacesContext(), component, "delay", delay);
		setIntegerProperty(getFacesContext(), component, "cacheLength", cacheLength);
		setBooleanProperty(getFacesContext(), component, "matchSubset", matchSubset);
		setBooleanProperty(getFacesContext(), component, "matchCase", matchCase);
		setBooleanProperty(getFacesContext(), component, "matchContains", matchContains);
		setBooleanProperty(getFacesContext(), component, "mustMatch", mustMatch);
		setBooleanProperty(getFacesContext(), component, "selectFirst", selectFirst);
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

	public void setValue(String value){
		this.value = value;
	}

	public void setConverter(String value){
		this.converter = value;
	}

	public void setImmediate(String value){
		this.immediate = value;
	}

	public void setRequired(String value){
		this.required = value;
	}

	public void setValidator(String value){
		this.validator = value;
	}

	public void setValueChangeListener(String value){
		this.valueChangeListener = value;
	}

	public void setRequiredMessage(String value){
		this.requiredMessage = value;
	}

	public void setConverterMessage(String value){
		this.converterMessage = value;
	}

	public void setValidatorMessage(String value){
		this.validatorMessage = value;
	}

	public void setAccesskey(String value){
		this.accesskey = value;
	}

	public void setAlt(String value){
		this.alt = value;
	}

	public void setDir(String value){
		this.dir = value;
	}

	public void setDisabled(String value){
		this.disabled = value;
	}

	public void setLang(String value){
		this.lang = value;
	}

	public void setMaxlength(String value){
		this.maxlength = value;
	}

	public void setOnblur(String value){
		this.onblur = value;
	}

	public void setOnchange(String value){
		this.onchange = value;
	}

	public void setOnclick(String value){
		this.onclick = value;
	}

	public void setOndblclick(String value){
		this.ondblclick = value;
	}

	public void setOnfocus(String value){
		this.onfocus = value;
	}

	public void setOnkeydown(String value){
		this.onkeydown = value;
	}

	public void setOnkeypress(String value){
		this.onkeypress = value;
	}

	public void setOnkeyup(String value){
		this.onkeyup = value;
	}

	public void setOnmousedown(String value){
		this.onmousedown = value;
	}

	public void setOnmousemove(String value){
		this.onmousemove = value;
	}

	public void setOnmouseout(String value){
		this.onmouseout = value;
	}

	public void setOnmouseover(String value){
		this.onmouseover = value;
	}

	public void setOnmouseup(String value){
		this.onmouseup = value;
	}

	public void setReadonly(String value){
		this.readonly = value;
	}

	public void setSize(String value){
		this.size = value;
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setTabindex(String value){
		this.tabindex = value;
	}

	public void setTitle(String value){
		this.title = value;
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