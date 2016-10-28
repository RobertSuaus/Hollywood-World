package Controller;

import Model.Employee;
import Model.EmployeeDAO;
import Model.StatusValidator;
import View.EmployeeUI;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert
 */
public class EmployeeController implements ValidateEmployeeInterface {
    
    public EmployeeController(){
        this.employeeDAO = new EmployeeDAO();
        this.employeeUI = new EmployeeUI(this);
    }
    
    @Override
    public boolean isEmployeeIdAvailable(int employeeId){
        
        boolean isAvailable;
        if(employeeDAO.isEmployeeIdOccupied(employeeId) ){
            return false;
        }else{
            return true;
        }
    }
    
    @Override
    public Employee getEmployeeInfo(int employeeId){
        
        Employee employeeInfo = null;
        try {
            employeeInfo = employeeDAO.getEmployeeInformation(employeeId);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Date conversion error");
        }
        return employeeInfo;
    }
    
    @Override
    public int getNextEmployeeId(){
        
        int lastRegisteredId = employeeDAO.getLastRegisteredId();
        int nextId = lastRegisteredId + 1;
        
        return nextId;
    }
    
    @Override
    public String addEmployee(Employee employee){
        
        if(StatusValidator.success(employeeDAO.add(employee) ) ){
            return "Employee succesfully registered";
        }else{
            return "Couldn't register employee...";
        }
    }
    
    @Override
    public String modifyEmployee(Employee employee){
        
        if(StatusValidator.success(employeeDAO.modify(employee) ) ){
            return "Employee information updated!";
        }else{
            return "Couldn't update employee information...";
        }
    }
    
    private EmployeeDAO employeeDAO;
    private EmployeeUI employeeUI;
}
