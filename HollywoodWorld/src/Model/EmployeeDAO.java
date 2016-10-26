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
    
     public void add(Employee employee){
        String sql = "INSERT INTO employee(id_employee,"
                + "name, lastname, telephone, address,"
                + "rfc"
                + "basicSalary"
                + "admissionDate"
                + "position)"
                + "VALUES ('" + employee.getId()+"'"
                + "'" + employee.getName()+"'"
                + "'" + employee.getLastName() + "'"
                + "'" + employee.getTelephone() + "'"
                + "'" + employee.getAddress() + "'"
                + "'" + employee.getRfc()+ "'"
                + "'" + employee.getBasicSalary()+ "'"
                + "'" + employee.getAdmissionDate()+ "'"
                + "'" + employee.getPosition()
                + "')";
    }
    
    public void modify(Employee employee){
        String sql = "UPDATE employee SET id_client = $id_employee$" + employee.getId()
                + "name = $name$" + employee.getName()
                + "lastname = $lastname$" + employee.getLastName()
                + "telephone = $telephone$" + employee.getTelephone()
                + "address = $address$" + employee.getAddress()
                + "rfc = $rfc$" + employee.getRfc()
                + "basicSalary = $basicSalary$" + employee.getBasicSalary()
                + "admissionDate = $admissionDate$" + employee.getAdmissionDate()
                + "position = $position$" + employee.getPosition();
        
        sql = sql.replace("$name$", employee.getName());
        sql = sql.replace("$lastname$", employee.getLastName());
        sql = sql.replace("$telephone$", employee.getTelephone());
        sql = sql.replace("$address$", employee.getAddress());
        
    }
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
}
