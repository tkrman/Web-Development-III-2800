package edu.slcc.asdv.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Login
{

    public static ResultSet getAllLogin() throws SQLException
    {
        Connection con = connection();
        if (con == null)//3) con returns null from the connection method
          {
            System.out.println("cannot connect to database");
            return null; //4) returns null here thus resulting in the ResultSet to be null
          }
        try
          {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sqlStr = "SELECT  *  FROM credentials";

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
        String databaseName = "login";
        String userName = "root";
        String password = "";
        String URL2 = "com.mysql.jdbc.Driver";
        Connection con = null;
        try
          {// Load Sun's jdbc driver
            Class.forName(URL2).newInstance(); // 1) doesn't work, most likley deprecation
            System.out.println("JDBC Driver loaded!");
          }
        catch (Exception e) // driver not found
          {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            return null; //2) catches exception thus returning null
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
        ResultSet results = Login.getAllLogin();

        while (results.next())
          {

            String s = results.getString("username");
            System.out.println(s);
            results.getString("password");
          }
        results.close();
    }
}


