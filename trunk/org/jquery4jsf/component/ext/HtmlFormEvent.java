package org.jquery4jsf.component.ext;

public interface HtmlFormEvent extends HtmlElementEvent{


	public void setOnreset(String value);
	public void setOnselect(String value);
	public void setOnsubmit(String value);
	
	public String getOnreset();
	public String getOnselect();
	public String getOnsubmit();
	
}
