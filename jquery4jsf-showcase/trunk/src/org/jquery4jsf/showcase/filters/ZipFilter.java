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

import org.slf4j.LoggerFactory;

public class ZipFilter implements Filter {

	org.slf4j.Logger logger = LoggerFactory.getLogger(ZipFilter.class);
	
    public ZipFilter()
    {
    }

    public void init(FilterConfig filterconfig)
        throws ServletException
    {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException
    {
		boolean isFilterEnabled = true;
		if (isFilterEnabled){
   	
			if(req instanceof HttpServletRequest)
        {
				HttpServletRequest request = (HttpServletRequest)req;
				HttpServletResponse response = (HttpServletResponse)res;
    
					String ae = request.getHeader("accept-encoding");
					if(ae != null && ae.indexOf("gzip") != -1)
					{
						logger.debug("ZipFilter: " + ((HttpServletRequest) req).getRequestURI());
						GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);
						chain.doFilter(req, wrappedResponse);
	                	wrappedResponse.finishResponse();
	                	return;
				}
        	}
		}
        chain.doFilter(req, res);
    }

    public void destroy()
    {
    }
}