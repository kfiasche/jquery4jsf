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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;

import javax.faces.FacesException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jquery4jsf.resource.stream.jsmin.JSMin;
import org.jquery4jsf.utilities.TextUtilities;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yahoo.platform.yui.compressor.JavaScriptCompressor;


public class JavaScriptResourceStreamer implements ResourceStreamer {

	private static String PARAM_JAVASCRIPT_MIN = "org.jquery4jsf.JAVASCRIPT_MIN";
	private static String PARAM_JAVASCRIPT_TYPE = "org.jquery4jsf.JAVASCRIPT_TYPE";
	private Logger logger = LoggerFactory.getLogger(JavaScriptResourceStreamer.class);
	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && mimeType.equals("text/js"));
	}

	public void stream(ServletContext sc, HttpServletRequest request, HttpServletResponse response, InputStream inputStream, URL url) throws IOException {
		String isMin = sc.getInitParameter(PARAM_JAVASCRIPT_MIN);
		String type = sc.getInitParameter(PARAM_JAVASCRIPT_TYPE);
		if (TextUtilities.getBooleanValue(isMin)){
			if (TextUtilities.isStringVuota(type))
				throw new FacesException("Inserire il parametro "+ PARAM_JAVASCRIPT_TYPE + " nel file web.xml.");

			if (type.equalsIgnoreCase("yuicompressor")){
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
								logger.error("\n[WARNING] " + message);
							} else {
								logger.error("\n[WARNING] " + line + ':' + lineOffset + ':' + message);
							}
						}

						public void error(String message, String sourceName,
								int line, String lineSource, int lineOffset) {
							if (line < 0) {
								logger.error("\n[ERROR] " + message);
							} else {
								logger.error("\n[ERROR] " + line + ':' + lineOffset + ':' + message);
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
					logger.error("Error send script to client for resource "+url.getFile(), e);
				}
			}
			else {
                CountingOutputStream countingStream = new CountingOutputStream(response.getOutputStream());
                JSMin jsmin = new JSMin(inputStream,countingStream);
                try {
                        jsmin.jsmin();
                } catch (Exception e) {
                	logger.error("Error send script to client for resource "+url.getFile(), e);
                } finally {
                		inputStream.close();
                        countingStream.flush();
                        countingStream.close();
                }
                int written = countingStream.getWritten();
                if(logger.isDebugEnabled()){
                	logger.debug("Send "+written+" bytes to client for JavaScript resource "+url.getFile());
                }
			}
		}
		else{
			(new DefaultResourceStreamer()).stream(sc, request, response, inputStream, url);
		}
	}

	class CountingOutputStream extends OutputStream {
        private OutputStream outputStream;
        private int written = 0;

        CountingOutputStream(OutputStream outputStream) {
                super();
                this.outputStream = outputStream;
        }

        public void close() throws IOException {
                outputStream.close();
        }

        public void flush() throws IOException {
                outputStream.flush();
        }

        public void write(byte[] b, int off, int len) throws IOException {
                outputStream.write(b, off, len);
                written += len;
        }

        public void write(byte[] b) throws IOException {
                outputStream.write(b);
                written += b.length;
        }

        public void write(int b) throws IOException {
                outputStream.write(b);
                written++;
        }

        int getWritten() {
                return written;
        }
}

	
}
