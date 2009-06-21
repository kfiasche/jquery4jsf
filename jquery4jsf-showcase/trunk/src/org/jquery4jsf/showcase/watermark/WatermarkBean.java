/**
 * 
 */
package org.jquery4jsf.showcase.watermark;

import javax.faces.event.ActionEvent;

/**
 * @author Administrator
 *
 */
public class WatermarkBean {
	private String username;
	private String password;
	private String msg;
	private String show;
	
	
	public void actionListener(ActionEvent actionEvent){
		if (getUsername() != null 
				&& getUsername().equalsIgnoreCase("totti")
				&& getPassword() != null
				&& getPassword().equalsIgnoreCase("francesco")){
			msg = "Logged!!!";
		}
		else{
			msg = "Invalid username or password.";
		}
	}
	
	public WatermarkBean() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getShow() {
		if (getMsg() == null || getMsg().equalsIgnoreCase(""))
		{
			return "display: none;";
		}
		else{
			return  "display: block;";
		}
	}

	public void setShow(String show) {
		this.show = show;
	}
}
