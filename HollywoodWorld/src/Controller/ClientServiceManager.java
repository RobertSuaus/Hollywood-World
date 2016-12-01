package Controller;

import Model.Client;
import Model.ClientDAO;
import Model.StatusValidator;

/**
 *
 * @author Robert
 */
public class ClientServiceManager {
    /*Clase encargada del control de la información relacionada
    a los clientes: Agregar nuevos clientes, modificarlos y listarlos*/
    
    public static Client getClientInfo(int membershipId){
        
        Client clientInformation = ClientDAO.getRegistry(membershipId);
        return clientInformation;
    }
    
    public static String registerClient(Client client){
        
        if(StatusValidator.success(ClientDAO.save(client) ) ){
                return "New client succesfully registered!";
            }else{
                return "Couldn't register the client...";
            }
        
    }
    
    public static String modifyClient(Client client){
        
        if(StatusValidator.success(ClientDAO.update(client) ) ){
            return "Client succesfully updated!";
        }else{
            return "Couldn't update the client";
        }
    }
    
    
    
}
