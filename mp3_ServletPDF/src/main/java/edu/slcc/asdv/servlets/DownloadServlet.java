/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ASDV2
 */
public class DownloadServlet extends HttpServlet
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
          {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DownloadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DownloadServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
          }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //processRequest(request, response);
        ServletContext sc = getServletContext();
        //String path = sc.getRealPath("/");
        String path = sc.getRealPath("resources/files");
        String name = request.getParameter("name");

        response.setContentType("application/octet-stream");
        response.setHeader("content-disposition",
                "attachment; filename=" + name);

        FileInputStream in = new FileInputStream(path + "/" + name);
        PrintWriter out = response.getWriter();

        int i = in.read();
        while (i != -1)
          {
            out.write(i);
            i = in.read();
          }
        in.close();
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException
    {
        //processRequest(request, response);
        ServletContext sc = getServletContext();
        
        //String path = sc.getRealPath("/");
        String path = sc.getRealPath("resources/files");
        String name = request.getParameter("song");

        //response.setContentType("application/octet-stream");
                response.setContentType("video/mp4");

        response.setHeader("content-disposition",
                "attachment; filename=" + name);
        String s = path + "/" + name;
        FileInputStream in = new FileInputStream(s);
        PrintWriter out = response.getWriter();

        int i = in.read();
        
        while (i != -1)
          {
            out.write(i);
            i = in.read();
            
          }
        in.close();
        out.close();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

    protected void callMyService(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        System.out.println("callMyService called");
        String name = (String) request.getSession().getAttribute("song");
        System.out.println("inside servlet name:" + name);

        FacesContext context = FacesContext.getCurrentInstance();
        jakarta.faces.application.Application application = context.getApplication();
//CallServletBean bean = application.evaluateExpressionGet(context, "#{callServletBean}", CallServletBean.class);

        //bean.setName( name+ "from the servlet");
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsf");
        //dispatcher.forward(request, response);
    }

}
