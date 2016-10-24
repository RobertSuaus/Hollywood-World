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
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class UserDAO {
    
    public UserDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/hollywood_world?autoReconnect=true&useSSL=false",
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
        String sql = "SELECT * FROM user WHERE userName ='" +"'";
        User user = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            user = new User(
                resultSet.getString("name"),
                resultSet.getString("lastname"),
                resultSet.getString("userName"),
                resultSet.getString("password"),
                resultSet.getString("userPermissions")
                );
        }catch(SQLException ex){
            System.err.println("Error al obtener información de usuario " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener información de usuario.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }
    
    public boolean isUserNameOccupied(String userName){
        boolean isNameOccupied;
        String sql = "SELECT * FROM user WHERE "+
                    "userName ='" + userName + "'";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isNameOccupied = resultSet.first();
            
        }catch(SQLException ex){
            System.err.println("Error al verificar que el nombre esté ocupado " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener información de usuario.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            isNameOccupied = false;
        }
        return isNameOccupied;
    }
    
    public boolean isUserInfoCoincident(User user){
        boolean isInfoCoincident;
        String sql = "SELECT * FROM user WHERE "+
                    "userName ='" + user.getUserName() + "'" +
                    " AND password ='" + user.getPassword() + "'";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isInfoCoincident = resultSet.first();
            
        }catch(SQLException ex){
            System.err.println("Error al obtener información de usuario " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener información de usuario.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            isInfoCoincident = false;
        }
        return isInfoCoincident;
    }
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
}