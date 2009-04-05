package org.jquery4jsf.resource.stream;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ResourceStreamer {

	public void stream(HttpServletRequest request, HttpServletResponse response, InputStream inputStream) throws IOException;

	public boolean isAppropriateStreamer(String mimeType);
}
