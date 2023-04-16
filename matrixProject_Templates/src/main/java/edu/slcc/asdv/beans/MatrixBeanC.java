/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author A. V. Markou
 */
@Named(value = "matrixBeanC")
@ViewScoped
public class MatrixBeanC implements Serializable
{

    private int rows = 2;
    private int columns = 2;
    private int rowsOld = 2;
    private int columnsOld = 2;
    ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

    public MatrixBeanC()
    {
        for (int i = 0; i < this.rows; ++i)
        {
            String[] numbers = new String[columns];
            for (int j = 0; j < columns; ++j)
            {
                numbers[j] = new String("0");
            }
            this.matrix.add(new ArrayList<String>(Arrays.asList(numbers)));
        }
    }

    public ArrayList<ArrayList<String>> getMatrix()
    {

        return matrix;

    }

    public void setMatrix(ArrayList<ArrayList<String>> matrix)
    {
        this.matrix = matrix;
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    public void changeRowsColumns(int rows, int columns)
    {
        int oldI = 0, newI = 0;
        int oldJ = 0, newJ = 0;

        ArrayList<ArrayList<String>> newMatrix = new ArrayList<ArrayList<String>>();
        for (oldI = 0, newI = 0;
                oldI < this.rowsOld && newI < this.rows;
                ++oldI, ++newI)
        {

            ArrayList<String> oldRow = this.matrix.get(oldI);
            ArrayList<String> newRow = new ArrayList<String>();

            for (oldJ = 0, newJ = 0; oldJ < columnsOld && newJ < columns; ++oldJ, ++newJ)
            {
                newRow.add(oldRow.get(newJ));
            }
            if (columns > newJ)
            {
                for (int i = newJ; i < columns; ++i)
                {
                    newRow.add(new String("0"));
                }
            }
            newMatrix.add(newRow);
        }

        if (rows > newI)
        {
            for (int i = newI; i < rows; ++i)
            {
                ArrayList<String> newRow = new ArrayList<String>();
                for (int j = 0; j < columns; ++j)
                {
                    newRow.add(new String("0"));
                }
                newMatrix.add(newRow);
            }
        }

        this.matrix = newMatrix;
   

    }

}
