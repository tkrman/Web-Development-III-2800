/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author idont
 */
public class Database 
{
    private static Connection connection() //throws InstantiationException, IllegalAccessException
    {
        String databaseName = "downloads";
        String userName = "root";
        String password = "";
        String URL2 = "com.mysql.jdbc.Driver";
        Connection con = null;
        try
          {// Load Sun's jdbc driver
            Class.forName(URL2).newInstance();
            System.out.println("JDBC Driver loaded!");
          }
        catch (Exception e) // driver not found
          {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            return null;
          }
        String ip = "localhost"; //internet connection
        String url = "jdbc:mysql://" + ip + ":3306/" + databaseName;
        try
          {
            con = DriverManager.getConnection(url, userName, password);
            con.setReadOnly(false);
          }
        catch (Exception e)
          {
            System.err.println(e.toString());
            return null;
          }
        System.out.println("connection successfull");
        return con;
    }
    
    public static int saveFile( String fileName, String extension)
    {
        int count = -1;
        File f = null;
        Connection con = connection();
        if (con == null)
        {
            System.out.println("cannot connect to database");
            return -1;
        }
        try
        {
            PreparedStatement ps = null;

            String sqlStr = "INSERT INTO binary_files (file_name , file_extension, size_kb, binary_data )VALUES(?,?,?,?)";
            ps = con.prepareStatement(sqlStr);

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            ServletContext sc = (ServletContext) externalContext.getContext();
            String sPath = sc.getRealPath("WEB-INF");
            Path path = Paths.get(sPath + "/" + fileName);
            Path path1 = FileSystems.getDefault().getPath(sPath, fileName);
             f = path.toFile();
            long fileLength = f.length();
            String s = path.toString();
            ps.setString(1, fileName);
            ps.setString(2, extension);
            ps.setLong(3, fileLength/1000);

            FileInputStream fis = 
                    new FileInputStream(f);
            ps.setBinaryStream(4, fis, fileLength);
            //execute
            count = ps.executeUpdate();
        }
        catch (   FileNotFoundException e )
        {
               System.out.println("method Database:saveFile " + e);
  
        }
        catch (SQLException e)
        {
            System.out.println("method Database:saveFile " + e);
        }
        finally
        {
            try
            {
                if ( f!= null )
                    f.delete();//delete the uploaded file
                con.close();
            }
            catch (SQLException e)
            {
                System.out.println("connection did not close...method Database:saveFile " + e);
                return -1;
            }
        }
        
      return count;  

    }
    
    
    public static void main(String[] args) 
    {
        connection();
    }
}
