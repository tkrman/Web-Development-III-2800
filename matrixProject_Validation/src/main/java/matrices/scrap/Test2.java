/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package matrices.scrap;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import matrices.MyString;

/**
 *
 * @author idont
 */
@Named(value = "test2")
@SessionScoped
public class Test2 implements Serializable 
{
    private MyString ms;
    private String s;

    public Test2() 
    {
        ms = new MyString("11");
    }
        
    public MyString getMs() 
    {
        return ms;
    }

    public void setMs(MyString ms) 
    {
        this.ms = ms;System.out.println("###########################" + this.ms);
    }

    public String getS() 
    {
        return s;
    }

    public void setS(String s)
    {
        this.s = s;
        System.out.println("*************************" + this.s);
    }
    
    public void test()
    {
        System.out.println(this.s);
        System.out.println(this.ms);
    }
    
    
    
}
