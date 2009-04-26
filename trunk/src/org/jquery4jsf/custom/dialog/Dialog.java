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
package org.jquery4jsf.custom.dialog;

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

public class Dialog extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlDialog";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Dialog";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.DialogRenderer";

	private String[] resources;
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
	private String onbeforeclose;
	private String onopen;
	private String onfocus;
	private String ondragStart;
	private String ondrag;
	private String ondragStop;
	private String onresizeStart;
	private String onresize;
	private String onresizeStop;
	private String onclose;

	public Dialog() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"ui/ui.core.js",
			"dialog/ui.dialog.js",
			"ui/ui.draggable.js",
			"ui/ui.resizable.js",
			"external/jquery.bgiframe.min.js",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isAutoOpen() {
		if(autoOpen != null )
			return autoOpen.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(autoOpen, "autoOpen");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setAutoOpen(boolean autoOpen) {
		this.autoOpen = new Boolean(autoOpen);
	}

	public boolean isBgiframe() {
		if(bgiframe != null )
			return bgiframe.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(bgiframe, "bgiframe");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setBgiframe(boolean bgiframe) {
		this.bgiframe = new Boolean(bgiframe);
	}

	public String getButtons() {
		if(buttons != null )
			return buttons;

		String oValue = (String) getLocalOrValueBindingValue(buttons, "buttons");
		return oValue != null ? oValue : null;
	}
	public void setButtons(String buttons) {
		this.buttons = buttons;
	}

	public boolean isCloseOnEscape() {
		if(closeOnEscape != null )
			return closeOnEscape.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(closeOnEscape, "closeOnEscape");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setCloseOnEscape(boolean closeOnEscape) {
		this.closeOnEscape = new Boolean(closeOnEscape);
	}

	public String getDialogClass() {
		if(dialogClass != null )
			return dialogClass;

		String oValue = (String) getLocalOrValueBindingValue(dialogClass, "dialogClass");
		return oValue != null ? oValue : null;
	}
	public void setDialogClass(String dialogClass) {
		this.dialogClass = dialogClass;
	}

	public boolean isDraggable() {
		if(draggable != null )
			return draggable.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(draggable, "draggable");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setDraggable(boolean draggable) {
		this.draggable = new Boolean(draggable);
	}

	public int getHeight() {
		if(height != null )
			return height.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(height, "height");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setHeight(int height) {
		this.height = new Integer(height);
	}

	public String getHide() {
		if(hide != null )
			return hide;

		String oValue = (String) getLocalOrValueBindingValue(hide, "hide");
		return oValue != null ? oValue : null;
	}
	public void setHide(String hide) {
		this.hide = hide;
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

	public int getMinHeight() {
		if(minHeight != null )
			return minHeight.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(minHeight, "minHeight");
		return oValue != null ? oValue.intValue()  : 150;
	}
	public void setMinHeight(int minHeight) {
		this.minHeight = new Integer(minHeight);
	}

	public int getMinWidth() {
		if(minWidth != null )
			return minWidth.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(minWidth, "minWidth");
		return oValue != null ? oValue.intValue()  : 150;
	}
	public void setMinWidth(int minWidth) {
		this.minWidth = new Integer(minWidth);
	}

	public boolean isModal() {
		if(modal != null )
			return modal.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(modal, "modal");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setModal(boolean modal) {
		this.modal = new Boolean(modal);
	}

	public String getPosition() {
		if(position != null )
			return position;

		String oValue = (String) getLocalOrValueBindingValue(position, "position");
		return oValue != null ? oValue : "center";
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isResizable() {
		if(resizable != null )
			return resizable.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(resizable, "resizable");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setResizable(boolean resizable) {
		this.resizable = new Boolean(resizable);
	}

	public String getShow() {
		if(show != null )
			return show;

		String oValue = (String) getLocalOrValueBindingValue(show, "show");
		return oValue != null ? oValue : null;
	}
	public void setShow(String show) {
		this.show = show;
	}

	public boolean isStack() {
		if(stack != null )
			return stack.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(stack, "stack");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setStack(boolean stack) {
		this.stack = new Boolean(stack);
	}

	public String getTitle() {
		if(title != null )
			return title;

		String oValue = (String) getLocalOrValueBindingValue(title, "title");
		return oValue != null ? oValue : null;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		if(width != null )
			return width.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(width, "width");
		return oValue != null ? oValue.intValue()  : 300;
	}
	public void setWidth(int width) {
		this.width = new Integer(width);
	}

	public int getZindex() {
		if(zindex != null )
			return zindex.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(zindex, "zindex");
		return oValue != null ? oValue.intValue()  : 1000;
	}
	public void setZindex(int zindex) {
		this.zindex = new Integer(zindex);
	}

	public String getOnbeforeclose() {
		if(onbeforeclose != null )
			return onbeforeclose;

		String oValue = (String) getLocalOrValueBindingValue(onbeforeclose, "onbeforeclose");
		return oValue != null ? oValue : null;
	}
	public void setOnbeforeclose(String onbeforeclose) {
		this.onbeforeclose = onbeforeclose;
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

	public String getOnfocus() {
		if(onfocus != null )
			return onfocus;

		String oValue = (String) getLocalOrValueBindingValue(onfocus, "onfocus");
		return oValue != null ? oValue : null;
	}
	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	public String getOndragStart() {
		if(ondragStart != null )
			return ondragStart;

		String oValue = (String) getLocalOrValueBindingValue(ondragStart, "ondragStart");
		return oValue != null ? oValue : null;
	}
	public void setOndragStart(String ondragStart) {
		this.ondragStart = ondragStart;
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

	public String getOndragStop() {
		if(ondragStop != null )
			return ondragStop;

		String oValue = (String) getLocalOrValueBindingValue(ondragStop, "ondragStop");
		return oValue != null ? oValue : null;
	}
	public void setOndragStop(String ondragStop) {
		this.ondragStop = ondragStop;
	}

	public String getOnresizeStart() {
		if(onresizeStart != null )
			return onresizeStart;

		String oValue = (String) getLocalOrValueBindingValue(onresizeStart, "onresizeStart");
		return oValue != null ? oValue : null;
	}
	public void setOnresizeStart(String onresizeStart) {
		this.onresizeStart = onresizeStart;
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

	public String getOnresizeStop() {
		if(onresizeStop != null )
			return onresizeStop;

		String oValue = (String) getLocalOrValueBindingValue(onresizeStop, "onresizeStop");
		return oValue != null ? oValue : null;
	}
	public void setOnresizeStop(String onresizeStop) {
		this.onresizeStop = onresizeStop;
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

	public Object saveState(FacesContext context) {
		Object values[] = new Object[31];
		values[0] = super.saveState(context);
		values[1] = autoOpen;
		values[2] = bgiframe;
		values[3] = buttons;
		values[4] = closeOnEscape;
		values[5] = dialogClass;
		values[6] = draggable;
		values[7] = height;
		values[8] = hide;
		values[9] = maxHeight;
		values[10] = maxWidth;
		values[11] = minHeight;
		values[12] = minWidth;
		values[13] = modal;
		values[14] = position;
		values[15] = resizable;
		values[16] = show;
		values[17] = stack;
		values[18] = title;
		values[19] = width;
		values[20] = zindex;
		values[21] = onbeforeclose;
		values[22] = onopen;
		values[23] = onfocus;
		values[24] = ondragStart;
		values[25] = ondrag;
		values[26] = ondragStop;
		values[27] = onresizeStart;
		values[28] = onresize;
		values[29] = onresizeStop;
		values[30] = onclose;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.autoOpen = (Boolean) values[1];
		this.bgiframe = (Boolean) values[2];
		this.buttons = (String) values[3];
		this.closeOnEscape = (Boolean) values[4];
		this.dialogClass = (String) values[5];
		this.draggable = (Boolean) values[6];
		this.height = (Integer) values[7];
		this.hide = (String) values[8];
		this.maxHeight = (Integer) values[9];
		this.maxWidth = (Integer) values[10];
		this.minHeight = (Integer) values[11];
		this.minWidth = (Integer) values[12];
		this.modal = (Boolean) values[13];
		this.position = (String) values[14];
		this.resizable = (Boolean) values[15];
		this.show = (String) values[16];
		this.stack = (Boolean) values[17];
		this.title = (String) values[18];
		this.width = (Integer) values[19];
		this.zindex = (Integer) values[20];
		this.onbeforeclose = (String) values[21];
		this.onopen = (String) values[22];
		this.onfocus = (String) values[23];
		this.ondragStart = (String) values[24];
		this.ondrag = (String) values[25];
		this.ondragStop = (String) values[26];
		this.onresizeStart = (String) values[27];
		this.onresize = (String) values[28];
		this.onresizeStop = (String) values[29];
		this.onclose = (String) values[30];
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