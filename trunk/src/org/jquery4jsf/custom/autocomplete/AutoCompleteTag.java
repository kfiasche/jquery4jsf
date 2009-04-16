package org.jquery4jsf.custom.autocomplete;

import javax.faces.component.UIComponent;

import org.jquery4jsf.component.ComponentUtilities;

import com.sun.faces.taglib.html_basic.InputTextTag;

public class AutoCompleteTag extends InputTextTag {

	private String minChars;
	private String max;
	private String highlight;
	private String scroll;
	private String selectFirst;
	private String autoFill;
	private String mustMatch;
	private String matchContains;
	private String multiple;
	private String scrollHeight;
	private String multipleSeparator;
	private String formatItem;
	private String formatMatch;
	private String formatResult;
	private String jsonValue;
	private String oncomplete;
	private String delay;
    private String cacheLength;
	private String matchSubset;
	private String matchCase;

	public String getComponentType()
    {
        return AutoComplete.COMPONENT_TYPE;
    }

    public String getRendererType()
    {
        return AutoComplete.DEFAULT_RENDERER_TYPE;
    }
	
    public void release() 
    {
        super.release();
        minChars                = null;
        max                     = null;
        highlight               = null;
        scroll                  = null;
        selectFirst             = null;
        autoFill                = null;
        mustMatch               = null;
        matchContains           = null;
        multiple                = null;
        scrollHeight            = null;
        multipleSeparator       = null;
        formatItem              = null;
        formatMatch             = null;
        formatResult            = null;
        jsonValue				= null;
        oncomplete 				= null;
        delay					= null;
        cacheLength				= null;
    	matchSubset= null;
    	matchCase= null;
    }
    
    protected void setProperties(UIComponent component)
    {
		super.setProperties(component);
		ComponentUtilities.setIntegerProperty(getFacesContext(),component, "minChars",minChars);
		ComponentUtilities.setIntegerProperty(getFacesContext(),component, "max",max);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "highlight",highlight);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "scroll",scroll);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "selectFirst",selectFirst);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "autoFill",autoFill);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "mustMatch",mustMatch);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "matchContains",matchContains);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "multiple",multiple);
		ComponentUtilities.setIntegerProperty(getFacesContext(),component, "scrollHeight",scrollHeight);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "multipleSeparator",multipleSeparator);    
		ComponentUtilities.setStringProperty(getFacesContext(),component, "formatItem",formatItem);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "formatMatch",formatMatch);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "formatResult",formatResult);
		ComponentUtilities.setStringProperty(getFacesContext(),component, "jsonValue",jsonValue);
		ComponentUtilities.setMethodBindingProperty(getFacesContext(),component, "oncomplete", oncomplete);
		ComponentUtilities.setIntegerProperty(getFacesContext(),component, "delay", delay);
		ComponentUtilities.setIntegerProperty(getFacesContext(),component, "cacheLength", cacheLength);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "matchSubset",matchSubset);
		ComponentUtilities.setBooleanProperty(getFacesContext(),component, "matchCase",matchCase);
    }
    
    /**
     * @param autoFill Il valore autoFill da impostare.
     */
    public void setAutoFill(String autoFill) {
        this.autoFill = autoFill;
    }
    /**
     * @param formatItem Il valore formatItem da impostare.
     */
    public void setFormatItem(String formatItem) {
        this.formatItem = formatItem;
    }
    /**
     * @param formatMatch Il valore formatMatch da impostare.
     */
    public void setFormatMatch(String formatMatch) {
        this.formatMatch = formatMatch;
    }
    /**
     * @param formatResult Il valore formatResult da impostare.
     */
    public void setFormatResult(String formatResult) {
        this.formatResult = formatResult;
    }
    /**
     * @param highlight Il valore highlight da impostare.
     */
    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }
    /**
     * @param jsonValue Il valore jsonValue da impostare.
     */
    public void setJsonValue(String jsonValue) {
        this.jsonValue = jsonValue;
    }
    /**
     * @param matchContains Il valore matchContains da impostare.
     */
    public void setMatchContains(String matchContains) {
        this.matchContains = matchContains;
    }
    /**
     * @param max Il valore max da impostare.
     */
    public void setMax(String max) {
        this.max = max;
    }
    /**
     * @param minChars Il valore minChars da impostare.
     */
    public void setMinChars(String minChars) {
        this.minChars = minChars;
    }
    /**
     * @param multiple Il valore multiple da impostare.
     */
    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }
    /**
     * @param multipleSeparator Il valore multipleSeparator da impostare.
     */
    public void setMultipleSeparator(String multipleSeparator) {
        this.multipleSeparator = multipleSeparator;
    }
    /**
     * @param mustMatch Il valore mustMatch da impostare.
     */
    public void setMustMatch(String mustMatch) {
        this.mustMatch = mustMatch;
    }
    /**
     * @param scroll Il valore scroll da impostare.
     */
    public void setScroll(String scroll) {
        this.scroll = scroll;
    }
    /**
     * @param scrollHeight Il valore scrollHeight da impostare.
     */
    public void setScrollHeight(String scrollHeight) {
        this.scrollHeight = scrollHeight;
    }
    /**
     * @param selectFirst Il valore selectFirst da impostare.
     */
    public void setSelectFirst(String selectFirst) {
        this.selectFirst = selectFirst;
    }
    
    public void setOncomplete(String oncomplete) {
		this.oncomplete = oncomplete;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setCacheLength(String cacheLength) {
		this.cacheLength = cacheLength;
	}

	public void setMatchSubset(String matchSubset) {
		this.matchSubset = matchSubset;
	}

	public void setMatchCase(String matchCase) {
		this.matchCase = matchCase;
	}

}
