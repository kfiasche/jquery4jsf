package org.jquery4jsf.showcase.filters;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.LoggerFactory;

public class GZIPResponseWrapper extends HttpServletResponseWrapper
{
	org.slf4j.Logger logger = LoggerFactory.getLogger(GZIPResponseStream.class);

    public GZIPResponseWrapper(HttpServletResponse response)
    {
        super(response);
        origResponse = null;
        stream = null;
        writer = null;
        origResponse = response;
    }

    public ServletOutputStream createOutputStream()
        throws IOException
    {
        return new GZIPResponseStream(origResponse);
    }

    public void finishResponse()
    {
        try
        {
            if(writer != null)
                writer.close();
            else
            if(stream != null)
                stream.close();
        }
        catch(IOException ioexception) { }
    }

    public void flushBuffer()
        throws IOException
    {
    	if(stream != null)
    		stream.flush();
    }

    public ServletOutputStream getOutputStream()
        throws IOException
    {
        if(writer != null)
            throw new IllegalStateException("getWriter() has already been called!");
        if(stream == null)
            stream = createOutputStream();
        return stream;
    }

    public PrintWriter getWriter()
        throws IOException
    {
        if(writer != null)
            return writer;
        if(stream != null)
        {
            throw new IllegalStateException("getOutputStream() has already been called!");
        } else
        {
            stream = createOutputStream();
            //writer = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
            writer = new PrintWriter(new OutputStreamWriter(stream, "ISO-8859-1"));
            return writer;
        }
    }

    public void setContentLength(int i)
    {
    }

    protected HttpServletResponse origResponse;
    protected ServletOutputStream stream;
    protected PrintWriter writer;
}