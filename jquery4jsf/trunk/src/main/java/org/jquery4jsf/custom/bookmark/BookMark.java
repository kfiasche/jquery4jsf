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

public class BookMark extends HtmlBaseOutputComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlBookMark";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.BookMark";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.BookMarkRenderer";

	private String[] resources;
	private String url;
	private String title;
	private String sites;
	private String icons;
	private Integer iconSize;
	private Integer iconCols;
	private String target;
	private Boolean compact;
	private String hint;
	private Boolean popup;
	private String popupText;
	private Boolean addFavorite;
	private String favoriteText;
	private Integer favoriteIcon;
	private Boolean addEmail;
	private String emailText;
	private Integer emailIcon;
	private String emailSubject;
	private String emailBody;
	private String manualBookmark;

	public BookMark() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"bookmaker/jquery.bookmark.js",
			"bookmaker/jquery.bookmark.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getUrl() {
		if(url != null )
			return url;

		String oValue = (String) getLocalOrValueBindingValue(url, "url");
		return oValue != null ? oValue : null;
	}
	public void setUrl(String url) {
		this.url = url;
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

	public String getSites() {
		if(sites != null )
			return sites;

		String oValue = (String) getLocalOrValueBindingValue(sites, "sites");
		return oValue != null ? oValue : null;
	}
	public void setSites(String sites) {
		this.sites = sites;
	}

	public String getIcons() {
		if(icons != null )
			return icons;

		String oValue = (String) getLocalOrValueBindingValue(icons, "icons");
		return oValue != null ? oValue : null;
	}
	public void setIcons(String icons) {
		this.icons = icons;
	}

	public int getIconSize() {
		if(iconSize != null )
			return iconSize.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(iconSize, "iconSize");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setIconSize(int iconSize) {
		this.iconSize = new Integer(iconSize);
	}

	public int getIconCols() {
		if(iconCols != null )
			return iconCols.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(iconCols, "iconCols");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setIconCols(int iconCols) {
		this.iconCols = new Integer(iconCols);
	}

	public String getTarget() {
		if(target != null )
			return target;

		String oValue = (String) getLocalOrValueBindingValue(target, "target");
		return oValue != null ? oValue : null;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public boolean isCompact() {
		if(compact != null )
			return compact.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(compact, "compact");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setCompact(boolean compact) {
		this.compact = new Boolean(compact);
	}

	public String getHint() {
		if(hint != null )
			return hint;

		String oValue = (String) getLocalOrValueBindingValue(hint, "hint");
		return oValue != null ? oValue : null;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}

	public boolean isPopup() {
		if(popup != null )
			return popup.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(popup, "popup");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setPopup(boolean popup) {
		this.popup = new Boolean(popup);
	}

	public String getPopupText() {
		if(popupText != null )
			return popupText;

		String oValue = (String) getLocalOrValueBindingValue(popupText, "popupText");
		return oValue != null ? oValue : null;
	}
	public void setPopupText(String popupText) {
		this.popupText = popupText;
	}

	public boolean isAddFavorite() {
		if(addFavorite != null )
			return addFavorite.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(addFavorite, "addFavorite");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAddFavorite(boolean addFavorite) {
		this.addFavorite = new Boolean(addFavorite);
	}

	public String getFavoriteText() {
		if(favoriteText != null )
			return favoriteText;

		String oValue = (String) getLocalOrValueBindingValue(favoriteText, "favoriteText");
		return oValue != null ? oValue : null;
	}
	public void setFavoriteText(String favoriteText) {
		this.favoriteText = favoriteText;
	}

	public int getFavoriteIcon() {
		if(favoriteIcon != null )
			return favoriteIcon.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(favoriteIcon, "favoriteIcon");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setFavoriteIcon(int favoriteIcon) {
		this.favoriteIcon = new Integer(favoriteIcon);
	}

	public boolean isAddEmail() {
		if(addEmail != null )
			return addEmail.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(addEmail, "addEmail");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setAddEmail(boolean addEmail) {
		this.addEmail = new Boolean(addEmail);
	}

	public String getEmailText() {
		if(emailText != null )
			return emailText;

		String oValue = (String) getLocalOrValueBindingValue(emailText, "emailText");
		return oValue != null ? oValue : null;
	}
	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public int getEmailIcon() {
		if(emailIcon != null )
			return emailIcon.intValue();

		Integer oValue = (Integer) getLocalOrValueBindingValue(emailIcon, "emailIcon");
		return oValue != null ? oValue.intValue()  : 0;
	}
	public void setEmailIcon(int emailIcon) {
		this.emailIcon = new Integer(emailIcon);
	}

	public String getEmailSubject() {
		if(emailSubject != null )
			return emailSubject;

		String oValue = (String) getLocalOrValueBindingValue(emailSubject, "emailSubject");
		return oValue != null ? oValue : null;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		if(emailBody != null )
			return emailBody;

		String oValue = (String) getLocalOrValueBindingValue(emailBody, "emailBody");
		return oValue != null ? oValue : null;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getManualBookmark() {
		if(manualBookmark != null )
			return manualBookmark;

		String oValue = (String) getLocalOrValueBindingValue(manualBookmark, "manualBookmark");
		return oValue != null ? oValue : null;
	}
	public void setManualBookmark(String manualBookmark) {
		this.manualBookmark = manualBookmark;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[21];
		values[0] = super.saveState(context);
		values[1] = url;
		values[2] = title;
		values[3] = sites;
		values[4] = icons;
		values[5] = iconSize;
		values[6] = iconCols;
		values[7] = target;
		values[8] = compact;
		values[9] = hint;
		values[10] = popup;
		values[11] = popupText;
		values[12] = addFavorite;
		values[13] = favoriteText;
		values[14] = favoriteIcon;
		values[15] = addEmail;
		values[16] = emailText;
		values[17] = emailIcon;
		values[18] = emailSubject;
		values[19] = emailBody;
		values[20] = manualBookmark;
		return ((Object) values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.url = (String) values[1];
		this.title = (String) values[2];
		this.sites = (String) values[3];
		this.icons = (String) values[4];
		this.iconSize = (Integer) values[5];
		this.iconCols = (Integer) values[6];
		this.target = (String) values[7];
		this.compact = (Boolean) values[8];
		this.hint = (String) values[9];
		this.popup = (Boolean) values[10];
		this.popupText = (String) values[11];
		this.addFavorite = (Boolean) values[12];
		this.favoriteText = (String) values[13];
		this.favoriteIcon = (Integer) values[14];
		this.addEmail = (Boolean) values[15];
		this.emailText = (String) values[16];
		this.emailIcon = (Integer) values[17];
		this.emailSubject = (String) values[18];
		this.emailBody = (String) values[19];
		this.manualBookmark = (String) values[20];
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