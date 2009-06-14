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
package org.jquery4jsf.custom.menu;

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

public class HtmlMenu extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlMenu";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Menu";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.HtmlMenuRenderer";

	private String[] resources;
	private String label;
	private Integer width;
	private Integer maxHeight;
	private String positionOptsPosX;
	private String positionOptsPosY;
	private Integer positionOptsOffsetX;
	private Integer positionOptsOffsetY;
	private String positionOptsDirectionH;
	private String positionOptsDirectionV;
	private Boolean positionOptsDetectH;
	private Boolean positionOptsDetectV;
	private Boolean positionOptsLinkToFront;
	private Integer showSpeed;
	private String callerOnStateClass;
	private String loadingStateClass;
	private String linkHoverClass;
	private String linkHoverSecondaryClass;
	private Integer crossSpeed;
	private String crumbDefaultText;
	private Boolean backLink;
	private String backLinkText;
	private Boolean flyOut;
	private String flyOutOnStateClass;
	private String nextMenuLinkClass;
	private String topLinkText;
	private String nextCrumbLinkClass;

	public HtmlMenu() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"form/jquery.form.js",
			"menu/fg.menu.js",
			"menu/fg.menu.css",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getLabel() {
		if(label != null )
			return label;

		String oValue = (String) getLocalOrValueBindingValue(label, "label");
		return oValue != null ? oValue : null;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public int getWidth() {
		if(width != null )
			return width.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(width, "width");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setWidth(int width) {
		this.width = new Integer(width);
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

	public String getPositionOptsPosX() {
		if(positionOptsPosX != null )
			return positionOptsPosX;

		String oValue = (String) getLocalOrValueBindingValue(positionOptsPosX, "positionOptsPosX");
		return oValue != null ? oValue : null;
	}
	public void setPositionOptsPosX(String positionOptsPosX) {
		this.positionOptsPosX = positionOptsPosX;
	}

	public String getPositionOptsPosY() {
		if(positionOptsPosY != null )
			return positionOptsPosY;

		String oValue = (String) getLocalOrValueBindingValue(positionOptsPosY, "positionOptsPosY");
		return oValue != null ? oValue : null;
	}
	public void setPositionOptsPosY(String positionOptsPosY) {
		this.positionOptsPosY = positionOptsPosY;
	}

	public int getPositionOptsOffsetX() {
		if(positionOptsOffsetX != null )
			return positionOptsOffsetX.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(positionOptsOffsetX, "positionOptsOffsetX");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setPositionOptsOffsetX(int positionOptsOffsetX) {
		this.positionOptsOffsetX = new Integer(positionOptsOffsetX);
	}

	public int getPositionOptsOffsetY() {
		if(positionOptsOffsetY != null )
			return positionOptsOffsetY.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(positionOptsOffsetY, "positionOptsOffsetY");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setPositionOptsOffsetY(int positionOptsOffsetY) {
		this.positionOptsOffsetY = new Integer(positionOptsOffsetY);
	}

	public String getPositionOptsDirectionH() {
		if(positionOptsDirectionH != null )
			return positionOptsDirectionH;

		String oValue = (String) getLocalOrValueBindingValue(positionOptsDirectionH, "positionOptsDirectionH");
		return oValue != null ? oValue : null;
	}
	public void setPositionOptsDirectionH(String positionOptsDirectionH) {
		this.positionOptsDirectionH = positionOptsDirectionH;
	}

	public String getPositionOptsDirectionV() {
		if(positionOptsDirectionV != null )
			return positionOptsDirectionV;

		String oValue = (String) getLocalOrValueBindingValue(positionOptsDirectionV, "positionOptsDirectionV");
		return oValue != null ? oValue : null;
	}
	public void setPositionOptsDirectionV(String positionOptsDirectionV) {
		this.positionOptsDirectionV = positionOptsDirectionV;
	}

	public boolean isPositionOptsDetectH() {
		if(positionOptsDetectH != null )
			return positionOptsDetectH.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(positionOptsDetectH, "positionOptsDetectH");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setPositionOptsDetectH(boolean positionOptsDetectH) {
		this.positionOptsDetectH = new Boolean(positionOptsDetectH);
	}

	public boolean isPositionOptsDetectV() {
		if(positionOptsDetectV != null )
			return positionOptsDetectV.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(positionOptsDetectV, "positionOptsDetectV");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setPositionOptsDetectV(boolean positionOptsDetectV) {
		this.positionOptsDetectV = new Boolean(positionOptsDetectV);
	}

	public boolean isPositionOptsLinkToFront() {
		if(positionOptsLinkToFront != null )
			return positionOptsLinkToFront.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(positionOptsLinkToFront, "positionOptsLinkToFront");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setPositionOptsLinkToFront(boolean positionOptsLinkToFront) {
		this.positionOptsLinkToFront = new Boolean(positionOptsLinkToFront);
	}

	public int getShowSpeed() {
		if(showSpeed != null )
			return showSpeed.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(showSpeed, "showSpeed");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setShowSpeed(int showSpeed) {
		this.showSpeed = new Integer(showSpeed);
	}

	public String getCallerOnStateClass() {
		if(callerOnStateClass != null )
			return callerOnStateClass;

		String oValue = (String) getLocalOrValueBindingValue(callerOnStateClass, "callerOnStateClass");
		return oValue != null ? oValue : null;
	}
	public void setCallerOnStateClass(String callerOnStateClass) {
		this.callerOnStateClass = callerOnStateClass;
	}

	public String getLoadingStateClass() {
		if(loadingStateClass != null )
			return loadingStateClass;

		String oValue = (String) getLocalOrValueBindingValue(loadingStateClass, "loadingStateClass");
		return oValue != null ? oValue : null;
	}
	public void setLoadingStateClass(String loadingStateClass) {
		this.loadingStateClass = loadingStateClass;
	}

	public String getLinkHoverClass() {
		if(linkHoverClass != null )
			return linkHoverClass;

		String oValue = (String) getLocalOrValueBindingValue(linkHoverClass, "linkHoverClass");
		return oValue != null ? oValue : null;
	}
	public void setLinkHoverClass(String linkHoverClass) {
		this.linkHoverClass = linkHoverClass;
	}

	public String getLinkHoverSecondaryClass() {
		if(linkHoverSecondaryClass != null )
			return linkHoverSecondaryClass;

		String oValue = (String) getLocalOrValueBindingValue(linkHoverSecondaryClass, "linkHoverSecondaryClass");
		return oValue != null ? oValue : null;
	}
	public void setLinkHoverSecondaryClass(String linkHoverSecondaryClass) {
		this.linkHoverSecondaryClass = linkHoverSecondaryClass;
	}

	public int getCrossSpeed() {
		if(crossSpeed != null )
			return crossSpeed.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(crossSpeed, "crossSpeed");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setCrossSpeed(int crossSpeed) {
		this.crossSpeed = new Integer(crossSpeed);
	}

	public String getCrumbDefaultText() {
		if(crumbDefaultText != null )
			return crumbDefaultText;

		String oValue = (String) getLocalOrValueBindingValue(crumbDefaultText, "crumbDefaultText");
		return oValue != null ? oValue : null;
	}
	public void setCrumbDefaultText(String crumbDefaultText) {
		this.crumbDefaultText = crumbDefaultText;
	}

	public boolean isBackLink() {
		if(backLink != null )
			return backLink.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(backLink, "backLink");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setBackLink(boolean backLink) {
		this.backLink = new Boolean(backLink);
	}

	public String getBackLinkText() {
		if(backLinkText != null )
			return backLinkText;

		String oValue = (String) getLocalOrValueBindingValue(backLinkText, "backLinkText");
		return oValue != null ? oValue : null;
	}
	public void setBackLinkText(String backLinkText) {
		this.backLinkText = backLinkText;
	}

	public boolean isFlyOut() {
		if(flyOut != null )
			return flyOut.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(flyOut, "flyOut");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setFlyOut(boolean flyOut) {
		this.flyOut = new Boolean(flyOut);
	}

	public String getFlyOutOnStateClass() {
		if(flyOutOnStateClass != null )
			return flyOutOnStateClass;

		String oValue = (String) getLocalOrValueBindingValue(flyOutOnStateClass, "flyOutOnStateClass");
		return oValue != null ? oValue : null;
	}
	public void setFlyOutOnStateClass(String flyOutOnStateClass) {
		this.flyOutOnStateClass = flyOutOnStateClass;
	}

	public String getNextMenuLinkClass() {
		if(nextMenuLinkClass != null )
			return nextMenuLinkClass;

		String oValue = (String) getLocalOrValueBindingValue(nextMenuLinkClass, "nextMenuLinkClass");
		return oValue != null ? oValue : null;
	}
	public void setNextMenuLinkClass(String nextMenuLinkClass) {
		this.nextMenuLinkClass = nextMenuLinkClass;
	}

	public String getTopLinkText() {
		if(topLinkText != null )
			return topLinkText;

		String oValue = (String) getLocalOrValueBindingValue(topLinkText, "topLinkText");
		return oValue != null ? oValue : null;
	}
	public void setTopLinkText(String topLinkText) {
		this.topLinkText = topLinkText;
	}

	public String getNextCrumbLinkClass() {
		if(nextCrumbLinkClass != null )
			return nextCrumbLinkClass;

		String oValue = (String) getLocalOrValueBindingValue(nextCrumbLinkClass, "nextCrumbLinkClass");
		return oValue != null ? oValue : null;
	}
	public void setNextCrumbLinkClass(String nextCrumbLinkClass) {
		this.nextCrumbLinkClass = nextCrumbLinkClass;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[27];
		values[0] = super.saveState(context);
		values[1] = label;
		values[2] = width;
		values[3] = maxHeight;
		values[4] = positionOptsPosX;
		values[5] = positionOptsPosY;
		values[6] = positionOptsOffsetX;
		values[7] = positionOptsOffsetY;
		values[8] = positionOptsDirectionH;
		values[9] = positionOptsDirectionV;
		values[10] = positionOptsDetectH;
		values[11] = positionOptsDetectV;
		values[12] = positionOptsLinkToFront;
		values[13] = showSpeed;
		values[14] = callerOnStateClass;
		values[15] = loadingStateClass;
		values[16] = linkHoverClass;
		values[17] = linkHoverSecondaryClass;
		values[18] = crossSpeed;
		values[19] = crumbDefaultText;
		values[20] = backLink;
		values[21] = backLinkText;
		values[22] = flyOut;
		values[23] = flyOutOnStateClass;
		values[24] = nextMenuLinkClass;
		values[25] = topLinkText;
		values[26] = nextCrumbLinkClass;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.label = (String) values[1];
		this.width = (Integer) values[2];
		this.maxHeight = (Integer) values[3];
		this.positionOptsPosX = (String) values[4];
		this.positionOptsPosY = (String) values[5];
		this.positionOptsOffsetX = (Integer) values[6];
		this.positionOptsOffsetY = (Integer) values[7];
		this.positionOptsDirectionH = (String) values[8];
		this.positionOptsDirectionV = (String) values[9];
		this.positionOptsDetectH = (Boolean) values[10];
		this.positionOptsDetectV = (Boolean) values[11];
		this.positionOptsLinkToFront = (Boolean) values[12];
		this.showSpeed = (Integer) values[13];
		this.callerOnStateClass = (String) values[14];
		this.loadingStateClass = (String) values[15];
		this.linkHoverClass = (String) values[16];
		this.linkHoverSecondaryClass = (String) values[17];
		this.crossSpeed = (Integer) values[18];
		this.crumbDefaultText = (String) values[19];
		this.backLink = (Boolean) values[20];
		this.backLinkText = (String) values[21];
		this.flyOut = (Boolean) values[22];
		this.flyOutOnStateClass = (String) values[23];
		this.nextMenuLinkClass = (String) values[24];
		this.topLinkText = (String) values[25];
		this.nextCrumbLinkClass = (String) values[26];
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