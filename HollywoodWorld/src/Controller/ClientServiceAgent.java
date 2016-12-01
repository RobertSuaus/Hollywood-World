/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Client;
import Model.ClientDAO;
import Model.ClientMembership;
import View.ModifyClientForm;
import View.RegisterClientForm;

/**
 *
 * @author Robert
 */
public class ClientServiceAgent {
    /*Maneja y le da un sentido a las solicitudes o procedimientos relacionados
    con clientes*/
    
    public ClientServiceAgent(RegisterClientForm registerClientForm){
        
        this.registerClientForm = registerClientForm;
        this.client = new Client();
        initizalizeWindow();
    }
    
    public ClientServiceAgent(ModifyClientForm modifyClientForm){
        
        this.modifyClientForm = modifyClientForm;
        this.client = new Client();
    }
    
    /*Manejar el procedimiento de registro de cliente*/
    public String registerInformation(String[] userInputs){
        
        setClientInformation(userInputs);
        if(isClientDataValid() ){
           if(isMembershipIdAvailable(client.getMembership().getId() ) ){
               return ClientServiceManager.registerClient(client);
           } 
           return MEMBERSHIP_OCCUPIED_MSG;
        } 
        return INVALID_DATA_MSG;
    }
    
    /*Manejar el procedimiento de modificación de datos de cliente*/
    public String modifyInformation(String[] userInputs){
        
        setClientInformation(userInputs);
        if(isClientDataValid() ){
            return ClientServiceManager.modifyClient(client);
        }
        return INVALID_DATA_MSG;
    }
    
    /*Manejar el procedimiento de obtención de datos del cliente*/
    public String retrieveInformation(String membershipIdInput){
        
        if(isValidInputNumber(membershipIdInput) ){
           int membershipId = Integer.valueOf(membershipIdInput);
           if(membershipExists(membershipId)){
               
               client = ClientServiceManager.getClientInfo(membershipId);
               modifyClientForm.fillExistingClientForm(client);
               return "Mostrando datos de: "+client.getName();
           } 
           return MEMBERSHIP_NOT_FOUND_MSG;
        } 
        return INVALID_DATA_MSG;
    }
    
    /*Maneja el procedimiento de inicialización de parametros
    en la ventana de registro de clientes*/
    private void initizalizeWindow(){
        
        int nextId = generateNextMembershipId();
        registerClientForm.fillMembershipField(nextId);
    }
    
    private void setClientInformation(String[] userInputs){
        
        client.setName(userInputs[0]);
        client.setLastName(userInputs[1]);
        client.setTelephone(userInputs[2]);
        client.setAddress(userInputs[3]);
        client.setMembership(
            new ClientMembership(
                Integer.valueOf(userInputs[4]),
                userInputs[5]
            )    
        );
        
    }
    
    private boolean isMembershipIdAvailable(int membershipId){
        
        boolean isAvailable;
        if(ClientDAO.registryExists(membershipId) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    private boolean membershipExists(int membershipId){
        
        boolean exists;
        if(ClientDAO.registryExists(membershipId) ){
            exists = true;
        }else{
            exists = false;
        }
        return exists;
    }
    
    private int generateNextMembershipId(){
        
        int lastRegisteredId;
        lastRegisteredId = ClientDAO.getLastRegistryIndex();
        int nextId= lastRegisteredId + 1; //Recorrer una posición
        return nextId;
    }
    
    //Validaciones de sintaxis
    private boolean isClientDataValid(){
        
        if(
            isValidInputText( client.getName() ) &&
            isValidInputText( client.getLastName() ) &&
            isValidInputNumber( client.getTelephone() ) &&
            isValidInputAddress( client.getAddress() ) 
        ){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValidInputText(String input){
        if (input.matches("([A-Za-z]|\\s)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValidInputAddress(String input){
        if (input.matches("([A-Za-z]|\\s|[0-9]|#|-)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isValidInputNumber(String input){
        if (input.matches("([0-9]|\\s)*") 
            && input.equals(" ") == false 
            && input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private Client client;
    private RegisterClientForm registerClientForm;
    private ModifyClientForm modifyClientForm;
    private final String INVALID_DATA_MSG = "Los datos ingresados no son validos";
    private final String MEMBERSHIP_NOT_FOUND_MSG = "El número de membresía no está asignado";
    private final String MEMBERSHIP_OCCUPIED_MSG = "El número de membresía no esta disponible";
}
