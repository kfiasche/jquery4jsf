package org.jquery4jsf.custom.outputcss;

import javax.faces.component.UIComponentBase;

import org.jquery4jsf.component.ComponentUtilities;

public class OutputCss extends UIComponentBase {


	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Output";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.OutputCss";
	public static final String DEFAULT_RENDERER_TYPE = OutputCssRenderer.RENDERER_TYPE;

	private String hreflang;
	private String type;
	private String href;
	private String media;
	private String rel;
	private String charset;
	
	public String getRel() {
		return (String) getLocalOrValueBindingValue(rel, "rel");
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHreflang() {
		return (String) getLocalOrValueBindingValue(hreflang, "hreflang");
	}

	public void setHreflang(String hreflang) {
		this.hreflang = hreflang;
	}

	public String getHref() {
		return (String) getLocalOrValueBindingValue(href, "href");
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getMedia() {
		return (String) getLocalOrValueBindingValue(media, "media");
	}

	public void setMedia(String media) {
		this.media = media;
	}
	
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public OutputCss() {
		super();
		setRendererType(DEFAULT_RENDERER_TYPE);
	}
	
	private Object getLocalOrValueBindingValue(Object localValue, String  valueBindingName){
		return ComponentUtilities.getLocalOrValueBindingValue(localValue, valueBindingName);
	}

	public String getType() {
		return (String) getLocalOrValueBindingValue(type, "type");
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCharset() {
		return (String) getLocalOrValueBindingValue(charset, "charset");
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
	
}
