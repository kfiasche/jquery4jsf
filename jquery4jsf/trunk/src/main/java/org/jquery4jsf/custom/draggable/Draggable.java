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
package org.jquery4jsf.custom.draggable;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
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
import java.lang.Float;

public class Draggable extends HtmlBaseOutputComponent implements JQueryHtmlObject,UIInteractions {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlDraggable";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Draggable";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.DraggableRenderer";

	private String[] resources;
	private String _for;
	private Boolean addClasses;
	private String appendTo;
	private String axis;
	private String cancel;
	private String connectToSortable;
	private String containment;
	private String cursor;
	private String cursorAt;
	private Integer delay;
	private Integer distance;
	private String grid;
	private String handle;
	private String helper;
	private String iframeFix;
	private Float opacity;
	private Boolean refreshPositions;
	private String revert;
	private Integer revertDuration;
	private String scope;
	private Boolean scroll;
	private Integer scrollSensitivity;
	private Integer scrollSpeed;
	private String snap;
	private String snapMode;
	private Integer snapTolerance;
	private String stack;
	private Integer zindex;
	private String onstart;
	private String ondrag;
	private String onstop;

	public Draggable() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"jquery4jsf/ui.jquery4jsf.js",
			"ui/ui.core.js",
			"ui/ui.draggable.js",
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

