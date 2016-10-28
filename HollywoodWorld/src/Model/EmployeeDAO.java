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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                "jdbc:mysql://localhost/hollywood_world?autoReconnect=true&useSSL=false",
                "root",
                ""
            );
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    public int add(Employee employee){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String sql = "INSERT INTO employee(employee_id, name, lastname,"+
                " telephone, address, rfc, basicSalary, admissionDate,"+
                " position) VALUES( $employee_id$, '$name$', '$lastname$',"+
                " '$telephone$', '$address$', '$rfc$', $basicSalary$,"+
                " '$admissionDate$', '$position$' );";
        sql = sql.replace("$employee_id$", String.valueOf(employee.getId() ) );
        sql = sql.replace("$name$", employee.getName() );
        sql = sql.replace("$lastname$", employee.getLastName() );
        sql = sql.replace("$telephone$", employee.getTelephone() );
        sql = sql.replace("$address$", employee.getAddress() );
        sql = sql.replace("$rfc$", employee.getRfc() );
        sql = sql.replace("$basicSalary$", 
                String.valueOf(employee.getBasicSalary()) 
                );
        sql = sql.replace("$admissionDate$", dateFormat.
                format(employee.getAdmissionDate() ) 
                );
        sql = sql.replace("$position$", employee.getPosition() );
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return StatusValidator.SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar datos de empleado"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al guardar empleado",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }
    }
    
    public int modify(Employee employee){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "UPDATE employee SET " +
                "name = '$name$'," +
                "lastname = '$lastname$'," +
                "telephone = '$telephone$'," +
                "address = '$address$'," +
                "rfc = '$rfc$'," +
                "basicSalary = $basicSalary$," + 
                "admissionDate = '$admissionDate$'," + 
                "position = '$position$' WHERE employee_id = $employee_id$";
        
        sql = sql.replace("$name$", employee.getName() );
        sql = sql.replace("$lastname$", employee.getLastName() );
        sql = sql.replace("$telephone$", employee.getTelephone() );
        sql = sql.replace("$address$", employee.getAddress() );
        sql = sql.replace("$rfc$", employee.getRfc() );
        sql = sql.replace("$basicSalary$",
                String.valueOf(employee.getBasicSalary() )
                );
        sql = sql.replace("$admissionDate$", employee.getAddress() );
        sql = sql.replace("$admissionDate$", dateFormat.
                format(employee.getAdmissionDate() ) 
                );
        sql = sql.replace("$position$", employee.getPosition() );
        sql = sql.replace("$employee_id$", String.valueOf(employee.getId()) );
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return StatusValidator.SUCCESS;
        }catch(SQLException ex){
            System.err.println("Error al guardar datos de empleado"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error al guardar empleado",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }
    }
    
    public Employee getEmployeeInformation(int employeeId) throws ParseException{
        
        String sql = "SELECT * FROM employee WHERE"
                + " employee_id = $employeeId$";
        sql = sql.replace("$employeeId$", String.valueOf(employeeId) );
        Employee employee = null;
        
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date admissionDate = new Date();
            employee = new Employee(
                resultSet.getString("name"),
                resultSet.getString("lastname"),
                resultSet.getString("telephone"),
                resultSet.getString("address"),
                resultSet.getInt("employee_id"),
                resultSet.getString("rfc"),
                resultSet.getDouble("basicSalary"),
                admissionDate = dateFormat.
                    parse(resultSet.getString("admissionDate") ),
                resultSet.getString("position")
                );
            return employee;
            
        }catch(SQLException ex){
            System.err.println("Error al obtener el ultimo registro " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener registro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return employee;
        }
    }
    
    public int getLastRegisteredId(){
        
        String sql = "SELECT * FROM  employee WHERE employee_id ="+
                " (SELECT MAX(employee_id) FROM employee)";
        int lastId;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if(!resultSet.first()) return 0; //Si no hay registros, empezar en 0
            lastId = resultSet.getInt("employee_id");
            return lastId;
        }catch(SQLException ex){
            System.err.println("Error al obtener el ultimo registro " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener registro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return StatusValidator.ERROR;
        }   
    }
    
    public boolean isEmployeeIdOccupied(int employeeId){
        boolean isOccupied;
        String sql = "SELECT * FROM employee WHERE "+
                "employee_id ='" + employeeId + "'";
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            isOccupied = resultSet.first();
        }catch(SQLException ex){
            System.err.println("Error al verificar disponibilidad"+ ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error de asignación de id de empleado.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            isOccupied = false;
        }
        return isOccupied;
    }
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
}
