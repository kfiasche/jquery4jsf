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

import org.jquery4jsf.component.ext.HtmlBaseInputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Integer;

public class HtmlQuickSearch extends HtmlBaseInputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlQuickSearch";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.QuickSearch";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.HtmlQuickSearchRenderer";

	private String[] resources;
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
	private Integer delay;
	private Boolean focusOnLoad;
	private String hideElement;
	private String onBefore;
	private String onAfter;
	private String filter;
	private String randomElement;
	private Boolean isFieldset;
	private Boolean fixWidths;

	public HtmlQuickSearch() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"quicksearch/jquery.quicksearch.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getTarget() {
		if(target != null )
			return target;

		String oValue = (String) getLocalOrValueBindingValue(target, "target");
		return oValue != null ? oValue : null;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public String getPosition() {
		if(position != null )
			return position;

		String oValue = (String) getLocalOrValueBindingValue(position, "position");
		return oValue != null ? oValue : null;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getAttached() {
		if(attached != null )
			return attached;

		String oValue = (String) getLocalOrValueBindingValue(attached, "attached");
		return oValue != null ? oValue : null;
	}
	public void setAttached(String attached) {
		this.attached = attached;
	}

	public String getFormId() {
		if(formId != null )
			return formId;

		String oValue = (String) getLocalOrValueBindingValue(formId, "formId");
		return oValue != null ? oValue : null;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getLabelText() {
		if(labelText != null )
			return labelText;

		String oValue = (String) getLocalOrValueBindingValue(labelText, "labelText");
		return oValue != null ? oValue : null;
	}
	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	public String getLabelClass() {
		if(labelClass != null )
			return labelClass;

		String oValue = (String) getLocalOrValueBindingValue(labelClass, "labelClass");
		return oValue != null ? oValue : null;
	}
	public void setLabelClass(String labelClass) {
		this.labelClass = labelClass;
	}

	public String getInputText() {
		if(inputText != null )
			return inputText;

		String oValue = (String) getLocalOrValueBindingValue(inputText, "inputText");
		return oValue != null ? oValue : null;
	}
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public String getInputClass() {
		if(inputClass != null )
			return inputClass;

		String oValue = (String) getLocalOrValueBindingValue(inputClass, "inputClass");
		return oValue != null ? oValue : null;
	}
	public void setInputClass(String inputClass) {
		this.inputClass = inputClass;
	}

	public String getLoaderId() {
		if(loaderId != null )
			return loaderId;

		String oValue = (String) getLocalOrValueBindingValue(loaderId, "loaderId");
		return oValue != null ? oValue : null;
	}
	public void setLoaderId(String loaderId) {
		this.loaderId = loaderId;
	}

	public String getLoaderClass() {
		if(loaderClass != null )
			return loaderClass;

		String oValue = (String) getLocalOrValueBindingValue(loaderClass, "loaderClass");
		return oValue != null ? oValue : null;
	}
	public void setLoaderClass(String loaderClass) {
		this.loaderClass = loaderClass;
	}

	public String getLoaderImg() {
		if(loaderImg != null )
			return loaderImg;

		String oValue = (String) getLocalOrValueBindingValue(loaderImg, "loaderImg");
		return oValue != null ? oValue : null;
	}
	public void setLoaderImg(String loaderImg) {
		this.loaderImg = loaderImg;
	}

	public String getLoaderText() {
		if(loaderText != null )
			return loaderText;

		String oValue = (String) getLocalOrValueBindingValue(loaderText, "loaderText");
		return oValue != null ? oValue : null;
	}
	public void setLoaderText(String loaderText) {
		this.loaderText = loaderText;
	}

	public String getStripeRowClass() {
		if(stripeRowClass != null )
			return stripeRowClass;

		String oValue = (String) getLocalOrValueBindingValue(stripeRowClass, "stripeRowClass");
		return oValue != null ? oValue : null;
	}
	public void setStripeRowClass(String stripeRowClass) {
		this.stripeRowClass = stripeRowClass;
	}

	public int getDelay() {
		if(delay != null )
			return delay.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(delay, "delay");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setDelay(int delay) {
		this.delay = new Integer(delay);
	}

	public boolean isFocusOnLoad() {
		if(focusOnLoad != null )
			return focusOnLoad.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(focusOnLoad, "focusOnLoad");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setFocusOnLoad(boolean focusOnLoad) {
		this.focusOnLoad = new Boolean(focusOnLoad);
	}

	public String getHideElement() {
		if(hideElement != null )
			return hideElement;

		String oValue = (String) getLocalOrValueBindingValue(hideElement, "hideElement");
		return oValue != null ? oValue : null;
	}
	public void setHideElement(String hideElement) {
		this.hideElement = hideElement;
	}

	public String getOnBefore() {
		if(onBefore != null )
			return onBefore;

		String oValue = (String) getLocalOrValueBindingValue(onBefore, "onBefore");
		return oValue != null ? oValue : null;
	}
	public void setOnBefore(String onBefore) {
		this.onBefore = onBefore;
	}

	public String getOnAfter() {
		if(onAfter != null )
			return onAfter;

		String oValue = (String) getLocalOrValueBindingValue(onAfter, "onAfter");
		return oValue != null ? oValue : null;
	}
	public void setOnAfter(String onAfter) {
		this.onAfter = onAfter;
	}

	public String getFilter() {
		if(filter != null )
			return filter;

		String oValue = (String) getLocalOrValueBindingValue(filter, "filter");
		return oValue != null ? oValue : null;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getRandomElement() {
		if(randomElement != null )
			return randomElement;

		String oValue = (String) getLocalOrValueBindingValue(randomElement, "randomElement");
		return oValue != null ? oValue : null;
	}
	public void setRandomElement(String randomElement) {
		this.randomElement = randomElement;
	}

	public boolean isIsFieldset() {
		if(isFieldset != null )
			return isFieldset.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(isFieldset, "isFieldset");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setIsFieldset(boolean isFieldset) {
		this.isFieldset = new Boolean(isFieldset);
	}

	public boolean isFixWidths() {
		if(fixWidths != null )
			return fixWidths.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(fixWidths, "fixWidths");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setFixWidths(boolean fixWidths) {
		this.fixWidths = new Boolean(fixWidths);
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[23];
		values[0] = super.saveState(context);
		values[1] = target;
		values[2] = position;
		values[3] = attached;
		values[4] = formId;
		values[5] = labelText;
		values[6] = labelClass;
		values[7] = inputText;
		values[8] = inputClass;
		values[9] = loaderId;
		values[10] = loaderClass;
		values[11] = loaderImg;
		values[12] = loaderText;
		values[13] = stripeRowClass;
		values[14] = delay;
		values[15] = focusOnLoad;
		values[16] = hideElement;
		values[17] = onBefore;
		values[18] = onAfter;
		values[19] = filter;
		values[20] = randomElement;
		values[21] = isFieldset;
		values[22] = fixWidths;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.target = (String) values[1];
		this.position = (String) values[2];
		this.attached = (String) values[3];
		this.formId = (String) values[4];
		this.labelText = (String) values[5];
		this.labelClass = (String) values[6];
		this.inputText = (String) values[7];
		this.inputClass = (String) values[8];
		this.loaderId = (String) values[9];
		this.loaderClass = (String) values[10];
		this.loaderImg = (String) values[11];
		this.loaderText = (String) values[12];
		this.stripeRowClass = (String) values[13];
		this.delay = (Integer) values[14];
		this.focusOnLoad = (Boolean) values[15];
		this.hideElement = (String) values[16];
		this.onBefore = (String) values[17];
		this.onAfter = (String) values[18];
		this.filter = (String) values[19];
		this.randomElement = (String) values[20];
		this.isFieldset = (Boolean) values[21];
		this.fixWidths = (Boolean) values[22];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}