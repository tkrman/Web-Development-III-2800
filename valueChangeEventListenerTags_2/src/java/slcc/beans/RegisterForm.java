package slcc.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Locale;


@Named("registerForm")
@SessionScoped
public class RegisterForm implements Serializable
{

    private String background = "";
    private String streetAddress;
    private String city;
    private String state;
    private String country;

    private static final Locale[] countries =
      {
        Locale.US, Locale.CANADA, new Locale("EL"), Locale.JAPAN
      };

    public Locale[] getCountries()
    {
        return countries;
    }

    public void setStreetAddress(String newValue)
    {
        streetAddress = newValue;
    }

    public String getStreetAddress()
    {
        return streetAddress;
    }

    public void setCity(String newValue)
    {
        city = newValue;
    }

    public String getCity()
    {
        return city;
    }

    public void setState(String newValue)
    {
        state = newValue;
    }

    public String getState()
    {
        return state;
    }

    public void setCountry(String newValue)
    {
        country = newValue;
    }

    public String getCountry()
    {
        return country;
    }

    public String getBackground() {
        return background;
    }
    
    public void countryChanged(ValueChangeEvent event)
    {
        for (Locale loc : countries)
          {
            if (loc.getCountry().equals(event.getNewValue()))
              {
                FacesContext.getCurrentInstance().getViewRoot().setLocale(loc);
                
              }
          }
    }
    
    public void setBackground(String s)
    {
        background = s;

    }
}

