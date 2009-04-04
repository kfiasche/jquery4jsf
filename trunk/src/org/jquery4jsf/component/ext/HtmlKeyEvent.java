package org.jquery4jsf.component.ext;

public interface HtmlKeyEvent {

	public void setOnkeydown(String value);
	public void setOnkeypress(String value);
	public void setOnkeyup(String value);

	public String getOnkeydown(); 	
	public String getOnkeypress();
	public String getOnkeyup();  
	
}
