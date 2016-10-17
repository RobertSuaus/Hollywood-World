/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Robert
 */
public class UserAccount {
    /*Representa una cuenta de usuario usada por un empleado para interactuar
    con el sistema. No todos los empleados usan cuentas de usuario.*/
    
    public UserAccount(
        String userName,
        String password
        ){
            this.userName = userName;
            this.password = password;
        }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    private String userName;
    private String password;
}
