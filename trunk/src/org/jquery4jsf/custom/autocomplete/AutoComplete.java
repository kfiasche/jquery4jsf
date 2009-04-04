/*
 * Creato il 30-mar-2009
 *
 * TODO Per modificare il modello associato a questo file generato, aprire
 * Finestra - Preferenze - Java - Stile codice - Modelli codice
 */
package org.jquery4jsf.custom.autocomplete;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import javax.faces.render.Renderer;

import org.jquery4jsf.custom.AjaxComponent;
import org.jquery4jsf.custom.JQueryHtmlObject;
import org.jquery4jsf.renderkit.AjaxBaseRenderer;

/**
 * @author Administrator
 *
 * TODO Per modificare il modello associato al commento di questo tipo generato, aprire
 * Finestra - Preferenze - Java - Stile codice - Modelli codice
 */
public class AutoComplete extends javax.faces.component.html.HtmlInputText implements JQueryHtmlObject, AjaxComponent {

	private Integer minChars;
	private Integer max;
	private Boolean highlight;
	private Boolean scroll;
	private Boolean selectFirst;
	private Boolean autoFill;
	private Boolean mustMatch;
	private Boolean matchContains;
	private Boolean multiple;
	private Integer scrollHeight;
	private String multipleSeparator;
	/*
	 * Eventi
	 */
	private String formatItem;
	private String formatMatch;
	private String formatResult;
	private String jsonValue;
	
	private MethodBinding oncomplete;

	public static final String DEFAULT_RENDERER_TYPE = AutoCompleteRenderer.RENDERER_TYPE;
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.HtmlInputText";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlInputTextAutocomplete";
	private String[] resources = null;
	
	public AutoComplete() {
		super();
		setRendererType(DEFAULT_RENDERER_TYPE);
		resources = new String[]{
				"jquery/jquery.js",
				"external/jquery.ajaxQueue.js",
				"autocomplete/jquery.autocomplete.js",
				"autocomplete/jquery.autocomplete.css",
				"external/jquery.bgiframe.min.js",
				"external/thickbox-compressed.js",
				"external/thickbox.css"};
	}

	public String[] getResources() {
		return resources;
	}

	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
    public Object saveState(FacesContext context)
    {
        Object values[] = new Object[17];
        values[0] = super.saveState(context);
        values[1]=(Integer)minChars;
        values[2]=(Integer)max;
        values[3]=(Boolean)highlight;
        values[4]=(Boolean)scroll;
        values[5]=(Boolean)selectFirst;
        values[6]=(Boolean)autoFill;
        values[7]=(Boolean)mustMatch;
        values[8]=(Boolean)matchContains;
        values[9]=(Boolean)multiple;
        values[10]=(Integer)scrollHeight;
        values[11]=(String)multipleSeparator;
        values[12]=(String)formatItem;
        values[13]=(String)formatMatch;
        values[14]=(String)formatResult;
        values[15]=(String)jsonValue;
        values[16]=(MethodBinding)oncomplete;
        return values;
    }
    public void restoreState(FacesContext context, Object state)
    {
        Object values[] = (Object[]) state;
        super.restoreState(context, values[0]);
	    minChars                = (Integer)values[1];
	    max                     = (Integer)values[2];
	    highlight               = (Boolean)values[3];
	    scroll                  = (Boolean)values[4];
	    selectFirst             = (Boolean)values[5];
	    autoFill                = (Boolean)values[6];
	    mustMatch               = (Boolean)values[7];
	    matchContains           = (Boolean)values[8];
	    multiple                = (Boolean)values[9];
	    scrollHeight            = (Integer)values[10];
	    multipleSeparator       = (String)values[11];
	    formatItem              = (String)values[12];
	    formatMatch             = (String)values[13];
	    formatResult			= (String)values[14];
	    jsonValue				= (String)values[15];
	    oncomplete				= (MethodBinding)values[16];
	}

