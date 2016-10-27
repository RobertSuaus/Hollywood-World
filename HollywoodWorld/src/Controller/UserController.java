/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.StatusValidator;
import Model.User;
import Model.UserDAO;
import View.UserUI;

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
        
        boolean isAvailable;
        if(userDAO.isUserNameOccupied(userName)){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        return isAvailable;
    }
    
    @Override
    public User getUserInfo(String userName){
        
        User userInformation= new User();
        userInformation = userDAO.getUserInfo(userName);
        return userInformation;
    }
    
    @Override
    public String addUser(User user){
        if(StatusValidator.success(userDAO.add(user))){
            return "User succesfully added to database.";
        }else{
            return "Couldn't add user...";
        }
    }
    
    @Override
    public String modifyUser(User user){
        if(StatusValidator.success(userDAO.modify(user))){
            return "User information succesfully updated.";
        }else{
            return "Couldn't update user information...";
        }
    }
    
    private UserDAO userDAO;
    private UserUI userUI;
}
