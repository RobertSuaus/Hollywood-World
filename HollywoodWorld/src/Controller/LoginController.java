/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import Model.UserAccount;
import Model.UserAccountDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class LoginController implements ValidateLoginInterface {
    /*Clase encargada de la funcionalidad del sistema de login*/
    
    public LoginController(){
        userAccountDAO = new UserAccountDAO();
        userAccount = new UserAccount();
        loginUI = new LoginUI(this);
    }
    
    //Métodos para la validación de datos de cuenta de usuario
    @Override
    public void validateUserName(String inUserName){
        int minNameLength = 4;
        int inNameLength = inUserName.length();
        
        if (inNameLength >= minNameLength){
            userAccount.setUserName(inUserName);
        }
    }
    
    @Override
    public void validatePassword(String inPassword){
        int minPasswordLength = 4;
        int inPasswordLength = inPassword.length();
        
        if(inPasswordLength >= minPasswordLength){
            userAccount.setPassword(inPassword);
        }
    }
    
    @Override
    public void handleLoginAction(){
        if( userAccountDAO.isUserInfoCoincident(userAccount) ){
            Employee currentEmployee = getEmployeeInfo(userAccount);
            new MainMenuController(currentEmployee);
            
            loginUI.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Datos de usuario incorrectos");
        }
    }
    
    //Obtiene los datos de empleado, dada una cuenta de usuario
    private Employee getEmployeeInfo(UserAccount userAccount){
        return userAccountDAO.getUserAccountOwner(userAccount);
    }
    
    
    private UserAccountDAO userAccountDAO;
    private UserAccount userAccount;
    private LoginUI loginUI;
}
