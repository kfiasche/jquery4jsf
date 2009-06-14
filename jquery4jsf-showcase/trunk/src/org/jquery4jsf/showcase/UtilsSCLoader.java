package org.jquery4jsf.showcase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.servlet.ServletContext;

import org.jquery4jsf.showcase.parser.model.TagDefinition;

import com.sun.facelets.FaceletContext;

public class UtilsSCLoader {

	private String textSource;

	public String getTextSource() {
		return textSource;
	}

	public void setTextSource(String textSource) {
		this.textSource = textSource;
	}
//	public void doTagInformationLocader(FacesContext context){
//		ValueBinding vb = context.getApplication().createValueBinding("#{tagName}");
//		
//		String tagName = (String) vb.getValue(context);
//		if (tagName != null){
//			ValueBinding vbs = context.getApplication().createValueBinding("#{startupBean}");
//			StartupBean sb = (StartupBean) vbs.getValue(context);
//			TagDefinition tagDefinition = sb.getTagLib().getTags().get(tagName);
//			ValueBinding vbt = context.getApplication().createValueBinding("#{tagDefinition}");
//			vbt.setValue(context, tagDefinition);
//		}
//	}
	
	public void doSouceLocader(FacesContext context){
		String sourcePath = context.getViewRoot().getViewId();
		if (sourcePath != null) {
			ServletContext sc = (ServletContext) context.getExternalContext().getContext();
			InputStream sourceStream =
				sc.getResourceAsStream(sourcePath);

			if (sourceStream == null) {
				try {
					// Work around for websphere
					sourceStream = new FileInputStream(new File(
							sc.getRealPath(
									sourcePath.replaceFirst("./", ""))));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (sourceStream != null) {
				try{
					BufferedReader br = new BufferedReader(new InputStreamReader(sourceStream));
					String strLine;
					String text = "";
					boolean isInto = false;
					while ((strLine = br.readLine()) != null)   {
						if (strLine.trim().equalsIgnoreCase("<!-- START -->")){
							isInto = true;
							continue;
						}
						else if (strLine.trim().equalsIgnoreCase("<!-- END -->")){
							isInto = false;
						}
						if (isInto){
							
							text = text +"\n"+ strLine;
						}
					}
					textSource = text;
					sourceStream.close();
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
		}
	}
}
