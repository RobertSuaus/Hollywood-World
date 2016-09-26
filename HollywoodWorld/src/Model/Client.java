/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 */
package Model;

public class Client extends Person {
    //Representa un cliente socio registrado en el sistema
    
    public Client(
        String name,
        String lastName,
        String telephone,
        String address,
        boolean isActive,
        int membershipId
    ){
        super(name, lastName, telephone, address);
        this.isActive = isActive;
        this.membershipId = membershipId;
    }
    
    //Dar de alta al cliente
    public void setAsActive(){
        this.isActive = true;
    }
    
    //Dar de baja al cliente
    public void setAsInactive(){
        this.isActive = false;
    }
    
    public void setMembershipId(int membershipId){
        this.membershipId = membershipId;
    }
    
    //Retorna el estado de alta
    public boolean isActive(){
        return isActive;
    }
    
    public int getMembershipId(){
        return membershipId;
    }
    
    
    private boolean isActive; //Estado de alta o baja
    private int membershipId; //Número de socio: 1 a 99999
}