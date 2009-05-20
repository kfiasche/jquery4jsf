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
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TableRenderer.java

package org.jquery4jsf.custom.datatable;
import org.jquery4jsf.utilities.MessageFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.jquery4jsf.renderkit.JQueryBaseRenderer;

// Referenced classes of package com.sun.faces.renderkit.html_basic:
//            HtmlBasicRenderer

public class HtmlDataTableExRenderer extends JQueryBaseRenderer
{

    public HtmlDataTableExRenderer()
    {
    }

    public boolean getRendersChildren()
    {
        return true;
    }

    public void encodeBegin(FacesContext context, UIComponent component)
        throws IOException
    {
        if(context == null || component == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(log.isLoggable(Level.FINE))
            log.logp(Level.FINE, "com.sun.faces.renderkit.html_basic.TableRenderer", "encodeBegin", "Begin encoding component " + component.getId());
        if(!component.isRendered())
        {
            if(log.isLoggable(Level.FINE))
                log.logp(Level.FINE, "com.sun.faces.renderkit.html_basic.TableRenderer", "encodeBegin", "No encoding necessary " + component.getId() + " since " + "rendered attribute is set to false ");
            return;
        }
        UIData data = (UIData)component;
        data.setRowIndex(-1);
        ResponseWriter responsewriter = context.getResponseWriter();
        responsewriter.startElement("table", data);
        writeIdAttributeIfNecessary(context, responsewriter, component);
        String s = null;
        if(component instanceof HtmlDataTable)
            s = ((HtmlDataTable)component).getStyleClass();
        else
            s = (String)data.getAttributes().get("styleClass");
        if(s != null)
            responsewriter.writeAttribute("class", s, "styleClass");
        if(component instanceof HtmlDataTable)
        {
            if(((HtmlDataTable)component).getBgcolor() != null)
                responsewriter.writeAttribute("bgcolor", ((HtmlDataTable)component).getBgcolor(), null);
            if(((HtmlDataTable)component).getBorder() > 0)
                responsewriter.writeAttribute("border", new Integer(((HtmlDataTable)component).getBorder()), null);
            if(((HtmlDataTable)component).getCellpadding() != null)
                responsewriter.writeAttribute("cellpadding", ((HtmlDataTable)component).getCellpadding(), null);
            if(((HtmlDataTable)component).getCellspacing() != null)
                responsewriter.writeAttribute("cellspacing", ((HtmlDataTable)component).getCellspacing(), null);
            if(((HtmlDataTable)component).getDir() != null)
                responsewriter.writeAttribute("dir", ((HtmlDataTable)component).getDir(), null);
            if(((HtmlDataTable)component).getFrame() != null)
                responsewriter.writeAttribute("frame", ((HtmlDataTable)component).getFrame(), null);
            if(((HtmlDataTable)component).getLang() != null)
                responsewriter.writeAttribute("lang", ((HtmlDataTable)component).getLang(), null);
            if(((HtmlDataTable)component).getOnclick() != null)
                responsewriter.writeAttribute("onclick", ((HtmlDataTable)component).getOnclick(), null);
            if(((HtmlDataTable)component).getOndblclick() != null)
                responsewriter.writeAttribute("ondblclick", ((HtmlDataTable)component).getOndblclick(), null);
            if(((HtmlDataTable)component).getOnkeydown() != null)
                responsewriter.writeAttribute("onkeydown", ((HtmlDataTable)component).getOnkeydown(), null);
            if(((HtmlDataTable)component).getOnkeypress() != null)
                responsewriter.writeAttribute("onkeypress", ((HtmlDataTable)component).getOnkeypress(), null);
            if(((HtmlDataTable)component).getOnkeyup() != null)
                responsewriter.writeAttribute("onkeyup", ((HtmlDataTable)component).getOnkeyup(), null);
            if(((HtmlDataTable)component).getOnmousedown() != null)
                responsewriter.writeAttribute("onmousedown", ((HtmlDataTable)component).getOnmousedown(), null);
            if(((HtmlDataTable)component).getOnmousemove() != null)
                responsewriter.writeAttribute("onmousemove", ((HtmlDataTable)component).getOnmousemove(), null);
            if(((HtmlDataTable)component).getOnmouseout() != null)
                responsewriter.writeAttribute("onmouseout", ((HtmlDataTable)component).getOnmouseout(), null);
            if(((HtmlDataTable)component).getOnmouseover() != null)
                responsewriter.writeAttribute("onmouseover", ((HtmlDataTable)component).getOnmouseover(), null);
            if(((HtmlDataTable)component).getOnmouseup() != null)
                responsewriter.writeAttribute("onmouseup", ((HtmlDataTable)component).getOnmouseup(), null);
            if(((HtmlDataTable)component).getRules() != null)
                responsewriter.writeAttribute("rules", ((HtmlDataTable)component).getRules(), null);
            if(((HtmlDataTable)component).getStyle() != null)
                responsewriter.writeAttribute("style", ((HtmlDataTable)component).getStyle(), null);
            if(((HtmlDataTable)component).getSummary() != null)
                responsewriter.writeAttribute("summary", ((HtmlDataTable)component).getSummary(), null);
            if(((HtmlDataTable)component).getTitle() != null)
                responsewriter.writeAttribute("title", ((HtmlDataTable)component).getTitle(), null);
            if(((HtmlDataTable)component).getWidth() != null)
                responsewriter.writeAttribute("width", ((HtmlDataTable)component).getWidth(), null);
        } else
        {
        }
        responsewriter.writeText("\n", null);
        UIComponent uicomponent1 = getFacet(data, "header");
        int i = getFacetCount(data, "header");
        String s1 = null;
        if(component instanceof HtmlDataTable)
            s1 = ((HtmlDataTable)component).getHeaderClass();
        else
            s1 = (String)data.getAttributes().get("headerClass");
        if(uicomponent1 != null || i > 0)
        {
            responsewriter.startElement("thead", data);
            responsewriter.writeText("\n", null);
        }
        if(uicomponent1 != null)
        {
            responsewriter.startElement("tr", uicomponent1);
            responsewriter.startElement("th", uicomponent1);
            if(s1 != null)
                responsewriter.writeAttribute("class", s1, "headerClass");
            responsewriter.writeAttribute("colspan", "" + getColumnCount(data), null);
            responsewriter.writeAttribute("scope", "colgroup", null);
            encodeRecursive(context, uicomponent1);
            responsewriter.endElement("th");
            responsewriter.endElement("tr");
            responsewriter.writeText("\n", null);
        }
        if(i > 0)
        {
            responsewriter.startElement("tr", data);
            responsewriter.writeText("\n", null);
            for(Iterator iterator = getColumns(data); iterator.hasNext(); responsewriter.writeText("\n", null))
            {
                UIColumn uicolumn = (UIColumn)iterator.next();
                responsewriter.startElement("th", uicolumn);
                if(s1 != null)
                    responsewriter.writeAttribute("class", s1, "headerClass");
                String s2 = (String)uicolumn.getAttributes().get("width");
                if(s2 != null)
                    responsewriter.writeAttribute("width", s2, null);
                responsewriter.writeAttribute("scope", "col", null);
                UIComponent uicomponent3 = getFacet(uicolumn, "header");
                if(uicomponent3 != null)
                {
                    encodeRecursive(context, uicomponent3);
                } else
                {
                    responsewriter.startElement("span", component);
                    responsewriter.writeAttribute("style", "font-size:1pt", null);
                    responsewriter.write("&nbsp;");
                    responsewriter.endElement("span");
                }
                responsewriter.endElement("th");
            }

            responsewriter.endElement("tr");
            responsewriter.writeText("\n", null);
        }
        if(uicomponent1 != null || i > 0)
        {
            responsewriter.endElement("thead");
            responsewriter.writeText("\n", null);
        }
        UIComponent uicomponent2 = getFacet(data, "footer");
        int j = getFacetCount(data, "footer");
        String s3 = null;
        if(component instanceof HtmlDataTable)
            s3 = ((HtmlDataTable)component).getFooterClass();
        else
            s3 = (String)data.getAttributes().get("footerClass");
        if(uicomponent2 != null || j > 0)
        {
            responsewriter.startElement("tfoot", data);
            responsewriter.writeText("\n", null);
        }
        if(uicomponent2 != null)
        {
            responsewriter.startElement("tr", uicomponent2);
            responsewriter.startElement("td", uicomponent2);
            if(s3 != null)
                responsewriter.writeAttribute("class", s3, "footerClass");
            responsewriter.writeAttribute("colspan", "" + getColumnCount(data), null);
            encodeRecursive(context, uicomponent2);
            responsewriter.endElement("td");
            responsewriter.endElement("tr");
            responsewriter.writeText("\n", null);
        }
        if(j > 0)
        {
            responsewriter.startElement("tr", data);
            responsewriter.writeText("\n", null);
            for(Iterator iterator1 = getColumns(data); iterator1.hasNext(); responsewriter.writeText("\n", null))
            {
                UIColumn uicolumn1 = (UIColumn)iterator1.next();
                responsewriter.startElement("td", uicolumn1);
                if(s3 != null)
                    responsewriter.writeAttribute("class", s3, "footerClass");
                UIComponent uicomponent4 = getFacet(uicolumn1, "footer");
                if(uicomponent4 != null)
                    encodeRecursive(context, uicomponent4);
                responsewriter.endElement("td");
            }

            responsewriter.endElement("tr");
            responsewriter.writeText("\n", null);
        }
        if(uicomponent2 != null || j > 0)
        {
            responsewriter.endElement("tfoot");
            responsewriter.writeText("\n", null);
        }
    }

    public void encodeChildren(FacesContext facescontext, UIComponent uicomponent)
        throws IOException
    {
        if(facescontext == null || uicomponent == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(log.isLoggable(Level.FINE))
            log.logp(Level.FINE, "com.sun.faces.renderkit.html_basic.TableRenderer", "encodeChildren", "Begin encoding children " + uicomponent.getId());
        if(!uicomponent.isRendered())
        {
            if(log.isLoggable(Level.FINE))
                log.logp(Level.FINE, "com.sun.faces.renderkit.html_basic.TableRenderer", "encodeChildren", "No encoding necessary " + uicomponent.getId() + " since " + "rendered attribute is set to false ");
            return;
        }
        UIData uidata = (UIData)uicomponent;
        String as[] = getColumnClasses(uidata);
        boolean flag = false;
        int j = as.length;
        String as1[] = getRowClasses(uidata);
        int k = as1.length;
        ResponseWriter responsewriter = facescontext.getResponseWriter();
        Object obj = null;
        Object obj1 = null;
        int l = 0;
        int i1 = uidata.getFirst() - 1;
        int j1 = uidata.getRows();
        int k1 = 0;
        responsewriter.startElement("tbody", uicomponent);
        responsewriter.writeText("\n", null);
        do
        {
            if(j1 > 0 && ++l > j1)
                break;
            uidata.setRowIndex(++i1);
            if(!uidata.isRowAvailable())
                break;
            responsewriter.startElement("tr", uidata);
            if(k > 0)
            {
                responsewriter.writeAttribute("class", as1[k1++], "rowClasses");
                if(k1 >= k)
                    k1 = 0;
            }
            responsewriter.writeText("\n", null);
            int i = 0;
            for(Iterator iterator = getColumns(uidata); iterator.hasNext(); responsewriter.writeText("\n", null))
            {
                UIColumn uicolumn = (UIColumn)iterator.next();
                responsewriter.startElement("td", uicolumn);
                if(j > 0)
                {
                    responsewriter.writeAttribute("class", as[i++], "columnClasses");
                    if(i >= j)
                        i = 0;
                }
                Map map = uicolumn.getAttributes();
                String s = (String)map.get("width");
                String s1 = (String)map.get("height");
                String s2 = (String)map.get("nowrap");
                boolean flag1 = "true".equals(s2);
                String s3 = (String)map.get("align");
                String s4 = (String)map.get("valign");
                String s5 = (String)map.get("bgcolor");
                String s6 = (String)map.get("background");
                String s7 = (String)map.get("style");
                if(s != null)
                    responsewriter.writeAttribute("width", s, null);
                if(s1 != null)
                    responsewriter.writeAttribute("height", s1, null);
                if(flag1)
                    responsewriter.writeAttribute("nowrap", Boolean.TRUE, null);
                if(s3 != null)
                    responsewriter.writeAttribute("align", s3, null);
                if(s4 != null)
                    responsewriter.writeAttribute("valign", s4, null);
                if(s5 != null)
                    responsewriter.writeAttribute("bgcolor", s5, null);
                if(s6 != null)
                    responsewriter.writeAttribute("background", s6, null);
                if(s7 != null)
                    responsewriter.writeAttribute("style", s7, null);
                for(Iterator iterator1 = getChildren(uicolumn); iterator1.hasNext(); encodeRecursive(facescontext, (UIComponent)iterator1.next()));
                responsewriter.endElement("td");
            }

            responsewriter.endElement("tr");
            responsewriter.writeText("\n", null);
        } while(true);
        responsewriter.endElement("tbody");
        responsewriter.writeText("\n", null);
        uidata.setRowIndex(-1);
        if(log.isLoggable(Level.FINE))
            log.logp(Level.FINE, "com.sun.faces.renderkit.html_basic.TableRenderer", "encodeChildren", "End encoding children " + uicomponent.getId());
    }

    public void encodeEnd(FacesContext facescontext, UIComponent uicomponent)
        throws IOException
    {
        if(facescontext == null || uicomponent == null)
            throw new NullPointerException(MessageFactory.getMessage("com.sun.faces.NULL_PARAMETERS_ERROR"));
        if(!uicomponent.isRendered())
        {
            if(log.isLoggable(Level.FINE))
                log.logp(Level.FINE, "com.sun.faces.renderkit.html_basic.TableRenderer", "encodeEnd", "No encoding necessary " + uicomponent.getId() + " since " + "rendered attribute is set to false ");
            return;
        }
        UIData uidata = (UIData)uicomponent;
        uidata.setRowIndex(-1);
        ResponseWriter responsewriter = facescontext.getResponseWriter();
        responsewriter.endElement("table");
        responsewriter.writeText("\n", null);
        if(log.isLoggable(Level.FINE))
            log.logp(Level.FINE, "com.sun.faces.renderkit.html_basic.TableRenderer", "encodeEnd", "End encoding component " + uicomponent.getId());
    }

    private String[] getColumnClasses(UIData uidata)
    {
        String s = null;
        if(uidata instanceof HtmlDataTable)
            s = ((HtmlDataTable)uidata).getColumnClasses();
        else
            s = (String)uidata.getAttributes().get("columnClasses");
        if(s == null)
            return new String[0];
        s = s.trim();
        ArrayList arraylist = new ArrayList();
        while(s.length() > 0) 
        {
            int i = s.indexOf(",");
            if(i >= 0)
            {
                arraylist.add(s.substring(0, i).trim());
                s = s.substring(i + 1);
            } else
            {
                arraylist.add(s.trim());
                s = "";
            }
        }
        String as[] = new String[arraylist.size()];
        return (String[])arraylist.toArray(as);
    }

    private int getColumnCount(UIData uidata)
    {
        int i = 0;
        for(Iterator iterator = getColumns(uidata); iterator.hasNext();)
        {
            UIComponent uicomponent = (UIComponent)iterator.next();
            i++;
        }

        return i;
    }

    private Iterator getColumns(UIData uidata)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = uidata.getChildren().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            UIComponent uicomponent = (UIComponent)iterator.next();
            if((uicomponent instanceof UIColumn) && uicomponent.isRendered())
                arraylist.add(uicomponent);
        } while(true);
        return arraylist.iterator();
    }

