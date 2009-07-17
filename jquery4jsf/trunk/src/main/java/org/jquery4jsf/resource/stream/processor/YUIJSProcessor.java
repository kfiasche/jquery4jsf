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
package org.jquery4jsf.resource.stream.processor;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.EvaluatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yahoo.platform.yui.compressor.JavaScriptCompressor;

public class YUIJSProcessor implements JSProcessor {
	
	private final static int LINE_BREAK_POS = 1000;
	private Logger logger = LoggerFactory.getLogger(YUIJSProcessor.class);
	
	public void processor(InputStream in, Writer out, HttpServletRequest request) throws Exception {
		Reader reader = new InputStreamReader(in);
		try {
			JavaScriptCompressor compressor = new JavaScriptCompressor(reader, new ErrorReporter() {
				public void warning(String message, String sourceName,
						int line, String lineSource, int lineOffset) {
					logger.warn("[JAVASCRIPT COMPRESSOR WARN] in file : "+sourceName+"\n"+message+"\n"+line+":"+lineOffset);
				}

				public void error(String message, String sourceName,
						int line, String lineSource, int lineOffset) {
					logger.error("[JAVASCRIPT COMPRESSOR ERROR] in file : "+sourceName+"\nLine : "+lineSource+"\n"+message+"\n"+line+":"+lineOffset);
				}

				public EvaluatorException runtimeError(String message, String sourceName,
						int line, String lineSource, int lineOffset) {
					error(message, sourceName, line, lineSource, lineOffset);
					return new EvaluatorException(message);
				}
			});

			compressor.compress(out, LINE_BREAK_POS, true, true,true, true);

		} catch (Exception e) {
			logger.error("Error send script to client for resource ", e);
		}		
	}
}
