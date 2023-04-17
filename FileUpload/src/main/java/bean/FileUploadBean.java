/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import database.Database;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author idont
 */
@Named(value = "fileUploadBean")
@SessionScoped
public class FileUploadBean implements Serializable 
{
    private Part uploadedFile;
    private boolean success = true;
    private String msg = "";

    /**
     * Creates a new instance of FileUploadBean
     */
    public FileUploadBean() {
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }
    
    public void uploadFile()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        
        ServletContext sc = (ServletContext) externalContext.getContext();
        //path where to upload
        String sPath = sc.getRealPath("WEB-INF");
        Path path = Paths.get(sPath);
        String s = path.toString();
        
        if (uploadedFile == null) 
        {
            success = false;
            msg = "file cannot be empty";
            return;
        }
        
        try(InputStream input = uploadedFile.getInputStream())
        {
            String fileName = uploadedFile.getSubmittedFileName();
            System.out.println(s);
            Files.copy(input, new File(s, fileName).toPath());
        }
        catch(IOException e)
        {
            success = false;
            msg = e.toString();
            System.out.println("----failed to save file " + e);
        }
    
    }
    
    public void uploadToDatabase()
    {
        uploadFile();
        
        String fileName = uploadedFile.getSubmittedFileName();
        int indexOfDot = fileName.lastIndexOf(".");
        String fileExtension = "";
        if (indexOfDot != -1) 
        {
            fileExtension = fileName.substring(indexOfDot);
            int count = Database.saveFile(fileName, fileExtension);
            msg += "...the database server returned: " + Integer.toString(count);
        }
      
    }
    
    
    
}
