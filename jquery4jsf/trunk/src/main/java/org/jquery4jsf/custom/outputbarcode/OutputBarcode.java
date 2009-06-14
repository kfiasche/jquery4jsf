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
package org.jquery4jsf.custom.outputbarcode;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;

public class OutputBarcode extends UIComponentBase implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputBarcode";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.OutputBarcode";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.OutputBarcodeRenderer";

	private String[] resources;
	private Integer barWidth;
	private Integer barHeight;
	private Boolean showHRI;
	private String bgColor;
	private String color;
	private String fontSize;
	private String type;
	private Object value;

	public OutputBarcode() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"barcode/jquery-barcode-1.1.js"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public int getBarWidth() {
		if(barWidth != null )
			return barWidth.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(barWidth, "barWidth");
		return oValue != null ? oValue.intValue()  : 1;
	}
	public void setBarWidth(int barWidth) {
		this.barWidth = new Integer(barWidth);
	}

	public int getBarHeight() {
		if(barHeight != null )
			return barHeight.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(barHeight, "barHeight");
		return oValue != null ? oValue.intValue()  : 50;
	}
	public void setBarHeight(int barHeight) {
		this.barHeight = new Integer(barHeight);
	}

	public boolean isShowHRI() {
		if(showHRI != null )
			return showHRI.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(showHRI, "showHRI");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setShowHRI(boolean showHRI) {
		this.showHRI = new Boolean(showHRI);
	}

	public String getBgColor() {
		if(bgColor != null )
			return bgColor;

		String oValue = (String) getLocalOrValueBindingValue(bgColor, "bgColor");
		return oValue != null ? oValue : null;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getColor() {
		if(color != null )
			return color;

		String oValue = (String) getLocalOrValueBindingValue(color, "color");
		return oValue != null ? oValue : null;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getFontSize() {
		if(fontSize != null )
			return fontSize;

		String oValue = (String) getLocalOrValueBindingValue(fontSize, "fontSize");
		return oValue != null ? oValue : null;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public String getType() {
		if(type != null )
			return type;

		String oValue = (String) getLocalOrValueBindingValue(type, "type");
		return oValue != null ? oValue : null;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Object getValue() {
		if(value != null )
			return value;

		Object oValue = getLocalOrValueBindingValue(value, "value");
		return oValue != null ? oValue : null;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[9];
		values[0] = super.saveState(context);
		values[1] = barWidth;
		values[2] = barHeight;
		values[3] = showHRI;
		values[4] = bgColor;
		values[5] = color;
		values[6] = fontSize;
		values[7] = type;
		values[8] = value;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.barWidth = (Integer) values[1];
		this.barHeight = (Integer) values[2];
		this.showHRI = (Boolean) values[3];
		this.bgColor = (String) values[4];
		this.color = (String) values[5];
		this.fontSize = (String) values[6];
		this.type = (String) values[7];
		this.value = values[8];
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