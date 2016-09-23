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
    
    public Client(
        String name,
        String lastName,
        String telephone,
        String address,
        String membershipID
    ){
        super(name, lastName, telephone, address);
        this.membershipID = membershipID;
    }
    
    public void setMembershipID(){
        
    }
    
    public String getMembershipID(){
        return membershipID;
    }
    
    private String membershipID;
}
