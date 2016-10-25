package Controller;

import Model.Employee;

/**
 *
 * @author Robert
 */
public interface ValidateEmployeeInterface {
    
    public boolean isEmployeeIdAvailable(int employeeId);
    
    public Employee getEmployeeInfo(int employeeId);
    public int getNextEmployeeId();
    
    public void addEmployee(Employee employee);
    public void modifyEmployee(Employee employee);
}
