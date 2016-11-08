/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Robert
 */
public class DBConnection {
    
    public static int Connect(){
        connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String server = "jdbc:mysql://localhost/" + database+"?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(server, user, password);
            
            BaseDAO.setConnection(connection);
            return SUCCESS;
        } catch (ClassNotFoundException e){
            System.err.println("JBDC Driver not found " + e.getMessage());
            return ERROR_JBDC;
        } catch (SQLException ex){
            System.err.println("Could not connect to Database" + ex.getMessage());
            return ERROR_DB_CONNECTION;
        }
     
    }
    
    private static Connection connection = null;
    private static String database = "Hollywood_World";
    private static final int SUCCESS = 0;
    private static final int ERROR_DB_CONNECTION = -1;
    private static final int ERROR_JBDC = -2;
}
