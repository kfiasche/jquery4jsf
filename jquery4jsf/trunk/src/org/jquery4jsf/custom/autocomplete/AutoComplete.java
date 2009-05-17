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

import org.jquery4jsf.component.ext.HtmlInputText;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Integer;

public class AutoComplete extends HtmlInputText implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlAutoComplete";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.AutoComplete";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.AutoCompleteRenderer";

	private String[] resources;
	private String jsonValue;
	private Integer minChars;
	private Integer delay;
	private Integer cacheLength;
	private Boolean matchSubset;
	private Boolean matchCase;
	private Boolean matchContains;
	private Boolean mustMatch;
	private Boolean selectFirst;
	private String extraParams;
	private Boolean multiple;
	private String multipleSeparator;
	private Integer width;
	private Boolean autoFill;
	private Integer max;
	private String highlight;
	private Boolean scroll;
	private Integer scrollHeight;
	private String onformatItem;
	private String onformatMatch;
	private String onformatResult;
	private MethodBinding oncomplete;

	public AutoComplete() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getJsonValue() {
		if(jsonValue != null )
			return jsonValue;

		String oValue = (String) getLocalOrValueBindingValue(jsonValue, "jsonValue");
		return oValue != null ? oValue : null;
	}
	public void setJsonValue(String jsonValue) {
		this.jsonValue = jsonValue;
	}

	public int getMinChars() {
		if(minChars != null )
			return minChars.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(minChars, "minChars");
		return oValue != null ? oValue.intValue()  : 1;
	}
	public void setMinChars(int minChars) {
		this.minChars = new Integer(minChars);
	}

	public int getDelay() {
		if(delay != null )
			return delay.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(delay, "delay");
		return oValue != null ? oValue.intValue()  : 400;
	}
	public void setDelay(int delay) {
		this.delay = new Integer(delay);
	}

	public int getCacheLength() {
		if(cacheLength != null )
			return cacheLength.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(cacheLength, "cacheLength");
		return oValue != null ? oValue.intValue()  : 10;
	}
	public void setCacheLength(int cacheLength) {
		this.cacheLength = new Integer(cacheLength);
	}

	public boolean isMatchSubset() {
		if(matchSubset != null )
			return matchSubset.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(matchSubset, "matchSubset");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setMatchSubset(boolean matchSubset) {
		this.matchSubset = new Boolean(matchSubset);
	}

	public boolean isMatchCase() {
		if(matchCase != null )
			return matchCase.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(matchCase, "matchCase");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setMatchCase(boolean matchCase) {
		this.matchCase = new Boolean(matchCase);
	}

	public boolean isMatchContains() {
		if(matchContains != null )
			return matchContains.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(matchContains, "matchContains");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setMatchContains(boolean matchContains) {
		this.matchContains = new Boolean(matchContains);
	}

	public boolean isMustMatch() {
		if(mustMatch != null )
			return mustMatch.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(mustMatch, "mustMatch");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setMustMatch(boolean mustMatch) {
		this.mustMatch = new Boolean(mustMatch);
	}

	public boolean isSelectFirst() {
		if(selectFirst != null )
			return selectFirst.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(selectFirst, "selectFirst");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setSelectFirst(boolean selectFirst) {
		this.selectFirst = new Boolean(selectFirst);
	}

	public String getExtraParams() {
		if(extraParams != null )
			return extraParams;

		String oValue = (String) getLocalOrValueBindingValue(extraParams, "extraParams");
		return oValue != null ? oValue : null;
	}
	public void setExtraParams(String extraParams) {
		this.extraParams = extraParams;
	}

	public boolean isMultiple() {
		if(multiple != null )
			return multiple.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(multiple, "multiple");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setMultiple(boolean multiple) {
		this.multiple = new Boolean(multiple);
	}

	public String getMultipleSeparator() {
		if(multipleSeparator != null )
			return multipleSeparator;

		String oValue = (String) getLocalOrValueBindingValue(multipleSeparator, "multipleSeparator");
		return oValue != null ? oValue : null;
	}
	public void setMultipleSeparator(String multipleSeparator) {
		this.multipleSeparator = multipleSeparator;
	}

	public int getWidth() {
		if(width != null )
			return width.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(width, "width");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setWidth(int width) {
		this.width = new Integer(width);
	}

	public boolean isAutoFill() {
		if(autoFill != null )
			return autoFill.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(autoFill, "autoFill");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAutoFill(boolean autoFill) {
		this.autoFill = new Boolean(autoFill);
	}

	public int getMax() {
		if(max != null )
			return max.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(max, "max");
		return oValue != null ? oValue.intValue()  : 10;
	}
	public void setMax(int max) {
		this.max = new Integer(max);
	}

	public String getHighlight() {
		if(highlight != null )
			return highlight;

		String oValue = (String) getLocalOrValueBindingValue(highlight, "highlight");
		return oValue != null ? oValue : null;
	}
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public boolean isScroll() {
		if(scroll != null )
			return scroll.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(scroll, "scroll");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setScroll(boolean scroll) {
		this.scroll = new Boolean(scroll);
	}

	public int getScrollHeight() {
		if(scrollHeight != null )
			return scrollHeight.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(scrollHeight, "scrollHeight");
		return oValue != null ? oValue.intValue()  : 180;
	}
	public void setScrollHeight(int scrollHeight) {
		this.scrollHeight = new Integer(scrollHeight);
	}

	public String getOnformatItem() {
		if(onformatItem != null )
			return onformatItem;

		String oValue = (String) getLocalOrValueBindingValue(onformatItem, "onformatItem");
		return oValue != null ? oValue : null;
	}
	public void setOnformatItem(String onformatItem) {
		this.onformatItem = onformatItem;
	}

	public String getOnformatMatch() {
		if(onformatMatch != null )
			return onformatMatch;

		String oValue = (String) getLocalOrValueBindingValue(onformatMatch, "onformatMatch");
		return oValue != null ? oValue : null;
	}
	public void setOnformatMatch(String onformatMatch) {
		this.onformatMatch = onformatMatch;
	}

	public String getOnformatResult() {
		if(onformatResult != null )
			return onformatResult;

		String oValue = (String) getLocalOrValueBindingValue(onformatResult, "onformatResult");
		return oValue != null ? oValue : null;
	}
	public void setOnformatResult(String onformatResult) {
		this.onformatResult = onformatResult;
	}

	public MethodBinding getOncomplete() {
		if(oncomplete != null )
			return oncomplete;

		MethodBinding oValue = (MethodBinding) getLocalOrValueBindingValue(oncomplete, "oncomplete");
		return oValue != null ? oValue : null;
	}
	public void setOncomplete(MethodBinding oncomplete) {
		this.oncomplete = oncomplete;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[23];
		values[0] = super.saveState(context);
		values[1] = jsonValue;
		values[2] = minChars;
		values[3] = delay;
		values[4] = cacheLength;
		values[5] = matchSubset;
		values[6] = matchCase;
		values[7] = matchContains;
		values[8] = mustMatch;
		values[9] = selectFirst;
		values[10] = extraParams;
		values[11] = multiple;
		values[12] = multipleSeparator;
		values[13] = width;
		values[14] = autoFill;
		values[15] = max;
		values[16] = highlight;
		values[17] = scroll;
		values[18] = scrollHeight;
		values[19] = onformatItem;
		values[20] = onformatMatch;
		values[21] = onformatResult;
		values[22] = saveAttachedState(context, oncomplete);
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.jsonValue = (String) values[1];
		this.minChars = (Integer) values[2];
		this.delay = (Integer) values[3];
		this.cacheLength = (Integer) values[4];
		this.matchSubset = (Boolean) values[5];
		this.matchCase = (Boolean) values[6];
		this.matchContains = (Boolean) values[7];
		this.mustMatch = (Boolean) values[8];
		this.selectFirst = (Boolean) values[9];
		this.extraParams = (String) values[10];
		this.multiple = (Boolean) values[11];
		this.multipleSeparator = (String) values[12];
		this.width = (Integer) values[13];
		this.autoFill = (Boolean) values[14];
		this.max = (Integer) values[15];
		this.highlight = (String) values[16];
		this.scroll = (Boolean) values[17];
		this.scrollHeight = (Integer) values[18];
		this.onformatItem = (String) values[19];
		this.onformatMatch = (String) values[20];
		this.onformatResult = (String) values[21];
		this.oncomplete = (MethodBinding) restoreAttachedState(context, values[22]);
	}

	public String[] getResources() {
		return resources;
	}

	protected Object getLocalOrValueBindingValue(Object localValue, String valueBindingName)
	{
		if (localValue != null)
			return localValue;
		ValueBinding vb = getValueBinding(valueBindingName);
		return vb != null ? vb.getValue(getFacesContext()) : null;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}