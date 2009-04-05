package org.jquery4jsf.taglib.html.ext;

import javax.faces.component.UIComponent;

import org.jquery4jsf.custom.link.HtmlLink;
import org.jquery4jsf.renderkit.html.HTML;

public class HtmlLinkTag extends HtmlJSCompleteTag {

	private String charset;
	private String coords;
	private String href;
	private String hreflang;
	private String name;
	private String rel;
	private String rev;
	private String shape;
	private String target;

	public String getComponentType() {
		return HtmlLink.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return HtmlLink.DEFAULT_RENDERER_TYPE;
	}
	
	public void release(){
		super.release();
		charset		 = null; 
		coords		 = null;  
		href		 = null;    
		hreflang	 = null;
		name		 = null;    
		rel		 = null;    
		rev		 = null;     
		shape		 = null;      
		target		 = null;  
	}
	
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
        setStringProperty(getFacesContext(), component, HTML.CHARSET, charset);
        setStringProperty(getFacesContext(), component, HTML.COORDS, coords);
        setStringProperty(getFacesContext(), component, HTML.HREF, href);
        setStringProperty(getFacesContext(), component, HTML.HREF_LANG, hreflang);
        setStringProperty(getFacesContext(), component, HTML.NAME, name);
        setStringProperty(getFacesContext(), component, HTML.REL, rel);
        setStringProperty(getFacesContext(), component, HTML.REV, rev);
        setStringProperty(getFacesContext(), component, HTML.SHAPE, shape);
        setStringProperty(getFacesContext(), component, HTML.TARGET, target);
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setCoords(String coords) {
		this.coords = coords;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setHreflang(String hreflang) {
		this.hreflang = hreflang;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
