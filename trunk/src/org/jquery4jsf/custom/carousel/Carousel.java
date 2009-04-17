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
package org.jquery4jsf.custom.carousel;

import org.jquery4jsf.component.ext.HtmlBaseComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.el.ValueExpression;
import javax.el.MethodExpression;
import javax.faces.render.Renderer;
import java.io.IOException;
import java.lang.String;
import java.lang.Boolean;
import javax.faces.component.UIComponent;
import java.lang.Integer;

public class Carousel extends HtmlBaseComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlCarousel";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Carousel";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.CarouselRenderer";

	private String[] resources;
	private Boolean vertical;
	private String skin;
	private String skinCss;
	private String skinStyleClass;
	private Integer start;
	private Integer offset;
	private Integer size;
	private Integer scroll;
	private Integer visible;
	private String animation;
	private String easing;
	private Integer auto;
	private String wrap;
	private String initCallback;
	private String itemLoadCallbackBefore;
	private String itemLoadCallbackAfter;
	private String itemFirstInCallbackBefore;
	private String itemFirstInCallbackAfter;
	private String itemFirstOutCallbackBefore;
	private String itemFirstOutCallbackAfter;
	private String itemLastInCallbackBefore;
	private String itemLastInCallbackAfter;
	private String itemLastOutCallbackBefore;
	private String itemLastOutCallbackAfter;
	private String itemVisibleInCallbackBefore;
	private String itemVisibleInCallbackAfter;
	private String itemVisibleOutCallbackBefore;
	private String itemVisibleOutCallbackAfter;
	private String buttonNextCallback;
	private String buttonPrevCallback;
	private String buttonNextEvent;
	private String buttonPrevEvent;

	public Carousel() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"carousel/jquery.jcarousel.js",
			"carousel/jquery.jcarousel.css",
			"carousel/skins/"+getSkin()+"/skin.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isVertical() {
		if(vertical != null )
			return vertical.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(vertical, "vertical");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setVertical(boolean vertical) {
		this.vertical = new Boolean(vertical);
	}

	public String getSkin() {
		if(skin != null )
			return skin;

		String oValue = (String) getLocalOrValueBindingValue(skin, "skin");
		return oValue != null ? oValue : "tango";
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getSkinCss() {
		if(skinCss != null )
			return skinCss;

		String oValue = (String) getLocalOrValueBindingValue(skinCss, "skinCss");
		return oValue != null ? oValue : null;
	}
	public void setSkinCss(String skinCss) {
		this.skinCss = skinCss;
	}

	public String getSkinStyleClass() {
		if(skinStyleClass != null )
			return skinStyleClass;

		String oValue = (String) getLocalOrValueBindingValue(skinStyleClass, "skinStyleClass");
		return oValue != null ? oValue : null;
	}
	public void setSkinStyleClass(String skinStyleClass) {
		this.skinStyleClass = skinStyleClass;
	}

	public int getStart() {
		if(start != null )
			return start.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(start, "start");
		return oValue != null ? oValue.intValue()  : 1;
	}
	public void setStart(int start) {
		this.start = new Integer(start);
	}

	public int getOffset() {
		if(offset != null )
			return offset.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(offset, "offset");
		return oValue != null ? oValue.intValue()  : 1;
	}
	public void setOffset(int offset) {
		this.offset = new Integer(offset);
	}

	public int getSize() {
		if(size != null )
			return size.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(size, "size");
		return oValue != null ? oValue.intValue()  : -1;
	}
	public void setSize(int size) {
		this.size = new Integer(size);
	}

	public int getScroll() {
		if(scroll != null )
			return scroll.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(scroll, "scroll");
		return oValue != null ? oValue.intValue()  : 3;
	}
	public void setScroll(int scroll) {
		this.scroll = new Integer(scroll);
	}

	public int getVisible() {
		if(visible != null )
			return visible.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(visible, "visible");
		return oValue != null ? oValue.intValue()  : -1;
	}
	public void setVisible(int visible) {
		this.visible = new Integer(visible);
	}

	public String getAnimation() {
		if(animation != null )
			return animation;

		String oValue = (String) getLocalOrValueBindingValue(animation, "animation");
		return oValue != null ? oValue : "fast";
	}
	public void setAnimation(String animation) {
		this.animation = animation;
	}

	public String getEasing() {
		if(easing != null )
			return easing;

		String oValue = (String) getLocalOrValueBindingValue(easing, "easing");
		return oValue != null ? oValue : null;
	}
	public void setEasing(String easing) {
		this.easing = easing;
	}

	public int getAuto() {
		if(auto != null )
			return auto.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(auto, "auto");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setAuto(int auto) {
		this.auto = new Integer(auto);
	}

	public String getWrap() {
		if(wrap != null )
			return wrap;

		String oValue = (String) getLocalOrValueBindingValue(wrap, "wrap");
		return oValue != null ? oValue : null;
	}
	public void setWrap(String wrap) {
		this.wrap = wrap;
	}

	public String getInitCallback() {
		if(initCallback != null )
			return initCallback;

		String oValue = (String) getLocalOrValueBindingValue(initCallback, "initCallback");
		return oValue != null ? oValue : null;
	}
	public void setInitCallback(String initCallback) {
		this.initCallback = initCallback;
	}

	public String getItemLoadCallbackBefore() {
		if(itemLoadCallbackBefore != null )
			return itemLoadCallbackBefore;

		String oValue = (String) getLocalOrValueBindingValue(itemLoadCallbackBefore, "itemLoadCallbackBefore");
		return oValue != null ? oValue : null;
	}
	public void setItemLoadCallbackBefore(String itemLoadCallbackBefore) {
		this.itemLoadCallbackBefore = itemLoadCallbackBefore;
	}

	public String getItemLoadCallbackAfter() {
		if(itemLoadCallbackAfter != null )
			return itemLoadCallbackAfter;

		String oValue = (String) getLocalOrValueBindingValue(itemLoadCallbackAfter, "itemLoadCallbackAfter");
		return oValue != null ? oValue : null;
	}
	public void setItemLoadCallbackAfter(String itemLoadCallbackAfter) {
		this.itemLoadCallbackAfter = itemLoadCallbackAfter;
	}

	public String getItemFirstInCallbackBefore() {
		if(itemFirstInCallbackBefore != null )
			return itemFirstInCallbackBefore;

		String oValue = (String) getLocalOrValueBindingValue(itemFirstInCallbackBefore, "itemFirstInCallbackBefore");
		return oValue != null ? oValue : null;
	}
	public void setItemFirstInCallbackBefore(String itemFirstInCallbackBefore) {
		this.itemFirstInCallbackBefore = itemFirstInCallbackBefore;
	}

	public String getItemFirstInCallbackAfter() {
		if(itemFirstInCallbackAfter != null )
			return itemFirstInCallbackAfter;

		String oValue = (String) getLocalOrValueBindingValue(itemFirstInCallbackAfter, "itemFirstInCallbackAfter");
		return oValue != null ? oValue : null;
	}
	public void setItemFirstInCallbackAfter(String itemFirstInCallbackAfter) {
		this.itemFirstInCallbackAfter = itemFirstInCallbackAfter;
	}

	public String getItemFirstOutCallbackBefore() {
		if(itemFirstOutCallbackBefore != null )
			return itemFirstOutCallbackBefore;

		String oValue = (String) getLocalOrValueBindingValue(itemFirstOutCallbackBefore, "itemFirstOutCallbackBefore");
		return oValue != null ? oValue : null;
	}
	public void setItemFirstOutCallbackBefore(String itemFirstOutCallbackBefore) {
		this.itemFirstOutCallbackBefore = itemFirstOutCallbackBefore;
	}

	public String getItemFirstOutCallbackAfter() {
		if(itemFirstOutCallbackAfter != null )
			return itemFirstOutCallbackAfter;

		String oValue = (String) getLocalOrValueBindingValue(itemFirstOutCallbackAfter, "itemFirstOutCallbackAfter");
		return oValue != null ? oValue : null;
	}
	public void setItemFirstOutCallbackAfter(String itemFirstOutCallbackAfter) {
		this.itemFirstOutCallbackAfter = itemFirstOutCallbackAfter;
	}

	public String getItemLastInCallbackBefore() {
		if(itemLastInCallbackBefore != null )
			return itemLastInCallbackBefore;

		String oValue = (String) getLocalOrValueBindingValue(itemLastInCallbackBefore, "itemLastInCallbackBefore");
		return oValue != null ? oValue : null;
	}
	public void setItemLastInCallbackBefore(String itemLastInCallbackBefore) {
		this.itemLastInCallbackBefore = itemLastInCallbackBefore;
	}

	public String getItemLastInCallbackAfter() {
		if(itemLastInCallbackAfter != null )
			return itemLastInCallbackAfter;

		String oValue = (String) getLocalOrValueBindingValue(itemLastInCallbackAfter, "itemLastInCallbackAfter");
		return oValue != null ? oValue : null;
	}
	public void setItemLastInCallbackAfter(String itemLastInCallbackAfter) {
		this.itemLastInCallbackAfter = itemLastInCallbackAfter;
	}

	public String getItemLastOutCallbackBefore() {
		if(itemLastOutCallbackBefore != null )
			return itemLastOutCallbackBefore;

		String oValue = (String) getLocalOrValueBindingValue(itemLastOutCallbackBefore, "itemLastOutCallbackBefore");
		return oValue != null ? oValue : null;
	}
	public void setItemLastOutCallbackBefore(String itemLastOutCallbackBefore) {
		this.itemLastOutCallbackBefore = itemLastOutCallbackBefore;
	}

	public String getItemLastOutCallbackAfter() {
		if(itemLastOutCallbackAfter != null )
			return itemLastOutCallbackAfter;

		String oValue = (String) getLocalOrValueBindingValue(itemLastOutCallbackAfter, "itemLastOutCallbackAfter");
		return oValue != null ? oValue : null;
	}
	public void setItemLastOutCallbackAfter(String itemLastOutCallbackAfter) {
		this.itemLastOutCallbackAfter = itemLastOutCallbackAfter;
	}

	public String getItemVisibleInCallbackBefore() {
		if(itemVisibleInCallbackBefore != null )
			return itemVisibleInCallbackBefore;

		String oValue = (String) getLocalOrValueBindingValue(itemVisibleInCallbackBefore, "itemVisibleInCallbackBefore");
		return oValue != null ? oValue : null;
	}
	public void setItemVisibleInCallbackBefore(String itemVisibleInCallbackBefore) {
		this.itemVisibleInCallbackBefore = itemVisibleInCallbackBefore;
	}

	public String getItemVisibleInCallbackAfter() {
		if(itemVisibleInCallbackAfter != null )
			return itemVisibleInCallbackAfter;

		String oValue = (String) getLocalOrValueBindingValue(itemVisibleInCallbackAfter, "itemVisibleInCallbackAfter");
		return oValue != null ? oValue : null;
	}
	public void setItemVisibleInCallbackAfter(String itemVisibleInCallbackAfter) {
		this.itemVisibleInCallbackAfter = itemVisibleInCallbackAfter;
	}

	public String getItemVisibleOutCallbackBefore() {
		if(itemVisibleOutCallbackBefore != null )
			return itemVisibleOutCallbackBefore;

		String oValue = (String) getLocalOrValueBindingValue(itemVisibleOutCallbackBefore, "itemVisibleOutCallbackBefore");
		return oValue != null ? oValue : null;
	}
	public void setItemVisibleOutCallbackBefore(String itemVisibleOutCallbackBefore) {
		this.itemVisibleOutCallbackBefore = itemVisibleOutCallbackBefore;
	}

	public String getItemVisibleOutCallbackAfter() {
		if(itemVisibleOutCallbackAfter != null )
			return itemVisibleOutCallbackAfter;

		String oValue = (String) getLocalOrValueBindingValue(itemVisibleOutCallbackAfter, "itemVisibleOutCallbackAfter");
		return oValue != null ? oValue : null;
	}
	public void setItemVisibleOutCallbackAfter(String itemVisibleOutCallbackAfter) {
		this.itemVisibleOutCallbackAfter = itemVisibleOutCallbackAfter;
	}

	public String getButtonNextCallback() {
		if(buttonNextCallback != null )
			return buttonNextCallback;

		String oValue = (String) getLocalOrValueBindingValue(buttonNextCallback, "buttonNextCallback");
		return oValue != null ? oValue : null;
	}
	public void setButtonNextCallback(String buttonNextCallback) {
		this.buttonNextCallback = buttonNextCallback;
	}

	public String getButtonPrevCallback() {
		if(buttonPrevCallback != null )
			return buttonPrevCallback;

		String oValue = (String) getLocalOrValueBindingValue(buttonPrevCallback, "buttonPrevCallback");
		return oValue != null ? oValue : null;
	}
	public void setButtonPrevCallback(String buttonPrevCallback) {
		this.buttonPrevCallback = buttonPrevCallback;
	}

	public String getButtonNextEvent() {
		if(buttonNextEvent != null )
			return buttonNextEvent;

		String oValue = (String) getLocalOrValueBindingValue(buttonNextEvent, "buttonNextEvent");
		return oValue != null ? oValue : "click";
	}
	public void setButtonNextEvent(String buttonNextEvent) {
		this.buttonNextEvent = buttonNextEvent;
	}

	public String getButtonPrevEvent() {
		if(buttonPrevEvent != null )
			return buttonPrevEvent;

		String oValue = (String) getLocalOrValueBindingValue(buttonPrevEvent, "buttonPrevEvent");
		return oValue != null ? oValue : "click";
	}
	public void setButtonPrevEvent(String buttonPrevEvent) {
		this.buttonPrevEvent = buttonPrevEvent;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[33];
		values[0] = super.saveState(context);
		values[1] = vertical;
		values[2] = skin;
		values[3] = skinCss;
		values[4] = skinStyleClass;
		values[5] = start;
		values[6] = offset;
		values[7] = size;
		values[8] = scroll;
		values[9] = visible;
		values[10] = animation;
		values[11] = easing;
		values[12] = auto;
		values[13] = wrap;
		values[14] = initCallback;
		values[15] = itemLoadCallbackBefore;
		values[16] = itemLoadCallbackAfter;
		values[17] = itemFirstInCallbackBefore;
		values[18] = itemFirstInCallbackAfter;
		values[19] = itemFirstOutCallbackBefore;
		values[20] = itemFirstOutCallbackAfter;
		values[21] = itemLastInCallbackBefore;
		values[22] = itemLastInCallbackAfter;
		values[23] = itemLastOutCallbackBefore;
		values[24] = itemLastOutCallbackAfter;
		values[25] = itemVisibleInCallbackBefore;
		values[26] = itemVisibleInCallbackAfter;
		values[27] = itemVisibleOutCallbackBefore;
		values[28] = itemVisibleOutCallbackAfter;
		values[29] = buttonNextCallback;
		values[30] = buttonPrevCallback;
		values[31] = buttonNextEvent;
		values[32] = buttonPrevEvent;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.vertical = (Boolean) values[1];
		this.skin = (String) values[2];
		this.skinCss = (String) values[3];
		this.skinStyleClass = (String) values[4];
		this.start = (Integer) values[5];
		this.offset = (Integer) values[6];
		this.size = (Integer) values[7];
		this.scroll = (Integer) values[8];
		this.visible = (Integer) values[9];
		this.animation = (String) values[10];
		this.easing = (String) values[11];
		this.auto = (Integer) values[12];
		this.wrap = (String) values[13];
		this.initCallback = (String) values[14];
		this.itemLoadCallbackBefore = (String) values[15];
		this.itemLoadCallbackAfter = (String) values[16];
		this.itemFirstInCallbackBefore = (String) values[17];
		this.itemFirstInCallbackAfter = (String) values[18];
		this.itemFirstOutCallbackBefore = (String) values[19];
		this.itemFirstOutCallbackAfter = (String) values[20];
		this.itemLastInCallbackBefore = (String) values[21];
		this.itemLastInCallbackAfter = (String) values[22];
		this.itemLastOutCallbackBefore = (String) values[23];
		this.itemLastOutCallbackAfter = (String) values[24];
		this.itemVisibleInCallbackBefore = (String) values[25];
		this.itemVisibleInCallbackAfter = (String) values[26];
		this.itemVisibleOutCallbackBefore = (String) values[27];
		this.itemVisibleOutCallbackAfter = (String) values[28];
		this.buttonNextCallback = (String) values[29];
		this.buttonPrevCallback = (String) values[30];
		this.buttonNextEvent = (String) values[31];
		this.buttonPrevEvent = (String) values[32];
	}

	public String[] getResources() {
		return resources;
	}

	public void encodePartially(FacesContext facesContext) throws IOException {
		Renderer renderer = getRenderer(facesContext);

		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(facesContext, this);
		}
	}
}