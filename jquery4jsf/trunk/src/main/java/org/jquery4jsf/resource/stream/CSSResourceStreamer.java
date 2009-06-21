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
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jquery4jsf.resource.ResourceUtils;
import org.jquery4jsf.resource.stream.processor.CSSProcessor;
import org.jquery4jsf.resource.stream.processor.YUICSSProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CSSResourceStreamer implements ResourceStreamer {

	private static final String PARAM_CSS_MIN = "org.jquery4jsf.CSS_MIN";
	private Logger logger = LoggerFactory.getLogger(CSSResourceStreamer.class);

	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && mimeType.equals("text/css"));
	}

	public void stream(ServletContext sc, HttpServletRequest request, HttpServletResponse response, InputStream inputStream, URL url) throws IOException {
		String param = sc.getInitParameter(PARAM_CSS_MIN);
		if (param != null && Boolean.valueOf(param).booleanValue()){
			String charset = request.getCharacterEncoding();
	        if (charset == null) {
	            charset = "UTF-8";
	        }
	        OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), charset);
	        CSSProcessor cssProcessor = new YUICSSProcessor();
	        try {
				cssProcessor.processor(inputStream, writer, request);
			} catch (Exception e) {
				logger.error("Error into css process compressor: "+e.getMessage());
			}
		}
		else{
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), response.getCharacterEncoding());
			String line = null;
			while (null != (line = reader.readLine())) {
				String parsedLine = ResourceUtils.replaceRelativeUrl(request.getContextPath(), line);
				writer.write(parsedLine+"\n");
	        }
			writer.flush();
			writer.close();
		}
	}
}