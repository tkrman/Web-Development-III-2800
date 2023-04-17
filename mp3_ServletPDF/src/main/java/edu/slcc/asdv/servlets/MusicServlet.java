package edu.slcc.asdv.servlets;

import edu.slcc.asdv.database.Movie;
import edu.slcc.asdv.database.Music;
import edu.slcc.asdv.database.Suppliers;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/musicServlet")
public class MusicServlet
        extends HttpServlet
{

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {

        try
          {
            ResultSet results = Music.getMusic();

            ResultSetMetaData meta = results.getMetaData();
            int colCount = meta.getColumnCount();

            results.next();//position the cursor

            Blob blob = results.getBlob("file");
            response.setContentType("application/mp3");
            // set the response headers
            response.setHeader("content-disposition",
                    "attachment; filename=last.mp3");

            response.setHeader("cache-control", "no-cache");        // get the output stream and send the workbook to the browser

            InputStream in = blob.getBinaryStream();

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
        catch (SQLException e)
          {
            this.log(e.toString());
          }
        finally
          {

          }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {

        ServletContext sc = getServletContext();

        String nameOfMovie = request.getParameter("song");
        try
          {
            ResultSet results = Music.getMusic();

            ResultSetMetaData meta = results.getMetaData();
            int colCount = meta.getColumnCount();

            results.next();//position the cursor

            Blob blob = results.getBlob("file");

            InputStream in = blob.getBinaryStream();
            //FileOutputStream fos = new FileOutputStream( nameOfMovie);

            response.setContentType("application/mp3");
            // set the response headers
            response.setHeader("content-disposition",
                    "attachment; filename=" + nameOfMovie);

            response.setHeader("cache-control", "no-cache");        // get the output stream and send the workbook to the browser

            PrintWriter outResponse = response.getWriter();

            int i = in.read();
            while (i != -1)
              {
                outResponse.write(i);
                //fos.write( i );
                i = in.read();
              }
            in.close();
            outResponse.close();
            //fos.close();

          }
        catch (SQLException e)
          {
            this.log(e.toString());
          }
        finally
          {

          }

    }
}
