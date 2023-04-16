/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package matrices;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.ArrayDataModel;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author idont
 */
@Named(value = "test6")
@SessionScoped
public class Test6 implements Serializable
{
    ArrayList<ArrayList<MyString>> matrix = new ArrayList<ArrayList<MyString>>();
    private int columns = 2;
    private int rows = 2;
    String valueOfDynamicInputTextFromConverter = "dummy";
    
    public Test6() 
    {
        for (int i = 0; i < this.rows; i++) 
        {
            MyString[] numbers = new MyString[this.columns];
            for (int j = 0; j < this.columns; j++) 
            {
                numbers[j] = new MyString("");
            }
            this.matrix.add(new ArrayList<MyString>(Arrays.asList(numbers)));            
        }
        
    }

    public ArrayList<ArrayList<MyString>> getMatrix() 
    {
        return this.matrix;
    }

    public int getColumns() 
    {
        return columns;
    }

    public void setColumns(int columns) 
    {
        this.columns = columns;
        System.out.println(this.columns);
    }

    public int getRows() 
    {
        return rows;
    }

    public void setRows(int rows) 
    {
        this.rows = rows;
        System.out.println(this.rows);
    }
    
    public void changeRowsColumns()
    {
        ArrayList<ArrayList<MyString>> temp = new ArrayList<ArrayList<MyString>>();
            
        int minCol;
        int minRow;
        
        //makes new blank matrix set to size of current row/column value
        for (int i = 0; i < this.rows; i++) 
        {
            temp.add(new ArrayList<MyString>());
            for (int j = 0; j < this.columns; j++) 
            {
                temp.get(i).add(new MyString(""));
                //temp.get(i).add(j, new MyString(""));
            }
        }
        
        //finds the smallest column size out of the two matrixes
       if( this.matrix.get(0).size() <= temp.get(0).size())
       {
           minCol = this.matrix.get(0).size();
       }
       else
       {
           minCol = temp.get(0).size();
       }
       
       
       //finds the smallest row size out of the two matrixes
       if( this.matrix.size() <= temp.size())
       {
           minRow = this.matrix.size();
       }
       else
       {
           minRow = temp.size();
       }
       
        //transfers the neccessary data into the temp matrix while staying within bounds 
        for (int i = 0; i < minRow; i++) 
        {
            for (int j = 0; j < minCol; j++) 
            {
                temp.get(i).set(j, this.matrix.get(i).get(j));                
            }
        }        
        this.matrix = temp;        
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////
    
    public void listenForKeyUp(int row, int column)
    {
        if ("dummy value".equals(this.valueOfDynamicInputTextFromConverter)) 
        {
            throw new RuntimeException("The AJAX Listener listenForKeyUp() does not have data from row column " + row + ", " + column);
        }
        this.matrix.get(row).set(column, new MyString(this.valueOfDynamicInputTextFromConverter));
        this.valueOfDynamicInputTextFromConverter = "dummy value";
    }
    
    public void receiveDataOfCurrentInputTextFromConverter(String valueFromConverter)
    {
        this.valueOfDynamicInputTextFromConverter = valueFromConverter;
    }
    
    public void printToServer()
    {
        for (ArrayList<MyString> row : this.matrix) 
        {
            for (MyString s : row) 
            {
                System.out.println(s);
            }
        }
        
        System.out.println("rows: " + this.rows);
        System.out.println("rows: " + this.columns);
    }
}
