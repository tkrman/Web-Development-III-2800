/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Tucker
 */
public class Database 
{
    
    

    public static ArrayList< LinkedHashMap<String, String>> getAllSuppliers() throws SQLException 
    {
        ArrayList< LinkedHashMap<String, String>> suppliers = new ArrayList<>();
        String test = "";
        
        Connection con = connection();
        if (con == null) {
            System.out.println("cannot connect to database");
            return null;
        }
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM supplier");
            
            
            while (result.next()) {
            String sNumber = result.getString(1) + " ";
            String sName = result.getString(2) + " ";
            String status = result.getInt(3) + " ";
            //String bdate = rs.getDate(4) + " ";
            String city = result.getString(4) + " ";

            LinkedHashMap<String, String> supplierMap = new LinkedHashMap<>();
            supplierMap.put("snumber", sNumber);
            supplierMap.put("sname", sName);
            supplierMap.put("status", status);
            supplierMap.put("city", city);

            suppliers.add(supplierMap);
        }
//            for (int i = 0; i < suppliers.size(); i++)
//            {
//                System.out.println("ROW " + i + ":");
//                for (Map.Entry<String, String> mapElement :suppliers.get(i).entrySet()) 
//                {
//                    String key = mapElement.getKey();
//                    String value = mapElement.getValue();
//                    System.out.print(key + " : " + value + " ");
//                }
//            }
                                    
            return suppliers;
        } finally {
            //  con.close();
        }
    }

    private static Connection connection() //throws InstantiationException, IllegalAccessException
    {
        String databaseName = "suppliers_parts";
        String userName = "root";
        String password = "";
        String URL2 = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {// Load Sun's jdbc driver
            Class.forName(URL2).newInstance();
            System.out.println("JDBC Driver loaded!");
        } catch (Exception e) // driver not found
        {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            return null;
        }
        String ip = "localhost"; //internet connection
        String url = "jdbc:mysql://" + ip + ":3306/" + databaseName;
        try {
            con = DriverManager.getConnection(url, userName, password);
            con.setReadOnly(false);
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
        System.out.println("connection successfull");
        return con;
    }
    
    public static void main(String[] args) 
    {
        String databaseName = "suppliers_parts";
        String userName = "root";
        String password = "";
        String URL2 = "com.mysql.jdbc.Driver";
        Connection con = null;
        try {// Load Sun's jdbc driver
            Class.forName(URL2).newInstance();
            System.out.println("JDBC Driver loaded!");
        } catch (Exception e) // driver not found
        {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            //return null;
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
            //return null;
        }
        System.out.println("connection successfull");
        //return con;
    }

}
