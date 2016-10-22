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
public class UserDAO {
    
    public UserDAO(){
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
    
    public User getUserInfo(String userName){
        
    }
    
    public boolean isUserNameOccupied(String userName){
        return true;
    }
    
    public boolean isUserInfoCoincident(User user){
        boolean isInfoCoincident;
        String sql = "SELECT" + "FROM User WHERE "+
                    "userName ='" + user.getUserName() + "'" +
                    " AND password ='" + user.getPassword() + "'";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isInfoCoincident = resultSet.first();
            
        }catch(Exception error){
            error.printStackTrace();
            isInfoCoincident = false;
        }
        
        return isInfoCoincident;
    }
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
}