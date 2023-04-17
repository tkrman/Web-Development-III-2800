/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Suppliers
{

    public static ResultSet getAllSuppliers() throws SQLException
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
            String sqlStr = "SELECT  *  FROM supplier";

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
        String databaseName = "suppliers_parts";
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
        url += "?autoReconnect=true&useSSL=false";
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
            throws SQLException
    {
        ResultSet results = Suppliers.getAllSuppliers();

        while (results.next())
          {

            String s = results.getString("snumber");
            System.out.println(s);
            results.getString("sname");
            results.getInt("status");
            results.getString("city");
          }
        results.close();
    }
}


