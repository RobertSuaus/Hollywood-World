/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Robert
 */
public class UserAccountDAO {
    
    public UserAccountDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/Hollywood_World",
                "root",
                ""
            );
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    public void add(){
        
    }
    
    public void modify(){
        
    }
    
    public void delete(){
        
    }
    
    public boolean isUserNameOccupied(){
        return true;
    }
    
    public boolean isUserInfoCoincident(UserAccount inUserAccount){
        boolean isInfoValid = false;
        String sql = "SELECT * FROM CuentasUsuario WHERE "+
                    "nombreCuenta ='" + inUserAccount.getUserName() + "'" +
                    " AND contrasenia='" + inUserAccount.getPassword() + "'";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isInfoValid = resultSet.first();
            
        }catch(Exception error){
            error.printStackTrace();
        }
        
        return isInfoValid;
    }
    
    public Employee getUserAccountOwner(UserAccount inUserAccount){
        String sql = "";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            
        }catch(Exception error){
            error.printStackTrace();
        }
        //Crear empleado y llenarlo con el conjunto que se generó
    }
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
}