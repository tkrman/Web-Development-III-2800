package edu.slcc.asdv.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Named(value = "callServletBean")
@SessionScoped
public class CallServletBean implements Serializable
{
    
  /**
     * Creates a new instance of CallServletBean
     */
    public CallServletBean()
    {
    }
 


  

    public void callServlet()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpSession session = request.getSession();
            //session.setAttribute("song", "last.mp3");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DownloadServlet");
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
    
    
    public void callServletMovie()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpSession session = request.getSession();
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
    
    
    public void callServletMusic()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpSession session = request.getSession();
            //session.setAttribute("song", "last.mp3");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/musicServlet");
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
    
    public void callServletPdf1()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpSession session = request.getSession();
            //session.setAttribute("song", "last.mp3");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pdfServlet1");
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
    
    public void callServletPdf2()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpSession session = request.getSession();
            //session.setAttribute("song", "last.mp3");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pdfServlet2");
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


