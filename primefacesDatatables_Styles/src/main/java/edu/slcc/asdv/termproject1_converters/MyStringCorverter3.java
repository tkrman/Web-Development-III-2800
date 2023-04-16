/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.termproject1_converters;

import jakarta.el.ELContext;
import jakarta.el.ELResolver;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.application.Application;
import edu.slcc.asdv.beans.MatrixBeanA;
import edu.slcc.asdv.beans.MatrixBeanB;

/**
 *
 * @author A. V. Markou
 */
@FacesConverter("edu.slcc.asdv.termproject1_converters.MyString3")
public class MyStringCorverter3 implements Converter
{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String newValue)
    {

        MatrixBeanB t = MyStringCorverter3.getCDIBean("matrixBeanB");
        t.recieveDataOfCurrentInputTextFromTheConverter( newValue );
        return new MyString3( newValue );
    }
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value)
    {

        MyString3 ms = new MyString3(value.toString());
        MatrixBeanB t = MyStringCorverter3.getCDIBean("matrixBeanB");
        t.recieveDataOfCurrentInputTextFromTheConverter( ms.toString() );

        return ms.toString();
    }
/**
 * 
 * @param <T>  T for any type of bean
 * @param nameOfTheBean the name of the  bean
 * @return the CDI bean or null if it does not exit
 */
    public static <T> T getCDIBean(String nameOfTheBean)
    {
        ELContext elc = FacesContext.getCurrentInstance().getELContext();
        FacesContext fc = FacesContext.getCurrentInstance();
        Application ap = fc.getApplication();
        ELResolver elr = ap.getELResolver();
        return (T) elr.getValue(elc, null, nameOfTheBean);    
    }

}
