/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ASDV2
 */
@Named(value = "callServletBean1")
@SessionScoped
public class CallServletBean1 implements Serializable
{
    
  /**
     * Creates a new instance of CallServletBean
     */
    public CallServletBean1()
    {
    }
 


  

    public void callServletExcel()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();    
            RequestDispatcher dispatcher = request.getRequestDispatcher("/spreadsheetServlet");//call the servlet witha POST request
            dispatcher.forward(request, response);//forward to browser the respnse

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
    
    
    public void callServletMovie()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            //HttpSession session = request.getSession();
            //session.setAttribute("song", "last.mp3");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/movieServlet");
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


