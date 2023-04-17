/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.slcc.asdv.servlets;
import database.Suppliers;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

@WebServlet("/userTableSpreadsheet")
public class UserTableSpreadsheetServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException
    {
                //>create the workbook, its worksheet, and its title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Supplier table");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("The Supplier table");

                //>create the header row
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("SupplierNumber");
        row.createCell(1).setCellValue("SupplierName");
        row.createCell(2).setCellValue("Status");
        row.createCell(3).setCellValue("City");

        try
          {
            ResultSet results = (ResultSet) Suppliers.getAllSuppliers();

                    //>> create the spreadsheet rows
            int i = 3;//row number
            while (results.next())
              {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue( results.getString("snumber"));
                row.createCell(1).setCellValue( results.getString("sname"));
                row.createCell(2).setCellValue(results.getInt("status") );
                row.createCell(3).setCellValue(results.getString("city"));
                i++;
              }
            results.close();
          }
        catch (SQLException e) {this.log(e.toString());}

            //> set the response headers
        response.setHeader("content-disposition", "attachment; filename=users.xls");       
        response.setHeader("cache-control", "no-cache");

            //> get the output stream from responsed
            //and send the workbook to the browser
        OutputStream out = response.getOutputStream();
        workbook.write(   out   );
        out.close();
    }
}