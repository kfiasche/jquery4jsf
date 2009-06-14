package org.jquery4jsf.showcase;

import java.io.InputStream;

import org.jquery4jsf.showcase.parser.TLDParser;
import org.jquery4jsf.showcase.parser.model.TagLib;

public class StartupBean {

	private TagLib tagLib;
	public StartupBean(){
		super();
		initStartupBean();
	}

	private void initStartupBean() {
		try {
			String tldPath = "/META-INF/jquery4jsf.tld";
			InputStream inputStream = StartupBean.class.getResourceAsStream(tldPath);
			tagLib = TLDParser.parse(inputStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TagLib getTagLib() {
		return tagLib;
	}

	public void setTagLib(TagLib tagLib) {
		this.tagLib = tagLib;
	}
	
}
