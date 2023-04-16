/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.termproject1_converters.MyString2;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import org.primefaces.PrimeFaces;

/**
 *
 * @author A. V. Markou
 */
@Named(value = "matrixBeanA")
@ViewScoped
public class MatrixBeanA implements Serializable
{

    ArrayList<ArrayList<MyString2>> matrix = new ArrayList<ArrayList<MyString2>>();
    private int rows = 2;
    private int columns = 2;
    private int rowsOld = 2;
    private int columnsOld = 2;

    String valueOfDynamicInputTextFromConverter = "dummy value";

    /**
     * Creates a new instance of Test1
     */
    public MatrixBeanA()
    {
        for (int i = 0; i < this.rows; ++i)
        {
            MyString2[] numbers = new MyString2[columns];
            for (int j = 0; j < columns; ++j)
            {
                numbers[j] = new MyString2("8");
            }
            this.matrix.add(new ArrayList<MyString2>(Arrays.asList(numbers)));
        }
    }

    public ArrayList<ArrayList<MyString2>> getMatrix()
    {
        return matrix;
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rowsOld = this.rows;
        this.rows = rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void setColumns(int columns)
    {
        this.columnsOld = this.columns;
        this.columns = columns;
    }

    /**
     * Creates a new matrix arraylist of arraylists and copies the existing
     * matrix into the new matrix, upon the this.rows and this.columns If the
     * the matrix is larger bill it with blanks if smaller put part of the old
     * matrix that use to me at (i,j) to the same (i,j) this.matrix is assigned
     * to the new matrix
     */
    public void changeRowsColumns()
    {
        int oldI = 0, newI = 0;
        int oldJ = 0, newJ = 0;

        ArrayList<ArrayList<MyString2>> newMatrix = new ArrayList<ArrayList<MyString2>>();
        for (oldI = 0, newI = 0;
                oldI < this.rowsOld && newI < this.rows;
                ++oldI, ++newI)
        {

            ArrayList<MyString2> oldRow = this.matrix.get(oldI);
            ArrayList<MyString2> newRow = new ArrayList<MyString2>();

            for (oldJ = 0, newJ = 0; oldJ < columnsOld && newJ < columns; ++oldJ, ++newJ)
            {
                newRow.add(oldRow.get(newJ));
            }
            if (columns > newJ)
            {
                for (int i = newJ; i < columns; ++i)
                {
                    newRow.add(new MyString2("1"));
                }
            }
            newMatrix.add(newRow);
        }

        if (rows > newI)
        {
            for (int i = newI; i < rows; ++i)
            {
                ArrayList<MyString2> newRow = new ArrayList<MyString2>();
                for (int j = 0; j < columns; ++j)
                {
                    newRow.add(new MyString2("1"));
                }
                newMatrix.add(newRow);
            }
        }

        this.matrix = newMatrix;
        
       String componentId = "form_matrix_A";
        PrimeFaces.current().ajax().update(componentId, "form_menu");
    }

    /**
     *
     * @param row the row of matrix parameter coming from AJax
     * @param column the column of matrix parameter coming from AJax
     */
    public void listenForKeyUp(int row, int column)
    {
        if ("dummy value".equals(this.valueOfDynamicInputTextFromConverter))
        {
            throw new RuntimeException("The Ajax Listener listenForKeyUp() does "
                    + "not have data for row column) "
                    + row + ", " + column);
        }
        System.out.println("listenForKeyUp ----------------------------");
        System.out.println(
                this.matrix.get(row).set(column, new MyString2(this.valueOfDynamicInputTextFromConverter)
                ));

        this.valueOfDynamicInputTextFromConverter = "dummy value";
    }

    /**
     *
     * @param valueFromConverter data come from the MyStringConverter
     */
    public void recieveDataOfCurrentInputTextFromTheConverter(String valueFromConverter)
    {
        this.valueOfDynamicInputTextFromConverter = valueFromConverter;
    }

    


    
}
