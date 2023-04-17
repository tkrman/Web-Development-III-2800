/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;

/**
 *
 * @author idont
 */
@Named(value = "menuConversions")
@ViewScoped
public class MenuConversions implements Serializable {

    /**
     * Creates a new instance of MenuConversions
     */
    public MenuConversions() {
    }
    
    public void toExcel()
    {
        callServletExcel();
    }
    
    public void callServletExcel()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpSession session = request.getSession();
            //session.setAttribute("song", "last.mp3");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/servletExcel");
            dispatcher.forward(request, response);

          }
        catch (Exception e)
          {
            e.printStackTrace();
          }
        finally
          {
            context.responseComplete();
          }
    }
    
    
    
    
}