    /**
     * @return Restituisce il valore autoFill.
     */
    public boolean isAutoFill() {
        if (autoFill != null) return autoFill.booleanValue();
        ValueBinding vb = getValueBinding("autoFill");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : null;
        return v != null ? v.booleanValue() : false;
    }
    /**
     * @param autoFill Il valore autoFill da impostare.
     */
    public void setAutoFill(boolean autoFill) {
        this.autoFill = autoFill ? Boolean.TRUE : Boolean.FALSE;
    }
    /**
     * @return Restituisce il valore formatItem.
     */
    public String getFormatItem() {
        if (formatItem != null) return formatItem;
        ValueBinding vb = getValueBinding("formatItem");
        String v = vb != null ? (String) vb.getValue(getFacesContext()) : null;
        return v;
    }
    /**
     * @param formatItem Il valore formatItem da impostare.
     */
    public void setFormatItem(String formatItem) {
        this.formatItem = formatItem;
    }
    /**
     * @return Restituisce il valore formatMatch.
     */
    public String getFormatMatch() {
        if (formatMatch != null) return formatMatch;
        ValueBinding vb = getValueBinding("formatMatch");
        String v = vb != null ? (String) vb.getValue(getFacesContext()) : null;
        return v;
    }
    /**
     * @param formatMatch Il valore formatMatch da impostare.
     */
    public void setFormatMatch(String formatMatch) {
        this.formatMatch = formatMatch;
    }
    /**
     * @return Restituisce il valore formatResult.
     */
    public String getFormatResult() {
        if (formatResult != null) return formatResult;
        ValueBinding vb = getValueBinding("formatResult");
        String v = vb != null ? (String) vb.getValue(getFacesContext()) : null;
        return v;
    }
    /**
     * @param formatResult Il valore formatResult da impostare.
     */
    public void setFormatResult(String formatResult) {
        this.formatResult = formatResult;
    }
    /**
     * @return Restituisce il valore highlight.
     */
    public boolean isHighlight() {
        if (highlight != null) return highlight.booleanValue();
        ValueBinding vb = getValueBinding("highlight");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : null;
        return v != null ? v.booleanValue() : false;
    }
    /**
     * @param highlight Il valore highlight da impostare.
     */
    public void setHighlight(boolean highlight) {
        this.highlight = highlight ? Boolean.TRUE : Boolean.FALSE;
    }
    /**
     * @return Restituisce il valore matchContains.
     */
    public boolean isMatchContains() {
        if (matchContains != null) return matchContains.booleanValue();
        ValueBinding vb = getValueBinding("matchContains");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : null;
        return v != null ? v.booleanValue() : false;
    }
    /**
     * @param matchContains Il valore matchContains da impostare.
     */
    public void setMatchContains(boolean matchContains) {
        this.matchContains = matchContains ? Boolean.TRUE : Boolean.FALSE;
    }
    /**
     * @return Restituisce il valore max.
     */
    public int getMax() {
        if (max != null) return max.intValue();
        ValueBinding vb = getValueBinding("max");
        Integer v = vb != null ? (Integer) vb.getValue(getFacesContext()) : null;
        return v != null ? v.intValue() : -1;
    }
    /**
     * @param max Il valore max da impostare.
     */
    public void setMax(int max) {
        this.max = new Integer(max);
    }
    /**
     * @return Restituisce il valore minChars.
     */
    public int getMinChars() {
        if (minChars != null) return minChars.intValue();
        ValueBinding vb = getValueBinding("minChars");
        Integer v = vb != null ? (Integer) vb.getValue(getFacesContext()) : null;
        return v != null ? v.intValue() : -1;
    }
    /**
     * @param minChars Il valore minChars da impostare.
     */
    public void setMinChars(int minChars) {
        this.minChars = new Integer(minChars);
    }
    /**
     * @return Restituisce il valore multiple.
     */
    public boolean isMultiple() {
        if (multiple != null) return multiple.booleanValue();
        ValueBinding vb = getValueBinding("multiple");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : null;
        return v != null ? v.booleanValue() : false;
    }
    /**
     * @param multiple Il valore multiple da impostare.
     */
    public void setMultiple(boolean multiple) {
        this.multiple = multiple ? Boolean.TRUE : Boolean.FALSE;
    }
    /**
     * @return Restituisce il valore multipleSeparator.
     */
    public String getMultipleSeparator() {
        if (multipleSeparator != null) return multipleSeparator;
        ValueBinding vb = getValueBinding("multipleSeparator");
        String v = vb != null ? (String) vb.getValue(getFacesContext()) : null;
        return v;
    }
    /**
     * @param multipleSeparator Il valore multipleSeparator da impostare.
     */
    public void setMultipleSeparator(String multipleSeparator) {
        this.multipleSeparator = multipleSeparator;
    }
    /**
     * @return Restituisce il valore mustMatch.
     */
    public boolean isMustMatch() {
        if (mustMatch != null) return mustMatch.booleanValue();
        ValueBinding vb = getValueBinding("mustMatch");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : null;
        return v != null ? v.booleanValue() : false;
    }
    /**
     * @param mustMatch Il valore mustMatch da impostare.
     */
    public void setMustMatch(boolean mustMatch) {
        this.mustMatch = mustMatch ? Boolean.TRUE : Boolean.FALSE;
    }
    /**
     * @return Restituisce il valore scroll.
     */
    public boolean isScroll() {
        if (scroll != null) return scroll.booleanValue();
        ValueBinding vb = getValueBinding("scroll");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : null;
        return v != null ? v.booleanValue() : false;
    }
    /**
     * @param scroll Il valore scroll da impostare.
     */
    public void setScroll(boolean scroll) {
        this.scroll = scroll ? Boolean.TRUE : Boolean.FALSE;
    }
    /**
     * @return Restituisce il valore scrollHeight.
     */
    public int getScrollHeight() {
        if (scrollHeight != null) return scrollHeight.intValue();
        ValueBinding vb = getValueBinding("scrollHeight");
        Integer v = vb != null ? (Integer) vb.getValue(getFacesContext()) : null;
        return v != null ? v.intValue() : -1;
    }
    /**
     * @param scrollHeight Il valore scrollHeight da impostare.
     */
    public void setScrollHeight(int scrollHeight) {
        this.scrollHeight = new Integer(scrollHeight);
    }
    /**
     * @return Restituisce il valore selectFirst.
     */
    public boolean isSelectFirst() {
        if (selectFirst != null) return selectFirst.booleanValue();
        ValueBinding vb = getValueBinding("selectFirst");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : null;
        return v != null ? v.booleanValue() : false;
        
    }
    /**
     * @param selectFirst Il valore selectFirst da impostare.
     */
    public void setSelectFirst(boolean selectFirst) {
        this.selectFirst = selectFirst ? Boolean.TRUE : Boolean.FALSE;
    }
    /**
     * @return Restituisce il valore jsonValue.
     */
    public String getJsonValue() {
        if (jsonValue != null) return jsonValue;
        ValueBinding vb = getValueBinding("jsonValue");
        String v = vb != null ? (String) vb.getValue(getFacesContext()) : null;
        return v;
    }
    /**
     * @param jsonValue Il valore jsonValue da impostare.
     */
    public void setJsonValue(String jsonValue) {
        this.jsonValue = jsonValue;
    }
    
	public MethodBinding getOncomplete() {
		return oncomplete;
	}

	public void setOncomplete(MethodBinding oncomplete) {
		this.oncomplete = oncomplete;
	}
	
	public void encodePartially(FacesContext context) throws IOException{
		Renderer renderer = getRenderer(context);
		if(renderer instanceof AjaxBaseRenderer) {
			((AjaxBaseRenderer)renderer).encodePartially(context, this);
		}
	}
}
