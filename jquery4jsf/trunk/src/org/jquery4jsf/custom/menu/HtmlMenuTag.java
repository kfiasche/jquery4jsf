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

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class HtmlMenuTag extends UIComponentTagBase {

	private String label;
	private String width;
	private String maxHeight;
	private String positionOptsPosX;
	private String positionOptsPosY;
	private String positionOptsOffsetX;
	private String positionOptsOffsetY;
	private String positionOptsDirectionH;
	private String positionOptsDirectionV;
	private String positionOptsDetectH;
	private String positionOptsDetectV;
	private String positionOptsLinkToFront;
	private String showSpeed;
	private String callerOnStateClass;
	private String loadingStateClass;
	private String linkHoverClass;
	private String linkHoverSecondaryClass;
	private String crossSpeed;
	private String crumbDefaultText;
	private String backLink;
	private String backLinkText;
	private String flyOut;
	private String flyOutOnStateClass;
	private String nextMenuLinkClass;
	private String topLinkText;
	private String nextCrumbLinkClass;

	public void release(){
		super.release();
		this.label = null;
		this.width = null;
		this.maxHeight = null;
		this.positionOptsPosX = null;
		this.positionOptsPosY = null;
		this.positionOptsOffsetX = null;
		this.positionOptsOffsetY = null;
		this.positionOptsDirectionH = null;
		this.positionOptsDirectionV = null;
		this.positionOptsDetectH = null;
		this.positionOptsDetectV = null;
		this.positionOptsLinkToFront = null;
		this.showSpeed = null;
		this.callerOnStateClass = null;
		this.loadingStateClass = null;
		this.linkHoverClass = null;
		this.linkHoverSecondaryClass = null;
		this.crossSpeed = null;
		this.crumbDefaultText = null;
		this.backLink = null;
		this.backLinkText = null;
		this.flyOut = null;
		this.flyOutOnStateClass = null;
		this.nextMenuLinkClass = null;
		this.topLinkText = null;
		this.nextCrumbLinkClass = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.menu.HtmlMenu component = null;
		try {
			component = (org.jquery4jsf.custom.menu.HtmlMenu) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "label", label);
		setIntegerProperty(getFacesContext(), component, "width", width);
		setIntegerProperty(getFacesContext(), component, "maxHeight", maxHeight);
		setStringProperty(getFacesContext(), component, "positionOptsPosX", positionOptsPosX);
		setStringProperty(getFacesContext(), component, "positionOptsPosY", positionOptsPosY);
		setIntegerProperty(getFacesContext(), component, "positionOptsOffsetX", positionOptsOffsetX);
		setIntegerProperty(getFacesContext(), component, "positionOptsOffsetY", positionOptsOffsetY);
		setStringProperty(getFacesContext(), component, "positionOptsDirectionH", positionOptsDirectionH);
		setStringProperty(getFacesContext(), component, "positionOptsDirectionV", positionOptsDirectionV);
		setBooleanProperty(getFacesContext(), component, "positionOptsDetectH", positionOptsDetectH);
		setBooleanProperty(getFacesContext(), component, "positionOptsDetectV", positionOptsDetectV);
		setBooleanProperty(getFacesContext(), component, "positionOptsLinkToFront", positionOptsLinkToFront);
		setIntegerProperty(getFacesContext(), component, "showSpeed", showSpeed);
		setStringProperty(getFacesContext(), component, "callerOnStateClass", callerOnStateClass);
		setStringProperty(getFacesContext(), component, "loadingStateClass", loadingStateClass);
		setStringProperty(getFacesContext(), component, "linkHoverClass", linkHoverClass);
		setStringProperty(getFacesContext(), component, "linkHoverSecondaryClass", linkHoverSecondaryClass);
		setIntegerProperty(getFacesContext(), component, "crossSpeed", crossSpeed);
		setStringProperty(getFacesContext(), component, "crumbDefaultText", crumbDefaultText);
		setBooleanProperty(getFacesContext(), component, "backLink", backLink);
		setStringProperty(getFacesContext(), component, "backLinkText", backLinkText);
		setBooleanProperty(getFacesContext(), component, "flyOut", flyOut);
		setStringProperty(getFacesContext(), component, "flyOutOnStateClass", flyOutOnStateClass);
		setStringProperty(getFacesContext(), component, "nextMenuLinkClass", nextMenuLinkClass);
		setStringProperty(getFacesContext(), component, "topLinkText", topLinkText);
		setStringProperty(getFacesContext(), component, "nextCrumbLinkClass", nextCrumbLinkClass);
	}

	public String getComponentType() {
		return HtmlMenu.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.HtmlMenuRenderer";
	}

	public void setLabel(String value){
		this.label = value;
	}

	public void setWidth(String value){
		this.width = value;
	}

	public void setMaxHeight(String value){
		this.maxHeight = value;
	}

	public void setPositionOptsPosX(String value){
		this.positionOptsPosX = value;
	}

	public void setPositionOptsPosY(String value){
		this.positionOptsPosY = value;
	}

	public void setPositionOptsOffsetX(String value){
		this.positionOptsOffsetX = value;
	}

	public void setPositionOptsOffsetY(String value){
		this.positionOptsOffsetY = value;
	}

	public void setPositionOptsDirectionH(String value){
		this.positionOptsDirectionH = value;
	}

	public void setPositionOptsDirectionV(String value){
		this.positionOptsDirectionV = value;
	}

	public void setPositionOptsDetectH(String value){
		this.positionOptsDetectH = value;
	}

	public void setPositionOptsDetectV(String value){
		this.positionOptsDetectV = value;
	}

	public void setPositionOptsLinkToFront(String value){
		this.positionOptsLinkToFront = value;
	}

	public void setShowSpeed(String value){
		this.showSpeed = value;
	}

	public void setCallerOnStateClass(String value){
		this.callerOnStateClass = value;
	}

	public void setLoadingStateClass(String value){
		this.loadingStateClass = value;
	}

	public void setLinkHoverClass(String value){
		this.linkHoverClass = value;
	}

	public void setLinkHoverSecondaryClass(String value){
		this.linkHoverSecondaryClass = value;
	}

	public void setCrossSpeed(String value){
		this.crossSpeed = value;
	}

	public void setCrumbDefaultText(String value){
		this.crumbDefaultText = value;
	}

	public void setBackLink(String value){
		this.backLink = value;
	}

	public void setBackLinkText(String value){
		this.backLinkText = value;
	}

	public void setFlyOut(String value){
		this.flyOut = value;
	}

	public void setFlyOutOnStateClass(String value){
		this.flyOutOnStateClass = value;
	}

	public void setNextMenuLinkClass(String value){
		this.nextMenuLinkClass = value;
	}

	public void setTopLinkText(String value){
		this.topLinkText = value;
	}

	public void setNextCrumbLinkClass(String value){
		this.nextCrumbLinkClass = value;
	}

}