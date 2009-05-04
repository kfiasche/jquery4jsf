package org.jquery4jsf.resource.stream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JavaScriptResourceStreamer implements ResourceStreamer {

	private static String PARAM_JAVASCRIPT_MIN = "org.jquery4jsf.JAVASCRIPT_MIN";
	
	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && mimeType.equals("text/js"));
	}

	public void stream(ServletContext sc, HttpServletRequest request, HttpServletResponse response, InputStream inputStream) throws IOException {
		String param = sc.getInitParameter(PARAM_JAVASCRIPT_MIN);
		if (param != null && Boolean.valueOf(param).booleanValue()){
			ServletOutputStream outputStream = response.getOutputStream();
			JavaScriptMin jsMin = new JavaScriptMin(inputStream, outputStream);
			try {
				jsMin.jsmin();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			int indice, tempIndice;
			byte tempArr[];
			byte mainArr[] = new byte[0];
			byte byteArr[] = new byte[65535];
			try {
				ServletOutputStream outputStream = response.getOutputStream();
				for(indice = 0; (indice = inputStream.read(byteArr)) > 0;)  {
					tempIndice = mainArr.length + indice;
					tempArr = new byte[tempIndice];
					System.arraycopy(mainArr, 0, tempArr, 0, mainArr.length);
					System.arraycopy(byteArr, 0, tempArr, mainArr.length, indice);
					mainArr = tempArr;
				}
				outputStream.write(mainArr);
				outputStream.flush();
				outputStream.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
