package Controller;

import Model.Client;
import Model.ClientDAO;
import Model.StatusValidator;
import View.ClientUI;

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
        
        boolean isAvailable;
        if(clientDAO.isMembershipOccupied(membershipId)){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    @Override
    public Client getClientInfo(int membershipId){
        
        Client clientInformation = clientDAO.getClientInfo(membershipId);
        return clientInformation;
    }
    
    @Override
    public int getNextMembershipId(){
        
        int lastRegisteredId;
        lastRegisteredId = clientDAO.getLastMembershipId();
        int nextId= lastRegisteredId + 1; //Recorrer una posición
        return nextId;
    }
    
    @Override
    public String addClient(Client client){
        if(StatusValidator.success(clientDAO.add(client))){
            return "New client succesfully registered!";
        }else{
            return "Couldn't register the client...";
        }
    }
    
    @Override
    public String modifyClient(Client client){
        if(StatusValidator.success(clientDAO.modify(client))){
            return "Client succesfully updated!";
        }else{
            return "Couldn't update the client";
        }
    }
    
    private ClientDAO clientDAO;
    private ClientUI clientUI;
}
