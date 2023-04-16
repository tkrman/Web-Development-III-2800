/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author idont
 */
@Named(value = "templatesBean")
@SessionScoped
public class TemplatesBean implements Serializable
{
    private String msgTopDefault = "";
    private String msgBottomDefault = "";
    private String msgCenterDefault = "No center content ... press the below button!";

    public String getMsgTopDefault(){return msgTopDefault;}
    public void setMsgTopDefault(String msgTopDefault){this.msgTopDefault = msgTopDefault;}
    public String getMsgBottomDefault(){return msgBottomDefault;}
    public void setMsgBottomDefault(String msgBottomDefault){this.msgBottomDefault = msgBottomDefault;}
    public String getMsgCenterDefault(){return msgCenterDefault;}
    public void setMsgCenterDefault(String msgCenterDefault){this.msgCenterDefault = msgCenterDefault;}   
    
    public void topAction(String msg){this.msgTopDefault = msg;}
    public void bottomAction(String msg){this.msgBottomDefault = msg;
        System.out.println( this.msgBottomDefault );}
    
    public void centerAction(){this.msgCenterDefault = "This is default content";}
    
}
