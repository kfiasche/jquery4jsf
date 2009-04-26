/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
/*
 *
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
package org.jquery4jsf.custom.resizable;

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

public class Resizable extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlResizable";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Resizable";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.ResizableRenderer";

	private String[] resources;
	private String _for;
	private String alsoResize;
	private String animateDuration;
	private String animateEasing;
	private String aspectRatio;
	private Boolean autoHide;
	private String cancel;
	private String containment;
	private Integer delay;
	private Integer distance;
	private Boolean ghost;
	private String grid;
	private String handles;
	private String helper;
	private Integer maxHeight;
	private Integer maxWidth;
	private Integer minWidth;
	private Integer minHeight;
	private String onstart;
	private String onresize;
	private String onstop;

	public Resizable() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"ui/ui.resizable.js",
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

	public String getAlsoResize() {
		if(alsoResize != null )
			return alsoResize;

		String oValue = (String) getLocalOrValueBindingValue(alsoResize, "alsoResize");
		return oValue != null ? oValue : null;
	}
	public void setAlsoResize(String alsoResize) {
		this.alsoResize = alsoResize;
	}

	public String getAnimateDuration() {
		if(animateDuration != null )
			return animateDuration;

		String oValue = (String) getLocalOrValueBindingValue(animateDuration, "animateDuration");
		return oValue != null ? oValue : null;
	}
	public void setAnimateDuration(String animateDuration) {
		this.animateDuration = animateDuration;
	}

	public String getAnimateEasing() {
		if(animateEasing != null )
			return animateEasing;

		String oValue = (String) getLocalOrValueBindingValue(animateEasing, "animateEasing");
		return oValue != null ? oValue : null;
	}
	public void setAnimateEasing(String animateEasing) {
		this.animateEasing = animateEasing;
	}

	public String getAspectRatio() {
		if(aspectRatio != null )
			return aspectRatio;

		String oValue = (String) getLocalOrValueBindingValue(aspectRatio, "aspectRatio");
		return oValue != null ? oValue : null;
	}
	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public boolean isAutoHide() {
		if(autoHide != null )
			return autoHide.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(autoHide, "autoHide");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAutoHide(boolean autoHide) {
		this.autoHide = new Boolean(autoHide);
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

	public String getContainment() {
		if(containment != null )
			return containment;

		String oValue = (String) getLocalOrValueBindingValue(containment, "containment");
		return oValue != null ? oValue : null;
	}
	public void setContainment(String containment) {
		this.containment = containment;
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

	public boolean isGhost() {
		if(ghost != null )
			return ghost.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(ghost, "ghost");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setGhost(boolean ghost) {
		this.ghost = new Boolean(ghost);
	}

	public String getGrid() {
		if(grid != null )
			return grid;

		String oValue = (String) getLocalOrValueBindingValue(grid, "grid");
		return oValue != null ? oValue : null;
	}
	public void setGrid(String grid) {
		this.grid = grid;
	}

	public String getHandles() {
		if(handles != null )
			return handles;

		String oValue = (String) getLocalOrValueBindingValue(handles, "handles");
		return oValue != null ? oValue : null;
	}
	public void setHandles(String handles) {
		this.handles = handles;
	}

	public String getHelper() {
		if(helper != null )
			return helper;

		String oValue = (String) getLocalOrValueBindingValue(helper, "helper");
		return oValue != null ? oValue : null;
	}
	public void setHelper(String helper) {
		this.helper = helper;
	}

	public int getMaxHeight() {
		if(maxHeight != null )
			return maxHeight.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(maxHeight, "maxHeight");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = new Integer(maxHeight);
	}

	public int getMaxWidth() {
		if(maxWidth != null )
			return maxWidth.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(maxWidth, "maxWidth");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMaxWidth(int maxWidth) {
		this.maxWidth = new Integer(maxWidth);
	}

	public int getMinWidth() {
		if(minWidth != null )
			return minWidth.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(minWidth, "minWidth");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMinWidth(int minWidth) {
		this.minWidth = new Integer(minWidth);
	}

	public int getMinHeight() {
		if(minHeight != null )
			return minHeight.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(minHeight, "minHeight");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setMinHeight(int minHeight) {
		this.minHeight = new Integer(minHeight);
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

	public String getOnresize() {
		if(onresize != null )
			return onresize;

		String oValue = (String) getLocalOrValueBindingValue(onresize, "onresize");
		return oValue != null ? oValue : null;
	}
	public void setOnresize(String onresize) {
		this.onresize = onresize;
	}

	public String getOnstop() {
		if(onstop != null )
			return onstop;

		String oValue = (String) getLocalOrValueBindingValue(onstop, "onstop");
		return oValue != null ? oValue : null;
	}
	public void setOnstop(String onstop) {
		this.onstop = onstop;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[22];
		values[0] = super.saveState(context);
		values[1] = _for;
		values[2] = alsoResize;
		values[3] = animateDuration;
		values[4] = animateEasing;
		values[5] = aspectRatio;
		values[6] = autoHide;
		values[7] = cancel;
		values[8] = containment;
		values[9] = delay;
		values[10] = distance;
		values[11] = ghost;
		values[12] = grid;
		values[13] = handles;
		values[14] = helper;
		values[15] = maxHeight;
		values[16] = maxWidth;
		values[17] = minWidth;
		values[18] = minHeight;
		values[19] = onstart;
		values[20] = onresize;
		values[21] = onstop;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.alsoResize = (String) values[2];
		this.animateDuration = (String) values[3];
		this.animateEasing = (String) values[4];
		this.aspectRatio = (String) values[5];
		this.autoHide = (Boolean) values[6];
		this.cancel = (String) values[7];
		this.containment = (String) values[8];
		this.delay = (Integer) values[9];
		this.distance = (Integer) values[10];
		this.ghost = (Boolean) values[11];
		this.grid = (String) values[12];
		this.handles = (String) values[13];
		this.helper = (String) values[14];
		this.maxHeight = (Integer) values[15];
		this.maxWidth = (Integer) values[16];
		this.minWidth = (Integer) values[17];
		this.minHeight = (Integer) values[18];
		this.onstart = (String) values[19];
		this.onresize = (String) values[20];
		this.onstop = (String) values[21];
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