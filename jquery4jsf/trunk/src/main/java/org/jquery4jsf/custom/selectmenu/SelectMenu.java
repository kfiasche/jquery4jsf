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
package org.jquery4jsf.custom.selectmenu;

import org.jquery4jsf.component.ext.HtmlBaseSelectOneComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.custom.UIInteractions;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;

public class SelectMenu extends HtmlBaseSelectOneComponent implements JQueryHtmlObject,UIInteractions {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlSelectMenu";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.SelectMenu";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.SelectMenuRenderer";

	private String[] resources;
	private String _for;
	private String transferClasses;
	private String styleType;
	private Integer width;
	private Integer menuWidth;
	private Integer handleWidth;
	private String icons;
	private String format;
	private String onopen;
	private String onclose;
	private String onchange;
	private String onselect;

	public SelectMenu() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"ui/ui.core.js",
			"selectmenu/ui.selectmenu.js",
			"selectmenu/ui.selectmenu.css",
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

	public String getTransferClasses() {
		if(transferClasses != null )
			return transferClasses;

		String oValue = (String) getLocalOrValueBindingValue(transferClasses, "transferClasses");
		return oValue != null ? oValue : null;
	}
	public void setTransferClasses(String transferClasses) {
		this.transferClasses = transferClasses;
	}

	public String getStyleType() {
		if(styleType != null )
			return styleType;

		String oValue = (String) getLocalOrValueBindingValue(styleType, "styleType");
		return oValue != null ? oValue : null;
	}
	public void setStyleType(String styleType) {
		this.styleType = styleType;
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

	public int getMenuWidth() {
		if(menuWidth != null )
			return menuWidth.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(menuWidth, "menuWidth");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMenuWidth(int menuWidth) {
		this.menuWidth = new Integer(menuWidth);
	}

	public int getHandleWidth() {
		if(handleWidth != null )
			return handleWidth.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(handleWidth, "handleWidth");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setHandleWidth(int handleWidth) {
		this.handleWidth = new Integer(handleWidth);
	}

	public String getIcons() {
		if(icons != null )
			return icons;

		String oValue = (String) getLocalOrValueBindingValue(icons, "icons");
		return oValue != null ? oValue : null;
	}
	public void setIcons(String icons) {
		this.icons = icons;
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

	public String getOnopen() {
		if(onopen != null )
			return onopen;

		String oValue = (String) getLocalOrValueBindingValue(onopen, "onopen");
		return oValue != null ? oValue : null;
	}
	public void setOnopen(String onopen) {
		this.onopen = onopen;
	}

	public String getOnclose() {
		if(onclose != null )
			return onclose;

		String oValue = (String) getLocalOrValueBindingValue(onclose, "onclose");
		return oValue != null ? oValue : null;
	}
	public void setOnclose(String onclose) {
		this.onclose = onclose;
	}

	public String getOnchange() {
		if(onchange != null )
			return onchange;

		String oValue = (String) getLocalOrValueBindingValue(onchange, "onchange");
		return oValue != null ? oValue : null;
	}
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnselect() {
		if(onselect != null )
			return onselect;

		String oValue = (String) getLocalOrValueBindingValue(onselect, "onselect");
		return oValue != null ? oValue : null;
	}
	public void setOnselect(String onselect) {
		this.onselect = onselect;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[13];
		values[0] = super.saveState(context);
		values[1] = this._for;
		values[2] = this.transferClasses;
		values[3] = this.styleType;
		values[4] = this.width;
		values[5] = this.menuWidth;
		values[6] = this.handleWidth;
		values[7] = this.icons;
		values[8] = this.format;
		values[9] = this.onopen;
		values[10] = this.onclose;
		values[11] = this.onchange;
		values[12] = this.onselect;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.transferClasses = (String) values[2];
		this.styleType = (String) values[3];
		this.width = (Integer) values[4];
		this.menuWidth = (Integer) values[5];
		this.handleWidth = (Integer) values[6];
		this.icons = (String) values[7];
		this.format = (String) values[8];
		this.onopen = (String) values[9];
		this.onclose = (String) values[10];
		this.onchange = (String) values[11];
		this.onselect = (String) values[12];
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

	public void encodeScript(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof org.jquery4jsf.renderkit.JQueryRenderer) {
			((org.jquery4jsf.renderkit.JQueryRenderer)renderer).encodeScript(facesContext, this);
		}
	}
}