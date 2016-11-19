/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.User;
import View.*;

/**
 *
 * @author Robert
 */
public class MainMenuAdministrator {
    
    public static void accessUserRegistrationWindow(){
        new RegisterUserForm();
    }
    
    public static void accessUserModificationWindow(){
        new ModifyUserForm();
    }
    
    public static void accessClientRegistrationWindow(){
        new RegisterClientForm();
    }
    
    public static void accessClientModificationWindow(){
        new ModifyClientForm();
    }
    
    public static void accessEmployeeRegistrationWindow(){
        
    }
    
    public static void accessEmployeeModificationWindow(){
        
    }
    
    public static void accessMovieInventoryWindow(){
        
    }
    
    public static void accessNewProfileWindow(){
        
    }
    
    public static void accessProfileModificationWindow(){
        
    }
    
    public static void accessNewRentWindow(User user){
        new RentalOrderForm(user);
    }
    
    public static void accessReturnsWindow(){
        new ReturnsUI();
    }
}
