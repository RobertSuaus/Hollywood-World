/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.UserDAO;
import View.LoginUI;

/**
 *
 * @author Robert
 */
public class SessionRequestHandler {
    /*Clase que maneja y le da un sentido a las solicitudes de inicio de
    sesión y terminación de sesión (login/logout)*/
    
    public SessionRequestHandler(){
        
        user = new User();
        
        userCredentialsAreValid = false;
    }
    
    public SessionRequestHandler(LoginUI loginUI){
        
        user = new User();
        this.loginUI = loginUI;
        userCredentialsAreValid = false;
    }
    
    public void handleLogin(String[] userInputs){
        
        setUserCredentials(userInputs);
        
        if(userCredentialsAreValid){
            if(authenticateUser(user) ){
                SessionAdministrator.initiateSession(user);
                loginUI.dispose();
            }else{
                loginUI.displayAuthenticationError();
            }
        }else{
            loginUI.displayInvalidDataError();
        }
        
    }
    
    public void handleLogout(){
        
        SessionAdministrator.terminateSession();
    }
    
    //Obtiene las entradas de la vista y las almacena en un objeto User
    private void setUserCredentials(String[] userInputs){
        
        user.setUserName(userInputs[0]);
        user.setPassword(userInputs[1]);
        userCredentialsAreValid = isUserDataValid();
    }
    
    private boolean authenticateUser(User user){
        /*Verificar que en la base de datos se encuentre
        el usuario con la contraseña correspondiente*/
        
        boolean isInfoValid = UserDAO.registryExists(user);
        
        return isInfoValid;
    }
    
    //Validaciones de sintaxis de las entradas obtenidas de la vista
    private boolean isUserDataValid(){
        if(isUserNameValid() && isPasswordValid() ){
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
        int passwordLength = user.getPassword().length();
        
        if(passwordLength >= minPasswordLength){
            return true;
        }else{
            return false;
        }
    }
    
    private User user;
    private LoginUI loginUI;
    private Boolean userCredentialsAreValid;
}
