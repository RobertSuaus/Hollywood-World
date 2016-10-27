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
        ClientMembership membership
    ){
        super(name, lastName, telephone, address);
        this.membership = membership;
    }
    
    public Client(){
        super("","","","");
    }
    
    public Client(ClientMembership membership){
        super("","","","");
        this.membership = membership;
    }
    
    public void setMembership(ClientMembership membership){
        this.membership = membership;
    }
    
    public ClientMembership getMembership(){
        return membership;
    }
    
    private ClientMembership membership;
}