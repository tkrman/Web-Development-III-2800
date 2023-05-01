/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

//import jakarta.enterprise.context.SessionScoped;
//import jakarta.faces.context.FacesContext;
//import jakarta.faces.event.ValueChangeEvent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.inject.Named;

/**
 *
 * @author asdv
 */
@Named(value = "nameForm")
@SessionScoped
public class NameForm implements Serializable
  {

    public static ArrayList<String> names = new ArrayList<>();
    private String output;
    

    public NameForm() 
    {
        names.add("john");
        names.add("mary");
        String test = names.get(0) + " " + names.get(1);
        setOutput(test);
        
    }

    public String getOutput()
      {
        return output;
      }

    public void setOutput(String output)
      {
        this.output = output;
      }
    

    
    public ArrayList<String> getNames()
    {
        return names;
    }
    
    public void nameListener()
            throws AbortProcessingException
    {
        System.out.println("test");
                
        for (int i = 0; i < 2; i++) 
        {
            names.add("john");
            names.add("mary");
        }
        String s = "";
        for (int i = 0; i < names.size(); i++)
            {
                s += names.get(i) + " ";
            }
        
        setOutput(s);
        
        
    }
    
  }
