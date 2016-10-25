package Controller;

import Model.Employee;

/**
 *
 * @author Robert
 */
public class EmployeeController implements ValidateEmployeeInterface {
    
    public EmployeeController(){
        this.employeeDAO = new EmployeeDAO();
        this.employeeUI = new EmployeeUI();
    }
    
    @Override
    public boolean isEmployeeIdAvailable(int employeeId){
        
    }
    
    @Override
    public Employee getEmployeeInfo(int employeeId){
        
    }
    
    @Override
    public int getNextEmployeeId(){
        
    }
    
    @Override
    public void addEmployee(Employee employee){
        
    }
    
    @Override
    public void modifyEmployee(Employee employee){
        
    }
    
    private EmployeeDAO employeeDAO;
    private EmployeeUI employeeUI;
}
