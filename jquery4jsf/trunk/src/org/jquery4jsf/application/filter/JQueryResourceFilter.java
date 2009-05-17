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
package org.jquery4jsf.application.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.jquery4jsf.resource.ResourceContext;
import org.xml.sax.InputSource;

public final class JQueryResourceFilter implements Filter {

	private static final String HEAD_SEARCH_PATTERN = "<title>";
	private static final String END_TAG_CHAR_SEARCH_PATTERN = "</title>";
	private static final Pattern HEAD_PATTERN = Pattern.compile(HEAD_SEARCH_PATTERN, Pattern.CASE_INSENSITIVE);
	private static final Pattern END_TAG_CHAR_PATTERN = Pattern.compile(END_TAG_CHAR_SEARCH_PATTERN, Pattern.CASE_INSENSITIVE);

	private FilterConfig _filterConfig;

	public void init(FilterConfig filterConfig) throws ServletException {
		_filterConfig = filterConfig;
	}

	public void destroy() {
		_filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (isNotAjaxCall(httpRequest)) {
			JQueryResponseWrapper jQueryResponseWrapper = new JQueryResponseWrapper(httpResponse);
			chain.doFilter(request, jQueryResponseWrapper);
			jQueryResponseWrapper.finishResponse();
			if (jQueryResponseWrapper.getContentType() != null 
					&& isValidContentType(jQueryResponseWrapper.getContentType())){
				String[] requestURISplitted = httpRequest.getRequestURI().split("/");
				ResourceContext resourceContext = ResourceContext.getInstance();
				Matcher headMatcher = HEAD_PATTERN.matcher(jQueryResponseWrapper.toString());
				boolean headMatchedBoolean = headMatcher.find();
				PrintWriter printerWriter = httpResponse.getWriter();
				if (headMatchedBoolean) {
					int headMatchIndex = headMatcher.start();
					String befor = jQueryResponseWrapper.toString().substring(0, headMatchIndex + 7);
					printerWriter.write(befor);
					Matcher endTagCharMatcher = END_TAG_CHAR_PATTERN.matcher(jQueryResponseWrapper.toString());
					endTagCharMatcher.find(headMatchIndex);
					int endTagCharIndex = endTagCharMatcher.start();
					String after = jQueryResponseWrapper.toString().substring(headMatchIndex + 7, endTagCharIndex + 8);
					printerWriter.write(after);
					Collection resourceCollection = resourceContext.getResources();
					String resourceConvertedToScriptElements = constructResourceToScriptTags(resourceCollection, requestURISplitted);
					printerWriter.write(resourceConvertedToScriptElements);
					printerWriter.write(jQueryResponseWrapper.toString().substring(endTagCharIndex + 8));
				} 
				printerWriter.flush();
				resourceContext.release();
			}
		}
		else{
			chain.doFilter(request, response);
		}
	}



	private boolean isNotAjaxCall(HttpServletRequest request) {
		if (request.getParameter("ajaxSourceJQuery") != null){
			return false;
		}
		return true;
	}

	private String constructResourceToScriptTags(Collection resources, String[] requestURI) {
		StringBuffer scriptElements = new StringBuffer();
		String webProjectName = null;
		if (requestURI.length == 2){
			webProjectName = requestURI[0];
		}
		else 
		{
			webProjectName = (requestURI.length < 2) ? requestURI[0] : requestURI[1];
		}
		scriptElements.append("\n");
		for (Iterator iterate = resources.iterator(); iterate.hasNext();) {
			String resource = (String) iterate.next();
			if (resource.endsWith(".js")){
				scriptElements.append("<script type=\"text/javascript\" src=\"/");
				if (!(webProjectName == null || webProjectName.trim().length() ==0)){
					scriptElements.append(webProjectName);
					scriptElements.append("/");
				}
				scriptElements.append("jquery4jsf_resource");
				scriptElements.append("/");
				scriptElements.append(resource);
				scriptElements.append("\"></script>\n");
			}
			else if (resource.endsWith(".css")){
				scriptElements.append("<link  type=\"text/css\" href=\"/");
				if (!(webProjectName == null || webProjectName.trim().length() ==0)){
					scriptElements.append(webProjectName);
					scriptElements.append("/");
				}
				scriptElements.append("jquery4jsf_resource");
				scriptElements.append("/");
				scriptElements.append(resource);
				scriptElements.append("\" "); 
				scriptElements.append("rel=\"stylesheet\" />\n");
			}
		}
		return scriptElements.toString();
	}

	private boolean isValidContentType(String contentType) {
		return contentType.startsWith("text/html")
				|| contentType.startsWith("text/xml")
				|| contentType.startsWith("application/xhtml+xml")
				|| contentType.startsWith("application/xml");
	}

	private final class JQueryResponseWrapper extends
			HttpServletResponseWrapper {

		private PrintWriter _printWriter = null;
		private String _contentType;
		private final ByteArrayOutputStream _outPutStream;

		private JQueryResponseWrapper(HttpServletResponse response) {
			super(response);
			_outPutStream = new ByteArrayOutputStream();
		}

		public byte[] getBytes() {
			return _outPutStream.toByteArray();
		}

		public String toString() {
			try {
				return _outPutStream.toString(getCharacterEncoding());
			} catch (UnsupportedEncodingException unsupportedEncodingException) {
				throw new RuntimeException(
						"Invalid character encoding for JQueryResponseWrapper toString for : "
								+ getCharacterEncoding());
			}
		}

		public PrintWriter getWriter() {
			if (_printWriter == null) {
				OutputStreamWriter streamWriter = new OutputStreamWriter(
						_outPutStream, Charset.forName(getCharacterEncoding()));
				_printWriter = new PrintWriter(streamWriter, true);
			}
			return _printWriter;
		}

		public ServletOutputStream getOutputStream() {

			return new ServletOutputStream() {
				public void write(int numBytes) {
					_outPutStream.write(numBytes);
				}

				public void write(byte[] bytes) throws IOException {
					_outPutStream.write(bytes);
				}

				public void write(byte[] bytes, int off, int len) {
					_outPutStream.write(bytes, off, len);
				}
			};
		}

		public InputSource getInputSource() {
			ByteArrayInputStream bais = new ByteArrayInputStream(_outPutStream
					.toByteArray());
			return new InputSource(bais);
		}

		public void setContentLength(int contentLength) {
		}

		public void setContentType(String contentType) {
			super.setContentType(contentType);
			_contentType = contentType;
		}

		public String getContentType() {
			return _contentType;
		}

		public void flushBuffer() throws IOException {
			_outPutStream.flush();
		}

		public void finishResponse() {
			try {
				if (_printWriter != null) {
					_printWriter.close();
				} else {
					if (_outPutStream != null) {
						_outPutStream.close();
					}
				}
			} catch (IOException ioException) {
			}
		}

	}

	public FilterConfig getFilterConfig() {
		return _filterConfig;
	}

}
