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
        String status,
        int membershipId
    ){
        super(name, lastName, telephone, address);
        this.status = status;
        this.membershipId = membershipId;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setMembershipId(int membershipId){
        this.membershipId = membershipId;
    }
    
    public String getStatus(){
        return status;
    }
    
    public int getMembershipId(){
        return membershipId;
    }
    
    private String status; //Alta, Baja,
    private int membershipId; //Número de socio: 1 a 99999
}
