package edu.slcc;

import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;

@Named("user")
@SessionScoped
public class UserBean implements Serializable
{

    private String name = "";
    private String password;

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

    public void validateName(FacesContext fc, UIComponent c, Object value)
    {
        try
          {
            Thread.sleep(200);
          }
        catch (InterruptedException e)
          {
            e.printStackTrace();
          }

        if (((String) value).contains("_"))
          {
            throw new ValidatorException(
                    new FacesMessage("Name cannot contain underscores"));
          }
    }
}
