
package edu.slcc.asdv.beans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.FacesMessage.Severity;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.PrimeFaces;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@Named(value = "menuBar")
@ViewScoped
public class MenuBar implements Serializable
{

    @Inject
    MatrixOperations matrixOperations;
    private List<List<Object>> menus = new ArrayList<List<Object>>();


    public void add()
    {
        System.out.println("menu add was called");

        System.out.println("menu bar add()");
        matrixOperations.add();///adition of matrices

        List<String> idsC = new ArrayList();
        idsC.add("formC");
        idsC.add("formC:datatableC");
        idsC.add("formC:datatableC:columnsC");
        idsC.add("formC:datatableC:columnsC:inputTextC");
        //idsC.add("form-menu");//:menuBar:submenu_matrices:menuitem_add");
        PrimeFaces.current().ajax().update(idsC);

    }

    public void multiply()
    {
        System.out.println("menu multiply was called");

        int rowsOfMatrixC = matrixOperations.getMatrixA().getRows();

        int columnsOfMatrixC = matrixOperations.getMatrixB().getColumns();
        System.out.println("rows " + rowsOfMatrixC);
        System.out.println("columns " + columnsOfMatrixC);
        MatrixBeanC c = matrixOperations.getMatrixC();
        c.changeRowsColumns(rowsOfMatrixC, columnsOfMatrixC);
        matrixOperations.multiply();
        List<String> idsC = new ArrayList();
        idsC.add("formC");
        idsC.add("formC:datatableC");
        idsC.add("formC:datatableC:columnsC");
        idsC.add("formC:datatableC:columnsC:inputTextC");
        PrimeFaces.current().ajax().update(idsC);

    }

    public void subtract()
    {
        message(
                FacesMessage.SEVERITY_INFO, 
                "Not Implemented",  "growl: menuMatrices.xhtml lines 16, 31.  MenuBar.java lines 75, 93 "
                + " Simply not implemented!");
    }
    public boolean isMultiplationValid()
    {

        return matrixOperations.isReadyForMultiplication();
    }
    public boolean isAdditionValid()
    {
        boolean b = matrixOperations.isReadyForAddition();
        System.out.println(" isAdditionValid: " + b);
        return b;
    }
    public void message( Severity severity, String msg, String msgDetails)
    {
        FacesMessage m = new FacesMessage(severity, msg, msgDetails);
        FacesContext.getCurrentInstance().addMessage("msg", m);
    }
}
