// WARNING: This file was automatically generated. Do not edit it directly,
//          or you will lose your changes.
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
public class CarouselTag
    extends javax.faces.webapp.UIComponentTag
{
    public CarouselTag()
    {    
    }
    
    public String getComponentType()
    {
        return "org.jquery4jsf.HtmlCarousel";
    }

    public String getRendererType()
    {
        return "org.jquery4jsf.custom.CarouselRenderer";
    }

 
    private String selectedItem;
    
    public void setSelectedItem(String selectedItem)
    {
        this.selectedItem = selectedItem;
    }
 
    private String scrollIncrement;
    
    public void setScrollIncrement(String scrollIncrement)
    {
        this.scrollIncrement = scrollIncrement;
    }
 
    private String circular;
    
    public void setCircular(String circular)
    {
        this.circular = circular;
    }
 
    private String vertical;
    
    public void setVertical(String vertical)
    {
        this.vertical = vertical;
    }
 
    private String autoplay;
    
    public void setAutoplay(String autoplay)
    {
        this.autoplay = autoplay;
    }
 
    private String revealAmount;
    
    public void setRevealAmount(String revealAmount)
    {
        this.revealAmount = revealAmount;
    }
 
    private String animate;
    
    public void setAnimate(String animate)
    {
        this.animate = animate;
    }
 
    private String speed;
    
    public void setSpeed(String speed)
    {
        this.speed = speed;
    }
 
    private String effect;
    
    public void setEffect(String effect)
    {
        this.effect = effect;
    }

    protected void setProperties(UIComponent component)
    {
        if (!(component instanceof org.jquery4jsf.custom.carousel.Carousel))
        {
            throw new IllegalArgumentException("Component "+
                component.getClass().getName() +" is no org.jquery4jsf.custom.carousel.Carousel");
        }
        
        org.jquery4jsf.custom.carousel.Carousel comp = (org.jquery4jsf.custom.carousel.Carousel) component;
        
        super.setProperties(component);
        
        FacesContext context = getFacesContext();

        if (selectedItem != null)
        {
            if (isValueReference(selectedItem))
            {
                ValueBinding vb = context.getApplication().createValueBinding(selectedItem);
                comp.setValueBinding("selectedItem", vb);
            }
            else
            {
                comp.getAttributes().put("selectedItem", Integer.valueOf(selectedItem));
            }
        } 
        if (scrollIncrement != null)
        {
            if (isValueReference(scrollIncrement))
            {
                ValueBinding vb = context.getApplication().createValueBinding(scrollIncrement);
                comp.setValueBinding("scrollIncrement", vb);
            }
            else
            {
                comp.getAttributes().put("scrollIncrement", Integer.valueOf(scrollIncrement));
            }
        } 
        if (circular != null)
        {
            if (isValueReference(circular))
            {
                ValueBinding vb = context.getApplication().createValueBinding(circular);
                comp.setValueBinding("circular", vb);
            }
            else
            {
                comp.getAttributes().put("circular", Boolean.valueOf(circular));
            }
        } 
        if (vertical != null)
        {
            if (isValueReference(vertical))
            {
                ValueBinding vb = context.getApplication().createValueBinding(vertical);
                comp.setValueBinding("vertical", vb);
            }
            else
            {
                comp.getAttributes().put("vertical", Boolean.valueOf(vertical));
            }
        } 
        if (autoplay != null)
        {
            if (isValueReference(autoplay))
            {
                ValueBinding vb = context.getApplication().createValueBinding(autoplay);
                comp.setValueBinding("autoplay", vb);
            }
            else
            {
                comp.getAttributes().put("autoplay", Integer.valueOf(autoplay));
            }
        } 
        if (revealAmount != null)
        {
            if (isValueReference(revealAmount))
            {
                ValueBinding vb = context.getApplication().createValueBinding(revealAmount);
                comp.setValueBinding("revealAmount", vb);
            }
            else
            {
                comp.getAttributes().put("revealAmount", Integer.valueOf(revealAmount));
            }
        } 
        if (animate != null)
        {
            if (isValueReference(animate))
            {
                ValueBinding vb = context.getApplication().createValueBinding(animate);
                comp.setValueBinding("animate", vb);
            }
            else
            {
                comp.getAttributes().put("animate", Boolean.valueOf(animate));
            }
        } 
        if (speed != null)
        {
            if (isValueReference(speed))
            {
                ValueBinding vb = context.getApplication().createValueBinding(speed);
                comp.setValueBinding("speed", vb);
            }
            else
            {
                comp.getAttributes().put("speed", Double.valueOf(speed));
            }
        } 
        if (effect != null)
        {
            if (isValueReference(effect))
            {
                ValueBinding vb = context.getApplication().createValueBinding(effect);
                comp.setValueBinding("effect", vb);
            }
            else
            {
                comp.getAttributes().put("effect", effect);
            }
        } 
    }

    public void release()
    {
        super.release();
        this.selectedItem = null;
        this.scrollIncrement = null;
        this.circular = null;
        this.vertical = null;
        this.autoplay = null;
        this.revealAmount = null;
        this.animate = null;
        this.speed = null;
        this.effect = null;
    }
}