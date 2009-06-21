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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.jquery4jsf.resource.ResourceUtils;

import com.yahoo.platform.yui.compressor.CssCompressor;

public class YUICSSProcessor implements CSSProcessor {

	public void processor(InputStream in, Writer writer, HttpServletRequest request) throws Exception {	
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while (null != (line = reader.readLine())) {
			String parsedLine = ResourceUtils.replaceRelativeUrl(request.getContextPath(), line);
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
}
