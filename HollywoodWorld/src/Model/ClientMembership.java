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
        String status
    ){
        this.id = id;
        this.status = status;
    }
    
    public ClientMembership(int id){
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public int getId(){
        return id;
    }
    
    public String getStatus(){
        return status;
    }
    
    private int id;
    private String status;
}
