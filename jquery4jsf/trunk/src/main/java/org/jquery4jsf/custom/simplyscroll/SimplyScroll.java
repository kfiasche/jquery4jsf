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
package org.jquery4jsf.custom.simplyscroll;

import org.jquery4jsf.component.ext.HtmlBaseOutputComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Integer;

public class SimplyScroll extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlSimplyScroll";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.SimplyScroll";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.SimplyScrollRenderer";

	private String[] resources;
	private String className;
	private Integer frameRate;
	private Integer speed;
	private Boolean horizontal;
	private String autoMode;
	private Boolean pauseOnHover;
	private String jsonSource;
	private Boolean customContent;

	public SimplyScroll() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"simplyscroll/jquery.simplyscroll.css",
			"jquery/jquery.js",
			"simplyscroll/jquery.simplyscroll.js"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getClassName() {
		if(className != null )
			return className;

		String oValue = (String) getLocalOrValueBindingValue(className, "className");
		return oValue != null ? oValue : null;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	public int getFrameRate() {
		if(frameRate != null )
			return frameRate.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(frameRate, "frameRate");
		return oValue != null ? oValue.intValue()  : 24;
	}
	public void setFrameRate(int frameRate) {
		this.frameRate = new Integer(frameRate);
	}

	public int getSpeed() {
		if(speed != null )
			return speed.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(speed, "speed");
		return oValue != null ? oValue.intValue()  : 1;
	}
	public void setSpeed(int speed) {
		this.speed = new Integer(speed);
	}

	public boolean isHorizontal() {
		if(horizontal != null )
			return horizontal.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(horizontal, "horizontal");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = new Boolean(horizontal);
	}

	public String getAutoMode() {
		if(autoMode != null )
			return autoMode;

		String oValue = (String) getLocalOrValueBindingValue(autoMode, "autoMode");
		return oValue != null ? oValue : null;
	}
	public void setAutoMode(String autoMode) {
		this.autoMode = autoMode;
	}

	public boolean isPauseOnHover() {
		if(pauseOnHover != null )
			return pauseOnHover.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(pauseOnHover, "pauseOnHover");
		return oValue != null ? oValue.booleanValue()  : true;
	}
	public void setPauseOnHover(boolean pauseOnHover) {
		this.pauseOnHover = new Boolean(pauseOnHover);
	}

	public String getJsonSource() {
		if(jsonSource != null )
			return jsonSource;

		String oValue = (String) getLocalOrValueBindingValue(jsonSource, "jsonSource");
		return oValue != null ? oValue : null;
	}
	public void setJsonSource(String jsonSource) {
		this.jsonSource = jsonSource;
	}

	public boolean isCustomContent() {
		if(customContent != null )
			return customContent.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(customContent, "customContent");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setCustomContent(boolean customContent) {
		this.customContent = new Boolean(customContent);
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[9];
		values[0] = super.saveState(context);
		values[1] = className;
		values[2] = frameRate;
		values[3] = speed;
		values[4] = horizontal;
		values[5] = autoMode;
		values[6] = pauseOnHover;
		values[7] = jsonSource;
		values[8] = customContent;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.className = (String) values[1];
		this.frameRate = (Integer) values[2];
		this.speed = (Integer) values[3];
		this.horizontal = (Boolean) values[4];
		this.autoMode = (String) values[5];
		this.pauseOnHover = (Boolean) values[6];
		this.jsonSource = (String) values[7];
		this.customContent = (Boolean) values[8];
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