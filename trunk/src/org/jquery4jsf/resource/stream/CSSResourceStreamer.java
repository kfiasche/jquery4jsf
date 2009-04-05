package org.jquery4jsf.resource.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jquery4jsf.resource.ResourceUtils;

/**
 * Streams css resources
 */
public class CSSResourceStreamer implements ResourceStreamer {

	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && mimeType.equals("text/css"));
	}

	public void stream(HttpServletRequest request, HttpServletResponse response, InputStream inputStream) throws IOException {
		System.out.println("request_css: "+request.getRequestURI());
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), response.getCharacterEncoding());
		String line = null;
		
		while (null != (line = reader.readLine())) {
			String parsedLine = replaceRelativeUrl(request.getContextPath(), line);
			writer.write(parsedLine+"\n");
        }
		
		writer.flush();
		writer.close();
	}
	
	public String replaceRelativeUrl(String contextPath, String input) {
        String replacement = contextPath;
        Pattern pattern = Pattern.compile(ResourceUtils.CSS_RESOURCE_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(replacement);
	}
}