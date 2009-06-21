package org.jquery4jsf.showcase.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements javax.servlet.Filter {

	private static final String REQUEST_ENCODING = "ISO-8859-1";

	public void init(FilterConfig filterConfig) throws ServletException {
		// This would be a good place to collect a parameterized
		// default encoding type.  For brevity, we're going to
		// use a hard-coded value in this example.
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// Wrap the response object.  You should create a mechanism
		// to ensure the response object only gets wrapped once.
		// In this example, the response object will inappropriately
		// get wrapped multiple times during a forward.
		response = new EncodingServletResponse((HttpServletResponse) response);
	
		// Specify the encoding to assume for the request so
		// the parameters can be properly decoded/.
		request.setCharacterEncoding(REQUEST_ENCODING);

		filterChain.doFilter(request, response);
	}

	public void destroy() {
		// no-op
	}
}