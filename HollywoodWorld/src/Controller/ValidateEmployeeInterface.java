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
    
    public String addEmployee(Employee employee);
    public String modifyEmployee(Employee employee);
}
