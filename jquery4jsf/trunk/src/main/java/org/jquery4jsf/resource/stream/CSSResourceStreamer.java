/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.jquery4jsf.resource.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jquery4jsf.resource.ResourceCostants;

import com.yahoo.platform.yui.compressor.CssCompressor;


/**
 * Streams css resources
 */
public class CSSResourceStreamer implements ResourceStreamer {

	private static final String PARAM_CSS_MIN = "org.jquery4jsf.CSS_MIN";

	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && mimeType.equals("text/css"));
	}

	public void stream(ServletContext sc, HttpServletRequest request, HttpServletResponse response, InputStream inputStream, URL url) throws IOException {
		
		String param = sc.getInitParameter(PARAM_CSS_MIN);
		if (param != null && Boolean.valueOf(param).booleanValue()){
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String charset = request.getCharacterEncoding();
            if (charset == null) {
                charset = "UTF-8";
            }
            OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), charset);
			String line = null;
			StringBuffer sb = new StringBuffer();
			while (null != (line = reader.readLine())) {
				String parsedLine = replaceRelativeUrl(request.getContextPath(), line);
				sb.append(parsedLine+"\n");
	        }
            int yuiCssLineBreak = -1;
            StringWriter sw = new StringWriter();
            CssCompressor compressor = new CssCompressor(new StringReader(sb.toString()));
            compressor.compress(sw, yuiCssLineBreak);
            writer.write(sw.toString());
			writer.flush();
			writer.close();
		}
		else{
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
	}
	
	public String replaceRelativeUrl(String contextPath, String input) {
        String replacement = contextPath;
        Pattern pattern = Pattern.compile(ResourceCostants.CSS_RESOURCE_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(replacement);
	}
}