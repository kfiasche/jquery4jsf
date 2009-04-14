package org.jquery4jsf.custom.draggable;

import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class DraggableTag extends UIComponentTagBase {

	private String addClasses;
	private String appendTo;
	private String axis;
	private String cancel;
	private String connectToSortable;
	private String containment;
	private String cursor;
	private String cursorAt;
	private String delay;
	private String distance;
	private String grid;
	private String handle;
	private String helper;
	private String iframeFix;
	private String opacity;
	private String refreshPositions;
	private String revert;
	private String revertDuration;
	private String scope;
	private String scroll;
	private String scrollSensitivity;
	private String scrollSpeed;
	private String snap;
	private String snapMode;
	private String snapTolerance;
	private String stack;
	private String zindex;
	
	public String getComponentType() {
		return Draggable.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return Draggable.DEFAULT_RENDERER_TYPE;
	}

	public void release(){
		super.release();
		addClasses = null;
		appendTo = null;
		axis = null;
		cancel = null;
		connectToSortable = null;
		containment = null;
		cursor = null;
		cursorAt = null;
		delay = null;
		distance = null;
		grid = null;
		handle = null;
		helper = null;
		iframeFix = null;
		opacity = null;
		refreshPositions = null;
		revert = null;
		revertDuration = null;
		scope = null;
		scroll = null;
		scrollSensitivity = null;
		scrollSpeed = null;
		snap = null;
		snapMode = null;
		snapTolerance = null;
		stack = null;
		zindex = null;
	}
	
	public void setAddClasses(String addClasses) {
		this.addClasses = addClasses;
	}

	public void setAppendTo(String appendTo) {
		this.appendTo = appendTo;
	}

	public void setAxis(String axis) {
		this.axis = axis;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public void setConnectToSortable(String connectToSortable) {
		this.connectToSortable = connectToSortable;
	}

	public void setContainment(String containment) {
		this.containment = containment;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public void setCursorAt(String cursorAt) {
		this.cursorAt = cursorAt;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public void setHelper(String helper) {
		this.helper = helper;
	}

	public void setIframeFix(String iframeFix) {
		this.iframeFix = iframeFix;
	}

	public void setOpacity(String opacity) {
		this.opacity = opacity;
	}

	public void setRefreshPositions(String refreshPositions) {
		this.refreshPositions = refreshPositions;
	}

	public void setRevert(String revert) {
		this.revert = revert;
	}

	public void setRevertDuration(String revertDuration) {
		this.revertDuration = revertDuration;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setScroll(String scroll) {
		this.scroll = scroll;
	}

	public void setScrollSensitivity(String scrollSensitivity) {
		this.scrollSensitivity = scrollSensitivity;
	}

	public void setScrollSpeed(String scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}

	public void setSnap(String snap) {
		this.snap = snap;
	}

	public void setSnapMode(String snapMode) {
		this.snapMode = snapMode;
	}

	public void setSnapTolerance(String snapTolerance) {
		this.snapTolerance = snapTolerance;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public void setZindex(String zindex) {
		this.zindex = zindex;
	}

}
