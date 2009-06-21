/*
 * Created on 31-gen-2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.jquery4jsf.showcase.filters;

/**
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

public class ResponseHeaderFilter implements Filter {
	private FilterConfig filterConfig = null;

	org.slf4j.Logger logger = LoggerFactory.getLogger(ResponseHeaderFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		boolean isResponseHeaderFilterEnabled = true;
		if (isResponseHeaderFilterEnabled)
		{
			logger.debug("Inizio.");
			for (Enumeration e = filterConfig.getInitParameterNames(); e.hasMoreElements();) {
				
				logger.debug("RHFilter: " + ((HttpServletRequest) req).getRequestURI());
				
				String headerName = (String) e.nextElement();
				HttpServletResponse response = (HttpServletResponse) res;
				response.addHeader(headerName, filterConfig.getInitParameter(headerName));
				chain.doFilter(req, response);
				
			}
			logger.debug("Fine.");
		}
		chain.doFilter(req, res);
	}

}
