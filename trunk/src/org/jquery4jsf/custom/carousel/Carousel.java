/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.jquery4jsf.custom.carousel;

import javax.faces.component.UIComponent;
import javax.faces.el.ValueBinding;
import javax.faces.context.FacesContext;


// Generated from class org.jquery4jsf.custom.carousel.Carousel.
//
// WARNING: This file was automatically generated. Do not edit it directly,
//          or you will lose your changes.
public class Carousel extends javax.faces.component.UIData
{

   	public static final String COMPONENT_FAMILY = "org.jquery4jsf.Carousel";
    public static final String COMPONENT_TYPE = "org.jquery4jsf.HtmlCarousel";
    public static final String DEFAULT_RENDERER_TYPE =  "org.jquery4jsf.custom.CarouselRenderer";


	private String[] resources;


    private int selectedItem;
    private int scrollIncrement;
    private boolean circular;
    private boolean vertical;
    private int autoplay;
    private int revealAmount;
    private boolean animate;
    private double speed;
    private String effect;

    public Carousel()
    {
        setRendererType("org.jquery4jsf.custom.CarouselRenderer");

		resources = new String[]{
		"/yui/carousel/assets/skins/sam/carousel.css",
		"/yui/utilities/utilities.js",
		"/yui/carousel/carousel-min.js",
		"/yuiext/carousel/carousel.js",
		};
    }

    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }


    private boolean selectedItemSet;
    
    public int getSelectedItem()
    {
        if (selectedItemSet)
        {
            return selectedItem;
        }
        ValueBinding vb = getValueBinding("selectedItem");
        if (vb != null)
        {
            return ((Integer) vb.getValue(getFacesContext())).intValue();
        }
        return 0; 
    }

    public void setSelectedItem(int selectedItem)
    {
        this.selectedItem = selectedItem;
        this.selectedItemSet = true;        
    }

    private boolean scrollIncrementSet;
    
    public int getScrollIncrement()
    {
        if (scrollIncrementSet)
        {
            return scrollIncrement;
        }
        ValueBinding vb = getValueBinding("scrollIncrement");
        if (vb != null)
        {
            return ((Integer) vb.getValue(getFacesContext())).intValue();
        }
        return 1; 
    }

    public void setScrollIncrement(int scrollIncrement)
    {
        this.scrollIncrement = scrollIncrement;
        this.scrollIncrementSet = true;        
    }

    private boolean circularSet;
    
    public boolean isCircular()
    {
        if (circularSet)
        {
            return circular;
        }
        ValueBinding vb = getValueBinding("circular");
        if (vb != null)
        {
            return ((Boolean) vb.getValue(getFacesContext())).booleanValue();
        }
        return false; 
    }

    public void setCircular(boolean circular)
    {
        this.circular = circular;
        this.circularSet = true;        
    }

    private boolean verticalSet;
    
    public boolean isVertical()
    {
        if (verticalSet)
        {
            return vertical;
        }
        ValueBinding vb = getValueBinding("vertical");
        if (vb != null)
        {
            return ((Boolean) vb.getValue(getFacesContext())).booleanValue();
        }
        return false; 
    }

    public void setVertical(boolean vertical)
    {
        this.vertical = vertical;
        this.verticalSet = true;        
    }

    private boolean autoplaySet;
    
    public int getAutoplay()
    {
        if (autoplaySet)
        {
            return autoplay;
        }
        ValueBinding vb = getValueBinding("autoplay");
        if (vb != null)
        {
            return ((Integer) vb.getValue(getFacesContext())).intValue();
        }
        return 0; 
    }

    public void setAutoplay(int autoplay)
    {
        this.autoplay = autoplay;
        this.autoplaySet = true;        
    }

    private boolean revealAmountSet;
    
    public int getRevealAmount()
    {
        if (revealAmountSet)
        {
            return revealAmount;
        }
        ValueBinding vb = getValueBinding("revealAmount");
        if (vb != null)
        {
            return ((Integer) vb.getValue(getFacesContext())).intValue();
        }
        return 0; 
    }

    public void setRevealAmount(int revealAmount)
    {
        this.revealAmount = revealAmount;
        this.revealAmountSet = true;        
    }

    private boolean animateSet;
    
    public boolean isAnimate()
    {
        if (animateSet)
        {
            return animate;
        }
        ValueBinding vb = getValueBinding("animate");
        if (vb != null)
        {
            return ((Boolean) vb.getValue(getFacesContext())).booleanValue();
        }
        return true; 
    }

    public void setAnimate(boolean animate)
    {
        this.animate = animate;
        this.animateSet = true;        
    }

    private boolean speedSet;
    
    public double getSpeed()
    {
        if (speedSet)
        {
            return speed;
        }
        ValueBinding vb = getValueBinding("speed");
        if (vb != null)
        {
            return ((Double) vb.getValue(getFacesContext())).doubleValue();
        }
        return 0.5; 
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
        this.speedSet = true;        
    }

    public String getEffect()
    {
        if (effect != null)
        {
            return effect;
        }
        ValueBinding vb = getValueBinding("effect");
        if (vb != null)
        {
            return (String) vb.getValue(getFacesContext()).toString();
        }
        return null;
    }

    public void setEffect(String effect)
    {
        this.effect = effect;
    }

    public Object saveState(FacesContext facesContext)
    {
        Object[] values = new Object[18];
        values[0] = super.saveState(facesContext);
        values[1] = new Integer(selectedItem);
        values[2] = Boolean.valueOf(selectedItemSet);
        values[3] = new Integer(scrollIncrement);
        values[4] = Boolean.valueOf(scrollIncrementSet);
        values[5] = Boolean.valueOf(circular);
        values[6] = Boolean.valueOf(circularSet);
        values[7] = Boolean.valueOf(vertical);
        values[8] = Boolean.valueOf(verticalSet);
        values[9] = new Integer(autoplay);
        values[10] = Boolean.valueOf(autoplaySet);
        values[11] = new Integer(revealAmount);
        values[12] = Boolean.valueOf(revealAmountSet);
        values[13] = Boolean.valueOf(animate);
        values[14] = Boolean.valueOf(animateSet);
        values[15] = new Double(speed);
        values[16] = Boolean.valueOf(speedSet);
        values[17] = effect;
        return values; 
    }

    public void restoreState(FacesContext facesContext, Object state)
    {
        Object[] values = (Object[])state;
        super.restoreState(facesContext,values[0]);
        selectedItem = ((Integer) values[1]).intValue();
        selectedItemSet = ((Boolean) values[2]).booleanValue();
        scrollIncrement = ((Integer) values[3]).intValue();
        scrollIncrementSet = ((Boolean) values[4]).booleanValue();
        circular = ((Boolean) values[5]).booleanValue();
        circularSet = ((Boolean) values[6]).booleanValue();
        vertical = ((Boolean) values[7]).booleanValue();
        verticalSet = ((Boolean) values[8]).booleanValue();
        autoplay = ((Integer) values[9]).intValue();
        autoplaySet = ((Boolean) values[10]).booleanValue();
        revealAmount = ((Integer) values[11]).intValue();
        revealAmountSet = ((Boolean) values[12]).booleanValue();
        animate = ((Boolean) values[13]).booleanValue();
        animateSet = ((Boolean) values[14]).booleanValue();
        speed = ((Double) values[15]).doubleValue();
        speedSet = ((Boolean) values[16]).booleanValue();
        effect = (java.lang.String) values[17];
    }
}
