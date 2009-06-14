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
package org.jquery4jsf.custom.lightbox;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Integer;

public class LightBox extends UIComponentBase implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlLightBox";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.LightBox";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.LightBoxRenderer";

	private String[] resources;
	private String style;
	private String styleClass;
	private Integer activeImage;
	private Boolean fixedNavigation;
	private String overlayBgColor;
	private String overlayOpacity;
	private String imageLoading;
	private String imageBtnClose;
	private String imageBtnPrev;
	private String imageBtnNext;
	private String containerBorderSize;
	private String containerResizeSpeed;
	private String txtImage;
	private String txtOf;
	private String imageBlank;
	private String keyToClose;
	private String keyToPrev;
	private String keyToNext;

	public LightBox() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"lightbox/lightbox.css",
			"jquery/jquery.js",
			"lightbox/lightbox.js"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getStyle() {
		if(style != null )
			return style;

		String oValue = (String) getLocalOrValueBindingValue(style, "style");
		return oValue != null ? oValue : null;
	}
	public void setStyle(String style) {
		this.style = style;
	}

	public String getStyleClass() {
		if(styleClass != null )
			return styleClass;

		String oValue = (String) getLocalOrValueBindingValue(styleClass, "styleClass");
		return oValue != null ? oValue : null;
	}
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public int getActiveImage() {
		if(activeImage != null )
			return activeImage.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(activeImage, "activeImage");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setActiveImage(int activeImage) {
		this.activeImage = new Integer(activeImage);
	}

	public boolean isFixedNavigation() {
		if(fixedNavigation != null )
			return fixedNavigation.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(fixedNavigation, "fixedNavigation");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setFixedNavigation(boolean fixedNavigation) {
		this.fixedNavigation = new Boolean(fixedNavigation);
	}

	public String getOverlayBgColor() {
		if(overlayBgColor != null )
			return overlayBgColor;

		String oValue = (String) getLocalOrValueBindingValue(overlayBgColor, "overlayBgColor");
		return oValue != null ? oValue : null;
	}
	public void setOverlayBgColor(String overlayBgColor) {
		this.overlayBgColor = overlayBgColor;
	}

	public String getOverlayOpacity() {
		if(overlayOpacity != null )
			return overlayOpacity;

		String oValue = (String) getLocalOrValueBindingValue(overlayOpacity, "overlayOpacity");
		return oValue != null ? oValue : null;
	}
	public void setOverlayOpacity(String overlayOpacity) {
		this.overlayOpacity = overlayOpacity;
	}

	public String getImageLoading() {
		if(imageLoading != null )
			return imageLoading;

		String oValue = (String) getLocalOrValueBindingValue(imageLoading, "imageLoading");
		return oValue != null ? oValue : null;
	}
	public void setImageLoading(String imageLoading) {
		this.imageLoading = imageLoading;
	}

	public String getImageBtnClose() {
		if(imageBtnClose != null )
			return imageBtnClose;

		String oValue = (String) getLocalOrValueBindingValue(imageBtnClose, "imageBtnClose");
		return oValue != null ? oValue : null;
	}
	public void setImageBtnClose(String imageBtnClose) {
		this.imageBtnClose = imageBtnClose;
	}

	public String getImageBtnPrev() {
		if(imageBtnPrev != null )
			return imageBtnPrev;

		String oValue = (String) getLocalOrValueBindingValue(imageBtnPrev, "imageBtnPrev");
		return oValue != null ? oValue : null;
	}
	public void setImageBtnPrev(String imageBtnPrev) {
		this.imageBtnPrev = imageBtnPrev;
	}

	public String getImageBtnNext() {
		if(imageBtnNext != null )
			return imageBtnNext;

		String oValue = (String) getLocalOrValueBindingValue(imageBtnNext, "imageBtnNext");
		return oValue != null ? oValue : null;
	}
	public void setImageBtnNext(String imageBtnNext) {
		this.imageBtnNext = imageBtnNext;
	}

	public String getContainerBorderSize() {
		if(containerBorderSize != null )
			return containerBorderSize;

		String oValue = (String) getLocalOrValueBindingValue(containerBorderSize, "containerBorderSize");
		return oValue != null ? oValue : null;
	}
	public void setContainerBorderSize(String containerBorderSize) {
		this.containerBorderSize = containerBorderSize;
	}

	public String getContainerResizeSpeed() {
		if(containerResizeSpeed != null )
			return containerResizeSpeed;

		String oValue = (String) getLocalOrValueBindingValue(containerResizeSpeed, "containerResizeSpeed");
		return oValue != null ? oValue : null;
	}
	public void setContainerResizeSpeed(String containerResizeSpeed) {
		this.containerResizeSpeed = containerResizeSpeed;
	}

	public String getTxtImage() {
		if(txtImage != null )
			return txtImage;

		String oValue = (String) getLocalOrValueBindingValue(txtImage, "txtImage");
		return oValue != null ? oValue : null;
	}
	public void setTxtImage(String txtImage) {
		this.txtImage = txtImage;
	}

	public String getTxtOf() {
		if(txtOf != null )
			return txtOf;

		String oValue = (String) getLocalOrValueBindingValue(txtOf, "txtOf");
		return oValue != null ? oValue : null;
	}
	public void setTxtOf(String txtOf) {
		this.txtOf = txtOf;
	}

	public String getImageBlank() {
		if(imageBlank != null )
			return imageBlank;

		String oValue = (String) getLocalOrValueBindingValue(imageBlank, "imageBlank");
		return oValue != null ? oValue : null;
	}
	public void setImageBlank(String imageBlank) {
		this.imageBlank = imageBlank;
	}

	public String getKeyToClose() {
		if(keyToClose != null )
			return keyToClose;

		String oValue = (String) getLocalOrValueBindingValue(keyToClose, "keyToClose");
		return oValue != null ? oValue : null;
	}
	public void setKeyToClose(String keyToClose) {
		this.keyToClose = keyToClose;
	}

	public String getKeyToPrev() {
		if(keyToPrev != null )
			return keyToPrev;

		String oValue = (String) getLocalOrValueBindingValue(keyToPrev, "keyToPrev");
		return oValue != null ? oValue : null;
	}
	public void setKeyToPrev(String keyToPrev) {
		this.keyToPrev = keyToPrev;
	}

	public String getKeyToNext() {
		if(keyToNext != null )
			return keyToNext;

		String oValue = (String) getLocalOrValueBindingValue(keyToNext, "keyToNext");
		return oValue != null ? oValue : null;
	}
	public void setKeyToNext(String keyToNext) {
		this.keyToNext = keyToNext;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[19];
		values[0] = super.saveState(context);
		values[1] = style;
		values[2] = styleClass;
		values[3] = activeImage;
		values[4] = fixedNavigation;
		values[5] = overlayBgColor;
		values[6] = overlayOpacity;
		values[7] = imageLoading;
		values[8] = imageBtnClose;
		values[9] = imageBtnPrev;
		values[10] = imageBtnNext;
		values[11] = containerBorderSize;
		values[12] = containerResizeSpeed;
		values[13] = txtImage;
		values[14] = txtOf;
		values[15] = imageBlank;
		values[16] = keyToClose;
		values[17] = keyToPrev;
		values[18] = keyToNext;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.style = (String) values[1];
		this.styleClass = (String) values[2];
		this.activeImage = (Integer) values[3];
		this.fixedNavigation = (Boolean) values[4];
		this.overlayBgColor = (String) values[5];
		this.overlayOpacity = (String) values[6];
		this.imageLoading = (String) values[7];
		this.imageBtnClose = (String) values[8];
		this.imageBtnPrev = (String) values[9];
		this.imageBtnNext = (String) values[10];
		this.containerBorderSize = (String) values[11];
		this.containerResizeSpeed = (String) values[12];
		this.txtImage = (String) values[13];
		this.txtOf = (String) values[14];
		this.imageBlank = (String) values[15];
		this.keyToClose = (String) values[16];
		this.keyToPrev = (String) values[17];
		this.keyToNext = (String) values[18];
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