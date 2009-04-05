package org.jquery4jsf.el;

import javax.el.MethodNotFoundException;
import javax.faces.component.StateHolder;
import javax.faces.context.FacesContext;
import javax.faces.el.EvaluationException;
import javax.faces.el.MethodBinding;

public class JQueryMethodBinding extends MethodBinding
        implements StateHolder
{
    private String outcome;
    private boolean _transient = false;


    public JQueryMethodBinding()
    {
    	outcome = null;
    }

    public JQueryMethodBinding(String outcome)
    {
    	this.outcome = outcome;
    }

    public Object invoke(FacesContext facescontext, Object aobj[]) throws EvaluationException, MethodNotFoundException
    {
    	return outcome;
    }

    public Class getType(FacesContext facescontext) throws MethodNotFoundException
    {
    	return String.class;
    }




    public Object saveState(FacesContext facescontext)
    {
    	return outcome;
    }

    public void restoreState(FacesContext facescontext, Object obj)
    {
    	outcome = (String)obj;
    }

    public boolean isTransient()
    {
    	return _transient;
    }

    public void setTransient(boolean flag)
    {
    	_transient = flag;
    }

    public String toString()
    {
    	return outcome;
    }
}
