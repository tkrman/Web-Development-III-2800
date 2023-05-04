/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

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
public class Database {

    public static Map<String, ArrayList<String>> getAllEmployees() throws SQLException {
        Map<String, ArrayList<String>> employees = new LinkedHashMap<>();
        String test = "";

        Connection con = connection();
        if (con == null) {
            System.out.println("cannot connect to database");
            return null;
        }
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM employee");

            while (result.next()) {
                String name = result.getString(1) + " ";
                //String sName = result.getString(2) + " ";
                //String status = result.getInt(3) + " ";
                String bdate = result.getDate(2) + " ";
                String age = result.getInt(3) + " ";

                ArrayList<String> employeeList = new ArrayList<>();
                employeeList.add(bdate);
                employeeList.add(age);

                employees.put(name, employeeList);
            }
//            for (int i = 0; i < employees.size(); i++)
//            {
//                System.out.println("ROW " + i + ":");
//                for (Map.Entry<String, String> mapElement :employees.get(i).entrySet()) 
//                {
//                    String key = mapElement.getKey();
//                    String value = mapElement.getValue();
//                    System.out.print(key + " : " + value + " ");
//                }
//            }
            for (Map.Entry<String, ArrayList<String>> entry : employees.entrySet()) 
            { 
                System.out.println(entry.getKey() + " = " + entry.getValue()); 
            } 

            return employees;
            
        } finally {
            //  con.close();
        }
    }

    private static Connection connection() //throws InstantiationException, IllegalAccessException
    {
        String databaseName = "final";
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

    public static void main(String[] args) throws SQLException {
        String databaseName = "final";
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
        try {
            con = DriverManager.getConnection(url, userName, password);
            con.setReadOnly(false);
        } catch (Exception e) {
            System.err.println(e.toString());
            //return null;
        }
        System.out.println("connection successfull");
        Map<String, ArrayList<String>> test = getAllEmployees();
        //return con;
    }

}
