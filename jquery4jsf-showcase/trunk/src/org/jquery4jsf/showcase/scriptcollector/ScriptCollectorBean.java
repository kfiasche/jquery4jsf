/**
 * 
 */
package org.jquery4jsf.showcase.scriptcollector;

import javax.faces.context.FacesContext;

/**
 * @author Administrator
 *
 */
public class ScriptCollectorBean {
	public ScriptCollectorBean() {
	}
	private String loadText = "Befor Loaded";
	private String postText = "Befor post";
	
	
	public String getLoadText() {
		return loadText;
	}
	public void setLoadText(String loadText) {
		this.loadText = loadText;
	}
	public void onPageLoad(FacesContext context){
		loadText = "It's loaded begin!";
	}
	public void onPageLoadEnd(FacesContext context){
		loadText = "It's loaded end!";
	}
	public void onPagePost(FacesContext context){
		postText = "It's loaded post!";
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}

}
