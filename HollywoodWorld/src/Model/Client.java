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
        Membership membership
    ){
        super(name, lastName, telephone, address);
        this.membership = membership;
    }
    
    public void setMembership(Membership membership){
        this.membership = membership;
    }
    
    public Membership getMembership(){
        return membership;
    }
    
    private Membership membership;
}