	public boolean isAddClasses() {
		if(addClasses != null )
			return addClasses.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(addClasses, "addClasses");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setAddClasses(boolean addClasses) {
		this.addClasses = new Boolean(addClasses);
	}

	public String getAppendTo() {
		if(appendTo != null )
			return appendTo;

		String oValue = (String) getLocalOrValueBindingValue(appendTo, "appendTo");
		return oValue != null ? oValue : null;
	}
	public void setAppendTo(String appendTo) {
		this.appendTo = appendTo;
	}

	public String getAxis() {
		if(axis != null )
			return axis;

		String oValue = (String) getLocalOrValueBindingValue(axis, "axis");
		return oValue != null ? oValue : null;
	}
	public void setAxis(String axis) {
		this.axis = axis;
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

	public String getConnectToSortable() {
		if(connectToSortable != null )
			return connectToSortable;

		String oValue = (String) getLocalOrValueBindingValue(connectToSortable, "connectToSortable");
		return oValue != null ? oValue : null;
	}
	public void setConnectToSortable(String connectToSortable) {
		this.connectToSortable = connectToSortable;
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

	public String getCursor() {
		if(cursor != null )
			return cursor;

		String oValue = (String) getLocalOrValueBindingValue(cursor, "cursor");
		return oValue != null ? oValue : null;
	}
	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public String getCursorAt() {
		if(cursorAt != null )
			return cursorAt;

		String oValue = (String) getLocalOrValueBindingValue(cursorAt, "cursorAt");
		return oValue != null ? oValue : null;
	}
	public void setCursorAt(String cursorAt) {
		this.cursorAt = cursorAt;
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
		return oValue != null ? oValue.intValue()  : 1;
	}
	public void setDistance(int distance) {
		this.distance = new Integer(distance);
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

	public String getHandle() {
		if(handle != null )
			return handle;

		String oValue = (String) getLocalOrValueBindingValue(handle, "handle");
		return oValue != null ? oValue : null;
	}
	public void setHandle(String handle) {
		this.handle = handle;
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

	public String getIframeFix() {
		if(iframeFix != null )
			return iframeFix;

		String oValue = (String) getLocalOrValueBindingValue(iframeFix, "iframeFix");
		return oValue != null ? oValue : null;
	}
	public void setIframeFix(String iframeFix) {
		this.iframeFix = iframeFix;
	}

	public Float getOpacity() {
		if(opacity != null )
			return opacity;

		Float oValue = (Float) getLocalOrValueBindingValue(opacity, "opacity");
		return oValue != null ? oValue : null;
	}
	public void setOpacity(Float opacity) {
		this.opacity = opacity;
	}

	public boolean isRefreshPositions() {
		if(refreshPositions != null )
			return refreshPositions.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(refreshPositions, "refreshPositions");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setRefreshPositions(boolean refreshPositions) {
		this.refreshPositions = new Boolean(refreshPositions);
	}

	public String getRevert() {
		if(revert != null )
			return revert;

		String oValue = (String) getLocalOrValueBindingValue(revert, "revert");
		return oValue != null ? oValue : null;
	}
	public void setRevert(String revert) {
		this.revert = revert;
	}

	public int getRevertDuration() {
		if(revertDuration != null )
			return revertDuration.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(revertDuration, "revertDuration");
		return oValue != null ? oValue.intValue()  : 500;
	}
	public void setRevertDuration(int revertDuration) {
		this.revertDuration = new Integer(revertDuration);
	}

	public String getScope() {
		if(scope != null )
			return scope;

		String oValue = (String) getLocalOrValueBindingValue(scope, "scope");
		return oValue != null ? oValue : null;
	}
	public void setScope(String scope) {
		this.scope = scope;
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

	public int getScrollSensitivity() {
		if(scrollSensitivity != null )
			return scrollSensitivity.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(scrollSensitivity, "scrollSensitivity");
		return oValue != null ? oValue.intValue()  : 20;
	}
	public void setScrollSensitivity(int scrollSensitivity) {
		this.scrollSensitivity = new Integer(scrollSensitivity);
	}

	public int getScrollSpeed() {
		if(scrollSpeed != null )
			return scrollSpeed.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(scrollSpeed, "scrollSpeed");
		return oValue != null ? oValue.intValue()  : 20;
	}
	public void setScrollSpeed(int scrollSpeed) {
		this.scrollSpeed = new Integer(scrollSpeed);
	}

	public String getSnap() {
		if(snap != null )
			return snap;

		String oValue = (String) getLocalOrValueBindingValue(snap, "snap");
		return oValue != null ? oValue : null;
	}
	public void setSnap(String snap) {
		this.snap = snap;
	}

	public String getSnapMode() {
		if(snapMode != null )
			return snapMode;

		String oValue = (String) getLocalOrValueBindingValue(snapMode, "snapMode");
		return oValue != null ? oValue : null;
	}
	public void setSnapMode(String snapMode) {
		this.snapMode = snapMode;
	}

	public int getSnapTolerance() {
		if(snapTolerance != null )
			return snapTolerance.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(snapTolerance, "snapTolerance");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setSnapTolerance(int snapTolerance) {
		this.snapTolerance = new Integer(snapTolerance);
	}

	public String getStack() {
		if(stack != null )
			return stack;

		String oValue = (String) getLocalOrValueBindingValue(stack, "stack");
		return oValue != null ? oValue : null;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}

	public int getZindex() {
		if(zindex != null )
			return zindex.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(zindex, "zindex");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setZindex(int zindex) {
		this.zindex = new Integer(zindex);
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

	public String getOndrag() {
		if(ondrag != null )
			return ondrag;

		String oValue = (String) getLocalOrValueBindingValue(ondrag, "ondrag");
		return oValue != null ? oValue : null;
	}
	public void setOndrag(String ondrag) {
		this.ondrag = ondrag;
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
		Object values[] = new Object[32];
		values[0] = super.saveState(context);
		values[1] = this._for;
		values[2] = this.addClasses;
		values[3] = this.appendTo;
		values[4] = this.axis;
		values[5] = this.cancel;
		values[6] = this.connectToSortable;
		values[7] = this.containment;
		values[8] = this.cursor;
		values[9] = this.cursorAt;
		values[10] = this.delay;
		values[11] = this.distance;
		values[12] = this.grid;
		values[13] = this.handle;
		values[14] = this.helper;
		values[15] = this.iframeFix;
		values[16] = this.opacity;
		values[17] = this.refreshPositions;
		values[18] = this.revert;
		values[19] = this.revertDuration;
		values[20] = this.scope;
		values[21] = this.scroll;
		values[22] = this.scrollSensitivity;
		values[23] = this.scrollSpeed;
		values[24] = this.snap;
		values[25] = this.snapMode;
		values[26] = this.snapTolerance;
		values[27] = this.stack;
		values[28] = this.zindex;
		values[29] = this.onstart;
		values[30] = this.ondrag;
		values[31] = this.onstop;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this._for = (String) values[1];
		this.addClasses = (Boolean) values[2];
		this.appendTo = (String) values[3];
		this.axis = (String) values[4];
		this.cancel = (String) values[5];
		this.connectToSortable = (String) values[6];
		this.containment = (String) values[7];
		this.cursor = (String) values[8];
		this.cursorAt = (String) values[9];
		this.delay = (Integer) values[10];
		this.distance = (Integer) values[11];
		this.grid = (String) values[12];
		this.handle = (String) values[13];
		this.helper = (String) values[14];
		this.iframeFix = (String) values[15];
		this.opacity = (Float) values[16];
		this.refreshPositions = (Boolean) values[17];
		this.revert = (String) values[18];
		this.revertDuration = (Integer) values[19];
		this.scope = (String) values[20];
		this.scroll = (Boolean) values[21];
		this.scrollSensitivity = (Integer) values[22];
		this.scrollSpeed = (Integer) values[23];
		this.snap = (String) values[24];
		this.snapMode = (String) values[25];
		this.snapTolerance = (Integer) values[26];
		this.stack = (String) values[27];
		this.zindex = (Integer) values[28];
		this.onstart = (String) values[29];
		this.ondrag = (String) values[30];
		this.onstop = (String) values[31];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodeScript(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof org.jquery4jsf.renderkit.JQueryRenderer) {
			((org.jquery4jsf.renderkit.JQueryRenderer)renderer).encodeScript(facesContext, this);
		}
	}
}