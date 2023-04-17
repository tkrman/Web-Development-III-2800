/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.slcc.asdv.servlets;

import edu.slcc.asdv.beans.MatrixBeanA;
import edu.slcc.asdv.beans.MatrixBeanB;
import edu.slcc.asdv.beans.MatrixBeanC;
import edu.slcc.asdv.termproject1_converters.MyString2;
import edu.slcc.asdv.termproject1_converters.MyString3;
import edu.slcc.asdv.utilities.Utilities;
import jakarta.faces.component.UIComponent;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

@WebServlet("/servletExcel")
public class ServletExcel extends HttpServlet
{

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException
    {
            //>get the beans
        MatrixBeanA matrixBeanA = Utilities.getCDIBean("matrixBeanA");
        ArrayList<ArrayList<MyString2>> matrixA = matrixBeanA.getMatrix();

        MatrixBeanB matrixBeanB = Utilities.getCDIBean("matrixBeanB");
        ArrayList<ArrayList<MyString3>> matrixB = matrixBeanB.getMatrix();
                //>convert the matrices into strings
        MatrixBeanC matrixBeanC = Utilities.getCDIBean("matrixBeanC");
        ArrayList<ArrayList<String>> matrixCstring = matrixBeanC.getMatrix();
    
        ArrayList<ArrayList<BigInteger>> a = Utilities.convertMyString2ToBigInteger(matrixA);
        ArrayList<ArrayList<String>> matrixAstring = Utilities.convertBigIntegerToString(a);

        ArrayList<ArrayList<BigInteger>> b = Utilities.convertMyString3ToBigInteger(matrixB);
        ArrayList<ArrayList<String>> matrixBstring = Utilities.convertBigIntegerToString(b);
                //> create the excel book
        Workbook workbook = new HSSFWorkbook();
        Sheet sheetMatrixA = workbook.createSheet("Matrix A");
        Sheet sheetMatrixB = workbook.createSheet("Matrix B");
        Sheet sheetMatrixC = workbook.createSheet("Matrix C");
        Row rowA = sheetMatrixA.createRow(0);
        rowA.createCell(0).setCellValue("Matrix A");

        Row rowB = sheetMatrixB.createRow(0);
        rowB.createCell(0).setCellValue("Matrix B");

        Row rowC = sheetMatrixC.createRow(0);
        rowC.createCell(0).setCellValue("Matrix C");
            
                    //>> create sheet matrix A
        for (int i = 0; i < matrixAstring.size(); ++i)
        {
            rowA = sheetMatrixA.createRow(i + 3);
            for (int j = 0; j < matrixAstring.get(i).size(); ++j)
            {
                String number = matrixAstring.get(i).get(j);
                rowA.createCell(j).setCellValue(number);
            }
        }
                    //>> create sheet matrix B
        for (int i = 0; i < matrixBstring.size(); ++i)
        {
            rowB = sheetMatrixB.createRow(i + 3);
            for (int j = 0; j < matrixBstring.get(i).size(); ++j)
            {
                String number = matrixBstring.get(i).get(j);
                rowB.createCell(j).setCellValue(number);
            }
        }
                    //>> create sheet matrix C
        for (int i = 0; i < matrixCstring.size(); ++i)
        {
            rowC = sheetMatrixC.createRow(i + 3);
            for (int j = 0; j < matrixCstring.get(i).size(); ++j)
            {
                String number = matrixCstring.get(i).get(j);
                rowC.createCell(j).setCellValue(number);
            }
        }
                //>set the response headers
        response.setHeader("content-disposition", "attachment; filename=Matrices.xls");
        response.setHeader("cache-control", "no-cache");
                //> get the outstream to send to the brwser
        OutputStream out = response.getOutputStream();
                //> write to the output stream the excel book
        workbook.write(out);
        out.close();
    }
}
