package Controller;

import Model.Client;

/**
 *
 * @author Robert
 */
public class ClientController implements ValidateClientInterface {
    /*Clase encargada del control de la información relacionada
    a los clientes: Agregar nuevos clientes, modificarlos y listarlos*/
    
    public ClientController(){
        clientDAO = new ClientDAO();
        clientUI = new ClientUI(this);
    }
    
    //Verifica que no este ocupado el numero de membresía
    @Override
    public boolean isMembershipIdAvailable(int membershipId){
        
    }
    
    //Obtiene todos los datos de un cliente
    @Override
    public Client getClientInfo(int membershipId){
        
    }
    
    @Override
    public int getNextMembershipId(){
        
    }
    
    @Override
    public void addClient(Client client){
        
    }
    
    @Override
    public void modifyClient(Client client){
        
    }
    
    private ClientDAO clientDAO;
    private ClientUI clientUI;
}
