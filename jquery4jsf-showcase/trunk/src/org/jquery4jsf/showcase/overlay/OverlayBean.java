/**
 * 
 */
package org.jquery4jsf.showcase.overlay;

import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 *
 */
public class OverlayBean {
	private Logger logger = LoggerFactory.getLogger(OverlayBean.class);
	public OverlayBean() {
	}
	
	public void actionListener(ActionEvent actionEvent){
		for (int i = 0; i < 100000; i++) {
			//logger.error(Integer.toString(i));
		}
	}
}
