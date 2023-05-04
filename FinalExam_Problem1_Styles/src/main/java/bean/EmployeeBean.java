/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.servlet.jsp.jstl.sql.Result;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;




@Named(value = "employeeBean")
@RequestScoped
public class EmployeeBean
{
    Map<String, ArrayList<String>> output;

    public Map<String, ArrayList<String>> getOutput() {
        return output;
    }

    public void setOutput(Map<String, ArrayList<String>> output) {
        this.output = output;
    }
    
    
    
    public Map<String, ArrayList<String>> getResultSuppliers()
            throws SQLException
    {
        
        output = Database.getAllEmployees();   
        return output;
    }
    
    
    
}
