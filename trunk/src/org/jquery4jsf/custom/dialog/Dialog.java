package org.jquery4jsf.custom.dialog;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;

public class Dialog extends HtmlBaseComponent implements AjaxComponent, JQueryHtmlObject {
	
	private String[] resources = null;
	public static final String DEFAULT_RENDERER_TYPE = DialogRenderer.RENDERER_TYPE;
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Dialog";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlDialog";
	
	private Boolean autoOpen;
	private Boolean bgiframe;
	private String buttons;
	private Boolean closeOnEscape;
	private String dialogClass;
	private Boolean draggable;
	private Integer height;
	private String hide;
	private Integer maxHeight;
	private Integer maxWidth;
	private Integer minHeight;
	private Integer minWidth;
	private Boolean modal;
	private String position;
	private Boolean resizable;
	private String show;
	private Boolean stack;
	private String title;
	private Integer width;
	private Integer zindex;
	
	public Dialog() {
		super();
		setRendererType(DEFAULT_RENDERER_TYPE);
		resources = new String[]{
				"jquery/jquery.js",
				"ui/ui.core.js",
				"ui/ui.draggable.js",
				"ui/ui.resizable.js",
				"dialog/ui.dialog.js",
				"external/jquery.bgiframe.min.js",
				"themes/base/ui.all.css"
		};
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

	public boolean isAutoOpen() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(autoOpen, "autoOpen");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setAutoOpen(boolean autoOpen) {
		this.autoOpen = autoOpen ? Boolean.TRUE :  Boolean.FALSE;
	}

	public boolean isBgiframe() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(bgiframe, "bgiframe");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setBgiframe(boolean bgiframe) {
		this.bgiframe = bgiframe? Boolean.TRUE :  Boolean.FALSE;
	}

	public String getButtons() {
		return (String) getLocalOrValueBindingValue(buttons, "buttons");
	}

	public void setButtons(String buttons) {
		this.buttons = buttons;
	}

	public boolean isCloseOnEscape() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(closeOnEscape, "closeOnEscape");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setCloseOnEscape(boolean closeOnEscape) {
		this.closeOnEscape = closeOnEscape? Boolean.TRUE :  Boolean.FALSE;
	}

	public String getDialogClass() {
		return (String) getLocalOrValueBindingValue(dialogClass, "dialogClass");
	}

	public void setDialogClass(String dialogClass) {
		this.dialogClass = dialogClass;
	}

	public boolean isDraggable() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(draggable, "draggable");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setDraggable(boolean draggable) {
		this.draggable = draggable? Boolean.TRUE :  Boolean.FALSE;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getHide() {
		return (String) getLocalOrValueBindingValue(hide, "hide");
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	public Integer getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
	}

	public Integer getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(Integer maxWidth) {
		this.maxWidth = maxWidth;
	}

	public Integer getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(Integer minHeight) {
		this.minHeight = minHeight;
	}

	public Integer getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(Integer minWidth) {
		this.minWidth = minWidth;
	}

	public boolean isModal() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(modal, "modal");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setModal(boolean modal) {
		this.modal = modal? Boolean.TRUE :  Boolean.FALSE;
	}

	public String getPosition() {
		return (String) getLocalOrValueBindingValue(position, "position");
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isResizable() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(resizable, "resizable");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setResizable(boolean resizable) {
		this.resizable = resizable? Boolean.TRUE :  Boolean.FALSE;
	}

	public String getShow() {
		return (String) getLocalOrValueBindingValue(show, "show");
	}

	public void setShow(String show) {
		this.show = show;
	}

	public boolean isStack() {
		Boolean bValue = (Boolean) getLocalOrValueBindingValue(stack, "stack");
		return bValue != null ? bValue.booleanValue() : false;
	}

	public void setStack(boolean stack) {
		this.stack = stack? Boolean.TRUE :  Boolean.FALSE;
	}

	public String getTitle() {
		return (String) getLocalOrValueBindingValue(title, "title");
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
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
