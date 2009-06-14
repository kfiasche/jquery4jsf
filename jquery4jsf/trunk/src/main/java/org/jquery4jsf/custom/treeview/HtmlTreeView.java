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
package org.jquery4jsf.custom.treeview;

import org.jquery4jsf.component.ext.HtmlBaseDataComponent;
import javax.faces.context.FacesContext;
import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;
import org.jquery4jsf.custom.JQueryHtmlObject;
import javax.faces.render.Renderer;
import java.io.IOException;
import javax.faces.el.ValueBinding;
import java.lang.String;
import java.lang.Boolean;
import java.lang.Object;

public class HtmlTreeView extends HtmlBaseDataComponent implements JQueryHtmlObject,AjaxComponent {


	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlTreeView";
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.TreeView";
	public static final String DEFAULT_RENDERER = "org.jquery4jsf.HtmlTreeViewRenderer";

	private String[] resources;
	private Boolean dataAsync;
	private String onAsyncData;
	private String selected;
	private String opened;
	private String cookies;
	private String languages;
	private String path;
	private String uidots;
	private String uirtl;
	private String uianimation;
	private String uihovermode;
	private String uiscrollspd;
	private String uithemepath;
	private String uithemename;

	public HtmlTreeView() {
		setRendererType(DEFAULT_RENDERER);
		 resources = new String[]{
			"jquery/jquery.js",
			"treeview/jquery.tree.js",
			"treeview/jquery.css.js",
			"external/sarissa.js",
			"external/sarissa_ieemu_xpath.js",
			"external/jquery.xslt.js",
			"external/jquery.cookie.js",
			"treeview/jquery.tree.css",
			"themes/base/ui.all.css"
		};
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public boolean isDataAsync() {
		if(dataAsync != null )
			return dataAsync.booleanValue();

		Boolean oValue = (Boolean) getLocalOrValueBindingValue(dataAsync, "dataAsync");
		return oValue != null ? oValue.booleanValue()  : false;
	}
	public void setDataAsync(boolean dataAsync) {
		this.dataAsync = new Boolean(dataAsync);
	}

	public String getOnAsyncData() {
		if(onAsyncData != null )
			return onAsyncData;

		String oValue = (String) getLocalOrValueBindingValue(onAsyncData, "onAsyncData");
		return oValue != null ? oValue : null;
	}
	public void setOnAsyncData(String onAsyncData) {
		this.onAsyncData = onAsyncData;
	}

	public String getSelected() {
		if(selected != null )
			return selected;

		String oValue = (String) getLocalOrValueBindingValue(selected, "selected");
		return oValue != null ? oValue : null;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getOpened() {
		if(opened != null )
			return opened;

		String oValue = (String) getLocalOrValueBindingValue(opened, "opened");
		return oValue != null ? oValue : null;
	}
	public void setOpened(String opened) {
		this.opened = opened;
	}

	public String getCookies() {
		if(cookies != null )
			return cookies;

		String oValue = (String) getLocalOrValueBindingValue(cookies, "cookies");
		return oValue != null ? oValue : null;
	}
	public void setCookies(String cookies) {
		this.cookies = cookies;
	}

	public String getLanguages() {
		if(languages != null )
			return languages;

		String oValue = (String) getLocalOrValueBindingValue(languages, "languages");
		return oValue != null ? oValue : null;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getPath() {
		if(path != null )
			return path;

		String oValue = (String) getLocalOrValueBindingValue(path, "path");
		return oValue != null ? oValue : null;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getUidots() {
		if(uidots != null )
			return uidots;

		String oValue = (String) getLocalOrValueBindingValue(uidots, "uidots");
		return oValue != null ? oValue : null;
	}
	public void setUidots(String uidots) {
		this.uidots = uidots;
	}

	public String getUirtl() {
		if(uirtl != null )
			return uirtl;

		String oValue = (String) getLocalOrValueBindingValue(uirtl, "uirtl");
		return oValue != null ? oValue : null;
	}
	public void setUirtl(String uirtl) {
		this.uirtl = uirtl;
	}

	public String getUianimation() {
		if(uianimation != null )
			return uianimation;

		String oValue = (String) getLocalOrValueBindingValue(uianimation, "uianimation");
		return oValue != null ? oValue : null;
	}
	public void setUianimation(String uianimation) {
		this.uianimation = uianimation;
	}

	public String getUihovermode() {
		if(uihovermode != null )
			return uihovermode;

		String oValue = (String) getLocalOrValueBindingValue(uihovermode, "uihovermode");
		return oValue != null ? oValue : null;
	}
	public void setUihovermode(String uihovermode) {
		this.uihovermode = uihovermode;
	}

	public String getUiscrollspd() {
		if(uiscrollspd != null )
			return uiscrollspd;

		String oValue = (String) getLocalOrValueBindingValue(uiscrollspd, "uiscrollspd");
		return oValue != null ? oValue : null;
	}
	public void setUiscrollspd(String uiscrollspd) {
		this.uiscrollspd = uiscrollspd;
	}

	public String getUithemepath() {
		if(uithemepath != null )
			return uithemepath;

		String oValue = (String) getLocalOrValueBindingValue(uithemepath, "uithemepath");
		return oValue != null ? oValue : null;
	}
	public void setUithemepath(String uithemepath) {
		this.uithemepath = uithemepath;
	}

	public String getUithemename() {
		if(uithemename != null )
			return uithemename;

		String oValue = (String) getLocalOrValueBindingValue(uithemename, "uithemename");
		return oValue != null ? oValue : null;
	}
	public void setUithemename(String uithemename) {
		this.uithemename = uithemename;
	}

	public Object saveState(FacesContext context) {
		Object values[] = new Object[15];
		values[0] = super.saveState(context);
		values[1] = dataAsync;
		values[2] = onAsyncData;
		values[3] = selected;
		values[4] = opened;
		values[5] = cookies;
		values[6] = languages;
		values[7] = path;
		values[8] = uidots;
		values[9] = uirtl;
		values[10] = uianimation;
		values[11] = uihovermode;
		values[12] = uiscrollspd;
		values[13] = uithemepath;
		values[14] = uithemename;
		return (values);
	}
	public void restoreState(FacesContext context, Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(context, values[0]);
		this.dataAsync = (Boolean) values[1];
		this.onAsyncData = (String) values[2];
		this.selected = (String) values[3];
		this.opened = (String) values[4];
		this.cookies = (String) values[5];
		this.languages = (String) values[6];
		this.path = (String) values[7];
		this.uidots = (String) values[8];
		this.uirtl = (String) values[9];
		this.uianimation = (String) values[10];
		this.uihovermode = (String) values[11];
		this.uiscrollspd = (String) values[12];
		this.uithemepath = (String) values[13];
		this.uithemename = (String) values[14];
	}

	public String[] getResources() {
		return resources;
	}

	/*public void broadcast(javax.faces.event.FacesEvent event) throws javax.faces.event.AbortProcessingException {
		super.broadcast(event);
		
		FacesContext context = FacesContext.getCurrentInstance();
		MethodBinding me = null;

		if(event instanceof NodeSelectEvent) {
			me = getTreeNodeSelectListener();
		} else if(event instanceof NodeExpandEvent) {
			me = getTreeNodeExpandListener();
		} else if(event instanceof NodeCollapseEvent) {
			me = getTreeNodeCollapseListener();
		}
		
		if (me != null) {
			me.invoke(context, new Object[] {event});
		}
	}*/

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