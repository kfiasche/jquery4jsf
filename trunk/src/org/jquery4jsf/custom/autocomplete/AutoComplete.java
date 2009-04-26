/*
 *  Copyright (c) 2009 Giuseppe Trisciuoglio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
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
	private Integer delay;
	private Integer cacheLength;
	private Boolean matchSubset;
	private Boolean matchCase;
	
	public static final String DEFAULT_RENDERER_TYPE = AutoCompleteRenderer.RENDERER_TYPE;
	public static final String COMPONENT_FAMILY = "org.jquery4jsf.HtmlInputText";
	public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlInputTextAutocomplete";
	
	private static int 		DEFAULT_MIN_CHARS = 1;
	private static int 		DEFAULT_DELAY = 400;
	private static int 		DEFAULT_CACHE_LENGTH = 10;
	private static boolean 	DEFAULT_MATCH_SUBSET = true;
	private static boolean 	DEFAULT_SELECT_FIRST = true;
	private static String 	DEFAULT_MULTIPLE_SEPARATOR = ", ";
	private static int 		DEFAULT_MAX = 10;
	private static boolean 	DEFAULT_SCROLL = true;
	private static int 		DEFAULT_SCROLL_HEIGHT = 180;
	
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
        Object values[] = new Object[21];
        values[0] = super.saveState(context);
        values[1]=minChars;
        values[2]=max;
        values[3]=highlight;
        values[4]=scroll;
        values[5]=selectFirst;
        values[6]=autoFill;
        values[7]=mustMatch;
        values[8]=matchContains;
        values[9]=multiple;
        values[10]=scrollHeight;
        values[11]=multipleSeparator;
        values[12]=formatItem;
        values[13]=formatMatch;
        values[14]=formatResult;
        values[15]=jsonValue;
        values[16]=oncomplete;
        values[17]=delay;
        values[18]=cacheLength;
        values[19]=matchSubset;
        values[20]=matchCase;
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
	    delay					= (Integer)values[17];
	    cacheLength				= (Integer)values[18];
	    matchSubset =(Boolean)values[19];
	    matchCase=(Boolean) values[20];
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
        return v != null ? v.intValue() : DEFAULT_MAX;
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
        return v != null ? v.intValue() : DEFAULT_MIN_CHARS;
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
        String v = vb != null ? (String) vb.getValue(getFacesContext()) : DEFAULT_MULTIPLE_SEPARATOR;
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
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : new Boolean(DEFAULT_SCROLL);
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
        return v != null ? v.intValue() : DEFAULT_SCROLL_HEIGHT;
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
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : new Boolean(DEFAULT_SELECT_FIRST);
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

	public Integer getDelay() {
        if (delay != null) return delay;
        ValueBinding vb = getValueBinding("delay");
        Integer v = vb != null ? (Integer) vb.getValue(getFacesContext()) : new Integer(DEFAULT_DELAY);
        return v;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public Integer getCacheLength() {
        if (cacheLength != null) return cacheLength;
        ValueBinding vb = getValueBinding("cacheLength");
        Integer v = vb != null ? (Integer) vb.getValue(getFacesContext()) : new Integer(DEFAULT_CACHE_LENGTH);
        return v;
	}
	
	public void setCacheLength(Integer cacheLength) {
		this.cacheLength = cacheLength;
	}

	public boolean isMatchSubset() {
        if (matchSubset != null) return matchSubset.booleanValue();
        ValueBinding vb = getValueBinding("matchSubset");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : new Boolean(DEFAULT_MATCH_SUBSET);
		return v.booleanValue();
	}

	public void setMatchSubset(boolean matchSubset) {
		this.matchSubset = matchSubset ? Boolean.TRUE : Boolean.FALSE;
	}

	public boolean isMatchCase() {
        if (matchCase != null) return matchCase.booleanValue();
        ValueBinding vb = getValueBinding("matchCase");
        Boolean v = vb != null ? (Boolean) vb.getValue(getFacesContext()) : Boolean.FALSE;
		return v.booleanValue();
	}

	public void setMatchCase(boolean matchCase) {
		this.matchCase = matchCase ? Boolean.TRUE : Boolean.FALSE;
	}
}
