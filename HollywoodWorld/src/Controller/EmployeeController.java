package Controller;

import Model.Employee;
import Model.EmployeeDAO;
import Model.StatusValidator;
import View.EmployeeUI;

/**
 *
 * @author Robert
 */
public class EmployeeController implements ValidateEmployeeInterface {
    
    public EmployeeController(){
        employeeDAO = new EmployeeDAO();
        employeeUI = new EmployeeUI();
    }
    
    @Override
    public boolean isEmployeeIdAvailable(int employeeId){
        boolean isAvailable;
        if(employeeDAO.isIdEmployeeOccupied(employeeId)){
            isAvailable = false;
        }else{
            isAvailable = true;
        }
        
        return isAvailable;
    }
    
    @Override
    public Employee getEmployeeInfo(int employeeId){
        
        Employee employeeInformation = employeeDAO.employeeFind(employeeId);
        return employeeInformation;
        
    }
    
    @Override
    public int getNextEmployeeId(){
        int lastRegisteredId;
        lastRegisteredId = employeeDAO.getLastEmployeeId();
        int nextId = lastRegisteredId + 1; //Recorrer una posición
        return nextId;
        
    }
    
    @Override
    public String addEmployee(Employee employee){
        if(StatusValidator.success(employeeDAO.add(employee))){
            return "New employee sucessfully registered!";
        }else{
            return "Couldn't register the client...";
        }
    }
    
    @Override
    public String modifyEmployee(Employee employee){
        if(StatusValidator.success(employeeDAO.modify(employee))){
            return "Employee sucessfully update!";
        }else{
            return "Couldn't update the employee";
        }
        
    }
    
    private EmployeeDAO employeeDAO;
    private EmployeeUI employeeUI;
}
