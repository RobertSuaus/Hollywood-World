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
public class EmployeeDAO {
    
     public  EmployeeDAO(){
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
    
     public int add(Employee employee){
        String sql = "INSERT INTO employee(id_employee," +
                "name, lastname, telephone, address," +
                "rfc," +
                "basicSalary," +
                "admissionDate," +
                "position)" +
                "VALUES ('" + employee.getId()+"'," +
                "'" + employee.getName()+"'," +
                "'" + employee.getLastName() + "'," +
                "'" + employee.getTelephone() + "'," +
                "'" + employee.getAddress() + "'," +
                "'" + employee.getRfc()+ "'," +
                "'" + employee.getBasicSalary()+ "'," +
                "'" + employee.getAdmissionDate()+ "'," +
                "'" + employee.getPosition() +
                "')";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return StatusValidator.SUCCESS;
        }catch(SQLException ex){
             System.err.println("Error al agregar empleado" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al agregar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }
    }
    
    public int modify(Employee employee){
        String sql = "UPDATE employee SET id_employee = $id_employee$," +
                "name = $name$," +
                "lastname = $lastname$," +
                 "telephone = $telephone$," +
                "address = $address$," +
                "rfc = $rfc$," +
                "basicSalary = $basicSalary$," +
                "admissionDate = $admissionDate$," + 
                "position = $position$";
        
        sql = sql.replace("$name$", employee.getName());
        sql = sql.replace("$lastname$", employee.getLastName());
        sql = sql.replace("$telephone$", employee.getTelephone());
        sql = sql.replace("$address$", employee.getAddress());
        sql = sql.replace("$position$", employee.getPosition());
        sql = sql.replace("",String.valueOf(employee.getId()));
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
           
            
            return StatusValidator.SUCCESS;
        }catch(SQLException ex){
             System.err.println("Error al actualizar empleado" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }
       
    }
    
    public int getLastEmployeeId(){
        String sql = "SELECT * FROM  employee WHERE id_employee ="+
                " (SELECT MAX(id_employee)  FROM employee)";
        int lastId;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            lastId = resultSet.getInt("id_employee");
            return lastId;
        }catch(SQLException ex){
            System.err.println("Ultimo ID Utilizado " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ultimo ID.",
                    "ID", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }   
    }
    
    public boolean isIdEmployeeOccupied(int id){
        boolean isOccupied;
        String sql = "SELECT * FROM employee WHERE "+
                "id_employee ='" + id+"'";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isOccupied = resultSet.first();
        }catch(SQLException ex){
            System.err.println("Error ID ocupada"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error de asignación de ID.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            isOccupied = false;
        }
        return isOccupied;
        
    }
    
    public Employee employeeFind(int id){
        String sql = "SELECT * FROM employee WHERE"
                + "id_employee = $id_employee$" ;
        sql = sql.replace("$id_employee$", String.valueOf(id));
        Employee employee = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            employee = new Employee(
                resultSet.getString("name"),
                resultSet.getString("lastName"),
                resultSet.getString("telephone"),
                resultSet.getString("address"),
                resultSet.getInt("id_employee"),
                resultSet.getString("rfc"),
                resultSet.getDouble("basicSalary"),
                resultSet.getDate("admissionDate"),
                resultSet.getString("position")
                
                        );
            return employee;
        }catch(SQLException ex){
            System.err.println("Error No se encontro el emplado"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error de busqueda.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return employee;
        }
    }
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
}
