/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package matrices.scrap;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.ArrayDataModel;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Iterator;
import matrices.MyString;

/**
 *
 * @author idont
 */
@Named(value = "test3")
@SessionScoped
public class Test3 implements Serializable
{
    ArrayDataModel<MyString> model = new ArrayDataModel<MyString>();
    private int columns = 2;
    private int rows = 2;
    

    public Test3() 
    {
        MyString[] numbers = new MyString[columns];
        for (int i = 0; i < columns; i++) 
        {
            numbers[i] = new MyString(Double.toString(Math.random()));
        }
        model = new ArrayDataModel<MyString>(numbers);
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
        this.columns = columns;
    }

    public int getRows() 
    {
        return rows;
    }

    public void setRows(int rows) 
    {
        this.rows = rows;
    }
    
    public void printToServer()
    {
        Iterator it = this.model.iterator();
        while (it.hasNext()) 
        {
            System.out.println(it.next() + " ");
        }
    }

}
