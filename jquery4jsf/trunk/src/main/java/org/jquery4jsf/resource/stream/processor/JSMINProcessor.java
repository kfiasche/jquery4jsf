package org.jquery4jsf.resource.stream.processor;

import java.io.InputStream;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.resource.stream.jsmin.JSMin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSMINProcessor  implements JSProcessor {
	
	private Logger logger = LoggerFactory.getLogger(JSMINProcessor.class);
	public void processor(InputStream in, Writer out, HttpServletRequest request) throws Exception {
		try {
			JSMin jsmin = new JSMin(in,out);
			jsmin.jsmin();
		} catch (Exception e) {
			logger.error("Error send script to client for resource ", e);
		} finally {
			in.close();
			out.flush();
			out.close();
		}
		
	}

	
	
}
