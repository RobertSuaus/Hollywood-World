package Model;

/**
 *
 * @author Robert
 */
public class ClientMembership {
    /*Representa la membresia de socio de un cliente. Todos los clientes
    tienen una y solo una membresia.*/
    
    public ClientMembership(
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
