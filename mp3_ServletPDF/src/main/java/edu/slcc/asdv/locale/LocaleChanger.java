package edu.slcc.asdv.locale;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;




@Named(value = "localeChanger")
@SessionScoped
public class LocaleChanger implements Serializable
{

    private String lang;

    private Map<String, String> languages;

    public LocaleChanger()
    {
        languages = new LinkedHashMap();
        languages.put("English", "EN"); // label, value
        languages.put("Greek", "EL");
        languages.put("Spanish", "ES");
        languages.put("Arabic", "AR");
    }

    public void setLang(String lang)
    {
        this.lang = lang;
    }

    public String getLang()
    {
        return lang;
    }

    public Map<String, String> getLanguages()
    {
        return languages;
    }

    public void changeLocale(ValueChangeEvent event)
    {
        String language = event.getNewValue().toString();
        Locale loc = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(loc);
    }

}
