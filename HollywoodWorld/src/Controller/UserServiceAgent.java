/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.UserDAO;
import View.ModifyUserForm;
import View.RegisterUserForm;

/**
 *
 * @author Robert
 */
public class UserServiceAgent {
    /*Da atención con cuestiones relacionadas al control de usuarios. Verificar
    que el nombre de usuario esté disponible, verifica los datos, etc.*/
    
    public UserServiceAgent(RegisterUserForm registerUserForm){
        
        this.registerUserForm = registerUserForm;
    }
    
    public UserServiceAgent(ModifyUserForm modifyUserForm){
        
        this.modifyUserForm = modifyUserForm;
    }
    /*Manejar el procedimiento de creación de usuario*/
    public String requestUserCreation(String[] userInputs){
        
        User user = setUserInformation(userInputs);
        if(isUserDataValid(user) ){
            if(isUserNameAvailable(user.getName() ) ){
                registerUserForm.clearFields();
                return UserServiceManager.createUser(user);
            }
            return "El nombre de usuario está ocupado";
        }
        return "Los datos son invalidos";
    }
    
    /*Manejar el procedimiento de modificacion de usuario*/
    public String requestUserModification(String[] userInputs){
        
        User user = setUserInformation(userInputs);
        if(isUserDataValid(user) ){
            modifyUserForm.clearFields();
            return UserServiceManager.modifyUser(user);
        }
        return "Los datos son invalidos";
    }
    
    /*Manejar el procedimiento de obtención de datos de usuario*/
    public String requestUserInformation(String userNameInput){
        
        if(isUserNameValid(userNameInput) ){
            if(userNameRegistered(userNameInput) ){
                User user = UserServiceManager.retrieveUserInfo(userNameInput);
                modifyUserForm.fillExistingUserForm(user);
                return "Mostrando información del usuario: "+ user.getUserName();
            }
            return "El usuario no está registrado";
        }
        return "Los datos no son validos";
    }
    
    //Asigna los datos de usuario obtenidos desde el formulario de la vista
    private User setUserInformation(String[] userInput){
        
        User user = new User();
        user.setName(userInput[0]);
        user.setLastName(userInput[1]);
        user.setUserName(userInput[2]);
        user.setPassword(userInput[3]);
        user.setPermissions(userInput[4]);
        
        return user;
    }
    
    private boolean isUserNameAvailable(String userName){
        
        boolean isAvailable;
        if(UserDAO.registryExists(userName ) ){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    private boolean userNameRegistered(String userName){
        
        boolean exists;
        if(UserDAO.registryExists(userName) ){
            exists = true;
        }else{
            exists = false;
        }
        return exists;
    }
    
    //Validaciones de Sintaxis de los datos 
    private boolean isUserDataValid(User user){
        
        if( isNameValid(user.getName() ) &&
            isLastNameValid(user.getLastName() ) &&
            isUserNameValid(user.getUserName() ) &&
            isPasswordValid(user.getPassword() ) 
        ){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isNameValid(String input){
        
        if (input.matches("([A-Za-z]|\\s)*") && 
            input.equals(" ") == false &&
            input.equals("") == false){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isLastNameValid(String input){
        
        if (input.matches("([A-Za-z]|\\s)*") &&
            input.equals(" ") == false &&
            input.equals("") == false
            ){
                return true;
            }else{
                return false;
            }
    }
    
    private boolean isUserNameValid(String input){
        
        int minNameLength = 4;
        int nameLength = input.length();
        
        if (nameLength >= minNameLength){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean isPasswordValid(String input){
        
        int minPasswordLength = 4;
        int passwordLength = input.length();
        
        if (passwordLength >= minPasswordLength){
            return true;
        }else{
            return false;
        }
    }
    
    private RegisterUserForm registerUserForm;
    private ModifyUserForm modifyUserForm;
}
