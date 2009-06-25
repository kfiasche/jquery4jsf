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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;

import javax.faces.FacesException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jquery4jsf.resource.stream.jsmin.JSMin;
import org.jquery4jsf.resource.stream.processor.JSMINProcessor;
import org.jquery4jsf.resource.stream.processor.JSProcessor;
import org.jquery4jsf.resource.stream.processor.YUIJSProcessor;
import org.jquery4jsf.utilities.TextUtilities;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yahoo.platform.yui.compressor.JavaScriptCompressor;


public class JavaScriptResourceStreamer implements ResourceStreamer {

	private static String PARAM_JAVASCRIPT_MIN = "org.jquery4jsf.JAVASCRIPT_MIN";
	private static String PARAM_JAVASCRIPT_TYPE = "org.jquery4jsf.JAVASCRIPT_TYPE";
	
	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && mimeType.equals("text/js"));
	}

	public void stream(ServletContext sc, HttpServletRequest request, HttpServletResponse response, InputStream inputStream, URL url) throws IOException {
		String isMin = sc.getInitParameter(PARAM_JAVASCRIPT_MIN);
		String type = sc.getInitParameter(PARAM_JAVASCRIPT_TYPE);
		if (TextUtilities.getBooleanValue(isMin)){
			if (TextUtilities.isStringVuota(type))
				throw new FacesException("Inserire il parametro "+ PARAM_JAVASCRIPT_TYPE + " nel file web.xml.");
			
			String charset = request.getCharacterEncoding();
			if (charset == null) {
				charset = "UTF-8";
			}
			OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), charset);
			if (type.equalsIgnoreCase("yuicompressor")){
				try {
					JSProcessor jsProcessor = new YUIJSProcessor();
					jsProcessor.processor(inputStream, writer, request);
				} catch (Exception e) {
				}
			}
			else {
				try {
					JSProcessor jsProcessor = new JSMINProcessor();
					jsProcessor.processor(inputStream, writer, request);
				} catch (Exception e) {
				}
			}
		}
		else{
			(new DefaultResourceStreamer()).stream(sc, request, response, inputStream, url);
		}
	}

	
}
