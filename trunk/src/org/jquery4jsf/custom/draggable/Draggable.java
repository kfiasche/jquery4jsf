package org.jquery4jsf.custom.draggable;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;


public class Draggable extends HtmlBaseComponent implements AjaxComponent, JQueryHtmlObject{

	private String[] resources = null;
	public static final String DEFAULT_RENDERER_TYPE = DraggableRenderer.RENDERER_TYPE;
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Draggable";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlDraggable";
	
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
	
	public Draggable() {
		super();
		resources =  new String[]{
				"jquery/jquery.js",
				"ui/ui.core.js",
				"ui/ui.draggable.js",
				"themes/base/ui.all.css"	
		};
		setRendererType(DEFAULT_RENDERER_TYPE);
	}
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public void encodePartially(FacesContext facesContext) throws IOException {
	}
	public MethodBinding getOncomplete() {
		return null;
	}
	public void setOncomplete(MethodBinding methodBinding) {
	}
	public String[] getResources() {
		return resources;
	}
	
	public Boolean getAddClasses() {
		return addClasses;
	}
	public void setAddClasses(Boolean addClasses) {
		this.addClasses = addClasses;
	}
	public String getAppendTo() {
		return appendTo;
	}
	public void setAppendTo(String appendTo) {
		this.appendTo = appendTo;
	}
	public String getAxis() {
		return axis;
	}
	public void setAxis(String axis) {
		this.axis = axis;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public String getConnectToSortable() {
		return connectToSortable;
	}
	public void setConnectToSortable(String connectToSortable) {
		this.connectToSortable = connectToSortable;
	}
	public String getContainment() {
		return containment;
	}
	public void setContainment(String containment) {
		this.containment = containment;
	}
	public String getCursor() {
		return cursor;
	}
	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
	public String getCursorAt() {
		return cursorAt;
	}
	public void setCursorAt(String cursorAt) {
		this.cursorAt = cursorAt;
	}
	public Integer getDelay() {
		return delay;
	}
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getGrid() {
		return grid;
	}
	public void setGrid(String grid) {
		this.grid = grid;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public String getHelper() {
		return helper;
	}
	public void setHelper(String helper) {
		this.helper = helper;
	}
	public String getIframeFix() {
		return iframeFix;
	}
	public void setIframeFix(String iframeFix) {
		this.iframeFix = iframeFix;
	}
	public Float getOpacity() {
		return opacity;
	}
	public void setOpacity(Float opacity) {
		this.opacity = opacity;
	}
	public Boolean getRefreshPositions() {
		return refreshPositions;
	}
	public void setRefreshPositions(Boolean refreshPositions) {
		this.refreshPositions = refreshPositions;
	}
	public String getRevert() {
		return revert;
	}
	public void setRevert(String revert) {
		this.revert = revert;
	}
	public Integer getRevertDuration() {
		return revertDuration;
	}
	public void setRevertDuration(Integer revertDuration) {
		this.revertDuration = revertDuration;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Boolean getScroll() {
		return scroll;
	}
	public void setScroll(Boolean scroll) {
		this.scroll = scroll;
	}
	public Integer getScrollSensitivity() {
		return scrollSensitivity;
	}
	public void setScrollSensitivity(Integer scrollSensitivity) {
		this.scrollSensitivity = scrollSensitivity;
	}
	public Integer getScrollSpeed() {
		return scrollSpeed;
	}
	public void setScrollSpeed(Integer scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}
	public String getSnap() {
		return snap;
	}
	public void setSnap(String snap) {
		this.snap = snap;
	}
	public String getSnapMode() {
		return snapMode;
	}
	public void setSnapMode(String snapMode) {
		this.snapMode = snapMode;
	}
	public Integer getSnapTolerance() {
		return snapTolerance;
	}
	public void setSnapTolerance(Integer snapTolerance) {
		this.snapTolerance = snapTolerance;
	}
	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
	public Integer getZindex() {
		return zindex;
	}
	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}

	public void setResources(String[] resources) {
		this.resources = resources;
	}

	
}
