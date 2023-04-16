package edu.slcc.asdv;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.logging.Level;
import java.util.logging.Logger;
@Named
@RequestScoped
public class AjaxBean
{
    private static final Logger logger
            = Logger.getLogger(AjaxBean.class.getName());
    private String firstName = "default";
    private String lastName;
    private String phone;
    private String age;
    private String address;

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public String getAge()
    {
        return age;
    }
    public void setAge(String age)
    {
        this.age = age;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void ajaxAction(String executeNrender)
    {
        System.out.println(executeNrender);
        logger.log(Level.INFO, "First Name = {0}", this.firstName);
        logger.log(Level.INFO, "Last Name = {0}", this.lastName);
        logger.log(Level.INFO, "Phone = {0}", this.phone);
        logger.log(Level.INFO, "Age = {0}", this.age);
        logger.log(Level.INFO, "Address = {0}", this.address);
        System.out.println("--------------------------------------");
    }
}
