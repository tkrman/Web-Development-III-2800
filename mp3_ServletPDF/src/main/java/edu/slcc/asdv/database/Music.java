package edu.slcc.asdv.database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import javax.servlet.jsp.jstl.sql.Result;
//import javax.servlet.jsp.jstl.sql.ResultSupport;

public class Music
{

    public static ResultSet getMusic() throws SQLException
    {
        Connection con = connection();
        if (con == null)
          {
            System.out.println("cannot connect to database");
            return null;
          }
        try
          {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sqlStr = "SELECT file from files where id = 2 ";

            //prepare statement
            ps = con.prepareStatement(sqlStr);
            //execute
            rs = ps.executeQuery();
            return rs; //ResultSupport.toResult(result);
          }
        finally
          {
            //con.close();
          }
    }

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

    public static void main(String[] args)
            throws SQLException, FileNotFoundException, IOException
    {
        ResultSet results = Music.getMusic();

        ResultSetMetaData meta = results.getMetaData();
        int colCount = meta.getColumnCount();
        
        results.next();//position the cursor
        
        Blob blob = results.getBlob("file");
        InputStream is = blob.getBinaryStream();
        FileOutputStream os = new FileOutputStream("last.mp3");
        byte[] bytes = new byte[4096];
        while (is.available() != 0)
          {
            is.read(bytes);
            os.write(bytes);

          }
        results.close();
    }
}
