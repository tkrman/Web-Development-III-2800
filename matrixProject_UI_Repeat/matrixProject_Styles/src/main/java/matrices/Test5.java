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
import java.util.Iterator;
import matrices.MyString;

/**
 *
 * @author idont
 */
@Named(value = "test5")
@SessionScoped
public class Test5 implements Serializable
{
    ArrayList<ArrayDataModel<MyString>> matrix = new ArrayList<ArrayDataModel<MyString>>();
    ArrayDataModel<MyString> model = new ArrayDataModel<MyString>();
    private int columns = 2;
    private int rows = 2;
    

    public Test5() 
    {
        for (int i = 0; i < this.rows; i++) 
        {
            MyString[] numbers = new MyString[this.columns];
            for (int j = 0; j < this.columns; j++) 
            {
                numbers[j] = new MyString(Double.toString(Math.random()));
            }
            model = new ArrayDataModel<MyString>(numbers);//this model can be local var,
            this.matrix.add(model);
        }
        
    }

    public ArrayList<ArrayDataModel<MyString>> getMatrix() 
    {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayDataModel<MyString>> matrix) 
    {
        this.matrix = matrix;
    }
    

    public ArrayDataModel<MyString> getModel() 
    {
        return model;
    }

    public void setModel(ArrayDataModel<MyString> model) 
    {
        this.model = model;
    }

    public int getColumns() 
    {
        return columns;
    }

    public void setColumns(int columns) 
    {
        System.out.println("col has been set to " + columns);
        this.columns = columns;
        update();
    }

    public int getRows() 
    {
        return rows;
    }

    public void setRows(int rows) 
    {
        System.out.println("row has been set to " + rows);
        this.rows = rows;
        update();
    }
    
    public void printToServer()
    {
        for (int i = 0; i < this.matrix.size(); i++) 
        {
            this.model = this.matrix.get(i);
            Iterator it = this.model.iterator();
            while (it.hasNext()) 
            {
                System.out.println(it.next() + " ");
            }
        }
    }
    
    public void update()
    {
        this.matrix = new ArrayList<ArrayDataModel<MyString>>();
        this.model = new ArrayDataModel<MyString>();
        
        //System.out.println("row count: " + rows);
        //System.out.println("col count: " + columns);
        
        for (int i = 0; i < this.rows; i++) 
        {
            MyString[] numbers = new MyString[this.columns];
            for (int j = 0; j < this.columns; j++) 
            {
                numbers[j] = new MyString(Double.toString(Math.random()));
            }
            model = new ArrayDataModel<MyString>(numbers);//this model can be local var,
            this.matrix.add(model);
        }
        
    }

}
