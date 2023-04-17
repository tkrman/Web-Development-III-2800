/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.utilities;

import edu.slcc.asdv.termproject1_converters.MyString2;
import edu.slcc.asdv.termproject1_converters.MyString3;
import jakarta.el.ELContext;
import jakarta.el.ELResolver;
import jakarta.faces.application.Application;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import java.math.BigInteger;
import java.util.ArrayList;


public class Utilities
{
    
    public static UIComponent findComponent(String id)
    {

        UIComponent result = null;
        UIComponent root = FacesContext.getCurrentInstance().getViewRoot();
        if (root != null)
        {
            result = findComponent(root, id);
        }
        return result;

    }

    public static UIComponent findComponent(UIComponent root, String id)
    {

        UIComponent result = null;
        if (root.getId().equals(id))
        {
            return root;
        }

        for (UIComponent child : root.getChildren())
        {
            if (child.getId().equals(id))
            {
                result = child;
                break;
            }
            result = findComponent(child, id);
            if (result != null)
            {
                break;
            }
        }
        return result;

    }

    public static void printIDs(UIComponent component)
    {
       System.out.println("\n\nPARENT ID " + component.getId());

        if (component.getChildren() == null)
        {
            return;
        }

        for (UIComponent child : component.getChildren())
        {
             System.out.println("\t\tCHILD ID " + child.getId());

            printIDs(child);

        }
    }

public static boolean isNumberOrDecimal( String s )
{
    System.out.println("isNumberOrDecimal called " + s);
    //[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)
    String regx = "^[+-]?(\\d*\\.)?\\d+$";
    return s.matches(regx);
    
}
      public static void message( FacesMessage.Severity severity, String msg, String msgDetails)
    {
        FacesMessage m = new FacesMessage(severity, msg, msgDetails);
        FacesContext.getCurrentInstance().addMessage("msg", m);
    }  
      
      
      public static <T> T getCDIBean(String nameOfTheBean)
    {
        ELContext elc = FacesContext.getCurrentInstance().getELContext();
        FacesContext fc = FacesContext.getCurrentInstance();
        Application ap = fc.getApplication();
        ELResolver elr = ap.getELResolver();
        return (T) elr.getValue(elc, null, nameOfTheBean);    
    }
      
      
   public static ArrayList<ArrayList<String>> convertBigIntegerToString(ArrayList<ArrayList<BigInteger>> matrix)
    {
        ArrayList<ArrayList<String>> stringMatrix = new ArrayList<ArrayList<String>>();

        for (ArrayList<BigInteger> row : matrix)
        {
            ArrayList<String> stringRow = new ArrayList<String>();
            for (BigInteger bigInt : row)
            {
                stringRow.add(new String(bigInt.toString()));

            }
            stringMatrix.add(stringRow);
        }
        return stringMatrix;
    }
    public static ArrayList<ArrayList<BigInteger>> convertMyString2ToBigInteger(ArrayList<ArrayList<MyString2>> matrix)
    {
        ArrayList<ArrayList<BigInteger>> bigIntMatrix = new ArrayList<ArrayList<BigInteger>>();

        for (ArrayList<MyString2> row : matrix)
        {
            ArrayList<BigInteger> bigInteRow = new ArrayList<BigInteger>();
            for (MyString2 s : row)
            {
                bigInteRow.add(new BigInteger(s.toString()));

            }
            bigIntMatrix.add(bigInteRow);
        }
        return bigIntMatrix;
    }

    public static ArrayList<ArrayList<BigInteger>> convertMyString3ToBigInteger(ArrayList<ArrayList<MyString3>> matrix)
    {
        ArrayList<ArrayList<BigInteger>> bigIntMatrix = new ArrayList<ArrayList<BigInteger>>();

        for (ArrayList<MyString3> row : matrix)
        {
            ArrayList<BigInteger> bigInteRow = new ArrayList<BigInteger>();
            for (MyString3 s : row)
            {
                bigInteRow.add(new BigInteger(s.toString()));

            }
            bigIntMatrix.add(bigInteRow);
        }
        return bigIntMatrix;
    }

}
