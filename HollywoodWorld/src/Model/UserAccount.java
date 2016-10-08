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
    con el sistema. No todos los empleados son usuarios.*/
    
    public UserAccount(
        int employeeId,
        String userName,
        String password
        ){
            this.employeeId = employeeId;
            this.userName = userName;
            this.password = password;
        }
    
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public int getEmployeeId(){
        return employeeId;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    private int employeeId;
    private String userName;
    private String password;
}
