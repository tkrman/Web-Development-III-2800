/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.termproject1_converters;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author A. V. Markou
 */
public  class MyString3 implements Serializable
{

    private String s;
    public MyString3()
    {
    }
    public MyString3( String s )
    {
        this.s = s;
    }
    public String getS()
    {
        return s;
    }

    public void setS(String s)
    {
        System.out.println("set s called "+ s);
        this.s = s;
    }

  

    @Override
    public String toString()
    {
        return  this.s;
    }
    
    
    
}
