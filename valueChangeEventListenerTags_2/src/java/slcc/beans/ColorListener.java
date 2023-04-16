/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package slcc.beans;

import jakarta.faces.application.Application;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;


/**
 *
 * @author idont
 */

public class ColorListener implements ValueChangeListener
{
    @Override
    public void processValueChange(ValueChangeEvent event)
            throws AbortProcessingException
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        RegisterForm rb = application.evaluateExpressionGet(
                context, "#{registerForm}",
                RegisterForm.class);
        System.out.println(rb);   
        
        if ("en_US".equals(event.getNewValue()))
        {
            rb.setBackground("background: green;");
        }
        else if("en_CA".equals(event.getNewValue()))
          {
            rb.setBackground("background: blue;");
          }
        else if("el".equals(event.getNewValue()))
        {
            rb.setBackground("background: purple;");
        }
        else if("ja_JP".equals(event.getNewValue()))
        {
            rb.setBackground("background: red;");
        }
        
    }
    
}