    private int getFacetCount(UIData uidata, String s)
    {
        int i = 0;
        Iterator iterator = getColumns(uidata);
        do
        {
            if(!iterator.hasNext())
                break;
            UIComponent uicomponent = (UIComponent)iterator.next();
            if(getFacet(uicomponent, s) != null)
                i++;
        } while(true);
        return i;
    }

    private String[] getRowClasses(UIData uidata)
    {
        String s = null;
        if(uidata instanceof HtmlDataTable)
            s = ((HtmlDataTable)uidata).getRowClasses();
        else
            s = (String)uidata.getAttributes().get("rowClasses");
        if(s == null)
            return new String[0];
        s = s.trim();
        ArrayList arraylist = new ArrayList();
        while(s.length() > 0) 
        {
            int i = s.indexOf(",");
            if(i >= 0)
            {
                arraylist.add(s.substring(0, i).trim());
                s = s.substring(i + 1);
            } else
            {
                arraylist.add(s.trim());
                s = "";
            }
        }
        String as[] = new String[arraylist.size()];
        return (String[])arraylist.toArray(as);
    }

    protected static Logger log = Logger.getLogger("com.ibm.ws.jsf");
    private static final String CLASS_NAME = "com.sun.faces.renderkit.html_basic.TableRenderer";

}
