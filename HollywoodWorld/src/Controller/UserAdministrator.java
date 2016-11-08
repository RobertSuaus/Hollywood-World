/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StatusValidator;
import Model.User;
import Model.UserDAO;

/**
 *
 * @author Robert
 */
public class UserAdministrator{
    
    public static User getUser(String userName){
        
        User user= UserDAO.obtainRegistry(userName);
        return user;
    }
    
    public static String createUser(User user){
        
        if(StatusValidator.success(UserDAO.save(user) ) ){
            return "Usuario agregado exitosamente!";
        }else{
            return "Error! No se pudo agregar el usuario a la BD.";
        }
        
    }
    
    public static String modifyUser(User user){
        
        if(StatusValidator.success(UserDAO.update(user))){
            return "User information succesfully updated.";
        }else{
            return "Couldn't update user information...";
        }
        
    }
    
    
}
