/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package matrices;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author idont
 */
@Named(value = "myString")
@SessionScoped
public class MyString implements Serializable 
{
    private String s;

    public MyString() 
    {
        
    }

    public MyString(String s) 
    {
        this.s = s;
    }
        

    public String getS() 
    {
        return s;
    }

    public void setS(String s) 
    {
        this.s = s;
    }

    @Override
    public String toString() 
    {
        return s;
    }
    
    
    
    
    
    
}
