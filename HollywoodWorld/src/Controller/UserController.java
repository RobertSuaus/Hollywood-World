/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.UserDAO;

/**
 *
 * @author Robert
 */
public class UserController implements ValidateUserInterface {
    
    public UserController(){
        this.userDAO = new UserDAO();
        this.userUI = new UserUI(this);
    }
    
    @Override
    public boolean isUserNameAvailable(String userName){
        
    }
    
    @Override
    public User getUserInfo(String userName){
        
    }
    
    @Override
    public void addUser(User user){
        
    }
    
    @Override
    public void modifyUser(User user){
        
    }
    
    private UserDAO userDAO;
    private UserUI userUI;
}
