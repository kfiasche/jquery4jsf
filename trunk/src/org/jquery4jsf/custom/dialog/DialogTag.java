package org.jquery4jsf.custom.dialog;

import javax.faces.component.UIComponent;

import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;

public class DialogTag extends UIComponentTagBase {

	private String autoOpen;
	private String bgiframe;
	private String buttons;
	private String closeOnEscape;
	private String dialogClass;
	private String draggable;
	private String height;
	private String hide;
	private String maxHeight;
	private String maxWidth;
	private String minHeight;
	private String minWidth;
	private String modal;
	private String position;
	private String resizable;
	private String show;
	private String stack;
	private String title;
	private String width;
	private String zindex;
	
	public String getComponentType() {
		return Dialog.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return Dialog.DEFAULT_RENDERER_TYPE;
	}

	public void release(){
		super.release();
		autoOpen        = null;
		bgiframe        = null;
		buttons         = null;
		closeOnEscape   = null;
		dialogClass     = null;
		draggable       = null;
		height          = null;
		hide            = null;
		maxHeight       = null;
		maxWidth        = null;
		minHeight       = null;
		minWidth        = null;
		modal           = null;
		position        = null;
		resizable       = null;
		show            = null;
		stack           = null;
		title           = null;
		width           = null;
		zindex		= null;
	}
	
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		setBooleanProperty(getFacesContext(),component, "autoOpen", autoOpen);
		setBooleanProperty(getFacesContext(),component, "bgiframe", bgiframe);     
		setStringProperty(getFacesContext(),component, "buttons", buttons);       
		setBooleanProperty(getFacesContext(),component, "closeOnEscape", closeOnEscape);
		setStringProperty(getFacesContext(),component, "dialogClass", dialogClass);   
		setBooleanProperty(getFacesContext(),component, "draggable", draggable);    
		setIntegerProperty(getFacesContext(),component, "height", height);       
		setStringProperty(getFacesContext(),component, "hide", hide);       
		setIntegerProperty(getFacesContext(),component, "maxHeight", maxHeight);    
		setIntegerProperty(getFacesContext(),component, "maxWidth", maxWidth);     
		setIntegerProperty(getFacesContext(),component, "minHeight", minHeight);    
		setIntegerProperty(getFacesContext(),component, "minWidth", minWidth);     
		setBooleanProperty(getFacesContext(),component, "modal", modal);       
		setStringProperty(getFacesContext(),component, "position", position);       
		setBooleanProperty(getFacesContext(),component, "resizable", resizable);     
		setStringProperty(getFacesContext(),component, "show", show);           
		setBooleanProperty(getFacesContext(),component, "stack", stack);         
		setStringProperty(getFacesContext(),component, "title", title);          
		setIntegerProperty(getFacesContext(),component, "width", width);         
		setIntegerProperty(getFacesContext(),component, "zindex", zindex);     
	}
	
	
	public void setAutoOpen(String autoOpen) {
		this.autoOpen = autoOpen;
	}

	public void setBgiframe(String bgiframe) {
		this.bgiframe = bgiframe;
	}

	public void setButtons(String buttons) {
		this.buttons = buttons;
	}

	public void setCloseOnEscape(String closeOnEscape) {
		this.closeOnEscape = closeOnEscape;
	}

	public void setDialogClass(String dialogClass) {
		this.dialogClass = dialogClass;
	}

	public void setDraggable(String draggable) {
		this.draggable = draggable;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	public void setMaxHeight(String maxHeight) {
		this.maxHeight = maxHeight;
	}

	public void setMaxWidth(String maxWidth) {
		this.maxWidth = maxWidth;
	}

	public void setMinHeight(String minHeight) {
		this.minHeight = minHeight;
	}

	public void setMinWidth(String minWidth) {
		this.minWidth = minWidth;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setResizable(String resizable) {
		this.resizable = resizable;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public void setZindex(String zindex) {
		this.zindex = zindex;
	}

}
