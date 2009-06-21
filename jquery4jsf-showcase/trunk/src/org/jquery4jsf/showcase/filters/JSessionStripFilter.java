package org.jquery4jsf.showcase.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.LoggerFactory;

/**
 * Replaces the Response with one that will never put in a jsession.

 * Here is what needs to go into the web.xml:
 *
 <filter>
 <filter-name>JSession Strip Filter</filter-name>
 <filter-class>com.foo.JSessionStripFilter</filter-class>
 </filter>

 <filter-mapping>
 <filter-name>JSession Strip Filter</filter-name>
 <url-pattern>/*</url-pattern>
 <dispatcher>REQUEST</dispatcher>
 </filter-mapping>

 * some of this code is from URLRewriteFilter
 */
public class JSessionStripFilter implements Filter {

	//private FilterConfig filterConfig = null;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JSessionStripFilter.class.getName());
	public static String USING_JSESSION_STRIP = "usingJsessionStrip";
	private static String USER_AGENT = "user-agent";
	
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletResponse hResponse = (HttpServletResponse) response;
		HttpServletRequest hRequest = (HttpServletRequest) request;
		
		boolean isJsessionFilterEnabled = true;
		if (!isJsessionFilterEnabled)
		{
			return;
		}
		else
		{
			hRequest.setAttribute(USING_JSESSION_STRIP, "true");
			if (hResponse.isCommitted()) {
				logger.error("response is comitted cannot forward " +
				          " (check you haven't done anything to the response (ie, written to it) before here)");
				return;
			}
			String header = hRequest.getHeader(USER_AGENT);
			if (header == null 
					|| header.toLowerCase().indexOf("google") > -1 
					|| header.toLowerCase().indexOf("bot") > -1)
			{
				chain.doFilter(hRequest, new StripSessionIdWrapper(hResponse));
			}
			else
			{
				chain.doFilter(request,response);
			}
		}

	}

	public void destroy() {
	}

	/**
	 * This is a wrapper that does not encode urls with jsessions
	 */
	public class StripSessionIdWrapper extends HttpServletResponseWrapper {
		public StripSessionIdWrapper(HttpServletResponse response) {
			super(response);
		}

		public String encodeRedirectURL(String url) {
			return (url);
		}

		public String encodeUrl(String url) {
			return (url);
		}

		public String encodeURL(String url) {
			return (url);
		}

	}
}
