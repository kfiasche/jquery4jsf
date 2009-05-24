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

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;

import com.yahoo.platform.yui.compressor.JavaScriptCompressor;


public class JavaScriptResourceStreamer implements ResourceStreamer {

	private static String PARAM_JAVASCRIPT_MIN = "org.jquery4jsf.JAVASCRIPT_MIN";
	
	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && mimeType.equals("text/js"));
	}

	public void stream(ServletContext sc, HttpServletRequest request, HttpServletResponse response, InputStream inputStream, URL url) throws IOException {
		String param = sc.getInitParameter(PARAM_JAVASCRIPT_MIN);
		if (param != null && Boolean.valueOf(param).booleanValue()){
			try {
				String charset = request.getCharacterEncoding();
				if (charset == null) {
				    charset = "UTF-8";
				}
				OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), charset);
				Reader in = new InputStreamReader(inputStream, charset);
				JavaScriptCompressor javaScriptCompressor = new JavaScriptCompressor(in, new ErrorReporter() {

				    public void warning(String message, String sourceName,
				            int line, String lineSource, int lineOffset) {
				        if (line < 0) {
				            System.err.println("\n[WARNING] " + message);
				        } else {
				            System.err.println("\n[WARNING] " + line + ':' + lineOffset + ':' + message);
				        }
				    }

				    public void error(String message, String sourceName,
				            int line, String lineSource, int lineOffset) {
				        if (line < 0) {
				            System.err.println("\n[ERROR] " + message);
				        } else {
				            System.err.println("\n[ERROR] " + line + ':' + lineOffset + ':' + message);
				        }
				    }

				    public EvaluatorException runtimeError(String message, String sourceName,
				            int line, String lineSource, int lineOffset) {
				        error(message, sourceName, line, lineSource, lineOffset);
				        return new EvaluatorException(message);
				    }
				});
				
				in.close(); in = null;

				//YUICompressor settings
				boolean yuiJsNoMunge = false;
				boolean yuiJsPreserveAllSemiColons = true;
				boolean yuiJsDisableOptimizations = true;
				int yuiJsLineBreak = -1;
				
				StringWriter sw = new StringWriter();
				javaScriptCompressor.compress(sw, yuiJsLineBreak, yuiJsNoMunge, false, yuiJsPreserveAllSemiColons, yuiJsDisableOptimizations);
				writer.write(sw.toString());
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			(new DefaultResourceStreamer()).stream(sc, request, response, inputStream, url);
		}
	}

}
