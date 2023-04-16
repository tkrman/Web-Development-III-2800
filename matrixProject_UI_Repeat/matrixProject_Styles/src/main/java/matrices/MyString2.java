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
public  class MyString2 implements Serializable
{

    private String s;
    public MyString2()
    {
    }
    public MyString2( String s )
    {
        this.s = s;
    }
    public String getS()
    {
        return s;
    }

    public void setS(String s)
    {
        System.out.println("set s called "+ s);
        this.s = s;
    }

  

    @Override
    public String toString()
    {
        return  this.s;
    }
    
    
    
    
    
    
}
