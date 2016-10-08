/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Robert
 */
public class Membership {
    //Representa la membresia de socio de un cliente
    
    public Membership(
        int id,
        boolean activeStatus
    ){
        this.id = id;
        this.activeStatus = activeStatus;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setAsActive(){
        this.activeStatus = true;
    }
    
    public void setAsInactive(){
        this.activeStatus = false;
    }
    
    public int getId(){
        return id;
    }
    
    public boolean isActive(){
        return activeStatus;
    }
    
    private int id;
    private boolean activeStatus;
}
