/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import pojos.Employees;;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.jsp.jstl.sql.Result;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;



@Named(value = "employeeBean")
@RequestScoped
public class EmployeeBean
{

 

    public Result getResultSuppliers()
            throws SQLException
    {
        return Employees.getAllSuppliers();
    }
    
    
    
}
