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
package org.jquery4jsf.custom.bookmark;

import java.lang.String;
import org.jquery4jsf.taglib.html.ext.UIComponentTagBase;
import javax.faces.component.UIComponent;

public class BookMarkTag extends UIComponentTagBase {

	private String style;
	private String styleClass;
	private String url;
	private String title;
	private String sites;
	private String icons;
	private String iconSize;
	private String iconCols;
	private String target;
	private String compact;
	private String hint;
	private String popup;
	private String popupText;
	private String addFavorite;
	private String favoriteText;
	private String favoriteIcon;
	private String addEmail;
	private String emailText;
	private String emailIcon;
	private String emailSubject;
	private String emailBody;
	private String manualBookmark;

	public void release(){
		super.release();
		this.style = null;
		this.styleClass = null;
		this.url = null;
		this.title = null;
		this.sites = null;
		this.icons = null;
		this.iconSize = null;
		this.iconCols = null;
		this.target = null;
		this.compact = null;
		this.hint = null;
		this.popup = null;
		this.popupText = null;
		this.addFavorite = null;
		this.favoriteText = null;
		this.favoriteIcon = null;
		this.addEmail = null;
		this.emailText = null;
		this.emailIcon = null;
		this.emailSubject = null;
		this.emailBody = null;
		this.manualBookmark = null;
	}

	protected void setProperties(UIComponent comp){
		super.setProperties(comp);

		org.jquery4jsf.custom.bookmark.BookMark component = null;
		try {
			component = (org.jquery4jsf.custom.bookmark.BookMark) comp;
		} catch(ClassCastException cce) {
			throw new IllegalStateException("Component " + component.toString() + " not expected type.");
		}

		setStringProperty(getFacesContext(), component, "style", style);
		setStringProperty(getFacesContext(), component, "styleClass", styleClass);
		setStringProperty(getFacesContext(), component, "url", url);
		setStringProperty(getFacesContext(), component, "title", title);
		setStringProperty(getFacesContext(), component, "sites", sites);
		setStringProperty(getFacesContext(), component, "icons", icons);
		setIntegerProperty(getFacesContext(), component, "iconSize", iconSize);
		setIntegerProperty(getFacesContext(), component, "iconCols", iconCols);
		setStringProperty(getFacesContext(), component, "target", target);
		setBooleanProperty(getFacesContext(), component, "compact", compact);
		setStringProperty(getFacesContext(), component, "hint", hint);
		setBooleanProperty(getFacesContext(), component, "popup", popup);
		setStringProperty(getFacesContext(), component, "popupText", popupText);
		setBooleanProperty(getFacesContext(), component, "addFavorite", addFavorite);
		setStringProperty(getFacesContext(), component, "favoriteText", favoriteText);
		setIntegerProperty(getFacesContext(), component, "favoriteIcon", favoriteIcon);
		setBooleanProperty(getFacesContext(), component, "addEmail", addEmail);
		setStringProperty(getFacesContext(), component, "emailText", emailText);
		setIntegerProperty(getFacesContext(), component, "emailIcon", emailIcon);
		setStringProperty(getFacesContext(), component, "emailSubject", emailSubject);
		setStringProperty(getFacesContext(), component, "emailBody", emailBody);
		setStringProperty(getFacesContext(), component, "manualBookmark", manualBookmark);
	}

	public String getComponentType() {
		return BookMark.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return "org.jquery4jsf.BookMarkRenderer";
	}

	public void setStyle(String value){
		this.style = value;
	}

	public void setStyleClass(String value){
		this.styleClass = value;
	}

	public void setUrl(String value){
		this.url = value;
	}

	public void setTitle(String value){
		this.title = value;
	}

	public void setSites(String value){
		this.sites = value;
	}

	public void setIcons(String value){
		this.icons = value;
	}

	public void setIconSize(String value){
		this.iconSize = value;
	}

	public void setIconCols(String value){
		this.iconCols = value;
	}

	public void setTarget(String value){
		this.target = value;
	}

	public void setCompact(String value){
		this.compact = value;
	}

	public void setHint(String value){
		this.hint = value;
	}

	public void setPopup(String value){
		this.popup = value;
	}

	public void setPopupText(String value){
		this.popupText = value;
	}

	public void setAddFavorite(String value){
		this.addFavorite = value;
	}

	public void setFavoriteText(String value){
		this.favoriteText = value;
	}

	public void setFavoriteIcon(String value){
		this.favoriteIcon = value;
	}

	public void setAddEmail(String value){
		this.addEmail = value;
	}

	public void setEmailText(String value){
		this.emailText = value;
	}

	public void setEmailIcon(String value){
		this.emailIcon = value;
	}

	public void setEmailSubject(String value){
		this.emailSubject = value;
	}

	public void setEmailBody(String value){
		this.emailBody = value;
	}

	public void setManualBookmark(String value){
		this.manualBookmark = value;
	}

}