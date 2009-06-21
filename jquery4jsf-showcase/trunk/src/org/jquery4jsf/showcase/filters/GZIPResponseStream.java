package org.jquery4jsf.showcase.filters;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

public class GZIPResponseStream extends ServletOutputStream
{
	org.slf4j.Logger logger = LoggerFactory.getLogger(GZIPResponseStream.class);
    
	public GZIPResponseStream(HttpServletResponse response)
        throws IOException
    {
        baos = null;
        gzipstream = null;
        closed = false;
        this.response = null;
        output = null;
        responseBytes = null;
        closed = false;
        this.response = response;
        output = response.getOutputStream();
        baos = new ByteArrayOutputStream();
        gzipstream = new GZIPOutputStream(baos);
    }

    public void close()
        throws IOException
    {
        if(closed)
            throw new IOException("This output stream has already been closed");
        gzipstream.finish();
        byte bytes[] = (byte[])null;
        if(responseBytes != null)
        {
            bytes = responseBytes;
        } else
        {
            bytes = baos.toByteArray();
            response.addHeader("Content-Encoding", "gzip");
        }
        response.addHeader("Content-Length", Integer.toString(bytes.length));
        output.write(bytes);
        output.flush();
        output.close();
        closed = true;
    }

    public void flush()
        throws IOException
    {
        if(closed)
        {
            throw new IOException("Cannot flush a closed output stream");
        } else
        {
            gzipstream.flush();
            return;
        }
    }

    public void write(int b)
        throws IOException
    {
        if(closed)
        {
            throw new IOException("Cannot write to a closed output stream");
        } else
        {
            gzipstream.write((byte)b);
            return;
        }
    }

    public void write(byte b[])
        throws IOException
    {
        write(b, 0, b.length);
    }

    public void write(byte b[], int off, int len)
        throws IOException
    {
        if(closed)
        {
            throw new IOException("Cannot write to a closed output stream");
        } else
        {
            gzipstream.write(b, off, len);
            return;
        }
    }

    public boolean closed()
    {
        return closed;
    }

    public void reset()
    {
    }

    public void setResponseBytes(byte bs[])
    {
        responseBytes = bs;
    }

    protected ByteArrayOutputStream baos;
    protected GZIPOutputStream gzipstream;
    protected boolean closed;
    protected HttpServletResponse response;
    protected ServletOutputStream output;
    private byte responseBytes[];
}