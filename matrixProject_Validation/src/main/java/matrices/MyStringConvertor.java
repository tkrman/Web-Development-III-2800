/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrices;

import jakarta.el.ELContext;
import jakarta.el.ELResolver;
import jakarta.faces.application.Application;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author idont
 */
@FacesConverter("matrices.MyString")
public class MyStringConvertor implements Converter
{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String newValue) 
    {
       Test6 t = MyStringConvertor.getCDIBean("test6");
       t.receiveDataOfCurrentInputTextFromConverter(newValue);
       return new MyString(newValue);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) 
    {
       MyString ms = new MyString(value.toString());
       Test6 t = MyStringConvertor.getCDIBean("test6");
       t.receiveDataOfCurrentInputTextFromConverter(ms.toString());
       
       return ms.toString();
    }
    
    public static <T> T getCDIBean(String nameOfTheBean)
    {
        ELContext elc = FacesContext.getCurrentInstance().getELContext();
        FacesContext fc = FacesContext.getCurrentInstance();
        Application ap = fc.getApplication();
        ELResolver elr = ap.getELResolver();
        return (T) elr.getValue(elc, null, nameOfTheBean);
    }
    
}
