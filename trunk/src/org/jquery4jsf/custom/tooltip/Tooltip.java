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
package org.jquery4jsf.custom.tooltip;

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

public class Tooltip extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTooltip";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Tooltip";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.TooltipRenderer";

	private String[] resources;
	private Integer delay;
	private String track;
	private String showURL;
	private String showBody;
	private String onbodyHandler;
	private String extraClass;
	private Integer top;
	private String fixPNG;
	private Integer left;

	public Tooltip() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"external/jquery.bgiframe.min.js",
			"external/jquery.dimensions.js",
			"tooltip/jquery.tooltip.js",
			"tooltip/jquery.tooltip.css",
			"external/chili-1.7.pack.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
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

	public String getTrack() {
		if(track != null )
			return track;

		String oValue = (String) getLocalOrValueBindingValue(track, "track");
		return oValue != null ? oValue : null;
	}
	public void setTrack(String track) {
		this.track = track;
	}

	public String getShowURL() {
		if(showURL != null )
			return showURL;

		String oValue = (String) getLocalOrValueBindingValue(showURL, "showURL");
		return oValue != null ? oValue : null;
	}
	public void setShowURL(String showURL) {
		this.showURL = showURL;
	}

	public String getShowBody() {
		if(showBody != null )
			return showBody;

		String oValue = (String) getLocalOrValueBindingValue(showBody, "showBody");
		return oValue != null ? oValue : null;
	}
	public void setShowBody(String showBody) {
		this.showBody = showBody;
	}

	public String getOnbodyHandler() {
		if(onbodyHandler != null )
			return onbodyHandler;

		String oValue = (String) getLocalOrValueBindingValue(onbodyHandler, "onbodyHandler");
		return oValue != null ? oValue : null;
	}
	public void setOnbodyHandler(String onbodyHandler) {
		this.onbodyHandler = onbodyHandler;
	}

	public String getExtraClass() {
		if(extraClass != null )
			return extraClass;

		String oValue = (String) getLocalOrValueBindingValue(extraClass, "extraClass");
		return oValue != null ? oValue : null;
	}
	public void setExtraClass(String extraClass) {
		this.extraClass = extraClass;
	}

	public int getTop() {
		if(top != null )
			return top.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(top, "top");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setTop(int top) {
		this.top = new Integer(top);
	}

	public String getFixPNG() {
		if(fixPNG != null )
			return fixPNG;

		String oValue = (String) getLocalOrValueBindingValue(fixPNG, "fixPNG");
		return oValue != null ? oValue : null;
	}
	public void setFixPNG(String fixPNG) {
		this.fixPNG = fixPNG;
	}

	public int getLeft() {
		if(left != null )
			return left.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(left, "left");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setLeft(int left) {
		this.left = new Integer(left);
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[10];
		values[0] = super.saveState(context);
		values[1] = delay;
		values[2] = track;
		values[3] = showURL;
		values[4] = showBody;
		values[5] = onbodyHandler;
		values[6] = extraClass;
		values[7] = top;
		values[8] = fixPNG;
		values[9] = left;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.delay = (Integer) values[1];
		this.track = (String) values[2];
		this.showURL = (String) values[3];
		this.showBody = (String) values[4];
		this.onbodyHandler = (String) values[5];
		this.extraClass = (String) values[6];
		this.top = (Integer) values[7];
		this.fixPNG = (String) values[8];
		this.left = (Integer) values[9];
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