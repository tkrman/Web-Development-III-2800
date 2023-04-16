/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package menus;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author ASDV1
 */
@Named(value = "math")
@ViewScoped
public class Math implements Serializable
{

    private String number1 ="0";
    private String number2 ="0";
    private String result = "0";

    public String getNumber1()
    {
        return number1;
    }

    public void setNumber1(String number1)
    {
        this.number1 = number1;
    }

    public String getNumber2()
    {
        return number2;
    }

    public void setNumber2(String number2)
    {
        this.number2 = number2;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }
    

    public String add()
    {
        System.out.println("add of Math bean called");

        result = String.valueOf(Integer.parseInt(number1) + Integer.parseInt(number2));
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(result);
        return "";
    }
    
    public String subtract()
    {
        System.out.println("subtract of Math bean called");

        result = String.valueOf(Integer.parseInt(number1) - Integer.parseInt(number2));
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(result);
        return "";
    }
    
    public String multiply()
    {
        System.out.println("subtract of Math bean called");

        result = String.valueOf(Integer.parseInt(number1) * Integer.parseInt(number2));
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(result);
        return "";
    }
}
