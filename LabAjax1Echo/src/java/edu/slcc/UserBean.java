package edu.slcc;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("user") 
@SessionScoped
public class UserBean implements Serializable
{
    private String name = "";
    private String password;
    private String response = "abc";
    

    public String getName()
    {
        return name;
    }

    public void setName(String newValue)
    {
        name = newValue;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String newValue)
    {
        password = newValue;
    }
    
    public String getResponse()
    {
        return response;
    }
      public String getResponse2()
    {
        response =  Double.toString( Math.random() * 100 );
        return response;
    }  
   
}
