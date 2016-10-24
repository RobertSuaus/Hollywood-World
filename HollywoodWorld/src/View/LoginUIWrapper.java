/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author che_i
 */
public class LoginUIWrapper extends LoginUI {
    
    public LoginUIWrapper(){
        super();
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        if(controller.authenticateUser()){
            controller.initiateSession();
        }
    }
    
    private void userNameTxtCaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        // TODO add your handling code here:
        i_userName= userNameTxt.text();
        if (controller.isUserNameValid(i_userName)){
            controller.assignUserName(i_userName);
        }
    }  
    
}
