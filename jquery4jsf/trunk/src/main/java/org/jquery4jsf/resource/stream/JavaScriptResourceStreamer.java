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
/*
 * Copyright 2009 Prime Technology.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jquery4jsf.resource.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.faces.FacesException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jquery4jsf.resource.stream.processor.JSMINProcessor;
import org.jquery4jsf.resource.stream.processor.JSProcessor;
import org.jquery4jsf.resource.stream.processor.YUIJSProcessor;
import org.jquery4jsf.utilities.TextUtilities;


public class JavaScriptResourceStreamer implements ResourceStreamer {

	private static final String YUI_COMPRESSOR = "yuicompressor";
	private static String PARAM_JAVASCRIPT_MIN = "org.jquery4jsf.JAVASCRIPT_MIN";
	private static String PARAM_JAVASCRIPT_TYPE = "org.jquery4jsf.JAVASCRIPT_TYPE";
	
	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && mimeType.equals("text/js"));
	}

	public void stream(ServletContext sc, HttpServletRequest request, HttpServletResponse response, InputStream inputStream, URL url) throws IOException {
		String isMin = sc.getInitParameter(PARAM_JAVASCRIPT_MIN);

		if (TextUtilities.getBooleanValue(isMin)){
			String charset = request.getCharacterEncoding();
			if (charset == null) {
				charset = "UTF-8";
			}
			OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), charset);
			JSProcessor jsProcessor = getJSProcessor(sc);
			try {
				jsProcessor.processor(inputStream, writer, request);
			} catch (Exception e) {
			}
		}
		else{
			(new DefaultResourceStreamer()).stream(sc, request, response, inputStream, url);
		}
	}

	private JSProcessor getJSProcessor(ServletContext sc){
		String type = sc.getInitParameter(PARAM_JAVASCRIPT_TYPE);
		if (TextUtilities.isStringVuota(type))
			throw new FacesException("Inserire il parametro "+ PARAM_JAVASCRIPT_TYPE + " nel file web.xml.");
		
		if (type.equalsIgnoreCase(YUI_COMPRESSOR)){
			return new YUIJSProcessor();
		}
		else{
			return new JSMINProcessor();
		}
	}
}
