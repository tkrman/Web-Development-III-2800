/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package menus;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.DefaultSubMenu.Builder;
import org.primefaces.model.menu.MenuModel;

@Named(value = "menuBar")
@ViewScoped
public class MenuBar implements Serializable
{

    @Inject
    Math math;

    private MenuModel model = new DefaultMenuModel();
    private List<List<Object>> menus = new ArrayList<List<Object>>();

    public MenuModel getModel()
    {
        return model;
    }

    public DefaultSubMenu addMenu(String label, String... items)
    {
        return addMenu(null, label, items);
    }

    public DefaultSubMenu addMenu(DefaultSubMenu parentMenu, String label, String... items)
    {
        System.out.println("addMenu called");
        Builder b = DefaultSubMenu.builder();
        b.label(label);
        //b.id(label);

        DefaultSubMenu theSubMenu = b.build();

        //create the menu items to add to the submenu
        for (Object item : items)
        {

            DefaultMenuItem.Builder bld = DefaultMenuItem.builder();
            bld.value(item);
            //bld.icon(label);
            //bld.url("https://www.youtube.com/watch?v=lepdqiCF-W8");

            bld.command("#{menuBar." + item.toString().toLowerCase() + "}");
            System.out.println(item.toString());
            DefaultMenuItem menuItem = bld.build();
            theSubMenu.getElements().add(menuItem);

        }

        if (parentMenu == null)
        {
            this.model.getElements().add(theSubMenu);
        }
        else
        {
            parentMenu.setStyleClass("aSubMenu");
            parentMenu.getElements().add(theSubMenu);
        }
        return theSubMenu;

    }

    public void initializeMenu(List<Object>... list)
    {
        for (int i = 0; i < list.length; ++i)
        {
            this.menus.add(list[i]);
        }
        putMenuItemsIn();
    }

    private void putMenuItemsIn()
    {
        for (int i = 0; i < this.menus.size(); ++i)
        {
            List<Object> oneMenu = menus.get(i);
            String label = (String) oneMenu.get(0);
            String[] items = new String[oneMenu.size() - 1];
            for (int j = 1; j < oneMenu.size(); ++j)
            {
                items[j - 1] = (String) oneMenu.get(j);
            }
            addMenu(label, items);
        }
    }

    public void add(MenuActionEvent event)
    {
        System.out.println("******************File( MenuActionEvent event )");
        math.add();

        System.out.println(event.getMenuItem().toString());
        String componentId = "form_math:result";
        PrimeFaces.current().ajax().update(componentId);
    }
    
    public void multiply(MenuActionEvent event)
    {
        System.out.println("******************File( MenuActionEvent event )");
        math.multiply();

        System.out.println(event.getMenuItem().toString());
        String componentId = "form_math:result";
        PrimeFaces.current().ajax().update(componentId);
    }
    
    public void subtract(MenuActionEvent event)
    {
        System.out.println("******************File( MenuActionEvent event )");
        math.subtract();

        System.out.println(event.getMenuItem().toString());
        String componentId = "form_math:result";
        PrimeFaces.current().ajax().update(componentId);
    }
}
