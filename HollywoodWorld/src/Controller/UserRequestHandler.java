/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.UserDAO;
import View.ModifyUserForm;

/**
 *
 * @author Robert
 */
public class UserRequestHandler {
    
    public UserRequestHandler(){
        
        user = new User();
        userDataIsValid = false;
    }
    
    public UserRequestHandler(ModifyUserForm modifyUserForm){
        
        user = new User();
        this.modifyUserForm = modifyUserForm;
        userDataIsValid = false;
    }
    
    public String processCreation(String[] userInputs){
        
        setUserInformation(userInputs);
        if(userDataIsValid){
            if(isUserNameAvailable() ){
                return UserAdministrator.createUser(user);
            }
            return OCCUPIED_USERNAME_MSG;
        }
        return INVALID_DATA_MSG;
    }
    
    public String processModification(String[] userInputs){
        
        setUserInformation(userInputs);
        if(userDataIsValid){
            return UserAdministrator.modifyUser(user);
        }
        return INVALID_DATA_MSG;
    }
    
    public String processRetrieve(String userNameInput){
        
        user.setUserName(userNameInput);
        
        if(isUserNameValid() ){
            if(!isUserNameAvailable() ){
                user = UserAdministrator.getUser(userNameInput);
                modifyUserForm.fillExistingUserForm(user);
                return "Mostrando información del usuario: "+ user.getUserName();
            }
            return USERNAME_NOT_FOUND_MSG;
        }
        return INVALID_DATA_MSG;
    }
    
    //Asigna los datos de usuario obtenidos desde el formulario de la vista
    private void setUserInformation(String[] userInput){
        
        user.setName(userInput[0]);
        user.setLastName(userInput[1]);
        user.setUserName(userInput[2]);
        user.setPassword(userInput[3]);
        user.setPermissions(userInput[4]);
        
        userDataIsValid = isUserDataValid();
    }
    
    private boolean isUserNameAvailable(){
        
        boolean isAvailable;
        if(UserDAO.registryExists(user.getUserName() ) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    //Validaciones de Sintaxis de los datos 
    private boolean isUserDataValid(){
        
        if( isNameValid() &&
            isLastNameValid() &&
            isUserNameValid() &&
            isPasswordValid() 
        ){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isNameValid(){
        
        String input = user.getName();
        if (input.matches("([A-Za-z]|\\s)*") && 
            input.equals(" ") == false &&
            input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isLastNameValid(){
        
        String input = user.getLastName();
        if (input.matches("([A-Za-z]|\\s)*") &&
            input.equals(" ") == false &&
            input.equals("") == false
            ){
                return true;
            }else{
                return false;
            }
    }
    
    private boolean isUserNameValid(){
        
        int minNameLength = 4;
        int nameLength = user.getUserName().length();
        
        if (nameLength >= minNameLength){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isPasswordValid(){
        
        int minPasswordLength = 4;
        int nameLength = user.getPassword().length();
        
        if (nameLength >= minPasswordLength){
            return true;
        }else{
            return false;
        }
    }
    
    private User user;
    private ModifyUserForm modifyUserForm;
    private Boolean userDataIsValid;
    
    private final String INVALID_DATA_MSG = "Los datos ingresados no son correctos";
    private final String OCCUPIED_USERNAME_MSG = "El nombre de usuario ya está ocupado";
    private final String USERNAME_NOT_FOUND_MSG = "El nombre de usuario no existe";
}
