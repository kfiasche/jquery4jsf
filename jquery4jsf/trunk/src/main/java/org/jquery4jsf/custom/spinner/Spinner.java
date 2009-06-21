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
package org.jquery4jsf.custom.spinner;

import org.jquery4jsf.component.ext.HtmlInputText;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.custom.UIInteractions;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Object;
import javax.faces.convert.Converter;
import javax.faces.validator.Validator;
import javax.faces.event.ValueChangeListener;
import java.lang.Integer;

public class Spinner extends HtmlInputText implements JQueryHtmlObject,AjaxComponent,UIInteractions {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlSpinner";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Spinner";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.SpinnerRenderer";

	private String[] resources;
	private String _for;
	private String syncWith;
	private String step;
	private Boolean currency;
	private String format;
	private String groupSeparator;
	private String hide;
	private Boolean incremental;
	private Integer max;
	private Integer min;
	private Boolean mouseWheel;
	private Integer padLength;
	private Integer page;
	private Integer precision;
	private Integer radix;
	private String radixPoint;
	private String readOnly;
	private String spinnerClass;
	private Integer width;

	public Spinner() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"spinner/ui.spinner.js",
			"spinner/ui.spinner.sync.js",
			"external/jquery.mousewheel.js",
			"spinner/ui.spinner.css",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getFor() {
		if( _for != null )
			return _for;

		String oValue = (String) getLocalOrValueBindingValue( _for, "for");
		return oValue != null ? oValue : null;
	}
	public void setFor(String _for) {
		this._for = _for;
	}

	public String getSyncWith() {
		if(syncWith != null )
			return syncWith;

		String oValue = (String) getLocalOrValueBindingValue(syncWith, "syncWith");
		return oValue != null ? oValue : null;
	}
	public void setSyncWith(String syncWith) {
		this.syncWith = syncWith;
	}

	public String getStep() {
		if(step != null )
			return step;

		String oValue = (String) getLocalOrValueBindingValue(step, "step");
		return oValue != null ? oValue : null;
	}
	public void setStep(String step) {
		this.step = step;
	}

	public boolean isCurrency() {
		if(currency != null )
			return currency.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(currency, "currency");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setCurrency(boolean currency) {
		this.currency = new Boolean(currency);
	}

	public String getFormat() {
		if(format != null )
			return format;

		String oValue = (String) getLocalOrValueBindingValue(format, "format");
		return oValue != null ? oValue : null;
	}
	public void setFormat(String format) {
		this.format = format;
	}

	public String getGroupSeparator() {
		if(groupSeparator != null )
			return groupSeparator;

		String oValue = (String) getLocalOrValueBindingValue(groupSeparator, "groupSeparator");
		return oValue != null ? oValue : null;
	}
	public void setGroupSeparator(String groupSeparator) {
		this.groupSeparator = groupSeparator;
	}

	public String getHide() {
		if(hide != null )
			return hide;

		String oValue = (String) getLocalOrValueBindingValue(hide, "hide");
		return oValue != null ? oValue : null;
	}
	public void setHide(String hide) {
		this.hide = hide;
	}

	public boolean isIncremental() {
		if(incremental != null )
			return incremental.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(incremental, "incremental");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setIncremental(boolean incremental) {
		this.incremental = new Boolean(incremental);
	}

	public int getMax() {
		if(max != null )
			return max.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(max, "max");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMax(int max) {
		this.max = new Integer(max);
	}

	public int getMin() {
		if(min != null )
			return min.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(min, "min");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMin(int min) {
		this.min = new Integer(min);
	}

	public boolean isMouseWheel() {
		if(mouseWheel != null )
			return mouseWheel.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(mouseWheel, "mouseWheel");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setMouseWheel(boolean mouseWheel) {
		this.mouseWheel = new Boolean(mouseWheel);
	}

	public int getPadLength() {
		if(padLength != null )
			return padLength.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(padLength, "padLength");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setPadLength(int padLength) {
		this.padLength = new Integer(padLength);
	}

	public int getPage() {
		if(page != null )
			return page.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(page, "page");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setPage(int page) {
		this.page = new Integer(page);
	}

	public int getPrecision() {
		if(precision != null )
			return precision.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(precision, "precision");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setPrecision(int precision) {
		this.precision = new Integer(precision);
	}

	public int getRadix() {
		if(radix != null )
			return radix.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(radix, "radix");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setRadix(int radix) {
		this.radix = new Integer(radix);
	}

	public String getRadixPoint() {
		if(radixPoint != null )
			return radixPoint;

		String oValue = (String) getLocalOrValueBindingValue(radixPoint, "radixPoint");
		return oValue != null ? oValue : null;
	}
	public void setRadixPoint(String radixPoint) {
		this.radixPoint = radixPoint;
	}

	public String getReadOnly() {
		if(readOnly != null )
			return readOnly;

		String oValue = (String) getLocalOrValueBindingValue(readOnly, "readOnly");
		return oValue != null ? oValue : null;
	}
	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getSpinnerClass() {
		if(spinnerClass != null )
			return spinnerClass;

		String oValue = (String) getLocalOrValueBindingValue(spinnerClass, "spinnerClass");
		return oValue != null ? oValue : null;
	}
	public void setSpinnerClass(String spinnerClass) {
		this.spinnerClass = spinnerClass;
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

	public Object saveState(FacesContext context) {
		Object values[] = new Object[20];
		values[0] = super.saveState(context);
		values[1] = _for;
		values[2] = syncWith;
		values[3] = step;
		values[4] = currency;
		values[5] = format;
		values[6] = groupSeparator;
		values[7] = hide;
		values[8] = incremental;
		values[9] = max;
		values[10] = min;
		values[11] = mouseWheel;
		values[12] = padLength;
		values[13] = page;
		values[14] = precision;
		values[15] = radix;
		values[16] = radixPoint;
		values[17] = readOnly;
		values[18] = spinnerClass;
		values[19] = width;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.syncWith = (String) values[2];
		this.step = (String) values[3];
		this.currency = (Boolean) values[4];
		this.format = (String) values[5];
		this.groupSeparator = (String) values[6];
		this.hide = (String) values[7];
		this.incremental = (Boolean) values[8];
		this.max = (Integer) values[9];
		this.min = (Integer) values[10];
		this.mouseWheel = (Boolean) values[11];
		this.padLength = (Integer) values[12];
		this.page = (Integer) values[13];
		this.precision = (Integer) values[14];
		this.radix = (Integer) values[15];
		this.radixPoint = (String) values[16];
		this.readOnly = (String) values[17];
		this.spinnerClass = (String) values[18];
		this.width = (Integer) values[19];
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