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
public class SessionManager {
    /*El gestor de sesión le solicita al administrador de sesiones iniciar
    sesiónes en el sistema si las credenciales son correctas*/
    
    public SessionManager(){
        
        user = new User();
        
    }
    
    public SessionManager(LoginUI loginUI){
        
        user = new User();
        this.loginUI = loginUI;
    }
    
    public void requestSesionLogin(String[] userInputs){
        
        setUserCredentials(userInputs);
        
        if(isUserDataValid() ){
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
    
    public void requestSessionLogout(){
        
        SessionAdministrator.terminateSession();
    }
    
    //Obtiene las entradas de la vista y las almacena en un objeto User
    private void setUserCredentials(String[] userInputs){
        
        user.setUserName(userInputs[0]);
        user.setPassword(userInputs[1]);
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
}
