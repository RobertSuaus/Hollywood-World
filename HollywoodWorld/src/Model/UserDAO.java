/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.User;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class UserDAO extends BaseDAO {
    
    public static int save(User user){
        String sql = "INSERT INTO user(userName, name, lastName, password, userPermissions) VALUES ("+
                "'" + user.getUserName()+"' ," +
                "'" + user.getName()+"' ," +
                "'" + user.getLastName() + "' ," +
                "'" + user.getPassword() + "' ," +
                "'" + user.getPermissions() + "');";
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar datos de usuario " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al guardar datos de usuario.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }
    }
    
    public static int update(User user){
        String sql = "UPDATE user SET " +
                "name = '" + user.getName() + "' ," +
                "lastname = '" + user.getLastName()+"' ," +
                "password = '" + user.getPassword()+"' ," +
                "userPermissions = '" + user.getPermissions()+"' " +
                "WHERE userName= '"+ user.getUserName() + "'";
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al modificar datos de usuario " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar datos de usuario.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }
    }
    
    public static User obtainRegistry(String userName){
        
        String sql = "SELECT * FROM user WHERE userName ='" + userName +"'";
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
    
    public static boolean registryExists(String userName){
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
    
    public static boolean registryExists(User user){
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
    
}