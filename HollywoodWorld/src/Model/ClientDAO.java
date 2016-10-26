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
 * @author Reynaldo Marrufo
 */
public class ClientDAO {
    
    public  ClientDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/hollywood_prueba?autoReconnect=true&useSSL=false",
                "root",
                ""
            );
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    public void add(Client client){
        String sql = "INSERT INTO client(id_client,"
                + "name, lastname, telephone, address,"
                + "activestatus)"
                + "VALUES ('" + client.getMembership()+"'"
                + "'" + client.getName()+"'"
                + "'" + client.getLastName() + "'"
                + "'" + client.getTelephone() + "'"
                + "'" + client.getAddress() + "'"
                + "TRUE)";
    }
    
    public void modify(Client client){
        String sql = "UPDATE client SET id_client = $id_client$" + client.getMembership()
                + "name = $name$" + client.getName()
                + "lastname = $lastname$" + client.getLastName()
                + "telephone = $telephone$" + client.getTelephone()
                + "address = $address$" + client.getAddress();
        
        sql = sql.replace("$name$", client.getName());
        sql = sql.replace("$lastname$", client.getLastName());
        sql = sql.replace("$telephone$", client.getTelephone());
        sql = sql.replace("$name$", client.getAddress());
        
    }
    
    public String getLastMembershipId(String membership){
        String sql = "SELECT * FROM client WHERE "+
                "id_client ='" + membership+"'";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch(SQLException ex){
            System.err.println("Membresia Utilizada, reintente otra vez " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error de membresia.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
     return sql;   
    }
    
    public boolean isMembershipOccupied(String membership){
        boolean isOccupied;
        String sql = "SELECT * FROM client WHERE "+
                "id_client ='" + membership+"'";
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
    
    public String clientFind(String membership){
        String sql = "SELECT * FROM client WHERE"
                + "id_client = $id_client$"
                + "AND status = $activestatus$";
        sql = sql.replace("activestatus", membership);
        return sql;
    }
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
}
