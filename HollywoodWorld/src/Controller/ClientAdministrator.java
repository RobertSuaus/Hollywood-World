package Controller;

import Model.Client;
import Model.ClientDAO;
import Model.StatusValidator;

/**
 *
 * @author Robert
 */
public class ClientAdministrator {
    /*Clase encargada del control de la información relacionada
    a los clientes: Agregar nuevos clientes, modificarlos y listarlos*/
    
    public static Client getClientInfo(int membershipId){
        
        Client clientInformation = ClientDAO.getRegistry(membershipId);
        return clientInformation;
    }
    
    public static int generateNextMembershipId(){
        
        int lastRegisteredId;
        lastRegisteredId = ClientDAO.getLastRegistryIndex();
        int nextId= lastRegisteredId + 1; //Recorrer una posición
        return nextId;
    }
    
    public static String addClient(Client client){
        
        if(isMembershipIdAvailable(client.getMembership().getId() ) ){
            
            if(StatusValidator.success(ClientDAO.save(client) ) ){
                return "New client succesfully registered!";
            }else{
                return "Couldn't register the client...";
            }
        }else{
            return "Membership number not available";
        }
        
    }
    
    public static String modifyClient(Client client){
        if(StatusValidator.success(ClientDAO.update(client) ) ){
            return "Client succesfully updated!";
        }else{
            return "Couldn't update the client";
        }
    }
    
    private static boolean isMembershipIdAvailable(int membershipId){
        
        boolean isAvailable;
        if(ClientDAO.registryExists(membershipId) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
}
