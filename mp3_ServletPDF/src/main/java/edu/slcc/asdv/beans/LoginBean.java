/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.database.Login;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author idont
 */
@Named(value = "loginBean")
@ViewScoped
public class LoginBean implements Serializable
{   
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String validateCredentials() throws SQLException
    {
        ResultSet results = Login.getAllLogin();//5) results set to null to Login classes' getAllLogin() method
        String navigate = "login";
        
        while (results.next()) //6) calls results.next() however it's unable b/c there's nothing to point to, it crashes. BUT WHY THOUGH! I HATE NETBEANS MAY IT ROT IN HELL!!!
        {
            if (getUsername().equals(results.getString("username")) && getPassword().equals(results.getString("password"))) 
            {
                navigate = "index";
                results.close();
                return navigate;
            }
        }
        results.close();
        return navigate;
    }
    

}
