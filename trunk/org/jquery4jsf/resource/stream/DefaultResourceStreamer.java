package org.jquery4jsf.resource.stream;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultResourceStreamer implements ResourceStreamer {

	public boolean isAppropriateStreamer(String mimeType) {
		return (mimeType != null && !mimeType.equals("text/css"));
	}

	public void stream(HttpServletRequest request, HttpServletResponse response, InputStream inputStream) throws IOException {
		int indice, tempIndice;
		byte tempArr[];
		byte mainArr[] = new byte[0];
		byte byteArr[] = new byte[65535];
		try {
			System.out.println("request: "+request.getRequestURI());
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
