/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Reynaldo Marrufo
 */
public class ClientDAO extends BaseDAO {
    
    public static int save(Client client){
        String sql = "INSERT INTO client(membership_id, name, lastname,"+
                " telephone, address, status) VALUES("+
                "$membership_id$, '$name$', '$lastname$', '$telephone$',"+ 
                " '$address$', '$status$');";
        
        sql = sql.replace("$membership_id$",
                String.valueOf(client.getMembership().getId())
                );
        sql = sql.replace("$name$", client.getName());
        sql = sql.replace("$lastname$", client.getLastName());
        sql = sql.replace("$telephone$", client.getTelephone());
        sql = sql.replace("$address$", client.getAddress());
        sql = sql.replace("$status$", client.getMembership().getStatus());
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar datos de cliente"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al guardar datos de cliente",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }
    }
    
    public static int update(Client client){
        String sql = "UPDATE client SET"+
                " name = '$name$', lastname = '$lastname$', telephone = '$telephone$',"+
                " address = '$address$', status = '$status$'"+
                " WHERE membership_id = $membership_id$ ";
        
        sql = sql.replace("$name$", client.getName());
        sql = sql.replace("$lastname$", client.getLastName());
        sql = sql.replace("$telephone$", client.getTelephone());
        sql = sql.replace("$address$", client.getAddress());
        sql = sql.replace("$status$", client.getMembership().getStatus());
        sql = sql.replace("$membership_id$", 
                String.valueOf(client.getMembership().getId())
                );
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar datos de cliente"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al guardar datos de cliente",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }
    }
    
    public static int getLastRegistryIndex(){
        
        String sql = "SELECT * FROM  client WHERE membership_id ="+
                " (SELECT MAX(membership_id)  FROM client)";
        int lastId;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            
            if(!resultSet.first()) return 0; //Si no hay registros, empezar en 0
            
            lastId = resultSet.getInt("membership_id");
            return lastId;
        }catch(SQLException ex){
            System.err.println("Error al obtener el ultimo registro " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener registro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return ERROR;
        }   
    }
    
    public static boolean registryExists(int membershipId){
        boolean isOccupied;
        String sql = "SELECT * FROM client WHERE "+
                "membership_id ='" + membershipId+"'";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isOccupied = resultSet.first();
        }catch(SQLException ex){
            System.err.println("Error Membresia ocupada"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error de asignación de memebresia.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            isOccupied = false;
        }
        return isOccupied;
        
    }
    
    public static Client getRegistry(int membershipId){
        String sql = "SELECT * FROM client WHERE"
                + " membership_id = $membershipId$";
        sql = sql.replace("$membershipId$", String.valueOf(membershipId));
        Client client = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            client = new Client(
                resultSet.getString("name"),
                resultSet.getString("lastName"),
                resultSet.getString("telephone"),
                resultSet.getString("address"),
                new ClientMembership(
                    resultSet.getInt("membership_id"),
                    resultSet.getString("status")
                    )
                );
            return client;
            
        }catch(SQLException ex){
            System.err.println("Error al obtener información de cliente"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al obtener información de cliente",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return client;
        }
    }
}
