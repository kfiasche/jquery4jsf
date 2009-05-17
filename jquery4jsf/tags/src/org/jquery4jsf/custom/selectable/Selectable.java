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
package org.jquery4jsf.custom.selectable;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;

public class Selectable extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlSelectable";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Selectable";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.SelectableRenderer";

	private String[] resources;
	private String _for;
	private Boolean autoRefresh;
	private String cancel;
	private Integer delay;
	private Integer distance;
	private String filter;
	private String tolerance;
	private String onselected;
	private String onselecting;
	private String onstart;
	private String stop;
	private String onunselected;
	private String onunselecting;

	public Selectable() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"ui/ui.selectable.js",
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

	public boolean isAutoRefresh() {
		if(autoRefresh != null )
			return autoRefresh.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(autoRefresh, "autoRefresh");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setAutoRefresh(boolean autoRefresh) {
		this.autoRefresh = new Boolean(autoRefresh);
	}

	public String getCancel() {
		if(cancel != null )
			return cancel;

		String oValue = (String) getLocalOrValueBindingValue(cancel, "cancel");
		return oValue != null ? oValue : null;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
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

	public int getDistance() {
		if(distance != null )
			return distance.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(distance, "distance");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setDistance(int distance) {
		this.distance = new Integer(distance);
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

	public String getTolerance() {
		if(tolerance != null )
			return tolerance;

		String oValue = (String) getLocalOrValueBindingValue(tolerance, "tolerance");
		return oValue != null ? oValue : null;
	}
	public void setTolerance(String tolerance) {
		this.tolerance = tolerance;
	}

	public String getOnselected() {
		if(onselected != null )
			return onselected;

		String oValue = (String) getLocalOrValueBindingValue(onselected, "onselected");
		return oValue != null ? oValue : null;
	}
	public void setOnselected(String onselected) {
		this.onselected = onselected;
	}

	public String getOnselecting() {
		if(onselecting != null )
			return onselecting;

		String oValue = (String) getLocalOrValueBindingValue(onselecting, "onselecting");
		return oValue != null ? oValue : null;
	}
	public void setOnselecting(String onselecting) {
		this.onselecting = onselecting;
	}

	public String getOnstart() {
		if(onstart != null )
			return onstart;

		String oValue = (String) getLocalOrValueBindingValue(onstart, "onstart");
		return oValue != null ? oValue : null;
	}
	public void setOnstart(String onstart) {
		this.onstart = onstart;
	}

	public String getStop() {
		if(stop != null )
			return stop;

		String oValue = (String) getLocalOrValueBindingValue(stop, "stop");
		return oValue != null ? oValue : null;
	}
	public void setStop(String stop) {
		this.stop = stop;
	}

	public String getOnunselected() {
		if(onunselected != null )
			return onunselected;

		String oValue = (String) getLocalOrValueBindingValue(onunselected, "onunselected");
		return oValue != null ? oValue : null;
	}
	public void setOnunselected(String onunselected) {
		this.onunselected = onunselected;
	}

	public String getOnunselecting() {
		if(onunselecting != null )
			return onunselecting;

		String oValue = (String) getLocalOrValueBindingValue(onunselecting, "onunselecting");
		return oValue != null ? oValue : null;
	}
	public void setOnunselecting(String onunselecting) {
		this.onunselecting = onunselecting;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[14];
		values[0] = super.saveState(context);
		values[1] = _for;
		values[2] = autoRefresh;
		values[3] = cancel;
		values[4] = delay;
		values[5] = distance;
		values[6] = filter;
		values[7] = tolerance;
		values[8] = onselected;
		values[9] = onselecting;
		values[10] = onstart;
		values[11] = stop;
		values[12] = onunselected;
		values[13] = onunselecting;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.autoRefresh = (Boolean) values[2];
		this.cancel = (String) values[3];
		this.delay = (Integer) values[4];
		this.distance = (Integer) values[5];
		this.filter = (String) values[6];
		this.tolerance = (String) values[7];
		this.onselected = (String) values[8];
		this.onselecting = (String) values[9];
		this.onstart = (String) values[10];
		this.stop = (String) values[11];
		this.onunselected = (String) values[12];
		this.onunselecting = (String) values[13];
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