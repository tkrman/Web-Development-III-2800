package slcc.beans;

import jakarta.faces.application.Application;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;
import java.util.Locale;



public class CountryListener implements ValueChangeListener
{
    @Override
    public void processValueChange(ValueChangeEvent event)
            throws AbortProcessingException
    {
        System.out.println("processValueChange1------------------");
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("processValueChange2------------------");
        if ("en_US".equals(event.getNewValue()))
          {
            context.getViewRoot().setLocale(Locale.US);
          }
        else if("en_CA".equals(event.getNewValue()))
          {
            context.getViewRoot().setLocale(Locale.CANADA);
          }
        else if("el".equals(event.getNewValue()))
        {
            context.getViewRoot().setLocale(new Locale("EL"));
        }
        else if("ja_JP".equals(event.getNewValue()))
            context.getViewRoot().setLocale(Locale.JAPAN);
            
    }
    
}