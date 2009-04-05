package org.jquery4jsf.resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jquery4jsf.resource.stream.CSSResourceStreamer;
import org.jquery4jsf.resource.stream.DefaultResourceStreamer;
import org.jquery4jsf.resource.stream.ResourceStreamer;


public class ResourceServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6036011231753381431L;
	private static Map mimeTypes;
	private List resourceStreamers;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		initMimeTypes();
		initResourceStreamers();
	}

	private void initMimeTypes() {
		mimeTypes = new HashMap();
		mimeTypes.put("css", "text/css");
		mimeTypes.put("js", "text/js");
		mimeTypes.put("jpg", "image/jpeg");
		mimeTypes.put("jpeg", "image/jpeg");
		mimeTypes.put("png", "image/png");
		mimeTypes.put("gif", "image/gif");
		mimeTypes.put("swf", "application/x-shockwave-flash");
	}
	
	private void initResourceStreamers() {
		resourceStreamers = new ArrayList();
		resourceStreamers.add(new DefaultResourceStreamer());
		resourceStreamers.add(new CSSResourceStreamer());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resourcePath = ResourceUtils.RESOURCE_FOLDER + getResourcePath(req.getRequestURI());
		String mimeType = getResourceContentType(resourcePath);
	    try {
	        InputStream inputStream = ResourceServlet.class.getResourceAsStream(resourcePath);
	        URL url = ResourceServlet.class.getResource(resourcePath);
	        if(url == null) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
	        resp.setContentType(mimeType);
	        resp.setStatus(200);
	        setCaching(resp);
	        streamResource(req, resp, mimeType, inputStream);
	    }
	    catch (Exception e) {
	    }
	}

	private void streamResource(HttpServletRequest req, HttpServletResponse resp, String mimeType, InputStream inputStream) throws IOException {
		for (Iterator iterator = resourceStreamers.iterator(); iterator.hasNext();) {
			ResourceStreamer resourceStreamer = (ResourceStreamer) iterator.next();
			if(resourceStreamer.isAppropriateStreamer(mimeType))
				resourceStreamer.stream(req, resp, inputStream);
		}
	}
	
	private void setCaching(HttpServletResponse response) {
		long now = System.currentTimeMillis();
		long oneYear = 31363200000L;
		response.setHeader("Cache-Control", "Public");
		response.setDateHeader("Expires", now + oneYear);
	}

	protected String getResourcePath(String requestURI) {
		int patternIndex = requestURI.indexOf(ResourceUtils.RESOURCE_PATTERN);
		return requestURI.substring(patternIndex + ResourceUtils.RESOURCE_PATTERN.length(), requestURI.length());
	}
	
	protected String getResourceContentType(String resourcePath) {
		String resourceFileExtension = getResourceFileExtension(resourcePath);
		return (String) mimeTypes.get(resourceFileExtension);
	}
	
	protected String getResourceFileExtension(String resourcePath) {
		String parsed[] = resourcePath.split("\\.");
		return parsed[parsed.length -1];
	}
}